public class Inherit{
	public static void main(String[] args){
		//学生继承了Person类,而Person类由于有自定义的构造方法，因此没有默认的构造方法
		//所以必须在Student中定义构造方法
		Student student = new Student("Jack","男","1","bit");
		//调用Student.toString，而Student.toString是继承Person.toString
		//因此打印的是Person.toString
		System.out.println(student); 
	}
}

//学生在Person的基础上增加学号、学校
class Student extends Person{
	private String num;
	private String school;
	
	public Student(String name,String gender,String num,String school){
		//虽然Student继承了Person，但是由于name、gender是私有的，因此Student不能访问
		//this.name=name;   //error
		
		//直接赋值 ->能够访问到父类的属性
		//通过构造方法 -> 父类提供构造方法（带参数）
		//通过setter方法 ->能够访问到父类的setter方法
		super(name,gender);  //调用父类的构造方法
		this.num=num;
		this.school=school;
		System.out.println("这是子类的构造方法");
	}
	public String getNum(){
		return this.num;
	}
	public String getSchool(){
		return this.school;
	}
	
	//方法覆写
	public String toString(){
		return super.toString()+" 学号："+this.num+" 学校："+this.school;
	}
	
	// public String toString(){
		// return " 姓名："+this.getName()+" 性别："+this.getGender()+" 学号："+this.num+" 学校："+this.school;
	// }
	
}

//面向对象的一个特性——封装，对方封装好的部分进行扩展，
//开闭原则：对扩展开放，对修改关闭
class Person{
	private String name;
	private String gender;

	//构造方法
	public Person(String name,String gender){
		this.name=name;
		this.gender=gender;
		System.out.println("这是父类的构造方法");
	}
	
	//getter方法
	
	public String getName(){
		return this.name;
	}
	
	public String getGender(){
		return this.gender;
	}
	
	public String toString(){
		return " 姓名："+this.name+" 性别："+this.gender;
	}
}