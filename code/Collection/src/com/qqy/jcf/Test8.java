package com.qqy.jcf;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet
 * Author:qqy
 */
public class Test8 {
    public static void main(String[] args) {
        //1.TreeSet无参数构造方法，元素排序使用元素的排序策略
        //2.TreeSet有参数，传递比较器的实例化对象，采用自定义的比较方法

        //1.
        Set<String> set1 = new TreeSet<>();

        //2.
        //比较常用方法2，灵活，比较策略容易替换
        Set<String> set = new TreeSet<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        //倒序
                        return o1.compareTo(o2)*-1;
                    }
                }
          //Lambda表达式
//        (o1, o2) -> o1.compareTo(o2) * -1
        );

        set.add("Java");
        set.add("C++");
        set.add("PHP");
        set.add("Python");
        set.add("C");

        //遍历
        Iterator<String> iterator = set.iterator();
        //foreach
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
