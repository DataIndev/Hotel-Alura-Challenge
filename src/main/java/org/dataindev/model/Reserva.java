package org.dataindev.model;
import lombok.*;
import java.sql.Date;

@Getter@Setter
@AllArgsConstructor
public class Reserva {
    private Long numeroReserva;
    private Date checkIn;
    private Date checkOut;
    private float valor;
    private String formaDePago;


}
