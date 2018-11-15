public class AbstractClass{
	public static void main(String[] args){
		Person per = new Student();
		per.fun();
		new Student();
	}
}

abstract class Person{
	private String name;
	//抽象类的构造方法
	public Person(){
		System.out.println("1.***************");
	}
	public String getName(){
		return name;
	}
	//抽象方法
	public abstract void fun();
}

//子类覆写抽象类
class Student extends Person{
	////普通类的构造方法
	public Student(){
		System.out.println("2.###############");
	}
	public void fun(){
		System.out.println("子类继承父类");
	}
}