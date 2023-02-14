package com.lhj.shixun1.account.entity;

import com.lhj.shixun1.common.entiy.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "account_user")
public class User extends AbstractEntity {
    private String userName;
    private String password;

    public User() {
    }

    public User(int id, LocalDateTime createTime, LocalDateTime updateTime, String userName, String password) {
        super(id, createTime, updateTime);
        this.userName = userName;
        this.password = password;
    }
}
