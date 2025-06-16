/*
 * Class: CMSC203
 * Instructor: [Instructor Name]
 * Description: ESP (Extrasensory Perception) Game to guess randomly selected color names
 * Due: MM/DD/YYYY
 * Platform/compiler: [Your Platform and IDE or command line compiler]
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Print your Name here: Kevin Lopez Estrada
 */
package assignment1v2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class ESPGame {
    public static final String COLOR1 = "black";
    public static final String COLOR2 = "white";
    public static final String COLOR3 = "gray";
    public static final String COLOR4 = "silver";
    public static final String COLOR5 = "maroon";
    public static final String COLOR6 = "red";
    public static final String COLOR7 = "purple";
    public static final String COLOR8 = "fuchsia";
    public static final String COLOR9 = "green";
    public static final String COLOR10 = "lime";
    public static final String COLOR11 = "olive";
    public static final String COLOR12 = "yellow";
    public static final String COLOR13 = "navy";
    public static final String COLOR14 = "blue";
    public static final String COLOR15 = "teal";
    public static final String COLOR16 = "aqua";

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        String name, description, dueDate;
        int guessCorrect;
        String playAgain = null;

        do {
            System.out.println("Welcome to ESP - extrasensory perception!");
            System.out.println("Would you please choose one of the 4 options from the menu:");
            System.out.println("1. Display first 16 colors");
            System.out.println("2. Display first 10 colors");
            System.out.println("3. Display first 5 colors");
            System.out.println("4. Exit from the program");
            System.out.print("Enter the option: ");
            int option = input.nextInt();
            input.nextLine();

            int colorLimit = 0;
            switch (option) {
                case 1: colorLimit = 16; break;
                case 2: colorLimit = 10; break;
                case 3: colorLimit = 5; break;
                case 4: 
                    System.out.print("Enter your name: ");
                    name = input.nextLine();
                    System.out.print("Describe yourself: ");
                    description = input.nextLine();
                    System.out.print("Due Date (MM/DD): ");
                    dueDate = input.nextLine();
                    System.out.println("Username: " + name);
                    System.out.println("User Description: " + description);
                    System.out.println("Date: " + dueDate);
                    return;
                default:
                    System.out.println("Invalid option.");
                    continue;
            }

            File file = new File("colors.txt");
            Scanner fileReader = new Scanner(file);

            System.out.println("There are " + colorLimit + " colors from the file:");
            for (int i = 1; i <= colorLimit && fileReader.hasNext(); i++) {
                System.out.println(i + " " + fileReader.nextLine());
            }

            fileReader.close();

            guessCorrect = 0;
            for (int round = 1; round <= 3; round++) {
                int chosenNumber = rand.nextInt(colorLimit) + 1;
                String chosenColor = getColorByIndex(chosenNumber);

                System.out.println("\nRound " + round);
                System.out.println("I am thinking of a color.\nIs it one of list of colors above?");
                System.out.print("Enter your guess: ");
                String guess = input.nextLine().toLowerCase();

                if (guess.equalsIgnoreCase(chosenColor)) {
                    guessCorrect++;
                }
                System.out.println("I was thinking of " + capitalize(chosenColor) + ".");
            }

            System.out.println("\nGame Over");
            System.out.println("You guessed " + guessCorrect + " out of 3 colors correctly.\n");

            FileWriter writer = new FileWriter("EspGameResults.txt");
            System.out.print("Enter your name: ");
            name = input.nextLine();
            System.out.print("Describe yourself: ");
            description = input.nextLine();
            System.out.print("Due Date (MM/DD): ");
            dueDate = input.nextLine();

            writer.write("Game Over\nYou guessed " + guessCorrect + " out of 3 colors correctly.\n");
            writer.write("Due Date: " + dueDate + "\n");
            writer.write("Username: " + name + "\n");
            writer.write("User Description: " + description + "\n");
            writer.write("Date: " + dueDate + "\n");
            writer.close();

            System.out.print("Would you like to continue a Game? Type Yes/No: ");
            playAgain = input.nextLine();
        } while (playAgain.equalsIgnoreCase("Yes"));

        input.close();
    }

    public static String getColorByIndex(int index) {
        switch(index) {
            case 1: return COLOR1;
            case 2: return COLOR2;
            case 3: return COLOR3;
            case 4: return COLOR4;
            case 5: return COLOR5;
            case 6: return COLOR6;
            case 7: return COLOR7;
            case 8: return COLOR8;
            case 9: return COLOR9;
            case 10: return COLOR10;
            case 11: return COLOR11;
            case 12: return COLOR12;
            case 13: return COLOR13;
            case 14: return COLOR14;
            case 15: return COLOR15;
            case 16: return COLOR16;
            default: return "";
        }
    }

    public static String capitalize(String str) {
        if (str == null || str.length() == 0) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
