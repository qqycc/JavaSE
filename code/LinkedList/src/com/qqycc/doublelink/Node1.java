package com.qqycc.doublelink;

/**
 * Author: qqy
 */

interface ILink {
    //链表增加节点（节点内容）
    boolean add(Object data);

    //判断指定内容节点在链表中是否存在（所判断内容）,返回找到的节点的索引
    int contains(Object data);

    //删除指定内容节点
    boolean remove(Object data);

    //根据指定下标修改节点内容（索引下标，替换后内容），返回替换前节点内容
    Object set(int index, Object newdata);

    //根据指定下标返回节点内容
    Object get(int index);

    //清空链表
    void clear();

    //链表遍历的需要递归实现，因此将链表转为数组，返回所有的节点内容
    Object[] toArray();

    //链表长度
    int size();

    //遍历链表
    void printLink();
}

class LinkImpl implements ILink {
    private Node1 head;  //头指针
    private Node1 last;  //尾指针
    private int size;   //链表长度

    //将Node1作为内部类原因
    //1.封装，只有LinkImpl需要用到
    //2.方便操作，无需getter、setter
    //真正的节点，负责数据存储
    public class Node1 {
        private Node1 prev;
        private Object data;
        private Node1 next;

        //作为内部类，无需定义getter、setter属性
        public Node1(Node1 prev, Object data, Node1 next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }


    @Override
    public boolean add(Object data) {
        Node1 temp = this.last;
        Node1 newNode = new Node1(temp, data, null);
        this.last = newNode;
        if (this.head == null) {
            this.head = newNode;
        } else {
            temp.next = newNode;
        }
        this.size++;

        return false;
    }

    @Override
    public int contains(Object data) {
        //null
        if (data == null) {
            int i=0;
            for (Node1 temp = this.head; temp != null; temp = temp.next) {
                if (temp.data == null) {
                    return i;
                }
                i++;
            }
        }else{
            int i=0;
            for (Node1 temp = this.head; temp != null; temp = temp.next) {
                if (temp.data.equals(data)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(Object data) {
        if(data==null){
            for(Node1 temp=this.head;temp!=null;temp=temp.next){
                if(temp.data==null){
                    unLink(temp);
                    return true;
                }
            }
        }else{
            for(Node1 temp=this.head;temp!=null;temp=temp.next){
                if(temp.data.equals(data)){
                    unLink(temp);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        if (!isLinkIndex(index)) {
            return null;
        }
        Node1 node =node(index);
        Object elementData=node.data;
        node.data=newData;
        return elementData;
    }

    @Override
    public Object get(int index) {
        if (!isLinkIndex(index)) {
            return null;
        }
        return node(index).data;
    }

    @Override
    public void clear() {
        for (Node1 temp = head; temp != null; ) {
            temp.data = null;
            Node1 node = temp.next;
            temp = temp.prev = temp.next = null;
            temp = node;
            this.size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node1 temp = head; temp != null; temp = temp.next) {
            result[i++] = temp.data;
        }
        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printLink() {
        Object[] data = this.toArray();
        for (Object temp : data) {
            System.out.println(temp);
        }
    }

    //仅供本类方法使用,根据指定的索引确定具体的节点
    private Node1 node(int index){
        if(index<(size>>1)){
            Node1 temp=this.head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            return temp;
        }
        Node1 temp=this.last;
        for(int i=size-1;i>index;i--){
            temp=temp.prev;
        }
        return temp;
    }

    //判断指定的索引是否合法
    private boolean isLinkIndex(int index){
        return index>=0 && index<size;
    }

    private Object unLink(Node1 x){
        Object elementData=x.data;
        Node1 prev=x.prev;
        Node1 next=x.next;
        if(prev==null){
            this.head=next;
        }else {
            prev.next=next;
            x.prev=null;
        }
        if(next==null){
            this.last=prev;
        }else {
            next.prev=prev;
            x.next=null;
        }
        x.data=null;
        this.size--;
        return elementData;
    }
}