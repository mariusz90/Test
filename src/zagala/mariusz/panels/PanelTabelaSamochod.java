package zagala.mariusz.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import zagala.mariusz.classes.Samochod;
import zagala.mariusz.database.DBS;
import zagala.mariusz.models.ModelTabelaSamochod;
import zagala.mariusz.settings.Settings;

public class PanelTabelaSamochod extends JPanel implements ActionListener{
	private JTable tabelaSamochod;
	private ModelTabelaSamochod model;
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JPanel panelDol;
	
	
	
	public PanelTabelaSamochod()
	{
		super(new BorderLayout());
		//tabelka w swing mozesz zrobic bardzo szybko, wystarczy dostarczyc 
		//kolumny i wiersze co zalatwimy dwoma tablicami
		
		model = new ModelTabelaSamochod();
		//tabelaSamochod = new JTable(rows, headers);
		tabelaSamochod = new JTable(model);
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(this);
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		
		panelDol = new JPanel(new GridLayout(1, 3, 5 ,5));
		panelDol.add(btnInsert);
		panelDol.add(btnDelete);
		panelDol.add(btnUpdate);
		
		add(new JScrollPane(tabelaSamochod), BorderLayout.CENTER);
		add(panelDol, BorderLayout.PAGE_END);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInsert)
		{
			//klasa ktora odpowiada za okienkow
			JFrame frame = new JFrame("DODAWANIE SAMOCHODU");
			//dodajemy do krzyzyka opcje ze jak go n acisniesz to zamykasz okienko
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//tworzyy obiekt naszej klasy Okienko
			PanelDodawanieSamochod panel = new PanelDodawanieSamochod(frame, tabelaSamochod, model);
			//ustawiamy panel na widoczny
			panel.setVisible(true);
			//ustawiamy zawartosc panelu jako glowna zawartosc okienka
			frame.setContentPane(panel);
			//pack to metoda ktora dopasuje rozmiar okineka do elementow ktore sie  wnim znajduja
			frame.pack();
			//frame.setSize(new Dimension(300,400));
			//ustawiamy widocznosc okienka na true
			frame.setVisible(true);
			//mozemy rozciagac okienko
			frame.setResizable(false);
			//dodajemy do jframea menu ktore pochodzi z formularza
			frame.addWindowListener(new WindowListener(){

				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowClosed(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowClosing(WindowEvent e) {
				
					
				}

				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		else if (e.getSource() == btnUpdate)
		{
			int idx = tabelaSamochod.getSelectedRow();
			if (idx >= 0)
			{
				Samochod s = model.getRowAt(idx);
				Integer idDoUsuniecia = (Integer)model.getValueAt(idx, 0);
				JFrame frame = new JFrame("UPDATE SAMOCHODU");
				//dodajemy do krzyzyka opcje ze jak go n acisniesz to zamykasz okienko
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				//tworzyy obiekt naszej klasy Okienko
				PanelUpdateSamochod panel = new PanelUpdateSamochod(frame, s,tabelaSamochod, model);
				//ustawiamy panel na widoczny
				panel.setVisible(true);
				//ustawiamy zawartosc panelu jako glowna zawartosc okienka
				frame.setContentPane(panel);
				//pack to metoda ktora dopasuje rozmiar okineka do elementow ktore sie  wnim znajduja
				frame.pack();
				//frame.setSize(new Dimension(300,400));
				//ustawiamy widocznosc okienka na true
				frame.setVisible(true);
				//mozemy rozciagac okienko
				frame.setResizable(false);
				//dodajemy do jframea menu ktore pochodzi z formularza
				DBS.updateSamochod(s);

				
				
				
				model.updateRows(DBS.selectSamochod());
				tabelaSamochod.updateUI();
			}
		}
		else if (e.getSource() == btnDelete)
		{
			int idx = tabelaSamochod.getSelectedRow(); //idx to indeks z listy, ktora jest powiazana z modelem
			//a nam jest potrzebne id z tego zaznaczonego wiersza, bo delete usuwa na podstawie
			if (idx >= 0)
			{
				Integer idDoUsuniecia = (Integer)model.getValueAt(idx, 0);
				DBS.deleteSamochod(idDoUsuniecia);
				model.updateRows(DBS.selectSamochod());
				tabelaSamochod.updateUI();
			}
		}
		
	}
	public void updateFont(int newSize)
	{
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, Settings.FONT_SIZE));
		btnInsert.setFont(new Font("Times New Roman", Font.PLAIN, newSize));
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, newSize));
	}
	public void updateFontColor(Color newFontColor)
	{
		btnDelete.setForeground(newFontColor);
		btnInsert.setForeground(newFontColor);
		btnUpdate.setForeground(newFontColor);
	}
}
