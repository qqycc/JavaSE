public class Test5{
	public static void main(String[] args){
		//向上转型
		
		//父类  父类引用 = new 子类( )；
		Person per=new Student();
		per.fun();
		System.out.println(per.getPersonInfo());
		//Student给的是子类对象，但变量类型是Person
		//使用时，将一个Student变量当Person来用
		//我们所看到的属性、方法，是Person中定义的
		//Person中没有定义getStudentInfo()，因此下行代码错误
		//System.out.println(per.getStudentInfo());  //error
		
		//向下转型
		
		//子类  子类引用 = （子类）父类实例；
		Student stu=(Student)per;  
		//Student stu=(Student)new Person();  //编译通过，无法运行（CCE）
		stu.fun();
		System.out.println(stu.getPersonInfo());
		System.out.println(stu.getStudentInfo()); 
	}
}

class Person{
	public void fun(){
		System.out.println("父类");
	}
	
	public String getPersonInfo(){
		return "Person info";
	}
}

class Student extends Person{
	public void fun(){
		System.out.println("子类");
	}
	
	public String getStudentInfo(){
		return "Student info";
	}
}