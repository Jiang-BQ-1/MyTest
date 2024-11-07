package com.example.mytest.common;

import com.example.mytest.customAnnotations.SensitiveAnnotation;
import com.example.mytest.enmus.SensitiveStrategyEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.lang.annotation.Annotation;

public class SensitiveJsonSerialize extends JsonSerializer<String> implements ContextualSerializer {

    private SensitiveStrategyEnum sensitiveStrategyEnum;
    @Override
    public void serialize(String s, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//        以下逻辑是固定的脱敏逻辑
//        String substring = s.substring(s.length() - 4);
//        s = "****" + substring;
//        jsonGenerator.writeString(s);
        // 调用enum中function的apply方法，即 脱敏方法，传入原数据
        jsonGenerator.writeString(sensitiveStrategyEnum.getDesensitizes().apply(s));
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {

        Annotation annotation = beanProperty.getAnnotation(SensitiveAnnotation.class);
        if(annotation == null){
            return serializerProvider.findNullValueSerializer(null);
        }else{
            // 获取注解中的value值，即脱敏策略
            SensitiveStrategyEnum sensitiveStrategyEnum = ((SensitiveAnnotation) annotation).value();
            // 将脱敏策略赋值给当前类
            this.sensitiveStrategyEnum = sensitiveStrategyEnum;
            return this;
        }

    }
}
