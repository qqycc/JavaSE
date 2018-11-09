public class OOP{
	private String name;
	private int age;
	private String secret="***";
	private String hobby;
	
	//假设创建对象时必须同时赋予名字，因此，不提供无参的构造方法
	
	//有参的构造方法
	public OOP(String name){
		this.name=name;		//对象的名字=赋值的名字
	}
	
	//方法、行为
	public String personInfo(){
		return "这个人叫"+name+"，年龄是"+age+"，爱好是"+hobby;
	}
	
	//getter getXXX()  XXX为属性名称
	String getName(){
		return name;
	}
	
	int getAge(){
		return age;
	}
	
	String getSecret(){
		return secret;
	}
	
	String getHobby(){
		return hobby;
	}
	
	//setter setXXX()  XXX为属性名称
	void setAge(int age){
		this.age=age;
	}
	
	void setHobby(String hobby){
		this.hobby=hobby;
	}
	
	//具体对象
	// public static void main(String [] args){
		// //对象1
		// //创建对象
		// OOP per1=new OOP();
		// //对属性赋值
		// per1.name="Tom";
		// per1.age=18;
		
		// //对象2
		// OOP per2=new OOP();
		// per2.name="Mary";
		// per2.age=20;
		
		// //对象3
		// OOP per3=new OOP("Alice",22);
		
		// // //引用传递
		// // //per1对象引用的地址赋值给砰然
		// // OOP per4=per1;
		// // per4.age=25;
		
		// // per1变量引用指向空
		// // per1=null;
		// // per4=null;//堆上的person对象已经没有变量引用它，但依然存在
		
		// //调用对象的方法
		// System.out.println(per1.personInfo());
		// System.out.println(per2.personInfo());
		// System.out.println(per3.personInfo());
		// System.out.println(per1.secret);
	// }
	
}