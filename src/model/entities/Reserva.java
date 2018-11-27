package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {}
	
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) throws DomainException {	
		
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro de reserva: Data check-out deve ser após a data check-in.");
		}		
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public void atualizaData (Date checkIn, Date checkOut) throws DomainException {		
		Date now = new Date();		
		
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Erro de reserva: Datas para atualização devem ser futuras.");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Erro de reserva: Data check-out deve ser após a data check-in.");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;	
	}

	@Override
	public String toString() {
		return "Quarto " + numeroQuarto + ", checkIn: " + sdf.format(checkIn) + ", checkOut: " + sdf.format(checkOut) + ", " + duracao() + " noites";
	}
	
	
}
