import java.util.Scanner;

public class ingresarNumeros{

	public static void main(String[] args) {
		Scanner consola = new Scanner(System.in);
		int numero = 11;

		while(numero>=10){
			System.out.println("Ingrese un numero:");

			numero = consola.nextInt();

			if(numero<10){
				System.out.println(numero);
			} else if (numero == 13) {
				System.out.println("13 el numero de la suerte.");
			} else if(numero == 14){
				continue;
			} else if(numero == 12){
				break;
			}
		}

		for (int i = 0; i < 10; i++) {
		  if (i == 4) {
		    continue;
		  }
		  System.out.println(i);
		}

		System.out.println("Adios.");
	}
}