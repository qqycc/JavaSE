package com.qqy.calculation;

import java.util.Scanner;

/**
 * 计算学分绩点
 * 90-100 4.0 85-89 3.7 82-84 3.3 78-81 3.0 75-77 2.7
 * 72-74 2.3 68-71 2.0 64-67 1.5 60-63 1.0 60以下0
 * Author:qqy
 */
public class GradePoint {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int num = Integer.parseInt(in.nextLine());
            String[] credit = in.nextLine().split(" ");
            String[] score = in.nextLine().split(" ");
            cal(num, credit, score);
        }
    }

    public static void cal(int num, String[] credit, String[] score) {
        double grade,sum=0.0;
        int sumgrade=0;
        boolean flag = true;

        for(int i=0;i<num;i++) {
            sumgrade+=Integer.parseInt(credit[i]);
        }

        for (int i = 0; i < num; i++) {
            int temp = Integer.parseInt(score[i]);
            if (temp <= 100 && temp >= 90) {
                grade = 4.0;
            }else if (temp <= 89 && temp >= 85) {
                grade = 3.7;
            }else if (temp <= 84 && temp >= 82) {
                grade = 3.3;
            }else if (temp <= 81 && temp >= 78) {
                grade = 3.0;
            }else if (temp <= 77 && temp >= 75) {
                grade = 2.7;
            }else if (temp <= 74 && temp >= 72) {
                grade = 2.3;
            }else if (temp <= 71 && temp >= 68) {
                grade = 2.0;
            }else if (temp <= 67 && temp >= 64) {
                grade = 1.5;
            }else if (temp <= 63 && temp >= 60) {
                grade = 1.0;
            }else {
                grade=0;
            }
            sum+=Double.parseDouble(credit[i])*grade;
        }

        System.out.printf("%.2f",sum/sumgrade);
    }
}

