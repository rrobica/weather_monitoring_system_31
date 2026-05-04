package sdad;

public class Senzor {
    private String tipSenzor;
    private float valoare;
    private String unitateMasura;

    public Senzor(String tipSenzor, float valoare, String unitateMasura) {
        this.tipSenzor = tipSenzor;
        this.valoare = valoare;
        this.unitateMasura = unitateMasura;
    }

    public String getTipSenzor() {
        return tipSenzor;
    }

    public float citesteValoare() {
        return valoare;
    }

    public String getUnitateMasura() {
        return unitateMasura;
    }
}