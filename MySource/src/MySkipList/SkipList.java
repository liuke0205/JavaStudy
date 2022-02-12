package MySkipList;

import java.util.Random;

class SkipNode<T>{
    int key;
    T value;
    SkipNode right, down;
    public SkipNode(int key, T value){
        this.key = key;
        this.value = value;
    }
}

public class SkipList {
    SkipNode head;//头结点
    int highLevel;//当前调表索引的层数
    Random random;//用于投掷硬币
    final int MAX_LEVEL = 32;//最大层数
    public SkipList(){
        random = new Random();
        head = new SkipNode(Integer.MAX_VALUE, null);
        highLevel = 0;
    }

    //根据key查找节点
    public SkipNode select(int key){
        SkipNode cur = head;
        while (cur != null){
            if(cur.key == key){
                return cur;
            }
            if(cur.right == null){
                cur = cur.down;
            }else {
                if(cur.right.key > key){
                    cur = cur.down;
                }else {
                    cur = cur.right;
                }
            }
        }
        return null;
    }

    //根据key删除节点
    public void delete(int key){
        SkipNode cur = head;
        while (cur != null){
            if (cur.right == null){//右侧没有了，说明这一层找到，没有只能下降
                cur = cur.down;
            }else if (cur.right.key == key){//找到节点，右侧即为待删除节点
                cur.right = cur.right.right;
                cur = cur.down;
            }else if(cur.right.key > key){//右侧已经不可能了，向下
                cur = cur.down;
            }else {//节点还在右侧
                cur = cur.right;
            }
        }
    }
}

