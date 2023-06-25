package it.rizzoli;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.URI;

public class MyHandler implements HttpHandler {

    private Concessionario c;
    Command command;

    private static final String OpenTable = "<html><body><table>\n" +
            "  <tr>\n" +
            "    <th>Prezzo</th>\n" +
            "    <th>Marca</th>\n" +
            "    <th>KM</th>\n" +
            "    <th>Voto</th>\n" +
            "  </tr>";
    private static final String CloseTable = "</html></body></table>";

    public MyHandler() {
        this.c = Concessionario.getInstance();
        this.command = new Command();
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        System.out.println(exchange.getRemoteAddress().getAddress());

        OutputStream os = exchange.getResponseBody();
        URI uri = exchange.getRequestURI();

        if (uri.getPath().equalsIgnoreCase("/more_expensive")) {
            String result = OpenTable + c.getMoreExprensive() + CloseTable;

            exchange.sendResponseHeaders(200, result.length());
            os.write(result.getBytes());
            os.close();

        } else if (uri.getPath().equalsIgnoreCase("/all")) {

            String result = OpenTable + c.getAllCars() + CloseTable;

            exchange.sendResponseHeaders(200, result.length());
            os.write(result.getBytes());
            os.close();

        } else if (uri.getPath().equalsIgnoreCase("/all_sorted")) {

            String result = OpenTable + c.getAllCarsSorted() + CloseTable;

            exchange.sendResponseHeaders(200, result.length());
            os.write(result.getBytes());
            os.close();

        }
    }
}
