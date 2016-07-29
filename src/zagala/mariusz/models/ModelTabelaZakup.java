package zagala.mariusz.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;


import zagala.mariusz.classes.Zakup;
import zagala.mariusz.database.DBS;

public class ModelTabelaZakup extends AbstractTableModel {
	private List<String> headers;
	//lista sluzy do przechowywania wierszy
	private List<Zakup> rows;
	
	public ModelTabelaZakup() {
		headers = new ArrayList<>(Arrays.asList("ID", "IDS","IDK"));
		rows = DBS.selectZakup();

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
		Zakup s= rows.get(row);
		if (col == 0)
		{
			return s.getId();
		}
		else if (col == 1)
		{
			return s.getIdK();
		}
		else  
		{
			return s.getIdS();
		}
		
	}
	@Override
	public String getColumnName(int column) {
		return headers.get(column);
				
	}
	
	public void updateRows(List<Zakup> lista)
	{
		rows = new ArrayList<>(lista);
		fireTableDataChanged(); //aktualizuje tabelke w momencie gdy wpiszesz dane - aktualizuje zawartosc tabelki
	}
	
	public Zakup getRowAt(int idx)
	{
		return rows.get(idx);
	}
	


}
