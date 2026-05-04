package sdad;

public class Alerta {
    private String conditieMeteorologica;
    private String mesajSfat;

    public Alerta(String conditie, String mesaj) {
        this.conditieMeteorologica = conditie;
        this.mesajSfat = mesaj;
    }

    public void verificaConditii(StareVreme stareCurenta, float pragCriticTemperatura) {
        float temperaturaCurenta = stareCurenta.getTemperatura();
        
        if (temperaturaCurenta >= pragCriticTemperatura) {
            declanseazaAlerta(temperaturaCurenta);
        }
    }

    public void declanseazaAlerta(float valoareInregistrata) {
        System.out.println("\n!!! ALERTA METEO: " + conditieMeteorologica + " !!!");
        System.out.println("S-a inregistrat valoarea de: " + valoareInregistrata);
        System.out.println("Sfat: " + mesajSfat + "\n");
    }
}