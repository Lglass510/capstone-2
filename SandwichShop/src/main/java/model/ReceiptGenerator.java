package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptGenerator {


        public static void generateReceipt(Order order) {

            String folderName = "receipts";
            File folder = new File("receipts");

            if (!folder.exists()){
                folder.mkdirs();
            }




            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = "receipt_" + timestamp + ".txt";

            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write("--- Subs4U Order Receipt ---\n\n");

                for (Sandwich sandwich : order.getSandwiches()) {
                    writer.write(sandwich.toString() + "\n");
                }

                if (!order.getSides().isEmpty()) {
                    writer.write("\nChips:\n");
                    for (SideItem side : order.getSides()) {
                        writer.write("- " + side.getName() + " ($" + String.format("%.2f", side.getPrice()) + ")\n");
                    }
                }

                writer.write("\nTotal: $" + String.format("%.2f", order.calculateTotalPrice()) + "\n");
                writer.write("Time: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");

            } catch (IOException e) {
                System.out.println("Failed to write receipt: " + e.getMessage());
            }
        }
    }


