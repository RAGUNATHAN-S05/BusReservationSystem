public class Bus {
    private int busId;
    private String source, destination, departureTime;
    private int totalSeats, availableSeats;

    public Bus(int busId, String source, String destination, String departureTime, int totalSeats) {
        this.busId = busId;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public boolean reserveSeats(int count) {
        if (availableSeats >= count) {
            availableSeats -= count;
            return true;
        }
        return false;
    }

    public void cancelSeats(int count) {
        availableSeats += count;
    }

    public void showDetails() {
        System.out.printf("Bus ID: %d | From: %s | To: %s | Time: %s | Available Seats: %d%n",
                busId, source, destination, departureTime, availableSeats);
    }

    public int getBusId() { return busId; }
    public int getAvailableSeats() { return availableSeats; }
}
