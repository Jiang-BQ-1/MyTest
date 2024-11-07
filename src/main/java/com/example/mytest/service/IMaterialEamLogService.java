package com.example.mytest.service;

import com.example.mytest.vo.MaterialEamLogVo;
import com.example.mytest.vo.UserVo;
import org.springframework.stereotype.Service;

/**
 * @Classname IMaterialEamLogService
 * @Description TODO
 * @Version 1.0.0
 * @Date 2024/10/16 17:58
 * @Created by 17517
 */

public interface IMaterialEamLogService {

    /**
     * 插入日志
     * @param materialEamLogVo
     * @return
     */
    public boolean insert(MaterialEamLogVo materialEamLogVo);

    /**
     * 获取用户信息
     */
    public UserVo getUserInfo();


}
