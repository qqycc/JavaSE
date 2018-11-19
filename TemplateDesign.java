import java.util.Scanner;
public class TemplateDesign{
	public static void main(String[] args){
		CaffeineBeverage coffee = new Coffee();
		CaffeineBeverage tea = new Tea(false);
		CaffeineBeverage tea1 = new Tea();
		coffee.prepareRecipe();
		System.out.println("-----------------------------");
		tea.prepareRecipe();
		System.out.println("-----------------------------");
		tea1.prepareRecipe();
	}
}

abstract class CaffeineBeverage{
	//被声明为final——只允许子类使用，不允许被覆写
	//不准子类修改核心冲泡方法
	//流程发生改变，只需要在父类的模板方法中修改
	public final void prepareRecipe(){
		boilWater();
		brew();
		pourInCup();
		//通过子类的定制，可以改变流程
		if(customerWantsCondiments()){
			addCondiments();
		}
		clean();
	}
	
	//将水煮沸
	public final void boilWater(){
		System.out.println("将水煮沸");
	}
	
	//倒入杯子
	public final void pourInCup(){
		System.out.println("倒入杯子");
	}
	
	boolean customerWantsCondiments(){
		return true;
	}
	
	//基类声明为抽象类的原因：其子类必须实现其操作
	//由于冲泡过程以及加辅料不同，所以由子类来实现
	abstract void brew();
	abstract void addCondiments();
	
	//钩子方法
	public void clean(){
		
	}
}

class Coffee extends CaffeineBeverage{
	public void brew(){
		System.out.println("冲泡咖啡");
	}
	
	public void addCondiments(){
		System.out.println("加糖和牛奶");
	}
	
	//覆写钩子方法
	public void clean(){
		System.out.println("清理餐具");
	}
}

 class Tea extends CaffeineBeverage{
	private boolean customerWantsCondiments=true;
	
	//无参的构造方法，默认加辅料
	public Tea(){
		
	}
	
	//有参的构造方法，按客户需求添加辅料
	public Tea(boolean customerWantsCondiments){
		this.customerWantsCondiments=customerWantsCondiments;
	}	
	 
	public void brew(){
		System.out.println("浸泡茶包");
	}
	
	public void addCondiments(){
		System.out.println("加柠檬");
	}
	
	//覆写父类方法
	public boolean customerWantsCondiments(){
		return this.customerWantsCondiments;
	}
 }
 
 //模板设计模式的基类（父类、超类）
 abstract class TemplateClass{
	 //模板方法
	 //返回值-根据实际情况确定
	 //final修饰，public
	 public final void templateMethod(){
		 this.methodOptional1();
		 this.methodOptional2();
		 if(isSupportMethodOptional()){
			 this.methodOptional3();
		 }
		 this.methodOptional4();
		 this.hook();
	 }
	 
	 //普通方法
	 public [final] void methodOptional1(){
		 
	 }
	 
	 //抽象方法
	 public abstract void methodOptional2();
	 
	 public void methodOptional3(){
		 
	 }
	 public abstract void methodOptional4()；
	 
	 //改变流程的方法，子类可以覆写
	 public boolean isSupportMethodOptional(){
		 return true;
	 }
	 
	 //钩子方法
	 public void hook(){
		 //空方法体
	 }
 }
 
 