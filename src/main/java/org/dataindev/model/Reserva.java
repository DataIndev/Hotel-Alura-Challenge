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
    private Integer id;

    public Reserva(Date checkIn, Date checkOut, String valor, String formaPago) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.formaDePago = formaDePago;
        this.valor = Float.parseFloat(valor);

    }

    public Reserva(long id, Date checkIn, Date checkOut, float valor, String formaPago) {
        this.id = (int) id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.valor = Float.parseFloat(String.valueOf(valor));
        this.formaDePago = formaDePago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getfechaE() {
        return checkIn;
    }

    public Date getfechaS() {
        return checkOut;
    }

    public float getvalor() {
        return valor;
    }

    public String getformaPago() {
        return formaDePago;
    }

    public float getValor() {
        return 0;
    }

//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return String.format("La reserva generada fue: %d, %s, %s, %s, %s", this.id, this.checkIn, this.checkOut, this.valor, this.formaDePago);
//	}
}