package main.java.com.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String password = "default";

    static Scanner scanner = new Scanner(System.in);

    static String email_pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    static String name_pattern = "^[a-zA-Z\\-]{3,}";

    public static void main(String[] args) {
        run();
    }

    static void run (){
        if (auth()) {
            registerNewClient();
        }

    }



    static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = scanner.nextLine();

            if (password.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }
        System.out.println(accepted ? "Welcome to the Magic  Vet!" : "Application has been blocked.");
        return accepted;
    }
    static void registerNewClient() {
        System.out.println("Please, provide client details.");
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("First name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last name: ");
        String lastName = scanner.nextLine();

        if (isEmailValid(email) && isNameValid(firstName) && isNameValid(lastName) ) {
            Client client = buildClient(email, firstName, lastName);
            System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");
        } else {
            System.out.println("Provided email or name are invalid");
        }
    }

    static Client buildClient(String email, String firstName, String lastName) {
         Client client = new Client();
         client.email = email;
         client.firstName = firstName;
         client.lastName = lastName;
         return client;
     }

     static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(name_pattern);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}