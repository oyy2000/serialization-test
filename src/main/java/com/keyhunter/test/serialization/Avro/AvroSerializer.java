package com.keyhunter.test.serialization.Avro;

import com.keyhunter.test.serialization.Serializer;
import example.avro.User;

import java.io.IOException;

public class AvroSerializer implements Serializer {
    public AvroSerializer() throws IOException {
        User user1 = new User();
        user1.setName("Alyssa");
        user1.setFavoriteNumber(256);
// Leave favorite color null

// Alternate constructor
        User user2 = new User("Ben", 7, "red");

// Construct via builder
        User user3 = User.newBuilder()
                .setName("Charlie")
                .setFavoriteColor("blue")
                .setFavoriteNumber(null)
                .build();
    // Serialize user1, user2 and user3 to disk


//        DatumWriter<SimpleObject> simpleObjDatumWriter = new SpecificDatumWriter<>(SimpleObject.class);
//        DataFileWriter<SimpleObject> dataFileWriter = new DataFileWriter<>(simpleObjDatumWriter);
//        dataFileWriter.create(user1.getSchema(), new File("users.avro"));
//        dataFileWriter.append(user1);
//        dataFileWriter.append(user2);
//        dataFileWriter.append(user3);
//        dataFileWriter.close();

    }

    @Override
    public <T> byte[] serialize(T object) {
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        return null;
    }
}
