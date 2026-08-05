package com.dmhr114514.zhangxianzhong.simulator;

import java.util.Random;
import java.util.Scanner;

public class Tutu {
    public static void main(String[] args){
        //缓冲时间
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎使用大西王模拟器");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("免责声明");
        System.out.println("本程序仅供娱乐，亦供java初学者练习，不代表作者立场");
        System.out.println("作者不支持任何极端思想！！！");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //输入城名
        System.out.println("请输入您要图的城市名");
        String name = sc.next();

        //人口判定
        int population = 0;
        System.out.println("由自己决定人口请输入A，由系统生成人口请输入B");
        String control = sc.next();
        if (control.equals("A")){
            System.out.println("请输入人口数");
            population = sc.nextInt();
        } else if (control.equals("B")){
            Random ra = new Random();
            population = ra.nextInt(9999999);
        } else {
            System.out.println("您输入了无效字符串！");
            return;
        }
        System.out.println("确认：");
        System.out.println("城邑名：" + name);
        System.out.println("人口数：" + population);
        System.out.println("输入“OK”以确认，不正确则重启程序");
        control = sc.next();

        //计算代码
        int ren = 0;
        if (control.equals("OK")) {
            while (true) {
                System.out.println("启禀将军，我们已经攻占了" + name + "，您想要图城还是施恩？");
                System.out.println("输入“图图”或者“施恩”以选择");
                control = sc.next();
                if (control.equals("图图")) {
                    System.out.println("请输入数字");
                    ren = sc.nextInt();
                    if (ren <= 0){
                        System.out.println("您输入了无效数值！");
                        continue;
                    } else {
                        if (ren <= population) {
                            population = population - ren;
                            System.out.println(name + "还剩" + population + "人");
                            continue;
                        } else {
                            population = 0;
                            System.out.println(name + "变成了鬼城");
                            continue;
                        }
                    }
                } else if (control.equals("施恩")) {
                    System.out.println("释放多少人归田？");
                    System.out.println("请输入数字");
                    ren = sc.nextInt();
                    population = population + ren;
                    System.out.println(name + "现有" + population + "人");
                    continue;
                } else {
                    System.out.println("您输入了无效字符串！");
                    continue;
                }
            }
        } else {
            System.out.println("您输入了无效字符串！");
        }
    }
}
