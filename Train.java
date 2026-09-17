public class Train implements Bookable {

    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private double fare;

    // 5 rows × 10 seats
    private boolean[][] seats = new boolean[5][10];

    public Train(int trainNumber, String trainName,
                 String source, String destination,
                 double fare) {

        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getFare() {
        return fare;
    }

    public int getAvailableSeats() {
        int count = 0;

        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                if (!seats[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public synchronized void bookTicket(
            Passenger passenger, int row, int seat)
            throws SeatNotAvailableException {

        if (row < 1 || row > 5 || seat < 1 || seat > 10) {
            throw new SeatNotAvailableException(
                    "Invalid seat number!");
        }

        if (seats[row - 1][seat - 1]) {
            throw new SeatNotAvailableException(
                    "Seat is already booked!");
        }

        seats[row - 1][seat - 1] = true;

        System.out.println("\nTicket booked successfully!");
    }

    @Override
    public void cancelTicket(int row, int seat) {

        if (row >= 1 && row <= 5 &&
            seat >= 1 && seat <= 10) {

            seats[row - 1][seat - 1] = false;

            System.out.println("Ticket cancelled successfully.");
        }
    }

    public void displaySeats() {

        System.out.println("\n----- Seat Layout -----");

        for (int i = 0; i < seats.length; i++) {

            System.out.print("Row " + (i + 1) + ": ");

            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j]) {
                    System.out.print("[X] ");
                } else {
                    System.out.print("[" + (j + 1) + "] ");
                }
            }

            System.out.println();
        }

        System.out.println("\n[X] = Booked");
    }

    public void displayTrain() {

        System.out.println("--------------------------------");
        System.out.println("Train No     : " + trainNumber);
        System.out.println("Train Name   : " + trainName);
        System.out.println("From         : " + source);
        System.out.println("To           : " + destination);
        System.out.println("Fare         : ₹" + fare);
        System.out.println("Available    : " + getAvailableSeats());
        System.out.println("--------------------------------");
    }
}