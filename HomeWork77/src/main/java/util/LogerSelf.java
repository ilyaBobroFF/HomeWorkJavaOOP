package util;

import controller.Controller;

import java.util.logging.Logger;

public class LogerSelf {
    private double num1;
    private double num2;
    private double result;
    private static final Logger loger = Logger.getLogger(Controller.class.getName());
    public LogerSelf(double num1, double num2, double result){
        this.num1 = num1;
        this.num2 = num2;
        this.result = result;
    }

    public void sumLog(){
        loger.info("Сложение: Число №1 = "+num1 +" Число №2 = "+ num2);
        loger.info("Результат = "+ result);
    }
    public void multyLog(){
        loger.info("Умножение: Число №1 = "+num1 +" Число №2 = "+ num2);

    }
    public void divideLog(){
        loger.info("Деление: Число №1 = "+num1 +" Число №2 = "+ num2);
        loger.info("Результат = "+ result);
    }
    public void defaultLog(){
        loger.info("Неизвестный оператор! " );
    }
    public void finishLog(){
        loger.info("Завершение работы");
    }
    public void errorLog(String text){
        loger.info(text);
    }
}

