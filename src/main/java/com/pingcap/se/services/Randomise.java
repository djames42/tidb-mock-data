package com.pingcap.se.services;

import java.util.Random;

public class Randomise {
    private Random random;
    public Randomise() {
        random = new Random();
    }

    public int randomInt(int maxInt) {
        return random.nextInt(maxInt);
    }

    public float randomFloat() {
        return random.nextFloat()*1000F;
    }

    public String randomString(Integer length) {
        StringBuilder buffer = new StringBuilder(length);
        int ascii;
        for (int c=0; c<length; c++) {
            ascii = 97 + randomInt(26);
            buffer.append((char) ascii);
        }
        return buffer.toString();
    }

}
