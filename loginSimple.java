import java.util.Scanner;
import java.io.IOException;

public class loginSimple{

    public static boolean probarAcceso(String usuario, String clave){
        String Username = "user";
        String Password = "ps123";
        
        if(usuario.equals(Username) && clave.equals(Password)){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException{
        Integer Intentos = 0;

        do{
            Scanner entrada1 = new Scanner(System.in);
            System.out.println("Ingrese el usuario: ");
            String usuario = entrada1.next();
            Scanner entrada2 = new Scanner(System.in);
            System.out.println("Ingrese la clave: ");
            String clave = entrada2.next();

            if (probarAcceso(usuario, clave)){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("Acceso correcto. Bienvenido/a!");
                Intentos = 0;
                break;
            } else{
                Intentos += 1;
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("Usuario o clave incorrectos");
                System.out.println("El sistema permite 3 intentos.");
                System.out.println("Usted ya probo " + Intentos + " veces.");
                if(Intentos == 3){
                    System.out.println("Adios!");
                }
            }
        } while (Intentos < 3);

    }

}