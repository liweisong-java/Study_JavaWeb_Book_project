package com.weisong.test;

import com.weisong.pojo.Book;
import com.weisong.pojo.Page;
import com.weisong.service.BookService;
import com.weisong.service.impl.BookServiceImpl;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.math.BigDecimal;
import java.util.FormatFlagsConversionMismatchException;

import static org.junit.Assert.*;

/**
 * @author 李伟松
 * @create 2021-09-30-15:52
 */
public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook(){
        bookService.addBook(new Book(null, "酒泉", "伟松", new BigDecimal(10000), 100000, 20, null));
    }

    @Test
    public void deleteBookById(){
        bookService.deleteBookById(20);
    }

    @Test
    public void updateBook(){
        bookService.updateBook(new Book(27, "酒泉剑", "伟松", new BigDecimal(55), 100000, 20, null));
    }

    @Test
    public void queryBookById(){
        System.out.println(bookService.queryBookById(27));
    }

    @Test
    public void queryBooks(){
        for (Book queryBook : bookService.queryBooks()){
            System.out.println(queryBook);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }
    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE,10,50));
    }
}