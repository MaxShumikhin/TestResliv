package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.dao.AppDao;
import test.dao.AppDaoImpl;
import test.entity.Geography;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    private AppDao appDao;

    @Autowired
    public void setAppDao(AppDao appDao) {
        this.appDao = appDao;
    }

    @Override
    @Transactional
    public List<Geography> allInfo() {
        return appDao.allInfoDao();
    }

    @Override
    @Transactional
    public boolean addNewCity(Geography geography) {
        return appDao.addNewCityDao(geography);
    }

    @Override
    @Transactional
    public Geography findById(long id) {
        return appDao.findByIdDao(id);
    }

    @Override
    @Transactional
    public void editNote(Geography geography) {
        appDao.editNoteDao(geography);
    }

    @Override
    @Transactional
    public void deleteNote(Geography geography) {
        appDao.deleteNoteDao(geography);
    }

    @Override
    @Transactional
    public String findByName(String cityname) {
       AppDao appDao1 = new AppDaoImpl();
        Geography geography = appDao1.findByNameDao(cityname);
        if(geography!=null) {
            String description = geography.toString();
            return description;
        } else return "нет";
    }
}
