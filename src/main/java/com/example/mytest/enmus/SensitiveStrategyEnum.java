package com.example.mytest.enmus;

import java.util.function.Function;
/**
 * @Author: jiangbingqing
 * @Date: 2024/10/14
 * @Description: com.example.mytest.enmus
 * @Citer:https: //blog.csdn.net/fffhhdd/article/details/131219818
 */
public enum SensitiveStrategyEnum {

    USERNAME(s -> s.replaceAll("(\\S)\\S(\\S*)", "$1*$2")),
    ID_CARD(s -> s.replaceAll("(\\d{3})\\d{13}(\\w{2})", "$1****$2")),
    PHONE(s -> s.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2")),
    ADDRESS(s -> s.replaceAll("(\\S{3})\\S{2}(\\S*)\\S{2}", "$1****$2****"));

    private Function<String, String> desensitizes;
    SensitiveStrategyEnum(Function<String, String> desensitizes) {
        this.desensitizes = desensitizes;
    }

    public Function<String, String> getDesensitizes() {
        return desensitizes;
    }

    public void setDesensitizes(Function<String, String> desensitizes) {
        this.desensitizes = desensitizes;
    }

}
