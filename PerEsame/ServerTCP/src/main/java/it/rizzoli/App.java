package it.rizzoli;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Hello world!
 *
 */
public class App
{
    public static int portNumber = 1234;
    public static Cars cars = Cars.getInstance();

    public static void main( String[] args )
    {
        cars.add(new Car(123,"bmw",3594.9, 2));
        cars.add(new Car(3634,"audi",38346.9, 1));
        cars.add(new Car(135,"ferrari",130000.4, 10));

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("----------------");
        System.out.println("Server avviato");
        System.out.println("---------------");

        ServerListen sl = new ServerListen(serverSocket);
        sl.start();
    }
}
