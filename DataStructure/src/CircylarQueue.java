class MyCircularQueue {
    int front;//front指向队首前一个
    int rear;//rear指向队尾元素
    int maxCapacity;
    int[] data;
    public MyCircularQueue(int k) {
        this.maxCapacity = k + 1;
        front = 0;
        rear = 0;
        data = new int[this.maxCapacity];
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        rear = (rear + 1) % maxCapacity;
        data[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % maxCapacity;
        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[(front + 1) % maxCapacity];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[rear];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % maxCapacity == front;
    }
}