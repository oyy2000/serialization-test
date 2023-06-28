package com.keyhunter.test.serialization.protobuffer;

import com.alibaba.fastjson.JSON;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.keyhunter.test.serialization.Serializer;
import com.keyhunter.test.serialization.bean.FareSearchResponseOuterClass;
import com.keyhunter.test.serialization.bean.SimpleObject;
import com.keyhunter.test.serialization.bean.SimpleObjectOuterClass;
import com.keyhunter.test.serialization.bean.pojo.FareSearchResponse;

public class ProtobufSerializer implements Serializer {
    // 出于信任，没有测试反序列化的对象是否符合要求
    private final SimpleObjectOuterClass.SimpleObject.Builder simpleObjectBuilder = SimpleObjectOuterClass.SimpleObject.newBuilder();
    private final FareSearchResponseOuterClass.FareSearchResponse.Builder fareSearchResponseBuilder = FareSearchResponseOuterClass.FareSearchResponse.newBuilder();
    private boolean isFirst = true;
    public <T> void preSerialize(T object) {
        if(!isFirst) {
            return;
        }
        isFirst = false;
        String json = JSON.toJSONString(object);
        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) object.getClass();
        if (clazz == SimpleObject.class) {
            try {
                JsonFormat.parser().ignoringUnknownFields().merge(json, simpleObjectBuilder);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        } else if (clazz == FareSearchResponse.class) {
            try {
                JsonFormat.parser().ignoringUnknownFields().merge(json, fareSearchResponseBuilder);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public <T> byte[] serialize(T object) {
        // convert the object into json string
//        Stopwatch started = Stopwatch.createStarted();

        @SuppressWarnings("unchecked")
        Class<T> clazz = (Class<T>) object.getClass();
//        System.out.println(started.elapsed(TimeUnit.NANOSECONDS) + "ns to get class");
        if (clazz == SimpleObject.class) {
            return simpleObjectBuilder.build().toByteArray();
        } else if (clazz == FareSearchResponse.class) {
            return fareSearchResponseBuilder.build().toByteArray();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        if(clazz == SimpleObject.class) {
            try {
                return (T) SimpleObjectOuterClass.SimpleObject.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        } else if (clazz == FareSearchResponse.class) {
            try {
                return (T) FareSearchResponseOuterClass.FareSearchResponse.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }


}
