package com.kk.demo.springsecurity.model;

import com.kk.demo.springsecurity.model.converter.ActivationConverter;
import com.kk.demo.springsecurity.model.enums.Activation;
import lombok.Data;

import javax.persistence.*;

/**
 * 使用者
 */
@Data
@Entity
@Table(name = "user")
public class UserSecurity {

    @Id
    @Column(name = "user_sid", nullable = false, length = 36)
    private String sid;

    /** 名稱(帳號) */
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    /** 密碼 */
    @Column(name = "password", nullable = false, length = 20)
    private String password;

    /** 資料狀態 */
    @Convert(converter = ActivationConverter.class)
    @Column(name = "status")
    private Activation status;
}