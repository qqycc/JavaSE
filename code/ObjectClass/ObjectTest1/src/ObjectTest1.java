import javax.jws.soap.SOAPBinding;
import java.util.logging.SocketHandler;

/**
 * Author: qqy
 */
public class ObjectTest1 {
    public static void main(String[] args) {
        fun(new Person("张三",25));   //覆写前：Person@1540e19d  覆写后：姓名：张三  年龄：25
        fun("hello");   //hello
    }
    public static void fun(Object obj) {
        System.out.println(obj.toString());
        //等同于下行代码
        System.out.println(obj);
    }
}

class Person {
    private String name;
    private int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    //覆写toString()
    public String toString() {
        return "姓名："+name+"  年龄："+age;
    }
}
