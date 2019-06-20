package cn.zedongw.dao.impl;

import cn.zedongw.dao.IStudentsDao;
import cn.zedongw.entity.PageBean;
import cn.zedongw.entity.Students;
import cn.zedongw.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * @Author ZeDongW
 * @ClassName StudentsDao
 * @Description 数据访问层接口实现
 * @Version 1.0
 * @date ：Created in 2019/6/20 0020 10:15
 * @modified By：
 */

public class StudentsDao implements IStudentsDao {
    @Override
    public void getAll(PageBean<Students> pb) {
        //获取总记录数
        pb.setTotalCount(this.getTotalCount());
        pb.setTotalPage();

        //设置当前页数大于0且小于等于最大页
        if (pb.getCurrPage() < 1){ //当前查询页面小于1，设置为1
            pb.setCurrPage(1);
        } else if (pb.getCurrPage() > pb.getTotalPage()){  //查询页数大于最大页面数，设置为最大页数
            pb.setCurrPage(pb.getTotalPage());
        }

        int currPage = pb.getCurrPage(); //当前页数

        int index = (currPage - 1) * pb.getPageCount();  //查询起始行

        int pageCount = pb.getPageCount();  //查询行数

        //SQL
        String sql = "select * from students limit ?,?";

        //获取queryrunner对象
        QueryRunner qr = JDBCUtils.getQueryRunner();

        //将查询结果封装成对象
        try {
            pb.setPageData(qr.query(sql, new BeanListHandler<Students>(Students.class), index, pageCount));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getTotalCount() {
        //SQL
        String sql = "select count(1) from students";
        //获取QueryRunner对象
        QueryRunner qr = JDBCUtils.getQueryRunner();
        try {
            //返回查询结果
            return qr.query(sql, new ScalarHandler<Long>()).intValue();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
