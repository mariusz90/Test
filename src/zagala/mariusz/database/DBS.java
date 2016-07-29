package zagala.mariusz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;

import zagala.mariusz.classes.Klient;
import zagala.mariusz.classes.Laczona;
import zagala.mariusz.classes.Samochod;
import zagala.mariusz.classes.Zakup;

public class DBS {
	//czesc
	private static final String DB = "jdbc:sqlite:SalonSamochodowy.db";
	private static final String DRV = "org.sqlite.JDBC";
	private static Connection conn; // zmienna do zarzadzania polaczeniem z baza
									// danych
	private static Statement stat;

	public static void connect() {

		try {
			Class.forName(DRV);
			SQLiteConfig conf = new SQLiteConfig();
			conn = DriverManager.getConnection(DB, conf.toProperties());
			stat = conn.createStatement();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createTables() {
		String createTableSamochod = "CREATE TABLE IF NOT EXISTS Samochod" + "("
				+ "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + "marka VARCHAR(50) NOT NULL,"
				+ "kolor VARCHAR(50) NOT NULL," + "cena DOUBLE NOT NULL," + "pojemnosc DOUBLE NOT NULL,"
				+ "przebieg DOUBLE NOT NULL," + "rokProdukcji INTEGER NOT NULL," + "czyKlimatyzacja INTEGER NOT NULL, "
				+ "czyElektryczneSzyby INTEGER NOT NULL, " + "czyNowy INTEGER NOT NULL" + ");";
		String createTableKlient = "CREATE TABLE IF NOT EXISTS Klient" + "("
				+ "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + "imie VARCHAR(50) NOT NULL,"
				+ "nazwisko VARCHAR(50) NOT NULL," + "miejsceZamieszkania VARCHAR(50) NOT NULL,"
				+ "nrTelefonu INTEGER NOT NULL" + ");";
		String createTabelaZakup = "CREATE TABLE IF NOT EXISTS Zakup" + "("
				+ "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + "idK INTEGER NOT NULL," + "idS INTEGER NOT NULL,"
				+ "FOREIGN KEY(idK) REFERENCES Klient(id) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "FOREIGN KEY(idS) REFERENCES Samochod(id) ON DELETE CASCADE ON UPDATE CASCADE" + ");";
		try {
			stat.execute(createTableSamochod);
			stat.execute(createTableKlient);
			stat.execute(createTabelaZakup);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertSamochod(Samochod s) {
		String insertS = "INSERT INTO Samochod"
				+ "(marka, kolor, cena, pojemnosc, przebieg, rokProdukcji,czyKlimatyzacja, czyElektryczneSzyby, czyNowy)"
				+ "VALUES" + "(?, ?, ?, ?,?,?,?,?,?);";

		try {
			PreparedStatement ps = conn.prepareStatement(insertS);
			ps.setString(1, s.getMarka());
			ps.setString(2, s.getKolor());
			ps.setDouble(3, s.getCena());
			ps.setDouble(4, s.getPojemnosc());
			ps.setDouble(5, s.getPrzebieg());
			ps.setInt(6, s.getRokProdukcji());
			ps.setInt(7, s.isCzyKlimatyzacja() == true ? 1 : 0);
			ps.setInt(8, s.isCzyElektryczneSzyby() == true ? 1 : 0);
			ps.setInt(9, s.isCzyNowy() == true ? 1 : 0);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertKlient(Klient k) {
		String insertK = "INSERT INTO Klient" + "(imie, nazwisko, miejsceZamieszkania, nrTelefonu)" + "VALUES"
				+ "(?,?,?,?);";
		try {
			PreparedStatement ps = conn.prepareStatement(insertK);
			ps.setString(1, k.getImie());
			ps.setString(2, k.getNazwisko());
			ps.setString(3, k.getMiejsceZamieszkania());
			ps.setInt(4, k.getNrTelefonu());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Samochod> selectSamochod() {
		List<Samochod> lista = new ArrayList<>();

		String select = "SELECT * FROM Samochod;";
		try {
			ResultSet rs = stat.executeQuery(select);
			while (rs.next()) {
				int id = rs.getInt("id");
				String marka = rs.getString("marka");
				String kolor = rs.getString("kolor");
				double cena = rs.getInt("cena");
				double pojemnosc = rs.getDouble("pojemnosc");
				double przebieg = rs.getDouble("przebieg");
				int rokProdukcji = rs.getInt("rokProdukcji");
				boolean czyKlimatyzacja = rs.getInt("czyKlimatyzacja") == 1 ? true : false;
				boolean czyElektryczneSzyby = rs.getInt("czyElektryczneSzyby") == 1 ? true : false;
				boolean czyNowy = rs.getInt("czyNowy") == 1 ? true : false;
				lista.add(new Samochod(id, marka, kolor, cena, pojemnosc, przebieg, rokProdukcji, czyKlimatyzacja,
						czyElektryczneSzyby, czyNowy));
			}
			System.out.println(lista);
			return lista;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}

	}

	public static boolean insertZakup(int idS, int idK) {
		String insertS = " INSERT INTO Zakup(idK, idS) VALUES (?, ?)";
		PreparedStatement prep;
		try {
			prep = conn.prepareStatement(insertS);
			prep.setInt(1, idK);
			prep.setInt(2, idS);
			prep.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			return false;
		}

	}

	public static List<Zakup> selectZakup() {
		List<Zakup> lista = new ArrayList<>();
		try {

			String selectZakup = "SELECT * FROM Zakup";
			ResultSet rs = stat.executeQuery(selectZakup);
			while (rs.next()) {
				int id = rs.getInt("id");
				int idK = rs.getInt("idK");
				int idS = rs.getInt("idS");
				lista.add(new Zakup(id, idK, idS));
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static List<Klient> slectKlient() {
		List<Klient> lista = new ArrayList<>();
		String select = "SELECT * FROM Klient;";
		try {
			ResultSet rs = stat.executeQuery(select);
			while (rs.next()) {
				int id = rs.getInt("id");
				String imie = rs.getString("imie");
				String nazwisko = rs.getString("nazwisko");
				String miejsceZamieszkania = rs.getString("miejsceZamieszkania");
				int nrTelefonu = rs.getInt("nrTelefonu");
				lista.add(new Klient(id, imie, nazwisko, miejsceZamieszkania, nrTelefonu));
			}
			return lista;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void updateKlient(Klient k) {

		String updateS = "UPDATE Klient SET imie = ?, nazwisko = ?, miejsceZamieszkania = ?, nrTelefonu = ? WHERE id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(updateS);
			ps.setString(1, k.getImie());
			ps.setString(2, k.getNazwisko());
			ps.setString(3, k.getMiejsceZamieszkania());
			ps.setInt(4, k.getNrTelefonu());
			ps.setInt(5, k.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateSamochod(Samochod s) {
		String updateS = "UPDATE Samochod SET marka = ?, kolor = ?, cena = ?, pojemnosc = ?, przebieg = ? , rokProdukcji = ?, czyKlimatyzacja = ?, czyElektryczneSzyby = ?, czyNowy = ? WHERE id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(updateS);
			ps.setString(1, s.getMarka());
			ps.setString(2, s.getKolor());
			ps.setDouble(3, s.getCena());
			ps.setDouble(4, s.getPojemnosc());
			ps.setDouble(5, s.getPrzebieg());
			ps.setInt(6, s.getRokProdukcji());
			ps.setInt(7, s.isCzyKlimatyzacja() == true ? 1 : 0);
			ps.setInt(8, s.isCzyElektryczneSzyby() == true ? 1 : 0);
			ps.setInt(9, s.isCzyNowy() == true ? 1 : 0);
			ps.setInt(10, s.getId());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deleteKlient(int id) {
		String deleteK = "DELETE FROM Klient WHERE id = ? ;";
		try {
			PreparedStatement ps = conn.prepareStatement(deleteK);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteSamochod(int id) {
		String deleteS = "DELETE FROM Samochod WHERE id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(deleteS);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void deleteZakup(int id) {
		String deleteS = "DELETE FROM Zakup WHERE id = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(deleteS);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Laczona> innerJoin() {
		List<Laczona> list = new ArrayList<>();
		String innerJoinStr = "SELECT Zakup.id, Samochod.marka, Samochod.kolor, Samochod.cena, Samochod.pojemnosc,Samochod.przebieg, Samochod.rokProdukcji, Samochod.czyKlimatyzacja, Samochod.czyElektryczneSzyby, Samochod.czyNowy,"
				+ "Klient.imie, Klient.nazwisko, Klient.miejsceZamieszkania, Klient.nrTelefonu "
				+ "FROM Samochod INNER JOIN Zakup ON Samochod.id = Zakup.idS "
				+ "INNER JOIN Klient ON Zakup.idK = Klient.id;";

		try {
			ResultSet rs = stat.executeQuery(innerJoinStr);
			int id;
			String marka;
			String kolor;
			double cena;
			double pojemnosc;
			double przebieg;
			int rokProdukcji;
			boolean czyKlimatyzacja;
			boolean czyElektryczneSzyby;
			boolean czyNowy;
			String imie;
			String nazwisko;
			String miejsceZamieszkania;
			int nrTelefonu;
			while (rs.next()) {
				id = rs.getInt(1);
				marka = rs.getString(2);
				kolor = rs.getString(3);
				cena = rs.getDouble(4);
				pojemnosc = rs.getDouble(5);
				przebieg = rs.getDouble(6);
				rokProdukcji = rs.getInt(7);
				czyKlimatyzacja = rs.getBoolean(8);
				czyElektryczneSzyby = rs.getBoolean(9);
				czyNowy = rs.getBoolean(10);
				imie = rs.getString(11);
				nazwisko = rs.getString(12);
				miejsceZamieszkania = rs.getString(13);
				nrTelefonu = rs.getInt(14);
				list.add(new Laczona(id, marka, kolor, cena, pojemnosc, przebieg, rokProdukcji, czyKlimatyzacja,
						czyElektryczneSzyby, czyNowy, imie, nazwisko, miejsceZamieszkania, nrTelefonu));
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	public static Samochod selectSamochodId(int id) {
		try {
			String select = "SELECT * FROM Samochod WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(select);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String marka = rs.getString(2);
				String kolor = rs.getString(3);
				double cena = rs.getDouble(4);
				double pojemnosc = rs.getDouble(5);
				double przebieg = rs.getDouble(6);
				int rokProdukcji = rs.getInt(7);
				boolean czyKlimatyzacja = rs.getBoolean(8);
				boolean czyElektryczneSzyby = rs.getBoolean(9);
				boolean czyNowy = rs.getBoolean(10);
				return new Samochod(-1, marka, kolor, cena, pojemnosc, przebieg, rokProdukcji, czyKlimatyzacja,
						czyElektryczneSzyby, czyNowy);
			} else {
				System.out.println("NIEPOPRAWNE ID SAMOCHOD");
				return null;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}

	public static Klient selectKlientId(int id) {
		String select = "SELECT * FROM Klient WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(select);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String imie = rs.getString(2);
				String nazwisko = rs.getString(3);
				String miejsceZamieszkania = rs.getString(4);
				int nrTelefonu = rs.getInt(5);
				return new Klient(-1, imie, nazwisko, miejsceZamieszkania, nrTelefonu);
			} else {
				System.out.println("NIEPOPRAWNE ID Klient");
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static double maxCena() {
		String maxCena = "SELECT MAX(cena) From Samochod;";

		try {
			ResultSet rs = stat.executeQuery(maxCena);
			if (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public static double minCena() {
		String minCena = "SELECT MIN(cena) From Samochod;";

		try {
			ResultSet rs = stat.executeQuery(minCena);
			if (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public static double maxPrzebieg() {
		String maxPrzebieg = "SELECT MAX(przebieg) From Samochod;";

		try {
			ResultSet rs = stat.executeQuery(maxPrzebieg);
			if (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public static double minPrzebieg() {
		String minPrzebieg = "SELECT MIN(przebieg) From Samochod;";

		try {
			ResultSet rs = stat.executeQuery(minPrzebieg);
			if (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public static double maxPojemnosc() {
		String maxPojemnosc = "SELECT MAX(pojemnosc) From Samochod;";

		try {
			ResultSet rs = stat.executeQuery(maxPojemnosc);
			if (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public static double minPojemnosc() {
		String minPojemnosc = "SELECT MIN(pojemnosc) From Samochod;";

		try {
			ResultSet rs = stat.executeQuery(minPojemnosc);
			if (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public static double sredniaCena() {
		String sredniaCena = "SELECT AVG(cena) From Samochod;";

		try {
			ResultSet rs = stat.executeQuery(sredniaCena);
			if (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public static double sredniaPrzebieg() {
		String sredniaPrzebieg = "SELECT AVG(przebieg) From Samochod;";

		try {
			ResultSet rs = stat.executeQuery(sredniaPrzebieg);
			if (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public static int maxRokProdukcji() {
		String maxRokProdukcji = "SELECT MAX(rokProdukcji) From Samochod;";

		try {
			ResultSet rs = stat.executeQuery(maxRokProdukcji);
			if (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public static int minRokProdukcji() {
		String minRokProdukcji = "SELECT MIN(rokProdukcji) From Samochod;";

		try {
			ResultSet rs = stat.executeQuery(minRokProdukcji);
			if (rs.next()) {
				return rs.getInt(1);
			}
			return -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;

		}
	}
	
	public static List<Laczona> selectFilter(double cenaOd, double cenaDo,double pojemnoscOd, double pojemnoscDo, 
			double przebiegOd, double przebiegDo, int rokProdukcjiOd, int rokProdukcjiDo,List<String> marki, 
			List<String> kolory, boolean czyKlimatyzacja, boolean czySzyba, boolean czyNowy)
			
	{
		String poWhere = "WHERE cena BETWEEN " + cenaOd + " AND " + cenaDo 
				+ " AND pojemnosc BETWEEN " + pojemnoscOd + " AND " + pojemnoscDo 
				+ " AND przebieg BETWEEN " + przebiegOd + " AND " + przebiegDo 
				+ " AND rokProdukcji BETWEEN " + rokProdukcjiOd + " AND " + rokProdukcjiDo 
				+ " AND marka IN ( ";
				
		for (int i = 0;  i < marki.size(); i++)
		{
			if (i != marki.size()-1)
			{
				poWhere += " '" + marki.get(i) +"' " + ", ";
			}
			else
			{
				poWhere += " '" + marki.get(i) + "' " + " )";
			}
		}
		
		poWhere += " AND kolor IN ( ";
		
		for (int i = 0;  i < kolory.size(); i++)
		{
			if (i != kolory.size()-1)
			{
				poWhere += " '" + kolory.get(i) + "' " + ", ";
			}
			else
			{
				poWhere += " '" + kolory.get(i) + "' " + " )";
			}
		}
		
		poWhere += " AND czyKlimatyzacja = " + czyKlimatyzacja + " AND czyNowy = " + czyNowy + 
				" AND czyElektryczneSzyby = " + czySzyba + " ;";
		
		System.out.println(poWhere);
		
		return null;
	}
	/*
	 select kolumny inner join ... where
	 */
}
