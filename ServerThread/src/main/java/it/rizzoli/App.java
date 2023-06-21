package it.rizzoli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    static final int portNumber = 1234;

    public static void main( String[] args )
    {
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
