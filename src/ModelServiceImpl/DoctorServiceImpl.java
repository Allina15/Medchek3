package ModelServiceImpl;

import DaoService.DoctorDao;
import Database.Dao;
import ModelService.DoctorService;

public class DoctorServiceImpl implements DoctorService {
    private Dao dao;
    public DoctorDao doctorDao;
    public DoctorServiceImpl(Dao dao, DoctorDao doctorDao) {
        this.dao = dao;
        this.doctorDao = doctorDao;
    }
}
