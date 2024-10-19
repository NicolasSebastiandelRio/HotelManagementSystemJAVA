package hotelManagementSystem;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationsController {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	
	public static void createNewReservation(ArrayList<Guest> guests,ArrayList<Reservation> reservations, ArrayList<Room> rooms,Scanner input) {
		System.out.println("Enter Arrival Date:(yyyy-MM-dd) ");
		String arrivalDate = input.next();
		System.out.println("Enter departure date (yyyy-MM-dd): ");
		String departureDate = input.next();
		System.out.println("Enter guest id (int) \n -1 to search guest by name ");
		int guestId = input.nextInt();
		if (guestId == -1) {
			GuestsController.searchGuestByName(guests, input);
			System.out.println("Enter guest id (int) ");
			guestId = input.nextInt();
		}
		System.out.println("Enter room id (int): \n -1 to show all");
		int roomId = input.nextInt();
		if(roomId == -1) {
			RoomsController.showAllRooms(rooms);
			System.out.println("Enter room id (int): ");
			roomId = input.nextInt();
		}
		
		LocalDate arrDate = LocalDate.parse(arrivalDate,formatter);
		LocalDate depDate = LocalDate.parse(departureDate,formatter);
		
		Guest guest = guests.get(guestId);
		Room room = RoomsController.getRoomById(roomId, rooms);
		if(room.isReserved(arrDate, depDate)) {
			System.out.println("This room is reserved!");
			return;
		}else {
			int days = Period.between(arrDate, depDate).getDays();
			double sum = days*room.getPrice();
			double total = sum - sum*guest.getDiscount()/100;
			System.out.println("Total before discount = "+sum);
			System.out.println("Total after discount = "+total);
			System.out.println("Will you pay now? \n1. Yes\n2. No");
			int j = input.nextInt();
			String status;
			if (j==1) {
				status = "Paid";
			}else {
				status = "Reserved";
			}
			Reservation r = new Reservation(arrDate, depDate,total , status, guest, room);
			reservations.add(r);
			r.print();
			System.out.println();
		}
	}
	
	public static void showAllReservations(ArrayList<Reservation> reservations, Scanner input) {
		for(Reservation r: reservations) {
			System.out.println("\n---------------------------------");
			System.out.println("Id: "+reservations.indexOf(r));
			System.out.println("Arrival date: "+r.getArrivalDatetoString());
			System.out.println("Departure date: "+r.getDepartureDatetoString());
			System.out.println("Guest name: "+r.getGuest().getName());
			System.out.println("Room id: "+r.getRoom().getId());
			System.out.println("Price: "+r.getPrice());
			System.out.println("Status: "+r.getStatus());
			System.out.println("---------------------------------\n");

		}
		
	}
	
	public static void getReservationGuestName (ArrayList<Reservation> reservations,Scanner input) {
		System.out.println("Enter guest name: ");
		String guestName = input.next();
		for(Reservation r : reservations) {
			String name = r.getGuest().getName();
			if(guestName.equals(name)) {
				r.print();
			}
		}
	}
	public static void getReservationGuestId(ArrayList<Reservation> reservations,Scanner input) {
		System.out.println("Enter guest Id: (int)");
		int guestId = input.nextInt();
		for(Reservation r : reservations) {
			int id = r.getGuest().getId();
			if(guestId == id) {
				r.print();
			}
		}
		
	}
	
	public static void editReservation(ArrayList<Guest> guests,ArrayList<Reservation> reservations, ArrayList<Room> rooms,Scanner input) {
		System.out.println("Enter reservation id (int):\n-1 to show all reservation ids");
		int id = input.nextInt();
		if(id == -1) {
			showAllReservations(reservations,input);
			System.out.println("Enter reservation id (int):\n-1 to show all reservation ids");
			id = input.nextInt();
		}
		Reservation reservation = reservations.get(id);
		
		System.out.println("Enter arrival date(yyyy-M-dd)\n-1 to keep it");
		String arrivalDate = input.next();
		if(arrivalDate.equals("-1")) {
			arrivalDate = reservation.getArrivalDatetoString();
		}
		
		System.out.println("Enter departure date(yyyy-M-dd)\n-1 to keep it");
		String departureDate = input.next();
		if(departureDate.equals("-1")) {
			departureDate = reservation.getDepartureDatetoString();
		}
		
		System.out.println("Enter room id (int)\n-1 no keep it\n-2 no show all room ids");
		int roomId = input.nextInt();
		if(roomId == -1) {
			roomId = reservation.getRoom().getId();	
		}else if(roomId == -2) {
			RoomsController.showAllRooms(rooms);
			System.out.println("Enter room id (int): ");
			roomId = input.nextInt();
		}
		LocalDate arrDate = LocalDate.parse(arrivalDate,formatter);
		LocalDate depDate = LocalDate.parse(departureDate,formatter);
		
		Guest guest = reservation.getGuest();
		Room room = RoomsController.getRoomById(roomId, rooms);
		if(room.isReserved(arrDate, depDate)) {
			System.out.println("This room is reserved!");
			return;
		}else {
			int days = Period.between(arrDate, depDate).getDays();
			double sum = days*room.getPrice();
			double total = sum - sum*guest.getDiscount()/100;
			System.out.println("Total before discount = "+sum);
			System.out.println("Total after discount = "+total);
			System.out.println("Will you pay now? \n1. Yes\n2. No");
			int j = input.nextInt();
			String status;
			if (j==1) {
				status = "Paid";
			}else {
				status = "Reserved";
			}
			reservation.setArrivalDate(arrDate);
			reservation.setDepartureDate(depDate);
			reservation.setRoom(room);
			reservation.setStatus(status);
			reservation.setPrice(total);
			reservations.set(id,reservation);
			reservation.print();
			System.out.println();
		}
		
	}
	
	public static void payReservation(ArrayList<Reservation> reservations, Scanner input) {
		System.out.println("Enter reservation id(int): \n-1 to show all reservations ids");
		int id = input.nextInt();
		if(id == -1) {
			showAllReservations(reservations,input);
			System.out.println("Enter reservation id (int): ");
			id = input.nextInt();
		}
		
		Reservation reservation = reservations.get(id);
		if(reservation.getStatus().equals("Reserved")) {
			reservation.setStatus("Paid");
			System.out.println("Reservation paid succesfully!");
		}else {
			System.out.println("This reservation is already paid!");
		}
		 
	}
}
