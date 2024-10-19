package hotelManagementSystem;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<Room> rooms;
	private static ArrayList<Guest> guests;
	private static ArrayList<Employee> employees;
	private static ArrayList <Reservation> reservations;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		rooms = new ArrayList<>();
		guests = new ArrayList<>();
		employees = new ArrayList<>();
		reservations = new ArrayList<>();
		int i = 0;
		while (i != 17) {
			System.out.println("-------------------------");
			System.out.println("Welcome to Hotel Hilton. ");
			System.out.println("-------------------------");
			
			System.out.println("Please choose one of the options below: ");
			System.out.println("1. Add new room");
			System.out.println("2. Show all rooms");
			System.out.println("3. Edit room data");
			System.out.println("4. Add new guest");
			System.out.println("5. Show all guests");
			System.out.println("6. Search guest by name");
			System.out.println("7. Edit guest data");
			System.out.println("8. Create a new reservation");
			System.out.println("9. Show all reservations");
			System.out.println("10. Get reservation by guest name");
			System.out.println("11. Get reservation by guest id");
			System.out.println("12. Edit reservation");
			System.out.println("13. Pay reservation");
			System.out.println("14. Add new Employee");
			System.out.println("15. Show all employees");
			System.out.println("16. Edit Employee data");
			System.out.println("17. Quit");
			System.out.println();
			
			i = input.nextInt();
			switch (i) {
			case 1: 
				RoomsController.addNewRoom(rooms,input);
				break;
			case 2:
				RoomsController.showAllRooms(rooms);
				break;
				
			case 3:
				RoomsController.editRoom(rooms, input);
				break;
			case 4:
				GuestsController.addNewGuest(guests,input);
				break;
			case 5:
				GuestsController.showAllGuests(guests);
				break;
			case 6:
				GuestsController.searchGuestByName(guests, input);
				break;
			case 7:
				GuestsController.editGuest(guests,input);
				break;
				
			case 8:
				ReservationsController.createNewReservation(guests,reservations,rooms, input);
				break;
			
			case 9:
				ReservationsController.showAllReservations(reservations, input);
				break;
				
			case 10:
				ReservationsController.getReservationGuestName(reservations, input);
				break;
				
			case 11:
				ReservationsController.getReservationGuestId(reservations,input);
				break;
				
			case 12:
				ReservationsController.editReservation(guests, reservations, rooms, input);
				break;
			case 13:
				ReservationsController.payReservation(reservations, input);
				break;
			case 14:
				EmployeesController.addNewEmployee(employees, input);
				break;
				
			case 15:
				EmployeesController.showAllEmployees(employees);
				break;
			case 16:
				EmployeesController.editEmployeeData(employees, input);
				break;
			case 17:
				System.out.println("See you later!");
				input.close();
				return;
				
			default:
				System.out.println("Error, try again");
				break;
			}
			
		}
		

		

	}

}
