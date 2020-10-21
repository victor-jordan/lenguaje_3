public class ejemploObjeto{
    // Los atributos
    int x;
    int y;

    // Si queremos valores por defecto, tenemos que habilitar
    // un constructor de la clase.
    ejemploObjeto(){
        x = 5;
        y = 8;
    }

    ejemploObjeto(int a, int b){
        x = b;
        y = a;
    }

    public void mostrarPuntos(){
        // ejemploObjeto es la clase, modelo de datos
        // instanciamos un objeto del tipo ejemploObjeto
        // ejemploObjeto objPuntos = new ejemploObjeto();
        // objPuntos.x = 10;
        // objPuntos.y = 13;
        System.out.println(this.x);
        System.out.println(this.y);
    }


    public static void main(String[] args) {
        // Metodo principal
        // mostrarPuntos();
        ejemploObjeto otrObjeto = new ejemploObjeto(4, 6);
        otrObjeto.mostrarPuntos();
    }
}