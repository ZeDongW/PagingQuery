package cn.zedongw.service.impl;

import cn.zedongw.dao.IStudentsDao;
import cn.zedongw.dao.impl.StudentsDao;
import cn.zedongw.entity.PageBean;
import cn.zedongw.entity.Students;
import cn.zedongw.service.IStudentsService;

/**
 * @Author ZeDongW
 * @ClassName StudentsService
 * @Description 分页查询业务逻辑实现
 * @Version 1.0
 * @date ：Created in 2019/6/20 0020 11:54
 * @modified By：
 */

public class StudentsService implements IStudentsService {
    //数据访问层
    private IStudentsDao dao = new StudentsDao();

    @Override
    public void getAll(PageBean<Students> pb) {
        dao.getAll(pb);
    }
}
