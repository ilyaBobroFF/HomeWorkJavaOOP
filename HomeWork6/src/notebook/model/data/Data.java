package notebook.model.data;

import java.util.List;

public interface Data<E> {
    List<E> readData();
    void writeData();
}
