package spring5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring5.dao.BookDao;
import spring5.entity.Book;

import java.util.List;

@Service
public class BookService {
    //注入dao
    @Autowired
    private BookDao bookDao;
    //添加的方法
    public void addBook(Book book){
        bookDao.add(book);
    }

    //修改的方法
    public void updateBook(Book book){
        bookDao.update(book);
    }
    public void deleteBook(int id){
        bookDao.delete(id);
    }

    public Book findOne(int id){
        return bookDao.findBookInfo(id);
    }

    //批量添加
    public void batchAdd(List<Object[]> batchArgs){

        bookDao.batchAddBook(batchArgs);
    }
    public void batchUpdate(List<Object[]> batchArgs){

        bookDao.batchUpdate(batchArgs);
    }
    public void batchDelete(List<Object[]> batchArgs){

        bookDao.batchDelete(batchArgs);
    }

}
