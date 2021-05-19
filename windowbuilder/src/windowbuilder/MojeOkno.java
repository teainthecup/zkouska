package windowbuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class MojeOkno extends JFrame {

	private JPanel contentPane;
	private JTextField jmeno;
	private JTextField prijmeni;
	private ArrayList<Osoba> seznam = new ArrayList<>();
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MojeOkno frame = new MojeOkno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MojeOkno() {
		this.setTitle("Formular");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 775, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel zadejjm = new JLabel("Zadej jméno: ");
		zadejjm.setFont(new Font("Tahoma", Font.PLAIN, 24));
		zadejjm.setBounds(10, 33, 201, 29);
		contentPane.add(zadejjm);
		
		JLabel zadejpr = new JLabel("Zadej prijmeni: ");
		zadejpr.setFont(new Font("Tahoma", Font.PLAIN, 25));
		zadejpr.setBounds(10, 96, 178, 31);
		contentPane.add(zadejpr);
		
		jmeno = new JTextField();
		jmeno.setBounds(231, 33, 131, 30);
		contentPane.add(jmeno);
		jmeno.setColumns(10);
		
		prijmeni = new JTextField();
		prijmeni.setBounds(231, 98, 131, 29);
		contentPane.add(prijmeni);
		prijmeni.setColumns(10);
		
		JButton ulozit = new JButton("Ulozit");
		ulozit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Osoba o = new Osoba(jmeno.getText(), prijmeni.getText());
				seznam.add(o);
				jmeno.setText("");
				prijmeni.setText("");
				
			}
		});
		
		ulozit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		ulozit.setBounds(551, 198, 146, 48);
		contentPane.add(ulozit);
		
		JTextArea vypisJmen = new JTextArea();
		vypisJmen.setBounds(10, 161, 504, 263);
		contentPane.add(vypisJmen);
		vypisJmen.setEditable(false);		//zakaze psani do textu
		
		btnNewButton = new JButton("Vypis");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vypis = "";
				for(Osoba o : seznam) {
					vypis += o.toString()+"\r\n";
				}
				vypisJmen.setText(vypis);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(551, 269, 146, 48);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Nove okno");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DruheOkno okno = new DruheOkno();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.setBounds(551, 338, 146, 48);
		contentPane.add(btnNewButton_1);
	}
}
