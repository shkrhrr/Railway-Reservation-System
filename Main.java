import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ReservationService system =
            new ReservationService();

    public static void main(String[] args) {

        // Sample trains
        system.addTrain(
                new Train(
                        12951,
                        "Rajdhani Express",
                        "Bhopal",
                        "New Delhi",
                        850
                )
        );

        system.addTrain(
                new Train(
                        12155,
                        "Bhopal Express",
                        "Bhopal",
                        "Mumbai",
                        650
                )
        );

        system.addTrain(
                new Train(
                        12627,
                        "Karnataka Express",
                        "Bhopal",
                        "Bangalore",
                        1100
                )
        );

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("   RAILWAY RESERVATION SYSTEM");
            System.out.println("=================================");

            System.out.println("1. View All Trains");
            System.out.println("2. Search Train");
            System.out.println("3. Check Seat Availability");
            System.out.println("4. Book Ticket");
            System.out.println("5. Cancel Ticket");
            System.out.println("6. Check PNR Status");
            System.out.println("7. View All Bookings");
            System.out.println("8. View Saved Bookings");
            System.out.println("9. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    system.displayAllTrains();
                    break;

                case 2:
                    searchTrain();
                    break;

                case 3:
                    checkSeats();
                    break;

                case 4:
                    bookTicket();
                    break;

                case 5:
                    cancelTicket();
                    break;

                case 6:
                    checkPNR();
                    break;

                case 7:
                    system.displayBookings();
                    break;

                case 8:
                    FileManager.readBookings();
                    break;

                case 9:
                    System.out.println(
                            "Thank you for using Railway Reservation System!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice!"
                    );
            }

        } while (choice != 9);

        sc.close();
    }

    static void searchTrain() {

        sc.nextLine();

        System.out.print("Enter source: ");
        String source = sc.nextLine();

        System.out.print("Enter destination: ");
        String destination = sc.nextLine();

        Train train =
                system.searchTrain(source, destination);

        if (train != null) {
            train.displayTrain();
        } else {
            System.out.println(
                    "No train found for this route."
            );
        }
    }

    static void checkSeats() {

        System.out.print("Enter train number: ");
        int number = sc.nextInt();

        Train train = system.findTrain(number);

        if (train != null) {
            train.displaySeats();
            System.out.println(
                    "Available seats: "
                    + train.getAvailableSeats()
            );
        } else {
            System.out.println("Train not found.");
        }
    }

    static void bookTicket() {

        sc.nextLine();

        System.out.print("Passenger name: ");
        String name = sc.nextLine();

        System.out.print("Phone number: ");
        String phone = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Gender: ");
        String gender = sc.nextLine();

        Passenger passenger =
                new Passenger(name, phone, age, gender);

        System.out.print("Enter train number: ");
        int trainNumber = sc.nextInt();

        Train train = system.findTrain(trainNumber);

        if (train == null) {
            System.out.println("Train not found.");
            return;
        }

        train.displaySeats();

        System.out.print("Enter row (1-5): ");
        int row = sc.nextInt();

        System.out.print("Enter seat (1-10): ");
        int seat = sc.nextInt();

        try {

            Ticket ticket =
                    system.bookTicket(
                            passenger,
                            trainNumber,
                            row,
                            seat
                    );

            ticket.displayTicket();

            FileManager.saveBooking(ticket);

        } catch (SeatNotAvailableException e) {

            System.out.println(
                    "Booking failed: "
                    + e.getMessage()
            );
        }
    }

    static void cancelTicket() {

        System.out.print("Enter PNR: ");
        int pnr = sc.nextInt();

        boolean cancelled =
                system.cancelTicket(pnr);

        if (cancelled) {
            System.out.println(
                    "Ticket cancelled successfully."
            );
        } else {
            System.out.println(
                    "PNR not found."
            );
        }
    }

    static void checkPNR() {

        System.out.print("Enter PNR: ");
        int pnr = sc.nextInt();

        Ticket ticket =
                system.findTicket(pnr);

        if (ticket != null) {
            ticket.displayTicket();
        } else {
            System.out.println(
                    "No active ticket found for this PNR."
            );
        }
    }
}