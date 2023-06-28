package com.keyhunter.test.serialization;

import com.alibaba.fastjson.JSON;
import com.keyhunter.test.serialization.bean.SimpleObject;
import com.keyhunter.test.serialization.bean.pojo.FareSearchResponse;
import com.keyhunter.test.serialization.jdk.JdkSerializer;
import com.keyhunter.test.serialization.json.FastJSONSerializer;
import com.keyhunter.test.serialization.kryo.KryoSerializerV5;
import com.keyhunter.test.serialization.protobuffer.ProtobufSerializer;
import com.keyhunter.test.serialization.protobuffer.ProtoStuffSerializer;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Application entry point
 *
 * @author yingren
 * Created on 2017/2/23.
 */
@State(Scope.Benchmark)
public class Application {

    private final List<Serializer> serializers = new ArrayList<>();
    private List<Statistics> statisticsList;
    private final Config config;
    final static int LOOP_SIZE_SIMPLE = 1000;
    final static int LOOP_SIZE_COMPLEX = 200;
    final static int OUTER_LOOP_SIZE = 200;
    final static int COLD_START_LOOP_SIZE = 1;
    private StatisticsCollecter statisticsCollecter;

    /**
     * main method to the run an application
     * @param args args
     */
    public static void main(String[] args) throws IOException {
        //simple
        Config config = new Config();
        config.setOuterLoopSize(COLD_START_LOOP_SIZE);
        config.setLoopSize(COLD_START_LOOP_SIZE);
        config.setNameSuffix("Simple-Cold");
        config.setTargetObject(buildSimpleObject());
        Application application = new Application(config);
        // cold start, only once
        application.run(config.getOuterLoopSize());
        // hot start
        config.setOuterLoopSize(OUTER_LOOP_SIZE);
        config.setNameSuffix("Simple-Hot");
        config.setLoopSize(LOOP_SIZE_SIMPLE);
        application = new Application(config);
        application.run(config.getOuterLoopSize());

        //complex
        config.setOuterLoopSize(COLD_START_LOOP_SIZE);
        config.setLoopSize(COLD_START_LOOP_SIZE);
        config.setNameSuffix("Complex-Cold");
        config.setTargetObject(buildFSR());
        application = new Application(config);
        // cold start
        application.run(config.getOuterLoopSize());
        // hot start
        config.setOuterLoopSize(OUTER_LOOP_SIZE);
        config.setLoopSize(LOOP_SIZE_COMPLEX);
        config.setNameSuffix("Complex-Hot");
        application = new Application(config);
        application.run(config.getOuterLoopSize());
    }

    static SimpleObject buildSimpleObject() {
        SimpleObject simpleObject = new SimpleObject();
        simpleObject.setName("simple object");
        simpleObject.setValue("i'm a simple object");
        simpleObject.setAge(22);
        simpleObject.setMail("xiaoming@qq.com");
        ArrayList<String> parents = new ArrayList<>();
        parents.add("mother");
        parents.add("father");
        simpleObject.setParents(parents);
        simpleObject.setSchool("Star School");
        simpleObject.setTeacher("James Lee");
        simpleObject.setScore(32.8);
        simpleObject.setHeight(180);
        simpleObject.setWeight(66);
        simpleObject.setDesc("It's my pleasure to introduce my self..well");
        return simpleObject;
    }

    private static FareSearchResponse buildFSR() throws IOException {
        FareSearchResponse fsr;
        // read the file from resource
        String fileName = "SHA-HKG-2023-05-25.txt";
        ClassLoader classLoader = Application.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());

        // using BufferReader to read the file from resource
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        String ls = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();
        String content = stringBuilder.toString();
        // using fastJson to generate the FareSearchResponse POJO object
        fsr = JSON.parseObject(content,FareSearchResponse.class);
        return fsr;
    }

    void run(int loopSize) {
        for (int i = 0; i < loopSize; i++) {
            statistics();
//            System.out.println("第" + i +"次");
//            print();
        }
        divideLoopSize(loopSize);
        print();
    }


    public Application(Config config) {
        this.config = config;
        this.init();
    }

    public void init() {
        register(new JdkSerializer());
        register(new FastJSONSerializer());
        register(new ProtobufSerializer());
        register(new ProtoStuffSerializer());
        register(new KryoSerializerV5());

//        register(new XMLSerializer());
//        register(new JackJSONSerializer());
//        register(new HessianSerializer());
        statisticsCollecter = new StatisticsCollecter(config);
    }

    public void register(Serializer serializer) {
        serializers.add(serializer);
    }

    public void print() {
        sortStatistics();
        computePercentage();
        System.out.println("\n" + config);
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println(Statistics.header());
        for (Statistics statistics : statisticsList) {
            System.out.println(statistics.toString());
        }
    }

    private void divideLoopSize(int loopSize) {
        for (Statistics statistics : statisticsList) {
            statistics.setSize(statistics.getSize() / loopSize);
            statistics.setAvgTotalCostTime(statistics.getAvgTotalCostTime() / loopSize);
            statistics.setAvgSerializeCostTime(statistics.getAvgSerializeCostTime() / loopSize);
            statistics.setAvgDeserializeCostTime(statistics.getAvgDeserializeCostTime() / loopSize);
        }
    }

    private void sortStatistics() {
        statisticsList.sort((o1, o2) -> {
            long avgCostTime1 = o1.getAvgSerializeCostTime() + o1.getAvgDeserializeCostTime();
            long avgCostTime2 = o2.getAvgSerializeCostTime() + o2.getAvgDeserializeCostTime();
            return Long.compare(avgCostTime1, avgCostTime2);
        });
    }

    private void computePercentage() {
        // compute the percentage of the comparison of min AvgSerializeCostTime, AvgDeserializeCostTime, AvgTotalCostTime, AvgSize
        // 对比AvgSerializeCostTime, AvgDeserializeCostTime, AvgTotalCostTime, AvgSize这几个指标的同Protobuf的差异百分比
        Statistics protobufStatistics = null;
        for (Statistics statistics : statisticsList) {
            if (statistics.getName().contains("Protobuf")) {
                protobufStatistics = statistics;
                break;
            }
        }
        if (protobufStatistics == null) {
            return;
        }
        for (Statistics statistics : statisticsList) {
            if (statistics.getName().equals("Protobuf")) {
                continue;
            }
            statistics.setAvgSerializeCostTimeComparison((double) statistics.getAvgSerializeCostTime() / protobufStatistics.getAvgSerializeCostTime() - 1);
            statistics.setAvgDeserializeCostTimeComparison((double) statistics.getAvgDeserializeCostTime() / protobufStatistics.getAvgDeserializeCostTime() - 1);
            statistics.setAvgTotalCostTimeComparison((double) statistics.getAvgTotalCostTime() / protobufStatistics.getAvgTotalCostTime() - 1);
            statistics.setSizeComparison((double) statistics.getSize() / protobufStatistics.getSize() - 1);
        }

    }

    public void statistics() {
        final List<Statistics> statisticsList = new ArrayList<>();
        final CountDownLatch countDownLatch = new CountDownLatch(serializers.size());
        for (final Serializer serializer : serializers) {
//            Thread thread = new Thread(() -> {
                Statistics statistics = statisticsCollecter.collect(serializer, config.getTargetObject());
                statistics.setName(statistics.getName() + "-" + config.getNameSuffix());
                statisticsList.add(statistics);
                countDownLatch.countDown();
//            });
//            thread.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.statisticsList == null)
        {
            this.statisticsList = statisticsList;
        } else {
            // accumulate the data of each statistics
            for (Statistics statistics : statisticsList) {
                for (Statistics statistics1 : this.statisticsList) {
                    if (statistics.getName().equals(statistics1.getName())) {
                        statistics1.setAvgSerializeCostTime((statistics1.getAvgSerializeCostTime() + statistics.getAvgSerializeCostTime()));
                        statistics1.setAvgDeserializeCostTime((statistics1.getAvgDeserializeCostTime() + statistics.getAvgDeserializeCostTime()));
                        statistics1.setAvgTotalCostTime((statistics1.getAvgTotalCostTime() + statistics.getAvgTotalCostTime()));
                        statistics1.setSize((statistics1.getSize() + statistics.getSize()));
                        statistics1.setMinSerializeCostTime(Math.min(statistics1.getMinSerializeCostTime(), statistics.getMinSerializeCostTime()));
                        statistics1.setMinDeserializeCostTime(Math.min(statistics1.getMinDeserializeCostTime(), statistics.getMinDeserializeCostTime()));
                        statistics1.setMaxSerializeCostTime(Math.max(statistics1.getMaxSerializeCostTime(), statistics.getMaxSerializeCostTime()));
                        statistics1.setMaxDeserializeCostTime(Math.max(statistics1.getMaxDeserializeCostTime(), statistics.getMaxDeserializeCostTime()));
                        break;
                    }
                }
            }
        }
    }
}
