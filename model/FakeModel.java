package com.codegym.task.task36.task3608.model;

import com.codegym.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model{

    private DataModel dataModel = new DataModel();
    @Override
    public DataModel getDataModel() {
        return dataModel;
    }

    @Override
    public void loadUsers() {
        List<User> lista = new ArrayList<>();
        User user1 = new User("A", 1, 1);
        User user2 = new User("B", 2, 1);
        lista.add(user1);
        lista.add(user2);

        dataModel.setUsers(lista);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }
}
