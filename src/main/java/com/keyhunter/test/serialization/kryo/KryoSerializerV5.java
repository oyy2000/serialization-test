package com.keyhunter.test.serialization.kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.keyhunter.test.serialization.Serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @auther yingren
 * Created on 2017/2/23.
 */
public class KryoSerializerV5 implements Serializer {
    Kryo kryo = new Kryo();

    /**
     * 循环里已经多次序列化了，相当于已经做了文档里说的提前注册，所以这里注册与否都无所谓了，但是实际开发过程中，可能还要写 kryo.addDefaultSerializer(SomeClass.class, SomeSerializer.class);
     * Instead of writing a varint class ID (often 1-2 bytes), the fully qualified class name is written
     * the first time an unregistered class appears in the object graph. Subsequent appearances of that
     * class within the same object graph are written using a varint. Short package names could be considered to reduce the serialized size.
     */
    public <T> void preSerialize(T object) {
        kryo.setRegistrationRequired(false);//No need to pre-register the class

//        @SuppressWarnings("unchecked")
//        Class<T> clazz = (Class<T>) object.getClass();
//        kryo.register(clazz);
//        kryo.register(java.util.ArrayList.class);
//        kryo.register(SimpleObject.class);
//        kryo.register(FareSearchResponse.class);
    }

    @Override
    public <T> byte[] serialize(T object) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             Output output = new Output(outputStream)) {
            kryo.writeObject(output, object);
            output.flush();
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
             Input input = new Input(byteArrayInputStream)) {
                return kryo.readObject(input, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            kryo.reset();
        }
        return null;
    }
}
