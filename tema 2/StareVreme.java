package sdad;

import java.util.ArrayList;
import java.util.List;

public class StareVreme {
    private float temperatura;
    private float umiditate;
    private float precipitatii;
    private float presiune;
    private float punctRoua;

    private List<Senzor> senzori;

    public StareVreme() {
        this.senzori = new ArrayList<>();
    }

    public void adaugaSenzor(Senzor senzor) {
        senzori.add(senzor);
    }

    public void actualizeazaDateSenzori() {
        for (Senzor s : senzori) {
            String tip = s.getTipSenzor().toLowerCase();
            
            if (tip.contains("temperatura")) {
                this.temperatura = s.citesteValoare();
            } else if (tip.contains("umiditate")) {
                this.umiditate = s.citesteValoare();
            } else if (tip.contains("precipitatii")) {
                this.precipitatii = s.citesteValoare();
            } else if (tip.contains("presiune")) {
                this.presiune = s.citesteValoare();
            } else if (tip.contains("roua")) {
                this.punctRoua = s.citesteValoare();
            }
        }
    }

    private String getUnitate(String tipCautat) {
        for (Senzor s : senzori) {
            if (s.getTipSenzor().toLowerCase().contains(tipCautat)) {
                return s.getUnitateMasura();
            }
        }
        return "";
    }

    public void obtineStareCurenta() {
        System.out.println("--- Starea Vremii Curenta ---");
        System.out.println("Temperatura: " + temperatura + " " + getUnitate("temperatura"));
        System.out.println("Umiditate: " + umiditate + " " + getUnitate("umiditate"));
        System.out.println("Precipitatii: " + precipitatii + " " + getUnitate("precipitatii"));
        System.out.println("Presiune: " + presiune + " " + getUnitate("presiune"));
        System.out.println("Punct de roua: " + punctRoua + " " + getUnitate("roua"));
        System.out.println("-----------------------------");
    }

    public float getTemperatura() {
        return temperatura;
    }
}