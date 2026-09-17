public interface Bookable {
    void bookTicket(Passenger passenger, int row, int seat)
            throws SeatNotAvailableException;

    void cancelTicket(int row, int seat);
}