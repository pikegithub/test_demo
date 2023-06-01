package com.example.demo.domain;

import lombok.Data;

import java.util.Date;

@Data
public class AuthRole {
    /**
     * 角色ID
     */
    private String id;

    /**
     * 角色代码
     */
    private String code;

    /**
     * 排序代码
     */
    private String sortCode;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色类型
     */
    private String type;

    /**
     * 是否应用于工作流
     */
    private String inWorkFlow;

    /**
     * 角色状态
     */
    private String status;

    /**
     * 角色描述
     */
    private String summary;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedTime;
}