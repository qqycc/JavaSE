public class Outer{
	private String msg="this is a attribute";
	
	//Inner：内部类  Outer：外部类
	//内部类——局部封装，不让外部类轻易的访问内部类中的属性、方法
	class Inner{
		private String msg="this is a inner attribute";
		
		public void print(){
			//内部类使用外部类的属性——外部类的类名.this.属性名
			System.out.println("Inner中输出的外部类属性；" + Outer.this.msg);
			//内部类使用自身的属性——this.属性名
			System.out.println("Inner中输出的内部类属性；" + this.msg);
		}
	}
	
	public void fun(){
		System.out.println(this.msg);
		//内部类可以直接访问外部类的属性，但外部类不能直接访问内部类的属性
		//System.out.println(Inner.this.msg);   //error
		//this指当前对象——Outer，而print()是Inner的方法，无法调用
		//this.print();  //error
		
		//外部类访问内部类的属性，必须创建一个内部类的对象
		//调用print()的正确方法
		Inner inner = new Inner();
		inner.print();	
	}
	
	public static void main(String[] args){
		Outer outer=new Outer();
		outer.fun();
	}
}