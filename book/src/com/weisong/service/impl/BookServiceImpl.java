package com.weisong.service.impl;

import com.weisong.dao.BookDao;
import com.weisong.dao.impl.BookDaoImpl;
import com.weisong.pojo.Book;
import com.weisong.pojo.Page;
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

    public Page<Book> page(int pageNo ,int pageSize) {
        Page<Book> page = new Page<Book>();


        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pagetotalCount = bookDao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotal(pagetotalCount);
        //求总页码
        Integer pageTotal = pagetotalCount / pageSize;
        if (pagetotalCount % pageSize > 0){
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);

        /*数据边界的有效检查*/
        if (pageNo < 1){
            pageNo = 1;
        }
        if (pageNo > pageTotal){
            pageNo = pageTotal;
        }
        //设置当前页码
        page.setPageNo(pageNo);
        //求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        //设置当前页数据
        page.setItems(items);


        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();

        //设置每页显示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pagetotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        //设置总记录数
        page.setPageTotal(pagetotalCount);
        //求总页码
        Integer pageTotal = pagetotalCount / pageSize;
        if (pagetotalCount % pageSize > 0){
            pageTotal += 1;
        }
        //设置总页码
        page.setPageTotal(pageTotal);

        /*数据边界的有效检查*/
        if (pageNo < 1){
            pageNo = 1;
        }
        if (pageNo > pageTotal){
            pageNo = pageTotal;
        }
        //设置当前页码
        page.setPageNo(pageNo);
        //求当前页数据的开始索引
        int begin = (page.getPageNo() - 1) * pageSize;
        //求当前页数据
        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        //设置当前页数据
        page.setItems(items);


        return page;
    }
}
