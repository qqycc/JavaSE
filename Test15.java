//判断字符串是否由数字所组成
public class Test15{
	public static void main(String[] args){
		String str = "12bonjour3";
		String str1 = "123";
		judge(str);
		judge(str1);
	}
	
	public static void judge(String str){
		//先将字符串转化为字符数组
		char[] ch = str.toCharArray();
		//再对字符数组中的每一个元素进行判断
		for(int i=0;i<ch.length;i++){
			if(ch[i] >= '0' && ch[i] <= '9'){
				System.out.println("字符串"+str+"由数字所组成");
				break;
			}else{
				System.out.println("字符串"+str+"不由数字所组成");
				break;
			}
		}		
	}
}