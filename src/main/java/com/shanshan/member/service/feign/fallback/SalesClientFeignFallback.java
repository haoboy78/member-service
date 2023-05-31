package com.shanshan.member.service.feign.fallback;

import com.shanshan.member.service.feign.SalesClientFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: tengzhihao
 * @Date: 2023/3/13 18:24
 * @Version: 1.0
 */
@Component
@Slf4j
public class SalesClientFeignFallback implements SalesClientFeign {

    @Override
    public void reduceBalance(Integer userId) {
        log.error("reduceBalance error");
    }

}
