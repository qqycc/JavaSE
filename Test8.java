//接口标准
public class Test8{
	public static void main(String[] args){
		Computer computer = new Computer();
		computer.use(new Mouse());
		computer.use(new Keyboard());
	}
}

//定义USB子类
class Mouse implements USB{
	public void plugIn(){
		System.out.println("将鼠标接收器插入电脑");
	}
	
	public void setup(){
		System.out.println("安装鼠标驱动");
	}
	
	public void work(){
		System.out.println("鼠标使用");
	}
}

class Keyboard implements USB{
	public void plugIn(){
		System.out.println("将键盘接收器插入电脑");
	}
	
	public void setup(){
		System.out.println("安装键盘驱动");
	}
	
	public void work(){
		System.out.println("键盘使用");
	}
}

//定义电脑类
class Computer{
	public void use(USB usb){
		usb.plugIn();
		usb.setup();
		usb.work();
	}
}

//定义USB标准
interface USB{
	//插入
	void plugIn();
	//安装驱动
	void setup();
	//工作
	void work();
}

