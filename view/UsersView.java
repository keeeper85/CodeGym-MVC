package com.codegym.task.task36.task3608.view;

import com.codegym.task.task36.task3608.bean.User;
import com.codegym.task.task36.task3608.controller.Controller;
import com.codegym.task.task36.task3608.model.DataModel;

public class UsersView implements View{

    private Controller controller;

    @Override
    public void refresh(DataModel dataModel) {

        if (!dataModel.isDisplayDeletedUserList()){
            System.out.println("All users:");

            for (User values : dataModel.getUsers()){
                String text = String.format("User{name='%s', id=%d, level=%d}", values.getName(), values.getId(), values.getLevel());
                System.out.println("\t" + text);
            }

            System.out.println("===================================================");
        }
        else {
            System.out.println("All deleted users:");

            for (User values : dataModel.getUsers()){
                String text = String.format("User{name='%s', id=%d, level=%d}", values.getName(), values.getId(), values.getLevel());
                System.out.println("\t" + text);
            }

            System.out.println("===================================================");
        }


    }

    public void fireShowAllUsersEvent() {
        controller.onShowAllUsers();;

    }



    public void fireShowDeletedUsersEvent() {
        controller.onShowAllDeletedUsers();
    }

    public void fireOpenUserEditFormEvent(long id) {
        controller.onOpenUserEditForm(id);
    }



    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }


}
