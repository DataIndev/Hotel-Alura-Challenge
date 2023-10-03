package org.dataindev.test;

import org.dataindev.controller.HuespedesController;
import org.dataindev.model.Huesped;
import org.dataindev.services.ConnectionService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ConnectionTest {
    public static void main(String[] args) {
         HuespedesController huespedesController = new HuespedesController();

         List<Huesped> huespedes = huespedesController.listarHuespedes();

         for(Huesped h : huespedes){
             System.out.println(h.getApellido());
         }



    }
}
