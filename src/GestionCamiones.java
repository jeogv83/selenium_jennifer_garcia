import java.util.Scanner;

public class GestionCamiones {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        Camion c1 = new Camion();
        c1.setChapa(4444);
        c1.setColor("Negro");
        System.out.println(c1);
        /*System.out.println("La chapa del camion es: " + c1.getChapa());
        System.out.println("El color del camion es: " + c1.getColor());*/

        Camion c2 = new Camion();
        System.out.println(c2);

        Camion c3 = new Camion(123);
        System.out.println(c3);

        Camion c4 = new Camion(9000, "Verde");
        System.out.println(c4);

        System.out.println("Ingrese el color del camion: ");
        String colorCamion = input.nextLine();
        System.out.println("Ingrese la chapa del camion: ");
        int chapaCamion = input.nextInt();

        Camion c5 = new Camion(chapaCamion, colorCamion);
        System.out.println(c5);

        boolean sonIguales = c1.tieneMismoColor(c2);
        if (sonIguales == true){
            System.out.println("Los camiones tienen el mismo color");
        }else{
            System.out.println("Los camiones No tienen el mismo color");
        }
        //c2.tieneMismoColor(c3);

    }

}
