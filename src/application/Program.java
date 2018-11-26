package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Welcome to the JavaHotel!");
		System.out.println();
		System.out.print("Número do quarto: ");
		int number = sc.nextInt();
		System.out.print("Check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro de reserva : Data check-out deve ser após a data check-in");
		} 
		else {
			Reserva reserva = new Reserva(number, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			System.out.println();
			System.out.print("Atualizar reserva (s/n)? ");
			char at = sc.next().charAt(0);
			
			if (at == 's') {
				System.out.print("Check-in (dd/MM/yyyy): ");
				checkIn = sdf.parse(sc.next());
				System.out.print("Check-out (dd/MM/yyyy): ");
				checkOut = sdf.parse(sc.next());				
				Date now = new Date();
				
				if (checkIn.before(now) || checkOut.before(now)) {
					System.out.println("Erro de reserva: Datas para atualização devem ser futuras.");
				} else if (!checkOut.after(checkIn)) {
					System.out.println("Erro de reserva : Data check-out deve ser após a data check-in");
				} else { 
					reserva.atualizaData(checkIn, checkOut);
					System.out.println("Reserva: " + reserva);
				} 
			}
		}

		sc.close();
	}

}
