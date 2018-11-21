//工厂方法模式
import java.util.Scanner;
public class Test13{
	//客户端
	public static void main(String[] args){
		ComputerFactory factory = new AppleFactory();
		Computer computer = factory.createComputer();
		computer.printComputer();
	}
}

interface Computer{
	void printComputer();
}

class MacbookPro implements Computer{
	public void printComputer(){
		System.out.println("This is a macbookpro");
	}
}

class SurfaceBook implements Computer{
	public void printComputer(){
		System.out.println("This is a SurfaceBook");
	}
}

interface ComputerFactory{
	Computer createComputer();
}

//微软产品工厂
class MsFactory implements ComputerFactory{
	public Computer createComputer(){
		return new SurfaceBook();
	}
}

//苹果产品工厂
class AppleFactory implements ComputerFactory{
	public Computer createComputer(){
		return new MacbookPro();
	}
}

