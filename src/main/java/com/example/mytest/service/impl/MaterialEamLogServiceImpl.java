package com.example.mytest.service.impl;

import com.example.mytest.dao.LogInfoMapper;
import com.example.mytest.dao.UserInfoMapper;
import com.example.mytest.service.IMaterialEamLogService;
import com.example.mytest.vo.MaterialEamLogVo;
import com.example.mytest.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Classname MaterialEamLogServiceImpl
 * @Description TODO
 * @Version 1.0.0
 * @Date 2024/10/16 17:59
 * @Created by 17517
 */
@Service
@Slf4j
public class MaterialEamLogServiceImpl implements IMaterialEamLogService {

    @Autowired
    private LogInfoMapper mapper;

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public boolean insert(MaterialEamLogVo materialEamLogVo) {

        mapper.insert(materialEamLogVo);
        System.out.println(materialEamLogVo);
        System.out.println("插入成功");
        return true;
    }

    @Override
    public UserVo getUserInfo() {
        UserVo vo = new UserVo();
//        vo = userInfoMapper.getUserInfo();

        vo = userInfoMapper.getUserInfo();

        return vo;
    }
}
