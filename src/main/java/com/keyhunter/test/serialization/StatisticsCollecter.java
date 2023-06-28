package com.keyhunter.test.serialization;

import com.google.common.base.Stopwatch;
import com.keyhunter.test.serialization.kryo.KryoSerializerV5;
import com.keyhunter.test.serialization.protobuffer.ProtobufSerializer;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author yingren
 * Created on 2017/2/23.
 */
public class StatisticsCollecter {

    private final int loopSize;


    public StatisticsCollecter(Config config) {
        this.loopSize = config.getLoopSize();
    }

    /**
     * Collect statistics.
     */
    public Statistics collect(Serializer serializer, Serializable serializable) {

        String simpleName = serializer.getClass().getSimpleName();
        Statistics statistics = new Statistics(simpleName.replace("Serializer", ""));

        long totalSerializeCostTime = 0L;
        long totalDeserializeCostTime = 0L;

        // 针对protobuf和kryo分别做前置处理，以达到热启动性能
        if (serializer instanceof ProtobufSerializer){
            ((ProtobufSerializer) serializer).preSerialize(serializable);
        } else if (serializer instanceof KryoSerializerV5) {
            ((KryoSerializerV5) serializer).preSerialize(serializable);
        }

        byte[] serialized = serializer.serialize(serializable);

        statistics.setSize(serialized.length);

        for (int i = 0; i < loopSize; i++) {
            // ser
            Stopwatch startSer = Stopwatch.createStarted();
            byte[] serialize = serializer.serialize(serializable);
            long serializeCostTime =  startSer.elapsed(TimeUnit.NANOSECONDS);
            totalSerializeCostTime += serializeCostTime;
            setSerializeCostTime(statistics, serializeCostTime);

            // desr
            Stopwatch startDesr = Stopwatch.createStarted();
            Object o = serializer.deserialize(serialize, serializable.getClass());
            long deserializeCostTime =  startDesr.elapsed(TimeUnit.NANOSECONDS);
            totalDeserializeCostTime += deserializeCostTime;
            setDeserialeCostTime(statistics, deserializeCostTime);
        }

        statistics.setAvgSerializeCostTime(totalSerializeCostTime / loopSize);
        statistics.setAvgDeserializeCostTime(totalDeserializeCostTime / loopSize);

        statistics.setAvgTotalCostTime( (totalSerializeCostTime + totalDeserializeCostTime) / loopSize);
        return statistics;
    }


    public Statistics collectNoLoop(Serializer serializer, Serializable serializable) {
        String simpleName = serializer.getClass().getSimpleName();
        Statistics statistics = new Statistics(simpleName.replace("Serializer", ""));

        long totalSerializeCostTime = 0L;
        long totalDeserializeCostTime = 0L;

        // 针对protobuf和kryo分别做前置处理，以达到热启动性能
        if (serializer instanceof ProtobufSerializer){
            ((ProtobufSerializer) serializer).preSerialize(serializable);
        } else if (serializer instanceof KryoSerializerV5) {
            ((KryoSerializerV5) serializer).preSerialize(serializable);
        }

        byte[] serialized = serializer.serialize(serializable);

        statistics.setSize(serialized.length);

            // ser
            Stopwatch startSer = Stopwatch.createStarted();
            byte[] serialize = serializer.serialize(serializable);
            long serializeCostTime =  startSer.elapsed(TimeUnit.NANOSECONDS);
            totalSerializeCostTime += serializeCostTime;
            setSerializeCostTime(statistics, serializeCostTime);

            // desr
            Stopwatch startDesr = Stopwatch.createStarted();
            Object o = serializer.deserialize(serialize, serializable.getClass());
            long deserializeCostTime =  startDesr.elapsed(TimeUnit.NANOSECONDS);
            totalDeserializeCostTime += deserializeCostTime;
            setDeserialeCostTime(statistics, deserializeCostTime);

        statistics.setAvgSerializeCostTime(totalSerializeCostTime );
        statistics.setAvgDeserializeCostTime(totalDeserializeCostTime );

        statistics.setAvgTotalCostTime( (totalSerializeCostTime + totalDeserializeCostTime));
        return statistics;
    }

    /**
     * set min and max deserializeCostTime
     *
     * @param statistics
     * @param deserializeCostTime
     */
    private void setDeserialeCostTime(Statistics statistics, long deserializeCostTime) {
        if (statistics.getMinDeserializeCostTime() == 0 || statistics.getMinDeserializeCostTime() > deserializeCostTime) {
            statistics.setMinDeserializeCostTime(deserializeCostTime);
        }
        if (statistics.getMaxDeserializeCostTime() == 0 || statistics.getMaxDeserializeCostTime() < deserializeCostTime) {
            statistics.setMaxDeserializeCostTime(deserializeCostTime);
        }
    }

    /**
     * set min and max serializeCostTime
     *
     * @param statistics
     * @param serializeCostTime
     */
    private void setSerializeCostTime(Statistics statistics, long serializeCostTime) {
        if (statistics.getMinSerializeCostTime() == 0 || statistics.getMinSerializeCostTime() > serializeCostTime) {
            statistics.setMinSerializeCostTime(serializeCostTime);
//            System.out.println("minSerializeCostTime:" + statistics.getMinSerializeCostTime());
//            System.out.println("serializeCostTime:" + serializeCostTime);
        }
        if (statistics.getMaxSerializeCostTime() == 0 || statistics.getMaxSerializeCostTime() < serializeCostTime) {
            statistics.setMaxSerializeCostTime(serializeCostTime);
        }
    }
}