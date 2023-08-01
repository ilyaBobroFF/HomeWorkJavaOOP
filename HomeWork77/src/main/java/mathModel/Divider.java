package mathModel;

import mathModel.abstractOperation.Operation;

public class Divider extends Operation {
    private double num1;
    private double num2;

    public Divider (double num1, double num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    public double divide(){
        return num1 / num2;
    }
}
