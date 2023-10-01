package org.dataindev.dao;


import org.dataindev.model.Reserva;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    private final Connection connection;
    public ReservaDAO(Connection connection) {
        this.connection = connection;
    }

    public void guardar(Reserva reserva) {
        try {
            String sql = "INSERT INTO reservas (checkIn, checkOut, valor, formaPago) VALUES (?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstm.setDate(1, reserva.getCheckIn());
                pstm.setDate(2, reserva.getCheckOut());
                pstm.setFloat(3, reserva.getValor());
                pstm.setString(4, reserva.getFormaDePago());

                pstm.executeUpdate();

                try (ResultSet rst = pstm.getGeneratedKeys()) {
                    while (rst.next()) {
                        reserva.setNumeroReserva(rst.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Reserva> buscar() {
        List<Reserva> reservas = new ArrayList<>();
        try {
            String sql = "SELECT numeroReserva, checkIn, checkOut, valor, formaPago FROM reservas";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();

                transformarResultSetEnReserva(reservas, pstm);
            }
            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Reserva> buscarId(String id) {
        List<Reserva> reservas = new ArrayList<>();
        try {

            String sql = "SELECT numeroReserva, checkIn, checkOut, valor, formaPago FROM reservas WHERE numeroReserva = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, id);
                pstm.execute();

                transformarResultSetEnReserva(reservas, pstm);
            }
            return reservas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminar(Long id) {
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM reservas WHERE numeroReserva = ?")) {
            stm.setLong(1, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Actualizar(Date fechaE, Date fechaS, String valor, String formaPago, Integer id) {
        try (PreparedStatement stm = connection
        .prepareStatement("UPDATE reservas SET checkIn = ?, checkOut = ?, valor = ?, formaPago = ? WHERE numeroReserva = ?")) {
            stm.setDate(1, fechaE);
            stm.setDate(2, fechaS);
            stm.setString(3, valor);
            stm.setString(4, formaPago);
            stm.setInt(5, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void transformarResultSetEnReserva(List<Reserva> reservas, PreparedStatement pstm) throws SQLException {
        try (ResultSet rst = pstm.getResultSet()) {
            while (rst.next()) {
                Reserva produto = new Reserva(rst.getLong(1), rst.getDate(2), rst.getDate(3), rst.getFloat(4), rst.getString(5));

                reservas.add(produto);
            }
        }
    }

}
