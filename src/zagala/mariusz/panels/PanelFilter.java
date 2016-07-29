package zagala.mariusz.panels;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import zagala.mariusz.classes.Laczona;
import zagala.mariusz.database.DBS;
import zagala.mariusz.settings.Settings;

public class PanelFilter extends JPanel implements ActionListener {
	private JLabel lCenaOd;
	private JLabel lCenaDo;

	private JLabel lPrzebiegOd;
	private JLabel lPrzebiegDo;

	private JLabel lPojemnoscOd;
	private JLabel lPojemnoscDo;

	private JLabel lmarka;
	private JLabel lkolor;

	private JLabel lRokProdukcjiOd;
	private JLabel lRokProdukcjiDo;

	private JLabel lCzyKlimatyzacja;
	private JLabel lCzyNowy;
	private JLabel lCzyElektrycznaSzyba;

	private JTextField tfCenaOD;
	private JTextField tfCenaDo;

	private JTextField tfPrzebiegOd;
	private JTextField tfPrzebiegDo;

	private JTextField tfPojemnoscOd;
	private JTextField tfPojemnoscDo;

	private JTextField tfRokProdukcjiOd;
	private JTextField tfRokProdukcjiDo;

	/*
	 * private JComboBox<String> cbKolor; private JComboBox<String> cbMarka;
	 * 
	 * private ModelComboBoxKolor modelComboBoxKolor; private ModelComboBoxMarka
	 * modelComboBoxMarka;
	 */

	DefaultListModel<String> modelListaMarka;
	DefaultListModel<String> modelListaKolory;

	private JList<String> listMarka;
	private JList<String> listKolory;

	private JCheckBox wyborKlimatyzacja;
	private JCheckBox wyborSzyba;
	private JCheckBox wyborNowy;

	private JButton btnFiltruj;
	private JFrame frame;
	private JTable tabela;
	
	private boolean isCenaOdValid;

	private boolean isValidDouble(String text)
	{
		//moze sie pojawic kropka bo to double
		String[] przedPo = text.split("\\.");
		
		if (przedPo.length > 2)
		{
			return false;
		}
		else if (przedPo.length == 1) //masz liczbe bez kropki
		{
			//sprawdz czy masz do czynienia z liczba
			//skoro nie ma kropki to moge bezposrednio operowac na zmiennej text
			
			//https://docs.oracle.com/javase/tutorial/essential/regex/
			if (!text.matches("[1-9][0-9]*"))
			{
				return false;
			}
			return true;
		}
		else //masz liczbe z kropka
		{
			if (!przedPo[0].matches("[1-9][0-9]*") && !przedPo[1].matches("[0-9]+"))
			{
				return false;
			}
			return true;
		}
	}
	
	public PanelFilter(JFrame frame, JTable tabela) {
		super(new GridBagLayout());
		this.frame = frame;
		this.tabela = tabela;

		btnFiltruj = new JButton("Filtruj");
		btnFiltruj.addActionListener(this);

		tfCenaDo = new JTextField(10);
		//komponent textField zawiera w sobie specjalny obiekt ktory pozwoli dobierac sie do zawartosci ktora wpisujesz
		//i dodatkowo ja monitorowac
		tfCenaOD = new JTextField(10);
		tfCenaOD.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				
				if (!isValidDouble(tfCenaOD.getText()))
				{
					tfCenaOD.setBackground(Color.RED);
					isCenaOdValid = false;
				}
				else
				{
					tfCenaOD.setBackground(Color.WHITE);
					isCenaOdValid = true;
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				
				if (!isValidDouble(tfCenaOD.getText()))
				{
					tfCenaOD.setBackground(Color.RED);
				}
				else
				{
					tfCenaOD.setBackground(Color.WHITE);
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		tfPojemnoscDo = new JTextField(10);
		tfPojemnoscOd = new JTextField(10);

		tfPrzebiegOd = new JTextField(10);
		tfPrzebiegDo = new JTextField(10);

		tfRokProdukcjiDo = new JTextField(10);
		tfRokProdukcjiOd = new JTextField(10);

		wyborKlimatyzacja = new JCheckBox();
		wyborNowy = new JCheckBox();
		wyborSzyba = new JCheckBox();

		lCenaOd = new JLabel("Cena od");
		lCenaDo = new JLabel("do");

		lPojemnoscOd = new JLabel("Pojemnoœæ od");
		lPojemnoscDo = new JLabel("do");

		lPrzebiegOd = new JLabel("Przebieg od");
		lPrzebiegDo = new JLabel("do");

		lRokProdukcjiOd = new JLabel("Rok produkcji od");
		lRokProdukcjiDo = new JLabel("do");

		lCzyElektrycznaSzyba = new JLabel("Elektryczna szyba");
		lCzyKlimatyzacja = new JLabel("Klimatyzacja");
		lCzyNowy = new JLabel("Nowy");

		lkolor = new JLabel("Kolor");
		lmarka = new JLabel("Marka");

		// modelComboBoxKolor = new ModelComboBoxKolor();
		// cbKolor = new JComboBox<>(modelComboBoxKolor);
		modelListaMarka = new DefaultListModel<>();
		modelListaKolory = new DefaultListModel<>();
		// wypelniamy model listy
		for (Laczona l : DBS.innerJoin()) {
			if (!modelListaMarka.contains(l.getMarka()))
			{
				modelListaMarka.addElement(l.getMarka());
			}
			
			if(!modelListaKolory.contains(l.getKolor()))
			{
				modelListaKolory.addElement(l.getKolor());
			}
		}
		listMarka = new JList<>(modelListaMarka);
		listMarka.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listKolory = new JList<>(modelListaKolory);
		listKolory.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		// cbKolor.addActionListener(this);
		// modelComboBoxMarka = new ModelComboBoxMarka();
		// cbMarka = new JComboBox<>(modelComboBoxMarka);
		// cbMarka.addActionListener(this);

		GridBagConstraints gbcFilter = new GridBagConstraints();
		gbcFilter.weightx = 1; // powinny teraz kompoenty sie rozjezdzac
		gbcFilter.weighty = 1;

		gbcFilter.gridx = 1; // kolumna
		gbcFilter.gridy = 0; // wiersz
		gbcFilter.ipadx = 20;
		gbcFilter.insets = new Insets(Settings.ODSTEP_GORA, Settings.ODSTEP_LEWO, Settings.ODSTEP_DOL,
				Settings.ODSTEP_PRAWO);
		gbcFilter.anchor = GridBagConstraints.LINE_START;

		gbcFilter.gridx = 0;
		gbcFilter.gridy = 0;
		gbcFilter.ipadx = 20;
		add(lCenaOd, gbcFilter);

		gbcFilter.gridx = 1;
		gbcFilter.gridy = 0;
		gbcFilter.ipadx = 20;
		add(tfCenaOD, gbcFilter);

		gbcFilter.gridx = 2;
		gbcFilter.gridy = 0;
		gbcFilter.ipadx = 20;
		add(lCenaDo, gbcFilter);

		gbcFilter.gridx = 3;
		gbcFilter.gridy = 0;
		gbcFilter.ipadx = 20;
		add(tfCenaDo, gbcFilter);

		gbcFilter.gridx = 0;
		gbcFilter.gridy = 1;
		gbcFilter.ipadx = 20;
		add(lPrzebiegOd, gbcFilter);

		gbcFilter.gridx = 1;
		gbcFilter.gridy = 1;
		gbcFilter.ipadx = 20;
		add(tfPrzebiegOd, gbcFilter);

		gbcFilter.gridx = 2;
		gbcFilter.gridy = 1;
		gbcFilter.ipadx = 20;
		add(lPrzebiegDo, gbcFilter);

		gbcFilter.gridx = 3;
		gbcFilter.gridy = 1;
		gbcFilter.ipadx = 20;
		add(tfPrzebiegDo, gbcFilter);

		gbcFilter.gridx = 0;
		gbcFilter.gridy = 2;
		gbcFilter.ipadx = 20;
		add(lPojemnoscOd, gbcFilter);

		gbcFilter.gridx = 1;
		gbcFilter.gridy = 2;
		gbcFilter.ipadx = 20;
		add(tfPojemnoscOd, gbcFilter);

		gbcFilter.gridx = 2;
		gbcFilter.gridy = 2;
		gbcFilter.ipadx = 20;
		add(lPojemnoscDo, gbcFilter);

		gbcFilter.gridx = 3;
		gbcFilter.gridy = 2;
		gbcFilter.ipadx = 20;
		add(tfPojemnoscDo, gbcFilter);

		gbcFilter.gridx = 0;
		gbcFilter.gridy = 3;
		gbcFilter.ipadx = 20;
		add(lRokProdukcjiOd, gbcFilter);

		gbcFilter.gridx = 1;
		gbcFilter.gridy = 3;
		gbcFilter.ipadx = 20;
		add(tfRokProdukcjiOd, gbcFilter);

		gbcFilter.gridx = 2;
		gbcFilter.gridy = 3;
		gbcFilter.ipadx = 20;
		add(lRokProdukcjiDo, gbcFilter);

		gbcFilter.gridx = 3;
		gbcFilter.gridy = 3;
		gbcFilter.ipadx = 20;
		add(tfRokProdukcjiDo, gbcFilter);

		gbcFilter.gridx = 0;
		gbcFilter.gridy = 4;
		gbcFilter.ipadx = 20;
		add(lmarka, gbcFilter);

		gbcFilter.gridx = 1;
		gbcFilter.gridy = 4;
		gbcFilter.ipadx = 20;
		add(new JScrollPane(listMarka), gbcFilter);

		gbcFilter.gridx = 0;
		gbcFilter.gridy = 5;
		gbcFilter.ipadx = 20;
		add(lkolor, gbcFilter);

		gbcFilter.gridx = 1;
		gbcFilter.gridy = 5;
		gbcFilter.ipadx = 20;
		add(new JScrollPane(listKolory), gbcFilter);

		gbcFilter.gridx = 0;
		gbcFilter.gridy = 6;
		gbcFilter.ipadx = 20;
		add(lCzyElektrycznaSzyba, gbcFilter);

		gbcFilter.gridx = 1;
		gbcFilter.gridy = 6;
		gbcFilter.ipadx = 20;
		add(wyborSzyba, gbcFilter);

		gbcFilter.gridx = 0;
		gbcFilter.gridy = 7;
		gbcFilter.ipadx = 20;
		add(lCzyKlimatyzacja, gbcFilter);

		gbcFilter.gridx = 1;
		gbcFilter.gridy = 7;
		gbcFilter.ipadx = 20;
		add(wyborKlimatyzacja, gbcFilter);

		gbcFilter.gridx = 0;
		gbcFilter.gridy = 8;
		gbcFilter.ipadx = 20;
		add(lCzyNowy, gbcFilter);

		gbcFilter.gridx = 1;
		gbcFilter.gridy = 8;
		gbcFilter.ipadx = 20;
		add(wyborNowy, gbcFilter);

		gbcFilter.gridx = 3;
		gbcFilter.gridy = 9;
		gbcFilter.ipadx = 20;
		add(btnFiltruj, gbcFilter);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnFiltruj)
		{
			double cenaOd = Double.parseDouble(tfCenaOD.getText());
			double cenaDo = Double.parseDouble(tfCenaDo.getText());
			double pojemnoscOd = Double.parseDouble(tfPojemnoscOd.getText());
			double pojemnoscDo = Double.parseDouble(tfPojemnoscDo.getText());
			double przebiegOd = Double.parseDouble(tfPrzebiegOd.getText());
			double przebiegDo = Double.parseDouble(tfPrzebiegDo.getText());
			int rokProdukcjiOd =  Integer.parseInt(tfRokProdukcjiOd.getText());
			int rokProdukcjiDo = Integer.parseInt(tfRokProdukcjiDo.getText());
			List<String> marki = listMarka.getSelectedValuesList();
			List<String> kolory = listKolory.getSelectedValuesList();
			boolean czyKlimatyzacja = wyborKlimatyzacja.isSelected();
			boolean czySzyba = wyborSzyba.isSelected();
			boolean czyNowy = wyborNowy.isSelected();
			
			//if (isCenaOdValid && !marki.isEmpty() && marki != null && !kolory.isEmpty() && kolory != null/* && tutaj kolejne iscostam*/ )
			//{
				DBS.selectFilter(cenaOd, cenaDo, pojemnoscOd, pojemnoscDo, przebiegOd, przebiegDo, rokProdukcjiOd, rokProdukcjiDo, marki, kolory, czyKlimatyzacja, czySzyba, czyNowy);
			//}
			/*
			System.out.println("Cena od " + cenaOd);
			System.out.println("Cena do " + cenaOd);
			System.out.println("Pojemnosc od " + pojemnoscOd);
			System.out.println("Pojemnosc do " + pojemnoscDo);
			System.out.println("Przebieg od " + przebiegOd);
			System.out.println("Przebieg do " + przebiegDo);
			System.out.println("Rok produkcji od " + rokProdukcjiOd);
			System.out.println("Rok produkcji do " + rokProdukcjiDo);
			System.out.println("Marka " + marki);
			System.out.println("Kolor " + kolory);
			System.out.println("czyKlimatyzacja " + czyKlimatyzacja);
			System.out.println("czySzyba " + czySzyba);
			System.out.println("czyNowy " + czyNowy);
			*/
		}

	}
}
