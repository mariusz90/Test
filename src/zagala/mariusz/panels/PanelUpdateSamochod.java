package zagala.mariusz.panels;

import java.awt.Font;
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

public class PanelUpdateSamochod extends JPanel implements ActionListener {
	private JTextField tfId;
	private JTextField tfMarka;
	private JTextField tfKolor;
	private JTextField tfPojemnosc;
	private JTextField tfCena;
	private JTextField tfPrzebieg;
	private JTextField tfRokProdukcji;

	private JLabel lId;
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
	
	private JButton update;
	private JButton anuluj;
	private JFrame frame;
	private JTable tabela;
	private ModelTabelaSamochod model;
	
	public PanelUpdateSamochod ( JFrame frame, Samochod modyfikowany,JTable tabela, ModelTabelaSamochod model)
	{
		super(new GridBagLayout());
		
		this.frame = frame;
		this.tabela = tabela;
		this.model = model;
		
		update = new JButton("Update");
		//update.setFont(new Font("Comic Sans MS", Font.PLAIN, Settings.FONT_SIZE));
		update.addActionListener(this);
		anuluj = new JButton("Anuluj");
		//anuluj.setFont(new Font("Comic Sans MS", Font.PLAIN, Settings.FONT_SIZE));
		anuluj.addActionListener(this);
		
		tfId = new JTextField(10);
		//tfId.setFont(new Font("Comic Sans MS", Font.PLAIN, Settings.FONT_SIZE));
		tfMarka = new JTextField(10);
		//tfMarka.setFont(new Font("Comic Sans MS", Font.PLAIN, Settings.FONT_SIZE));
		tfKolor = new JTextField(10);
		//tfKolor.setFont(new Font("Comic Sans MS", Font.PLAIN, Settings.FONT_SIZE));
		tfPojemnosc = new JTextField(10);
		//tfPojemnosc.setFont(new Font("Comic Sans MS", Font.PLAIN, Settings.FONT_SIZE));
		tfPrzebieg = new JTextField(10);
		//tfPrzebieg.setFont(new Font("Comic Sans MS", Font.PLAIN, Settings.FONT_SIZE));
		tfCena = new JTextField(10);
		//tfCena.setFont(new Font("Comic Sans MS", Font.PLAIN, Settings.FONT_SIZE));
		tfRokProdukcji = new JTextField(10);
		//tfRokProdukcji.setFont(new Font("Comic Sans MS", Font.PLAIN, Settings.FONT_SIZE));
		
		wyborKlimatyzacja = new JCheckBox();		
		wyborSzyba = new JCheckBox();
		wyborNowy = new JCheckBox();
		lId = new JLabel("Id");
		lMarka = new JLabel("Marka");
		lKolor = new JLabel("Kolor");
		lCena = new JLabel("Cena");
		lPojemnosc = new JLabel("Pojemnoœæ");
		lPrzebieg = new JLabel("Przebieg");
		lRokProdukcji = new JLabel("Rok produkcji");
		lCzyKlimatyzacja = new JLabel("Klimatyzacja");
		lCzyElektryczneSzyby = new JLabel("Elektryczne szyby");
		lCzyNowy = new JLabel("Stan nowy");
		
		tfId.setText(modyfikowany.getId()+ "");
		tfMarka.setText(modyfikowany.getMarka()+ "");
		tfKolor.setText(modyfikowany.getKolor()+ "");
		tfCena.setText(modyfikowany.getCena()+ "");
		tfPojemnosc.setText(modyfikowany.getPojemnosc()+ "");
		tfPrzebieg.setText(modyfikowany.getPrzebieg()+ "");
		tfRokProdukcji.setText(modyfikowany.getRokProdukcji()+ "");
		wyborKlimatyzacja.setSelected(modyfikowany.isCzyKlimatyzacja());
		wyborSzyba.setSelected(modyfikowany.isCzyElektryczneSzyby());
		wyborNowy.setSelected(modyfikowany.isCzyNowy());
		
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
		add(update,gbcDodSam);
		
		gbcDodSam.gridx = 1; 
		gbcDodSam.gridy = 9; 
		gbcDodSam.ipadx = 20;
		add(anuluj,gbcDodSam);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == update)
		{
			int id = Integer.parseInt(tfId.getText());
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
			Samochod S = new Samochod(id,marka,kolor,cena, pojemnosc,przebieg,rokProdukcji,czyKlimatyzacja ,czyElektryczneSzyby,czyNowy);
			DBS.updateSamochod(S);
			System.out.println("-------------------");
			for (Samochod s : DBS.selectSamochod())
			{
				System.out.println(s);
			}
			model.updateRows(DBS.selectSamochod());
			tabela.updateUI();
			
			
		}
		else if(e.getSource()== anuluj)
		{
			frame.dispose();
		}
	}

}
