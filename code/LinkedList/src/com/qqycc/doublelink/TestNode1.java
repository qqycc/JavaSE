package com.qqycc.doublelink;

/**
 * Author: qqy
 */
public class TestNode1 {
    public static void main(String[] args) {
        ILink link = new LinkImpl();
        link.add("火车头");
        link.add("车厢一");
        link.add("车厢二");
        link.add("火车尾");
        System.out.println(link.contains("车厢二"));  //2
        System.out.println(link.contains("车厢三"));  //-1
//        link.clear();
        System.out.println(link.size());
        System.out.println(link.get(3));  //火车尾
        System.out.println(link.set(2,"滴滴滴"));  //车厢二
        link.printLink();
        System.out.println(link.remove("滴滴滴"));
        link.printLink();

    }
}
