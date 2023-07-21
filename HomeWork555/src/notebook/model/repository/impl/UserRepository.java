package notebook.model.repository.impl;


import notebook.util.mapper.impl.UserMapper;
import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository implements GBRepository<User, Long> {
    private final UserMapper mapper;
    //private final FileOperation operation;
    private final String fileName;
    private List<User> userList;

    public UserRepository(String fileName) {
        this.mapper = new UserMapper();
        this.fileName = fileName;
        this.userList = upLoad();
    }
    // Выгрузка из файла списка контактов
    @Override
    public List<User> upLoad() {
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
    // Передача текущего списка контактов
    @Override
    public List<User> findAll() {
        return this.userList;
    }
    // Добавление нового контакта в текущий список
    @Override
    public void create(User user) {
        long max = 0L;
        for (User u : upLoad()) {
            long id = u.getId();
            if (max < id){
                max = id;
            }
        }
        long next = max + 1;
        user.setId(next);
        this.userList.add(user);
    }
    // Нахождение конкретного контакта по ID
    @Override
    public User findById(Long id) {
        User ediUser = this.userList.stream()
                .filter(u -> u.getId()
                        .equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("User not found"));
        return ediUser;
    }
    // Изменение конкретного контакта по ID
    @Override
    public void update(Long id, User user) {
        User ediUser = findById(id);
        ediUser.setId(id);
        ediUser.setFirstName(user.getFirstName());
        ediUser.setPhone(user.getPhone());
        ediUser.setLastName(user.getLastName());
    }
    //Удаление конкретного контакта по ID
    @Override
    public boolean delete(Long delId) {
        List <User> newUsers = new ArrayList<>();
        boolean delOk = false;
        for (User item : userList) {
            if (Objects.equals(item.getId(), delId)) delOk = true;
            else newUsers.add(item);
        }
        userList.clear();
        userList = newUsers;
        return delOk;
    }
    //Загрузка текущего списка контактов в файл
    @Override
    public void downLoad(List<User> users){
        List<String> lines = new ArrayList<>();
        for (User item : users){
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
    //Завешение работы и загрузка текущего списка контактов в файл
    public void finish(){
        downLoad(this.userList);
    }

}

