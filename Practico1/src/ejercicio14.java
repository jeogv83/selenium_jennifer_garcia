import java.util.Scanner;

public class ejercicio14 {
    public static void main (String args[ ] ){
        //Pedir el ingreso de números hasta que se ingrese un 0
        //Mostrar la suma de ellos.
        Scanner input =  new Scanner(System.in);
        int num = 1;
        int resultado = 0;

        while (num != 0){
            System.out.println("Ingrese un numero: ");
            num = input.nextInt();
            resultado = resultado + num;
        }

        System.out.println("La suma de los números ingresados es: " + resultado);
        System.out.println("El programa ha finalizado ");
    }
}
