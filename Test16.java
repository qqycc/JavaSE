public class Test16{
	public static void main(String[] args){
		//子类可以实现多个接口，子类的实例化对象可以向上转型为任意接口类型
		QQMessage qq  =new QQMessage();
		IMessage qq2 = new QQMessage();
		IPlatform qq3 = new QQMessage();
		qq.print();
		
		//类型之间转换：编译阶段、运行阶段
		
		//为了让msn实现supportPlateform()方法，将msn强转为IPlatform类型
		//运行时，msn在内存空间上创建一个MSNMessage对象
		//如果msn instanceof IPlatform为true，则可运行通过；为false，则CCE
		
		//编译时，msn为IMessage类型，只要强转为IPlatform，则编译通过
		IPlatform platform = (IPlatform)qq3; //相当于IPlatform platform = new QQMessage();
		platform.supportPlateform();
		
		QQMessage qqmessage = (QQMessage)qq2;
		qqmessage.printCompany();
	}
}

//子类可以实现多个接口
//子类可以继承抽象类(类),先extends，再implements
//接口的实现类，要实现接口的抽象方法
//虽然抽象类Company已经实现了IMessage接口，但是此处仍可以再写一遍，强调当前类是IMessage的子类
class QQMessage extends Company implements IMessage,IPlatform{
	public void print(){
		System.out.println("这是QQMessage");
	}
	
	public void supportPlateform(){
		System.out.println("QQ支持Windows和Macos平台");
	}
	
	public void printCompany(){
		System.out.println("Tencent出品");
	}
}

//抽象类实现接口
abstract class Company implements IMessage{
	public abstract void printCompany();
}

interface IMessage{
	//全局常量
	//接口中定义的变量，实际就是全局常量
	//默认public static final 
	String MSG="bonjour";  // IMessage.MSG
	//抽象方法
	//接口中定义的方法默认为public
    void print();
}

interface IPlatform{
	void supportPlateform();
}