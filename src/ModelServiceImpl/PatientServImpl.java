package ModelServiceImpl;

import DaoService.DepartmentDao;
import DaoService.PatientDao;
import DaoServiceImpl.DaoPatientImpl;
import Database.Dao;
import Model.Patient;
import ModelService.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServImpl implements PatientService {
    private DaoPatientImpl daoPatient;

    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        return daoPatient.addPatientToHospital(id, patient);
    }

    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        return daoPatient.updatePatientById(id, patientsNewInfo);
    }

    @Override
    public void removePatientById(Long id) {
        daoPatient.removePatientById(id);
    }

    @Override
    public Patient getPatientById(Long id) {
        return daoPatient.getPatientById(id);
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        return daoPatient.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return daoPatient.sortPatientsByAge(ascOrDesc);
    }
}
