package family_tree.presenter;

import family_tree.view.View;
import family_tree.model.service.Service;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, LocalDate dateOfBirth){
        service.addHuman(name, dateOfBirth);
        getHumansListInfo();
    }

    public void getHumansListInfo() {
        String info = service.getTreeInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getHumansListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumansListInfo();
    }

    public void sortById() {
        service.sortById();
        getHumansListInfo();
    }

    public void remove(long id) {
        service.remove(id);
        getHumansListInfo();
    }

    public void setWedding(long id1, long id2) {
        service.setWedding(id1, id2);
        getHumansListInfo();
    }

    public void setDivorce(long id1, long id2) {
        service.setDivorce(id1, id2);
        getHumansListInfo();
    }

    public void load(){
        service.load();
    }

    public void save(){
        service.save();
    }

}
