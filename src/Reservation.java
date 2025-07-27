public class Reservation {
    private static int nextId = 1;
    private int reservationId;
    private String passengerName;
    private int busId;
    private int seatsBooked;

    public Reservation(String passengerName, int busId, int seatsBooked) {
        this.reservationId = nextId++;
        this.passengerName = passengerName;
        this.busId = busId;
        this.seatsBooked = seatsBooked;
    }

    public int getReservationId() { return reservationId; }
    public int getBusId() { return busId; }
    public int getSeatsBooked() { return seatsBooked; }

    public void showDetails() {
        System.out.printf("Reservation ID: %d | Passenger: %s | Bus ID: %d | Seats: %d%n",
                reservationId, passengerName, busId, seatsBooked);
    }
}
