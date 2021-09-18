package com.weisong.test;

import com.weisong.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author 李伟松
 * @create 2021-09-12-21:58
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);

        }
    }
}
