import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Dog {
    private long id;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender; //При реализации дописать-доимпортировать Gender;
    private List<Dog> parents;
    private List<Dog> partners;
    private List<Dog> children;

    public Dog(String name, LocalDate dateOfBirth, LocalDate dateOfDeath, Gender gender, Dog mother, Dog father, Dog partner) {
        id = -1;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;

        parents = new ArrayList<>();
        if (father != null) parents.add(father);
        if (mother != null) parents.add(mother);

	partners = new ArrayList<>();
        if (partner != null) partners.add(partner);

        children = new ArrayList<>();
    }

    public Dog(String name, LocalDate dateOfBirth, Gender gender){
        this(name, dateOfBirth, null, gender, null, null, null);
    }

    public Dog(String name, LocalDate dateOfBirth, Gender gender, Dog mother, Dog father){
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

    public Dog getMother() {
        for (Dog parent: parents)
            if (parent.getGender() == Gender.Female)
                return parent;

        return null;
    }

    public Dog getFather() {
        for (Dog parent: parents)
            if (parent.getGender() == Gender.Male)
                return parent;

        return null;
    }

    public List<Dog> getParents() {return parents; }

    public List<Dog> getChildren() {return children; }

    public Dog findChild(String name) {
        for (Dog child: children) {
            if (child.getName().equalsIgnoreCase(name))
                return child;
        }
        return null;
    }

    public List<Dog> getPartners() {
            return partners;
    }

    //---------------------------Setters-------------------------------------------
    public void setId (long id) {this.id = id;}

    public void setDateOfBirth(LocalDate dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public void setDateOfDeath(LocalDate dateOfDeath) {this.dateOfDeath = dateOfDeath;}

    public boolean addParent(Dog parent){
        if (!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public boolean addPartners(Dog partner){
        if (!partners.contains(partner)){
            partners.add(partner);
            return true;
        }
        return false;
    }

    public boolean addChild(Dog child){
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
        sb.append(", ");            sb.append(getPartnersInfo());
        return sb.toString();
    }

    public String getMotherInfo(){
        String res = "мать: ";
        Dog mother = getMother();
        if (mother == null) res += " — ";
        else res += mother.getName();
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        Dog father = getFather();
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

    public String getPartnersInfo(){
        StringBuilder res = new StringBuilder();
        res.append("партнеры: ");

        if (partners.size() != 0){
            res.append(partners.get(0).getName());

            for (int i = 1; i < partners.size(); i++) {
                res.append(", ");
                res.append(partners.get(i).getName());
            }
        }
        else res.append(" — ");

        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Dog)) return false;

        Dog dog = (Dog) obj;
        return dog.getId() == getId();
    }
}