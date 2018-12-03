package com.qqy.exception;

/**
 * Author: qqy
 */
public class Test1 {
    public static void main(String[] args) {
        //1.通过编码进行校验
        //args.length==2
        //args[i]是否由数字组成
        //args[1]是否为0

        //异常处理
        System.out.println("1.计算开始");
        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            System.out.println("2.计算：" + x / y);
        } catch (ArithmeticException e) {
            System.out.println("数组越界");
        } catch (NumberFormatException e) {
            System.out.println("输入值不是数字");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("分母不能为0");
        } finally {
            System.out.println("Finally不管是否产生异常，都执行此语句");
        }
        System.out.println("[3].数学计算结束后");
    }
}
