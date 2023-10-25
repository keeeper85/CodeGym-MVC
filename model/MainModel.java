package com.codegym.task.task36.task3608.model;

import com.codegym.task.task36.task3608.bean.User;
import com.codegym.task.task36.task3608.model.DataModel;
import com.codegym.task.task36.task3608.model.Model;
import com.codegym.task.task36.task3608.model.service.UserService;
import com.codegym.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements Model {

    private UserService userService = new UserServiceImpl();
    private DataModel dataModel = new DataModel();

    @Override
    public DataModel getDataModel() {
        return dataModel;
    }

    @Override
    public void loadUsers() {
        //getAllUsers();

        dataModel.setUsers(getAllUsers());
        dataModel.setDisplayDeletedUserList(false);

    }

    public void loadDeletedUsers() {
        List users = userService.getAllDeletedUsers();
        dataModel.setUsers(users);
        dataModel.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        dataModel.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {

//        List<User> list = dataModel.getUsers();
//        for (User values : list){
//            if (values.getId() == id){
//                list.remove(values);
//                break;
//            }
//        }

        User user = userService.deleteUser(id);
        dataModel.setActiveUser(user);
        dataModel.setUsers(getAllUsers());


    }

    public void changeUserData(String name, long id, int level){
        userService.createOrUpdateUser(name, id, level);
        dataModel.setUsers(getAllUsers());
    }

    private List<User> getAllUsers(){

        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1,100));
    }
}
