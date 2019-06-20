package cn.zedongw.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * @Author ZeDongW
 * @ClassName JDBCUtils
 * @Description JDBC连接工具
 * @Version 1.0
 * @date ：Created in 2019/6/20 0020 10:01
 * @modified By：
 */

public class JDBCUtils {
    //c3p0连接池
    private static ComboPooledDataSource dataSource;

    //静态代码块初始化连接池
    static {
        dataSource = new ComboPooledDataSource();
    }

    public static QueryRunner getQueryRunner(){
        return new QueryRunner(dataSource);
    }
}
