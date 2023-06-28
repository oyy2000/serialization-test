package com.keyhunter.test.serialization;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * Created by yingren on 2016/12/2.
 */
public interface Serializer {
    @Benchmark
    <T> byte[] serialize(T object);

    @Benchmark
    <T> T deserialize(byte[] bytes, Class<T> clazz);
}
