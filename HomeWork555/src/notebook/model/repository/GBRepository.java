package notebook.model.repository;

import notebook.model.User;

import java.util.List;

/**
 * �����������, ��� ���������� CreateReadUpdateDelete (CRUD) ��������
 * @param <E> ��� ������ ������
 * @param <I> ��� ID ������ ������ E
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
