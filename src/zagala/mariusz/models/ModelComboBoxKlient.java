package zagala.mariusz.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import zagala.mariusz.classes.Klient;
import zagala.mariusz.database.DBS;



public class ModelComboBoxKlient extends AbstractListModel<Integer> implements ComboBoxModel<Integer> {
	
	private List<Integer> lista;
	private Integer zaznaczony;
	
	public ModelComboBoxKlient()
	{
		lista = new ArrayList<>();
		List<Klient> daneFromDatabase = DBS.slectKlient();
		for (Klient s : daneFromDatabase)
		{
			lista.add(s.getId());
		}
	}
	public void updateModel()
	{
		
		lista.clear();
		List<Klient> daneFromDatabase = DBS.slectKlient();
		for (Klient s : daneFromDatabase)
		{
			lista.add(s.getId());
		}
		
		 
	}
	

	@Override
	public Integer getElementAt(int idx) {
		// TODO Auto-generated method stub
		return lista.get(idx);	}

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
