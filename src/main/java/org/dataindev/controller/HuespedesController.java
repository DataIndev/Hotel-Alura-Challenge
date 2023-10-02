package org.dataindev.controller;

import org.dataindev.dao.HuespedDAO;
import org.dataindev.model.Huesped;
import org.dataindev.services.ConnectionService;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class HuespedesController {
    private HuespedDAO huespedDAO;

    public HuespedesController() {
        Connection connection = new ConnectionService().recoveryConnection();
        this.huespedDAO = new HuespedDAO(connection);
    }

    public void guardar(Huesped huespedes) {
        this.huespedDAO.guardar(huespedes);
    }
    public List<Huesped> listarHuespedes() {
        return this.huespedDAO.listarHuespedes();
    }

    public List<Huesped> listarHuespedesId(String id) {
        return this.huespedDAO.buscarId(id);
    }

    public void actualizar(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono, Integer idReserva, Integer id) {
        this.huespedDAO.actualizar(nombre, apellido, fechaN, nacionalidad, telefono, idReserva, id);
    }

    public void eliminar(Long id) {
        this.huespedDAO.eliminar(id);
    }
}
