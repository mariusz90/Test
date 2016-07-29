package zagala.mariusz.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import zagala.mariusz.classes.Klient;
import zagala.mariusz.classes.Samochod;
import zagala.mariusz.classes.Zakup;
import zagala.mariusz.database.DBS;
import zagala.mariusz.models.ModelComboBoxKlient;
import zagala.mariusz.models.ModelComboBoxSamochod;
import zagala.mariusz.models.ModelTabelaLaczona;
import zagala.mariusz.settings.Settings;



public class PanelTabelaZakup extends JPanel implements ActionListener{

	private JComboBox<Integer> cbSamochod;
	private JComboBox<Integer> cbKlient;
	
	private JLabel lIdSamochod;
	private JLabel lIdKlient;
	
	private JLabel lIdS;
	private JLabel lIdK;
	
	private JTextField tfIdS;
	private JTextField tfIK;
	private JTextField tfId;
	
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
	
	private JTextField tfImie;
	private JTextField tfNazwisko;
	private JTextField tfMiejsceZamieszkania;
	private JTextField tfNrTelefonu;
	
	private JLabel lImie;
	private JLabel lNazwisko;
	private JLabel lMiejsceZamieszkania;
	private JLabel lNrTelefonu;
	
	private JTable tabelaLaczona;
	private ModelTabelaLaczona model;
	
	private JButton btnInsert;
	private JButton btnDelete;
	private JButton btnFiltruj;
	
	private JPanel panelGora;
	private JPanel panelSrodek;
	private JPanel panelSrodek1;
	private JPanel panelSrodek2;
	private JPanel panelDol;
	
	private JFrame frame;
	private JTable tabela;
	
	private ModelComboBoxKlient modelComboBoxKlient;
	private ModelComboBoxSamochod modelComboBoxSamochod ;
	

	private List<Zakup> lista;
	private int idx;

	public PanelTabelaZakup()
	{
		super(new BorderLayout());
		
		panelGora = new JPanel(new GridLayout());
		GridBagConstraints gbcGora = new GridBagConstraints();
		gbcGora.gridy = 0; //wiersz
		gbcGora.gridx = 0; //kolumna
		gbcGora.ipadx = 300;
		gbcGora.ipady = 100;
		
		//gbcGora.fill = GridBagConstraints.BOTH;
		model = new ModelTabelaLaczona();
		tabelaLaczona = new JTable(model);
		panelGora.add(new JScrollPane(tabelaLaczona,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		gbcGora.gridwidth = 1;
		
		panelSrodek = new JPanel(new GridBagLayout());
		
		modelComboBoxSamochod = new ModelComboBoxSamochod();
		cbSamochod =  new JComboBox<>(modelComboBoxSamochod);
		cbSamochod.addActionListener(this);
		
		lIdSamochod = new JLabel("ID Samochod");
		tfMarka = new JTextField();
		tfKolor = new JTextField();
		tfPojemnosc = new JTextField();
		tfPrzebieg = new JTextField();
		tfCena = new JTextField();
		tfRokProdukcji = new JTextField();
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
		
		modelComboBoxKlient = new ModelComboBoxKlient();
		cbKlient =  new JComboBox<>(modelComboBoxKlient);
		cbKlient.addActionListener(this);
		
		lIdKlient = new JLabel("ID Klient");
		
		tfImie = new JTextField();
		tfNazwisko = new JTextField();
		tfMiejsceZamieszkania = new JTextField();
		tfNrTelefonu = new JTextField();
		
		lImie = new JLabel("Imie");
		lNazwisko = new JLabel("Nazwisko");
		lMiejsceZamieszkania = new JLabel("Miejsce zamieszkania");
		lNrTelefonu = new JLabel("Numer telefonu");
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		
		btnFiltruj = new JButton("Flitruj");
		btnFiltruj.addActionListener(this);
		
		
		GridBagConstraints gbcSrodek = new GridBagConstraints();
		gbcSrodek.weightx = 1; //powinny teraz kompoenty sie rozjezdzac
		gbcSrodek.weighty = 1;
		
		gbcSrodek.gridx = 1; //kolumna
		gbcSrodek.gridy = 0; //wiersz
		gbcSrodek.ipadx = 20;
		gbcSrodek.insets = new Insets(Settings.ODSTEP_GORA, Settings.ODSTEP_LEWO, Settings.ODSTEP_DOL, Settings.ODSTEP_PRAWO);
		gbcSrodek.anchor = GridBagConstraints.LINE_START;
		panelSrodek.add(cbSamochod, gbcSrodek);
		
		gbcSrodek.gridx = 0; //kolumna
		gbcSrodek.gridy = 0; //wiersz
		gbcSrodek.ipadx = 20;
		panelSrodek.add(lIdSamochod, gbcSrodek);
		
		gbcSrodek.gridx = 3; //kolumna
		gbcSrodek.gridy = 0; //wiersz
		gbcSrodek.ipadx = 20;
		panelSrodek.add(cbKlient, gbcSrodek);
		
		gbcSrodek.gridx = 2; //kolumna
		gbcSrodek.gridy = 0; //wiersz
		gbcSrodek.ipadx = 0;
		panelSrodek.add(lIdKlient, gbcSrodek);
		
		gbcSrodek.gridx = 0; //kolumna
		gbcSrodek.gridy = 1; //wiersz
		gbcSrodek.ipadx = 0; 
		panelSrodek.add(lMarka, gbcSrodek);
		
		gbcSrodek.gridx = 1; //kolumna
		gbcSrodek.gridy = 1; //wiersz
		gbcSrodek.ipadx = Settings.SZEROKOSC_TEXT_FIELD_TABELA_ZAKUPY;
		panelSrodek.add(tfMarka, gbcSrodek);
		
		gbcSrodek.gridx = 2; //kolumna
		gbcSrodek.gridy = 1; //wiersz
		gbcSrodek.ipadx = 0;
		panelSrodek.add(lImie, gbcSrodek);
		
		gbcSrodek.gridx = 3; //kolumna
		gbcSrodek.gridy = 1; //wiersz
		gbcSrodek.ipadx = Settings.SZEROKOSC_TEXT_FIELD_TABELA_ZAKUPY;
		panelSrodek.add(tfImie, gbcSrodek);
		
		gbcSrodek.gridx = 0; //kolumna
		gbcSrodek.gridy = 2; //wiersz
		gbcSrodek.ipadx = 0; 
		panelSrodek.add(lKolor, gbcSrodek);
		
		gbcSrodek.gridx = 1; //kolumna
		gbcSrodek.gridy = 2; //wiersz
		gbcSrodek.ipadx = Settings.SZEROKOSC_TEXT_FIELD_TABELA_ZAKUPY;
		panelSrodek.add(tfKolor, gbcSrodek);
		
		gbcSrodek.gridx = 2; //kolumna
		gbcSrodek.gridy = 2; //wiersz
		gbcSrodek.ipadx = 0; 
		panelSrodek.add(lNazwisko, gbcSrodek);
		
		gbcSrodek.gridx = 3; //kolumna
		gbcSrodek.gridy = 2; //wiersz
		gbcSrodek.ipadx = Settings.SZEROKOSC_TEXT_FIELD_TABELA_ZAKUPY;
		panelSrodek.add(tfNazwisko, gbcSrodek);
		
		gbcSrodek.gridx = 0; //kolumna
		gbcSrodek.gridy = 3; //wiersz
		gbcSrodek.ipadx = 0; 
		panelSrodek.add(lCena, gbcSrodek);
		
		gbcSrodek.gridx = 1; //kolumna
		gbcSrodek.gridy = 3; //wiersz
		gbcSrodek.ipadx = Settings.SZEROKOSC_TEXT_FIELD_TABELA_ZAKUPY;
		panelSrodek.add(tfCena, gbcSrodek);
		
		gbcSrodek.gridx = 2; //kolumna
		gbcSrodek.gridy = 3; //wiersz
		gbcSrodek.ipadx = 0; 
		panelSrodek.add(lMiejsceZamieszkania, gbcSrodek);
		
		gbcSrodek.gridx = 3; //kolumna
		gbcSrodek.gridy = 3; //wiersz
		gbcSrodek.ipadx = Settings.SZEROKOSC_TEXT_FIELD_TABELA_ZAKUPY;
		panelSrodek.add(tfMiejsceZamieszkania, gbcSrodek);
		
		gbcSrodek.gridx = 0; //kolumna
		gbcSrodek.gridy = 4; //wiersz
		gbcSrodek.ipadx = 0; 
		panelSrodek.add(lPojemnosc, gbcSrodek);
		
		gbcSrodek.gridx = 1; //kolumna
		gbcSrodek.gridy = 4; //wiersz
		gbcSrodek.ipadx = Settings.SZEROKOSC_TEXT_FIELD_TABELA_ZAKUPY;
		panelSrodek.add(tfPojemnosc, gbcSrodek);
		
		gbcSrodek.gridx = 2; //kolumna
		gbcSrodek.gridy = 4; //wiersz
		gbcSrodek.ipadx = 0; 
		panelSrodek.add(lNrTelefonu, gbcSrodek);
		
		gbcSrodek.gridx = 3; //kolumna
		gbcSrodek.gridy = 4; //wiersz
		gbcSrodek.ipadx = Settings.SZEROKOSC_TEXT_FIELD_TABELA_ZAKUPY;
		panelSrodek.add(tfNrTelefonu, gbcSrodek);
		
		gbcSrodek.gridx = 0; //kolumna
		gbcSrodek.gridy = 5; //wiersz
		gbcSrodek.ipadx = 0; 
		panelSrodek.add(lPrzebieg, gbcSrodek);
		
		gbcSrodek.gridx = 1; //kolumna
		gbcSrodek.gridy = 5; //wiersz
		gbcSrodek.ipadx = Settings.SZEROKOSC_TEXT_FIELD_TABELA_ZAKUPY;
		panelSrodek.add(tfPrzebieg, gbcSrodek);
		
		gbcSrodek.gridx = 0; //kolumna
		gbcSrodek.gridy = 6; //wiersz
		gbcSrodek.ipadx = 0; 
		panelSrodek.add(lRokProdukcji, gbcSrodek);
		
		gbcSrodek.gridx = 1; //kolumna
		gbcSrodek.gridy = 6; //wiersz
		gbcSrodek.ipadx = Settings.SZEROKOSC_TEXT_FIELD_TABELA_ZAKUPY;
		panelSrodek.add(tfRokProdukcji, gbcSrodek);
		
		gbcSrodek.gridx = 0; //kolumna
		gbcSrodek.gridy = 7; //wiersz
		gbcSrodek.ipadx = 0; 
		panelSrodek.add(lCzyElektryczneSzyby, gbcSrodek);
		
		gbcSrodek.gridx = 1; //kolumna
		gbcSrodek.gridy = 7; //wiersz
		gbcSrodek.ipadx = Settings.SZEROKOSC_TEXT_FIELD_TABELA_ZAKUPY;
		panelSrodek.add(wyborSzyba, gbcSrodek);
		
		gbcSrodek.gridx = 0; //kolumna
		gbcSrodek.gridy = 8; //wiersz
		gbcSrodek.ipadx = 0; 
		panelSrodek.add(lCzyKlimatyzacja, gbcSrodek);
		
		gbcSrodek.gridx = 1; //kolumna
		gbcSrodek.gridy = 8; //wiersz
		gbcSrodek.ipadx = Settings.SZEROKOSC_TEXT_FIELD_TABELA_ZAKUPY;
		panelSrodek.add(wyborKlimatyzacja, gbcSrodek);
		
		gbcSrodek.gridx = 0; //kolumna
		gbcSrodek.gridy = 9; //wiersz
		gbcSrodek.ipadx = 0; 
		panelSrodek.add(lCzyNowy, gbcSrodek);
		
		gbcSrodek.gridx = 1; //kolumna
		gbcSrodek.gridy = 9; //wiersz
		gbcSrodek.ipadx = Settings.SZEROKOSC_TEXT_FIELD_TABELA_ZAKUPY;
		panelSrodek.add(wyborNowy, gbcSrodek);
		
		gbcSrodek.gridx = 0; //kolumna
		gbcSrodek.gridy = 10; //wiersz
		gbcSrodek.gridwidth = 2; //szerokosc na dwie kolumny
		gbcSrodek.fill = GridBagConstraints.BOTH; //pozwalasz na rozszerzanie sie w obydwie strony
		//gbcSrodek.fill = GridBagConstraints.HORIZONTAL; //tylko w poziomie
		//gbcSrodek.fill = GridBagConstraints.VERTICAL; //tylko w pionie
		panelSrodek.add(btnInsert, gbcSrodek);
		
		gbcSrodek.gridx = 2; //kolumna
		gbcSrodek.gridy = 10; //wiersz
		gbcSrodek.gridwidth = 2;
		panelSrodek.add(btnDelete, gbcSrodek);
		
		gbcSrodek.gridx = 0; //kolumna
		gbcSrodek.gridy = 11; //wiersz
		gbcSrodek.gridwidth = 2;
		panelSrodek.add(btnFiltruj, gbcSrodek);
		
		GridBagConstraints gbcAll = new GridBagConstraints();
		gbcAll.insets = new Insets(Settings.ODSTEP_GORA, Settings.ODSTEP_LEWO, Settings.ODSTEP_DOL, Settings.ODSTEP_PRAWO);
		
		gbcAll.gridx = 0;
		gbcAll.gridy = 0;
		add(panelGora, BorderLayout.CENTER);
		
		gbcAll.gridx = 0;
		gbcAll.gridy = 1;
		add(panelSrodek, BorderLayout.PAGE_END);
		
		/*
		super(new GridLayout(2,1,5,5));
		
		
		panelGora = new JPanel(new GridLayout(1, 1, 5 ,5));
		model = new ModelTabelaZakup();
		tabelaZakup = new JTable(model);
		
		
		panelSrodek1 = new JPanel(new GridLayout(10, 2, 5 ,5));
		
		modelComboBoxSamochod = new ModelComboBoxSamochod();
		cbSamochod =  new JComboBox<>(modelComboBoxSamochod);
		cbSamochod.addActionListener(this);
		
		lIdSamochod = new JLabel("ID Samochod");
		
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
		
		panelSrodek1.add(lIdSamochod);
		panelSrodek1.add(cbSamochod);
		panelSrodek1.add(lMarka);
		panelSrodek1.add(tfMarka);
		panelSrodek1.add(lKolor);
		panelSrodek1.add(tfKolor);
		panelSrodek1.add(lCena);
		panelSrodek1.add(tfCena);
		panelSrodek1.add(lPojemnosc);
		panelSrodek1.add(tfPojemnosc);
		panelSrodek1.add(lPrzebieg);
		panelSrodek1.add(tfPrzebieg);
		panelSrodek1.add(lRokProdukcji);
		panelSrodek1.add(tfRokProdukcji);
		panelSrodek1.add(lCzyKlimatyzacja);
		panelSrodek1.add(wyborKlimatyzacja);
		panelSrodek1.add(lCzyElektryczneSzyby);
		panelSrodek1.add(wyborSzyba);
		panelSrodek1.add(lCzyNowy);
		panelSrodek1.add(wyborNowy);
		
		panelSrodek2 =  new JPanel(new GridLayout(6, 2, 5 ,5));
		
		modelComboBoxKlient = new ModelComboBoxKlient();
		cbKlient =  new JComboBox<>(modelComboBoxKlient);
		cbKlient.addActionListener(this);
		
		lIdKlient = new JLabel("ID Klient");
		
		tfImie = new JTextField(12);
		tfNazwisko = new JTextField(12);
		tfMiejsceZamieszkania = new JTextField(12);
		tfNrTelefonu = new JTextField(12);
		
		lImie = new JLabel("Imie");
		lNazwisko = new JLabel("Nazwisko");
		lMiejsceZamieszkania = new JLabel("Miejsce zamieszkania");
		lNrTelefonu = new JLabel("Numer telefonu");
		
		btnInsert = new JButton("Insert");
		btnInsert.addActionListener(this);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		
		panelSrodek2.add(lIdKlient);
		panelSrodek2.add(cbKlient);
		panelSrodek2.add(lImie);
		panelSrodek2.add(tfImie);
		panelSrodek2.add(lNazwisko);
		panelSrodek2.add(tfNazwisko);
		panelSrodek2.add(lMiejsceZamieszkania);
		panelSrodek2.add(tfMiejsceZamieszkania);
		panelSrodek2.add(lNrTelefonu);
		panelSrodek2.add(tfNrTelefonu);
		panelSrodek2.add(btnInsert);
		panelSrodek2.add(btnDelete);
		panelSrodek = new JPanel(new GridLayout(1, 2, 5 ,5));
		
		panelSrodek.add(panelSrodek1);
		panelSrodek.add(panelSrodek2);
		
		panelDol = new JPanel(new GridLayout(2, 1, 5 ,5));
		
//		btnInsert = new JButton("Insert");
//		btnInsert.addActionListener(this);
//		
//		btnDelete = new JButton("Delete");
//		btnDelete.addActionListener(this);
//		
//		panelDol.add(btnInsert);
//		panelDol.add(btnDelete);
		
		
		//add(panelDol,BorderLayout.PAGE_END);
		
		for(int i = 0; i < tabelaZakup.getColumnCount(); i++)
		{
			tabelaZakup.getColumnModel().getColumn(i).setPreferredWidth(80);
			//tabelaKlient.getColumnModel().getColumn(i).setWidth(180);
			//tabelaKlient.getColumnModel().getColumn(i).setMinWidth(80);
			//tabelaKlient.getColumnModel().getColumn(i).setMaxWidth(80);
			//tabelaZakup.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		}
		
	
		
		JScrollPane sb = new JScrollPane(tabelaZakup);
	            //JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            //JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JScrollPane sc = new JScrollPane(panelSrodek,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
	        	
	    		
		add(new JScrollPane(sb));
		add(panelSrodek);
		//add(panelDol,BorderLayout.PAGE_END);
	*/	
	
	}
	public ModelComboBoxSamochod getModelComboBoxSamochod() 
	{
		return modelComboBoxSamochod;
	}
	public ModelComboBoxKlient getModelComboBoxKlient() {
		return modelComboBoxKlient;
	}

	public JComboBox<Integer> getCbSamochod() {
		return cbSamochod;
	}
	public JComboBox<Integer> getCbKlient()
	{
		return cbKlient;
	}
	
	public JTextField getTfIdS() {
		return tfIdS;
	}
	public JTextField getTfIdK() {
		return tfIK;
	}
	/**
	 * @return the tfIdU
	 */
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public void fillFieldsSamochod(Samochod s)
	{
		tfMarka.setText(s.getMarka());
		tfKolor.setText(s.getKolor());
		tfCena.setText(s.getCena()+"");
		tfPojemnosc.setText(s.getPojemnosc()+"");
		tfPrzebieg.setText(s.getPrzebieg()+"");
		tfRokProdukcji.setText(s.getRokProdukcji()+"");
		wyborKlimatyzacja.setSelected(s.isCzyKlimatyzacja());
		wyborSzyba.setSelected(s.isCzyElektryczneSzyby());
		wyborNowy.setSelected(s.isCzyNowy());
	}
	public void fillFieldsKlient(Klient k)
	{
		tfImie.setText(k.getImie());
		tfNazwisko.setText(k.getNazwisko());
		tfMiejsceZamieszkania.setText(k.getMiejsceZamieszkania());
		tfNrTelefonu.setText(k.getNrTelefonu()+"");
	}
	public void fillWypelnij()
	{
		if (lista.isEmpty() == false)
		{
			tfIdS.setText(lista.get(idx).getIdS()+"");
			tfIK.setText(lista.get(idx).getIdK()+"");
			tfId.setText(lista.get(idx).getId()+"");
		}
		else 
		{
			tfIdS.setText("");
			tfIK.setText("");
			tfId.setText("");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cbSamochod)
		{
			Integer id = (Integer)cbSamochod.getSelectedItem();
			System.out.println(id);
			Samochod s = DBS.selectSamochodId(id);
			fillFieldsSamochod(s);
		}
		if(e.getSource()== cbKlient)
		{
			Integer id = (Integer)cbKlient.getSelectedItem();
			System.out.println(id);
		    Klient s = DBS.selectKlientId(id);
		    fillFieldsKlient(s);
		}
		if(e.getSource()== btnInsert)
		{
			int s = (Integer)cbSamochod.getSelectedItem();
			int u = (Integer)cbKlient.getSelectedItem();
			if (DBS.insertZakup(s, u) == true)
			{
				JOptionPane.showMessageDialog(null, "POPRAWNIE WSTAWIONO DO BAZY");
				model.updateRows(DBS.innerJoin());
			}
			else
			{
				JOptionPane.showMessageDialog(null, "NIE UDALO SIE WSTAWIC");
			}
		}
		else if (e.getSource() == btnDelete)
		{
			int idx = tabelaLaczona.getSelectedRow();
			if (idx >= 0)
			{
				Integer idDoUsuniecia = (Integer)model.getValueAt(idx, 0);
				DBS.deleteZakup(idDoUsuniecia);
				model.updateRows(DBS.innerJoin());
				tabelaLaczona.updateUI();
			}
		}
		else if(e.getSource() == btnFiltruj)
		{
			//klasa ktora odpowiada za okienkow
			JFrame frame = new JFrame("Filter");
			//dodajemy do krzyzyka opcje ze jak go n acisniesz to zamykasz okienko
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//tworzyy obiekt naszej klasy Okienko
			PanelFilter panel = new PanelFilter(frame,  tabela);
			
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
		}
	}
	
	
}
