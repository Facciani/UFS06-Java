package it.rizzoli;

public class Auto {
    private int prezzo;
    private String marca;
    private double km;
    private int voto;

    public Auto() {
        this.prezzo = 0;
        this.marca = "";
        this.km = 0.0;
        this.voto = 0;
    }

    public void setAll(int prezzo, String marca, double km, int voto) {
        this.prezzo = prezzo;
        this.marca = marca;
        this.km = km;
        this.voto = voto;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }
}
