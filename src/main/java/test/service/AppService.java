package test.service;

import test.entity.Geography;

import java.util.List;

public interface AppService {

    List<Geography> allInfo();

    boolean addNewCity(Geography geography);

    Geography findById(long id);

    void editNote(Geography geography);

    void deleteNote(Geography geography);

    String  findByName(String  cityName);

}
