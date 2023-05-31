package com.shanshan.member.controller;

import com.shanshan.tools.response.ApiResponse;
import com.shanshan.tools.response.ResponseUtil;
import org.dromara.sms4j.core.factory.SmsFactory;
import org.dromara.sms4j.provider.enumerate.SupplierType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: tengzhihao
 * @Date: 2023/4/18 09:32
 * @Version: 1.0
 */
@RestController
public class SmsController {

    @GetMapping("/sms/sender")
    public ApiResponse smsSender() {
        SmsFactory.createSmsBlend(SupplierType.HUAWEI).sendMessage("18758810708", "1299");
        return ResponseUtil.ok();
    }

}
