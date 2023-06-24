package it.rizzoli;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Database {

    private static Database instance ;
    private Connection connection;
    private Command command;
    private String url = "jdbc:mysql://localhost/esamejava?user=root&password=password";

    private Database() {
        this.command = new Command();
        try {
            this.connection = DriverManager.getConnection(this.url);

            System.out.println("---------------------------------");
            System.out.println("Connessione con database riuscita");
            System.out.println("---------------------------------");

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Command getMoreExpensive(){
        Statement stmt = null;
        ResultSet rs = null;
        Auto auto = new Auto();

        String result = "";

        try {
            stmt = this.connection.createStatement();

            if (stmt.execute("SELECT prezzo, marca, km, voto FROM auto WHERE prezzo = ( SELECT MAX(prezzo) FROM auto ) ORDER BY prezzo ASC LIMIT 1;")) {
                rs = stmt.getResultSet();

                if(!rs.isBeforeFirst()){
                    this.command.setStato("Error");
                    this.command.setRisultato("Nessun dato presente");

                    return this.command;
                }else{

                    while(rs.next()){
                        int prezzo = rs.getInt("prezzo");
                        String marca = rs.getString("marca");
                        double km = rs.getDouble("km");
                        int voto = rs.getInt("voto");

                        auto.setAll(prezzo,marca,km,voto);
                    }

                    this.command.setStato("OK");
                    this.command.setRisultato(new Gson().toJson(auto));

                    return this.command;
                }
            }

        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                    System.out.println("SQLState: " + sqlEx.getSQLState());
                    System.out.println("VendorError: " + sqlEx.getErrorCode());
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                    System.out.println("SQLState: " + sqlEx.getSQLState());
                    System.out.println("VendorError: " + sqlEx.getErrorCode());
                }
                stmt = null;
            }
        }

        this.command.setStato("Errore");
        this.command.setRisultato("Impossibile eseguire il comando");

        return this.command;
    }

    public Command getAll(){
        Statement stmt = null;
        ResultSet rs = null;
        List<Auto> listAuto = new ArrayList<>();

        String result = "";

        try {
            stmt = this.connection.createStatement();

            if (stmt.execute("SELECT prezzo, marca, km, voto FROM auto;")) {
                rs = stmt.getResultSet();

                if(!rs.isBeforeFirst()){
                    this.command.setStato("Error");
                    this.command.setRisultato("Nessun dato presente");

                    return this.command;
                }else{

                    while(rs.next()){
                        int prezzo = rs.getInt("prezzo");
                        String marca = rs.getString("marca");
                        double km = rs.getDouble("km");
                        int voto = rs.getInt("voto");

                        Auto auto = new Auto();
                        auto.setAll(prezzo,marca,km,voto);

                        listAuto.add(auto);
                    }

                    this.command.setStato("OK");
                    this.command.setRisultato(new Gson().toJson(listAuto));

                    return this.command;
                }
            }

        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                    System.out.println("SQLState: " + sqlEx.getSQLState());
                    System.out.println("VendorError: " + sqlEx.getErrorCode());
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                    System.out.println("SQLState: " + sqlEx.getSQLState());
                    System.out.println("VendorError: " + sqlEx.getErrorCode());
                }
                stmt = null;
            }
        }

        this.command.setStato("Errore");
        this.command.setRisultato("Impossibile eseguire il comando");

        return this.command;
    }

    public Command getAllSorted(){
        Statement stmt = null;
        ResultSet rs = null;
        List<Auto> listAuto = new ArrayList<>();

        String result = "";

        try {
            stmt = this.connection.createStatement();

            if (stmt.execute("SELECT prezzo, marca, km, voto FROM auto ORDER BY marca ASC;")) {
                rs = stmt.getResultSet();

                if(!rs.isBeforeFirst()){
                    this.command.setStato("Error");
                    this.command.setRisultato("Nessun dato presente");

                    return this.command;
                }else{

                    while(rs.next()){
                        int prezzo = rs.getInt("prezzo");
                        String marca = rs.getString("marca");
                        double km = rs.getDouble("km");
                        int voto = rs.getInt("voto");

                        Auto auto = new Auto();
                        auto.setAll(prezzo,marca,km,voto);

                        listAuto.add(auto);
                    }

                    this.command.setStato("OK");
                    this.command.setRisultato(new Gson().toJson(listAuto));

                    return this.command;
                }
            }

        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                    System.out.println("SQLState: " + sqlEx.getSQLState());
                    System.out.println("VendorError: " + sqlEx.getErrorCode());
                }
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    System.out.println("SQLException: " + sqlEx.getMessage());
                    System.out.println("SQLState: " + sqlEx.getSQLState());
                    System.out.println("VendorError: " + sqlEx.getErrorCode());
                }
                stmt = null;
            }
        }

        this.command.setStato("Errore");
        this.command.setRisultato("Impossibile eseguire il comando");

        return this.command;
    }
}
