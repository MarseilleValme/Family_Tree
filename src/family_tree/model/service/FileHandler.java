package family_tree.model.service;

import java.io.*;

public class FileHandler implements Writable{
    private String filePath = "src/family_tree/model/data/tree.out";
    public boolean save(Serializable serializable){
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objOut.writeObject(serializable);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Object load() {
        try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(filePath))) {
            return objInput.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}