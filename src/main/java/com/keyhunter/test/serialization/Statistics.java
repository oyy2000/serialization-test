package com.keyhunter.test.serialization;

import java.text.DecimalFormat;

/**
 * @author yingren
 * Created on 2017/2/23.
 */
public class Statistics {

    /**
     * name for statistics
     */
    private String name;

    /**
     * max cost time
     * UNIT:ns
     */
    private long maxSerializeCostTime;

    /**
     * min serialize cost time
     * UNIT:ns
     */
    private long minSerializeCostTime;

    /**
     * avg serialize cost time
     * UNIT:ns
     */
    private long avgSerializeCostTime;

    private double avgSerializeCostTimeComparison;

    /**
     * max serialize cost time
     * UNIT:ns
     */
    private long maxDeserializeCostTime;

    /**
     * min serialize cost time
     * UNIT:ns
     */
    private long minDeserializeCostTime;

    /**
     * avg serialize cost time
     * UNIT:ns
     */
    private long avgDeserializeCostTime;
    private double avgDeserializeCostTimeComparison;

    private long avgTotalCostTime;

    public long getAvgTotalCostTime() {
        return avgTotalCostTime;
    }

    public void setAvgTotalCostTime(long avgTotalCostTime) {
        this.avgTotalCostTime = avgTotalCostTime;
    }

    public double getAvgTotalCostTimeComparison() {
        return avgTotalCostTimeComparison;
    }

    public void setAvgTotalCostTimeComparison(double avgTotalCostTimeComparison) {
        this.avgTotalCostTimeComparison = avgTotalCostTimeComparison;
    }

    private double avgTotalCostTimeComparison;

    /**
     * size
     * UNIT:byte
     */
    private int size;

    public double getAvgSerializeCostTimeComparison() {
        return avgSerializeCostTimeComparison;
    }

    public void setAvgSerializeCostTimeComparison(double avgSerializeCostTimeComparison) {
        this.avgSerializeCostTimeComparison = avgSerializeCostTimeComparison;
    }

    public double getAvgDeserializeCostTimeComparison() {
        return avgDeserializeCostTimeComparison;
    }

    public void setAvgDeserializeCostTimeComparison(double avgDeserializeCostTimeComparison) {
        this.avgDeserializeCostTimeComparison = avgDeserializeCostTimeComparison;
    }

    public double getSizeComparison() {
        return sizeComparison;
    }

    public void setSizeComparison(double sizeComparison) {
        this.sizeComparison = sizeComparison;
    }

    private double sizeComparison;

    private final static String SPLITOR = " |";
    private final static DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#########");
    private final static int NUMBER_FIX_LENGTH = 9;
    private final static int STRING_FIX_LENGTH = 22;


    public Statistics() {
    }

    public Statistics(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMaxSerializeCostTime() {
        return maxSerializeCostTime;
    }

    public void setMaxSerializeCostTime(long maxSerializeCostTime) {
        this.maxSerializeCostTime = maxSerializeCostTime;
    }

    public long getMinSerializeCostTime() {
        return minSerializeCostTime;
    }

    public void setMinSerializeCostTime(long minSerializeCostTime) {
        this.minSerializeCostTime = minSerializeCostTime;
    }

    public long getAvgSerializeCostTime() {
        return avgSerializeCostTime;
    }

    public void setAvgSerializeCostTime(long avgSerializeCostTime) {
        this.avgSerializeCostTime = avgSerializeCostTime;
    }

    public long getMaxDeserializeCostTime() {
        return maxDeserializeCostTime;
    }

    public void setMaxDeserializeCostTime(long maxDeserializeCostTime) {
        this.maxDeserializeCostTime = maxDeserializeCostTime;
    }

    public long getMinDeserializeCostTime() {
        return minDeserializeCostTime;
    }

    public void setMinDeserializeCostTime(long minDeserializeCostTime) {
        this.minDeserializeCostTime = minDeserializeCostTime;
    }

    public long getAvgDeserializeCostTime() {
        return avgDeserializeCostTime;
    }

    public void setAvgDeserializeCostTime(long avgDeserializeCostTime) {
        this.avgDeserializeCostTime = avgDeserializeCostTime;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private String toPercentage(double value) {
        // 控制double显示两位小数
        return toNumberFixLength(new DecimalFormat("##.##").format(value * 100) + "%");
    }
    @Override
    public String toString() {
        // make the avgSerializeCostTimeComparison to be displayed like percentage
        return toStringFixLength(name)
                + SPLITOR + toMillSecondsString(avgSerializeCostTime)
                + SPLITOR + toPercentage(avgSerializeCostTimeComparison)
                + SPLITOR + toMillSecondsString(minSerializeCostTime)
                + SPLITOR + toMillSecondsString(maxSerializeCostTime)
                + SPLITOR + toMillSecondsString(avgDeserializeCostTime)
                + SPLITOR + toPercentage(avgDeserializeCostTimeComparison)
                + SPLITOR + toMillSecondsString(minDeserializeCostTime)
                + SPLITOR + toMillSecondsString(maxDeserializeCostTime)
                + SPLITOR + toMillSecondsString(avgTotalCostTime)
                + SPLITOR + toPercentage(avgTotalCostTimeComparison)
                + SPLITOR + toNumberFixLength(String.valueOf(size))
                + SPLITOR + toPercentage(sizeComparison);
    }

    public static String header() {
        return toStringFixLength("name")
                + SPLITOR + toNumberFixLength("avgSer")
                + SPLITOR + toPercentageFixLength("ser%")
                + SPLITOR + toNumberFixLength("minSer")
                + SPLITOR + toNumberFixLength("maxSer")
                + SPLITOR + toNumberFixLength("avgDeser")
                + SPLITOR + toPercentageFixLength("dser%")
                + SPLITOR + toNumberFixLength("minDeser")
                + SPLITOR + toNumberFixLength("maxDeser")
                + SPLITOR + toNumberFixLength("TotalTime")
                + SPLITOR + toPercentageFixLength("total%")
                + SPLITOR + toNumberFixLength("size")
                + SPLITOR + toPercentageFixLength("size%");
    }

    private String toMillSecondsString(long nanoMills) {
        return toNumberFixLength(DECIMAL_FORMAT.format(nanoMills));
    }

    private static String toNumberFixLength(String s) {
        return toFixLength(s, NUMBER_FIX_LENGTH);
    }

    private static String toPercentageFixLength(String s) {
        return toFixLength(s, NUMBER_FIX_LENGTH);
    }

    private static String toStringFixLength(String s) {
        return toFixLength(s, STRING_FIX_LENGTH);
    }

    private static String toFixLength(String s, int length) {
        if (s.length() < length) {
            StringBuilder buf = new StringBuilder(s);
            int fixLength = length - s.length();
            for (int i = 0; i < fixLength; i++) {
                buf.insert(0, " ");
            }
            return buf.toString();
        }
        return s;
    }
}
