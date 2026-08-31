//来自DMHRsJavaLib
package com.DMHR114514.zhangxianzhong.simulator.DMHRsJavaLib;

import java.util.Random;

public class RandomRun {
    public static boolean may(float chance) {
        Random random = new Random();
        //当给定的float概率x＜0或x＞1时，直接报错
        if (chance < 0 || chance > 1) {
            throw new IllegalArgumentException("食不食油饼，0≤P(A)≤1，你填了个" + chance + "是什么鬼");
        }
        return random.nextFloat(1) < chance;
    }
}
