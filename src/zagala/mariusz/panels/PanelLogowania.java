package zagala.mariusz.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import zagala.mariusz.settings.Settings;



public class PanelLogowania extends JPanel implements ActionListener{
	  

		private JButton btnLoguj;
		private JButton btnAnuluj;
		private JTextField tfPoleUser;
		private JPasswordField tfPoleHaslo;
		private JLabel lUser;
		private JLabel lHaslo;
		
		private JFrame frame;
		
		public PanelLogowania(JFrame frame)
		{
			super(new GridBagLayout());
			
			GridBagConstraints gbcGlowny = new GridBagConstraints();
			gbcGlowny.weightx = 1; 
			gbcGlowny.weighty = 1;
			gbcGlowny.gridx = 1; 
			gbcGlowny.gridy = 0;
			gbcGlowny.ipadx = 20;
			gbcGlowny.insets = new Insets(Settings.ODSTEP_GORA, Settings.ODSTEP_LEWO, Settings.ODSTEP_DOL, Settings.ODSTEP_PRAWO);
			gbcGlowny.anchor = GridBagConstraints.LINE_START;
			
			this.frame = frame;
			btnLoguj = new JButton("Loguj");
			btnLoguj.addActionListener(this);
			btnAnuluj = new JButton("Anuluj");
			btnAnuluj.addActionListener(this);
			
			lHaslo = new JLabel("Haslo");
			lUser = new JLabel("U¿ytkownik");
			
			tfPoleHaslo = new JPasswordField(10);
			tfPoleUser = new JTextField(10);
			
			
			
			gbcGlowny.gridx = 0; 
			gbcGlowny.gridy = 0; 
			gbcGlowny.ipadx = 20;
			add(lUser,gbcGlowny);

			
			gbcGlowny.gridx = 1; 
			gbcGlowny.gridy = 0; 
			gbcGlowny.ipadx = 20;
			add(tfPoleUser,gbcGlowny);
			
			gbcGlowny.gridx = 0; 
			gbcGlowny.gridy = 1; 
			gbcGlowny.ipadx = 20;
			add(lHaslo,gbcGlowny);
			
			gbcGlowny.gridx = 1; 
			gbcGlowny.gridy = 1; 
			gbcGlowny.ipadx = 20;
			add(tfPoleHaslo,gbcGlowny);
			
			gbcGlowny.gridx = 0; 
			gbcGlowny.gridy = 2; 
			gbcGlowny.ipadx = 20;
			add(btnLoguj,gbcGlowny);
			
			gbcGlowny.gridx = 1; 
			gbcGlowny.gridy = 2; 
			gbcGlowny.ipadx = 20;
			add(btnAnuluj,gbcGlowny);
			
		}



		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == btnLoguj)
			{
				String hasloDobre = "1";
				String userDobry = "1";
				
				//1. pobieramy dane wpisane przez usera w polach txt
				String podanyUser = tfPoleUser.getText();
				char[] podaneHaslo = tfPoleHaslo.getPassword();
				String podaneHasloStr = String.valueOf(podaneHaslo); //konwersja z char[] na String
				
				if (hasloDobre.equals(podaneHasloStr) && userDobry.equals(podanyUser))
				{
					//musimy wyswietlic okienko z panelami
					JFrame frameGlowny = new JFrame("TABELA");
					//dodajemy do krzyzyka opcje ze jak go n acisniesz to zamykasz okienko
					frameGlowny.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//tworzyy obiekt naszej klasy Okienko
					PanelGlowny panel = new PanelGlowny();
					//ustawiamy panel na widoczny
					panel.setVisible(true);
					//ustawiamy zawartosc panelu jako glowna zawartosc okienka
					frameGlowny.setContentPane(panel);
					//pack to metoda ktora dopasuje rozmiar okineka do elementow ktore sie  wnim znajduja
					frameGlowny.pack();
					//frame.setSize(new Dimension(300,400));
					//ustawiamy widocznosc okienka na true
					frameGlowny.setVisible(true);
					//mozemy rozciagac okienko
					frameGlowny.setResizable(false);
					//menu
					frameGlowny.setJMenuBar(panel.createJMenuBar());
					//kiedy bedziemy wchodzic do okienka z formularzem glownym to zamkniemy okienko z logowaniem
					frame.dispose();
				}
			}
			else if(e.getSource() == btnAnuluj)
			{
				//kiedy naciskamy anuluj to chcemy zeby okienko logowania sie zamknelo
				//do okienka logowania mozemy odniesc sie przez this
				//pamietaj zamykasz JFrame a nie panel wiec musisz zrobic wszystko zeby w tym miejscu
				//znalzla sie referencja do JFrame w ktorym otwierasz twoj panel
				frame.dispose();
				
			}
			
		}
		
	}


