//接口定义与实现
public class Test7{
	public static void main(String[] args){
		//接口中的所有抽象方法都被子类覆写，具有多态性
		//使用向上转型，达到参数统一化、标准化
		IMyInterface myInterface = new MyInterfaceImpl();
		myInterface.test();
	}
}

class MyInterfaceImpl implements IMyInterface{
	public void test(){
		System.out.println(MSG);
	}
}

interface IMyInterface{
	public static final String MSG="bonjour"; 
	public abstract void test();
}

