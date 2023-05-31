package com.shanshan.member.controller;

import com.shanshan.member.dto.MallUserGrowthDTO;
import com.shanshan.member.entity.UsrAccntCzz;
import com.shanshan.member.service.IUsrAccntCzzService;
import com.shanshan.tools.response.ApiResponse;
import com.shanshan.tools.response.ResponseUtil;
import io.github.linpeilie.Converter;
import org.redisson.api.RLongAdder;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: tengzhihao
 * @Date: 2023/3/13 18:27
 * @Version: 1.0
 */
@RestController
public class MemberController {

    @Autowired
    private IUsrAccntCzzService usrAccntCzzService;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private Converter converter;

    @PostMapping("/reduce")
    public ApiResponse reduce() {
        RLongAdder count = redissonClient.getLongAdder("ssmall:admin");
        System.out.println(count.sum());

        count.increment();

        RLongAdder next = redissonClient.getLongAdder("ssmall:admin");
        System.out.println(next.sum());

        return ResponseUtil.ok();
    }

    @GetMapping("/testdubbo")
    public ApiResponse testdubbo() {
        String message = usrAccntCzzService.findInfoByDubbo();
        return ResponseUtil.ok(message);
    }

    @GetMapping("/findMallUserGrowthByCid")
    public ApiResponse findMallUserGrowthByCid(String cid) {
        UsrAccntCzz usrAccntCzz = usrAccntCzzService.findMallUserGrowthByCid(cid);
        MallUserGrowthDTO mallUserGrowthDTO = converter.convert(usrAccntCzz, MallUserGrowthDTO.class);
        return ResponseUtil.ok(mallUserGrowthDTO);
    }

}
