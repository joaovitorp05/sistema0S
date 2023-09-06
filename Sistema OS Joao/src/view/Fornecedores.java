package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import model.DAO;
import utils.Validador;

import java.awt.Font;
import java.awt.Toolkit;

public class Fornecedores extends JDialog {
	
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	
	
	
	
	private JTextField txtID;
	private JTextField txtRazao;
	private JTextField txtFone;
	private JTextField txtCNPJ;
	private JTextField txtEndereco;
	private JTextField txtCEP;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	@SuppressWarnings({ "rawtypes", "unused" })
	private JComboBox cboUF;
	@SuppressWarnings("rawtypes")
	private JComboBox cboUF_1;
	private JButton btnLimpar;
	private JButton btnEditar;
	private JButton btnAdicionar;
	private JButton btnExcluir;
	private JScrollPane scrollPane00;
	@SuppressWarnings("rawtypes")
	private JList listarUsuarios;
	private JTextField txtIE;
	private JTextField txtVendedor;
	private JTextField txtFantasia;
	private JTextField txtEmail;
	private JLabel lblNewLabel_13;
	private JTextField txtSite;
	private JLabel lblNewLabel_14;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fornecedores dialog = new Fornecedores();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Fornecedores() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedores.class.getResource("/img/suppliers.png")));
		getContentPane().setBackground(new Color(183, 197, 202));
		setTitle("Fornecedores");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		scrollPane00 = new JScrollPane();
		scrollPane00.setVisible(false);
		scrollPane00.setBounds(55, 112, 214, 29);
		getContentPane().add(scrollPane00);
		
		listarUsuarios = new JList();
		listarUsuarios.setDoubleBuffered(true);
		listarUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarUsuarioLista ();
			}
		});
		scrollPane00.setViewportView(listarUsuarios);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(22, 48, 26, 14);
		getContentPane().add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(58, 45, 53, 20);
		getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtRazao = new JTextField();
		txtRazao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				listarUsuario ();
			}
		});
		txtRazao.setBounds(55, 93, 214, 20);
		getContentPane().add(txtRazao);
		txtRazao.setColumns(10);
		txtRazao.setDocument(new Validador(40));
		
		txtFone = new JTextField();
		txtFone.setBounds(335, 162, 144, 20);
		getContentPane().add(txtFone);
		txtFone.setColumns(10);
		txtFone.setDocument(new Validador(25));
		
		txtCNPJ = new JTextField();
		txtCNPJ.setBounds(88, 211, 165, 20);
		getContentPane().add(txtCNPJ);
		txtCNPJ.setColumns(10);
		txtCNPJ.setDocument(new Validador(15));
		
		
		JLabel lblNewLabel_1 = new JLabel("Razao");
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 95, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fone");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		lblNewLabel_2.setBounds(288, 164, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CNPJ");
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		lblNewLabel_3.setBounds(20, 213, 36, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Endereço");
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 264, 61, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(88, 262, 214, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		txtEndereco.setDocument(new Validador(50));
		
		txtCEP = new JTextField();
		txtCEP.setBounds(381, 262, 144, 20);
		getContentPane().add(txtCEP);
		txtCEP.setColumns(10);
		txtCEP.setDocument(new Validador(10));
		
		JLabel lblNewLabel_5 = new JLabel("CEP");
		lblNewLabel_5.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		lblNewLabel_5.setBounds(335, 264, 36, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Número");
		lblNewLabel_6.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		lblNewLabel_6.setBounds(367, 368, 46, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(426, 366, 86, 20);
		getContentPane().add(txtNumero);
		txtNumero.setColumns(10);
		txtNumero.setDocument(new Validador(7));
		
		JLabel lblNewLabel_7 = new JLabel("Cidade");
		lblNewLabel_7.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		lblNewLabel_7.setBounds(299, 418, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(353, 416, 105, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		txtCidade.setDocument(new Validador(30));
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(119, 416, 109, 20);
		getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);
		txtComplemento.setDocument(new Validador(25));
		
		JLabel lblNewLabel_8 = new JLabel("Complemento");
		lblNewLabel_8.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		lblNewLabel_8.setBounds(35, 418, 76, 14);
		getContentPane().add(lblNewLabel_8);
		
		cboUF_1 = new JComboBox();
		cboUF_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		cboUF_1.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboUF_1.setBounds(266, 364, 54, 22);
		getContentPane().add(cboUF_1);
		
		JButton btnbuscarCep = new JButton("BuscarCEP");
		btnbuscarCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnbuscarCep.setBounds(548, 261, 116, 23);
		getContentPane().add(btnbuscarCep);
		
		JLabel lblNewLabel_9 = new JLabel("Bairro");
		lblNewLabel_9.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		lblNewLabel_9.setBounds(35, 364, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(91, 362, 104, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		txtBairro.setDocument(new Validador(40));
		
		btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBorder(null);
		btnLimpar.setToolTipText("Limpar Campos");
		btnLimpar.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/eraser.png")));
		btnLimpar.setBounds(188, 477, 80, 60);
		getContentPane().add(btnLimpar);
		
		btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarContato();
			}
		});
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setContentAreaFilled(false);
		btnEditar.setBorder(null);
		btnEditar.setToolTipText("Editar Fornecedor");
		btnEditar.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/editar.png")));
		btnEditar.setBounds(299, 477, 80, 60);
		getContentPane().add(btnEditar);
		
		btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setBorder(null);
		btnAdicionar.setToolTipText("Adicionar Fornecedor");
		btnAdicionar.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/add.png")));
		btnAdicionar.setBounds(399, 477, 80, 60);
		getContentPane().add(btnAdicionar);
		
		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirContato();
			}
		});
		btnExcluir.setToolTipText("Excluir Fornecedor");
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorder(null);
		btnExcluir.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/delete 0.png")));
		btnExcluir.setBounds(484, 477, 80, 60);
		getContentPane().add(btnExcluir);
		
		txtIE = new JTextField();
		txtIE.setBounds(76, 315, 119, 20);
		getContentPane().add(txtIE);
		txtIE.setColumns(10);
		txtIE.setDocument(new Validador(20));
		
		txtVendedor = new JTextField();
		txtVendedor.setBounds(329, 315, 145, 20);
		getContentPane().add(txtVendedor);
		txtVendedor.setColumns(10);
		txtVendedor.setDocument(new Validador(30));
		
		JLabel lblNewLabel_10 = new JLabel("IE");
		lblNewLabel_10.setBounds(35, 318, 46, 14);
		getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Vendedor");
		lblNewLabel_11.setBounds(266, 318, 67, 14);
		getContentPane().add(lblNewLabel_11);
		
		txtFantasia = new JTextField();
		txtFantasia.setBounds(354, 116, 125, 20);
		getContentPane().add(txtFantasia);
		txtFantasia.setColumns(10);
		txtFantasia.setDocument(new Validador(35));
		
		JLabel lblNewLabel_12 = new JLabel("Fantasia");
		lblNewLabel_12.setBounds(299, 119, 54, 14);
		getContentPane().add(lblNewLabel_12);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(71, 162, 182, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setDocument(new Validador(30));
		
		lblNewLabel_13 = new JLabel("Email");
		lblNewLabel_13.setBounds(25, 165, 46, 14);
		getContentPane().add(lblNewLabel_13);
		
		txtSite = new JTextField();
		txtSite.setBounds(365, 211, 147, 20);
		getContentPane().add(txtSite);
		txtSite.setColumns(10);
		txtSite.setDocument(new Validador(35));
		
		lblNewLabel_14 = new JLabel("Site");
		lblNewLabel_14.setBounds(307, 214, 46, 14);
		getContentPane().add(lblNewLabel_14);

	}
	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCEP.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboUF_1.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						System.out.println("OK");
						} else {
							JOptionPane.showMessageDialog(null, "CEP não encontrado");
						}
					}
				}
				txtEndereco.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
				System.out.println(e);
		}
	}
	private void excluirContato() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste fornecedor?","Atenção!",
				JOptionPane.YES_NO_OPTION);
		if(confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from fornecedores where idfor=?";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(delete);
				pst.setString(1, txtID.getText());
				pst.executeUpdate();
				limparCampos();
				
				
				JOptionPane.showMessageDialog(null, "Fornecedor excluído");
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null, "Não foi Possível Excluir o Fornecedor!\nHá um Serviço Pendente.");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	private void editarContato() {
		if (txtRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o nome do fornecedor");
			txtRazao.requestFocus();
		} else {
			String update = "update fornecedores set razao=?, fantasia=?, fone=?,vendedor=?, email=?, site=?, cnpj=?, ie=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, uf=? WHERE idfor=?";
			try {
				con = dao.conectar();
				pst = con.prepareStatement(update);
				pst.setString(1, txtRazao.getText());
				pst.setString(2, txtFantasia.getText());
				pst.setString(3, txtFone.getText());
				pst.setString(4, txtVendedor.getText());
				pst.setString(5, txtEmail.getText());
				pst.setString(6, txtSite.getText());
				pst.setString(7, txtCNPJ.getText());
				pst.setString(8, txtIE.getText());
				pst.setString(9, txtCEP.getText());
				pst.setString(10, txtEndereco.getText());
				pst.setString(11, txtNumero.getText());
				pst.setString(12, txtComplemento.getText());
				pst.setString(13, txtBairro.getText());
				pst.setString(14, txtCidade.getText());
				pst.setString(15, cboUF_1.getSelectedItem().toString());
				pst.setString(16, txtID.getText());
				
				pst.executeUpdate();
				
				limparCampos();
				JOptionPane.showMessageDialog(null, "Dados do fornecedor editados com sucesso");
            } catch (java.sql.SQLIntegrityConstraintViolationException e) {
                JOptionPane.showMessageDialog(null, "CNPJ Existente");
                txtCNPJ.setText(null);
                txtCNPJ.requestFocus();
            } catch (Exception e1) {
                System.out.println(e1);
            }
        }
    }


				
	private void limparCampos() {
		txtID.setText(null);
		txtRazao.setText(null);
		txtEndereco.setText(null);
		txtCNPJ.setText(null);
		txtSite.setText(null);
		txtFantasia.setText(null);
		txtCEP.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		txtFone.setText(null);
		txtIE.setText(null);
		txtEmail.setText(null);
		txtVendedor.setText(null);
		cboUF_1.setSelectedItem(null);
	}
	private void adicionarUsuario() {
		
		if (txtRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do fornecedor");
			txtRazao.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o telefone do fornecedor");
			txtFone.requestFocus();
		} else if (txtCNPJ.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CNPJ do fornecedor");
			txtCNPJ.requestFocus();
		} else if (txtCEP.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CEP do fornecedor");
			txtCEP.requestFocus();	
		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a cidade do fornecedor");
			txtCidade.requestFocus();
		} else if (txtNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o número do fornecedor");
			txtNumero.requestFocus();
		} else {
			
			String create = "insert into fornecedores(razao,fantasia,fone,vendedor,email,site,cnpj,ie,cep,endereco,numero,complemento,bairro,cidade,uf) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			try {
				
				con = dao.conectar();
				
				pst = con.prepareStatement(create);
				pst.setString(1, txtRazao.getText());
				pst.setString(2, txtFantasia.getText());
				pst.setString(3, txtFone.getText());
				pst.setString(4, txtVendedor.getText());
				pst.setString(5, txtEmail.getText());
				pst.setString(6, txtSite.getText());
				pst.setString(7, txtCNPJ.getText());
				pst.setString(8, txtIE.getText());
				pst.setString(9, txtCEP.getText());
				pst.setString(10, txtEndereco.getText());
				pst.setString(11, txtNumero.getText());
				pst.setString(12, txtComplemento.getText());
				pst.setString(13, txtBairro.getText());
				pst.setString(14, txtCidade.getText());
				pst.setString(15, cboUF_1.getSelectedItem().toString());
				
				
				
				
				
				
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(null, "Fornecedor adicionado");
				
				limparCampos();
				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}


			
		}
	}
	@SuppressWarnings("unchecked")
	private void listarUsuario() {
		
		DefaultListModel<String> modelo = new DefaultListModel<>();
		
		listarUsuarios.setModel(modelo);
		
		String readlista = "select * from fornecedores where razao like '" + txtRazao.getText() + "%'" + "order by razao";
		try {
			
			con = dao.conectar();
		
			pst = con.prepareStatement(readlista);
			
			rs = pst.executeQuery();
			
			while(rs.next()) {
				
				scrollPane00.setVisible(true);
				
				modelo.addElement(rs.getString(2));
				if (txtRazao.getText().isEmpty()) {
					scrollPane00.setVisible(false);
				}
				
			}
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void buscarUsuarioLista() {
		
		int linha = listarUsuarios.getSelectedIndex();
		if (linha>= 0) {
			
			String readlistaUsuario = "select * from fornecedores where razao like '" + txtRazao.getText() + "%'" + "order by razao limit " + (linha) + " , 1";
			try {
				
				con = dao.conectar();
				
				pst = con.prepareStatement(readlistaUsuario);
				
				rs = pst.executeQuery();
				if (rs.next()) {
					
					scrollPane00.setVisible(false);
					
					txtID.setText(rs.getString(1));
                    txtRazao.setText(rs.getString(2));
                    txtFantasia.setText(rs.getString(3));
                    txtFone.setText(rs.getString(4));
                    txtVendedor.setText(rs.getString(5));
                    txtEmail.setText(rs.getString(6));
                    txtSite.setText(rs.getString(7));
                    txtCNPJ.setText(rs.getString(8));
                    txtIE.setText(rs.getString(9));
                    txtCEP.setText(rs.getString(10));
                    txtEndereco.setText(rs.getString(11));
                    txtNumero.setText(rs.getString(12));
                    txtComplemento.setText(rs.getString(13));
                    txtBairro.setText(rs.getString(14));   
                    txtCidade.setText(rs.getString(15));
                    cboUF_1.setSelectedItem(rs.getString(16));
									
				} else {
					JOptionPane.showMessageDialog(null, "Fornecedor inexistente");
					
				}
				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			
			scrollPane00.setVisible(false);
			
			
		}
	}
}
