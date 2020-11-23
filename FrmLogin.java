package sistemaRegistro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;


public class FrmLogin {

	private JFrame ventanaLogin;
	private JTextField txtUsuario;
	private JPasswordField pfClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin window = new FrmLogin();
					window.ventanaLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventanaLogin = new JFrame();
		ventanaLogin.setTitle("Acceso al sistema");
		ventanaLogin.getContentPane().setBackground(new Color(112, 128, 144));
		ventanaLogin.setBounds(100, 100, 354, 205);
		ventanaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaLogin.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblUsuario.setForeground(Color.BLACK);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(21, 11, 83, 30);
		ventanaLogin.getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(255, 255, 224));
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUsuario.setLabelFor(txtUsuario);
		txtUsuario.setBounds(171, 16, 149, 20);
		ventanaLogin.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setHorizontalAlignment(SwingConstants.CENTER);
		lblClave.setForeground(Color.BLACK);
		lblClave.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblClave.setBounds(21, 61, 83, 30);
		ventanaLogin.getContentPane().add(lblClave);
		
		pfClave = new JPasswordField();
		pfClave.setToolTipText("La clave debe tener 8 caracteres");
		pfClave.setBackground(new Color(255, 255, 224));
		lblClave.setLabelFor(pfClave);
		pfClave.setBounds(171, 66, 149, 20);
		ventanaLogin.getContentPane().add(pfClave);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				char[] clave = pfClave.getPassword();
				
				try {
					mdlIngresar(usuario, String.valueOf(clave));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAcceder.setBounds(132, 118, 89, 23);
		ventanaLogin.getContentPane().add(btnAcceder);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaLogin.dispose();
			}
		});
		btnCancelar.setBounds(231, 118, 89, 23);
		ventanaLogin.getContentPane().add(btnCancelar);
	}
	
	public void mdlIngresar(String usuario, String clave) throws SQLException{
		String ejecutar = "select * from usuario where username='" + usuario + "' and password='" + clave + "';";
		// (boolean) es un cast, significa que aseguramos el valor retornado como boolean.
		if((boolean) IntfBaseDato.Login(ejecutar)) {
			JOptionPane.showMessageDialog(null, "Acceso Correcto!");
		} else {
			JOptionPane.showMessageDialog(null, "Usuario o password incorrecto.");
		}
	}
}
