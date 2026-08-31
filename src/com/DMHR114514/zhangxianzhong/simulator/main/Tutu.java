package com.DMHR114514.zhangxianzhong.simulator.main;

import com.DMHR114514.zhangxianzhong.simulator.DMHRsJavaLib.RandomRun;

import java.util.Random;
import java.util.Scanner;

public class Tutu {
    public static void main(String[] args){
        //预加载
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("欢迎使用大西王模拟器");
        System.out.println("任何不忠不孝不礼不智不仁不义者终将杀杀杀杀杀杀杀！！！");
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" ");
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
        System.out.println(" ");
        System.out.println("请输入您要图的城市名");
        System.out.println("填现实城市名造成的可能恶劣后果，作者概不承担");
        String name = scanner.next();

        //人口判定
        int population = 0;
        System.out.println(" ");
        System.out.println("由自己决定人口请输入“Me”");
        System.out.println("由系统生成人口请输入“System”");
        String control = scanner.next();
        if (control.equals("Me") || control.equals("me")){
            System.out.println("请输入人口数");
            population = scanner.nextInt();
        } else if (control.equals("System") || control.equals("system")){
            population = random.nextInt(10000000);
        } else {
            System.out.println("您输入了无效字符串！");
            return;
        }
        System.out.println(" ");
        System.out.println("确认数据");
        System.out.println("城邑名：" + name);
        System.out.println("人口数：" + population);
        System.out.println("输入“OK”以确认，不正确则请重启程序");
        control = scanner.next();

        //计算代码
        int ren = 0;
        double liang = 0;
        int qian = 0;
        int bing = 11451;
        int time = 1;
        double shuilu = 0.0;
        if (control.equals("OK") || control.equals("ok")) {
            System.out.println(" ");
            System.out.println("启禀将军，我们已经攻占了" + name);
            System.out.println("不过大军人困马乏，先收点粮草吧，请将军确定税率");
            System.out.println("请输入百分号前税率，范围在0~100之间");
            shuilu = scanner.nextDouble();
            liang = liang + shuilu / 100 * (double) ren * 500;

            //游戏主循环
            while (true) {
                //长期事件
                System.out.println("这是驻扎在" + name + "的第" + time + "个月");
                System.out.println("目前资源：");
                System.out.println("粮草：" + liang + " 钱币：" + qian + " 兵力：" + bing);
                System.out.println("输入“征兵”、“释兵”、“施恩”或者“图图”以选择");
                control = scanner.next();
                switch (control) {
                    case "征兵" : control.equals("征兵");
                        System.out.println("征多少人从军？");
                        System.out.println("请输入数字");
                        ren = scanner.nextInt();
                        if (ren <= 0 || ren >= population) {
                            System.out.println("您输入了无效数值！");
                        } else {
                                population = population - ren;
                                bing = bing + ren;
                                System.out.println(name + "还剩" + population + "人");
                                System.out.println("您现在有" + bing + "兵力");
                        }
                        break;
                    case "释兵" : control.equals("释兵");
                        System.out.println("释放多少人归田？");
                        System.out.println("请输入数字");
                        ren = scanner.nextInt();
                        population = population + ren;
                        bing = bing - ren;
                        System.out.println(name + "现有" + population + "人");
                        System.out.println("您现有" + bing + "兵力");
                        break;
                    case "施恩" : control.equals("施恩");
                        System.out.println("放多少粮食？");
                        System.out.println("请输入数字");
                        ren = scanner.nextInt();
                        liang =liang - ren;
                        System.out.println("百姓欢呼雀跃，将军您太善良了");
                        break;
                    case "图图" : control.equals("图图");
                        System.out.println("图多少人");
                        System.out.println("请输入数字");
                        ren = scanner.nextInt();
                        if (ren <= 0) {
                            System.out.println("您输入了无效数值！");
                        } else {
                            if (ren <= population) {
                                population = population - ren;
                                System.out.println(name + "还剩" + population + "人");
                            } else {
                                population = 0;
                                System.out.println(name + "变成了鬼城");
                                System.exit(0);
                            }
                        }
                        break;
                    default :
                        System.out.println("您输入了无效字符串！");
                        break;
                }

                //随机事件1：流寇攻城
                if (RandomRun.may(0.1f)) {
                    int liukou = random.nextInt(bing*(random.nextInt(11)));
                    System.out.println("报告将军，有流寇来攻");
                    System.out.println("请选择处理方法：");
                    System.out.println("正面守城请输入A；交粮消灾请输入B");
                    control = scanner.next();
                    switch (control) {
                        case "A" : control.equals("A");
                            bing = bing - liukou / (random.nextInt(11));
                            if (bing > 0) {
                                liukou = 0;
                                System.out.println("启禀将军，我们战胜了流寇");
                                System.out.println("您还有" + bing + "人的兵力");
                            } else if (bing == 0) {
                                liukou = 0;
                                System.out.println("流寇势大，我军不敌，最终和流寇同归于尽，城邑士绅自治……");
                                System.exit(0);
                            } else {
                                liukou = 0;
                                System.out.println("流寇势大，我军不敌，最终我军全军覆没，流寇占领了城邑……");
                                System.exit(0);
                            }
                            break;
                        case "B" : control.equals("B");
                            int xiaozai = liukou * 10;
                            liang = liang - xiaozai;
                            System.out.println("我们给了流寇" + xiaozai + "车粮食，流寇走了");
                            liukou = 0;
                            xiaozai = 0;
                            break;
                        default :
                            System.out.println("您输入了无效字符串！");
                            break;
                    }
                }
                time = time + 1;
            }
        } else {
            System.out.println("您输入了无效字符串！");
        }
    }
}
