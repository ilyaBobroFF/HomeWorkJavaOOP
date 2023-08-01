package controller;

import mathModel.Addition;
import mathModel.Divider;
import mathModel.Multiplicat;
import util.Checknull;
import util.LogerSelf;


public class Controller {
    private double num1;
    private String operation;
    private double num2;

    public Controller (String num1, String operation, String num2){
        this.num1 = Double.parseDouble(num1);
        this.operation = operation;
        this.num2 = Double.parseDouble(num2);
    }

    public double result (){
        double result;
        switch (operation){
            case "+":
                Addition sum = new Addition(num1, num2);
                result = sum.sum();
                LogerSelf loger = new LogerSelf(num1, num2, result);
                loger.sumLog();
                break;
            case "*":
                Multiplicat multiplay = new Multiplicat(num1, num2);
                result = multiplay.multiPlay();
                loger = new LogerSelf(num1, num2, result);
                loger.multyLog();
                break;
            case "/":
                Divider divide = new Divider(num1, num2);
                Checknull checknull = new Checknull(num2);
                if (!checknull.checkNull()) {
                    result = divide.divide();
                    loger = new LogerSelf(num1, num2, result);
                    loger.divideLog();
                }
                else {
                    result = -0D;
                    loger = new LogerSelf(0, 0, 0);
                    loger.errorLog("Деление на 0");

                }
                break;
            default:
                loger = new LogerSelf(0, 0, 0);
                loger.defaultLog();
                throw new IllegalStateException("Unexpected value: " + operation);
        }
        return result;
    }

}
