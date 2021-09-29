package com.weisong.test;

import com.weisong.dao.BookDao;
import com.weisong.dao.impl.BookDaoImpl;
import com.weisong.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author 李伟松
 * @create 2021-09-29-16:03
 */
public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "伟松记", "李伟松", new BigDecimal(56), 106, 2, null));
    }

    @Test
    public void deleteBookById() {

    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(25, "松记", "李伟松", new BigDecimal(56), 106, 2, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(25));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook:bookDao.queryBooks()){
            System.out.println(queryBook);
        }
    }
}