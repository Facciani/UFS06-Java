package it.rizzoli;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListen extends Thread{

    private Socket clientSocket;
    private ServerSocket serverSocket;

    private Condivisa c;

    public ServerListen(ServerSocket serverSocket) {
        this.clientSocket = null;
        this.serverSocket = serverSocket;
        this.c = Condivisa.getInstance();
    }

    @Override
    public void run() {
        while (true){
            try {
                this.clientSocket = serverSocket.accept();
                c.addSocket(this.clientSocket);
                System.out.println(this.clientSocket.getInetAddress() + " : Connesso");
                ServerThread thread = new ServerThread(this.clientSocket);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
