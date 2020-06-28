package dao.impl;

import dao.ItemsDao;
import domain.Items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsDaoImpl implements ItemsDao {
    public List<Items> findAll() throws Exception {
        List<Items> list = new ArrayList<Items>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");

            //获取connection对象
            connection = DriverManager.getConnection("jdbc:mysql:///users?useUnicode=true&characterEncoding=utf8","root","123456");

            //获取真正操作数据库的对象
            pst = connection.prepareStatement("select * from user");

            //执行数据库查询操作
            resultSet = pst.executeQuery();

            //把数据库结果集转为list集合

            while (resultSet.next()){
                Items it = new Items();
                it.setId(resultSet.getInt("id"));
                it.setUsername(resultSet.getString("username"));
                it.setPassword(resultSet.getString("password"));
                list.add(it);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
            pst.close();
            resultSet.close();
        }

        return list;

    }
}
