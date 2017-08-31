package com.javarush.task.task36.task3608.model;


/**
 * Created by Ben on 2017-08-29.
 */
public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long id);
}
