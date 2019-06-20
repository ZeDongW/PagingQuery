package cn.zedongw.service;

import cn.zedongw.entity.Students;
import cn.zedongw.entity.PageBean;

/**
 * @Author: ZeDongW
 * @Description: 业务逻辑层接口
 * @Date: 2019/6/20 0020 11:50
 * @Param: 
 * @return: 
 */ 
public interface IStudentsService {

    /**
     * @Author: ZeDongW
     * @Description: 分页查询数据
     * @Date: 2019/6/20 0020 11:53
     * @Param: [pb]
     * @return: void
     */ 
    public void getAll(PageBean<Students> pb);
}
