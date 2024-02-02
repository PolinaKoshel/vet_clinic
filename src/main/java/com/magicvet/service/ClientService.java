package main.java.com.magicvet.service;

import main.java.com.magicvet.Main;
import main.java.com.magicvet.model.Client;
import org.w3c.dom.ls.LSOutput;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME = "^[a-zA-Z-]{3,}";

    public Client registerNewClient(){
        Client client = null;

        System.out.println("Please provide client details.");
        System.out.print("Email: ");
        String email = Main.SCANNER.nextLine();

        if (isEmailValid(email)) {
            client = buildClient(email);
            System.out.println("New client: " + client.getFirstName() + " "
                    + client.getLastName() + " ("
                    + client.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }

        return client;
    }

    private static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);

        System.out.print("Location (KYIV / LVIV / ODESA): ");
        String location = Main.SCANNER.nextLine();
        client.setLocation(Client.Location.valueOf(location));

        System.out.print("First name (at least 3 characters): ");
        client.setFirstName(Main.SCANNER.nextLine());

        System.out.print("Last name (at least 3 characters): ");
        client.setLastName(Main.SCANNER.nextLine());

        if (isFistNameValid(client.getFirstName())
            && isLastNameValid(client.getLastName())) {

            System.out.println("Registration is successful");
            return client;
        } else {
            System.out.println("Please try again.");
            return buildClient(email);
        }
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isFistNameValid(String firstName) {
        Pattern pattern = Pattern.compile(NAME);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }
    private static boolean isLastNameValid(String lastName) {
        Pattern pattern = Pattern.compile(NAME);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }


}
