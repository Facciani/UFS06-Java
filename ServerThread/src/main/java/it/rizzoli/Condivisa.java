package it.rizzoli;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Condivisa {
    private static Condivisa instance ;
    private List<Socket> listClient = new ArrayList<>();

    private Condivisa() {
    }

    public static synchronized Condivisa getInstance() {
        if (instance == null) {
            instance = new Condivisa();
        }
        return instance;
    }

    public List<Socket> getListClient() {
        return listClient;
    }

    public synchronized void addSocket(Socket clientSocket){
        this.listClient.add(clientSocket);
    }

    public synchronized void dellSocket(Socket clientSocket){
        for (int i = 0; i < this.listClient.size(); i++){
            if (this.listClient.get(i).getInetAddress().equals(clientSocket.getInetAddress())){
                this.listClient.remove(i);
            }
        }
    }
}
