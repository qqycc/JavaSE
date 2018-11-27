/**
 * Author: qqy
 */
public class ObjectTest3 {
    public static void main(String[] args) {
        //Object接收数组对象
        Object obj = new int[]{1,3,5,7,9};
        int[] data = (int[]) obj;
        System.out.println(data[0]);  //1

        //Object接收接口对象
        IMessage msg = new MessageImpl();
        Object obj1 = msg;
        ((IMessage) obj1).test();  //bonjour！
        System.out.println(obj1);  //默认调用to.String()  //MessageImpl@1540e19d
    }
}

interface IMessage{
    void test();
}

class MessageImpl implements IMessage{
    @Override
    public void test() {
        System.out.println("bonjour！");
    }
}