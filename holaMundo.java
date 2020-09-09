// public class holaMundo {
//     public static void main (String [] args) {
//         System.out.println("Hola Mundo");
//     }
// }

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Test
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader lector =
        new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Escribe tu nombre: ");
        String nombre = lector.readLine();
        System.out.println("Eres hombre o mujer? ");
        String soy = lector.readLine();
        System.out.println("Hola " + nombre + "!");
        System.out.println("Eres " + soy + ".");
    }
}