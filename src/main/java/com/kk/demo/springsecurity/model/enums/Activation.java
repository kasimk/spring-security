package com.kk.demo.springsecurity.model.enums;

import lombok.Getter;

/**
 * 狀態類型
 */
public enum Activation {

    ACTIVE("啟用"),
    INACTIVE("停用");

    @Getter
    private String name;

    Activation(String name) {
        this.name = name;
    }
}
