package com.qqy.jcf;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator的前后遍历
 * Author:qqy
 */
public class Test5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        //list.listIterator() -> 返回列表中的列表迭代器（ArrayList的方法）
        ListIterator<String> iterator = list.listIterator();
        //  A  B  C  D
        //^             (迭代器的初始位置)

        //A -> B -> C -> D ->
        System.out.println("从前往后迭代：");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" -> ");
        }
        System.out.println();

        //当游标在后面时，才能从后向前遍历
        //D <- C <- B <- A <-
        System.out.println("从后往前：");
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous());
            System.out.print(" <- ");
        }
    }
}
