package it.rizzoli;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Hello world!
 *
 */
public class App
{
    public static Concessionario cars = Concessionario.getInstance();

    public static void main( String[] args )
    {
        cars.add(new Macchina(123,"bmw",3594.9, 2));
        cars.add(new Macchina(3634,"audi",38346.9, 1));
        cars.add(new Macchina(135,"ferrari",130000.4, 10));

        HttpServer server = null;
        try{
            server = HttpServer.create(new InetSocketAddress(8080), 0);
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("----------------");
        System.out.println("Server avviato");
        System.out.println("---------------");

        if(server != null){
            server.createContext("/all", new MyHandler());
            server.setExecutor(null);

            server.createContext("/all_sort", new MyHandler());
            server.setExecutor(null);

            server.createContext("/more_expensive", new MyHandler());
            server.setExecutor(null);

            server.start();
        }else{
            System.out.println("Impossibile avviare il server");
        }
    }
}
