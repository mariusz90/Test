package zagala.mariusz.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import zagala.mariusz.classes.Klient;
import zagala.mariusz.classes.Samochod;
import zagala.mariusz.database.DBS;


public class ModelTabelaKlient extends AbstractTableModel{ 
	
		private List<String> headers;
		private List<Klient> rows;
	
	public ModelTabelaKlient()
	{
		headers = new ArrayList<>(Arrays.asList("ID","IMIE","NAZWISKO","MIEJSCE ZAMIESZKANIA","NUMER TELEFONU"));
		rows = DBS.slectKlient();
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
		Klient k = rows.get(row);
		
		if(col == 0)
		{
			return k.getId();
		}
		else if(col == 1)
		{
			return k.getImie();
		}
		else if(col == 2)
		{
			return k.getNazwisko();
		}
		else if(col == 3)
		{
			return k.getMiejsceZamieszkania();
		}
		else 
		{
			return k.getNrTelefonu();
		}
		
	}
	@Override
	public String getColumnName(int column) {
		return headers.get(column);
}
	public void updateRows(List<Klient> lista)
	{
		rows = new ArrayList<>(lista);
		fireTableDataChanged(); //aktualizuje tabelke w momencie gdy wpiszesz dane - aktualizuje zawartosc tabelki
	}
	public Klient getRowAt(int idx)
	{
		return rows.get(idx);
	}
	
}
