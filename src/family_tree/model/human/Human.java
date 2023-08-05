package family_tree.model.human;

import family_tree.model.family_tree.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, TreeItem<Human> {
    private long id;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;
    private List<Human> parents;
    private Human spouse;
    private List<Human> children;

    public Human(String name, LocalDate dateOfBirth, LocalDate dateOfDeath, Gender gender, Human mother, Human father, Human spouse) {
        id = -1;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;

        parents = new ArrayList<>();
        if (father != null) parents.add(father);
        if (mother != null) parents.add(mother);

        if (spouse != null) this.spouse = spouse;

        children = new ArrayList<>();
    }

    public Human(String name, LocalDate dateOfBirth, Gender gender){
        this(name, dateOfBirth, null, gender, null, null, null);
    }

    public Human(String name, LocalDate dateOfBirth, Gender gender, Human mother, Human father){
        this(name, dateOfBirth, null, gender, mother, father, null);
    }



    //---------------------------Getters-------------------------------------------
    public long getId() {return id;}

    public String getName() {
        return name;
    }

    public LocalDate getBirhday() {return dateOfBirth;}

    public LocalDate getDeathday() {return dateOfDeath;}

    private int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period diff = Period.between(dateOfBirth, dateOfDeath);
        return diff.getYears();
    }

    public int getAge(){
        if (dateOfDeath == null) return getPeriod(dateOfBirth, LocalDate.now());
        else return getPeriod(dateOfBirth, dateOfDeath);
    }

    public Gender getGender() {return gender;}

    public Human getMother() {
        for (Human parent: parents)
            if (parent.getGender() == Gender.Female)
                return parent;

        return null;
    }

    public Human getFather() {
        for (Human parent: parents)
            if (parent.getGender() == Gender.Male)
                return parent;

        return null;
    }

    public List<Human> getParents() {return parents; }

    public List<Human> getChildren() {return children; }

    public Human findChild(String name) {
        for (Human child: children) {
            if (child.getName().equalsIgnoreCase(name))
                return child;
        }
        return null;
    }

    public Human getSpouse() {
        return spouse;
    }

    //---------------------------Setters-------------------------------------------
    public void setId (long id) {this.id = id;}

    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public void setDateOfDeath(LocalDate dateOfDeath) {this.dateOfDeath = dateOfDeath;}

    public boolean addParent(Human parent){
        if (!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public void setSpouse(Human spouse) {this.spouse = spouse;}

    public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    //---------------------------Output-------------------------------------------
    @Override
    public String toString() { return getInfo(); }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");          sb.append(getId());
        sb.append(", имя: ");       sb.append(getName());
        sb.append(", возраст: ");   sb.append(getAge());
        sb.append(", пол: ");       sb.append(getGender());
        sb.append(", ");            sb.append(getMotherInfo());
        sb.append(", ");            sb.append(getFatherInfo());
        sb.append(", ");            sb.append(getChildrenInfo());
        sb.append(", ");            sb.append(getSpouseInfo());
        return sb.toString();
    }

    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if (mother == null) res += " — ";
        else res += mother.getName();
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        Human father = getFather();
        if (father == null) res += " — ";
        else res += father.getName();
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");

        if (children.size() != 0){
            res.append(children.get(0).getName());

            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }
        else res.append(" — ");

        return res.toString();
    }

    public String getSpouseInfo(){
        String res = "супруг(а): ";
        if (spouse == null) res += " — ";
        else res += spouse.getName();
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Human)) return false;

        Human human = (Human) obj;
        return human.getId() == getId();
    }
}