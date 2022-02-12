class TrieNode{
    boolean val;
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null){
                cur.children[idx] = new TrieNode();
            }
            cur = cur.children[idx];
        }
        cur.val = true;
    }
    //支持.万能匹配的搜索功能
    public boolean search(String word){
        return search(word, 0, root);
    }

    public boolean search(String word, int i, TrieNode cur){
        if (cur == null){
            return false;
        }
        if (i == word.length()){
            return cur.val;
        }
        char c = word.charAt(i);
        if (c != '.'){
            return search(word, i+1, cur.children[c - 'a']);
        }
        for (int j = 0; j < 26; j++) {
            if (search(word, i+1, cur.children[j])){
                return true;
            }
        }
        return false;
    }

    //前缀搜索 已有abc  搜索是否存在ab
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            int idx = c - 'a';
            if(cur.children[idx] == null){
                return false;
            }
            cur = cur.children[idx];
        }
        return true;
    }
    //搜索abcd的最短前缀
    public String shortPrev(String word) {
        TrieNode cur = root;
        int cnt = 0;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (cur.children[idx] == null && !cur.val){
                return "";
            }
            if (cur.val){
                return word.substring(0, cnt);
            }
            cnt++;
            cur = cur.children[idx];
        }
        return word.substring(0, cnt);
    }
}