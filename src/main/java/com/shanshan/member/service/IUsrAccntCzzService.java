package com.shanshan.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shanshan.member.entity.UsrAccntCzz;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhangxun
 * @since 2022-09-16
 */
public interface IUsrAccntCzzService extends IService<UsrAccntCzz> {

    void accntReduceCzz(String cid);

    String findInfoByDubbo();

    UsrAccntCzz findMallUserGrowthByCid(String cid);

}
