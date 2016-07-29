package zagala.mariusz.panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;



import zagala.mariusz.classes.Klient;
import zagala.mariusz.classes.Samochod;
import zagala.mariusz.database.DBS;
import zagala.mariusz.models.ModelTabelaKlient;
import zagala.mariusz.models.ModelTabelaSamochod;

public class PanelUpdateKlienta extends JPanel implements ActionListener {
	private JTextField tfId;
	private JTextField tfImie;
	private JTextField tfNazwisko;
	private JTextField tfMiejsceZamieszkania;
	private JTextField tfNrTelefonu;
	
	private JLabel lId;
	private JLabel lImie;
	private JLabel lNazwisko;
	private JLabel lMiejsceZamieszkania;
	private JLabel lNrTelefonu;
	private JButton update;
	private JButton anuluj;
	private JFrame frame;
	private JTable tabela;
	private ModelTabelaKlient model;
	public PanelUpdateKlienta( JFrame frame, Klient modyfikowany,JTable tabela, ModelTabelaKlient model)
	{
		super(new GridLayout(6,2,8,8));
		
		this.frame = frame;
		this.model = model;
		this.tabela = tabela;
		
		update = new JButton("Update");
		update.addActionListener(this);
		anuluj = new JButton("Anuluj");
		anuluj.addActionListener(this);
		
		tfId = new JTextField(10);
		tfImie = new JTextField(10);
		tfNazwisko = new JTextField(10);
		tfMiejsceZamieszkania = new JTextField(10);
		tfNrTelefonu = new JTextField(10);
		
		lId = new JLabel("Id");
		lImie = new JLabel("Imie");
		lNazwisko = new JLabel("Nazwisko");
		lMiejsceZamieszkania = new JLabel("Miejsce zamieszkania");
		lNrTelefonu = new JLabel("Numer telefonu");
		
		tfId.setText(modyfikowany.getId()+"");
		tfImie.setText(modyfikowany.getImie() + "");
		tfNazwisko.setText(modyfikowany.getNazwisko()+ "");
		tfMiejsceZamieszkania.setText(modyfikowany.getMiejsceZamieszkania()+ "");
		tfNrTelefonu.setText(modyfikowany.getNrTelefonu()+ "");
		
		add(lId);
		add(tfId);
		add(lImie);
		add(tfImie);
		add(lNazwisko);
		add(tfNazwisko);
		add(lMiejsceZamieszkania);
		add(tfMiejsceZamieszkania);
		add(lNrTelefonu);
		add(tfNrTelefonu);
		add(update);
		add(anuluj);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == update)
		{
			int id = Integer.parseInt(tfId.getText());
			String imie = tfImie.getText();
			String nazwisko = tfNazwisko.getText();
			String miejsceZamieszkania = tfMiejsceZamieszkania.getText();
			int nrTelefonu = Integer.parseInt(tfNrTelefonu.getText());
			Klient k = new Klient(id,imie, nazwisko ,miejsceZamieszkania,nrTelefonu);
			DBS.updateKlient(k);
		
			
			model.updateRows(DBS.slectKlient());
			tabela.updateUI();
			
		}
		else if(e.getSource()== anuluj)
		{
			frame.dispose();
		}
	}
	
}
