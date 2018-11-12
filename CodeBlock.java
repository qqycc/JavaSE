public class CodeBlock{
	private int codeline;
	private String codeFileName;
	private int salary;

	// 暗示静态块优先于构造块执行
	static{
		System.out.println("静态块，属于类");
	}
	
	//暗示构造块的执行在构造方法之前
	{
		System.out.println("CodeBlock  非静态块");
		codeline=10;
		//假设salary的初始化较为复杂，则可以在此对其进行初始化
		salary=codeline*2;
	}
	
	public CodeBlock(){
		//也可以在此对其进行初始化
		System.out.println("构造方法执行");
	}

	public static void norCodeBlock(){
		{
			int x=10;
		    System.out.println(x);
		}
		int x=100;
		System.out.println(x);
	}
	
	public static void main(String[] args){
		CodeBlock codeBlock=new CodeBlock();
		CodeBlock codeBlock2=new CodeBlock();
		System.out.println("main()");
	}
}