package test.dao;

import test.entity.Geography;

import java.util.List;

public interface AppDao {
    List<Geography> allInfoDao();

    boolean addNewCityDao(Geography geography);

    Geography findByIdDao(long id);

    void editNoteDao(Geography geography);

    void deleteNoteDao(Geography geography);
}
