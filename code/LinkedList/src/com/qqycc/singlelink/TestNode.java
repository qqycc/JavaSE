package com.qqycc.singlelink;

/**
 * Author: qqy
 */
public class TestNode {
    public static void main(String[] args) {
        //封装节点
        Node head = new Node("火车头");
        Node first = new Node("车厢一");
        Node second = new Node("车厢二");
        Node last = new Node("火车尾");
        //设置车厢关系，即挂载
        head.setNext(first);
        first.setNext(second);
        second.setNext(last);
        printLink(head);
    }

    public static void printLink(Node node ){
        if(node != null){
            System.out.println(node.getData());
            node = node.getNext();
            printLink(node);
        }
    }
}
