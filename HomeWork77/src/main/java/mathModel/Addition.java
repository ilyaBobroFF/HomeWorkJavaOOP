package mathModel;

import mathModel.abstractOperation.Operation;

public class Addition extends Operation {
    private double num1;
    private double num2;

    public Addition(double num1, double num2) {
       this.num1 = num1;
       this.num2 = num2;
    }
    public double sum(){
        return num1 + num2;
    }
}
