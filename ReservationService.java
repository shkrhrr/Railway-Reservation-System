import java.util.ArrayList;
import java.util.Stack;

public class ReservationService {

    private ArrayList<Train> trains = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();
    private Stack<Ticket> cancelledTickets = new Stack<>();

    public void addTrain(Train train) {
        trains.add(train);
    }

    public void displayAllTrains() {

        if (trains.isEmpty()) {
            System.out.println("No trains available.");
            return;
        }

        for (Train train : trains) {
            train.displayTrain();
        }
    }

    public Train searchTrain(String source, String destination) {

        for (Train train : trains) {

            if (train.getSource().equalsIgnoreCase(source)
                    && train.getDestination()
                           .equalsIgnoreCase(destination)) {

                return train;
            }
        }

        return null;
    }

    public Train findTrain(int trainNumber) {

        for (Train train : trains) {

            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }

        return null;
    }

    public Ticket bookTicket(Passenger passenger,
                             int trainNumber,
                             int row,
                             int seat)
            throws SeatNotAvailableException {

        Train train = findTrain(trainNumber);

        if (train == null) {
            throw new SeatNotAvailableException(
                    "Train not found!");
        }

        train.bookTicket(passenger, row, seat);

        Ticket ticket =
                new Ticket(passenger, train, row, seat);

        tickets.add(ticket);

        return ticket;
    }

    public boolean cancelTicket(int pnr) {

        for (Ticket ticket : tickets) {

            if (ticket.getPnr() == pnr) {

                ticket.getTrain().cancelTicket(
                        ticket.getRow(),
                        ticket.getSeat()
                );

                cancelledTickets.push(ticket);
                tickets.remove(ticket);

                return true;
            }
        }

        return false;
    }

    public Ticket findTicket(int pnr) {

        for (Ticket ticket : tickets) {

            if (ticket.getPnr() == pnr) {
                return ticket;
            }
        }

        return null;
    }

    public void displayBookings() {

        if (tickets.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        for (Ticket ticket : tickets) {
            ticket.displayTicket();
        }
    }
}