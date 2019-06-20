package cn.zedongw.dao.impl;

import cn.zedongw.dao.IStudentsDao;
import cn.zedongw.entity.PageBean;
import cn.zedongw.entity.Students;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentsDaoTest {
    IStudentsDao dao = new StudentsDao();
    @Test
    public void getAll() {
        PageBean pb = new PageBean<Students>();
        pb.setCurrPage(8);
        pb.setPageCount(15);
        dao.getAll(pb);
        System.out.println(pb.getPageData());
    }
}