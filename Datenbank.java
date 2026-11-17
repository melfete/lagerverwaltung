import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Datenbank {
    private static final String URL = "jdbc:mysql://localhost:3306/lagerverwaltung";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection verbinden() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static ArrayList<Artikel> alleLaden() throws SQLException {
        ArrayList<Artikel> liste = new ArrayList<>();
        String sql = "SELECT name, preis, bestand FROM artikel";

        try (Connection con = verbinden();
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                double preis = rs.getDouble("preis");
                int bestand = rs.getInt("bestand");
                liste.add(new Artikel(name, preis, bestand));
            }
        }
        return liste;
    }

    public static void speichern(Artikel a) throws SQLException {
        String sql = "INSERT INTO artikel (name, preis, bestand) VALUES (?, ?, ?)";

        try (Connection con = verbinden();
                PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, a.name);
            stmt.setDouble(2, a.preis);
            stmt.setInt(3, a.bestand);
            stmt.executeUpdate();
        }
    }

    public static void bestandAktualisieren(Artikel a) throws SQLException {
        String sql = "UPDATE artikel SET bestand = ? WHERE name = ?";

        try (Connection con = verbinden();
                PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, a.bestand);
            stmt.setString(2, a.name);
            stmt.executeUpdate();
        }
    }
}