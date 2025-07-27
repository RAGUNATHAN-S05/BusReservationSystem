import java.util.ArrayList;

public class BusDatabase {
    private ArrayList<Bus> buses = new ArrayList<>();

    public BusDatabase() {
        buses.add(new Bus(101, "Delhi", "Jaipur", "08:00 AM", 40));
        buses.add(new Bus(102, "Mumbai", "Pune", "10:30 AM", 35));
        buses.add(new Bus(103, "Chennai", "Bangalore", "07:00 AM", 50));
    }

    public void showAllBuses() {
        for (Bus bus : buses) {
            bus.showDetails();
        }
    }

    public Bus getBusById(int busId) {
        for (Bus bus : buses) {
            if (bus.getBusId() == busId) return bus;
        }
        return null;
    }
}
