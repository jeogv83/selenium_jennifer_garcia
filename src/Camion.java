public class Camion {

    //atributos
    private int chapa;
    private String color;

    //constructor sin parametro
    public Camion(){
        this.color = "rojo";
        this.chapa = 1234;
    }

    //constructor con un oarametro
    public Camion (int unaChapa){
        this.color = "Desconocido";
        this.chapa = unaChapa;
    }

    //constructor con 2 parametros
    public Camion (int unaChapa, String unColor){
        this.color = unColor;
        this.chapa = unaChapa;
    }

    //metodos de acceso y modificacion
    public int getChapa(){
        return this.chapa;
    }

    public void setChapa(int unaChapa) {
        this.chapa = unaChapa;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String unColor){
        this.color = unColor;
    }

    //comparar si dos camiones tienen el mismo color
    public boolean tieneMismoColor (Camion otroCamion){
        return this.getColor().equals(otroCamion.getColor());
    }

    public String toString(){
        return "Camion de color: " + this.getColor() + " con una chapa: " + this.getChapa();
    }
}
