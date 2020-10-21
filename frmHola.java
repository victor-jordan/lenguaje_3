import javax.swing.*;

public class frmHola{
	public static void main(String[] args) {
		JFrame cuadroEjemplo = new JFrame("Hola Mundo Swing");
		cuadroEjemplo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblSaludo = new JLabel("Hola mundo.");
		cuadroEjemplo.getContentPane().add(lblSaludo);

		cuadroEjemplo.setVisible(true);
	}
}