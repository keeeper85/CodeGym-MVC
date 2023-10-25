package com.codegym.task.task36.task3608.controller;

import com.codegym.task.task36.task3608.model.Model;
import com.codegym.task.task36.task3608.view.EditUserView;
import com.codegym.task.task36.task3608.view.UsersView;

public class Controller {

    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void onShowAllUsers(){

        model.loadUsers();
        usersView.refresh(model.getDataModel());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        //usersView.fireShowDeletedUsersEvent();
        usersView.refresh(model.getDataModel());
    }


    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getDataModel());
    }

    public void onDeleteUser(long id){
        model.deleteUserById(id);
        usersView.refresh(model.getDataModel());
    }

    public void onChangeUserData(String name, long id, int level){
        model.changeUserData(name, id, level);
        usersView.refresh(model.getDataModel());
    }


    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    
}
