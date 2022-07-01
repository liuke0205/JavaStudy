package 面试真题.腾讯;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author liuke
 * @date 2022/7/2 0:00
 */
public class LRU {
    /*
    https://leetcode.cn/problems/lru-cache/
     */

}

//定义一个node节点类
class Node<K, V> {
    K key;
    V value;
    Node<K, V> prev;
    Node<K, V> next;

    //构造器
    public Node() {
        this.prev = this.next = null;
    }

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.prev = this.next = null;
    }
}

//定义一个双向链表来实现节点的增加和删除
class DoubleLinkedList<K, V> {
    Node<K, V> head;
    Node<K, V> tail;

    public DoubleLinkedList() {
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.prev = head;
    }

    //在链表头部增加节点
    public void addHead(Node<K,V> node) {
        if (node == null) return;
        node.next = this.head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    //删除节点
    public void removeNode(Node<K, V> node) {
        if (node == null) return;

        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = null;
        node.next = null;
    }

    //获取最后一个元素
    public Node<K, V> getLastNode() {
        return this.tail.prev;
    }
}

class LRUCache {

    //缓存容量
    private int capacity;

    //map用来存放数据节点
    private Map<Integer, Node<Integer,Integer>> map;

    //双向链表，进行数据的删除与增加
    private DoubleLinkedList<Integer, Integer> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new DoubleLinkedList<>();
    }

    public int get(int key) {
        if ( !map.containsKey(key) ) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        list.removeNode(node);
        list.addHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if ( map.containsKey(key) ) {
            //如果已经包含
            Node<Integer, Integer> node = map.get(key);
            //update data
            node.value = value;
            //put map
            map.put(key, node);
            list.removeNode(node);
            list.addHead(node);
        } else {
            Node<Integer,Integer> newNode = new Node<>(key, value);
            if (map.size() == capacity) {
                Node<Integer, Integer> lastNode = list.getLastNode();
                map.remove(lastNode.key);
                list.removeNode(lastNode);
            }
            map.put(key,newNode);
            list.addHead(newNode);
        }
    }
}

class LRUCache2 extends LinkedHashMap<Integer, Integer> {
    private final int capacity;
    public LRUCache2(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return this.capacity < this.size();
    }
}