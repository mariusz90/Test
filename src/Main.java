import java.awt.Dimension;

import javax.swing.JFrame;

import zagala.mariusz.classes.Klient;
import zagala.mariusz.classes.Samochod;
import zagala.mariusz.database.DBS;
import zagala.mariusz.panels.PanelGlowny;
import zagala.mariusz.panels.PanelLogowania;
import zagala.mariusz.panels.PanelTabelaSamochod;


public class Main {

	
	//metoda spina panel z oknem glownym programu
	public static void createAndShowGui()
	{
		//klasa ktora odpowiada za okienkow
		JFrame frame = new JFrame("BUTTONS");
		//dodajemy do krzyzyka opcje ze jak go n acisniesz to zamykasz okienko
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//tworzyy obiekt naszej klasy Okienko
		//PanelTabelaKlient panel = new PanelTabelaKlient();
		//PanelTabelaSamochod panel = new PanelTabelaSamochod();
		PanelLogowania panel = new PanelLogowania(frame);
		//ustawiamy panel na widoczny
		panel.setVisible(true);
		//ustawiamy zawartosc panelu jako glowna zawartosc okienka
		frame.setContentPane(panel);
		//pack to metoda ktora dopasuje rozmiar okineka do elementow ktore sie  wnim znajduja
		//frame.pack();
		frame.setSize(new Dimension(800,400));
		//ustawiamy widocznosc okienka na true
		frame.setVisible(true);
		//mozemy rozciagac okienko
		frame.setResizable(true);
		//dodajemy do jframea menu ktore pochodzi z formularza
		//frame.setJMenuBar(panel.createJMenuBar());
		//pack
		frame.pack();
	}
	public static void main(String[] args) {
		DBS.connect();
		DBS.createTables();
		
		javax.swing.SwingUtilities.invokeLater(
				new Runnable()
				{
					public void run()
					{
						createAndShowGui();
					}
				}
		);
		

	}

}
