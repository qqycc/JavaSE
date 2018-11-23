//String类扩展功能实现
public class Strings{
	public static void main(String[] args){
	//1.
	System.out.println(repeat('a',6));
	System.out.println(repeat('a',-1));
	System.out.println("-------------------------");
	//2.
	System.out.println(fillBefore("abc", 'A', 5));
	System.out.println(fillBefore("abc", 'A', 1));
	System.out.println("-------------------------");
	//3.
	System.out.println(fillAfter("abc", 'A', 5));
	System.out.println(fillAfter("abc", 'A', 2));
	System.out.println("-------------------------");
	//4.
	System.out.println(removeAll("aa-bb-cc-dd","-"));
	System.out.println(removeAll("aa-bb-cc-dd","e"));
	System.out.println("-------------------------");
	//5.
	System.out.println(reverse("bonjour"));
	System.out.println(reverse(null));
	System.out.println("-------------------------");
    }
	
     /**
     * 重复某个字符
     * 
     * 例如： 
     * 'a' 5   => "aaaaa"  
     * 'a' -1  => ""
     * 
     * @param c     被重复的字符
     * @param count 重复的数目，如果小于等于0则返回""
     * @return 重复字符字符串
     */
    public static String repeat(char c, int count) {
        if(count > 0){
			String str = "";
			char[] c1 = new char[count];
		   for(int i=0;i<count;i++){
			   c1[i]=c;
		   }
		   for(int i=0;i<count;i++){
			   str += c1[i];
		   }
		   return str;
	    }
		return "";
    }
    
    
     /**
     * 将已有字符串填充为规定长度，如果已有字符串超过这个长度则返回这个字符串
     * 字符填充于字符串前
     *
     * 例如： 
     * "abc" 'A' 5  => "AAabc"
     * "abc" 'A' 3  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillBefore(String str, char filledChar, int len) {
        String str1 = str;
		int len1=len-str.length();
	    if(len>str.length()){
			//将字符串转换为字符数组ch
			char[] ch = str1.toCharArray();
			char[] ch1 = new char[len];
			//将填充的字符加入ch1
			for(int i=0;i<len1;i++){
				ch1[i] = filledChar;
			}
			//将字符串转换后的字符加入ch1
			for(int i=len1;i<ch1.length;i++){
				ch1[i] = ch[i-len1];
			}
			//将字符数组转换为字符串
			str1 =new String(ch1);
			return str1;
	    }
        return str;
    }
    
    /**
     * 将已有字符串填充为规定长度，如果已有字符串超过这个长度则返回这个字符串<br>
     * 字符填充于字符串后
     * 例如： 
     * "abc" 'A' 5  => "abcAA"
     * "abc" 'A' 3  => "abc"
     *
     * @param str        被填充的字符串
     * @param filledChar 填充的字符
     * @param len        填充长度
     * @return 填充后的字符串
     */
    public static String fillAfter(String str, char filledChar, int len) {
        String str1 = str;
	    if(len>str.length()){
			//将字符串转换为字符数组ch
			char[] ch = str1.toCharArray();
			char[] ch1 = new char[len];
			//将字符串转换后的字符加入ch1
			for(int i=0;i<ch.length;i++){
				ch1[i] = ch[i];
			}
			//将填充的字符加入ch1
			for(int i=ch.length;i<ch1.length;i++){
				ch1[i] = filledChar;
			}
			//将字符数组转换为字符串
			str1 =new String(ch1);
			return str1;
	    }
        return str;
    }

    /**
     * 移除字符串中所有给定字符串
     * 例：removeAll("aa-bb-cc-dd", "-") => aabbccdd
     *
     * @param str         字符串
     * @param strToRemove 被移除的字符串
     * @return 移除后的字符串
     */
    public static String removeAll(CharSequence str, CharSequence strToRemove) {
		//将CharSequence -> String
		String str1 = str.toString();
		String strToRemove1 = strToRemove.toString();
	    if(str1.contains(strToRemove1)){
			return str1.replaceAll("-","");
		}
        return "";
    }
    
    /**
     * 反转字符串
     * 例如：abcd => dcba
     *
     * @param str 被反转的字符串
     * @return 反转后的字符串
     */
    public static String reverse(String str) {
		if(str!=null){
			//创建一个新字符数组
			char[] ch = new char[str.length()];
			//将字符串转换为字符数组ch
			char[] ch1 = str.toCharArray();
			//反向放入新数组
			for(int i=0,j=str.length();i<str.length();i++,j--){
				ch[i]=ch1[j-1];
			}
		    //将字符数组转换为字符串
			String str1 = new String(ch);
			return str1;
		}
        return "";
    }
}