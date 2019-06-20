package cn.zedongw.dao;

import cn.zedongw.entity.PageBean;
import cn.zedongw.entity.Students;

/**
 * 数据访问层接口
 */
public interface IStudentsDao {

    /**
     * @Author: ZeDongW
     * @Description: 分页查询所有数据
     * @Date: 2019/6/20 0020 10:10
     * @Param: [pb]
     * @return: void
     */
    public void getAll(PageBean<Students> pb);

    /**
     * @Author: ZeDongW
     * @Description: 查询总记录数
     * @Date: 2019/6/20 0020 10:11
     * @Param: []
     * @return: int
     */
    public int getTotalCount();
}
