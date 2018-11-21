//代理模式
public class Test12{
	public static void main(String[] args){
		ISubject subject = new ProxySubjectImpl(new RealSubjectImpl());
		subject.buyComputer();
	}
}

//业务接口
interface ISubject{
	void buyComputer();
}

//真实主题类
class RealSubjectImpl implements ISubject{
	public void buyComputer(){
		System.out.println("买macbook pro");
	}
}

//代理类
class ProxySubjectImpl implements ISubject{
	private ISubject realSubject;
	//构造注入，注入真实主题类
	public ProxySubjectImpl(ISubject realSubject){
		this.realSubject = realSubject;
	}
	
	public void beforeSubject(){
		System.out.println("取钱");
	}
	
	public void buyComputer(){
		this.beforeSubject();
		this.realSubject.buyComputer();
		this.afterSubject();
	}
	
	public void afterSubject(){
		System.out.println("装软件");
	}
}