import java.io.Console;

public class precioIva{
	public static void main(String[] args) {
		Double precio;
		Double precio_mas_iva;
		Integer iva = 10;
		Console cnsl = null;

		try {
			cnsl = System.console();

			if (cnsl != null){
				System.out.println("Ingresa un precio: ");
				// precio = Convert.ToDouble(cnsl.readLine());
				precio = Double.parseDouble(cnsl.readLine());
				precio_mas_iva = precio + ((precio*iva)/100);
				System.out.println("El precio mas IVA es: " + precio_mas_iva);

			}
		} catch (Exception error) {
			error.printStackTrace();
		}

	}	
}