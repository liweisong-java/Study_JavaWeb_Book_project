package com.weisong.web;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
import java.util.zip.CheckedOutputStream;

/**
 * @author 李伟松
 * @create 2021-10-04-14:44
 */
public class ClientBookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();
    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1 获取请求的参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2 调用BookService.page(pageNo，pageSize)：Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);

        page.setUrl("client/bookServlet?action=page");

        //3 保存Page对象到Request域中
        req.setAttribute("page",page);
        //4 请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }


}
