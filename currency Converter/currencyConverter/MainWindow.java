package currencyConverter;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.util.ResourceBundle;

public class MainWindow extends JFrame {
	 //$NON-NLS-1$
	//JPanel contentpane;
	private JPanel contentPane;
	private JTextField fieldAmount;
	private ArrayList<Currency> currencies = Currency.init();
	
	/**
	 * Create the mainWindow frame
	 */
	public MainWindow() {
		setTitle("Currency Converter"); //$NON-NLS-1$
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 300);
		setLocationRelativeTo(null);
		setResizable( true );
		
		// Create menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// "File" menu
		JMenu mnFile = new JMenu("file"); //$NON-NLS-1$
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		// "Quit" menu item
		JMenuItem mntmQuit = new JMenuItem("Quit"); //$NON-NLS-1$
		mntmQuit.setMnemonic(KeyEvent.VK_Q);		
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});		
		mnFile.add(mntmQuit);
		
		
		
		
		// Window components
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Label "Convert"
		JLabel lblConvert = new JLabel("convert"); //$NON-NLS-1$
		lblConvert.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConvert.setBounds(0, 14, 450, 150);
		contentPane.add(lblConvert);
		
	
		// ComboBox of the first currency
		final JComboBox<String> comboBoxCountry1 = new JComboBox<String>();
		comboBoxCountry1.setBounds(600, 72, 240, 28);
		populate(comboBoxCountry1, currencies);
		contentPane.add(comboBoxCountry1);
		
		// Label "To"
		JLabel lblTo = new JLabel("To"); //$NON-NLS-1$
		lblTo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTo.setBounds(66, 54, 375, 250);
		contentPane.add(lblTo);
		
		// ComboBox of the second currency
		final JComboBox<String> comboBoxCountry2 = new JComboBox<String>();
		comboBoxCountry2.setBounds(600, 167, 240, 28);
		populate(comboBoxCountry2, currencies);
		contentPane.add(comboBoxCountry2);
		
		// Label "Amount"
		final JLabel lblAmount = new JLabel("Amount"); //$NON-NLS-1$
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setBounds(23, 108, 425, 350);
		contentPane.add(lblAmount);
		
		// Textfield where the user 
		fieldAmount = new JTextField();
		fieldAmount.setText("0.00");
		fieldAmount.setBounds(600, 270, 103, 29);
		contentPane.add(fieldAmount);
		fieldAmount.setColumns(10);
		fieldAmount.setDocument(new JTextFieldLimit(8));
		
	JLabel image = new JLabel();
		
		contentPane.add(image);
		image.setBounds(0,0,2000,1000);
		ImageIcon icon = new ImageIcon("C:\\Users\\Admin\\OneDrive\\Desktop\\1.jpg");
		Image img = icon.getImage();
		Image modifiedimage = img.getScaledInstance(1500,1500,java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(modifiedimage);
		image.setIcon(icon); 
		
     	
		// Label displaying result of conversion
		final JTextField lblResult = new JTextField("");
		lblResult.setHorizontalAlignment(SwingConstants.LEFT);
		lblResult.setBounds(500, 400, 340, 38);
		contentPane.add(lblResult);
		
		
		// Button "Convert"
		JButton btnConvert = new JButton("Convert"); //$NON-NLS-1$
		btnConvert.setBounds(600, 325, 129, 38);
		btnConvert.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	        	String nameCurrency1 = comboBoxCountry1.getSelectedItem().toString();
	        	String nameCurrency2 = comboBoxCountry2.getSelectedItem().toString();
	        	String result;
	        	String formattedPrice;
	        	String formattedAmount; 
	        	Double price;
	        	Double amount = 0.0;
	        	DecimalFormat format = new DecimalFormat("#0.00");
	        	
	        	try {
	        		amount = Double.parseDouble( fieldAmount.getText() ) ;
	        	} catch (NumberFormatException e) {
	        	    e.printStackTrace();
	        	    amount = 0.0;
	        	}
	        	
	        	price = convert(nameCurrency1, nameCurrency2, currencies, amount);
	        	
	        	// Format numbers to avoid "E7" problem
	        	formattedPrice = format.format(price);
	        	formattedAmount = format.format(amount);
	        	
	        	result = formattedAmount + " " + nameCurrency1 + " = " + formattedPrice + " " + nameCurrency2;
	        	lblResult.setText(result);	        	
	        }
	    });		
		contentPane.add(btnConvert);
	}
	
	// Fill comboBox with currencies name
	public static void populate(JComboBox<String> comboBox, ArrayList<Currency> currencies) {
		for (Integer i = 0; i < currencies.size(); i++) {
			comboBox.addItem( currencies.get(i).getName() );
		}		
	}
	
	// Find the short name and the exchange value of the second currency
	public static Double convert(String currency1, String currency2, ArrayList<Currency> currencies, Double amount) {
		String shortNameCurrency2 = null;
		Double exchangeValue;
		Double price = 0.0;
		
		// Find shortname for the second currency
		for (Integer i = 0; i < currencies.size(); i++) {
			if (currencies.get(i).getName() == currency2) {
				shortNameCurrency2 = currencies.get(i).getShortName();
				break;
			}
		}
		
		// Find exchange value and call convert() to calcul the new price
		if (shortNameCurrency2 != null) {
			for (Integer i = 0; i < currencies.size(); i++) {
				if (currencies.get(i).getName() == currency1) {
					exchangeValue = currencies.get(i).getExchangeValues().get(shortNameCurrency2);
					price = Currency.convert(amount, exchangeValue);
					break;
				}
			}
		}
		
		return price;
	}
}