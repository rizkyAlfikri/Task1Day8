package server;

import client.Address;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadReadAddress implements Runnable {

    @Override
    public void run() {
        List<Address> addressList = new ArrayList<Address>(readAddressFromFile());


            System.out.println("Read Address = " + addressList.get(0).getAddress());

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
            System.out.println("Failed Read Address Data");
        }
        return addressList;
    }
}
