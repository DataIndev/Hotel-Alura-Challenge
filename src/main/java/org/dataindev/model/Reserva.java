package org.dataindev.model;
import lombok.*;
import java.sql.Date;

@Getter @Setter
@AllArgsConstructor
public class Reserva {
    private Long numeroReserva;
    private Date checkIn;
    private Date checkOut;
    private Float valor;
    private String formaDePago;
    private Integer id;

    public Reserva(Date checkIn, Date checkOut, float valor, String formaDePago) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.formaDePago = formaDePago;
        this.valor = valor;

    }

    public Reserva(long id, Date checkIn, Date checkOut, float valor, String formaDePago) {
        this.id = (int) id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.valor = valor;
        this.formaDePago = formaDePago;
    }
}
