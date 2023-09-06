package view;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class Sobre extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private JButton btnNewButton;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Sobre() {
		getContentPane().setBackground(SystemColor.menu);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/about.png")));
		setTitle("Sobre");
		setBounds(100, 100, 500, 400);
		getContentPane().setLayout(null);
		
		JButton btnLogo = new JButton("");
		btnLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogo.setContentAreaFilled(false);
		btnLogo.setIcon(new ImageIcon(Sobre.class.getResource("/img/mit-icon.png")));
		btnLogo.setToolTipText("Licença MIT");
		btnLogo.setBorderPainted(false);
		btnLogo.setBorder(null);
		btnLogo.setBounds(334, 211, 150, 150);
		getContentPane().add(btnLogo);
		
		JLabel lblNewLabel = new JLabel("Autor: João Vitor ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		lblNewLabel.setBounds(22, 299, 135, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sobre a Licença MIT");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(343, 197, 168, 17);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sistema para Gestão de Funilaria");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(122, 36, 217, 43);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Sobre.class.getResource("/img/spray-gun (2).png")));
		lblNewLabel_3.setBounds(27, 158, 130, 130);
		getContentPane().add(lblNewLabel_3);
		
		btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				link("https://github.com/joaovitorp05?tab=repositories");
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(Sobre.class.getResource("/img/1964417_github_logo_media_social_icon.png")));
		btnNewButton.setBounds(250, 274, 89, 76);
		getContentPane().add(btnNewButton);

	}
	private void link(String site) {

        Desktop desktop = Desktop.getDesktop();

        try {

            URI uri = new URI(site);

            desktop.browse(uri);

        } catch (Exception e) {

            System.out.println(e);

        }
    }
}

