/**
 * Author: qqy
 */
public class PackageTest1 {
    public static void main(String[] args) {
        //将整形的常量封装到类中
        IntDemo intDemo=new IntDemo(10);
        int result=intDemo.getIntValue();
        System.out.println(result+20);
    }

}

class IntDemo {
    private  int intValue;
    public IntDemo(int intValue){
        this.intValue=intValue;
    }

    public int getIntValue() {
        return intValue;
    }
}