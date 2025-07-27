import java.util.ArrayList;
import java.util.Scanner;

public class ReservationSystem {
    private BusDatabase busDatabase = new BusDatabase();
    private ArrayList<Reservation> reservations = new ArrayList<>();

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n==== Bus Reservation Menu ====");
            System.out.println("1. View Buses");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Reservations");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume newline

            switch (choice) {
                case 1 -> busDatabase.showAllBuses();
                case 2 -> bookSeat(sc);
                case 3 -> cancelReservation(sc);
                case 4 -> showReservations();
                case 5 -> {
                    System.out.println("Thank you for using the system.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void bookSeat(Scanner sc) {
        System.out.print("Enter Passenger Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Bus ID: ");
        int busId = sc.nextInt();
        System.out.print("Number of Seats: ");
        int seats = sc.nextInt();

        Bus bus = busDatabase.getBusById(busId);
        if (bus != null && bus.reserveSeats(seats)) {
            Reservation res = new Reservation(name, busId, seats);
            reservations.add(res);
            System.out.println("Booking successful! Reservation ID: " + res.getReservationId());
        } else {
            System.out.println("Booking failed. Bus not found or insufficient seats.");
        }
    }

    private void cancelReservation(Scanner sc) {
        System.out.print("Enter Reservation ID to cancel: ");
        int resId = sc.nextInt();
        for (int i = 0; i < reservations.size(); i++) {
            if (reservations.get(i).getReservationId() == resId) {
                Bus bus = busDatabase.getBusById(reservations.get(i).getBusId());
                if (bus != null) {
                    bus.cancelSeats(reservations.get(i).getSeatsBooked());
                }
                reservations.remove(i);
                System.out.println("Reservation canceled.");
                return;
            }
        }
        System.out.println("Reservation ID not found.");
    }

    private void showReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation r : reservations) {
                r.showDetails();
            }
        }
    }
}
