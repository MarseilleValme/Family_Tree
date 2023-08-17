package family_tree.presenter;


import family_tree.model.service.FileHandler;
import family_tree.model.service.Writable;
import family_tree.view.View;
import family_tree.model.service.Service;

import java.time.LocalDate;


public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        Writable writable = new FileHandler();
        service = new Service(writable);
    }


    public void addHuman(String name, LocalDate dateOfBirth, String pol){
        service.addHuman(name, dateOfBirth, pol);
    }

    public void getHumansListInfo() {
        String info = service.getTreeInfo();
        view.printAnswer(info);
    }

    public void sortByAge() { service.sortByAge();
    }

    public void sortByName() { service.sortByName();
    }

    public void sortById() { service.sortById();
    }

    public void remove(long id) {service.remove(id);
    }

    public void setWedding(long id1, long id2) { service.setWedding(id1, id2);
    }

    public void setDivorce(long id1, long id2) {
        service.setDivorce(id1, id2);
    }

    public void addChild(long id1, long id2) { service.addChild(id1, id2);
    }

    public void addParent(long id1, long id2) { service.addParent(id1, id2);
    }

    public void load(){
        service.load();
    }

    public void save(){
        service.save();
    }

}
