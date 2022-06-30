package 面试真题.蔚来;

/**
 * 只能使用数组（不能使用其他数据结构）实现Queue（Queue的长度无限），
 * 数组可以无限使用，每个数组长度最大为10，提供pop和push功能
 */
class Array {
    public int first, last;
    public int[] arr;
    public Array next;
    public Array(){
        first = -1;
        last = 0;
        arr = new int[10];
    }

    public void setArr(int idx, int num){
        this.arr[idx] = num;
    }

    public int getArr(int idx){
        if (idx < 0 || idx > 9){
            return Integer.MIN_VALUE;
        }
        return arr[idx];
    }
    public void addFirst(){
        first++;
    }
    public void addLast(){
        last++;
    }
}

class MyQueue {
    Array popArray, pushArray;
    public MyQueue(){
        Array cur = new Array();
        popArray = cur;
        pushArray = cur;
    }

    public int pop(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        if (popArray.first == 9 && popArray.next != null){
            popArray = popArray.next;
        }
        popArray.addFirst();
        return popArray.getArr(popArray.first);
    }

    public void push(int num){
        if (pushArray.last == 10){
            if (pushArray.next == null){
                pushArray.next = new Array();
            }
            pushArray = pushArray.next;
        }
        pushArray.setArr(pushArray.last, num);
        pushArray.addLast();
    }

    public boolean isEmpty(){
        return popArray == pushArray && popArray.last == popArray.first + 1;
    }
}

public class Queue{
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        for (int i = 0; i < 20; i++) {
            queue.push(i);
        }

        for (int i = 0; i < 30; i++) {
            System.out.println(queue.pop());
        }
    }
}