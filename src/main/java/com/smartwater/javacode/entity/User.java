package com.smartwater.javacode.entity;

import java.io.Serializable;
import java.util.List;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import cn.smartwatercloud.smartwater.common.entity.BaseEntity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Author LiangKai
 * Date 2019-05-20
 */
@Data
@ToString
@Table(name = "user")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     *主键ID
     */
    @Id
    @Column(name = "ID")
    private int id;

    /**
     *用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     *邮箱地址
     */
    @Column(name = "email")
    private String email;

    /**
     *年龄
     */
    @Column(name = "age")
    private int age;

    /**
     *创建人ID
     */
    @Column(name = "CREATE_USER_ID")
    private String createUserId;

    /**
     *修改人ID
     */
    @Column(name = "UPDATE_USER_ID")
    private String updateUserId;

    /**
     *修改时间
     */
    @Column(name = "UPDATE_TIMESTAMP")
    private Timestamp updateTimestamp;

    /**
     *创建时间
     */
    @Column(name = "CREATE_TIMESTAMP")
    private Timestamp createTimestamp;



}