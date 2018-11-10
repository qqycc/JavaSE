//阶乘
public class Factorial{
	public static int fac(int i){
		if(i==1){
		  return 1;
		}else{
		  return i*fac(i-1);
		}
	}
	
	public static void main(String [] args){
		int result = fac(10);
		System.out.println(result);
	}
	
}