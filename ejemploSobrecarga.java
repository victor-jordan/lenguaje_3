public class ejemploSobrecarga{

    public static int mostrarSuma(int x, int y){
        return x + y;
    }

    public static double mostrarSuma(double x, double y){
        return x - y;
    }

    public static void main(String[] args) {
        System.out.println(mostrarSuma(5, 8));
        System.out.println(mostrarSuma(5.5, 8.8));
    }
}