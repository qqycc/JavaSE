public class Test2{
	public static void main(String[] args){
		Inner2 inner2 = new Inner2();
		Outer2 outer2 = new Outer2(inner2); 
		//Outer2 outer2 = new Outer2(new Inner2());  //new Inner2()为匿名对象
		outer2.fun();

		//new Inner();  //Inner()被隐藏
	}
}

//普通类
class Outer2{
	private String msg="this is a attribute";
	private Inner2 inner2;
	
	//构造方法
	//普通类访问一个其他类的内部属性，只能对其对象进行引用
	public  Outer2 (Inner2 inner2){
		this.inner2 = inner2;
	}
	
	public void fun(){
		inner2.print();	//Inner2的方法
	}
}

//普通类
//无法访问Outer2的属性
class Inner2{
	private String msg="this is a inner attribute";
	public void print(){
		//普通类中没有外部类可言，因此Outer2.this.msg是错误的
		//System.out.println("Inner中输出的外部类属性；" + Outer2.this.msg);
		System.out.println("Inner中输出；" + this.msg);
	}
}