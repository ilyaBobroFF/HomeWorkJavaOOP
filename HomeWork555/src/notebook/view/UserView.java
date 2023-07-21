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

        System.out.println("������� INFO ��� ������ ������ ���� ������");
        while (!exit) {
            String command = prompt("������� �������: ");
            com = Commands.valueOf(command);
            //if (com == Commands.EXIT) return;
            //else userController.finish();
            switch (com) {
                case CREATE:
                    String firstName = prompt("���: ");
                    String lastName = prompt("�������: ");
                    String phone = prompt("����� ��������: ");
                    userController.saveUser(new User(firstName, lastName, phone));
                    break;
                case READ:
                    String id = prompt("������������� ������������: ");
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
                        Long userid = Long.parseLong(prompt("������� ������������� ����������� ������������: "));
                        firstName = prompt("����� ���: ");
                        lastName = prompt("����� �������: ");
                        phone = prompt("����� ����� ��������: ");
                        User updated = new User(firstName, lastName, phone);
                        userController.updateUser(userid, updated);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case DELETE:
                    try {
                        Long userid = Long.parseLong(prompt("������� ������������� ���������� ������������: "));
                        userController.deleteUser(userid);
                    } catch (Exception e){
                        throw new RuntimeException(e);
                    }
                    break;
                case INFO:
                    System.out.println("INFO - ����� ������ ���� ������\n" +
                            "READ - ����� �������� �� ID\n" +
                            "CREATE - �������� ��������\n" +
                            "UPDATE - ��������� ��������\n" +
                            "LIST - ����� ���� ���������\n" +
                            "DELETE - �������� ��������� �� ID\n" +
                            "EXIT - ���������� ������");
                    break;
                case EXIT:
                    userController.finish();
                    System.out.println("�������� �����");
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
