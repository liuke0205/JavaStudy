package IteratorPattern;

/**
 * @author liuke
 * @create 2021/03/18/15:09
 */
public class NameRespority implements Container{
    public String[] names = {"Liuke", "Hanyao", "Loaj"};
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }
    private class NameIterator implements Iterator{
        int index;
        @Override
        public boolean hashNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hashNext()){
                return names[index++];
            }
            return null;
        }
    }
}
