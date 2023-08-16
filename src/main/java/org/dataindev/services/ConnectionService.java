package org.dataindev.services;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionService {

    //----------------------------------------------------------------
    //////////////////////////////// SETTINGS ////////////////////////
    private final String userDB = "root";
    private final String passwordDB = "ethernet";
    private final String nameDB = "tienda";
    private final int portDB = 3306;
    private final String jdbcUrl = "jdbc:mysql://ns1.dataindev.com:"+portDB+"/"+nameDB+"?useSSL=false&serverTimezone=UTC";

    //----------------------------------------------------------------
    private final DataSource dataSource;
    Connection con ;

    public ConnectionService()  {
        var comboPooledDataSource =new ComboPooledDataSource();

        comboPooledDataSource.setJdbcUrl(jdbcUrl);
        comboPooledDataSource.setUser(userDB);
        comboPooledDataSource.setPassword(passwordDB);
        comboPooledDataSource.setMaxPoolSize(10);

        this.dataSource = comboPooledDataSource;
    }

    public Connection recoveryConnection(){
        try{
            return this.dataSource.getConnection();
        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
