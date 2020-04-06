package client;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            System.out.println("Failed Add Order Data");
        }

        System.out.println("Write Address = " + addresses.getAddress());
    }

    private static List<Address> readAddressFromFile() {
        List<Address> addressList = new ArrayList<Address>();


        try {
            FileReader fr = new FileReader("C:\\Users\\IPComp\\IdeaProjects\\Task1Day8\\src\\client\\Address.txt");
            int byteStream;
            StringBuilder dataBuffer = new StringBuilder();
            while ((byteStream = fr.read()) != -1) {
                dataBuffer.append((char) byteStream);
            }

            List<String> arrayBuffer = new ArrayList<String>(Arrays.asList(dataBuffer.toString().split(",")));
            for (String str : arrayBuffer) {
                addressList.add(new Address(str));
            }


        } catch (
                IOException e) {
            System.out.println("Failed Read Order Data");
        }
        return addressList;
    }
}

