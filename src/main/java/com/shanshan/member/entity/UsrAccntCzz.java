package com.shanshan.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.shanshan.member.dto.MallUserGrowthDTO;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author zhangxun
 * @since 2022-09-19
 */
@Getter
@Setter
@TableName("usr_accnt_czz")
@AutoMapper(target = MallUserGrowthDTO.class)
public class UsrAccntCzz implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 顾客ID
     */
    private String cid;

    /**
     * 年份
     */
    private Integer year;

    /**
     * 本年成长值是第几年
     */
    private Integer yearOrder;

    /**
     * 本年实际会员等级，等价于max(上年末继承会员等级,本年成长值等级,本年日消费成长值等级)，另考虑强制升降级
     */
    private String gradeActual;

    /**
     * 本年成长值
     */
    private BigDecimal balance;

    /**
     * 本年成长值等级
     */
    private String gradeYear;

    /**
     * 上年末成长值
     */
    private BigDecimal balanceLastYear;

    /**
     * 上年末会员等级,不等于上年末继承会员等级
     */
    private String gradeLastYear;

    /**
     * 本年初会员等级，即上年末继承会员等级
     */
    private String gradeThisYearStart;

    /**
     * 本年最大日消费
     */
    private BigDecimal maxPayDay;

    /**
     * 本年日消费成长值等级
     */
    private String gradeDay;

    private LocalDateTime updateTime;

}
