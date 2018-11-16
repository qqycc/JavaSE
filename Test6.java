//instanceof
public class Test6{
	public static void main(String[] args){
		Person per=new Person();
		//per可以由Person类创建，返回true
		System.out.println(per instanceof Person);
		//如果per不能由Student创建
		if(!(per instanceof Student)){
			per=new Student();
			System.out.println(per instanceof Student);
		}
	}
}

class Person{
	public void fun(){
		System.out.println("父类");
	}
}

class Student extends Person{
	public void fun(){
		System.out.println("子类");
	}
}
