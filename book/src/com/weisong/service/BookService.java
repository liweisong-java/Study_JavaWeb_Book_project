package com.weisong.service;

import com.weisong.pojo.Book;

import java.util.List;

/**
 * @author 李伟松
 * @create 2021-09-30-15:12
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();
}
