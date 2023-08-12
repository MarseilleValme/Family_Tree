package family_tree.model.service;

import java.io.Serializable;

public interface Writable {
    Object load();
    boolean save(Serializable serializable);
}
