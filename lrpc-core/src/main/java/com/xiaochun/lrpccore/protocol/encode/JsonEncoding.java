package com.xiaochun.lrpccore.protocol.encode;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonEncoding implements Encoding {
    private static final ObjectMapper objectMapper = new ObjectMapper();


    static {
        // 注册JavaTime模块以支持LocalDateTime等时间类型
        objectMapper.registerModule(new JavaTimeModule());
        // 禁用序列化时失败特性
        objectMapper.disable(com.fasterxml.jackson.databind.SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // 禁用反序列化时未知属性特性
        objectMapper.disable(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    @Override
    public byte[] encode(Object obj) {
        if (obj == null) {
            return new byte[0];
        }

        try {
            return objectMapper.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON serialization failed for object: " + obj.getClass().getName(), e);
        }
    }

    @Override
    public <T> T decode(byte[] data, Class<T> clazz) {
        if (data == null || data.length == 0) {
            return null;
        }

        if (clazz == null) {
            throw new IllegalArgumentException("Class type cannot be null");
        }

        try {
            return objectMapper.readValue(data, clazz);
        } catch (IOException e) {
            throw new RuntimeException("JSON deserialization failed for class: " + clazz.getName(), e);
        }
    }

    // 提供获取ObjectMapper实例的方法，便于扩展
    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }
}
