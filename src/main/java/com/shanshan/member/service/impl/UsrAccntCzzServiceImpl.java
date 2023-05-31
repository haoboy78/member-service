package com.shanshan.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shanshan.member.entity.UsrAccntCzz;
import com.shanshan.member.mapper.UsrAccntCzzMapper;
import com.shanshan.member.service.IUsrAccntCzzService;
import com.shanshan.member.service.feign.SalesClientFeign;
import com.shanshan.sales.service.SalesUserService;
import com.shanshan.tools.exception.GlobalException;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
@Slf4j
public class UsrAccntCzzServiceImpl extends ServiceImpl<UsrAccntCzzMapper, UsrAccntCzz> implements IUsrAccntCzzService {

    @Resource
    private SalesClientFeign salesClientFeign;

    @DubboReference(version = "1.0.0")
    private SalesUserService salesUserService;

    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public void accntReduceCzz(String cid) {
        log.info("开启全局事务 {}", RootContext.getXID());
        Integer userId = 5090151;

        salesClientFeign.reduceBalance(userId);

        UsrAccntCzz usrAccntCzz = this.getOne(new LambdaQueryWrapper<UsrAccntCzz>().eq(UsrAccntCzz::getCid, cid));
        usrAccntCzz.setBalance(usrAccntCzz.getBalance().subtract(BigDecimal.valueOf(10)));
        this.updateById(usrAccntCzz);

        throw new GlobalException("全局事务异常");
    }

    @Override
    public String findInfoByDubbo() {
        return salesUserService.getSalesUser();
    }

    @Override
    public UsrAccntCzz findMallUserGrowthByCid(String cid) {
        return this.getOne(new LambdaQueryWrapper<UsrAccntCzz>().eq(UsrAccntCzz::getCid, cid));
    }

}
