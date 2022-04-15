package 图;

/**
 * @author liuke
 * @date 2022/4/12 0:56
 */
public class Solution990_等式方程的可满足性 {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);

        for (String str: equations) {
            char c1 = str.charAt(0);
            char symbol = str.charAt(1);
            char c2 = str.charAt(3);
            if (symbol == '='){
                uf.union(c1-'a', c2-'a');
            }
        }
        for (String str: equations) {
            char c1 = str.charAt(0);
            char symbol = str.charAt(1);
            char c2 = str.charAt(3);
            if (symbol == '!' && uf.connected(c1-'a', c2-'a')) {
                return false;
            }
        }
        return true;
    }
}