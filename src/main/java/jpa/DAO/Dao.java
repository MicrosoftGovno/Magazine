package jpa.DAO;


import java.util.List;

public interface Dao<T, E> {
    void createItem(T item);
    void updateItem(T item);
    void deleteItem(T item);
    T readItem(E id);
    List<T> getAllItems();
}
