import java.io.*;

public class FileManager {

    public static void saveBooking(Ticket ticket) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter("bookings.txt", true))) {

            writer.write(
                    "PNR: " + ticket.getPnr()
                    + " | Train: "
                    + ticket.getTrain().getTrainName()
                    + " | Seat: Row "
                    + ticket.getRow()
                    + " Seat "
                    + ticket.getSeat()
            );

            writer.newLine();

            System.out.println("Booking saved to file.");

        } catch (IOException e) {

            System.out.println(
                    "Error while saving booking: "
                    + e.getMessage()
            );
        }
    }

    public static void readBookings() {

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader("bookings.txt"))) {

            String line;

            System.out.println("\n----- Saved Bookings -----");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {

            System.out.println("No booking file found.");

        } catch (IOException e) {

            System.out.println(
                    "Error reading file: "
                    + e.getMessage()
            );
        }
    }
}