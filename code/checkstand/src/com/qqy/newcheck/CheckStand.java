package com.qqy.newcheck;

import com.qqy.newcheck.impl.GoodsCenterImpl;
import com.qqy.newcheck.impl.OrderCenterImpl;

import java.util.Scanner;

/**
 * 字符界面收银台(优化版)
 * Author:qqy
 */
public class CheckStand {
    private static Scanner scanner = new Scanner(System.in);

    //商品中心管理
    private static GoodsCenter goodsCenter = new GoodsCenterImpl();

    //订单中心管理，先实例化商品中心，因为订单中心的实例化需要传一个商品中心的实例化对象
    private static OrderCenter orderCenter = new OrderCenterImpl(goodsCenter);

    private static Integer orderId = 0;


    public static void helpInfo() {
        System.out.println("*************** 欢迎使用简易收银台 *****************");
        System.out.println(" [U] 使用 [S] 设置 [P] 保存所有信息 [A] 关于 [Q] 退出 ");
        System.out.println("            输入:  U S P A Q 进入操作               ");
        System.out.println("*************************************************");
    }

    public static void quit() {
        System.out.println("*************************************************");
        System.out.println("                欢迎使用，下次再见                 ");
        System.out.println("*************************************************");
        System.exit(0);
    }

    public static void about() {
        System.out.println("******************** 关于 ***********************");
        System.out.println("        名称：简易收银台                          ");
        System.out.println("        功能：基于字符界面的收银台操作系统          ");
        System.out.println("        作者: qqy                               ");
        System.out.println("        版本: v1.0.0                          ");
        System.out.println("        意见反馈：*********@qq.com            ");
        System.out.println("*************************************************");
    }

    public static void usageInfo() {
        System.out.println("******************* 买单功能 ********************");
        System.out.println("  [S] 查看当前订单 [U] 查看所有订单 [A] 下单 [C]清空   ");
        System.out.println("     [D] 取消 [L] 浏览商品 [P] 保存订单 [R] 返回   ");
        System.out.println("          输入:  S U A C D L P R 进入操作              ");
        System.out.println("*************************************************");
    }

    public static void settingInfo() {
        System.out.println("******************* 设置功能 ********************");
        System.out.println("           [S] 查看 [A] 上架 [D] 下架        ");
        System.out.println("         [U] 修改 [P] 保存商品 [R] 返回   ");
        System.out.println("          输入:  S A D U P R 进入操作              ");
        System.out.println("*************************************************");
    }

    public static void usage() {
        //创建订单，并且添加到订单管理中心
        Order order = new Order(String.valueOf(++orderId));
        orderCenter.addOrder(order);

        usageInfo();
        System.out.println(orderCenter.orderTable(order.getOrderId()));
        while (true) {
            String line = scanner.nextLine();
            switch (line.trim().toUpperCase()) {
                case "S": {
                    System.out.println(orderCenter.orderTable(order.getOrderId()));
                    break;
                }
                case "A": {
                    System.out.println("请输入下单信息[编号 数量]（如下格式：1  2 ）:");
                    String value = scanner.nextLine().trim();
                    String[] infoArray = value.split(" ");
                    if (infoArray.length == 2) {
                        Goods goods = goodsCenter.getGoods(infoArray[0].trim());
                        if (goods != null) {
                            order.add(infoArray[0].trim(), Integer.parseInt(infoArray[1].trim()));
                            System.out.println(orderCenter.orderTable(order.getOrderId()));
                            break;
                        }
                    }
                    if (!(goodsCenter.isExistGoods(infoArray[0]))) {
                        System.out.println("!商品还未上架，请重新选择商品");
                    }
                    System.out.println("请按照格式要求输入信息");
                    break;
                }
                case "D": {
                    System.out.println("请输入取消信息[编号 数量]（如下格式：1  2 ）:");
                    String value = scanner.nextLine().trim();
                    String[] infoArray = value.split(" ");
                    if (infoArray.length == 2) {
                        Goods goods = goodsCenter.getGoods(infoArray[0].trim());
                        if (goods != null) {
                            order.cancel(infoArray[0], Integer.parseInt(infoArray[1].trim()));
                            System.out.println(orderCenter.orderTable(order.getOrderId()));
                            break;
                        }
                    }
                    System.out.println("请按照格式要求输入信息");
                    break;
                }
                case "U": {
                    System.out.println(orderCenter.loadOrders());
                    break;
                }
                case "L": {
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "C":{
                    order.clear();
                    break;
                }
                case "P": {
                    //订单信息保存
                    orderCenter.storeOrders();
                    break;
                }
                case "R": {
                    return;
                }
                default: {
                    usageInfo();
                }
            }
        }
    }

    public static void setting() {
        settingInfo();
        while (true) {
            String line = scanner.nextLine();
            switch (line.toUpperCase()) {
                case "S": {
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "A": {
                    System.out.println("请输入上架商品信息（如下格式：1 餐巾纸 1.4）:");
                    Goods goods = readGoods(true);
                    if (goods == null) {
                        System.out.println("!请按照格式要求输入信息");
                        break;
                    }
                    if (goodsCenter.isExistGoods(goods.getId())) {
                        System.out.println("!上架商品已经存在，请重新上架");
                    } else {
                        goodsCenter.addGoods(goods);
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "D": {
                    System.out.println("请输入下架商品信息编号（如下格式：1 ）:");
                    Goods goods = readGoods(false);
                    if (goods == null) {
                        System.out.println("!请输入存在的商品");
                        break;
                    }else{
                        goodsCenter.removeGoods(goods.getId());
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "U": {
                    System.out.println("请输入修改商品信息（如下格式：1 餐巾纸 1.4 ）");
                    Goods goods = readGoods(false);
                    if (goods == null) {
                        System.out.println("!请输入存在的商品");
                        break;
                    }else {settingInfo();
                        goodsCenter.updateGoods(goods);
                    }
                    System.out.println(goodsCenter.listGoods());
                    break;
                }
                case "P": {
                    //商品信息保存
                    goodsCenter.store();
                    break;
                }
                case "R": {
                    return;
                }
                default: {
                    settingInfo();
                }
            }
        }
    }

    public static Goods readGoods(boolean flag) {
        String value = scanner.nextLine();
        String[] infoArray = value.split(" ");
        if (infoArray.length == 3 || infoArray.length == 1) {
            if (infoArray.length == 3) {
                if (!(CheckStand.isNumber(infoArray[0].trim())&&CheckStand.isNumber(infoArray[2].trim()))){
                    System.out.println("！商品编号或单价有误，请重新输入");
                }else {
                    if (!flag) {
                        if (goodsCenter.isExistGoods(infoArray[0])) {
                            Goods goods = new Goods(infoArray[0], infoArray[1], Double.parseDouble(infoArray[2]));
                            return goods;
                        }
                    }
                    else{
                        Goods goods = new Goods(infoArray[0], infoArray[1], Double.parseDouble(infoArray[2]));
                        return goods;
                    }
                }
            }
            //infoArray.length == 1
            if (!(CheckStand.isNumber(infoArray[0].trim()))){
                System.out.println("！商品编号有误，请重新输入");
            }else{
                if(goodsCenter.isExistGoods(infoArray[0])){
                    Goods goods = new Goods(infoArray[0], "", 0.0D);
                    return goods;
                }
            }
        }
        return null;
    }

    public static boolean isNumber(String str) {
        for (int i = str.length(); --i >= 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        helpInfo();
        goodsCenter.load();
        //每次打开项目，清空订单记录
        //新下单后存储信息后，才可查看所有订单。
        orderCenter.cleanOrders();
        while (true) {
            String line = scanner.nextLine();
            switch (line.trim().toUpperCase()) {
                case "U":
                    usage();
                    helpInfo();
                    break;
                case "S":
                    setting();
                    helpInfo();
                    break;
                case "A":
                    about();
                    break;
                case "P":
                    goodsCenter.store();
                    orderCenter.storeOrders();
                    break;
                case "Q":
                    quit();
                    break;
                default:
                    helpInfo();
            }
        }
    }
}
