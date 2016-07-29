package zagala.mariusz.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import zagala.mariusz.classes.Samochod;
import zagala.mariusz.database.DBS;

public class ModelComboBoxKolor extends AbstractListModel<String> implements ComboBoxModel<String> {
	private List<String> lista;
	private Integer zaznaczony;
	
	public ModelComboBoxKolor()
	{
		lista = new ArrayList<>();
		List<Samochod> daneFromDatabase = DBS.selectSamochod();
		for (Samochod s : daneFromDatabase)
		{
			lista.add(s.getKolor());
		}
	}
	public void updateModel()
	{
		
		lista.clear();
		List<Samochod> daneFromDatabase = DBS.selectSamochod();
		for (Samochod s : daneFromDatabase)
		{
			lista.add(s.getKolor());
		}
	}
	@Override
	public String getElementAt(int idx) {
	
		return lista.get(idx);	
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return lista.size();
	}
	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return zaznaczony;
	}
	@Override
	public void setSelectedItem(Object arg0) {
		zaznaczony = (Integer)arg0;
		
	}
	
	
}
