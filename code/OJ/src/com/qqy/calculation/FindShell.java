package com.qqy.calculation;


import java.util.Scanner;

/**
 * 初始位置x_0。当前位置x，只能移动到4*x+3或者8*x+7。只能移动最多100_000次。
 * 贝壳总生长在能被1_000_000_007整除的位置（比如：位置0，位置1，000，000，007，位置2，000，000，014等）。
 * 计算最少需要移动多少次就能吃到贝壳。
 *
 * 输入一个初始位置x_0，范围在1到1，000，000，006
 * 输出小易最少需要移动次数，如果使用次数使用完还未找到贝壳，输出-1
 *
 * 思路：
 *      循环计算4*x+3与8*x+7结合的移动，能够在100_000次内获得1_000_000_007的倍数。
 *      4x + 3等于做了两次2x + 1， 8x + 7做了三次。
 *      统计做了多少次2x + 1，把次数分解成若干个3与2的和，3的个数加上2的个数最小
 * Author:qqy
 */
public class FindShell {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){
            int x0=in.nextInt();
            int count = 0;
            //count<=300000 -> 假设最坏情况为全采用8x+7
            while (x0 != 0 && count <= 300000) {
                //多少次2x+1能到1000000007
                x0 = ((x0 << 1) + 1) % 1000000007;
                count++;
            }
            //下一行等价于int res = count%3 == 0 ? count/3 : count/3 + 1
            int res = (count + 2) / 3;
            System.out.println(res > 100000 ? -1 : res);
        }
    }
//    public static void main(String[] args){
//        Scanner in=new Scanner(System.in);
//        while(in.hasNextLong()){
//            long x=in.nextLong();
//            System.out.println(find(x));
//        }
//    }
//
//    public static long find(long x){
//        int count=0;
//        int i=2;
//        List<Long> list=new ArrayList<>();
//        while(count<=100000) {
//            count++;
//            list.add(4*x+3);
//            list.add(8*x+7);
//            if(list.get(0)%1000000007==0||list.get(1)%1000000007==0){
//                return count;
//            }
//            list.add(i,list.get(i-2)+list.get(i-1));
//            long res=list.get(i);
//            i++;
//            if(res%1000000007==0){
//                return count;
//            }
//        }
//        return -1;
//    }

}
