package notebook.model.repository;

import notebook.model.User;

import java.util.List;

/**
 * Репозиторий, для выполнения CreateReadUpdateDelete (CRUD) операций
 * @param <E> тип модели данных
 * @param <I> тип ID модели данных E
 */
public interface GBRepository<E, I> {
    List<E> findAll();
    void create(E e);
    E findById(I id);
    void update(I id, E e);
    boolean delete(I id);
    List<E> upLoad();
    void downLoad(List<User> users);
    void finish();
}
