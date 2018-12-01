/**
 * Author: qqy
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckStand {

    static java.util.Scanner scanner = new java.util.Scanner(System.in);

    static Order custom1 = new Order();

    static int count = 0;
    static int counta = 0;
    static int isError = 0;
    static int orderNumber = 1;
    static double sum = 0.00;
    static int goodsNum = 0;
    static int amount = 0;
    static int minusAmount = 0;
    static int putawayNum = 0;
    static double putawayPrice = 0;
    static String putawayName = null;

    static String next, next2, next3;

    public static void main(String[] args) {
        while (true) {
            next = first();
            //使用
            if (next.equalsIgnoreCase("U")) {
                sum = 0.00;
                counta = 0;
                custom1.detailsInit(Order.goodsCenter);
                firstUse();
                orderNumber++;
                continue;
                //设置
            } else if (next.equalsIgnoreCase("S")) {
                firstSetUp();
                continue;
            } else if (next.equalsIgnoreCase("Q")) {
                custom1.quitMenu();
                System.exit(-1);
            }
        }
    }

    public static void firstUse() {
        while (true) {
            isError = 0;
            next2 = use();
            if (next2.equalsIgnoreCase("A")) {
                add();
                counta = 1;
                continue;
            } else if (next2.equalsIgnoreCase("S")) {
                custom1.details(orderNumber, sum, Order.goodsCenter);
                continue;
            } else if (next2.equalsIgnoreCase("D")) {
                reduce();
                continue;
            } else if (next2.equalsIgnoreCase("L")) {
                custom1.commodityList(Order.goods);
                continue;
            }
            if (next2.equalsIgnoreCase("Q")) {
                break;
            }
        }
    }

    public static void firstSetUp() {
        while (true) {
            isError = 0;
            next3 = setUp();
            if (next3.equalsIgnoreCase("A")) {
                putaway();
                count = 1;
                continue;
            } else if (next3.equalsIgnoreCase("S")) {
                continue;
            } else if (next3.equalsIgnoreCase("D")) {
                soldOut();
                continue;
            } else if (next3.equalsIgnoreCase("U")) {
                alter();
                continue;
            } else if (next3.equalsIgnoreCase("Q")) {
                break;
            }
        }
    }

    //第一层菜单
    public static String first() {
        custom1.enterMenu();
        String letter;
        while (true) {
            letter = scanner.nextLine().trim();
            if (letter.equalsIgnoreCase("U")) {
                custom1.payMenu();
                if (count == 0) {
                    custom1.commodityListInit(Order.goods);
                }
                custom1.commodityList(Order.goods);
                break;
            } else if (letter.equalsIgnoreCase("S")) {
                custom1.setUpMenu();
                break;
            } else if (letter.equalsIgnoreCase("A")) {
                custom1.aboutMenu();
                continue;
            } else if (letter.equalsIgnoreCase("Q")) {
                break;
            } else {
                System.out.println("您的输入有误，请重新输入：");
            }
        }
        return letter;
    }

    //进入使用界面
    public static String use() {
        String letter1;
        while (true) {
            isError = 0;
            letter1 = scanner.nextLine().trim();
            if (letter1.equalsIgnoreCase("S")) {
                break;
            } else if (letter1.equalsIgnoreCase("A")) {
                System.out.println("请输入下单信息[编号 数量]（如下格式：1 2）");
                break;
            } else if (letter1.equalsIgnoreCase("D")) {
                System.out.println("请输入取消信息[编号 数量]（如下格式：1 2）");
                break;
            } else if (letter1.equalsIgnoreCase("L")) {
                break;
            } else if (letter1.equalsIgnoreCase("Q")) {
                break;
            } else {
                System.out.println("您的输入有误，请重新输入：");
                continue;
            }
        }
        return letter1;
    }

    //进入设置界面
    public static String setUp() {
        String letter;
        while (true) {
            letter = scanner.nextLine().trim();
            //查看
            if (count == 0) {
                custom1.commodityListInit(Order.goods);
            }
            if (letter.equalsIgnoreCase("S")) {
                custom1.commodityList(Order.goods);
                break;
                //上架
            } else if (letter.equalsIgnoreCase("A")) {
                System.out.println("请输入上架商品信息（如下格式：1 餐巾纸 1.4）");
                break;
                //下架
            } else if (letter.equalsIgnoreCase("D")) {
                System.out.println("请输入下架商品信息（如下格式：1 ）");
                break;
                //修改
            } else if (letter.equalsIgnoreCase("U")) {
                System.out.println("请输入修改商品信息（如下格式：1 餐巾纸 1.4）");
                break;
            }
            //退出
            else if (letter.equalsIgnoreCase("Q")) {
                break;
            } else {
                System.out.println("您的输入有误，请重新输入：");
                continue;
            }
        }
        return letter;
    }

    //上架
    public static void putaway() {
        if (count == 0) {
            custom1.commodityListInit(Order.goods);
        }
        while (true) {
            input();
            //若编号大于10，提示错误
            if (putawayNum > 10) {
                System.out.println("编号已超出范围！请重新上架！");
                continue;
            }
            if (Order.goods[putawayNum - 1].name.equals("--[未上架]") == false) {
                System.out.println("您挑选的商品已上架，请重新上架！");
                continue;
            }
            break;
        }
        if(isError==0) {
            Order.goods[putawayNum - 1] = new Goods(putawayNum, putawayName, putawayPrice);
            custom1.commodityList(Order.goods);
        }
    }

    //下架
    public static void soldOut() {
        int putawayNum = 0;
        while (true) {
            String letter = scanner.nextLine().trim();
            //将用户输入赋给putawayNum
            try {
                putawayNum = Integer.parseInt(letter);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            //若编号大于10，提示错误
            if (putawayNum > 10) {
                System.out.println("编号已超出范围！请重新下架！");
                continue;
            }
            if (Order.goods[putawayNum - 1].name.equals("--[未上架]")) {
                System.out.println("您挑选的商品还未上架，暂不能下架！");
                continue;
            }
            break;
        }
        Order.goods[putawayNum - 1] = new Goods(putawayNum, "--[未上架]", 0.0);
        custom1.commodityList(Order.goods);
    }

    // 修改
    public static void alter() {
        while (true) {
            input();
            //若编号大于10，提示错误
            if (putawayNum > 10) {
                System.out.println("编号已超出范围！请重新上架！");
                continue;
            }
            if (Order.goods[putawayNum - 1].name.equals("--[未上架]")) {
                System.out.println("您挑选的商品还未上架，暂不能修改！");
                continue;
            }
            break;
        }
        if(isError==0){
            Order.goods[putawayNum - 1] = new Goods(putawayNum, putawayName, putawayPrice);
            custom1.commodityList(Order.goods);
        }
    }

    // 下单
    public static void add() {
        while (true) {
            input1();
            //若编号大于10，提示错误
            if (goodsNum > 10) {
                System.out.println("编号已超出范围！请重新下单！");
                continue;
            }
            if (Order.goods[goodsNum - 1].name.equals("--[未上架]")) {
                System.out.println("您挑选的商品还未上架，请重新挑选！");
                continue;
            }
            break;
        }
        if (isError == 0) {
            String name = Order.goods[goodsNum - 1].name;
            double price = Order.goods[goodsNum - 1].price;
            if (Order.goodsCenter[goodsNum - 1].amount != 0) {
                amount += Order.goodsCenter[goodsNum - 1].amount;
                sum = price * amount;
            } else {
                sum += price * amount;
            }
            Order.goodsCenter[goodsNum - 1] = new GoodsCenter(goodsNum, name, amount, price);
            custom1.details(orderNumber, sum, Order.goodsCenter);
        }

    }

    // 取消
    public static void reduce() {
        while (true) {
            input1();
            minusAmount=amount;
            //若编号大于10，提示错误
            if (goodsNum > 10) {
                System.out.println("编号已超出范围！请重新取消！");
                continue;
            }
            if (Order.goodsCenter[goodsNum - 1].amount == 0) {
                System.out.println("您还未挑选过此商品，请重新取消！");
                continue;
            }

            if (Order.goodsCenter[goodsNum - 1].amount < minusAmount) {
                System.out.println("该商品的取消数量超出已下单数量，请重新取消！");
                continue;
            }
            if (minusAmount < 0) {
                System.out.println("您的输入有误，请重新取消！");
                continue;
            }
            break;
        }

        if (isError == 0) {
            String name = Order.goods[goodsNum - 1].name;
            double price = Order.goods[goodsNum - 1].price;
            Order.goodsCenter[goodsNum - 1].amount -= minusAmount;
            Order.goodsCenter[goodsNum - 1] = new GoodsCenter(goodsNum, name, Order.goodsCenter[goodsNum - 1].amount, price);
            sum = sum + Order.goodsCenter[goodsNum - 1].price * amount - (amount + minusAmount) * Order.goodsCenter[goodsNum - 1].price;
            custom1.details(orderNumber, sum, Order.goodsCenter);
        }
    }

    public static void input() {
        String[] str;
        String letter = scanner.nextLine().trim();
        //将字符串拆开
        str = letter.split(" ", 3);
        //将用户输入的第一部分赋给putawayNum
        try {
            putawayNum = Integer.parseInt(str[0].trim());
            //将用户输入的第二部分赋给putawayName
            putawayName = str[1].trim();
            //将用户输入的第三部分赋给putawayPrice
            putawayPrice = Double.valueOf(str[2].trim());
        } catch (NumberFormatException e) {
            System.out.println("您没有按要求输入！");
            isError = 1;
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("您没有按要求输入！");
            isError = 1;
        }
    }

    public static void input1(){
        String[] str;
        String letter = scanner.nextLine();
        try {
            //将字符串拆开
            str = letter.trim().split("", 2);
            //将用户输入的第一部分赋给orderNum
            goodsNum = Integer.parseInt(str[0].trim());
            //将用户输入的第二部分赋给amount
            amount = Integer.parseInt(str[1].trim());
        } catch (NumberFormatException e) {
            System.out.println("您没有按要求输入！");
            isError = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("您没有按要求输入！");
            isError = 1;
        }
    }
}

class Order {
    static Goods[] goods = new Goods[10];
    static GoodsCenter[] goodsCenter = new GoodsCenter[10];

    public void enterMenu() {
        System.out.println("***************欢迎使用简易收银台***************");
        System.out.println("       [U]使用  [S]设置  [A]关于  [Q]退出       ");
        System.out.println("            输入：U S A Q  进入操作             ");
        System.out.println("************************************************");
    }

    public void quitMenu() {
        System.out.println("************************************************");
        System.out.println("                欢迎使用，下次再见              ");
        System.out.println("************************************************");
    }

    public void aboutMenu() {
        System.out.println("**********************关于**********************");
        System.out.println("        名称：简易收银台                        ");
        System.out.println("        功能：基于字符界面的收银台操作系统      ");
        System.out.println("        作者：qqycc                             ");
        System.out.println("        版本：v0.0.1                            ");
        System.out.println("        意见反馈：*********@qq.com              ");
        System.out.println("************************************************");
    }

    public void setUpMenu() {
        System.out.println("********************设置功能********************");
        System.out.println("   [S]查看  [A]上架  [D]下架  [U]修改  [Q]退出  ");
        System.out.println("            输入：S A D U Q  进入操作           ");
        System.out.println("************************************************");
    }

    public void payMenu() {
        System.out.println("********************买单功能********************");
        System.out.println("   [S]查看  [A]下单  [D]取消  [L]浏览  [Q]退出  ");
        System.out.println("            输入：S A D L Q  进入操作           ");
        System.out.println("************************************************");
    }

    public void commodityListInit(Goods[] goods) {
        for (int i = 0; i < goods.length; i++) {
            goods[i] = new Goods(i + 1, "--[未上架]", 0.0);
        }
    }

    public void commodityList(Goods[] goods) {
        System.out.println("******************* 商品清单 *******************");
        System.out.println("\t   " + "编号" + "\t        " + "产品名称" + "\t         " + "单价");
        for (int i = 0; i < goods.length; i++) {
            goods[i].printList();
        }
        System.out.println("************************************************");
    }

    public void detailsInit(GoodsCenter[] goodsCenter) {
        for (int i = 0; i < goodsCenter.length; i++) {
            goodsCenter[i] = new GoodsCenter(0, "", 0, 0.0);
        }
    }

    public void details(int orderNumber, double sum, GoodsCenter[] goodsCenter) {
        System.out.println("=======================================");
        System.out.println("编号：" + orderNumber);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("打印时间：" + df.format(new Date()));// new Date()为获取当前系统时间
        System.out.println("=======================================");
        System.out.println("编号\t名称\t数量\t单价");
        for (int i = 0; i < goodsCenter.length; i++) {
            if (goodsCenter[i].serialNumber == 0) {
                continue;
            }
            goodsCenter[i].printList();
        }
        System.out.println("=======================================");
        System.out.println("总价：" + String.format("%.2f", sum));
        System.out.println("=======================================");
    }
}

class GoodsCenter extends Goods {
    int amount;

    public GoodsCenter(int serialNumber, String name, int amount, double price) {
        super(serialNumber, name, price);
        this.amount = amount;
    }

    public void printList() {
        System.out.println(this.serialNumber + "\t" + this.name + "\t" + this.amount + "\t" + this.price);
    }
}

class Goods {
    int serialNumber;
    String name;
    double price;

    public Goods(int serialNumber, String name, double price) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
    }

    public void printList() {
        System.out.println("\t   " + this.serialNumber + "\t        " + this.name + "\t             " + this.price);
    }
}
