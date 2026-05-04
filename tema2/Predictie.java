package sdad;

import java.util.ArrayList;
import java.util.List;

public class Predictie {
    private int numarZile;
    private List<Double> datePrognozate;

    public Predictie(int numarZile) {
        this.numarZile = numarZile;
        this.datePrognozate = new ArrayList<>();
    }

    public void genereazaPrognoza(List<Double> istoricTemperaturi) {
        datePrognozate.clear();

        if (istoricTemperaturi.size() < 2) {
            System.out.println("Nu exista date suficiente pentru predictie.");
            return;
        }

        int n = istoricTemperaturi.size();
        double tendinta = 0;
        for (int i = 1; i < n; i++) {
            tendinta += istoricTemperaturi.get(i) - istoricTemperaturi.get(i - 1);
        }

        if (tendinta > 0) {
            System.out.println("Predictie generala: Se incalzeste!");
        } else if (tendinta < 0) {
            System.out.println("Predictie generala: Se raceste!");
        } else {
            System.out.println("Predictie generala: Vremea ramane stabila!");
        }

        double ultimaTemperatura = istoricTemperaturi.get(n - 1);
        double pasModificare = tendinta / n;

        for (int i = 1; i <= numarZile; i++) {
            double tempViitoare = ultimaTemperatura + (pasModificare * i);
            datePrognozate.add(tempViitoare);
        }
    }

    public List<Double> getDatePrognozate() {
        return datePrognozate;
    }
}