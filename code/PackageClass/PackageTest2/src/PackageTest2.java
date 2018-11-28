/**
 * Author: qqy
 */
public class PackageTest2 {
    public static void main(String[] args) {
        //手工装箱
        Integer i1 = new Integer(10);  //10->装箱->i1
        //手工拆箱
        int result = i1.intValue();    //i1->拆箱->10
        System.out.println(result+10);   //20

        //JDK1.5之后
        //自动装箱
        Object i2=10;  //对10new一个Integer对象，赋给i2
        //自动拆箱
        int result2 =(int)i2;
        System.out.println(result2);    //10
        //i2.intValue()后进行运算
        System.out.println(++result2*5);  //55

        System.out.println(i1==i2);  //false  比较的是i1、i2的地址
        System.out.println(i1.equals(i2));  //true  比较的是i1、i2的值

        Integer j1=Integer.valueOf(200);
        Integer k1=Integer.valueOf(200);
        System.out.println(j1==k1);   //false

        Integer j=Integer.valueOf(126);
        Integer k=Integer.valueOf(126);
        System.out.println(j==k);    //true
    }
}
