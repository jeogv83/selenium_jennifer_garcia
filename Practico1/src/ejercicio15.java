import java.util.Scanner;

public class ejercicio15 {
    public static void main (String args[ ] ){
        //Pedir el ingreso de números hasta que se ingrese un 0
        //Mostrar el promedio de ellos.
        Scanner input =  new Scanner(System.in);
        int num = 1;
        int suma = 0;
        int contador = 0;
        int promedio= 0;

        while (num != 0){
            System.out.println("Ingrese un numero: ");
            num = input.nextInt();
            suma = suma + num;
            contador++;
        }

        promedio = suma / contador;
        System.out.println("El promedio es: " + promedio);
        System.out.println("El programa ha finalizado ");
    }
}
