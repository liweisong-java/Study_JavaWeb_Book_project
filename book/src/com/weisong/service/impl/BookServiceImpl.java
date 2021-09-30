package com.weisong.service.impl;

import com.weisong.dao.BookDao;
import com.weisong.dao.impl.BookDaoImpl;
import com.weisong.pojo.Book;
import com.weisong.service.BookService;

import java.util.List;

/**
 * @author 李伟松
 * @create 2021-09-30-15:18
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }


    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

}
