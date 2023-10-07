package org.dataindev.test;

import org.dataindev.controller.HuespedesController;
import org.dataindev.controller.ReservasController;
import org.dataindev.model.Huesped;
import org.dataindev.model.Reserva;
import org.dataindev.services.ConnectionService;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ConnectionTest {
    public static void main(String[] args) {

        ReservasController reservasController = new ReservasController();

        Reserva reserva = new Reserva(Date.valueOf("2023-10-9"),Date.valueOf("2023-10-9"),3500.00F,"Efectivo");

        reservasController.guardar(reserva);




    }
}
