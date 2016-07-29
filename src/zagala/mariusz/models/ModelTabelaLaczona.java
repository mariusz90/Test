package zagala.mariusz.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import zagala.mariusz.classes.Laczona;
import zagala.mariusz.database.DBS;


public class ModelTabelaLaczona  extends AbstractTableModel {
	private List<String> headers;
	//lista sluzy do przechowywania wierszy
	private List<Laczona> rows;
	
	public ModelTabelaLaczona ()
	{
		headers = new ArrayList<>(Arrays.asList("ID","MARKA","KOLOR","CENA","POJEMNOŒÆ", "PRZEBIEG", "ROK PRODUKCJI","KLIMATYZACJA", "SZYBY ELEKTRYCZNE","NOWY", "IMIE","NAZWISKO","MIEJSCE ZAMIESZKANIA","NUMER TELEFONU"));
		rows = DBS.innerJoin();
	}	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headers.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows.size();
	}

	@Override
	public Object getValueAt(int row, int col)  {
		Laczona s = rows.get(row);
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
		else if (col == 9)
		{
			return s.isCzyNowy();
		}
		else if(col == 10)
		{
			return s.getImie();
		}
		else if(col == 11)
		{
			return s.getNazwisko();
		}
		else if(col == 12)
		{
			return s.getMiejsceZamieszkania();
		}
		else 
		{
			return s.getNrTelefonu();
		}
	} 
	public String getColumnName(int column) {
		return headers.get(column);
				
	}
	
	public void updateRows(List<Laczona> lista)
	{
		rows = new ArrayList<>(lista);
		fireTableDataChanged(); //aktualizuje tabelke w momencie gdy wpiszesz dane - aktualizuje zawartosc tabelki
	}
	
	public Laczona getRowAt(int idx)
	{
		return rows.get(idx);
	}
	
}
