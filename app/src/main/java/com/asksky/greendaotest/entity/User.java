package com.asksky.greendaotest.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by asksky on 2017/3/3.
 * 用户实体类
 */

@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String sex;
    @Generated(hash = 1265202627)
    public User(Long id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return this.sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}

