package viewer;
import controller.Controller;
import util.LogerSelf;

import java.util.Scanner;

public class Viewer {
    private String strNum1 = "Введите первое число: ";
    private String strNum2 = "Введите второе число: ";
    private String strOperation = "Введите операцию(+, *, /): ";
    public String strResult = "Результат = ";
    public String strFinish =
            "Для продолжения введите любой символ\n" +
            "Для выхода введите 000: ";

    public void run(){
        boolean work = true;
        while (work){
            String num1 = prompt(strNum1);
            String operation = prompt(strOperation);
            String num2 = prompt(strNum2);
            Controller controller = new Controller(num1, operation, num2);
            System.out.println(strResult+ controller.result());
            String finish = prompt(strFinish);
            if (finish.equals("000")) {
                work = false;
                LogerSelf loger = new LogerSelf(0,0,0);
                loger.finishLog();
            }
        }

    }
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
