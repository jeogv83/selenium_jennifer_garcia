import java.util.Scanner;

public class ejercicio2 {
    public static void main (String args[ ] ){
        //Pedir el ingreso del nombre y el año de nacimiento. Mostrar el nombre y la edad de la persona.
        Scanner input = new Scanner(System.in);
        int ano = 0;

        System.out.println("Ingrese su nombre: ");
        String nombre = input.nextLine();

        System.out.println("Ingrese su año de nacimiento: ");
        ano = input.nextInt();

        int edad = 2020 - ano;
        System.out.println("Su nombre es " + nombre + " y su edad es " + edad);

        System.out.println("El programa ha finalizado...");
    }
}
