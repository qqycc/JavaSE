public class Car{
	//属性
	//品牌（不可更改）、产地（不可更改）、颜色、价格
	private String brand;
	private String origin;
	private String colour;
	private int price;
	
	//构造方法
	//假设汽车出厂后必须有品牌、产地、颜色
	public Car(String brand,String origin,String colour){
		this.brand=brand;
		this.origin=origin;
		this.colour=colour;
	}
	
	public Car(String brand,String origin,String colour,int price){
		this(brand,origin,colour);
		this.price=price;
	}
	
	//普通方法
	//getter方法
	public String getBrand(){
		return brand;
	}
	
	public String getOrigin(){
		return origin;
	}
	
	public String getColour(){
		return colour;
	}
	
	public int getPrice(){
		return price;
	}
	
	//setter方法
	public void setColour(String colour){
		this.colour=colour;
	}
	
	public void setPrice(int price){
		this.price=price;
	}
	
	//描述
	public String carInfo(){
		return "这辆车的品牌是"+brand+"，产自"+origin+"，颜色是"+colour+"，价格为"+price;
	}
	
	public void desc(){
		System.out.println("这辆"+brand+"的颜色很好看！");
	}
}