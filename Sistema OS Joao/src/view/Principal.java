package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;

public class Principal extends JFrame {
	
	DAO dao = new DAO();
	private Connection con;
	@SuppressWarnings("unused")
	private PreparedStatement pst;
	@SuppressWarnings("unused")
	private ResultSet rs;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblStatusz;
	private JPanel panel_1;
	private JLabel lblData;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/paint-spray.png")));
		setTitle("Sistema da Funilaria");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				
				status();
				setarData();
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnUsuarios = new JButton("");
		btnUsuarios.setBorder(null);
		btnUsuarios.setContentAreaFilled(false);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/users.png")));
		btnUsuarios.setToolTipText("Usuários");
		btnUsuarios.setBounds(88, 37, 141, 137);
		contentPane.add(btnUsuarios);

		JButton btnSobre = new JButton("");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setContentAreaFilled(false);
		btnSobre.setIcon(new ImageIcon(Principal.class.getResource("/img/about.png")));
		btnSobre.setToolTipText("Sobre");
		btnSobre.setActionCommand("Sobre");
		btnSobre.setBorder(null);
		btnSobre.setBounds(732, 0, 52, 52);
		contentPane.add(btnSobre);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 255));
		panel.setBounds(622, 377, -623, 52);
		contentPane.add(panel);
								
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 509, 784, 52);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblData = new JLabel("");
		lblData.setBounds(10, 11, 297, 28);
		panel_1.add(lblData);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblData.setForeground(new Color(255, 255, 255));
		
		lblStatusz = new JLabel("");
		lblStatusz.setBounds(736, 0, 48, 48);
		panel_1.add(lblStatusz);
		lblStatusz.setIcon(new ImageIcon(Principal.class.getResource("/img/dboff.png")));
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);
				
			}
		});
		btnNewButton.setToolTipText("Relatórios");
		btnNewButton.setBorder(null);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/img/REPORT 128.png")));
		btnNewButton.setBounds(101, 233, 128, 128);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Servicos servicos = new Servicos();
				servicos.setVisible(true);
				
			}
		});
		btnNewButton_1.setToolTipText("Serviços");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon(Principal.class.getResource("/img/SERVIÇOS.png")));
		btnNewButton_1.setBounds(283, 233, 128, 128);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("Clientes");
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setIcon(new ImageIcon(Principal.class.getResource("/img/USERS 128.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(283, 46, 128, 128);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/logo tela inicial.png")));
		lblNewLabel.setBounds(657, 381, 128, 128);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setToolTipText("Produtos");
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setIcon(new ImageIcon(Principal.class.getResource("/img/produtos.png")));
		btnNewButton_3.setBounds(468, 233, 128, 128);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setToolTipText("Fornecedores");
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setIcon(new ImageIcon(Principal.class.getResource("/img/fornecedores1.png")));
		btnNewButton_4.setBounds(478, 47, 140, 140);
		contentPane.add(btnNewButton_4);

	} 

	private void status() {
		try {
			
			con = dao.conectar();
			if (con == null) {
				
				lblStatusz.setIcon(new ImageIcon(Principal.class.getResource("/Img/dboff.png")));
			} else {
				
				lblStatusz.setIcon(new ImageIcon(Principal.class.getResource("/Img/dbon.png")));
			}
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}
	
	
	private void setarData() {
		Date data = new Date();
		
		DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		
		lblData.setText(formatador.format(data));
	}
}
