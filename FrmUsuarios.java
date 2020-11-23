package sistemaRegistro;

import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.List;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class FrmUsuarios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblUsuarios;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private boolean insertar = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUsuarios frame = new FrmUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FrmUsuarios() throws SQLException {
		setTitle("Administrar Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(289, 11, 250, 207);
		contentPane.add(scrollPane);
		tblUsuarios = new JTable();
		scrollPane.setViewportView(tblUsuarios);
		mdlLlenarTabla();
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblId.setBounds(10, 2, 96, 27);
		contentPane.add(lblId);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 40, 96, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 65, 96, 14);
		contentPane.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(116, 37, 132, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setToolTipText("hasta 8 caracteres");
		txtPassword.setBounds(116, 62, 133, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(8);
		
		JCheckBox chkbActive = new JCheckBox("Active");
		chkbActive.setBounds(116, 89, 97, 23);
		contentPane.add(chkbActive);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idusuario;
				String username = txtUsername.getText();
				String password = txtPassword.getText();
				int active;
				if(chkbActive.isSelected()) {
					active = 1;
				} else {
					active = 0;
				}
				if (insertar) {
					try {
						mdlInsertar(username,password,active);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					idusuario = Integer.parseInt(lblId.getText());
					try {
						mdlModificar(idusuario,username,password,active);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnAceptar.setBounds(10, 145, 82, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCancelar.setBounds(102, 145, 82, 23);
		contentPane.add(btnCancelar);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mdlResetForm();
			}
		});
		btnReset.setBounds(194, 145, 82, 23);
		contentPane.add(btnReset);
		
		tblUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				lblId.setText(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0).toString());
				txtUsername.setText(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 1).toString());
				txtPassword.setText("secreto");
				if(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 2).toString()=="true") {
					chkbActive.setSelected(true);
				} else {
					chkbActive.setSelected(false);
				}
				insertar = false;
			}
		});
	}
	
	public void mdlLlenarTabla() throws SQLException {
		String ejecutar = "select id,username,active from usuario;";
		DefaultTableModel modelo = IntfBaseDato.retornarLista(ejecutar);
		tblUsuarios.setModel(modelo);
	}
	
	public void mdlInsertar(String username, String password, int active) throws SQLException{
		String ejecutar = "insert into usuario (username, password, active) values ('" + username + "','" + password + "', " + active + ");";
		// (boolean) es un cast, significa que aseguramos el valor retornado como boolean.
		if(IntfBaseDato.Insertar(ejecutar)) {
			JOptionPane.showMessageDialog(null, "Insertado!");
			mdlLlenarTabla();
		} else {
			JOptionPane.showMessageDialog(null, "Ocurrio un problema");
		}
	}
	
	public void mdlModificar(int idusuario, String username, String password, int active) throws SQLException{
		JOptionPane.showMessageDialog(null, "Modificado");
	}
	
	public void mdlResetForm() {
		Container cntTemporal = null;
		cntTemporal = this.getContentPane();
		Component arrayCompTmp[] = cntTemporal.getComponents();
		
		for(int i = 0; i<arrayCompTmp.length; i++) {
			//JOptionPane.showMessageDialog(this, arrayCompTmp[i].getClass()); // can be removed
			insertar = true;
			if(arrayCompTmp[i] instanceof JLabel) {
				JLabel objTemporal = (JLabel) arrayCompTmp[i];
				ArrayList<String> labels = new ArrayList<String>();
				labels.add("Username");
				labels.add("Password");
				if(!labels.contains(objTemporal.getText())) {
					objTemporal.setText("Id");
				}
				// objTemporal.setText("Id");
			}
			if(arrayCompTmp[i] instanceof JTextField) {
			JTextField objTemporal = (JTextField) arrayCompTmp[i];
			objTemporal.setText("");
			}
			if (arrayCompTmp[i] instanceof JCheckBox) {
				JCheckBox objTemporal = (JCheckBox) arrayCompTmp[i];
				objTemporal.setSelected(false);
			}
		}
	}
}
