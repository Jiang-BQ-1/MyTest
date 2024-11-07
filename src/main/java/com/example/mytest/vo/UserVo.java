package com.example.mytest.vo;

import com.example.mytest.customAnnotations.SensitiveAnnotation;
import com.example.mytest.enmus.SensitiveStrategyEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {

    private String id;

    @SensitiveAnnotation(SensitiveStrategyEnum.USERNAME)
    private String user_name;

    @SensitiveAnnotation(SensitiveStrategyEnum.ID_CARD)
    private String id_card;

    @SensitiveAnnotation(SensitiveStrategyEnum.PHONE)
    private String phone;

    @SensitiveAnnotation(SensitiveStrategyEnum.ADDRESS)
    private String address;


}
