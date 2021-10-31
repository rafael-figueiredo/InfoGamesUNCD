package br.com.mvc.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.mvc.dao.LeitorDAOConsole;
import br.com.mvc.dao.LeitorDAODesktop;
import br.com.mvc.dao.LeitorDAOGame;
import br.com.mvc.dao.LeitorDAONotebook;
import br.com.mvc.dao.LeitorDAOSmartPhone;
import br.com.mvc.model.LeitorConsole;
import br.com.mvc.model.LeitorDesktop;
import br.com.mvc.model.LeitorGame;
import br.com.mvc.model.LeitorNotebook;
import br.com.mvc.model.LeitorSmartPhone;
import br.com.mvc.util.ConnectionFactory;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;

public class MenuPrincipal extends JFrame {

	protected static final KeyEvent evt = null;
	private Connection conn; // Conecta com o banco de dados
	private PreparedStatement ps; // Permite executar querys
	private ResultSet rs;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panelDesktop;
	private JPanel panelNotebook;
	private JPanel panelConsoles;
	private JPanel panelConsultar;
	private TextArea txtaDados;
	private LeitorConsole leitor;
	private LeitorDAOConsole daoCS;
	private LeitorGame leitor2;
	private LeitorDAOGame daoGM;
	private LeitorSmartPhone leitor3;
	private LeitorDAOSmartPhone daoSP;
	private JLabel lblConsoles;
	private JTextField txtNome4;
	private JTextField txtPlataforma4;
	private JLabel lblFabricante_1;
	private JTextField txtFabricante4;
	private JLabel lblModelo_1;
	private JTextField txtModelo4;
	private JTextField txtGarantia4;
	private JTextField txtQuantidade4;
	private JLabel lblCadastroDeNotebook;
	private JLabel lblCadastroDeSmartphone;
	private JLabel lblGames;
	private JFormattedTextField ftxtCod;
	private JFormattedTextField ftxtCod2;
	private JFormattedTextField ftxtCod3;
	private JFormattedTextField ftxtCod4;
	private JLabel lblCod;
	private JButton btnConsultar;
	private JFormattedTextField ftxtCod5;
	private JFormattedTextField ftxtCod6;
	private JTextField txtNome5;
	private JTextField txtPlataforma5;
	private JLabel lblGarantia5;
	private JTextField txtGarantia5;
	private JLabel lblQuantidade5;
	private JTextField txtQuantidade5;
	private JLabel lblValor6;
	private JButton btnExcluir;
	private JButton btnLimpar5;
	private JTextField txtPreco4;
	private JTextField txtPreco5;
	private JTextField txtPreco1;
	private JTextField txtQuantidade1;
	private JButton btnSalvar1;
	private LeitorDesktop desktop;
	private LeitorDAODesktop daoDK;
	private LeitorNotebook notebook;
	private LeitorDAONotebook daoNK;
	private JButton btnLimpar1;
	private JTextField txtQuantidade3;
	private JTextField txtPreco3;
	private JTextField txtMarca2;
	private JTextField txtProce;
	private JTextField txtTela;
	private JTextField txtEstoque;
	private JTextField txtArmaze;
	private JTextField txtPreco;
	private JComboBox cmbMeRam;
	private JComboBox cmbSo2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setResizable(false);
		setFont(new Font("Segoe UI", Font.BOLD, 14));
		setTitle("InfoGamesUNCD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 569, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(25, 25, 112));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 21, 525, 389);
		contentPane.add(tabbedPane);

		panelDesktop = new JPanel();
		panelDesktop.setBackground(new Color(100, 149, 237));
		tabbedPane.addTab("Desktops", null, panelDesktop, null);
		panelDesktop.setLayout(null);
		
		lblConsoles = new JLabel("Cadastro de Desktops");
		lblConsoles.setForeground(new Color(255, 215, 0));
		lblConsoles.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblConsoles.setBounds(169, 30, 184, 20);
		panelDesktop.add(lblConsoles);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setForeground(new Color(255, 215, 0));
		lblCdigo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCdigo.setBounds(10, 78, 60, 19);
		panelDesktop.add(lblCdigo);
		
		ftxtCod = new JFormattedTextField();
		ftxtCod.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ftxtCod.setBounds(67, 79, 66, 20);
		formatarCampo1();
		panelDesktop.add(ftxtCod);
		
		JLabel lblModeloGabinete = new JLabel("Modelo Gabinete:");
		lblModeloGabinete.setForeground(new Color(255, 215, 0));
		lblModeloGabinete.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblModeloGabinete.setBounds(143, 78, 120, 19);
		panelDesktop.add(lblModeloGabinete);
		
		JFormattedTextField txtModGabinete = new JFormattedTextField();
		txtModGabinete.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtModGabinete.setBounds(273, 77, 93, 20);
		panelDesktop.add(txtModGabinete);
		
		JComboBox cmbSO = new JComboBox();
		cmbSO.setModel(new DefaultComboBoxModel(new String[] {"Windows", "Linux"}));
		cmbSO.setSelectedIndex(0);
		cmbSO.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbSO.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cmbSO.setBounds(409, 75, 101, 26);
		panelDesktop.add(cmbSO);
		
		JLabel lblSo = new JLabel("SO:");
		lblSo.setForeground(new Color(255, 215, 0));
		lblSo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSo.setBounds(376, 77, 23, 19);
		panelDesktop.add(lblSo);
		
		JLabel lblPlacaDeVdeo = new JLabel("Placa de V\u00EDdeo:");
		lblPlacaDeVdeo.setForeground(new Color(255, 215, 0));
		lblPlacaDeVdeo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPlacaDeVdeo.setBounds(10, 110, 107, 19);
		panelDesktop.add(lblPlacaDeVdeo);
		
		JFormattedTextField txtPlacaVideo = new JFormattedTextField();
		txtPlacaVideo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPlacaVideo.setBounds(121, 110, 168, 20);
		panelDesktop.add(txtPlacaVideo);
		
		JLabel lblMemriaRam = new JLabel("Mem\u00F3ria Ram:");
		lblMemriaRam.setForeground(new Color(255, 215, 0));
		lblMemriaRam.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMemriaRam.setBounds(298, 110, 101, 19);
		panelDesktop.add(lblMemriaRam);
		
		JComboBox cmbRam = new JComboBox();
		cmbRam.setModel(new DefaultComboBoxModel(new String[] {"4GB", "6GB", "8GB", "16GB", "32GB"}));
		cmbRam.setSelectedIndex(0);
		cmbRam.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbRam.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cmbRam.setBounds(409, 110, 101, 26);
		panelDesktop.add(cmbRam);
		
		JLabel lblProcessador = new JLabel("Processador:");
		lblProcessador.setForeground(new Color(255, 215, 0));
		lblProcessador.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblProcessador.setBounds(10, 150, 87, 19);
		panelDesktop.add(lblProcessador);
		
		JFormattedTextField txtProcessador = new JFormattedTextField();
		txtProcessador.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtProcessador.setBounds(102, 150, 161, 20);
		panelDesktop.add(txtProcessador);
		
		JLabel lblModeloCooler = new JLabel("Modelo Cooler:");
		lblModeloCooler.setForeground(new Color(255, 215, 0));
		lblModeloCooler.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblModeloCooler.setBounds(273, 150, 107, 19);
		panelDesktop.add(lblModeloCooler);
		
		JFormattedTextField txtCooler = new JFormattedTextField();
		txtCooler.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCooler.setBounds(382, 150, 128, 20);
		panelDesktop.add(txtCooler);
		
		JLabel lblHd = new JLabel("HD:");
		lblHd.setForeground(new Color(255, 215, 0));
		lblHd.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblHd.setBounds(10, 185, 30, 19);
		panelDesktop.add(lblHd);
		
		JComboBox cmbHD = new JComboBox();
		cmbHD.setModel(new DefaultComboBoxModel(new String[] {"HD", "SSD", "SSD M2"}));
		cmbHD.setSelectedIndex(0);
		cmbHD.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbHD.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cmbHD.setBounds(39, 185, 58, 26);
		panelDesktop.add(cmbHD);
		
		JLabel lblTamanhoHd = new JLabel("Tamanho HD:");
		lblTamanhoHd.setForeground(new Color(255, 215, 0));
		lblTamanhoHd.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTamanhoHd.setBounds(103, 185, 93, 19);
		panelDesktop.add(lblTamanhoHd);
		
		JComboBox cmbTamHD = new JComboBox();
		cmbTamHD.setModel(new DefaultComboBoxModel(new String[] {"120GB", "256GB", "500GB", "1TB", "2TB"}));
		cmbTamHD.setSelectedIndex(0);
		cmbTamHD.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbTamHD.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cmbTamHD.setBounds(201, 185, 72, 26);
		panelDesktop.add(cmbTamHD);
		
		JLabel lblWaterCooler = new JLabel("Water Cooler:");
		lblWaterCooler.setForeground(new Color(255, 215, 0));
		lblWaterCooler.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblWaterCooler.setBounds(278, 185, 107, 19);
		panelDesktop.add(lblWaterCooler);
		
		JComboBox cmbWaterC = new JComboBox();
		cmbWaterC.setModel(new DefaultComboBoxModel(new String[] {"N\u00E3o acompanha", "Acompanha"}));
		cmbWaterC.setSelectedIndex(0);
		cmbWaterC.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbWaterC.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cmbWaterC.setBounds(376, 185, 134, 26);
		panelDesktop.add(cmbWaterC);
		
		JLabel lblTeclado = new JLabel("Teclado:");
		lblTeclado.setForeground(new Color(255, 215, 0));
		lblTeclado.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTeclado.setBounds(10, 225, 87, 19);
		panelDesktop.add(lblTeclado);
		
		JFormattedTextField txtTeclado = new JFormattedTextField();
		txtTeclado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtTeclado.setBounds(95, 225, 194, 20);
		panelDesktop.add(txtTeclado);
		
		JLabel lblMouse = new JLabel("Mouse:");
		lblMouse.setForeground(new Color(255, 215, 0));
		lblMouse.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMouse.setBounds(300, 225, 60, 19);
		panelDesktop.add(lblMouse);
		
		JFormattedTextField txtMouse = new JFormattedTextField();
		txtMouse.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtMouse.setBounds(355, 225, 155, 20);
		panelDesktop.add(txtMouse);
		
		JTextField txtPreco1 = new JTextField();
		txtPreco1.setColumns(10);
		txtPreco1.setBounds(355, 257, 75, 20);
		panelDesktop.add(txtPreco1);
		
		JLabel lblQuantidade1 = new JLabel("Quantidade:");
		lblQuantidade1.setForeground(new Color(255, 215, 0));
		lblQuantidade1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblQuantidade1.setBounds(10, 255, 82, 20);
		panelDesktop.add(lblQuantidade1);
		
		JTextField txtQuantidade1 = new JTextField();
		txtQuantidade1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtQuantidade1.setColumns(10);
		txtQuantidade1.setBounds(95, 255, 50, 20);
		panelDesktop.add(txtQuantidade1);
		
		JLabel lblPreco1 = new JLabel("Preco:");
		lblPreco1.setForeground(new Color(255, 215, 0));
		lblPreco1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPreco1.setBounds(300, 255, 46, 20);
		panelDesktop.add(lblPreco1);
		
		btnSalvar1 = new JButton("");
		btnSalvar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Bot�o salvar Desktop
				try {
					Boolean waterCooler = null;
					if(ftxtCod.getText().equals("") || txtModGabinete.getText().equals("") || txtPlacaVideo.getText().equals("") || txtProcessador.getText().equals("")
							|| txtCooler.getText().equals("") || txtTeclado.getText().equals("") || txtMouse.getText().equals("") || txtQuantidade1.getText().equals("") || txtPreco1.getText().equals("")){
						JOptionPane.showMessageDialog(null, "N�o � poss�vel deixar os campos em branco!");
					} else {
						// Criando objeto destkop para cadastrar o produto
						desktop = new LeitorDesktop();
						desktop.setCod(Integer.parseInt(ftxtCod.getText().trim()));
						desktop.setModeloGabinete(txtModGabinete.getText().trim());
						desktop.setSO((String) cmbSO.getSelectedItem());
						desktop.setPlacaVideo(txtPlacaVideo.getText().trim());
						desktop.setMemoriaRam((String) cmbRam.getSelectedItem());
						desktop.setProcessador(txtProcessador.getText().trim());
						desktop.setModeloCooler(txtCooler.getText().trim());
						desktop.setModeloHD((String) cmbHD.getSelectedItem());
						desktop.setTamanhoHD((String) cmbTamHD.getSelectedItem());
						desktop.setWaterCooler((String) cmbWaterC.getSelectedItem());
						desktop.setTeclado(txtTeclado.getText().trim());
						desktop.setMouse(txtMouse.getText().trim());
						desktop.setQuantidade(Integer.parseInt(txtQuantidade1.getText()));
						desktop.setPreco(Double.parseDouble(txtPreco1.getText()));
						
						// abrindo conex�o
						daoDK = new LeitorDAODesktop();
						
						// salvando os meus atributos no m�todo salvar do DAO
						daoDK.salvar(desktop);
						JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
					} 
				} catch(Exception e3) {
					e3.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
				}
			}
		});
		ImageIcon iconSaveDesktop = new ImageIcon(MenuPrincipal.class.getResource("/imgs/icon2.png"));
		iconSaveDesktop.setImage(iconSaveDesktop.getImage().getScaledInstance(50, 45, 1));
		btnSalvar1.setIcon(iconSaveDesktop);
		btnSalvar1.setToolTipText("Cadastrar Game");
		btnSalvar1.setBounds(160, 285, 75, 47);
		panelDesktop.add(btnSalvar1);
		
		btnLimpar1 = new JButton("");
		btnLimpar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ftxtCod.setText(null);
				txtModGabinete.setText(null);
				cmbSO.setSelectedIndex(0);
				txtPlacaVideo.setText(null);
				cmbRam.setSelectedIndex(0);
				txtProcessador.setText(null);
				txtCooler.setText(null);
				cmbHD.setSelectedIndex(0);
				cmbTamHD.setSelectedIndex(0);
				cmbWaterC.setSelectedIndex(0);
				txtTeclado.setText(null);
				txtMouse.setText(null);
				txtQuantidade1.setText(null);
				txtPreco1.setText(null);
			}
		});
		ImageIcon icon1 = new ImageIcon(MenuPrincipal.class.getResource("/imgs/icon1.png"));
		icon1.setImage(icon1.getImage().getScaledInstance(50, 45, 1));
		btnLimpar1.setIcon(icon1);
		btnLimpar1.setToolTipText("Limpar Campos");
		btnLimpar1.setBounds(256, 285, 75, 47);
		panelDesktop.add(btnLimpar1);

		panelNotebook = new JPanel();
		panelNotebook.setBackground(new Color(100, 149, 237));
		tabbedPane.addTab("Notebooks", null, panelNotebook, null);
		panelNotebook.setLayout(null);
		
		lblCadastroDeNotebook = new JLabel("Cadastro de Notebooks");
		lblCadastroDeNotebook.setForeground(new Color(255, 215, 0));
		lblCadastroDeNotebook.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblCadastroDeNotebook.setBounds(170, 30, 200, 20);
		panelNotebook.add(lblCadastroDeNotebook);
		
		JLabel lblCodigo2 = new JLabel("C\u00F3digo:");
		lblCodigo2.setForeground(Color.ORANGE);
		lblCodigo2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCodigo2.setBounds(10, 87, 63, 20);
		panelNotebook.add(lblCodigo2);
		
		ftxtCod2 = new JFormattedTextField();
		ftxtCod2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ftxtCod2.setBounds(70, 89, 86, 20);
		formatarCampo2();
		panelNotebook.add(ftxtCod2);
		
		JLabel lblMarca2 = new JLabel("Marca:");
		lblMarca2.setForeground(Color.ORANGE);
		lblMarca2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMarca2.setBounds(170, 90, 51, 14);
		panelNotebook.add(lblMarca2);
		
		txtMarca2 = new JTextField();
		txtMarca2.setColumns(10);
		txtMarca2.setBounds(220, 89, 104, 20);
		panelNotebook.add(txtMarca2);
		
		JLabel lblProcessador2 = new JLabel("Processador: ");
		lblProcessador2.setForeground(Color.ORANGE);
		lblProcessador2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblProcessador2.setBounds(332, 90, 97, 14);
		panelNotebook.add(lblProcessador2);
		
		txtProce = new JTextField();
		txtProce.setColumns(10);
		txtProce.setBounds(424, 89, 86, 20);
		panelNotebook.add(txtProce);
		
		JLabel lblTela = new JLabel("Tela:");
		lblTela.setForeground(Color.ORANGE);
		lblTela.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTela.setBounds(10, 136, 46, 14);
		panelNotebook.add(lblTela);
		
		txtTela = new JTextField();
		txtTela.setColumns(10);
		txtTela.setBounds(70, 135, 86, 20);
		panelNotebook.add(txtTela);
		
		JLabel lblMemoriaRam2 = new JLabel("Mem\u00F3ria Ram:");
		lblMemoriaRam2.setForeground(Color.ORANGE);
		lblMemoriaRam2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMemoriaRam2.setBounds(170, 136, 109, 14);
		panelNotebook.add(lblMemoriaRam2);
		
		cmbMeRam = new JComboBox();
		cmbMeRam.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbMeRam.setModel(new DefaultComboBoxModel(new String[] {"4 GB", "6 GB", "8 GB", "16 GB", "32 GB"}));
		cmbMeRam.setBounds(276, 133, 112, 24);
		panelNotebook.add(cmbMeRam);
		
		JLabel lblSO2 = new JLabel("SO:");
		lblSO2.setForeground(Color.ORANGE);
		lblSO2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSO2.setBounds(398, 136, 31, 14);
		panelNotebook.add(lblSO2);
		
		cmbSo2 = new JComboBox();
		cmbSo2.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbSo2.setModel(new DefaultComboBoxModel(new String[] {"Windows", "Linux"}));
		cmbSo2.setBounds(424, 133, 86, 24);
		panelNotebook.add(cmbSo2);
		
		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setForeground(Color.ORANGE);
		lblEstoque.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEstoque.setBounds(10, 183, 75, 14);
		panelNotebook.add(lblEstoque);
		
		txtEstoque = new JTextField();
		txtEstoque.setColumns(10);
		txtEstoque.setBounds(70, 182, 86, 20);
		panelNotebook.add(txtEstoque);
		
		JLabel lblArmazenamento2 = new JLabel("Armazenamento:");
		lblArmazenamento2.setForeground(Color.ORANGE);
		lblArmazenamento2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblArmazenamento2.setBounds(170, 183, 125, 14);
		panelNotebook.add(lblArmazenamento2);
		
		txtArmaze = new JTextField();
		txtArmaze.setColumns(10);
		txtArmaze.setBounds(287, 182, 86, 20);
		panelNotebook.add(txtArmaze);
		
		JLabel lblPreco2 = new JLabel("Pre\u00E7o:");
		lblPreco2.setForeground(Color.ORANGE);
		lblPreco2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPreco2.setBounds(377, 183, 46, 14);
		panelNotebook.add(lblPreco2);
		
		txtPreco = new JTextField();
		txtPreco.setColumns(10);
		txtPreco.setBounds(424, 182, 86, 20);
		panelNotebook.add(txtPreco);
		
		JButton btnSalvar2 = new JButton("");
		btnSalvar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// Bot�o salvar Desktop
			try {
				
				if(ftxtCod2.getText().equals("") || txtMarca2.getText().equals("") || txtProce.getText().equals("") || txtArmaze.getText().equals("")
						|| txtTela.getText().equals("") || txtEstoque.getText().equals("") || txtPreco.getText().equals("")){
					JOptionPane.showMessageDialog(null, "N�o � poss�vel deixar os campos em branco!");
				} else {
						// Criando objeto notebook para cadastrar o produto
						notebook = new LeitorNotebook();
						notebook.setCod(Integer.parseInt(ftxtCod2.getText()));
						notebook.setMarca(txtMarca2.getText());
						notebook.setProcessador(txtProce.getText());
						notebook.setMemoriaRam((String) cmbMeRam.getSelectedItem());
						notebook.setArmazenamento(txtArmaze.getText());
						notebook.setTela(txtTela.getText());
						notebook.setSistema((String) cmbSo2.getSelectedItem());
						notebook.setqtdProduto(Integer.parseInt(txtEstoque.getText()));
						notebook.setPreco(Double.parseDouble(txtPreco.getText()));		
						
						// abrindo conex�o
						daoNK = new LeitorDAONotebook();
						
						// salvando os meus atributos no m�todo salvar do DAO
						daoNK.salvarNotebook(notebook);
						JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
						} 
				} catch(Exception e3) {
					e3.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
					}
				}
		});
		btnSalvar2.setToolTipText("Cadastrar Notebook");
		ImageIcon icon11 = new ImageIcon(MenuPrincipal.class.getResource("/imgs/icon2.png"));
		icon11.setImage(icon11.getImage().getScaledInstance(50, 45, 1));
		btnSalvar2.setIcon(icon11);
		btnSalvar2.setBounds(177, 256, 69, 53);
		panelNotebook.add(btnSalvar2);
		
		JButton btnLimpar2 = new JButton("");
		btnLimpar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ftxtCod2.setText(null);
				txtMarca2.setText(null);
				txtProce.setText(null);
				txtTela.setText(null);
				cmbMeRam.setSelectedIndex(0);
				cmbSo2.setSelectedIndex(0);
				txtEstoque.setText(null);
				txtArmaze.setText(null);
				txtPreco.setText(null);
			}
		});
		btnLimpar2.setToolTipText("Limpar Campos");
		ImageIcon icon12 = new ImageIcon(MenuPrincipal.class.getResource("/imgs/icon1.png"));
		icon12.setImage(icon12.getImage().getScaledInstance(50, 45, 1));
		btnLimpar2.setIcon(icon12);
		btnLimpar2.setBounds(295, 256, 75, 53);
		panelNotebook.add(btnLimpar2);
		
		JPanel panelSmartPhones = new JPanel();
		panelSmartPhones.setBackground(new Color(100, 149, 237));
		tabbedPane.addTab("SmartPhones", null, panelSmartPhones, null);
		panelSmartPhones.setLayout(null);
		
		lblCadastroDeSmartphone = new JLabel("Cadastro de SmartPhones");
		lblCadastroDeSmartphone.setForeground(new Color(255, 215, 0));
		lblCadastroDeSmartphone.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblCadastroDeSmartphone.setBounds(152, 30, 218, 20);
		panelSmartPhones.add(lblCadastroDeSmartphone);
		
		JLabel lblCodSP = new JLabel("C\u00F3digo:");
		lblCodSP.setForeground(new Color(255, 215, 0));
		lblCodSP.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCodSP.setBounds(10, 84, 60, 19);
		panelSmartPhones.add(lblCodSP);
		
		ftxtCod3 = new JFormattedTextField();
		ftxtCod3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ftxtCod3.setBounds(78, 83, 73, 20);
		formatarCampo3();
		panelSmartPhones.add(ftxtCod3);
		
		JLabel lblMarca3 = new JLabel("Marca:");
		lblMarca3.setForeground(new Color(255, 215, 0));
		lblMarca3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMarca3.setBounds(177, 84, 53, 19);
		panelSmartPhones.add(lblMarca3);
		
		JComboBox cmbMarca3 = new JComboBox();
		cmbMarca3.setModel(new DefaultComboBoxModel(new String[] {"Apple", "Asus", "LG", "Motorola", "Nokia", "Positivo", "Samsung", "Xiaomi"}));
		cmbMarca3.setSelectedIndex(0);
		cmbMarca3.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbMarca3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cmbMarca3.setBounds(228, 81, 101, 26);
		panelSmartPhones.add(cmbMarca3);
		
		JLabel lblMemoria3 = new JLabel("Mem\u00F3ria:");
		lblMemoria3.setForeground(new Color(255, 215, 0));
		lblMemoria3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMemoria3.setBounds(344, 84, 71, 19);
		panelSmartPhones.add(lblMemoria3);
		
		JComboBox cmbMemoria3 = new JComboBox();
		cmbMemoria3.setModel(new DefaultComboBoxModel(new String[] {"2 GB", "4 GB", "6 GB", "8 GB"}));
		cmbMemoria3.setSelectedIndex(0);
		cmbMemoria3.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbMemoria3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cmbMemoria3.setBounds(413, 81, 71, 26);
		panelSmartPhones.add(cmbMemoria3);
		
		JLabel lblModelo3 = new JLabel("Modelo:");
		lblModelo3.setForeground(new Color(255, 215, 0));
		lblModelo3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblModelo3.setBounds(10, 129, 60, 19);
		panelSmartPhones.add(lblModelo3);
		
		JFormattedTextField txtModelo3 = new JFormattedTextField();
		txtModelo3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtModelo3.setBounds(78, 128, 179, 20);
		panelSmartPhones.add(txtModelo3);
		
		JLabel lblArmazenamento3 = new JLabel("Armazenamento:");
		lblArmazenamento3.setForeground(new Color(255, 215, 0));
		lblArmazenamento3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblArmazenamento3.setBounds(295, 129, 120, 19);
		panelSmartPhones.add(lblArmazenamento3);
		
		JComboBox cmbArmazenamento3 = new JComboBox();
		cmbArmazenamento3.setModel(new DefaultComboBoxModel(new String[] {"16 GB", "32 GB", "64 GB", "128 GB"}));
		cmbArmazenamento3.setSelectedIndex(0);
		cmbArmazenamento3.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbArmazenamento3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cmbArmazenamento3.setBounds(413, 126, 71, 26);
		panelSmartPhones.add(cmbArmazenamento3);
		
		JLabel lblGarantia3 = new JLabel("Garantia:");
		lblGarantia3.setForeground(new Color(255, 215, 0));
		lblGarantia3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGarantia3.setBounds(10, 176, 71, 19);
		panelSmartPhones.add(lblGarantia3);
		
		JFormattedTextField txtGarantia3 = new JFormattedTextField();
		txtGarantia3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGarantia3.setBounds(81, 175, 115, 20);
		panelSmartPhones.add(txtGarantia3);
		
		JLabel lblVersaoSo3 = new JLabel("Vers\u00E3o S.O.:");
		lblVersaoSo3.setForeground(new Color(255, 215, 0));
		lblVersaoSo3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblVersaoSo3.setBounds(235, 176, 94, 19);
		panelSmartPhones.add(lblVersaoSo3);
		
		JFormattedTextField txtVersaoSo3 = new JFormattedTextField();
		txtVersaoSo3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtVersaoSo3.setBounds(329, 175, 155, 20);
		panelSmartPhones.add(txtVersaoSo3);
		
		JLabel lblQuantidade3 = new JLabel("Quantidade:");
		lblQuantidade3.setForeground(new Color(255, 215, 0));
		lblQuantidade3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblQuantidade3.setBounds(10, 219, 82, 20);
		panelSmartPhones.add(lblQuantidade3);
		
		txtQuantidade3 = new JTextField();
		txtQuantidade3.setColumns(10);
		txtQuantidade3.setBounds(102, 221, 94, 20);
		panelSmartPhones.add(txtQuantidade3);
		
		JLabel lblPreco3 = new JLabel("Preco:");
		lblPreco3.setForeground(new Color(255, 215, 0));
		lblPreco3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPreco3.setBounds(353, 219, 46, 20);
		panelSmartPhones.add(lblPreco3);
		
		txtPreco3 = new JTextField();
		txtPreco3.setColumns(10);
		txtPreco3.setBounds(402, 221, 82, 20);
		panelSmartPhones.add(txtPreco3);
		
		JButton btnSalvar3 = new JButton("");
		btnSalvar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (ftxtCod3.getText().trim().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Campo C�digo Inv�lido!!");
					} else if (txtModelo3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campo Modelo em Branco!!");
					} else if (txtGarantia3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campo Garantia em Branco!!");
					} else if (txtVersaoSo3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campo Vers�o do S.O. em Branco!!");
					} else if (txtQuantidade3.getText().trim().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Campo Quantidade Inv�lido!!");
					} else if (txtPreco3.getText().trim().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Campo Pre�o Inv�lido!!");
					} else {
						// criei o objeto leitor para pegar os dados da tela
						leitor3 = new LeitorSmartPhone();
						leitor3.setCodSP(Integer.parseInt(ftxtCod3.getText()));
						leitor3.setMarca((String) cmbMarca3.getSelectedItem());
						leitor3.setMemoria((String) cmbMemoria3.getSelectedItem());
						leitor3.setModelo(txtModelo3.getText());
						leitor3.setArmazenamento((String) cmbArmazenamento3.getSelectedItem());
						leitor3.setGarantia(txtGarantia3.getText());
						leitor3.setVersaoSo(txtVersaoSo3.getText());
						leitor3.setQuantidade(Integer.parseInt(txtQuantidade3.getText()));
						leitor3.setPreco(Double.parseDouble(txtPreco3.getText()));
						// Abrir a conex�o
						daoSP = new LeitorDAOSmartPhone();
						// Salvar
						daoSP.salvarSmartPhone(leitor3);
						JOptionPane.showMessageDialog(null, "Salvo com Sucesso!!!");
					}
				} catch(Exception e3) {
					e3.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
				}
			}
		});
		btnSalvar3.setToolTipText("Cadastrar SmartPhone");
		ImageIcon icon9 = new ImageIcon(MenuPrincipal.class.getResource("/imgs/icon2.png"));
		icon9.setImage(icon9.getImage().getScaledInstance(50, 45, 1));
		btnSalvar3.setIcon(icon9);
		btnSalvar3.setBounds(169, 272, 75, 47);
		panelSmartPhones.add(btnSalvar3);
		
		JButton btnLimpar3 = new JButton("");
		btnLimpar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ftxtCod3.setText(null);
				cmbMarca3.setSelectedItem("Apple");
				cmbMemoria3.setSelectedItem("2 GB");
				txtModelo3.setText(null);
				cmbArmazenamento3.setSelectedItem("16 GB");
				txtGarantia3.setText(null);
				txtVersaoSo3.setText(null);
				txtQuantidade3.setText(null);
				txtPreco3.setText(null);
			}
		});
		ImageIcon icon10 = new ImageIcon(MenuPrincipal.class.getResource("/imgs/icon1.png"));
		icon10.setImage(icon10.getImage().getScaledInstance(50, 45, 1));
		btnLimpar3.setIcon(icon10);
		btnLimpar3.setToolTipText("Limpar Campos");
		btnLimpar3.setBounds(260, 272, 75, 47);
		panelSmartPhones.add(btnLimpar3);
		
		panelConsoles = new JPanel();
		panelConsoles.setBackground(new Color(100, 149, 237));
		tabbedPane.addTab("Consoles", null, panelConsoles, null);
		panelConsoles.setLayout(null);
				
		JLabel lblConsoles_1 = new JLabel("Cadastro de Consoles");
		lblConsoles_1.setBounds(165, 30, 181, 20);
		lblConsoles_1.setForeground(new Color(255, 215, 0));
		lblConsoles_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panelConsoles.add(lblConsoles_1);
				
		JLabel lblCod4 = new JLabel("Codigo:");
		lblCod4.setForeground(new Color(255, 215, 0));
		lblCod4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCod4.setBounds(13, 94, 60, 16);
		panelConsoles.add(lblCod4);
				
		ftxtCod4 = new JFormattedTextField();
		ftxtCod4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ftxtCod4.setBounds(95, 94, 50, 20);
		formatarCampo4();
		panelConsoles.add(ftxtCod4);
				
		JLabel lblNome4 = new JLabel("Nome:");
		lblNome4.setForeground(new Color(255, 215, 0));
		lblNome4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNome4.setBounds(150, 94, 46, 14);
		panelConsoles.add(lblNome4);
				
		txtNome4 = new JTextField();
		txtNome4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNome4.setColumns(10);
		txtNome4.setBounds(200, 94, 130, 20);
		panelConsoles.add(txtNome4);
				
		JLabel lblPlataforma4 = new JLabel("Plataforma:");
		lblPlataforma4.setForeground(new Color(255, 215, 0));
		lblPlataforma4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPlataforma4.setBounds(336, 94, 82, 14);
		panelConsoles.add(lblPlataforma4);
				
		txtPlataforma4 = new JTextField();
		txtPlataforma4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPlataforma4.setColumns(10);
		txtPlataforma4.setBounds(420, 94, 75, 20);
		panelConsoles.add(txtPlataforma4);
				
		JLabel lblFabricante4 = new JLabel("Fabricante:");
		lblFabricante4.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFabricante4.setForeground(new Color(255, 215, 0));
		lblFabricante4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblFabricante4.setBounds(10, 151, 77, 14);
		panelConsoles.add(lblFabricante4);
				
		txtFabricante4 = new JTextField();
		txtFabricante4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtFabricante4.setColumns(10);
		txtFabricante4.setBounds(95, 150, 205, 20);
		panelConsoles.add(txtFabricante4);
				
		JLabel lblModelo4 = new JLabel("Modelo:");
		lblModelo4.setForeground(new Color(255, 215, 0));
		lblModelo4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblModelo4.setBounds(310, 151, 60, 14);
		panelConsoles.add(lblModelo4);
				
		txtModelo4 = new JTextField();
		txtModelo4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtModelo4.setColumns(10);
		txtModelo4.setBounds(370, 151, 125, 20);
		panelConsoles.add(txtModelo4);
				
		JLabel lblGarantia4 = new JLabel("Garantia:");
		lblGarantia4.setForeground(new Color(255, 215, 0));
		lblGarantia4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGarantia4.setBounds(13, 207, 65, 14);
		panelConsoles.add(lblGarantia4);
				
		txtGarantia4 = new JTextField();
		txtGarantia4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGarantia4.setColumns(10);
		txtGarantia4.setBounds(95, 207, 80, 20);
		panelConsoles.add(txtGarantia4);
				
		JLabel lblQuantidade5 = new JLabel("Quantidade:");
		lblQuantidade5.setForeground(new Color(255, 215, 0));
		lblQuantidade5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblQuantidade5.setBounds(190, 207, 82, 20);
		panelConsoles.add(lblQuantidade5);
				
		txtQuantidade4 = new JTextField();
		txtQuantidade4.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtQuantidade4.setColumns(10);
		txtQuantidade4.setBounds(275, 207, 50, 20);
		panelConsoles.add(txtQuantidade4);
				
		JLabel lblPreco4 = new JLabel("Preco:");
		lblPreco4.setForeground(new Color(255, 215, 0));
		lblPreco4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPreco4.setBounds(370, 207, 46, 20);
		panelConsoles.add(lblPreco4);
		
		// Bot�o Salvar Tela Consoles
		JButton btnSalvar4 = new JButton("");
		btnSalvar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (ftxtCod4.getText().trim().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Campo C�digo Inv�lido!!");
					} else if (txtNome4.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campo Nome em Branco!!");
					} else if (txtPlataforma4.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campo Plataforma em Branco!!");
					} else if (txtFabricante4.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campo Fabricante em Branco!!");
					} else if (txtModelo4.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campo Modelo em Branco!!");
					} else if (txtGarantia4.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campo Garantia em Branco!!");
					} else if (txtQuantidade4.getText().trim().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Campo Quantidade Inv�lido!!");
					} else if (txtPreco4.getText().trim().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Campo Pre�o Inv�lido!!");
					} else {
						// criei o objeto leitor para pegar os dados da tela
						leitor = new LeitorConsole();
						leitor.setCod(Integer.parseInt(ftxtCod4.getText()));
						leitor.setNome(txtNome4.getText());
						leitor.setPlataforma(txtPlataforma4.getText());
						leitor.setFabricante(txtFabricante4.getText());
						leitor.setModelo(txtModelo4.getText());
						leitor.setGarantia(txtGarantia4.getText());
						leitor.setQuantidade(Integer.parseInt(txtQuantidade4.getText()));
						leitor.setPreco(Double.parseDouble(txtPreco4.getText()));
						// Abrir a conex�o
						daoCS = new LeitorDAOConsole();
						// Salvar
						daoCS.salvarConsoles(leitor);
						JOptionPane.showMessageDialog(null, "Salvo com Sucesso!!!");
						}
				} catch(Exception e3) {
					e3.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
				}
			}
		});
		btnSalvar4.setToolTipText("Cadastrar Console");
		ImageIcon icon4 = new ImageIcon(MenuPrincipal.class.getResource("/imgs/icon2.png"));
		icon4.setImage(icon4.getImage().getScaledInstance(50, 45, 1));
		btnSalvar4.setIcon(icon4);
		btnSalvar4.setBounds(175, 260, 75, 47);
		panelConsoles.add(btnSalvar4);
				
		// Bot�o Limpar Tela Consoles
		JButton btnLimpar4 = new JButton("");
		btnLimpar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ftxtCod4.setText(null);
				txtNome4.setText(null);
				txtPlataforma4.setText(null);
				txtFabricante4.setText(null);
				txtModelo4.setText(null);
				txtGarantia4.setText(null);
				txtQuantidade4.setText(null);
				txtPreco4.setText(null);
			}
		});
		btnLimpar4.setToolTipText("Limpar Campos");
		ImageIcon icon5 = new ImageIcon(MenuPrincipal.class.getResource("/imgs/icon1.png"));
		icon5.setImage(icon5.getImage().getScaledInstance(50, 45, 1));
		btnLimpar4.setIcon(icon5);
		btnLimpar4.setBounds(271, 260, 75, 47);
		panelConsoles.add(btnLimpar4);
		
		txtPreco4 = new JTextField();
		txtPreco4.setBounds(420, 209, 75, 20);
		panelConsoles.add(txtPreco4);
		txtPreco4.setColumns(10);
		
		JPanel panelGames = new JPanel();
		panelGames.setBackground(new Color(100, 149, 237));
		tabbedPane.addTab("Games", null, panelGames, null);
		panelGames.setLayout(null);
		
		lblGames = new JLabel("Cadastro de Games");
		lblGames.setForeground(new Color(255, 215, 0));
		lblGames.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblGames.setBounds(175, 30, 170, 20);
		panelGames.add(lblGames);
		
		JLabel lblCod5 = new JLabel("Codigo:");
		lblCod5.setForeground(new Color(255, 215, 0));
		lblCod5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCod5.setBounds(13, 103, 60, 16);
		panelGames.add(lblCod5);
		
		ftxtCod5 = new JFormattedTextField();
		ftxtCod5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		ftxtCod5.setBounds(95, 103, 50, 20);
		formatarCampo5();
		panelGames.add(ftxtCod5);
		
		JLabel lblNome5 = new JLabel("Nome:");
		lblNome5.setForeground(new Color(255, 215, 0));
		lblNome5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNome5.setBounds(155, 103, 46, 16);
		panelGames.add(lblNome5);
		
		txtNome5 = new JTextField();
		txtNome5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNome5.setColumns(10);
		txtNome5.setBounds(205, 103, 130, 20);
		panelGames.add(txtNome5);
		
		JLabel lblPlataforma5 = new JLabel("Plataforma:");
		lblPlataforma5.setForeground(new Color(255, 215, 0));
		lblPlataforma5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPlataforma5.setBounds(345, 103, 82, 16);
		panelGames.add(lblPlataforma5);
		
		txtPlataforma5 = new JTextField();
		txtPlataforma5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPlataforma5.setColumns(10);
		txtPlataforma5.setBounds(430, 103, 80, 20);
		panelGames.add(txtPlataforma5);
		
		lblGarantia5 = new JLabel("Garantia:");
		lblGarantia5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGarantia5.setForeground(new Color(255, 215, 0));
		lblGarantia5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGarantia5.setBounds(10, 160, 63, 14);
		panelGames.add(lblGarantia5);
		
		txtGarantia5 = new JTextField();
		txtGarantia5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtGarantia5.setColumns(10);
		txtGarantia5.setBounds(95, 159, 80, 20);
		panelGames.add(txtGarantia5);
		
		lblQuantidade5 = new JLabel("Quantidade:");
		lblQuantidade5.setForeground(new Color(255, 215, 0));
		lblQuantidade5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblQuantidade5.setBounds(199, 160, 82, 20);
		panelGames.add(lblQuantidade5);
		
		txtQuantidade5 = new JTextField();
		txtQuantidade5.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtQuantidade5.setColumns(10);
		txtQuantidade5.setBounds(284, 160, 50, 20);
		panelGames.add(txtQuantidade5);
		
		JLabel lblPreco5 = new JLabel("Preco:");
		lblPreco5.setForeground(new Color(255, 215, 0));
		lblPreco5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPreco5.setBounds(375, 157, 46, 20);
		panelGames.add(lblPreco5);
		
		// Bot�o Salvar Tela Jogos
		JButton btnSalvar5 = new JButton("");
		btnSalvar5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (ftxtCod5.getText().trim().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Campo C�digo Inv�lido!!");
					} else if (txtNome5.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campo Nome em Branco!!");
					} else if (txtPlataforma5.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campo Plataforma em Branco!!");
					} else if (txtGarantia5.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Campo Garantia em Branco!!");
					} else if (txtQuantidade5.getText().trim().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Campo Quantidade Inv�lido!!");
					} else if (txtPreco5.getText().trim().length() <= 0) {
						JOptionPane.showMessageDialog(null, "Campo Pre�o Inv�lido!!");
					} else {
						// criei o objeto leitor para pegar os dados da tela
						leitor2 = new LeitorGame();
						leitor2.setCod(Integer.parseInt(ftxtCod5.getText()));
						leitor2.setNome(txtNome5.getText());
						leitor2.setPlataforma(txtPlataforma5.getText());
						leitor2.setGarantia(txtGarantia5.getText());
						leitor2.setQuantidade(Integer.parseInt(txtQuantidade5.getText()));
						leitor2.setPreco(Double.parseDouble(txtPreco5.getText()));
						
						// Abrir a conex�o
						daoGM = new LeitorDAOGame();
						
						// Salvar
						daoGM.salvarGames(leitor2);
						JOptionPane.showMessageDialog(null, "Salvo com Sucesso!!!");
					} 
				} catch(Exception e3) {
					e3.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
				}
			}
		});
		btnSalvar5.setToolTipText("Cadastrar Game");
		btnSalvar5.setBounds(175, 260, 75, 47);
		ImageIcon icon6 = new ImageIcon(MenuPrincipal.class.getResource("/imgs/icon2.png"));
		icon6.setImage(icon6.getImage().getScaledInstance(50, 45, 1));
		btnSalvar5.setIcon(icon6);
		btnSalvar5.setBounds(175, 260, 75, 47);
		panelGames.add(btnSalvar5);
		
		// Bot�o Limpar Tela Jogos
		btnLimpar5 = new JButton("");
		btnLimpar5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ftxtCod5.setText(null);
				txtNome5.setText(null);
				txtPlataforma5.setText(null);
				txtGarantia5.setText(null);
				txtQuantidade5.setText(null);
				txtPreco5.setText(null);
			}
		});
		btnLimpar5.setToolTipText("Limpar Campos");
		ImageIcon icon7 = new ImageIcon(MenuPrincipal.class.getResource("/imgs/icon1.png"));
		icon7.setImage(icon7.getImage().getScaledInstance(50, 45, 1));
		btnLimpar5.setIcon(icon7);
		btnLimpar5.setBounds(271, 260, 75, 47);
		panelGames.add(btnLimpar5);
		
		txtPreco5 = new JTextField();
		txtPreco5.setBounds(430, 159, 80, 20);
		panelGames.add(txtPreco5);
		txtPreco5.setColumns(10);
		ImageIcon icon2 = new ImageIcon(MenuPrincipal.class.getResource("/imgs/icon4.png"));
		icon2.setImage(icon2.getImage().getScaledInstance(50, 45, 1));
				
		panelConsultar = new JPanel();
		panelConsultar.setBackground(new Color(100, 149, 237));
		tabbedPane.addTab("Consultar", null, panelConsultar, null);
		panelConsultar.setLayout(null);
			
		txtaDados = new TextArea();
		txtaDados.setBounds(10, 130, 500, 221);
		txtaDados.setFocusable(false);
		txtaDados.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtaDados.setForeground(new Color(0, 0, 0));
		txtaDados.setBackground(new Color(100, 149, 237));
		txtaDados.setEditable(false);
		txtaDados.setFont(new Font("Segoe UI", Font.BOLD, 12));
		panelConsultar.add(txtaDados);
								
		JLabel lblConsultaProdutos = new JLabel("Consulta e Exclus\u00E3o de Produtos");
		lblConsultaProdutos.setForeground(new Color(255, 215, 0));
		lblConsultaProdutos.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblConsultaProdutos.setBounds(125, 30, 283, 17);
		panelConsultar.add(lblConsultaProdutos);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setForeground(new Color(255, 215, 0));
		lblCategoria.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCategoria.setBounds(10, 85, 70, 16);
		panelConsultar.add(lblCategoria);
		
		JComboBox cmbCategoria = new JComboBox();
		cmbCategoria.setFont(new Font("Dialog", Font.PLAIN, 12));
		cmbCategoria.setModel(new DefaultComboBoxModel(new String[] {"Selecione a categoria", "Desktop", "Notebook", "SmartPhones", "Consoles", "Games"}));
		cmbCategoria.setBounds(85, 84, 145, 22);
		panelConsultar.add(cmbCategoria);
								
		JLabel lblCod6 = new JLabel("Codigo:");
		lblCod6.setForeground(new Color(255, 215, 0));
		lblCod6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCod6.setBounds(240, 85, 60, 16);
		panelConsultar.add(lblCod6);
								
		btnConsultar = new JButton("");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ftxtCod6.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe um C�digo Valido para Listar os Dados!");
				}else if(cmbCategoria.getSelectedItem() == "Selecione a categoria") {
					JOptionPane.showMessageDialog(null, "Selecione uma categoria para consultar");
				}
				else if(cmbCategoria.getSelectedItem() == "Desktop"){
					try {
						txtaDados.setText(null);
						conn = ConnectionFactory.getConnection();
						ps = conn.prepareStatement("SELECT * FROM desktop");
						rs = ps.executeQuery();

						try {
							char s = 's';
							while (s == 's') {
								while (rs.next()) {
									int cod = rs.getInt("cod");
									String modeloGabinete = rs.getString("ModeloGabinete");
									String placaVideo = rs.getString("PlacaVideo");
									String memoriaRam = rs.getString("MemoriaRam");
									String processador = rs.getString("Processador");
									String modeloCooler = rs.getString("ModeloCooler");
									String waterCooler = rs.getString("WaterCooler");
									String modeloHD = rs.getString("ModeloHD");
									String tamanhoHD = rs.getString("TamanhoHD");
									String so = rs.getString("SO");
									String teclado = rs.getString("Teclado");
									String mouse = rs.getString("Mouse");
									int quantidade = rs.getInt("Quantidade");
									double preco = rs.getDouble("Preco");

									int cod2 = Integer.parseInt(ftxtCod6.getText());
									if (cod2 == cod) {
										
										conn = ConnectionFactory.getConnection();
										ps = conn.prepareStatement("SELECT * FROM desktop");
										rs = ps.executeQuery();
											while (rs.next()) {
												txtaDados.append("----------------------------------------------------------------------------------------------------------------------");
												txtaDados.append("\nCOD: " + cod);
												txtaDados.append("\tModelo Gabinete: " + modeloGabinete);
												txtaDados.append("\n");
												txtaDados.append("\nPlaca de V�deo: " + placaVideo);
												txtaDados.append("\tMemoria Ram: " + memoriaRam);
												txtaDados.append("\n");
												txtaDados.append("\nProcessador: " + processador);
												txtaDados.append("\n");
												txtaDados.append("\nModelo Cooler: " + modeloCooler);
												txtaDados.append("\tWater Cooler: " + waterCooler);
												txtaDados.append("\n");
												txtaDados.append("\nArmazenamento: " + modeloHD);
												txtaDados.append("\tTamanho: " + tamanhoHD);
												txtaDados.append("\tSO: " + so);
												txtaDados.append("\n");
												txtaDados.append("\nTeclado: " + teclado);
												txtaDados.append("\tMouse: " + mouse);
												txtaDados.append("\n");
												txtaDados.append("\nQuantidade: " + quantidade);
												DecimalFormat df = new DecimalFormat("#.##");
												txtaDados.append("\tPre�o: " + df.format(preco));
												txtaDados.append("\n----------------------------------------------------------------------------------------------------------------------");
											}
									}else {
										JOptionPane.showMessageDialog(null, "Informe um C�digo cadastrado para listar os dados");
									}
								}
								s = 'n';
							}
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Informe um C�digo Valido para Listar os Dados");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao listar os dados");
					}
				} else if(cmbCategoria.getSelectedItem() == "Notebook") {
					try {
						txtaDados.setText(null);
						conn = ConnectionFactory.getConnection();
						ps = conn.prepareStatement("SELECT * FROM notebook");
						rs = ps.executeQuery();
						
						try {
							char s = 's';
							while(s == 's') {
								while(rs.next()) {
									int cod = rs.getInt("cod");
									String marca = rs.getString("marca");
									String processador = rs.getString("processador");
									String memoriaRam = rs.getString("memoriaRam");
									String armazenamento = rs.getString("armazenamento");
									String tela = rs.getString("tela");
									String sistema = rs.getString("sistema");
									int quantidade = rs.getInt("qtdProduto");
									double preco = rs.getDouble("preco");
									
									int cod2 = Integer.parseInt(ftxtCod6.getText());
									if(cod2 == cod) {
										conn = ConnectionFactory.getConnection();
										ps = conn.prepareStatement("SELECT * FROM notebook");
										rs = ps.executeQuery();
											while(rs.next()) {
												txtaDados.append("----------------------------------------------------------------------------------------------------------------------");
												txtaDados.append("\nCOD: " + cod);
												txtaDados.append("\t                                                Marca: " + marca);
												txtaDados.append("\n");
												txtaDados.append("\nProcessador: " + processador);
												txtaDados.append("\tMemoria Ram: " + memoriaRam);
												txtaDados.append("\n");
												txtaDados.append("\nArmazenamento: " + armazenamento);
												txtaDados.append("\tTela: " + tela);
												txtaDados.append("\t        S.O.: " + sistema);
												txtaDados.append("\n");
												txtaDados.append("\nQuantidade: " + quantidade);
												DecimalFormat df = new DecimalFormat("#.##");
												txtaDados.append("\t                                Pre�o: " + df.format(preco));
												txtaDados.append("\n----------------------------------------------------------------------------------------------------------------------");
											}
									}else {
										JOptionPane.showMessageDialog(null, "Informe um C�digo cadastrado para listar os dados");
									}
								}
								s = 'n';
								}
							}catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Informe um C�digo Valido para Listar os Dados");
							}
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao listar os dados");
					}
					
				} else if(cmbCategoria.getSelectedItem() == "SmartPhones") {
					
					try {
						txtaDados.setText(null);
						conn = ConnectionFactory.getConnection();
						ps = conn.prepareStatement("SELECT * FROM smartphones");
						rs = ps.executeQuery();
						
						try {
							char s = 's';
							while(s == 's') {
								while(rs.next()) {
									int cod = rs.getInt("cod");
									String marca = rs.getString("marca");
									String memoria = rs.getString("memoria");
									String modelo = rs.getString("modelo");
									String armazenamento = rs.getString("armazenamento");
									String garantia = rs.getString("garantia");
									String versaoso = rs.getString("versaoSO");
									int quantidade = rs.getInt("quantidade");
									double preco = rs.getDouble("preco");
									
									int cod2 = Integer.parseInt(ftxtCod6.getText());
									if(cod2 == cod) {
										conn = ConnectionFactory.getConnection();
										ps = conn.prepareStatement("SELECT * FROM smartphones");
										rs = ps.executeQuery();
											while(rs.next()) {
												txtaDados.append("----------------------------------------------------------------------------------------------------------------------");
												txtaDados.append("\nCOD: " + cod);
												txtaDados.append("\tMarca: " + marca);
												txtaDados.append("\tMemoria: " + memoria);
												txtaDados.append("\n");
												txtaDados.append("\nModelo: " + modelo);
												txtaDados.append("\tArmazenamento: " + armazenamento);
												txtaDados.append("\n");
												txtaDados.append("\nGarantia: " + garantia);
												txtaDados.append("\t                Vers�o S.O.: " + versaoso);
												txtaDados.append("\n");
												txtaDados.append("\nQuantidade: " + quantidade);
												DecimalFormat df = new DecimalFormat("#.##");
												txtaDados.append("\t                Pre�o: " + df.format(preco));
												txtaDados.append("\n----------------------------------------------------------------------------------------------------------------------");
											}
									}else {
										JOptionPane.showMessageDialog(null, "Informe um C�digo cadastrado para listar os dados");
									}
								}
								s = 'n';
								}
							}catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Informe um C�digo Valido para Listar os Dados");
							}
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao listar os dados");
					}
				}else if(cmbCategoria.getSelectedItem() == "Consoles") {
					try {
						txtaDados.setText(null);
						conn = ConnectionFactory.getConnection();
						ps = conn.prepareStatement("SELECT * FROM consoles");
						rs = ps.executeQuery();

						try {
							char s = 's';
							while (s == 's') {
								while (rs.next()) {
									int cod = rs.getInt("cod");
									String nome = rs.getString("nome");
									String plataforma = rs.getString("plataforma");
									String fabricante = rs.getString("fabricante");
									String modelo = rs.getString("modelo");
									String garantia = rs.getString("garantia");
									int quantidade = rs.getInt("Quantidade");
									double preco = rs.getDouble("Preco");  

									int cod2 = Integer.parseInt(ftxtCod6.getText());
									if (cod2 == cod) {
										
										conn = ConnectionFactory.getConnection();
										ps = conn.prepareStatement("SELECT * FROM consoles");
										rs = ps.executeQuery();
											while (rs.next()) {
												txtaDados.append("----------------------------------------------------------------------------------------------------------------------");
												txtaDados.append("\nCOD: " + cod);
												txtaDados.append("\tNome: " + nome);
												txtaDados.append("\tPlataforma: " + plataforma);
												txtaDados.append("\n");
												txtaDados.append("\nFabricante: " + fabricante);
												txtaDados.append("\tModelo: " + modelo);
												txtaDados.append("\n");
												txtaDados.append("\nGarantia: " + garantia);
												txtaDados.append("\tQuantidade: " + quantidade);
												DecimalFormat df = new DecimalFormat("#.##");
												txtaDados.append("\tPre�o: " + df.format(preco));
												txtaDados.append("\n----------------------------------------------------------------------------------------------------------------------");
											}
									}else {
										JOptionPane.showMessageDialog(null, "Informe um C�digo cadastrado para listar os dados");
									}
								}
								s = 'n';
							}
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Informe um C�digo Valido para Listar os Dados");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao listar os dados");
					}
				}else if(cmbCategoria.getSelectedItem() == "Games") {
					try {
						txtaDados.setText(null);
						conn = ConnectionFactory.getConnection();
						ps = conn.prepareStatement("SELECT * FROM games");
						rs = ps.executeQuery();

						try {
							char s = 's';
							while (s == 's') {
								while (rs.next()) {
									int cod = rs.getInt("cod");
									String nome = rs.getString("nome");
									String plataforma = rs.getString("plataforma");
									String garantia = rs.getString("garantia");
									int quantidade = rs.getInt("Quantidade");
									double preco = rs.getDouble("Preco");  

									int cod2 = Integer.parseInt(ftxtCod6.getText());
									if (cod2 == cod) {
										
										conn = ConnectionFactory.getConnection();
										ps = conn.prepareStatement("SELECT * FROM games");
										rs = ps.executeQuery();
											while (rs.next()) {
												txtaDados.append("----------------------------------------------------------------------------------------------------------------------");
												txtaDados.append("\nCOD: " + cod);
												txtaDados.append("\tNome: " + nome);
												txtaDados.append("\n");
												txtaDados.append("\nPlataforma: " + plataforma);
												txtaDados.append("\n");
												txtaDados.append("\nGarantia: " + garantia);
												txtaDados.append("\n");
												txtaDados.append("\nQuantidade: " + quantidade);
												DecimalFormat df = new DecimalFormat("#.##");
												txtaDados.append("\tPre�o: " + df.format(preco));
												txtaDados.append("\n----------------------------------------------------------------------------------------------------------------------");
											}
									}else {
										JOptionPane.showMessageDialog(null, "Informe um C�digo cadastrado para listar os dados");
									}
								}
								s = 'n';
							}
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Informe um C�digo Valido para Listar os Dados");
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao listar os dados");
					}
				}
			}
		});
		btnConsultar.setToolTipText("Consultar Produto");
		btnConsultar.setIcon(icon2);
		btnConsultar.setBounds(350, 73, 50, 45);
		panelConsultar.add(btnConsultar);
							
		ftxtCod6 = new JFormattedTextField();
		ftxtCod6.setBounds(295, 85, 50, 20);
		panelConsultar.add(ftxtCod6);
								
		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (ftxtCod6.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Informe um C�digo Valido para excluir");
					}else if(cmbCategoria.getSelectedItem() == "Selecione a categoria") {
						JOptionPane.showMessageDialog(null, "Selecione uma categoria para excluir");
					}
					else if(cmbCategoria.getSelectedItem() == "Desktop"){
						try {
							conn = ConnectionFactory.getConnection();
							ps = conn.prepareStatement("SELECT * FROM desktop");
							rs = ps.executeQuery();
							
							try {
								char s = 's';
								while (s == 's') {
									while (rs.next()) {
										int cod = rs.getInt("cod");
										int cod2 = Integer.parseInt(ftxtCod6.getText());
										if (cod2 != cod) {
											JOptionPane.showMessageDialog(null, "Informe um C�digo Cadastrado para Excluir!");
										} else {
											// Abrir a conex�o
											daoDK = new LeitorDAODesktop();
											// Excluir
											int cod3 = Integer.parseInt(ftxtCod6.getText());
											daoDK.excluir(cod3);
											JOptionPane.showMessageDialog(null, "Exclu�do com Sucesso!!!");
										}
									}
									s = 'n';
								}
							}  catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Informe um C�digo Valido para Excluir!");
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Erro ao excluir os dados!");
						}
						
					} else if (cmbCategoria.getSelectedItem() == "Notebook") {
						try {
							conn = ConnectionFactory.getConnection();
							ps = conn.prepareStatement("SELECT * FROM notebook");
							rs = ps.executeQuery();
							
							try {
								char s = 's';
								while (s == 's') {
									while (rs.next()) {
										int cod = rs.getInt("cod");
										int cod2 = Integer.parseInt(ftxtCod6.getText());
										if (cod2 != cod) {
											JOptionPane.showMessageDialog(null, "Informe um C�digo Cadastrado para Excluir!");
										} else {
											// Abrir a conex�o
											daoNK = new LeitorDAONotebook();
											// Excluir
											int cod3 = Integer.parseInt(ftxtCod6.getText());
											daoNK.excluir(cod3);
											JOptionPane.showMessageDialog(null, "Exclu�do com Sucesso!!!");
										}
									}
									s = 'n';
								}
							}  catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Informe um C�digo Valido para Excluir!");
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Erro ao excluir os dados!");
						}
						
					} else if(cmbCategoria.getSelectedItem() == "SmartPhones") {
						try {
							conn = ConnectionFactory.getConnection();
							ps = conn.prepareStatement("SELECT * FROM smartphones");
							rs = ps.executeQuery();
							
							try {
								char s = 's';
								while (s == 's') {
									while (rs.next()) {
										int cod = rs.getInt("cod");
										int cod2 = Integer.parseInt(ftxtCod6.getText());
										if (cod2 != cod) {
											JOptionPane.showMessageDialog(null, "Informe um C�digo Cadastrado para Excluir!");
										}else {
											// Abrir a conex�o
											daoSP = new LeitorDAOSmartPhone();
											//Excluir
											int cod3 = Integer.parseInt(ftxtCod6.getText());
											daoSP.excluir(cod3);
											JOptionPane.showMessageDialog(null, "Exclu�do com Sucesso!!!");
										}
									}
									s = 'n';
								}
							}  catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Informe um C�digo Valido para Excluir!");
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Erro ao excluir os dados!");
						}
				
					} else if(cmbCategoria.getSelectedItem() == "Consoles") {
						try {
							conn = ConnectionFactory.getConnection();
							ps = conn.prepareStatement("SELECT * FROM consoles");
							rs = ps.executeQuery();
							
							try {
								char s = 's';
								while (s == 's') {
									while (rs.next()) {
										int cod = rs.getInt("cod");
										int cod2 = Integer.parseInt(ftxtCod6.getText());
										if (cod2 != cod) {
											JOptionPane.showMessageDialog(null, "Informe um C�digo Cadastrado para Excluir!");
										}else {
											// Abrir a conex�o
											daoCS = new LeitorDAOConsole();
											// Excluir
											int cod3 = Integer.parseInt(ftxtCod6.getText());
											daoCS.excluir(cod3);
											JOptionPane.showMessageDialog(null, "Exclu�do com Sucesso!!!");
										}
									}
									s = 'n';
								}
							}  catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Informe um C�digo Valido para Excluir!");
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Erro ao excluir os dados!");
						}
						
					}else if(cmbCategoria.getSelectedItem() == "Games") {
						try {
							conn = ConnectionFactory.getConnection();
							ps = conn.prepareStatement("SELECT * FROM games");
							rs = ps.executeQuery();
							
							try {
								char s = 's';
								while (s == 's') {
									while (rs.next()) {
										int cod = rs.getInt("cod");
										int cod2 = Integer.parseInt(ftxtCod6.getText());
										if (cod2 != cod) {
											JOptionPane.showMessageDialog(null, "Informe um C�digo Cadastrado para Excluir!");
										}else {
											// Abrir a conex�o
											daoGM = new LeitorDAOGame();
											// Excluir
											int cod3 = Integer.parseInt(ftxtCod6.getText());
											daoGM.excluir(cod3);
											JOptionPane.showMessageDialog(null, "Exclu�do com Sucesso!!!");
										}
									}
									s = 'n';
								}
							}  catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Informe um C�digo Valido para Excluir!");
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Erro ao excluir os dados!");
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao Consultar");
				}
			}
		});
		btnExcluir.setToolTipText("Excluir Produto");
		ImageIcon icon3 = new ImageIcon(MenuPrincipal.class.getResource("/imgs/icon5.png"));
		icon3.setImage(icon3.getImage().getScaledInstance(50, 45, 1));
		btnExcluir.setIcon(icon3);
		btnExcluir.setBounds(405, 73, 50, 45);
		panelConsultar.add(btnExcluir);
		
		JButton btnLimpar6 = new JButton("");
		btnLimpar6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbCategoria.setSelectedItem("Selecione a categoria");
				ftxtCod6.setText(null);
				txtaDados.setText(null);
			}
		});
		btnLimpar6.setToolTipText("Limpar Campos");
		ImageIcon icon8 = new ImageIcon(MenuPrincipal.class.getResource("/imgs/icon1.png"));
		icon8.setImage(icon8.getImage().getScaledInstance(50, 45, 1));
		btnLimpar6.setIcon(icon8);
		btnLimpar6.setToolTipText("Limpar Campos");
		btnLimpar6.setBounds(460, 73, 50, 47);
		panelConsultar.add(btnLimpar6);
	}
	
	private void formatarCampo1() {
		try {
			MaskFormatter mask = new MaskFormatter("###");
			mask.install(ftxtCod);
		} catch (ParseException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto", "ERROR", JOptionPane.ERROR);
		}
	}
	
	private void formatarCampo2() {
		try {
			MaskFormatter mask = new MaskFormatter("###");
			mask.install(ftxtCod2);
		} catch (ParseException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto", "ERROR", JOptionPane.ERROR);
		}
	}
	
	private void formatarCampo3() {
		try {
			MaskFormatter mask = new MaskFormatter("###");
			mask.install(ftxtCod3);
		} catch (ParseException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto", "ERROR", JOptionPane.ERROR);
		}
	}

	private void formatarCampo4() {
		try {
			MaskFormatter mask = new MaskFormatter("###");
			mask.install(ftxtCod4);
		} catch (ParseException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto", "ERROR", JOptionPane.ERROR);
		}
	}
	
	private void formatarCampo5() {
		try {
			MaskFormatter mask = new MaskFormatter("###");
			mask.install(ftxtCod5);
		} catch (ParseException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Erro ao formatar campo de texto", "ERROR", JOptionPane.ERROR);
		}
	}
}
