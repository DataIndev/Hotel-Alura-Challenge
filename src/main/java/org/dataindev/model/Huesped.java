package org.dataindev.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter
@AllArgsConstructor
public class Huesped {
    private Long id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private String telefono;
    private Long idReserva;

    public Huesped(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String telefono, Long idReserva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.idReserva = idReserva;
    }
}
