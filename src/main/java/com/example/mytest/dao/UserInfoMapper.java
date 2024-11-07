package com.example.mytest.dao;

import com.example.mytest.vo.UserVo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * @Classname UserInfoMapper
 * @Description TODO
 * @Version 1.0.0
 * @Date 2024/10/16 22:57
 * @Created by JiangBingQing
 */
@Mapper
public interface UserInfoMapper {

    UserVo getUserInfo();
}
