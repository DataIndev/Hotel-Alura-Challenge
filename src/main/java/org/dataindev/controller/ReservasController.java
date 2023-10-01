package org.dataindev.controller;

import org.dataindev.dao.ReservaDAO;
import org.dataindev.model.Reserva;
import org.dataindev.services.ConnectionService;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class ReservasController {

    private final ReservaDAO reservaDAO;

    public ReservasController() {
        Connection connection = new ConnectionService().recoveryConnection();
        this.reservaDAO = new ReservaDAO(connection);
    }

    public void guardar(Reserva reserva) {
        this.reservaDAO.guardar(reserva);
    }

    public List<Reserva> buscar() {
        return this.reservaDAO.buscar();
    }

    public List<Reserva> buscarId(String id) {
        return this.reservaDAO.buscarId(id);
    }

    public void actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
        this.reservaDAO.Actualizar(fechaE, fechaS, valor, formaPago, id);
    }

    public void eliminar(Long id) {
        this.reservaDAO.eliminar(id);
    }
}
