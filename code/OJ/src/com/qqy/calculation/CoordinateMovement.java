package com.qqy.calculation;

import java.util.Scanner;

/**
 * 坐标移动
 * A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0，0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * Author:qqy
 */
public class CoordinateMovement {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String[] array = in.nextLine().split(";");
            int x = 0;
            int y = 0;
            for (String str : array) {
                try {
                    int num = Integer.parseInt(str.substring(1));
                    if (num < 100 && num >= 0) {
                        if (str.charAt(0)==('A')) {
                            x -= num;
                        }
                        if (str.charAt(0)==('D')) {
                            x += num;
                        }
                        if (str.charAt(0)==('S')) {
                            y -= num;
                        }
                        if (str.charAt(0)==('W')) {
                            y += num;
                        }
                    }
                }catch(Exception e){
                    continue;
                }
            }
            System.out.println(x + "," + y);
        }

    }

}
