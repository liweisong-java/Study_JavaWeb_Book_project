package com.weisong.web;

import com.weisong.pojo.Book;
import com.weisong.pojo.Page;
import com.weisong.service.BookService;
import com.weisong.service.impl.BookServiceImpl;
import com.weisong.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 李伟松
 * @create 2021-09-30-16:33
 */
public class BookServlet extends BaseServlet{

    private BookService bookService = new BookServiceImpl();

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2、调用BookService.page(pageNo,pageSize):page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        //3、保存page对象到Request域中
        req.setAttribute("page", page);
        //4、请求转发到pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数id，图书编程
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2、调用bookService.deleteBookById();删除图书
        bookService.deleteBookById(id);
        //3、重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数==封装成为BOOK对象
        Book book = (Book) WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2、调用BookService.updateBook( book );修改图书
        bookService.updateBook(book);
        //3、重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2、调用bookService.queryBookById查询图书
        Book book = bookService.queryBookById(id);
        //3、保存到图书到Request
        req.setAttribute("book", book);
        //4、请求转发到pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2.把全部图书保存到Request域中
        req.setAttribute("books", books);
        //3.请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
