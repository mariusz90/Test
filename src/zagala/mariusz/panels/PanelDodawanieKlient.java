package zagala.mariusz.panels;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import zagala.mariusz.classes.Klient;
import zagala.mariusz.database.DBS;
import zagala.mariusz.models.ModelTabelaKlient;
import zagala.mariusz.settings.Settings;

public class PanelDodawanieKlient  extends JPanel implements ActionListener  {
		
		private JTextField tfImie;
		private JTextField tfNazwisko;
		private JTextField tfMiejsceZamieszkania;
		private JTextField tfNrTelefonu;
		
		private JLabel lImie;
		private JLabel lNazwisko;
		private JLabel lMiejsceZamieszkania;
		private JLabel lNrTelefonu;
		private JButton wstaw;
		private JButton anuluj;
		private JFrame frame;
		private JTable tabela;
		private ModelTabelaKlient model;
		public PanelDodawanieKlient(JFrame frame, JTable tabela,ModelTabelaKlient model )
		{
			super(new GridBagLayout());
			GridBagConstraints gbcGora = new GridBagConstraints();
			gbcGora.gridy = 0; //wiersz
			gbcGora.gridx = 0; //kolumna
			gbcGora.ipadx = 300;
			gbcGora.ipady = 100;
			
			this.frame = frame;
			this.tabela = tabela;
			this.model = model;
			
			wstaw = new JButton("Wstaw");
			wstaw.addActionListener(this);
			anuluj = new JButton("Anuluj");
			anuluj.addActionListener(this);
			
			tfImie = new JTextField(12);
			tfNazwisko = new JTextField(12);
			tfMiejsceZamieszkania = new JTextField(12);
			tfNrTelefonu = new JTextField(12);
			
			lImie = new JLabel("Imie");
			lNazwisko = new JLabel("Nazwisko");
			lMiejsceZamieszkania = new JLabel("Miejsce zamieszkania");
			lNrTelefonu = new JLabel("Numer telefonu");
			
			GridBagConstraints gbcDodKli = new GridBagConstraints();
			gbcDodKli.weightx = 1; //powinny teraz kompoenty sie rozjezdzac
			gbcDodKli.weighty = 1;
			
			gbcDodKli.gridx = 1; //kolumna
			gbcDodKli.gridy = 0; //wiersz
			gbcDodKli.ipadx = 20;
			gbcDodKli.insets = new Insets(Settings.ODSTEP_GORA, Settings.ODSTEP_LEWO, Settings.ODSTEP_DOL, Settings.ODSTEP_PRAWO);
			gbcDodKli.anchor = GridBagConstraints.LINE_START;
			
			gbcDodKli.gridx = 0; //kolumna
			gbcDodKli.gridy = 0; //wiersz
			gbcDodKli.ipadx = 20;
			add(lImie,gbcDodKli);
			
			gbcDodKli.gridx = 1; //kolumna
			gbcDodKli.gridy = 0; //wiersz
			gbcDodKli.ipadx = 20;
			add(tfImie,gbcDodKli);
			
			gbcDodKli.gridx = 0; //kolumna
			gbcDodKli.gridy = 1; //wiersz
			gbcDodKli.ipadx = 20;
			add(lNazwisko,gbcDodKli);
			
			gbcDodKli.gridx = 1; //kolumna
			gbcDodKli.gridy = 1; //wiersz
			gbcDodKli.ipadx = 20;
			add(tfNazwisko,gbcDodKli);
			
			gbcDodKli.gridx = 0; //kolumna
			gbcDodKli.gridy = 2; //wiersz
			gbcDodKli.ipadx = 20;
			add(lMiejsceZamieszkania,gbcDodKli);
			
			gbcDodKli.gridx = 1; //kolumna
			gbcDodKli.gridy = 2; //wiersz
			gbcDodKli.ipadx = 20;
			add(tfMiejsceZamieszkania,gbcDodKli);
			
			gbcDodKli.gridx = 0; //kolumna
			gbcDodKli.gridy = 3; //wiersz
			gbcDodKli.ipadx = 20;
			add(lNrTelefonu,gbcDodKli);
			
			gbcDodKli.gridx = 1; //kolumna
			gbcDodKli.gridy = 3; //wiersz
			gbcDodKli.ipadx = 20;
			add(tfNrTelefonu,gbcDodKli);
			
			gbcDodKli.gridx = 0; //kolumna
			gbcDodKli.gridy = 4; //wiersz
			gbcDodKli.ipadx = 20;
			add(wstaw,gbcDodKli);
			
			gbcDodKli.gridx = 1; //kolumna
			gbcDodKli.gridy = 4; //wiersz
			gbcDodKli.ipadx = 20;
			add(anuluj,gbcDodKli);
			
		}
		
		public PanelDodawanieKlient() {
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == wstaw)
			{
				String imie = tfImie.getText();
				String nazwisko = tfNazwisko.getText();
				String miejsceZamieszkania = tfMiejsceZamieszkania.getText();
				int nrTelefonu = Integer.parseInt(tfNrTelefonu.getText());
				
				Klient k = new Klient(-1,imie,nazwisko,miejsceZamieszkania,nrTelefonu);
				DBS.insertKlient(k);
				model.updateRows(DBS.slectKlient());
				tabela.updateUI();
			}
			else if(e.getSource()== anuluj)
			{
				frame.dispose();
			}
		}
		public void  updateFont(int newSize)
		{
			wstaw.setFont(new Font("Times New Roman", Font.PLAIN, newSize));
			anuluj.setFont(new Font("Times New Roman", Font.PLAIN, newSize));
			lImie.setFont(new Font("Times New Roman", Font.PLAIN, newSize));
			lMiejsceZamieszkania.setFont(new Font("Times New Roman", Font.PLAIN, newSize));
			lNazwisko.setFont(new Font("Times New Roman", Font.PLAIN, newSize));
			lNrTelefonu.setFont(new Font("Times New Roman", Font.PLAIN, newSize));
			
		}
}
