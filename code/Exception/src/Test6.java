/**
 * Author: qqy
 */
class AddException extends RuntimeException{
    public AddException(){

    }
    public AddException(String message){
        super(message);
    }
}

class AddException2 extends Exception{
    public AddException2(){

    }
    public AddException2(String message){
        super(message);
    }
}

public class Test6 {
    public static void main(String[] args) {
        System.out.println(add(50,50));
        try {
            System.out.println(add2(251,249));
        } catch (AddException2 e) {
            e.printStackTrace();
        }
        try {
            System.out.println(add2(25,25));
        } catch (AddException2 e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(add(250, 250));
        }catch (AddException e){
            System.out.println("异常捕获");
        }
        System.out.println(add(251,249));
    }

    public static  long add(long a,long b)throws AddException{
        long value=a+b;
        if(value==500){
            //抛出自定义异常
            throw  new AddException("a+b 不能等于500");
        }else{
            return value;
        }
    }

    public static  int add2(int a,int b)throws AddException2{
        int value=a+b;
        if(value==50){
            //抛出自定义异常
            throw  new AddException2("a+b 不能等于50");
        }else{
            return value;
        }
    }
}
