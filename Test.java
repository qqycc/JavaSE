public class Test{
	public static void main(String [] args){
		int i=10;
		char j='a';
	System.out.println(j<i);
	}
	
	public static void stringLink(){
		int num1=10;
		double num2=11.5;
		String result1="运算结果："+num1+num2;
		System.out.println(result1);
		String result2="相加运算结果："+(num1+num2);
		System.out.println(result2);
	}
	
	public static void charInequalityInt(){
		int i=8;
		char j='8';
		if(i==j){
			System.out.println("相等");
		}else{
			System.out.println("不相等");
		}
	}
	
	public static void charAndInt(){
		//int 转 char
		int a=65;
		char b=(char)(a+32);
		System.out.println(a);
		System.out.println(b);
		//char 转 int
		char ch='c';
		int i=ch+32;
		System.out.println(ch);
		System.out.println(i);
	}
	
	public static void byteAndInt(){
		//常量若在byte类型的保存范围之内
		byte b1=15;
		//常量若不在byte类型的保存范围之内
		byte b2=(byte)300;
		//整型变量
		int i = 10;
		byte b = (byte)i;
		System.out.println("整型常量在byte类型的保存范围之内: "+b1);
		System.out.println("整型常量不在byte类型的保存范围之内: "+b2);
		System.out.println("整型变量: "+b);
	}
	
	// //方法一：
	// //private static int a;
	// //方法二
	// private int a;
	
	// public static void main(String [] args){
		// //方法一：
		// //System.out.println(a);
		// //方法二：
		// Test res=new Test();
		// System.out.println(res.a);
	// }
	
	public static void intMax(){
		int max=Integer.MAX_VALUE;
		int min=Integer.MIN_VALUE;
		System.out.println(max);
		System.out.println(min);
		System.out.println();
		//若溢出，查看输出情况
		System.out.println(max+1);
		System.out.println(min-1);
	}
}