package com.example.mytest.dao;

import com.example.mytest.vo.MaterialEamLogVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname LogInfoDao
 * @Description TODO
 * @Version 1.0.0
 * @Date 2024/10/16 21:49
 * @Created by JiangBingQing
 */

@Mapper
public interface LogInfoMapper {

    @Insert("insert into log_info (params, method, result, url, ip, time) values (#{vo.params}, #{vo.method}, #{vo.result}, #{vo.url}, #{vo.ip} ,#{vo.time})")
    void insert(@Param("vo") MaterialEamLogVo materialEamLogVo);

}
