public class mostrarNumeros{
	public static void main(String[] args) {
		int numero = 1;

		System.out.print("Con While...\n");
		while (numero<=100){
			System.out.println(numero);
			// numero = numero + 1;
			numero++;
		}

		System.out.print("Con For...\n");
		for(int num=1; num<=100; num++){
			System.out.println(num);
		}
	}
}