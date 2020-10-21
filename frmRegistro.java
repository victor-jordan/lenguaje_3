/*
* DOCSTRINGS
* ---------------------------------
* Programa JAVA para implementar un
* Formulario de registro simple.
* 
* @author Victor Centurion
* @version 0.1
* @since 2020-10-14
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class frmRegistro {
    public static void main(String[] args) {
        // instanciamos el formulario que creamos
        miFormulario fr = new miFormulario();
    }
}

// Generamos una subclase que hereda de JFrame y que implementa Action Listener
class miFormulario
    extends JFrame
    implements ActionListener {
    // Inicializar los componentes para crear el formulario

    private Container ctnContenedor;
    private JLabel lblTitulo;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblTelefono;
    private JTextField txtTelefono;
    private JLabel lblSexo;
    private JRadioButton rbMasculino;
    private JRadioButton rbFemenino;
    private ButtonGroup bgSexo;
    private JLabel lblFdN;
    private JComboBox<String> cmbDia;
    private JComboBox<String> cmbMes;
    private JComboBox<String> cmbAnho;
    private JCheckBox chbCasado;
    private JButton btnReset;
    private JButton btnEnviar;
    private JLabel lblVisualizar;
    private JTextArea taVisualizar;

    private String dias[] = {
        "1", "2", "3", "4", "5", 
        "6", "7", "8", "9", "10", 
        "11", "12", "13", "14", "15", 
        "16", "17", "18", "19", "20", 
        "21", "22", "23", "24", "25", 
        "26", "27", "28", "29", "30", 
        "31"
    };

    private String meses[] = {
        "1", "2", "3", "4", "5", 
        "6", "7", "8", "9", "10", 
        "11", "12"
    };

    private String anhos [] = {
        "1990", "1991", "1992", "1993",
        "1994", "1995", "1996", "1997",
        "1998", "1999", "2000", "2001",
        "2002", "2003", "2004", "2005"
    };

    public miFormulario(){
        setTitle("Formulario de Registro de Datos");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        ctnContenedor = getContentPane();
        ctnContenedor.setLayout(null);

        lblTitulo = new JLabel("Formulario desde cero");
        lblTitulo.setFont(new Font("Arial", Font.PLAIN, 30));
        lblTitulo.setSize(300, 30);
        lblTitulo.setLocation(300, 30);
        ctnContenedor.add(lblTitulo);

        lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Arial", Font.PLAIN, 20));
        lblNombre.setSize(100, 20);
        lblNombre.setLocation(100, 100);
        ctnContenedor.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 15));
        txtNombre.setSize(190, 20);
        txtNombre.setLocation(200, 100);
        ctnContenedor.add(txtNombre);

        lblTelefono = new JLabel("Telefono");
        lblTelefono.setFont(new Font("Arial", Font.PLAIN, 20));
        lblTelefono.setSize(150, 20);
        lblTelefono.setLocation(100, 150);
        ctnContenedor.add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setFont(new Font("Arial", Font.PLAIN, 15));
        txtTelefono.setSize(150, 20);
        txtTelefono.setLocation(200, 150);
        ctnContenedor.add(txtTelefono);

        lblSexo = new JLabel("Sexo");
        lblSexo.setFont(new Font("Arial", Font.PLAIN, 20));
        lblSexo.setSize(100, 20);
        lblSexo.setLocation(100, 200);
        ctnContenedor.add(lblSexo);

        rbMasculino = new JRadioButton("Masculino");
        rbMasculino.setFont(new Font("Arial", Font.PLAIN, 15));
        rbMasculino.setSize(75, 20);
        rbMasculino.setLocation(200, 200);
        ctnContenedor.add(rbMasculino);

        rbFemenino = new JRadioButton("Femenino");
        rbFemenino.setFont(new Font("Arial", Font.PLAIN, 15));
        rbFemenino.setSize(80, 20);
        rbFemenino.setLocation(275, 200);
        ctnContenedor.add(rbFemenino);

        bgSexo = new ButtonGroup();
        bgSexo.add(rbMasculino);
        bgSexo.add(rbFemenino);

        lblFdN = new JLabel("FdN");
        lblFdN.setFont(new Font("Arial", Font.PLAIN, 20));
        lblFdN.setSize(100, 20);
        lblFdN.setLocation(100, 250);
        ctnContenedor.add(lblFdN);

        cmbDia = new JComboBox<>(dias);
        cmbDia.setFont(new Font("Arial", Font.PLAIN, 15));
        cmbDia.setSize(60, 20);
        cmbDia.setLocation(200, 250);
        ctnContenedor.add(cmbDia);

        cmbMes = new JComboBox<>(meses);
        cmbMes.setFont(new Font("Arial", Font.PLAIN, 15));
        cmbMes.setSize(60, 20);
        cmbMes.setLocation(280, 250);
        ctnContenedor.add(cmbMes);

        cmbAnho = new JComboBox<>(anhos);
        cmbAnho.setFont(new Font("Arial", Font.PLAIN, 15));
        cmbAnho.setSize(60, 20);
        cmbAnho.setLocation(360, 250);
        ctnContenedor.add(cmbAnho);

        chbCasado = new JCheckBox("Casado/a?");
        chbCasado.setFont(new Font("Arial", Font.PLAIN, 15));
        chbCasado.setSize(250, 20);
        chbCasado.setLocation(150, 300);
        ctnContenedor.add(chbCasado);

        btnEnviar = new JButton("Enviar");
        btnEnviar.setFont(new Font("Arial", Font.PLAIN, 15));
        btnEnviar.setSize(100, 20);
        btnEnviar.setLocation(150, 350);
        ctnContenedor.add(btnEnviar);

        btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Arial", Font.PLAIN, 15));
        btnReset.setSize(100, 20);
        btnReset.setLocation(270, 350);
        ctnContenedor.add(btnReset);

        taVisualizar = new JTextArea();
        taVisualizar.setFont(new Font("Arial", Font.PLAIN, 15));
        taVisualizar.setSize(300, 400);
        taVisualizar.setLocation(500, 100);
        taVisualizar.setLineWrap(true);
        taVisualizar.setEditable(false);
        ctnContenedor.add(taVisualizar);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        System.out.println("Accion");
    }
}