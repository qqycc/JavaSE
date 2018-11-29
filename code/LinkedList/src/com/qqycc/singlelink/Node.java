package com.qqycc.singlelink;

/**
 * Author: qqy
 */

//定义车厢节点（结构）
public class Node {
    //节点中数据
    private Object data;
    //指向下一个节点,因此，类型是Node
    private Node next;

    public Node(Object data){
        this.data=data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
