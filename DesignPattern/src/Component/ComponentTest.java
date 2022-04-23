package Component;

/**
 * @author liuke
 * @date 2022/4/16 11:49
 */
public class ComponentTest {
    public static void main(String[] args) {
        //第一代J
        PersonBranch OneJ=new PersonBranch("第一代J","男",150);
        //第一代J的三个儿子
        PersonBranch JA=new PersonBranch("JA","男",70);
        PersonBranch JB=new PersonBranch("JB","男",60);
        PersonBranch JC=new PersonBranch("JC","男",50);
        //JA的三个儿子
        PersonBranch JA1=new PersonBranch("JA1","男",40);
        PersonBranch JA2=new PersonBranch("JA2","男",30);
        PersonBranch JA3=new PersonBranch("JA3","男",45);
        //JB的两个儿子
        PersonBranch JB1=new PersonBranch("JB1","男",40);
        PersonBranch JB2=new PersonBranch("JB2","男",30);
        //JC的儿子小J
        PersonBranch xiao_J=new PersonBranch("xiao_J","男",20);
        //JA1的2个儿子
        PersonBranch JA1_1=new PersonBranch("JA1_1","男",18);
        PersonBranch JA1_2=new PersonBranch("JA1_2","男",16);
        //JA3的2个儿子
        PersonBranch JA3_1=new PersonBranch("JA3_1","男",16);
        PersonBranch JA3_2=new PersonBranch("JA3_2","男",20);

        //开始组装树状族谱
        //组装第一代J下的三个儿子
        OneJ.addPerson(JA);
        OneJ.addPerson(JB);
        OneJ.addPerson(JC);
        //组装JA的三个儿子
        JA.addPerson(JA1);
        JA.addPerson(JA2);
        JA.addPerson(JA3);
        //组装JB的两个儿子
        JB.addPerson(JB1);
        JB.addPerson(JB2);
        //组装JC的儿子
        JC.addPerson(xiao_J);
        //组装JA1的2个儿子
        JA1.addPerson(JA1_1);
        JA1.addPerson(JA1_2);
        //组装JA3的2个儿子
        JA3.addPerson(JA3_1);
        JA3.addPerson(JA3_2);

        showTree(OneJ);
    }

    private static void showTree(PersonBranch root){
        System.out.println(root.toString());
        for(PersonMode c:root.getPersonModeList()){
            if(c instanceof PersonLeaf){ //叶子节点
                System.out.println(c.toString());
            }else{ //树枝节点
                showTree((PersonBranch) c);
            }
        }
    }
}
