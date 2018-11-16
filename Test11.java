//方法覆写
public class Test11{
	public static void main(String [] args){
		Person person=new Person();
		person.print();
		
		Student student=new Student();
		//就近原则
		System.out.println(student.getName());
		student.print();
	}
}

class Person{
	public String name="Jack";
	
	//成员方法
	public void print(){
		System.out.println("这是Person的print方法");
	}
	
	private void hello(){
		System.out.println("这是Person的hello方法");
	}
	
}

class Student extends Person{
	private String name="Tom";
	
	//default——包私有
	//public>protected>[default]>private
	public void print(){
		super.print();
		System.out.println("这是Student的print方法");
	}
	
	//此时，子类的hello方法并不是方法覆写
	//因为父类中的hello方法是私有的，子类已经看不见父类的hello方法
	//因此，这只是子类的普通方法，与父类的方法没有任何关系
	public void hello(){
		System.out.println("这是Student的hello方法");
	}
	
	public String getName(){
		return super.name;
	}
}