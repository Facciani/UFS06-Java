package it.rizzoli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket clientSocket;
    private BufferedReader in;

    private Condivisa c;

    public ServerThread(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        this.in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
        this.c = Condivisa.getInstance();
    }

    @Override
    public void run() {
        while(!clientSocket.isClosed()){
            try {
                readWrite();
            } catch (IOException e) {
                System.out.println(this.clientSocket.getInetAddress() + " : ERROR = " + e.getMessage());
            }
        }
        this.c.dellSocket(this.clientSocket);
        System.out.println(this.clientSocket.getInetAddress() + " : Disconnesso");
    }

    private void readWrite() throws IOException{
        String s = "";
        while ((s = in.readLine()) != null) {
            System.out.println(s + " : " + clientSocket.getInetAddress());
            sendToAll(s.toUpperCase());
        }
        this.clientSocket.close();
    }

    private void sendToAll(String s) throws IOException{
        for (Socket client: this.c.getListClient()) {
            if(!client.getInetAddress().equals(this.clientSocket.getInetAddress())){
                PrintWriter out;
                out = new PrintWriter(client.getOutputStream(), true);
                out.println(this.clientSocket.getInetAddress() + " comunica a tutti = " + s.toUpperCase());
                out.flush();
            }
        }
    }
}
