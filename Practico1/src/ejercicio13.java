import java.util.Scanner;

public class ejercicio13 {
    public static void main (String args[ ] ){
        //Pedir el ingreso de números hasta que se ingrese un 0
        Scanner input =  new Scanner(System.in);
        int num = 1;

        while (num != 0){
            System.out.println("Ingrese un numero: ");
            num = input.nextInt();
        }

        System.out.println("El programa ha finalizado ");

    }
}
