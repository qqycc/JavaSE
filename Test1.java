class Person{
	public void fun(){
		System.out.println("人类");
	}
}

class Student extends Person{
	public void fun(){
		System.out.println("学生");
	}
}

class Worker extends Person{
	public void fun(){
		System.out.println("工人");
	}
}

public class Test1{
	public static void main(String[] args){
		Test1(new Person());
		//向上转型
		Test1(new Student());
		//向上转型
		Test1(new Worker());
	}
	public static void Test1(Person per){
		per.fun();
	}
}