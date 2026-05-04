package sdad;

import java.util.ArrayList;
import java.util.List;

public class SistemMonitorizare {
    public static void main(String[] args) {
        StareVreme stareaDeAzi = new StareVreme();
        
        Senzor senzorTemp = new Senzor("Temperatura", 36.5f, "C");
        Senzor senzorUmiditate = new Senzor("Umiditate", 45.0f, "%");
        Senzor senzorPresiune = new Senzor("Presiune", 1013.2f, "hPa");
        
        stareaDeAzi.adaugaSenzor(senzorTemp);
        stareaDeAzi.adaugaSenzor(senzorUmiditate);
        stareaDeAzi.adaugaSenzor(senzorPresiune);
        
        stareaDeAzi.actualizeazaDateSenzori();
        stareaDeAzi.obtineStareCurenta();
        
        Alerta alertaCanicula = new Alerta("Canicula Extrema", "Evitati expunerea la soare!");
        alertaCanicula.verificaConditii(stareaDeAzi, 35.0f);
        
        List<Double> istoricSaptamana = new ArrayList<>();
        istoricSaptamana.add(30.0);
        istoricSaptamana.add(32.5);
        istoricSaptamana.add(34.0);
        istoricSaptamana.add(36.5);
        
        Predictie predictiePe3Zile = new Predictie(3);
        predictiePe3Zile.genereazaPrognoza(istoricSaptamana);
        
        List<Double> rezultatPrognoza = predictiePe3Zile.getDatePrognozate();
        System.out.println("--- Prognoza detaliata ---");
        for (int i = 0; i < rezultatPrognoza.size(); i++) {
            System.out.println("Ziua " + (i + 1) + ": " + String.format("%.1f", rezultatPrognoza.get(i)) + " grade");
        }
    }
}