package family_tree.model.service;

import java.io.Serializable;

public interface Writable {
    Object load(String filePath);
    boolean save(Serializable serializable, String filePath);
}
