package com.qqy.calculation;

import java.text.DecimalFormat;
import java.util.Scanner;

import static java.lang.Math.PI;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * 根据坐标计算球的半径与体积
 * Author:qqy
 */
public class Sphere {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){
            int x0=in.nextInt();
            int y0=in.nextInt();
            int z0=in.nextInt();
            int x1=in.nextInt();
            int y1=in.nextInt();
            int z1=in.nextInt();

            double r=sqrt(pow(x1-x0,2)+pow(y1-y0,2)+pow(z1-z0,2));
            double area=4*r*r*r*PI/3;

            DecimalFormat f = new DecimalFormat("#.000");
            System.out.println(f.format(r)+" "+f.format(area));

        }
    }
}
