package com.magicvet.service;

import com.magicvet.Main;
import com.magicvet.model.Client;
import org.w3c.dom.ls.LSOutput;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService { // FIXME: add interface ClientService (SOLID)

    // TODO: change String to the Pattern
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME = "^[a-zA-Z-]{3,}";

    public Optional<Client> registerNewClient(){
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

        return Optional.ofNullable(client);
    }

    private static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);

        System.out.print("Location (KYIV / LVIV / ODESA): ");
        String location = Main.SCANNER.nextLine();
        client.setLocation(Client.Location.fromString(location));


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

    //TODO: all statics method refactors to validator diretory and make not static.
    // I should make interface: ValidationService and Override the methods.
    // Interface ValidationService make in service package. Add the package validation
    // Implamantation for ValidationService make in package impl

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
