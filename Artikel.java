public class Artikel {
    String name;
    double preis;
    int bestand;

    public Artikel(String name, double preis, int bestand) {
        this.name = name;
        this.preis = preis;
        this.bestand = bestand;
    }

    public void anzeigen() {
        System.out.println("Artikel: " + name);
        System.out.println("Preis: " + preis + " Euro");
        System.out.println("Bestand: " + bestand);
    }

    public void bestandAendern(int aenderung) {
        bestand = bestand + aenderung;
        if (bestand < 5) {
            System.out.println("Achtung: " + name + " nachbestellen!");
        }
    }
}