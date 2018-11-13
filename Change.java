public class Change{
	// public static void main(String[] args){
		// int a=10;
		// int b=8;
		// System.out.println("输出互换前手中的纸牌：");
		// System.out.println("左手中的纸牌："+a);
		// System.out.println("右手中的纸牌："+b);
		
		// a=a^b;
		// b=a^b;
		// a=a^b;
		// System.out.println("输出互换后手中的纸牌：");
		// System.out.println("左手中的纸牌："+a);
		// System.out.println("右手中的纸牌："+b);
	// }
	
	public static void main(String[] args){
		int a=10;
		int b=8;
		System.out.println("输出互换前手中的纸牌：");
		System.out.println("左手中的纸牌："+a);
		System.out.println("右手中的纸牌："+b);
		
		int temp;
		temp=a;
		a=b;
		b=temp;
		System.out.println("输出互换后手中的纸牌：");
		System.out.println("左手中的纸牌："+a);
		System.out.println("右手中的纸牌："+b);
	}
}