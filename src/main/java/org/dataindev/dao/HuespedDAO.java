package org.dataindev.dao;

import org.dataindev.model.Huesped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HuespedDAO {
    private final Connection connection;

    public HuespedDAO(Connection connection) {
        this.connection = connection;
    }

    public void guardar(Huesped huesped) {
        String sqlQuery = "INSERT INTO huespedes (nombre,apellido,fechaNacimiento, nacionalidad, telefono, idReserva) VALUES (?,?,?,?,?,?)";

        try (PreparedStatement pstm = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, huesped.getNombre());
            pstm.setString(2, huesped.getApellido());
            pstm.setDate(3, huesped.getFechaNacimiento());
            pstm.setString(4, huesped.getNacionalidad());
            pstm.setString(5, huesped.getTelefono());
            pstm.setLong(6, huesped.getIdReserva());

            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                while (rs.next()) {
                    huesped.setId(rs.getLong(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Huesped> listarHuespedes(){
        List<Huesped> huespedes = new ArrayList<>();

        try{
            String sqlQuery = "SELECT id, nombre, apellido, fechaNacimiento, nacionalidad, telefono,idReserva FROM huespedes";

            try(PreparedStatement pstm = connection.prepareStatement(sqlQuery)){
                pstm.execute();
                transformarResultSetEnHuesped(huespedes, pstm);
            }
            return huespedes;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Huesped> buscarId(String id) {
        List<Huesped> huespedes = new ArrayList<>();
        try {

            String sql = "SELECT id, nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva FROM huespedes WHERE idReserva = ?";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, id);
                pstm.execute();

                transformarResultSetEnHuesped(huespedes, pstm);
            }
            return huespedes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizar(String nombre, String apellido, Date fechaN, String nacionalidad, String telefono, Integer idReserva, Integer id) {
        try (PreparedStatement stm = connection
        .prepareStatement("UPDATE huespedes SET nombre = ?, apellido = ?, fechaNacimiento = ?, nacionalidad = ?, telefono = ?, idReserva = ? WHERE id = ?")) {
            stm.setString(1, nombre);
            stm.setString(2, apellido);
            stm.setDate(3, fechaN);
            stm.setString(4, nacionalidad);
            stm.setString(5, telefono);
            stm.setInt(6, idReserva);
            stm.setInt(7, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminar(Integer id) {
        try (PreparedStatement stm = connection.prepareStatement("DELETE FROM huespedes WHERE id = ?")) {
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void transformarResultSetEnHuesped(List<Huesped> reservas, PreparedStatement pstm) throws SQLException {
        try (ResultSet rs = pstm.getResultSet()) {
            while (rs.next()) {
                Huesped huespedes = Huesped.builder()
                .id(rs.getLong(1))
                .nombre(rs.getString(2))
                .apellido(rs.getString(3))
                .fechaNacimiento(rs.getDate(4))
                .nacionalidad(rs.getString(5))
                .telefono(rs.getString(6))
                .idReserva(rs.getLong(7))
                .build();
                reservas.add(huespedes);
            }
        }
    }


}
