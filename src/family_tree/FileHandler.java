package family_tree;

import java.io.*;

public class FileHandler implements Writable{
    public boolean save(Serializable serializable, String filePath){
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objOut.writeObject(serializable);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Object load(String filePath) {
        try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(filePath))) {
            return objInput.readObject();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
