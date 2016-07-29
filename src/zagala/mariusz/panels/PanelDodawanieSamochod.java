package zagala.mariusz.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import zagala.mariusz.classes.Samochod;
import zagala.mariusz.database.DBS;
import zagala.mariusz.models.ModelTabelaSamochod;
import zagala.mariusz.settings.Settings;

public class PanelDodawanieSamochod  extends JPanel implements ActionListener {
		private JTextField tfMarka;
		private JTextField tfKolor;
		private JTextField tfPojemnosc;
		private JTextField tfCena;
		private JTextField tfPrzebieg;
		private JTextField tfRokProdukcji;
	
		
		private JLabel lMarka;
		private JLabel lKolor;
		private JLabel lPojemnosc;
		private JLabel lCena;
		private JLabel lPrzebieg;
		private JLabel lRokProdukcji;
		private JLabel lCzyKlimatyzacja;
		private JLabel lCzyElektryczneSzyby;
		private JLabel lCzyNowy;
		
		private JCheckBox wyborKlimatyzacja;
		private JCheckBox wyborSzyba;
		private JCheckBox wyborNowy;
		
		private JButton wstaw;
		private JButton anuluj;
		
		private JFrame frame;
		private JTable tabela;
		private ModelTabelaSamochod model;
		
		public PanelDodawanieSamochod(JFrame frame, JTable tabela, ModelTabelaSamochod model)
		{
			super(new GridBagLayout());
			
			this.frame = frame;
			this.tabela = tabela;
			this.model = model;
			
			wstaw = new JButton("Wstaw");
			wstaw.addActionListener(this);
			anuluj = new JButton("Anuluj");
			anuluj.addActionListener(this);
			
			tfMarka = new JTextField(10);
			tfKolor = new JTextField(10);
			tfPojemnosc = new JTextField(10);
			tfPrzebieg = new JTextField(10);
			tfCena = new JTextField(10);
			tfRokProdukcji = new JTextField(10);
			
			wyborKlimatyzacja = new JCheckBox();
			wyborSzyba = new JCheckBox();	
			wyborNowy = new JCheckBox();
			
			lMarka = new JLabel("Marka");
			lKolor = new JLabel("Kolor");
			lCena = new JLabel("Cena");
			lPojemnosc = new JLabel("Pojemnoœæ");
			lPrzebieg = new JLabel("Przebieg");
			lRokProdukcji = new JLabel("Rok produkcji");
			lCzyKlimatyzacja = new JLabel("Klimatyzacja");
			lCzyElektryczneSzyby = new JLabel("Elektryczne szyby");
			lCzyNowy = new JLabel("Stan nowy");
			
			GridBagConstraints gbcDodSam = new GridBagConstraints();
			gbcDodSam.weightx = 1; //powinny teraz kompoenty sie rozjezdzac
			gbcDodSam.weighty = 1;
			
			gbcDodSam.gridx = 1; //kolumna
			gbcDodSam.gridy = 0; //wiersz
			gbcDodSam.ipadx = 20;
			gbcDodSam.insets = new Insets(Settings.ODSTEP_GORA, Settings.ODSTEP_LEWO, Settings.ODSTEP_DOL, Settings.ODSTEP_PRAWO);
			gbcDodSam.anchor = GridBagConstraints.LINE_START;
			
			gbcDodSam.gridx = 0; 
			gbcDodSam.gridy = 0; 
			gbcDodSam.ipadx = 20;
			add(lMarka,gbcDodSam);
			
			gbcDodSam.gridx = 1; 
			gbcDodSam.gridy = 0; 
			gbcDodSam.ipadx = 20;
			add(tfMarka,gbcDodSam);
			
			gbcDodSam.gridx = 0; 
			gbcDodSam.gridy = 1; 
			gbcDodSam.ipadx = 20;
			add(lKolor,gbcDodSam);
			
			gbcDodSam.gridx = 1; 
			gbcDodSam.gridy = 1; 
			gbcDodSam.ipadx = 20;
			add(tfKolor,gbcDodSam);
			
			gbcDodSam.gridx = 0; 
			gbcDodSam.gridy = 2; 
			gbcDodSam.ipadx = 20;
			add(lCena,gbcDodSam);
			
			gbcDodSam.gridx = 1; 
			gbcDodSam.gridy = 2; 
			gbcDodSam.ipadx = 20;
			add(tfCena,gbcDodSam);
			
			gbcDodSam.gridx = 0; 
			gbcDodSam.gridy = 3; 
			gbcDodSam.ipadx = 20;
			add(lPojemnosc,gbcDodSam);
			
			gbcDodSam.gridx = 1; 
			gbcDodSam.gridy = 3; 
			gbcDodSam.ipadx = 20;
			add(tfPojemnosc,gbcDodSam);
			
			gbcDodSam.gridx = 0; 
			gbcDodSam.gridy = 4; 
			gbcDodSam.ipadx = 20;
			add(lPrzebieg,gbcDodSam);
			
			gbcDodSam.gridx = 1; 
			gbcDodSam.gridy = 4; 
			gbcDodSam.ipadx = 20;
			add(tfPrzebieg,gbcDodSam);
			
			gbcDodSam.gridx = 0; 
			gbcDodSam.gridy = 5; 
			gbcDodSam.ipadx = 20;
			add(lRokProdukcji,gbcDodSam);
			
			gbcDodSam.gridx = 1; 
			gbcDodSam.gridy = 5; 
			gbcDodSam.ipadx = 20;
			add(tfRokProdukcji,gbcDodSam);
			
			gbcDodSam.gridx = 0; 
			gbcDodSam.gridy = 6; 
			gbcDodSam.ipadx = 20;
			add(lCzyKlimatyzacja,gbcDodSam);
			
			gbcDodSam.gridx = 1; 
			gbcDodSam.gridy = 6; 
			gbcDodSam.ipadx = 20;
			add(wyborKlimatyzacja,gbcDodSam);
			
			gbcDodSam.gridx = 0; 
			gbcDodSam.gridy = 7; 
			gbcDodSam.ipadx = 20;
			add(lCzyElektryczneSzyby,gbcDodSam);
			
			gbcDodSam.gridx = 1; 
			gbcDodSam.gridy = 7; 
			gbcDodSam.ipadx = 20;
			add(wyborSzyba,gbcDodSam);
			
			gbcDodSam.gridx = 0; 
			gbcDodSam.gridy = 8; 
			gbcDodSam.ipadx = 20;
			add(lCzyNowy,gbcDodSam);
			
			gbcDodSam.gridx = 1; 
			gbcDodSam.gridy = 8; 
			gbcDodSam.ipadx = 20;
			add(wyborNowy,gbcDodSam);
			
			gbcDodSam.gridx = 0; 
			gbcDodSam.gridy = 9; 
			gbcDodSam.ipadx = 20;
			add(wstaw,gbcDodSam);
			
			gbcDodSam.gridx = 1; 
			gbcDodSam.gridy = 9; 
			gbcDodSam.ipadx = 20;
			add(anuluj,gbcDodSam);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == wstaw)
			{
				String marka = tfMarka.getText();
				String kolor = tfKolor.getText();
				double cena = Double.parseDouble(tfCena.getText());
				double pojemnosc = Double.parseDouble(tfPojemnosc.getText());
				double przebieg = Double.parseDouble(tfPrzebieg.getText());
				int rokProdukcji = Integer.parseInt(tfRokProdukcji.getText());
				boolean czyKlimatyzacja=false;
				boolean czyElektryczneSzyby=false;
				boolean czyNowy=false;
				
				if(wyborKlimatyzacja.isSelected())
				{
					 czyKlimatyzacja = true;
				}
				else
				{
					czyKlimatyzacja =false;
				}
				if(wyborSzyba.isSelected())
				{
					czyElektryczneSzyby = true;
				}
				else
				{
					czyElektryczneSzyby = false;
				}
				if(wyborNowy.isSelected())
				{
					czyNowy = true;
				}
				else
				{
					czyNowy = false;
				}
				
				Samochod S = new Samochod(-1,marka,kolor,cena, pojemnosc,przebieg,rokProdukcji,czyKlimatyzacja ,czyElektryczneSzyby,czyNowy);
				DBS.insertSamochod(S);
				model.updateRows(DBS.selectSamochod());
				tabela.updateUI();
			}
			else if(e.getSource()== anuluj)
			{
				frame.dispose();
			}
		}
}

