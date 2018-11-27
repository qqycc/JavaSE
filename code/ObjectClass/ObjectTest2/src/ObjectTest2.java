/**
 * Author: qqy
 */
public class ObjectTest2 {
    public static void main(String[] args) {
        Person per1=new Person("李四",20);
        Person per2=new Person("李四",20);
        System.out.println(per1.equals(per2));  //true
        System.out.println(per1.equals(new ObjectTest2())); //false
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    //如果不覆写equals则原equals(Object obj) 返回(this == obj)
    //相当于per1==per2
    public boolean equals(Object obj) {
        //判断obj是否是Person的实例
        if (!(obj instanceof Person)) {
            return false;
        }
        //obj是自己
        if(obj==this){
            return true;
        }
        //同一个类的不同对象
        //因为Object类没有name、age属性
        //向下转型，取得Person类的name、age的属性
        Person per = (Person) obj;
        //分别比较name,age
        return per.name.equals(this.name)&&(per.age==this.age);
    }
}