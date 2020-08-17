package com.example.demo2.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2020-07-28 13:42:09
 */
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = -94879894071889084L;

    private Integer id;

    private String cname;

    private String userName;

    private Integer ciId;

    private Integer status;

    private long time;

    private Date creatTime;

    private Date gxTime;

}