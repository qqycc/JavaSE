public class TemplateDesign{
	public static void main(String[] args){
		CaffeineBeverage coffee = new Coffee();
		CaffeineBeverage tea = new Tea();
		coffee.prepareRecipe();
		tea.prepareRecipe();
		
	}
}

 // class Coffee{
	// //咖啡的冲泡方法
	// void prepareRecipe(){
		// boilWater();
		// brewCoffee();
		// pourInCup();
		// addSugerAndMilk();
	// }
	// //将水煮沸
	// void boilWater(){
		// System.out.println("将水煮沸");
	// }
	// //冲泡咖啡
	// void brewCoffee(){
		// System.out.println("用水冲泡咖啡");
	// }
	// //倒入杯子
	// void pourInCup(){
		// System.out.println("倒入杯子");
	// }
	// //加糖和奶
	// void addSugerAndMilk(){
		// System.out.println("加糖和奶");
	// }
	
// }

// class Tea{
	// void prepareRecipe(){
		// boilWater();
		// steepTeaBag();
		// pourInCup();
		// addLemon();
	// }
	// // 将水煮沸
	// void boilWater(){
		// System.out.println("将水煮沸");
	// }
	// // 浸泡茶包
	// void steepTeaBag(){
		// System.out.println("浸泡茶包");
	// }
	// // 倒入杯子
	// void pourInCup(){
		// System.out.println("倒入杯子");
	// }
	// // 加柠檬
	// void addLemon(){
		// System.out.println("加柠檬");
	// }
// }

abstract class CaffeineBeverage{
	//只允许子类使用，不允许被覆写
	//不准子类修改核心冲泡方法
	finalprepareRecipe(){
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}
	
	//将水煮沸
	void boilWater(){
		System.out.println("将水煮沸");
	}
	
	//倒入杯子
	void pourInCup(){
		System.out.println("倒入杯子");
	}
	
	abstract void brew();
	abstract void addCondiments();
}

class Coffee extends CaffeineBeverage{
	void brew(){
		System.out.println("冲泡咖啡");
	}
	
	void addCondiments(){
		System.out.println("加糖和牛奶");
	}
}

 class Tea extends CaffeineBeverage{
	 void brew(){
		System.out.println("浸泡茶包");
	}
	
	void addCondiments(){
		System.out.println("加柠檬");
	}
 }