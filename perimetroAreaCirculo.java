import java.util.Scanner;
 
public class perimetroAreaCirculo {
     
    // private static Scanner sc;
 
    public static void main(String[] args){
          
        // double radio = leerNumero("Introduce el radio del circulo: ");
        double radio = 7.5;
        double area, perimetro;
        perimetro = 2 * Math.PI * radio;
        area = Math.PI * Math.pow(radio, 2);
        System.out.printf("\nEl perimetro del circulo de radio %.2f es %.2f.", radio, perimetro);
        System.out.printf("\nEl area del circulo de radio %.2f es %.2f.", radio, area);
    }
  
    // private static double leerNumero(String s){
    //     sc = new Scanner(System.in);
    //     System.out.print(s);
    //     return sc.nextDouble();
    // }
}