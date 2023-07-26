package notebook.model.data.impl;

import notebook.model.User;
import notebook.model.data.Data;
import notebook.util.mapper.impl.UserMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataFile implements Data<User> {
    private final UserMapper mapper;
    private List<User> userList;
    private String fileName;

    public DataFile(String fileName, List<User> userList){
        this.mapper = new UserMapper();
        this.fileName = fileName;
        this.userList = userList;
    }
    public DataFile(String fileName) {
        this(fileName, new ArrayList<>());
//        this.mapper = new UserMapper();
//        this.fileName = fileName;
//        this.userList = new ArrayList<>();
    }
    @Override
    public List<User> readData() {
        List<User> users = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : lines) {
            users.add(mapper.toOutput(line));
        }
        return users;
    }


    @Override
    public void writeData() {
        List<String> lines = new ArrayList<>();
        for (User item : this.userList){
            lines.add(mapper.toInput(item));
        }
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (String line : lines) {
                // запись всей строки
                writer.write(line);
                // запись по символам
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
