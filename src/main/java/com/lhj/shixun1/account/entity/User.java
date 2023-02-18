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
    private String userImage;

    public User() {
    }

    public User(String userName, String password, String userImage) {
        this.userName = userName;
        this.password = password;
        this.userImage = userImage;
    }

    public User(int id, LocalDateTime createTime, LocalDateTime updateTime, String userName, String password, String userImage) {
        super(id, createTime, updateTime);
        this.userName = userName;
        this.password = password;
        this.userImage = userImage;
    }
}
