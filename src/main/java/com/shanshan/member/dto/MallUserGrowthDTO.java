package com.shanshan.member.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author: tengzhihao
 * @Date: 2023/4/27 08:46
 * @Version: 1.0
 */
@Data
public class MallUserGrowthDTO {

    /**
     * 顾客ID
     */
    private String cid;

    /**
     * 本年成长值
     */
    private BigDecimal balance;

    /**
     * 本年成长值等级
     */
    private String gradeYear;

}
