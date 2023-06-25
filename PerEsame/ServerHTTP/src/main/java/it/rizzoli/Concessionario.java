package it.rizzoli;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Concessionario {

    private static Concessionario instance ;


    public static synchronized Concessionario getInstance() {
        if (instance == null) {
            instance = new Concessionario();
        }
        return instance;
    }

    private List<Macchina> listaCar;
    private Command command;

    public Concessionario(){
        this.listaCar = new ArrayList<Macchina>();
        this.command = new Command();
    }

    public void add(Macchina c){
        this.listaCar.add(c);
    }

    public String getAllCars(){

        String result = "";

        for (Macchina car:
                this.listaCar) {
            result += car.toString();
        }

        return result;

    }

    public String getAllCarsSorted(){

        List<Macchina> tempList = new ArrayList<>(this.listaCar);

        tempList.sort((o1,o2)-> o1.getMarca().compareTo(o2.getMarca()));

        String result = "";

        for (Macchina car:
                tempList) {
            result += car.toString();
        }

        return result;

    }

    public String getMoreExprensive(){

        int max = 0;
        Macchina car = null;

        for (Macchina c:
                this.listaCar) {
            if(c.getPrezzo() > max){
                max = c.getPrezzo();
                car = c;
            }
        }
        String result = "";
        result = car.toString();
        return result;
    }
}
