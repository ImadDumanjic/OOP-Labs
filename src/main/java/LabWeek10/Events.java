package LabWeek10;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.*;

public class Events{
    public void generateEventFiles(String filename, int numberOfRecords){
        Random rand = new Random();
        String[] eventTypes = {"Login", "Logout", "Purchase", "ViewPage", "Error"};
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            for (int i = 0; i < numberOfRecords; i++) {

                LocalDateTime randomTime = LocalDateTime.now().minusDays(rand.nextInt(365));
                String timestamp = randomTime.format(formatter);

                String eventType = eventTypes[rand.nextInt(eventTypes.length)];

                int userId = rand.nextInt(1000);

                writer.write(timestamp + " | Event Type: " + eventType + " | User ID: " + userId);
                writer.newLine();
            }
            System.out.println("Events file generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printEventsFromFile(String filename){
        try(
                BufferedReader reader = new BufferedReader(
                        new FileReader(filename)
                )){
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFromFile(String filename){
        ArrayList<String> events = new ArrayList<>();
        try(
                BufferedReader reader = new BufferedReader(
                        new FileReader(filename)
                )){
            String line;
            while((line = reader.readLine()) != null){
                events.add(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return events;
    }

    public static void main(String[] args) {
        Events events = new Events();

        String filename = "events.txt";
        events.generateEventFiles(filename, 10);

        System.out.println("\nEvents from file:");
        events.printEventsFromFile(filename);

        ArrayList<String> eventRecords = events.readFromFile(filename);
        System.out.println("\nEvents as ArrayList:");
        for (String event : eventRecords) {
            System.out.println(event);
        }
    }
}
