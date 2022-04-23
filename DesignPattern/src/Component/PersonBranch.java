package Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/4/16 11:46
 */
public class PersonBranch extends PersonMode{
    private List<PersonMode> personModeList = new ArrayList<>();

    public PersonBranch(String name, String sex, int age) {
        super(name, sex, age);
    }

    public void addPerson(PersonMode person){
        this.personModeList.add(person);
    }

    public List<PersonMode> getPersonModeList(){
        return this.personModeList;
    }
}
