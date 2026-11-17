import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner eingabe = new Scanner(System.in);


        ArrayList<Artikel> lager = new ArrayList<>();

        lager.add(new Artikel("Milch", 1.19, 20));
        lager.add(new Artikel("Brot", 0.39 , 15));
        lager.add(new Artikel("Käse",  0.85, 10));
        lager.add(new Artikel("Eier", 1.49, 30));
        lager.add(new Artikel("Butter", 1.29, 31));

        boolean laeuft = true;

        while (laeuft) {
            System.out.println("1 = Anzeigen, 2 = Hinzufügen, 3 = Bestand ändern, 4 = Beenden");
            System.out.print("Auswahl: ");
            int wahl = eingabe.nextInt();
            eingabe.nextLine();

            switch (wahl) {
                case 1:
                    for (Artikel artikel : lager) {
                        artikel.anzeigen();
                    }

                    break;
                case 2:
                    System.out.print("Name des Artikels: ");
                    String name = eingabe.nextLine();
                    System.out.print("Preis des Artikels: ");
                    double preis = eingabe.nextDouble();
                    System.out.print("Bestand des Artikels:");
                    int bestand = eingabe.nextInt();
                    eingabe.nextLine();
                    lager.add(new Artikel(name, preis, bestand));

                    break;
                case 3:
                    System.out.println("Welcher Artikel?");
                    String suche = eingabe.nextLine();
                    System.out.println("Menge (+ oder -): ");
                    int menge = eingabe.nextInt();
                    eingabe.nextLine();

                    boolean gefunden = false;

                    for (Artikel artikel : lager) {
                        if (artikel.name.equalsIgnoreCase(suche)) {
                            artikel.bestandAendern(menge);
                            System.out.println("Bestand von " + artikel.name + " geändert.");
                            gefunden = true;
                        }

                    }

                    if (!gefunden) {
                        System.out.println("Artikel nicht gefunden.");
                    }
                            

                    for (Artikel artikel : lager) {
                        if (artikel.name.equalsIgnoreCase(suche)) {
                            artikel.bestandAendern(menge);
                            System.out.println("Bestand von " + artikel.name + " geändert.");
                        }
                    }
                    break;
                case 4:
                    laeuft = false;
                    break;
                default:
                    System.out.println("Ungültige Eingabe."); 

                }

        }
        
        eingabe.close();
    }
}