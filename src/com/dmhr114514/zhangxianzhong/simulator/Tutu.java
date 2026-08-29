package com.dmhr114514.zhangxianzhong.simulator;

import java.util.Random;
import java.util.Scanner;

public class Tutu {
    public static void main(String[] args){
        //缓冲时间
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎使用大西王模拟器");
        System.out.println("任何不忠不孝不礼不智不仁不义者终将杀杀杀杀杀杀杀！！！");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("免责声明");
        System.out.println("本程序仅供娱乐，或供java初学者练习，不代表作者立场");
        System.out.println("作者不支持任何极端思想！！！");
        System.out.println("作者没有侵害现实中任何人的意图，纯属娱乐！");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //输入城名
        System.out.println("请输入您要图的城市名");
        System.out.println("填现实城市名造成的可能恶劣后果，作者概不承担");
        String name = scanner.next();

        //人口判定
        int population = 0;
        System.out.println("由自己决定人口请输入“Me”");
        System.out.println("由系统生成人口请输入“System”");
        String control = scanner.next();
        if (control.equals("Me")){
            System.out.println("请输入人口数");
            population = scanner.nextInt();
        } else if (control.equals("System")){
            Random random = new Random();
            population = random.nextInt(10000000);
        } else {
            System.out.println("您输入了无效字符串！");
            return;
        }
        System.out.println("确认数据");
        System.out.println("城邑名：" + name);
        System.out.println("人口数：" + population);
        System.out.println("输入“OK”以确认，不正确则请重启程序");
        control = scanner.next();

        //计算代码
        int ren = 0;
        if (control.equals("OK")) {
            while (true) {
                System.out.println("启禀将军，我们已经攻占了" + name + "，您想要图图还是施恩？");
                System.out.println("输入“图图”或者“施恩”以选择");
                control = scanner.next();
                if (control.equals("图图")) {
                    System.out.println("请输入数字");
                    ren = scanner.nextInt();
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
                    ren = scanner.nextInt();
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
