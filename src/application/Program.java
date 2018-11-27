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
			System.out.println("--------------------------------------------------");
			System.out.println("Entre com os dados para atualizar a reserva: ");
			System.out.print("Check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());	
			String erro = reserva.atualizaData(checkIn, checkOut);
			
			if (erro != null) {
				System.out.println(erro);
			} else {
				System.out.println("Reserva: " + reserva);
			}		
		}
		sc.close();
	}
}
