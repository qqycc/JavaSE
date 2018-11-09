public class CarTest{
	public static void main(String [] args){
		//创建第一辆车
		Car car1=new Car("奥迪","德国","香槟色");
		car1.setPrice(8000000);
		//创建第二辆车
		Car car2=new Car("雪铁龙","法国","白色",5000000);
		//创建第三辆车
		Car car3=new Car("红旗","中国","黑色");
		car3.setPrice(6000000);
		
		System.out.println(car1.carInfo());
		car1.desc();
		System.out.println(car2.carInfo());
		System.out.println(car3.carInfo());
		
		//更改第一辆车的颜色
		car1.setColour("银色");
		//更改第二辆车的价格
		car2.setPrice(3500000);
		System.out.println();
		System.out.println("更改后的汽车信息为：");
		System.out.println(car1.carInfo());
		System.out.println(car2.carInfo());
		System.out.println(car3.carInfo());
		
	}
}