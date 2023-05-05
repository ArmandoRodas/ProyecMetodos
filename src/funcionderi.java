
public class funcionderi {

private double xi;
private String funcion;
private String funcionderivada;
private String funcionDderivada;

    public funcionderi() {
    }

    public funcionderi(String funcionderivada, String funcionDderivada, String funcion, double xi) {
        this.funcionderivada = funcionderivada;
        this.funcionDderivada = funcionDderivada;
        this.funcion = funcion;
        this.xi = xi;
    }

    public String getFuncionderivada() {
        return funcionderivada;
    }

    public void setFuncionderivada(String funcionderivada) {
        this.funcionderivada = funcionderivada;
    }

    public String getFuncionDderivada() {
        return funcionDderivada;
    }

    public void setFuncionDderivada(String funcionDderivada) {
        this.funcionDderivada = funcionDderivada;
    }

    public double getXi() {
        return xi;
    }

    public void setXi(double xi) {
        this.xi = xi;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
    
    
    
}
