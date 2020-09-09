public class operacionesBasicas {
	
	public static int suma(int n1, int n2){
		return n1 + n2;
	}

	public static int resta(int n1, int n2){
		return n1 - n2;
	}	

	public static int multiplicacion(int n1, int n2){
		return n1 * n2;
	}

	public static float division(int n1, int n2){
		return n1 / n2;
	}

	public static void mayor_o_menor(n1, n2){
		
	}

	public static void main(String[] args) {
		// Declaramos e inicializamos las variables
		int numero1 = 5;
		int numero2 = 10;

		// int suma = numero1 + numero2;
		// int resta = numero1 - numero2;
		// int multiplicacion = numero1 * numero2;
		// int division = numero1 / numero2;

		System.out.println("Suma: " + suma(numero1, numero2));
		System.out.println("Resta: " + resta(numero1, numero2));
		System.out.println("Multi: " + multiplicacion(numero1, numero2));
		System.out.println("Div: " + division(numero1, numero2));
	}
}