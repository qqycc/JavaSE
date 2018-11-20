//简单工厂模式（示例）
import java.util.Scanner;
public class Test9{
	//客户端
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入电脑型号：");
		String type = scanner.nextLine();
		Computer computer = ComputerFactory.getInstance(type);
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

class AlienWare implements Computer{
	public void printComputer(){
		System.out.println("This is a AlienWare");
	}
}

//第三方工厂类
class ComputerFactory{
	public static Computer getInstance(String type){
		if(type.equals("mac")){
			return new MacbookPro();
		}else if(type.equals("surface")){
			return new SurfaceBook();
		}else if(type.equals("alienware")){
			return new AlienWare();
		}
		return null;
	}
}