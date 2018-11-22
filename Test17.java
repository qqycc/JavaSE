//首字母大写
public class Test17{
	public static void main(String[] args){
		System.out.print(firstCase("hello"));
	}
	public static String firstCase(String str){
		return str.substring(0,1).toUpperCase()+str.substring(1);
	}
}