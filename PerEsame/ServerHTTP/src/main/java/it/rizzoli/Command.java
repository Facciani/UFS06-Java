package it.rizzoli;

public class Command {
    private String status;
    private String result;

    public Command(){
        this.status = "";
        this.result = "";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
