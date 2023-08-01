package mathModel;

import mathModel.abstractOperation.Operation;

public class Multiplicat extends Operation {
    private double num1;
    private double num2;
    public Multiplicat (double num1, double num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    public double multiPlay(){
        return num1 * num2;
    }
}
