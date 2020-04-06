package client;

import java.io.FileWriter;
import java.io.IOException;

public class ThreadAddress implements Runnable {
    private Address address;

    public ThreadAddress(Address address) {
        this.address = address;
    }


    @Override
    public void run() {
        saveAddressToFile(address);
    }

    private static void saveAddressToFile(Address addresses) {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\IPComp\\IdeaProjects\\Task1Day8\\src\\client\\Address.txt");
            fw.write(addresses.getAddress());
            fw.close();
        } catch (IOException e) {
            System.out.println("Failed Add Address Data");
        }

        System.out.println("Write Address = " + addresses.getAddress());
    }
}

