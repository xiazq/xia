package com.example.demo2.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;


public class Users implements Serializable {
    private static final long serialVersionUID = 201591254987287689L;

    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 1男 2.女
     */
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;

    private Date gmtCreate;
    /**
     * 来源
     */
    private Short source;
    /**
     * 描述
     */
    private Byte[] desc;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 上级id-对应相关id
     */
    private Integer parentId;

    private Users users;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Short getSource() {
        return source;
    }

    public void setSource(Short source) {
        this.source = source;
    }

    public Byte[] getDesc() {
        return desc;
    }

    public void setDesc(Byte[] desc) {
        this.desc = desc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

}