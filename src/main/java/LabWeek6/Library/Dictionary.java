package LabWeek6.Library;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {
    private HashMap<String, String> translations;

    public Dictionary() {
        this.translations = new HashMap<>();
    }

    public void add(String word, String translation) {
        this.translations.put(word, translation);
    }


    public String translate(String word) {
        return this.translations.get(word);
    }

    public int amountOfWords() {
        return this.translations.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> list = new ArrayList<>();
        for (String key : this.translations.keySet()) {
            list.add(key + " = " + this.translations.get(key));
        }
        return list;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");
        dictionary.add("cembalo", "harpsichord");
        System.out.println(dictionary.translate("apina"));
        System.out.println(dictionary.translate("porkkana"));
        System.out.println(dictionary.amountOfWords());
        dictionary.add("cembalo", "harpsichord");
        System.out.println(dictionary.amountOfWords());
    }
}


class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = reader.nextLine();

            if (command.equals("quit")) {
                System.out.println("Goodbye!");
                break;
            } else if (command.equals("add")) {
                add();
            } else if (command.equals("translate")) {
                translate();
            } else {
                System.out.println("Unknown statement");
            }
        }
    }

    private void add() {
        System.out.print("Word: ");
        String word = reader.nextLine();
        System.out.print("Translation: ");
        String translation = reader.nextLine();
        dictionary.add(word, translation);
        System.out.println("Added!");
    }

    private void translate() {
        System.out.print("Word: ");
        String word = reader.nextLine();
        String translation = dictionary.translate(word);
        if (translation != null) {
            System.out.println("Translation: " + translation);
        } else {
            System.out.println("The word '" + word + "' is not in the dictionary.");
        }
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");
        dictionary.add("cembalo", "harpsichord");

        ArrayList<String> translations = dictionary.translationList();
        for (String translation : translations) {
            System.out.println(translation);
        }

        Scanner reader = new Scanner(System.in);
        TextUserInterface ui = new TextUserInterface(reader, dictionary);
        ui.start();
    }
}


