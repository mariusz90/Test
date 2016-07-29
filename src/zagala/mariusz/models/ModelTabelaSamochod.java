package zagala.mariusz.models;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import zagala.mariusz.classes.Samochod;
import zagala.mariusz.database.DBS;

//jest to klasa ktora przechowuje model tabeli samochod, czyli sluzy do zarzadzania tym co w tabeli 
//jest wyswietlane
public class ModelTabelaSamochod extends AbstractTableModel{
	//lista sluzy do przechowywania naglowkow kolumn
	private List<String> headers;
	//lista sluzy do przechowywania wierszy
	private List<Samochod> rows;
	
	public ModelTabelaSamochod() {
		headers = new ArrayList<>(Arrays.asList("ID", "MARKA","KOLOR","CENA","POJEMNOŒÆ", "PRZEBIEG", "ROK PRODUKCJI","KLIMATYZACJA", "SZYBY ELEKTRYCZNE","NOWY" ));
		rows = DBS.selectSamochod();

	}
	
	@Override
	public int getColumnCount() {
		return headers.size();
	}
	@Override
	public int getRowCount() {
		return rows.size();
	}
	@Override
	public Object getValueAt(int row, int col) {
		Samochod s = rows.get(row);
		if (col == 0)
		{
			return s.getId();
		}
		else if (col == 1)
		{
			return s.getMarka();
		}
		else if (col == 2)
		{
			return s.getKolor();
		}
		else if (col == 3)
		{
			return s.getCena();
		}
		else if (col == 4)
		{
			return s.getPojemnosc();
		}
		else if (col == 5)
		{
			return s.getPrzebieg();
		}
		else if (col == 6)
		{
			return s.getRokProdukcji();
		}
		else if (col == 7)
		{
			return s.isCzyKlimatyzacja();
		}
		else if (col == 8)
		{
			return s.isCzyElektryczneSzyby();
		}
		else
		{
			return s.isCzyNowy();
		}
	}
	@Override
	public String getColumnName(int column) {
		return headers.get(column);
				
	}
	
	public void updateRows(List<Samochod> lista)
	{
		rows = new ArrayList<>(lista);
		fireTableDataChanged(); //aktualizuje tabelke w momencie gdy wpiszesz dane - aktualizuje zawartosc tabelki
	}
	
	public Samochod getRowAt(int idx)
	{
		return rows.get(idx);
	}
	
}
