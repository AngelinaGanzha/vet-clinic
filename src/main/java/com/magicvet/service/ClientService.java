package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

   private static final String email_pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

   private static final String name_pattern = "^[a-zA-Z\\-]{3,}";

   public Optional<Client> registerNewClient() {
       Client client = null;
        System.out.println("Please, provide client details.");
        System.out.print("Email: ");
        String email = Main.scanner.nextLine();

        System.out.print("First name: ");
        String firstName = Main.scanner.nextLine();

        System.out.print("Last name: ");
        String lastName = Main.scanner.nextLine();

        if (isEmailValid(email) && isNameValid(firstName) && isNameValid(lastName) ) {
            client = buildClient(email, firstName, lastName);
            System.out.println("New client: " + client.getFirstName() + " "
                    + client.getLastName() + " ("
                    + client.getEmail() + ")");
        } else {
            System.out.println("Provided email or name are invalid");
        }
        return Optional.ofNullable(client);
    }
   private static Client buildClient(String email, String firstName, String lastName) {
        Client client = new Client();
        client.setEmail(email);
        client.setFirstName(firstName);
        client.setLastName(lastName);

        System.out.print("Location: ");

        Client.Location location;
        String locationInput = Main.scanner.nextLine();

        try {
            location = Client.Location.valueOf(locationInput);
        } catch (IllegalArgumentException e) {
            location = Client.Location.Unknown;
            System.out.println("Unable to parse value '" + locationInput + "'. Using default value: " + Client.Location.Unknown);
        }
        client.setLocation(location);
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
