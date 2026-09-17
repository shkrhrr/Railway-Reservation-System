public class Ticket {

    private static int pnrCounter = 100000000;

    private int pnr;
    private Passenger passenger;
    private Train train;
    private int row;
    private int seat;

    public Ticket(Passenger passenger, Train train,
                  int row, int seat) {

        this.pnr = ++pnrCounter;
        this.passenger = passenger;
        this.train = train;
        this.row = row;
        this.seat = seat;
    }

    public int getPnr() {
        return pnr;
    }

    public Train getTrain() {
        return train;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public void displayTicket() {

        System.out.println("\n================================");
        System.out.println("       BOOKING CONFIRMED");
        System.out.println("================================");
        System.out.println("PNR       : " + pnr);
        System.out.println("Passenger : " + passenger.getName());
        System.out.println("Phone     : " + passenger.getPhone());
        System.out.println("Train     : " + train.getTrainName());
        System.out.println("Train No  : " + train.getTrainNumber());
        System.out.println("From      : " + train.getSource());
        System.out.println("To        : " + train.getDestination());
        System.out.println("Seat      : Row " + row + ", Seat " + seat);
        System.out.println("Fare      : \u20B9" + (int) train.getFare());
        System.out.println("Status    : CONFIRMED");
        System.out.println("================================");
    }
}