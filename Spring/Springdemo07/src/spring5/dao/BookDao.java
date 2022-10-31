package spring5.dao;

import spring5.entity.Book;

import java.util.List;

public interface BookDao {
    void add(Book book);
    void update(Book book);
    void delete(int id);
    Book findBookInfo(int id);
    void batchAddBook(List<Object[]> batchArgs);

    void batchUpdate(List<Object[]> batchArgs);

    void batchDelete(List<Object[]> batchArgs);
}
