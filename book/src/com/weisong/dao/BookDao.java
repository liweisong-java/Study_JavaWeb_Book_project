package com.weisong.dao;

import com.weisong.pojo.Book;

import java.util.List;

/**
 * @author 李伟松
 * @create 2021-09-29-15:06
 */
public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);
}
