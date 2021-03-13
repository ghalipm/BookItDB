package com.bookit.utilities;

import java.util.Random;

public class DataUtils {

    public static int generateSingleNum(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }
}
