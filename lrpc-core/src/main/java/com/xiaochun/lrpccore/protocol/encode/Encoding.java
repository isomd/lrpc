package com.xiaochun.lrpccore.protocol.encode;

public interface Encoding {
    byte[] encode(Object obj);
    <T> T decode(byte[] data, Class<T> clazz);
}
