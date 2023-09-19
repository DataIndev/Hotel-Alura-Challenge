package org.dataindev.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroReserva;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private float valor;
    private String formaDePago;

}
