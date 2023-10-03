package DaoServiceImpl;

import DaoService.HospitalDao;
import Database.Dao;

public class DaoHospitalImpl implements HospitalDao {

    private Dao dao;

    public DaoHospitalImpl(Dao dao) {
        this.dao = dao;
    }
}
