package DaoServiceImpl;

import DaoService.DoctorDao;
import Database.Dao;

import java.util.List;

public class DaoDoctorImpl implements DoctorDao {
    private Dao dao;

    public DaoDoctorImpl(Dao dao) {
        this.dao = dao;
    }
}
