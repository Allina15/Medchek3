import DaoService.DepartmentDao;
import DaoService.DoctorDao;
import DaoService.HospitalDao;
import DaoService.PatientDao;
import DaoServiceImpl.DaoDepartmentImpl;
import DaoServiceImpl.DaoDoctorImpl;
import DaoServiceImpl.DaoHospitalImpl;
import DaoServiceImpl.DaoPatientImpl;
import Database.Dao;
import ModelService.DepartmentService;
import ModelService.DoctorService;
import ModelService.HospitalService;
import ModelService.PatientService;
import ModelServiceImpl.DepartmentServImpl;
import ModelServiceImpl.DoctorServiceImpl;
import ModelServiceImpl.HospitalServiceImpl;
import ModelServiceImpl.PatientServImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                Dao dao = new Dao();

                PatientDao patientDao = new DaoPatientImpl(dao);
                PatientService patientService = new PatientServImpl(dao, patientDao);

                HospitalDao hospitalDao = new DaoHospitalImpl(dao);
                HospitalService hospitalService = new HospitalServiceImpl(hospitalDao);

                DoctorDao doctorDao = new DaoDoctorImpl(dao);
                DoctorService doctorService = new DoctorServiceImpl(dao, doctorDao);

                DepartmentDao departmentDao = new DaoDepartmentImpl(dao);
                DepartmentService departmentService = new DepartmentServImpl(dao,departmentDao);


    }
}