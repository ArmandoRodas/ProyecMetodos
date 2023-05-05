
public class ModelBiseccion {
    
    private double a;
    private double b;
    private String funcion;

    public ModelBiseccion() {
    }
    //CONSTRUCTOR
    public ModelBiseccion(double a, double b, String funcion) {
        this.a = a;
        this.b = b;
        this.funcion = funcion;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
}
