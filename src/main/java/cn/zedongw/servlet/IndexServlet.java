package cn.zedongw.servlet;

import cn.zedongw.entity.PageBean;
import cn.zedongw.entity.Students;
import cn.zedongw.service.impl.StudentsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ZeDongW
 * @ClassName IndexServlet
 * @Description 控制层
 * @Version 1.0
 * @date ：Created in 2019/6/20 0020 14:46
 * @modified By：
 */

public class IndexServlet extends HttpServlet {
    //创建Service实例
    private StudentsService service = new StudentsService();
    //创建pagebean对象
    private PageBean pb = new PageBean<Students>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取页面参数
        String currPage = req.getParameter("currPage");  //当前页
        String pageCount = req.getParameter("pageCount"); //查询行数

        // 判断
        if (currPage == null || "".equals(currPage.trim())){
            currPage = "1";  	// 第一次访问，设置当前页为1;
        }

        // 判断
        if (pageCount == null || "".equals(pageCount.trim())){
            pageCount = "5";  	// 第一次访问，查询行数5;
        }

        //封装属性
        pb.setPageCount(Integer.parseInt(pageCount));
        pb.setCurrPage(Integer.parseInt(currPage));

        //调用Service
        service.getAll(pb);

        //将pagebean对象保存到request域中
        req.setAttribute("pb", pb);

        //转发页面
        req.getRequestDispatcher("/WEB-INF/page/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
