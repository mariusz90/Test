package zagala.mariusz.panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import zagala.mariusz.settings.Settings;

public class PanelGlowny extends JTabbedPane{
	private PanelTabelaSamochod panelTabelaSamochod;
	private PanelTabelaKlient panelTabelaKlient;
	private PanelTabelaZakup panelTabelaZakup;
	private PanelDodawanieKlient panelDodawanieKlient;
	private PanelDodawanieSamochod panelDodawanieSamochod;
	private PanelStatystyki panelStatystyki;
	public PanelGlowny()
	{
		super();
		panelTabelaSamochod = new PanelTabelaSamochod();
		panelTabelaKlient = new PanelTabelaKlient();
		panelTabelaZakup = new PanelTabelaZakup();
		panelDodawanieKlient = new PanelDodawanieKlient();
		panelStatystyki = new PanelStatystyki();
		addTab("CAR", panelTabelaSamochod);
		addTab("CUSTOMER", panelTabelaKlient);
		addTab("BUY", panelTabelaZakup);
		addTab("STATISTICS",panelStatystyki);
		
		//wywoluje sie kiedy zmieniasz zakladke
		//w tym listenerze umiescimy odswiezanie comboboxow
		addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				panelTabelaZakup.getModelComboBoxKlient().updateModel();
				panelTabelaZakup.getCbKlient().updateUI();
				
				panelTabelaZakup.getModelComboBoxSamochod().updateModel();
				panelTabelaZakup.getCbSamochod().updateUI();
				
			}
		});
	}
	
	public JMenuBar createJMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menuOptions = new JMenu("OPTIONS");
		menuOptions.setMnemonic(KeyEvent.VK_ALT);
		
		JMenu menuFontSize = new JMenu("FONT SIZE");
		menuFontSize.setMnemonic(KeyEvent.VK_S);
		JMenuItem font12 = new JMenuItem("12");
		font12.setMnemonic(KeyEvent.VK_2);
		font12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, KeyEvent.CTRL_MASK));
		font12.setIcon(new ImageIcon("12.png"));
		JMenuItem font14 = new JMenuItem("14");
		font14.setMnemonic(KeyEvent.VK_4);
		font14.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, KeyEvent.CTRL_MASK));
		font14.setIcon(new ImageIcon("14.png"));
		JMenuItem font16 = new JMenuItem("16");
		font16.setMnemonic(KeyEvent.VK_6);
		font16.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, KeyEvent.CTRL_MASK));
		font16.setIcon(new ImageIcon("16.png"));
		
		JMenu menuFontColor = new JMenu("FONT COLOR");
		menuFontColor.setMnemonic(KeyEvent.VK_C);
		JMenuItem fontRedColor = new JMenuItem("RED");
		fontRedColor.setMnemonic(KeyEvent.VK_R);
		fontRedColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, KeyEvent.CTRL_MASK));
		fontRedColor.setIcon(new ImageIcon("red.png"));
		JMenuItem fontBlueColor = new JMenuItem("BLUE");
		fontBlueColor.setMnemonic(KeyEvent.VK_B);
		fontBlueColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, KeyEvent.CTRL_MASK));
		fontBlueColor.setIcon(new ImageIcon("blue.png"));
		JMenuItem fontBlackColor = new JMenuItem("BLACK");
		fontBlackColor.setMnemonic(KeyEvent.VK_K);
		fontBlackColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, KeyEvent.CTRL_MASK));
		fontBlackColor.setIcon(new ImageIcon("black.png"));
		JMenu menuHelp = new JMenu("HELP");
		JMenuItem info = new JMenuItem("INFO");
		info.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_MASK));
		info.setIcon(new ImageIcon("info.png"));
		JMenuItem exit = new JMenuItem("EXIT");
		exit.setIcon(new ImageIcon("exit.png"));
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
		menuHelp.add(info);
		menuHelp.add(exit);
		
		menuFontSize.add(font12);
		menuFontSize.add(font14);
		menuFontSize.add(font16);
		menuOptions.add(menuFontSize);
		
		menuFontColor.add(fontRedColor);
		menuFontColor.add(fontBlueColor);
		menuFontColor.add(fontBlackColor);
		menuOptions.add(menuFontColor);
		
		menuBar.add(menuOptions);
		menuBar.add(menuHelp);
		
		JMenu menu = new JMenu("PANELE");
		JMenuItem mipanel1 = new JMenuItem("PANEL 1");
		mipanel1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)menuBar.getLayout();
				cl.show(menuBar, "panel1");
				
			}
		});
		JMenuItem mipanel2 = new JMenuItem("PANEL 2");
		mipanel2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)menuBar.getLayout();
				cl.show(menuBar, "panel2");
				
			}
		});
		JMenuItem mipanel3 = new JMenuItem("PANEL 3");
		mipanel2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout)menuBar.getLayout();
				cl.show(menuBar, "panel2");
				
			}
		});
		menu.add(mipanel1);
		menu.add(mipanel2);
		menu.add(mipanel3);
		
		

		font12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ten kawalek kodu powoduje, ze czcionke zmieniaja komponenty menu
				final int newFontSize = 25;
				Settings.FONT_SIZE = 25;
				menuOptions.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				menuFontSize.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				font12.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				font14.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				font16.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				menuFontColor.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				mipanel1.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				mipanel2.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				mipanel3.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				fontRedColor.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				fontBlueColor.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				fontBlackColor.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				menuHelp.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				info.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				exit.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				//ten kawalek kodu powoduje ze zmiana czcionki nastepuje dla komponentow w panelach
				panelTabelaSamochod.updateFont(newFontSize);
				panelTabelaKlient.updateFont(newFontSize);
		        //ta linijka powoduje odswiezanie wszystkich komponentow w panelach, czyli zaladowanie nowej wartosci rozmiaru czcionki
		        SwingUtilities.updateComponentTreeUI(menuBar.getRootPane().getParent());
		        //dopasowanie rozmiarow okna do nowych rozmiarow komponentow
		        JFrame frame = (JFrame)menuBar.getRootPane().getParent();//w taki sposob mozesz pobrac referencje do JFrame, w ktorym znajduje sie Twoj panel, potrzebujesz jej do wywolania metody pack()
		        frame.pack();
			}
		});
		font14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ten kawalek kodu powoduje, ze czcionke zmieniaja komponenty menu
				final int newFontSize = 14;
				menuOptions.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				menuFontSize.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				font12.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				font14.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				font16.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				menuFontColor.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				mipanel1.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				mipanel2.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				mipanel3.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				fontRedColor.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				fontBlueColor.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				fontBlackColor.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				menuHelp.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				info.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				exit.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				//ten kawalek kodu powoduje ze zmiana czcionki nastepuje dla komponentow w panelach
				panelTabelaSamochod.updateFont(newFontSize);
				panelTabelaKlient.updateFont(newFontSize);
				panelDodawanieKlient.updateFont(newFontSize);
		        //ta linijka powoduje odswiezanie wszystkich komponentow w panelach, czyli zaladowanie nowej wartosci rozmiaru czcionki
		        SwingUtilities.updateComponentTreeUI(menuBar.getRootPane().getParent());
		        //dopasowanie rozmiarow okna do nowych rozmiarow komponentow
		        JFrame frame = (JFrame)menuBar.getRootPane().getParent();//w taki sposob mozesz pobrac referencje do JFrame, w ktorym znajduje sie Twoj panel, potrzebujesz jej do wywolania metody pack()
		        frame.pack();
			}
		});
		
		font16.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ten kawalek kodu powoduje, ze czcionke zmieniaja komponenty menu
				final int newFontSize = 16;
				menuOptions.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				menuFontSize.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				font12.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				font14.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				font16.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				menuFontColor.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				mipanel1.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				mipanel2.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				mipanel3.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				fontRedColor.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				fontBlueColor.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				fontBlackColor.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				menuHelp.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				info.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				exit.setFont(new Font("Times New Roman", Font.PLAIN, newFontSize));
				//ten kawalek kodu powoduje ze zmiana czcionki nastepuje dla komponentow w panelach
				panelTabelaSamochod.updateFont(newFontSize);
				panelTabelaKlient.updateFont(newFontSize);
		        //ta linijka powoduje odswiezanie wszystkich komponentow w panelach, czyli zaladowanie nowej wartosci rozmiaru czcionki
		        SwingUtilities.updateComponentTreeUI(menuBar.getRootPane().getParent());
		        //dopasowanie rozmiarow okna do nowych rozmiarow komponentow
		        JFrame frame = (JFrame)menuBar.getRootPane().getParent();//w taki sposob mozesz pobrac referencje do JFrame, w ktorym znajduje sie Twoj panel, potrzebujesz jej do wywolania metody pack()
		        frame.pack();
			}
		});
		fontRedColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ten kawalek kodu powoduje, ze czcionke zmieniaja komponenty menu
				final Color newFontColor = Color.RED;
				menuOptions.setForeground(newFontColor);
				menuFontSize.setForeground(newFontColor);
				font12.setForeground(newFontColor);
				font14.setForeground(newFontColor);
				font16.setForeground(newFontColor);
				menuFontColor.setForeground(newFontColor);
				mipanel1.setForeground(newFontColor);
				mipanel2.setForeground(newFontColor);
				mipanel3.setForeground(newFontColor);
				fontRedColor.setForeground(newFontColor);
				fontBlueColor.setForeground(newFontColor);
				fontBlackColor.setForeground(newFontColor);
				menuHelp.setForeground(newFontColor);
				info.setForeground(newFontColor);
				exit.setForeground(newFontColor);
				//ten kawalek kodu powoduje ze zmiana czcionki nastepuje dla komponentow w panelach
				panelTabelaSamochod.updateFontColor(newFontColor);
				panelTabelaKlient.updateFontColor(newFontColor);
		        //ta linijka powoduje odswiezanie wszystkich komponentow w panelach, czyli zaladowanie nowej wartosci rozmiaru czcionki
		        SwingUtilities.updateComponentTreeUI(menuBar.getRootPane().getParent());
		        //dopasowanie rozmiarow okna do nowych rozmiarow komponentow
		        JFrame frame = (JFrame)menuBar.getRootPane().getParent();//w taki sposob mozesz pobrac referencje do JFrame, w ktorym znajduje sie Twoj panel, potrzebujesz jej do wywolania metody pack()
		        frame.pack();
			}
		});
		fontBlueColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ten kawalek kodu powoduje, ze czcionke zmieniaja komponenty menu
				final Color newFontColor = Color.BLUE;
				menuOptions.setForeground(newFontColor);
				menuFontSize.setForeground(newFontColor);
				font12.setForeground(newFontColor);
				font14.setForeground(newFontColor);
				font16.setForeground(newFontColor);
				menuFontColor.setForeground(newFontColor);
				mipanel1.setForeground(newFontColor);
				mipanel2.setForeground(newFontColor);
				mipanel3.setForeground(newFontColor);
				fontRedColor.setForeground(newFontColor);
				fontBlueColor.setForeground(newFontColor);
				fontBlackColor.setForeground(newFontColor);
				menuHelp.setForeground(newFontColor);
				info.setForeground(newFontColor);
				exit.setForeground(newFontColor);
				//ten kawalek kodu powoduje ze zmiana czcionki nastepuje dla komponentow w panelach
				panelTabelaSamochod.updateFontColor(newFontColor);
				panelTabelaKlient.updateFontColor(newFontColor);
		        //ta linijka powoduje odswiezanie wszystkich komponentow w panelach, czyli zaladowanie nowej wartosci rozmiaru czcionki
		        SwingUtilities.updateComponentTreeUI(menuBar.getRootPane().getParent());
		        //dopasowanie rozmiarow okna do nowych rozmiarow komponentow
		        JFrame frame = (JFrame)menuBar.getRootPane().getParent();//w taki sposob mozesz pobrac referencje do JFrame, w ktorym znajduje sie Twoj panel, potrzebujesz jej do wywolania metody pack()
		        frame.pack();
			}
		});
		fontBlackColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//ten kawalek kodu powoduje, ze czcionke zmieniaja komponenty menu
				final Color newFontColor = Color.BLACK;
				menuOptions.setForeground(newFontColor);
				menuFontSize.setForeground(newFontColor);
				font12.setForeground(newFontColor);
				font14.setForeground(newFontColor);
				font16.setForeground(newFontColor);
				menuFontColor.setForeground(newFontColor);
				mipanel1.setForeground(newFontColor);
				mipanel2.setForeground(newFontColor);
				mipanel3.setForeground(newFontColor);
				fontRedColor.setForeground(newFontColor);
				fontBlueColor.setForeground(newFontColor);
				fontBlackColor.setForeground(newFontColor);
				menuHelp.setForeground(newFontColor);
				info.setForeground(newFontColor);
				exit.setForeground(newFontColor);
				//ten kawalek kodu powoduje ze zmiana czcionki nastepuje dla komponentow w panelach
				panelTabelaSamochod.updateFontColor(newFontColor);
				panelTabelaKlient.updateFontColor(newFontColor);
		        //ta linijka powoduje odswiezanie wszystkich komponentow w panelach, czyli zaladowanie nowej wartosci rozmiaru czcionki
		        SwingUtilities.updateComponentTreeUI(menuBar.getRootPane().getParent());
		        //dopasowanie rozmiarow okna do nowych rozmiarow komponentow
		        JFrame frame = (JFrame)menuBar.getRootPane().getParent();//w taki sposob mozesz pobrac referencje do JFrame, w ktorym znajduje sie Twoj panel, potrzebujesz jej do wywolania metody pack()
		        frame.pack();
			}
		});

		return menuBar;
	}
	

			
			
}
