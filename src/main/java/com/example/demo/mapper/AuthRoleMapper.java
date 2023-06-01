package com.example.demo.mapper;

import com.example.demo.domain.AuthRole;

import java.util.List;

public interface AuthRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(AuthRole record);

    AuthRole selectByPrimaryKey(String id);

    List<AuthRole> selectAll();

    int updateByPrimaryKey(AuthRole record);
}