package com.codegym.task.task36.task3608.model;

public interface Model {

    DataModel getDataModel();

    void loadUsers();
    public void loadDeletedUsers();

    void loadUserById(long userId);

    public void deleteUserById(long id);

    public void changeUserData(String name, long id, int level);

}
