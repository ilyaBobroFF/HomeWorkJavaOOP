package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;

import java.util.List;
import java.util.Scanner;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com;
        boolean exit = false;

        System.out.println("Введите INFO для вывода списка всех команд");
        while (!exit) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            //if (com == Commands.EXIT) return;
            //else userController.finish();
            switch (com) {
                case CREATE:
                    String firstName = prompt("Имя: ");
                    String lastName = prompt("Фамилия: ");
                    String phone = prompt("Номер телефона: ");
                    userController.saveUser(new User(firstName, lastName, phone));
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case LIST:
                    try {
                        List<User> users = userController.readAllUsers();
                        System.out.println(users);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case UPDATE:
                    try {
                        Long userid = Long.parseLong(prompt("Введите идентификатор изменяемого пользователя: "));
                        firstName = prompt("Новое Имя: ");
                        lastName = prompt("Новая Фамилия: ");
                        phone = prompt("Новый Номер телефона: ");
                        User updated = new User(firstName, lastName, phone);
                        userController.updateUser(userid, updated);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case DELETE:
                    try {
                        Long userid = Long.parseLong(prompt("Введите идентификатор удаляемого пользователя: "));
                        userController.deleteUser(userid);
                    } catch (Exception e){
                        throw new RuntimeException(e);
                    }
                    break;
                case INFO:
                    System.out.println("INFO - Вывод списка всех команд\n" +
                            "READ - вывод контакта по ID\n" +
                            "CREATE - создание контакта\n" +
                            "UPDATE - изменение контакта\n" +
                            "LIST - вывод всех контатков\n" +
                            "DELETE - удаление контаткта по ID\n" +
                            "EXIT - завершение работы");
                    break;
                case EXIT:
                    userController.finish();
                    System.out.println("Выполнен выход");
                    exit = true;
                    break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
