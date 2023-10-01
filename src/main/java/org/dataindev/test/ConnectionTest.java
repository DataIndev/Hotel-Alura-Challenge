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
            stmt.execute("SELECT * FROM huespedes");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()){
            }

        }catch(Exception e){
        }

        System.out.println(con);
    }
}
