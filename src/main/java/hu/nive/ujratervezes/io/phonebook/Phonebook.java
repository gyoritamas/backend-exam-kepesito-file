package hu.nive.ujratervezes.io.phonebook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Phonebook {
    void exportPhonebook(Map<String, String> contacts, String output) {
        if (contacts == null || output == null) {
            throw new IllegalArgumentException();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            for (Map.Entry<String, String> phoneBookEntry : contacts.entrySet()) {
                String name = phoneBookEntry.getKey();
                String phoneNumber = phoneBookEntry.getValue();

                writer.write(String.format("%s: %s%n", name, phoneNumber));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}