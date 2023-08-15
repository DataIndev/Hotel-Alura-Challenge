package org.dataindev.test;

import org.dataindev.services.ConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionTest {
    public static void main(String[] args) {
        Connection con = new ConnectionService().recoveryConnection();

        try{
            Statement stmt = con.createStatement();
            stmt.execute("SELECT * FROM PRODUCTO");
            ResultSet rs = stmt.getResultSet();
            System.out.println(rs);

        }catch(Exception e){
            throw new RuntimeException();
        }

        System.out.println(con);
    }
}
