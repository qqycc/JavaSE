//模版设计模式：在线购物流程 (天猫，京东)
//浏览商品 -> 选择商品 -> 客服服务 -> 快递服务 -> 结算 -> 付款 -> 查看订单
public class Shopping{
	public static void main(String[] args){
		OnlineShopping tmall = new Tmall();
		OnlineShopping jd = new JD();
		System.out.println("天猫购物：");
		tmall.prepareRecipe();
		System.out.println("----------------------------------");
		System.out.println("京东购物：");
		jd.prepareRecipe();
	}
}

//网上购物是一个抽象类
abstract class OnlineShopping{
	final void prepareRecipe() { 
	browseProducts();
	selectProducts();
	if (customerWantsService()){
		customerService();
	}
	courierService();
	settlement();
	payment();
	checkOrder();
	}
	
	public void browseProducts(){
		System.out.println("浏览商品");
	}
	
	public void selectProducts(){
		System.out.println("选择商品");
	}
	
	public void settlement(){
		System.out.println("结算");
	}
	
	public void payment(){
		System.out.println("付款");
	}
	
	public void checkOrder(){
		System.out.println("查看订单");
	}
	
	//因为天猫和京东的客服服务与快递服务不同，将这两个方法声明为抽象，让子类实现
	abstract void customerService();
	abstract void courierService();
	
	//判断是否需要客服服务
	public boolean customerWantsService(){
		String answer = getUserInput();
		if(answer.equals("y")){
			return true;
		}else{
			return false;
		}
	}
	
	private String getUserInput(){
		System.out.println("您需要客服服务么？(y/n)");
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		String answer = scanner.nextLine();
		return answer;
	}
}

class Tmall extends OnlineShopping{
	public void customerService (){
		System.out.println("阿里旺旺服务");
	}
	
	public void courierService(){
		System.out.println("天猫直达服务");
	}
}

class JD extends OnlineShopping{
	public void customerService (){
		System.out.println("京东客服服务");
	}
	
	public void courierService(){
		System.out.println("京东配送服务");
	}
}



