package zagala.mariusz.panels;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import zagala.mariusz.database.DBS;

public class PanelStatystyki extends JPanel implements ActionListener {
	
private JTextField tfMaxCena;
private JTextField tfMaxPzebieg;
private JTextField tfMaxPojemnosc;
private JTextField tfSredniaCena;
private JTextField tfSredniPrzebieg;
private JTextField tfMinCena;
private JTextField tfMinPrzebieg;
private JTextField tfMinPojemnosc;
private JTextField tfMaxRokProdukcji;
private JTextField tfMinRokProdukcji;

private JLabel lMaxCena;
private JLabel lMaxPzebieg;
private JLabel lMaxPojemnosc;
private JLabel lSredniaCena;
private JLabel lSredniPrzebieg;
private JLabel lMinCena;
private JLabel lMinPrzebieg;
private JLabel lMinPojemnosc;
private JLabel lMaxRokProdukcji;
private JLabel lMinRokProdukcji;

private JButton btnPokaz;

	public PanelStatystyki()
	{
		super(new GridBagLayout());
		tfMaxCena = new JTextField(10);
		tfMaxPzebieg = new JTextField(10);
		tfMaxPojemnosc = new JTextField(10);
		tfSredniaCena = new JTextField(10);
		tfSredniPrzebieg = new JTextField(10);
		tfMinCena = new JTextField(10);
		tfMinPrzebieg = new JTextField(10);
		tfMinPojemnosc = new JTextField(10);
		tfMaxRokProdukcji= new JTextField(10);
		tfMinRokProdukcji= new JTextField(10);
		
		lMaxCena = new JLabel("Max cena samochodu");
		lMaxPzebieg = new JLabel("Max przebieg samochodu");
		lMaxPojemnosc = new JLabel("Max pojemnoœæ samochodu");
		lSredniaCena = new JLabel("Œrednia cena samochodów");
		lSredniPrzebieg = new JLabel("Œredni przebieg samochodów");
		lMinCena = new JLabel("Min cena samochodu");
		lMinPrzebieg = new JLabel("Min przebieg samochodu");
		lMinPojemnosc = new JLabel("Min pojemnosc samochodu");
		lMaxRokProdukcji = new JLabel("Max rok produkcji samochodu");
		lMinRokProdukcji = new JLabel("Min rok produkcji samochodu");
		
		btnPokaz = new JButton("Pokaz");
		btnPokaz.addActionListener(this);
		
		GridBagConstraints gbcStat = new GridBagConstraints();
		gbcStat.gridy = 0; //wiersz
		gbcStat.gridx = 0; //kolumna
		gbcStat.ipadx = 100;
		gbcStat.ipady = 20;
		gbcStat.weightx = 1; //powinny teraz kompoenty sie rozjezdzac
		gbcStat.weighty = 1;
		
		//gbcStat.gridx = 1; //kolumna
		//gbcStat.gridy = 0; //wiersz
		//gbcStat.ipadx = 10;
		gbcStat.insets = new Insets(5, 5, 5, 5);
		gbcStat.anchor = GridBagConstraints.LINE_START;
		
		gbcStat.gridx = 0; //kolumna
		gbcStat.gridy = 0; //wiersz
		gbcStat.ipadx = 1;
		add(lMaxCena,gbcStat);
		
		gbcStat.gridx = 1; //kolumna
		gbcStat.gridy = 0; //wiersz
		gbcStat.ipadx = 20;
		add(tfMaxCena,gbcStat);
		
		gbcStat.gridx = 0; //kolumna
		gbcStat.gridy = 1; //wiersz
		gbcStat.ipadx = 20;
		add(lMaxPzebieg,gbcStat);
		
		
		gbcStat.gridx = 1; //kolumna
		gbcStat.gridy = 1; //wiersz
		gbcStat.ipadx = 20;
		add(tfMaxPzebieg,gbcStat);
		
		gbcStat.gridx = 0; //kolumna
		gbcStat.gridy = 2; //wiersz
		gbcStat.ipadx = 20;
		add(lMaxPojemnosc,gbcStat);
		
		gbcStat.gridx = 1; //kolumna
		gbcStat.gridy = 2; //wiersz
		gbcStat.ipadx = 20;
		add(tfMaxPojemnosc,gbcStat);
		
		
		gbcStat.gridx = 0; //kolumna
		gbcStat.gridy = 3; //wiersz
		gbcStat.ipadx = 20;
		add(lSredniaCena,gbcStat);
		
		
		gbcStat.gridx = 1; //kolumna
		gbcStat.gridy = 3; //wiersz
		gbcStat.ipadx = 20;
		add(tfSredniaCena,gbcStat);
		
		gbcStat.gridx = 0; //kolumna
		gbcStat.gridy = 4; //wiersz
		gbcStat.ipadx = 20;
		add(lSredniPrzebieg,gbcStat);
		
		gbcStat.gridx = 1; //kolumna
		gbcStat.gridy = 4; //wiersz
		gbcStat.ipadx = 20;
		add(tfSredniPrzebieg,gbcStat);
		
		
		gbcStat.gridx = 0; //kolumna
		gbcStat.gridy = 5; //wiersz
		gbcStat.ipadx = 20;
		add(lMinCena,gbcStat);
		
		
		gbcStat.gridx = 1; //kolumna
		gbcStat.gridy = 5; //wiersz
		gbcStat.ipadx = 20;
		add(tfMinCena,gbcStat);
		
		gbcStat.gridx = 0; //kolumna
		gbcStat.gridy = 6; //wiersz
		gbcStat.ipadx = 20;
		add(lMinPrzebieg,gbcStat);
		add(tfMinPrzebieg,gbcStat);
		
		gbcStat.gridx = 1; //kolumna
		gbcStat.gridy = 6; //wiersz
		gbcStat.ipadx = 20;
		add(tfMinPrzebieg,gbcStat);
		
		gbcStat.gridx = 0; //kolumna
		gbcStat.gridy = 7; //wiersz
		gbcStat.ipadx = 20;
		add(lMinPojemnosc,gbcStat);
	
		
		gbcStat.gridx = 1; //kolumna
		gbcStat.gridy = 7; //wiersz
		gbcStat.ipadx = 20;
		add(tfMinPojemnosc,gbcStat);
		
		
		gbcStat.gridx = 0; //kolumna
		gbcStat.gridy = 8; //wiersz
		gbcStat.ipadx = 20;
		add(lMaxRokProdukcji,gbcStat);
		
		
		gbcStat.gridx = 1; //kolumna
		gbcStat.gridy = 8; //wiersz
		gbcStat.ipadx = 20;
		add(tfMaxRokProdukcji,gbcStat);
		
		gbcStat.gridx = 0; //kolumna
		gbcStat.gridy = 9; //wiersz
		gbcStat.ipadx = 20;
		add(lMinRokProdukcji,gbcStat);
		
		gbcStat.gridx = 1; //kolumna
		gbcStat.gridy = 9; //wiersz
		gbcStat.ipadx = 20;
		add(tfMinRokProdukcji,gbcStat);
		
		gbcStat.gridx = 0; //kolumna
		gbcStat.gridy = 10; //wiersz
		gbcStat.ipadx = 20;
		add(btnPokaz,gbcStat);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnPokaz)
		{
			double maxCena = DBS.maxCena();
			double minCena = DBS.minCena();
			double maxPrzebieg = DBS.maxPrzebieg();
			double minPrzebieg = DBS.minPrzebieg();
			double maxPojemnosc = DBS.maxPojemnosc();
			double minPojemnosc = DBS.minPojemnosc();
			double sredniaCena = DBS.sredniaCena();
			double sredniPrzebieg = DBS.sredniaPrzebieg();
			int maxRokProdukcji = DBS.maxRokProdukcji();
			int minRokProdukcji = DBS.minRokProdukcji();
			
			if(maxCena !=-1)
			{
				tfMaxCena.setText(maxCena+"");
			}
			if(minCena !=-1)
			{
				tfMinCena.setText(minCena+"");
			}
			if(maxPrzebieg !=-1)
			{
				tfMaxPzebieg.setText(maxPrzebieg+"");
			}
			if(minPrzebieg !=-1)
			{
				tfMinPrzebieg.setText(minPrzebieg+"");
			}
			if(maxPojemnosc !=-1)
			{
				tfMaxPojemnosc.setText(maxPojemnosc+"");
			}
			if(minPojemnosc !=-1)
			{
				tfMinPojemnosc.setText(minPojemnosc+"");
			}
			if(sredniaCena !=-1)
			{
				tfSredniaCena.setText(sredniaCena+"");
			}
			if(sredniPrzebieg !=-1)
			{
				tfSredniPrzebieg.setText(sredniPrzebieg+"");
			}
			if(maxRokProdukcji !=-1)
			{
				tfMaxRokProdukcji.setText(maxRokProdukcji+"");
			}
			if(minRokProdukcji !=-1)
			{
				tfMinRokProdukcji.setText(minRokProdukcji+"");
			}
			
			
		}
		}
		
	


}
