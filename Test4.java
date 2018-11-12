public class Test4 {
	public static void main(String[] args){
		Outer outer = new Outer();
		outer.display(15);
	}
}

interface MyInterFace{
	void test();  //public abstract void test();
}

class Outer{
	private int num = 20;
	//final int value
	public void display(int value){
		//匿名内部类  实现了一个接口MyInterFace
		//匿名类不能创建更多的对象，只能有一个（匿名对象、有名字的对象）
		new MyInterFace(){
			public void test(){
				//来自Outer的成员方法的参数value
				System.out.println("Value = "+value);  
				//来自Outer的属性
				System.out.println("num = "+num);  //20
			}
		}.test();
	}
}