package com.keyhunter.test.serialization;

import java.io.*;

/**
 * The config for serialize test.
 *
 * @author yingren
 * Created on 2017/2/23.
 */
public class Config {

    /**
     * statistics loop size
     */
    private int loopSize;

    public int getOuterLoopSize() {
        return outerLoopSize;
    }

    public void setOuterLoopSize(int outerLoopSize) {
        this.outerLoopSize = outerLoopSize;
    }

    /**
     * outer loop size
     */
    private int outerLoopSize;

    /**
     * target obj to serialize and deserialize;
     */
    private Serializable targetObject;

    /**
     * statistics name suffix
     */
    private String nameSuffix;


    public int getLoopSize() {
        return loopSize;
    }

    public void setLoopSize(int loopSize) {
        this.loopSize = loopSize;
    }

    public Serializable getTargetObject() {
        return targetObject;
    }

    public void setTargetObject(Serializable targetObject) {
        this.targetObject = targetObject;
    }

    public String getNameSuffix() {
        return nameSuffix;
    }

    public void setNameSuffix(String nameSuffix) {
        this.nameSuffix = nameSuffix;
    }

    @Override
    public String toString() {
        return "Config: " +
                "loopSize = " + loopSize +
                ", outerLoopSize = " + outerLoopSize;
    }
}
