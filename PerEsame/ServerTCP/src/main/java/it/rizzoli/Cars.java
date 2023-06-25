package it.rizzoli;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class Cars {

    private static Cars instance ;

    public static synchronized Cars getInstance() {
        if (instance == null) {
            instance = new Cars();
        }
        return instance;
    }

    private List<Car> listaCar;
    private Command command;

    public Cars(){
        this.listaCar = new ArrayList<Car>();
        this.command = new Command();
    }

    public void add(Car c){
        this.listaCar.add(c);
    }

    public String getAllCars(){

        String json = new Gson().toJson(this.listaCar);
        return json;

    }

    public String getAllCarsSorted(){

        List<Car> tempList = new ArrayList<>(this.listaCar);

        tempList.sort((o1,o2)-> o1.getMarca().compareTo(o2.getMarca()));
        String json = new Gson().toJson(tempList);
        return json;

    }

    public String getMoreExprensive(){

        int max = 0;
        Car car = null;

        for (Car c:
                this.listaCar) {
            if(c.getPrezzo() > max){
                max = c.getPrezzo();
                car = c;
            }
        }

        String json = new Gson().toJson(car);
        return json;
    }
}
