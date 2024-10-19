package hotelManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class GuestsController {
	
	public static void addNewGuest(ArrayList<Guest> guests, Scanner input ) {
		System.out.println("Enter guest name: ");
		String name = input.next();
		System.out.println("Enter email: ");
		String email = input.next();
		System.out.println("Enter discount (int): ");
		int discount = input.nextInt();
		Guest guest = new Guest(guests.size(), name , email, discount);
		guests.add(guest);
	}
	
	public static void showAllGuests(ArrayList<Guest> guests) {
		for (Guest guest : guests) {
			System.out.println("-------------------------");
			guest.print();
			System.out.println("-------------------------");
			System.out.println();
		}
	}
	public static void searchGuestByName(ArrayList<Guest> guests, Scanner input) {
		System.out.println("Enter guest´s name: ");
		String name = input.next();
		for(Guest guest : guests) {
			if(guest.getName().equals(name)) {
				guest.print();
				System.out.println();
			}
		}
	}
	
	public static void editGuest(ArrayList<Guest> guests , Scanner input) {
		System.out.println("Enter id:(int) \n -1 to search guest by name");
		int id = input.nextInt();
		if(id ==-1) {
			searchGuestByName(guests,input);
			System.out.println("Enter id:(int) \n");

			id = input.nextInt();
		}
		
		Guest guest = guests.get(id);
		
		System.out.println("Enter name: \n-1 to keep it");
		String name = input.next();
		if(name.equals("-1") ) {name = guest.getName();}
		
		System.out.println("Enter email: \n -1 to keep it");
		String email = input.next();
		if (email.equals("-1")) {email = guest.getEmail();}
		
		System.out.println("Enter discuount (int)\n -1 to keep it");
		int discount = input.nextInt();
		if(discount == (-1)) {discount= guest.getDiscount();}
		
		
		guest.setName(name);
		guest.setEmail(email);
		guest.setDiscount(discount);
		guests.set(id, guest);
		
	}
}

