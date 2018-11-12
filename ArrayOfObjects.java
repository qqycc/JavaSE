public class ArrayOfObjects{
	//类方法
	public static void printArray(Person[] persons){
		for(int i=0;i<persons.length;i++){
			System.out.println(persons[i]);
		}
	}
	
	public static void main(String[] args){
		Person person = new Person(1,"唐僧");//email=null; phone=null;
		System.out.println(person);//person.toString(); ——继承自Object
		
		String s="Bonjour";  //引用类型
		System.out.println(s);  //s.toString(); ——继承
		
		//动态初始化
		Person[] persons = new Person[3];
		persons[0]=new Person(1,"Jack");
		persons[1]=new Person(2,"Tom","tom@gmail.com");
		persons[2]=new Person(3,"Alice","alice@gmail.com","15265478955");
		ArrayOfObjects.printArray(persons);
		
		//静态初始化
		Person[] persons2=new Person[]{
			new Person(4,"Tony")
		};
		ArrayOfObjects.printArray(persons2);
	}
}

class Person{
	private int id;
	private String name;
	private String email;
	private String phone;
	
	//构造方法
	public Person(int id,String name){
		this.id=id;
		this.name=name;
	}
	public Person(int id,String name,String email){
		this(id,name);
		this.email=email;
	}
	public Person(int id,String name,String email,String phone){
		this(id,name,email);
		this.phone=phone;
	}
	
	//getter方法
	public int getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getEmail(){
		return this.email;
	}
	public String getPhone(){
		return this.phone;
	}
	
	//setter方法
	public void setEmail(String email){
		this.email=email;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	
	public String toString(){
		return " 编号："+this.id+" 姓名："+this.name+" 邮箱："+this.email+" 电话："+this.phone;
	}
}