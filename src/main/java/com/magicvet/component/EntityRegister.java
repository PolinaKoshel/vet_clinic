package com.magicvet.component;

import com.magicvet.Main;
import com.magicvet.model.Client;
import com.magicvet.model.Pet;
import com.magicvet.service.ClientService;
import com.magicvet.service.PetService;

import java.util.*;
import java.util.stream.Collectors;

public class EntityRegister {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();
    public void registerClients() {
        List<Client> clients = new ArrayList<>();

        String message = "Do you want to register more clients? (y/n): ";
        do {
            Optional<Client> client = addClient();
            client.ifPresent(clients::add);
        } while(verifyRepeating(message));

        Map<Client.Location, List<Client>> clientsByLocation = clients.stream()
                .collect(Collectors.groupingBy(Client::getLocation));

        printClients(clientsByLocation);
    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for(Map.Entry<Client.Location, List<Client>> clients: clientsByLocation.entrySet()) {
            String content = "\nLocation: " + clients.getKey()
                    + "\nClients (" + clients.getValue().size() + "):"
                    + "\n\t" + clients.getValue();

            System.out.println(content);
        }
    }


    private Optional<Client> addClient() {
        Optional<Client> client = clientService.registerNewClient();
        client.ifPresent(this::registerPets);

        return client;
    }
    private void registerPets(Client client) {
        String message = "Do you want to add more pets for the current client? (y/n): ";
        do {
            addPet(client);
            System.out.println(client);
        } while(verifyRepeating(message));
    }
    private void addPet(Client client) {
        System.out.println("Adding a new pet.");

        Pet pet = petService.registerNewPet();

        if (pet != null) {
            client.addPet(pet);
            pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
            System.out.println("Pet has been added.");
        }
    }

    //TODO: refactor verifyRepeating to hasNextClient
    private boolean verifyRepeating(String message) {
        System.out.println(message);

        String answer = Main.SCANNER.nextLine();
        if("y".equals(answer)) {
            return true;
        } else if ("n".equals(answer)) {
            return false;
        } else {
            System.out.println("Incorrect answer. Please try again.");
            return verifyRepeating(message);
        }
    }
}
