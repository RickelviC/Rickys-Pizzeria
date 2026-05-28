package com.pluralsight.Plaza.Pizzeria.util;

import com.pluralsight.Plaza.Pizzeria.interfaces.IPriceable;
import com.pluralsight.Plaza.Pizzeria.model.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileManager {

    public void saveOrder(Order order) {
        File folder = new File("src/main/java/com/pluralsight/Plaza/receipts");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        File receipt = new File(folder, "receipt_" + timestamp + ".txt");

        try (PrintWriter writer = new PrintWriter(new FileWriter(receipt))) {
            writer.println("----------- RECEIPT -----------");
            writer.println("order ID: " + order.getId());
            writer.println("-----------------------------");
           for (IPriceable item : order.getItems()) {
                writer.println(item );
            }
            writer.println("-----------------------------");
            writer.println("total: $" + String.format("%.2f", order.getTotalPrice()));
            writer.println("-----------------------------");
        } catch (Exception ex) {
            System.err.println("did not save receipt");
        }

    }
}
