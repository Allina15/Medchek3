package DaoService;

import Model.Patient;

import java.util.List;
import java.util.Map;

public interface PatientDao {
    String addPatientToHospital(Long id, Patient patient);
    String updatePatientById(Long id, Patient patientsNewInfo);
    void removePatientById(Long id);
    Patient getPatientById(Long id);
    Map<Integer, Patient> getPatientByAge();
    List<Patient> sortPatientsByAge(String ascOrDesc);
}
