package it.rizzoli;

public class Macchina {
    public int prezzo;
    public String marca;
    public double km;
    public int voto;

    public Macchina(int prezzo, String marca, double km, int voto) {
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

    @Override
    public String toString() {
        return "<tr><td>"+ this.prezzo+"</td><td>"+this.marca+"</td><td>"+this.km+"</td><td>"+this.voto+"</td></tr>";
    }
}
