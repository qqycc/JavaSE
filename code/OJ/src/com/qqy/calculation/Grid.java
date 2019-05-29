package com.qqy.calculation;

import java.util.Scanner;

/**
 * 一个W*H的网格，行编号为0~H-1，列编号为0~W-1。
 * 每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
 * 格子坐标（×1，y1），（×2，y2）的欧几里得距离为：（（×1-×2）*（×1-×2）+（y1-y2）*（y1-y2））的算术平方根
 * 最多可以放多少块蛋糕在网格盒子里？
 * Author:qqy
 */
public class Grid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int a = m / 4;// 横坐标除4取整
            int b = m % 4;// 横坐标取余
            int c = n / 4;// 纵坐标除4取整
            int d = n % 4;// 纵坐标取余
            int sum12 = 0;//前边两行放的蛋糕数量一样
            int sum34 = 0;//3，4行蛋糕数量也一样
            int sum = 0;//最后的总的蛋糕数量
            int sum1234 = 0;//前边四行的蛋糕数量
            // 先得出前四行分别的数目，首先前面两行一样，后边两行一样
            // 首先是1，2两行放的蛋糕都一样
            if (d == 1) {
                sum12 = c * 2 + 1;
            } else if (d == 0) {
                sum12 = (c - 1) * 2 + 2;
            } else {
                sum12 = c * 2 + 2;
            }
            // 然后是3，4两行，放的蛋糕都一样
            sum34 = n - sum12;
            // 前面四行一共放蛋糕数量如下
            sum1234 = 2 * (sum12 + sum34);
            // 前边计算了前面四行分别的数目，接下来是往纵看，
            if (b == 1) {
                sum = a * sum1234 + sum12;
            } else if (b == 2) {
                sum = a * sum1234 + 2 * sum12;
            } else if (b == 3) {
                sum = a * sum1234 + sum12 * 2 + sum34;
            } else {
                sum = a * sum1234;
            }
            System.out.println(sum);

        }
    }
}
