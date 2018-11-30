package com.qqycc.Multiton;

/**
 * Author: qqy
 */
public class TestGender {
    public static void main(String[] args) {
        Gender male = Gender.getInstance(1);
        Gender female = Gender.getInstance(0);
        System.out.println(female == male);  //false
        System.out.println(female == Gender.getInstance(0));  //true

        if(female != null){
            String value = female.getValue();
            System.out.println(value);  //女
        }

        //访问枚举类的实例化对象，直接通过类名访问：类名.对象名
        Gender1 f =Gender1.FEMALE;
        Gender1 m =Gender1.MALE;
        System.out.println(f==Gender1.FEMALE);  //true
        System.out.println(m==Gender1.MALE);   //true
        System.out.println(f.getType());  //女
        System.out.println(m.getType());  //男

        //获取枚举类的所有实例化对象，通过类名.values( ) ;
        Gender1[] gender1s=Gender1.values();
        for(Gender1 gender1:gender1s){
            System.out.println("name:"+gender1.name());
        }

        //通过枚举的实例化对象名（常量名）获取对象  类名.valueOf
        Gender1 gender1=Gender1.valueOf("MALE");
        System.out.println("Type:"+gender1.getType()+"  "+gender1);
    }
}
