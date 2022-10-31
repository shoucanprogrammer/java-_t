package spring5.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import spring5.dao.BookDao;
import spring5.entity.Book;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    //注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void add(Book book) {
        String sql = "insert into t_book values(?,?,?)";
        int update = jdbcTemplate.update(sql, book.getUserId(), book.getUsername(), book.getUstatus());
    }

    @Override
    public void update(Book book) {
        String sql = "update t_book set username=?,ustatus=? where userid=?";
        jdbcTemplate.update(sql,book.getUsername(),book.getUstatus(),book.getUserId());
    }

    @Override
    public void delete(int id) {
        String sql = "delete from t_book where userid = ?";
        int update = jdbcTemplate.update(sql,id);
    }

    @Override
    public Book findBookInfo(int id) {
        String sql = "select * from t_book where userid=?";
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
        return book;
    }

    @Override
    public void batchAddBook(List<Object[]> batchArgs) {
        String sql = "insert into t_book values(?,?,?)";
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        String sql = "update t_book set username=?,ustatus=? where userid=?";
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }

    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        String sql = "delete from t_book where userid = ?";
        jdbcTemplate.batchUpdate(sql,batchArgs);
    }
}