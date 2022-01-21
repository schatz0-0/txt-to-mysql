package com.lin.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Ctd {
    /**
     * ID
     */
    @Id
    private Integer id;

    /**
     * 时间
     */
    private LocalDateTime dateTime;

    /**
     * 电导率
     */
    private Double conductivity;

    /**
     * 盐度（psu）
     */
    private Double salinity;

    /**
     * 温度（℃）
     */
    private Double temp;

    /**
     * 深度（m）
     */
    private Double depth;

    /**
     * 叶绿素（mg/L）
     */
    private Double chlorophyll;

    /**
     * 浊度（NTU）
     */
    private Double turbidity;

    /**
     * PH（ph）
     */
    private Double ph;

    /**
     * 溶解氧
     */
    private Double dissolvedOxygen;

    /**
     * 声速
     */
    private Double soundVelocity;
}
