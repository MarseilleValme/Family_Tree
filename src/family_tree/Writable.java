package family_tree;

import java.io.Serializable;

public interface Writable {
    Object load(String filePath);
    boolean save(Serializable serializable, String filePath);
}
