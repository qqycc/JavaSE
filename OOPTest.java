public class OOPTest{
	public static void main(String [] args){
		//对象1
		//创建对象
		//假设姓名不得修改，因此不提供setName()方法
		OOP per1=new OOP("Tom");
		
		// 对属性赋值
		per1.setAge(20);
		per1.setHobby("跑步");
		
		//OOP类的保护——封装
		//外部程序要访问 封装的属性 通过提供的getter方法访问
		System.out.println(per1.getSecret());
		System.out.println(per1.personInfo());
	}
}