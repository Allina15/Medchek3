package DaoServiceImpl;

import DaoService.DepartmentDao;
import Database.Dao;

import java.util.List;

public class DaoDepartmentImpl implements DepartmentDao {

    private Dao dao;

    public DaoDepartmentImpl(Dao dao) {
        this.dao = dao;
    }
}
