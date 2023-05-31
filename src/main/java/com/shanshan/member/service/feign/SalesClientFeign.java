package com.shanshan.member.service.feign;

import com.shanshan.member.service.feign.fallback.SalesClientFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Description:
 * @Author: tengzhihao
 * @Date: 2023/3/13 18:22
 * @Version: 1.0
 */
@FeignClient(value = "sales-service/sales/api", fallback = SalesClientFeignFallback.class)
public interface SalesClientFeign {

    @PostMapping("/balance/reduce/{userId}")
    void reduceBalance(@PathVariable("userId") Integer userId);

}
