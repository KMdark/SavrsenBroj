package Savrseni_brojevi;

import java.awt.EventQueue;

import java.awt.image.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.DropMode;
import javax.swing.JTextArea;

public class Savrsen3 {

	private JFrame frmSavrsenoTrazenje;
	private JTextField textFieldPrviBR;
	private JTextField textFieldDrugiBR;
	private JButton btnTRAZI;
	private JLabel lblREZULTAT;
	private JTextField textFieldREZ;
	private JLabel lblBabSlika;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Savrsen3 window = new Savrsen3();
					window.frmSavrsenoTrazenje.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Savrsen3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSavrsenoTrazenje = new JFrame();
		frmSavrsenoTrazenje.setBounds(300, 300, 400, 300);
		frmSavrsenoTrazenje.setTitle("  Trazenje savrsenog broja");
		frmSavrsenoTrazenje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSavrsenoTrazenje.getContentPane().setLayout(null);
		
		textFieldPrviBR = new JTextField();
		textFieldPrviBR.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPrviBR.setBounds(134, 25, 83, 23);
		frmSavrsenoTrazenje.getContentPane().add(textFieldPrviBR);
		textFieldPrviBR.setColumns(10);
		
		textFieldDrugiBR = new JTextField();
		textFieldDrugiBR.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldDrugiBR.setColumns(10);
		textFieldDrugiBR.setBounds(134, 75, 83, 23);
		frmSavrsenoTrazenje.getContentPane().add(textFieldDrugiBR);
		
		btnTRAZI = new JButton("TRAZI");
		btnTRAZI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x, y, z, s=0, i=1;
				try {
					
					x = Integer.parseInt(textFieldPrviBR.getText());
					y = Integer.parseInt(textFieldDrugiBR.getText());
					
					while (x < 2)	{
						System.out.print("Pogresan unos pocetnog broja, pocetni broj mora biti veci od 1! \nUnesi ponovo pocetni broj: ");
						JOptionPane.showMessageDialog(null, "Pogresan unos pocetnog broja, pocetni broj mora biti veci od 1! \nUnesi ponovo pocetni broj: ");
					}
					
					for (z = x; z <= y; z++) {
						for (i = 1, s = 0; i < z; i++)	{
							if (z % i == 0)	{
								s = s + i;
							}
						}
						if (s == z)	{
							textFieldREZ.setText(Integer.toString(z));
							System.out.println("Savrsen broj je: "+z);
						}
					}
				
					if (s == z)	{
						textFieldREZ.setText(Integer.toString(z));
						System.out.println("Savrsen broj je: "+z);
					}
					
					
					
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Uneseni broj nije validan!");
				}
			}
		});
		btnTRAZI.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTRAZI.setBounds(254, 48, 89, 23);
		frmSavrsenoTrazenje.getContentPane().add(btnTRAZI);
		
		lblREZULTAT = new JLabel("Savrseni brojevi su");
		lblREZULTAT.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblREZULTAT.setBounds(8, 116, 116, 40);
		frmSavrsenoTrazenje.getContentPane().add(lblREZULTAT);
		
		textFieldREZ = new JTextField();
		textFieldREZ.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldREZ.setColumns(10);
		textFieldREZ.setBounds(134, 116, 145, 123);
		frmSavrsenoTrazenje.getContentPane().add(textFieldREZ);
		
		lblBabSlika = new JLabel("babuskaslika");
		Image img = new ImageIcon(this.getClass().getResource("/babuska.png")).getImage();
		lblBabSlika.setIcon(new ImageIcon(img));
		lblBabSlika.setBounds(265, 108, 109, 142);
		frmSavrsenoTrazenje.getContentPane().add(lblBabSlika);
		
		JLabel lblPocetniBroj = new JLabel("Unesi pocetni broj");
		lblPocetniBroj.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPocetniBroj.setBounds(8, 15, 138, 40);
		frmSavrsenoTrazenje.getContentPane().add(lblPocetniBroj);
		
		JLabel lblZavrsniBroj = new JLabel("Unesi zavrsni broj");
		lblZavrsniBroj.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblZavrsniBroj.setBounds(8, 65, 138, 40);
		frmSavrsenoTrazenje.getContentPane().add(lblZavrsniBroj);
	}
}
