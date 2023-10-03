package ModelServiceImpl;

import DaoService.DepartmentDao;
import Database.Dao;
import ModelService.DepartmentService;

public class DepartmentServImpl implements DepartmentService {
    private Dao dao;
    public DepartmentDao departmentDao;

    public DepartmentServImpl(Dao dao, DepartmentDao departmentDao) {
        this.dao = dao;
        this.departmentDao = departmentDao;
    }
}
