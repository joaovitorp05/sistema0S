package view;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JDialog;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Color;

public class Relatorios extends JDialog {

	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;


	private static final long serialVersionUID = 1L;
	private JButton btnCusto;
	private JButton btnVenda;
	private JButton btnReposicao;
	private JButton btnFornecedores;
	private JButton btnClientes;
	private JButton btnServicos;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios dialog = new Relatorios();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Relatorios() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBackground(new Color(213, 214, 207));
		setTitle("Relatórios");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);

		btnClientes = new JButton("");
		btnClientes.setBorderPainted(false);
		btnClientes.setToolTipText("Clientes");
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setContentAreaFilled(false);
		btnClientes.setBorder(null);
		btnClientes.setIcon(new ImageIcon(Relatorios.class.getResource("/img/USERS 128.png")));
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioClientes();

			}
		});
		btnClientes.setBounds(80, 104, 141, 137);
		getContentPane().add(btnClientes);

		btnServicos = new JButton("");
		btnServicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				servicoCliente();

			}
		});
		btnServicos.setToolTipText("Serviços");
		btnServicos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnServicos.setContentAreaFilled(false);
		btnServicos.setBorder(null);
		btnServicos.setIcon(new ImageIcon(Relatorios.class.getResource("/img/servicess.png")));
		btnServicos.setBounds(280, 104, 141, 137);
		getContentPane().add(btnServicos);
		
		btnReposicao = new JButton("");
		btnReposicao.setToolTipText("Reposição");
		btnReposicao.setContentAreaFilled(false);
		btnReposicao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnReposicao.setBorder(null);
		btnReposicao.setIcon(new ImageIcon(Relatorios.class.getResource("/img/pecas-de-reposicao (1).png")));
		btnReposicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reposicao();
			}
		});
		btnReposicao.setBounds(481, 104, 141, 137);
		getContentPane().add(btnReposicao);
		
		btnVenda = new JButton("");
		btnVenda.setToolTipText("Venda");
		btnVenda.setContentAreaFilled(false);
		btnVenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVenda.setBorder(null);
		btnVenda.setIcon(new ImageIcon(Relatorios.class.getResource("/img/crescimento.png")));
		btnVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VendaPatrimonio ();
			}
		});
		btnVenda.setBounds(80, 284, 141, 137);
		getContentPane().add(btnVenda);
		
		btnCusto = new JButton("");
		btnCusto.setToolTipText("Custo");
		btnCusto.setContentAreaFilled(false);
		btnCusto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCusto.setBorder(null);
		btnCusto.setIcon(new ImageIcon(Relatorios.class.getResource("/img/custo.png")));
		btnCusto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustoPatrimonio();
			}
		});
		btnCusto.setBounds(280, 284, 141, 137);
		getContentPane().add(btnCusto);
		
		btnFornecedores = new JButton("");
		btnFornecedores.setToolTipText("Fornecedores");
		btnFornecedores.setBorder(null);
		btnFornecedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedores.setContentAreaFilled(false);
		btnFornecedores.setIcon(new ImageIcon(Relatorios.class.getResource("/img/entregador.png")));
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedores();
			}
		});
		btnFornecedores.setBounds(481, 297, 141, 137);
		getContentPane().add(btnFornecedores);

	}

	private void relatorioClientes() {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
			document.open();
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			document.add(new Paragraph("Clientes:"));
			document.add(new Paragraph(" "));
			
			String readClientes = "select nome,fone from clientes order by nome";
			try {
				
				con = dao.conectar();
				
				pst = con.prepareStatement(readClientes);
				rs = pst.executeQuery();
				PdfPTable tabela = new PdfPTable(2);
				PdfPCell col1 = new PdfPCell(new Paragraph("Cliente"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				while (rs.next()) {
					
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
				}
				
				document.add(tabela);
				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		document.close();
		
		try {
			Desktop.getDesktop().open(new File("clientes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void servicoCliente() {
		
		Document document = new Document();
		
		document.setPageSize(PageSize.A4.rotate());
	
		try {
			
			PdfWriter.getInstance(document, new FileOutputStream("servicos.pdf"));
			
			document.open();
			
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			
			document.add(new Paragraph("Servicos:"));
			document.add(new Paragraph(" "));
			
			String readServicos = "select servicos.os,servicos.dataOS,servicos.equipamento,servicos.defeito,servicos.valor,clientes.nome from servicos inner join clientes on servicos.idcli = clientes.idcli;";
			try {
				
				con = dao.conectar();
				
				pst = con.prepareStatement(readServicos);
			
				rs = pst.executeQuery();
				
				PdfPTable tabela = new PdfPTable(6); 
				
				PdfPCell col1 = new PdfPCell(new Paragraph("OS"));
				PdfPCell col2 = new PdfPCell(new Paragraph("dataOS"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Veículo"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Peça"));
				PdfPCell col5 = new PdfPCell(new Paragraph("Valor"));
				PdfPCell col6 = new PdfPCell(new Paragraph("Nome"));

				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				tabela.addCell(col6);
				while (rs.next()) {
					
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
					tabela.addCell(rs.getString(6));

				}
				
				document.add(tabela);
				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		document.close();
		
		try {
			Desktop.getDesktop().open(new File("servicos.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void Reposicao() {
		Document document = new Document();
		document.setPageSize(PageSize.A4.rotate());
		
		try {
			
			PdfWriter.getInstance(document, new FileOutputStream("produtos.pdf"));
			
			document.open();
			
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
		
			document.add(new Paragraph("Produtos:"));
			document.add(new Paragraph(""));
			
			String readProdutos = "select codigo as código,produto,date_format(dataval, '%d/%m/%Y') as validade,\n"
					+ "date_format(dataent, '%d/%m/%Y') as entrada,\n" + "estoque, estoquemin as estoque_mínimo \n"
					+ "from produtos where dataval < dataent or estoque < estoquemin";
			try {
				
				con = dao.conectar();
				
				pst = con.prepareStatement(readProdutos);
				
				rs = pst.executeQuery();
			
				PdfPTable tabela = new PdfPTable(6);
			
				PdfPCell col1 = new PdfPCell(new Paragraph("OS"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Validade"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Entrada"));
				PdfPCell col5 = new PdfPCell(new Paragraph("Estoque"));
				PdfPCell col6 = new PdfPCell(new Paragraph("Estoque min"));

				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				tabela.addCell(col6);

				while (rs.next()) {
					
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
					tabela.addCell(rs.getString(6));
				}
				
				document.add(tabela);
				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		document.close();
	
		try {
			Desktop.getDesktop().open(new File("produtos.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void CustoPatrimonio() {
		
		Document document = new Document();
		
		document.setPageSize(PageSize.A4.rotate());
		
		try {
			
			PdfWriter.getInstance(document, new FileOutputStream("patrimonio.pdf"));
			
			document.open();
			
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			
			document.add(new Paragraph("Patrímônio:"));
			document.add(new Paragraph("")); 
			
			String readPatrimonio = "select sum(custo * estoque) as Total from produtos;";
			try {
				
				con = dao.conectar();
				
				pst = con.prepareStatement(readPatrimonio);
			
				rs = pst.executeQuery();
				
				PdfPTable tabela = new PdfPTable(1); 
				
				PdfPCell col1 = new PdfPCell(new Paragraph("Patrímônio"));

				tabela.addCell(col1);

				while (rs.next()) {
					
					tabela.addCell(rs.getString(1));

				}
				
				document.add(tabela);
				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		document.close();
		
		try {
			Desktop.getDesktop().open(new File("patrimonio.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void VendaPatrimonio() {
		
		Document document = new Document();
		
		document.setPageSize(PageSize.A4.rotate());
		
		try {
			
			PdfWriter.getInstance(document, new FileOutputStream("patrimonio.pdf"));
			
			document.open();
			
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			
			document.add(new Paragraph("Patrímônio:"));
			document.add(new Paragraph(""));
			
			String readPatrimonio = "select sum((custo +(custo * lucro)/100) * estoque) as total from produtos;";
			try {
				
				con = dao.conectar();
				
				pst = con.prepareStatement(readPatrimonio);
				
				rs = pst.executeQuery();
				
				PdfPTable tabela = new PdfPTable(1); 
			
				PdfPCell col1 = new PdfPCell(new Paragraph("Patrímônio"));

				tabela.addCell(col1);

				while (rs.next()) {
					
					tabela.addCell(rs.getString(1));

				}
				
				document.add(tabela);
				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		document.close();
		
		try {
			Desktop.getDesktop().open(new File("patrimonio.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private void Fornecedores() {
		
		Document document = new Document();
		
		try {
			
			PdfWriter.getInstance(document, new FileOutputStream("fornecedores.pdf"));
			
			document.open();
			
			Date dataRelatorio = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(formatador.format(dataRelatorio)));
			
			document.add(new Paragraph("Fornecedores:"));
			document.add(new Paragraph(" "));
			
			String readFornecedores = "select razao,fone, cnpj from fornecedores order by razao";
			try {
				
				con = dao.conectar();
				
				pst = con.prepareStatement(readFornecedores);
				
				rs = pst.executeQuery();
				
				PdfPTable tabela = new PdfPTable(3);
				
				PdfPCell col1 = new PdfPCell(new Paragraph("Razão Social"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
				PdfPCell col3 = new PdfPCell(new Paragraph("CNPJ"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				while (rs.next()) {
					
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
				}
				
				document.add(tabela);
				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		document.close();
		
		try {
			Desktop.getDesktop().open(new File("fornecedores.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
