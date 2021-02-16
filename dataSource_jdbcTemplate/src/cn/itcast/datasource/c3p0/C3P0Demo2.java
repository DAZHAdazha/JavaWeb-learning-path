package cn.itcast.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        //什么都不传会使用默认配置
        DataSource ds = new ComboPooledDataSource();
//        DataSource ds = new ComboPooledDataSource("mySource");
        for (int i=0; i<31;i++){
            //31个会报错（因为配置文件中max为30)
            Connection conn = ds.getConnection();
            System.out.println(i + ":" + conn);

            if(i == 5){
                conn.close();//归还连接到连接池中
            }

        }

    }


}
