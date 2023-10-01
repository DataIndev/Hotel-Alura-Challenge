package org.dataindev.services;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import io.github.cdimascio.dotenv.Dotenv;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionService {

    Dotenv dotenv = Dotenv.load();
    //----------------------------------------------------------------
    //////////////////////////////// SETTINGS ////////////////////////
    private final String userDB = dotenv.get("USER_DB");
    private final String passwordDB = dotenv.get("PASSWORD_DB");
    private final String nameDB = dotenv.get("DATABASE_NAME");
    private final String portDB = dotenv.get("PORT_DB");

    private final String hostDB = dotenv.get("HOST_DB");
    private final String jdbcUrl = "jdbc:mysql://"+hostDB+":"+portDB+"/"+nameDB+"?useSSL=false&serverTimezone=UTC";


    //----------------------------------------------------------------
    private final DataSource dataSource;
    Connection con ;

    public ConnectionService()  {
        System.out.println(jdbcUrl);
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
            throw new RuntimeException(e);
        }
    }
}
