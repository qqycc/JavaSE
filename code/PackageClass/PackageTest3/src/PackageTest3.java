import java.util.Arrays;

/**
 * Author: qqy
 */
public class PackageTest3 {

    public static void main(String[] args) {
        private String age;

        String str = "123";
        int i = Integer.parseInt(str);   //默认将123当作十进制
        //radix：当前转换的字符表示的数字的进制
        int i1 = Integer.parseInt(str, 16);  //将123当作十六进制
        //Java表示的进制默认为十进制
        System.out.println(i + 2);
        System.out.println(i1);

        //boolean  当前转换的字符串只有为“true”，才返回true（忽略大小写），否则返回false
        System.out.println(Boolean.parseBoolean("true"));  //true
        System.out.println(Boolean.parseBoolean("TrUe"));  //true
        System.out.println(Boolean.parseBoolean("false"));  //false
        System.out.println(Boolean.parseBoolean("123"));   //false

        String str1 = "123.25";
        double i2 = Double.parseDouble(str1);
        System.out.println(i2 + 5);

        String str3 = "" + 123;
        System.out.println(str3.length());  //3

        String str4 = String.valueOf(true);
        System.out.println(str4.length());  //4

        int a = 20;
        char[] ch = new char[]{'a', 'b'};  //1
        swap(a, ch);
        System.out.println(a);    //20  20复制后赋给a，将20传递给b，b的值变为10，a不受影响
        //ch的地址复制后赋给ch1，ch的地址传递给chars，chars[0]='A',则ch[0]='A'
        System.out.println(java.util.Arrays.toString(ch));  //[A,b]
    }

    public static void swap(int b,char[] ch1){
        b=10;
        char[] chars=ch1;  //1
        chars[0]='A';
        ch1=new char[]{'C','D'};  //2
    }
}



