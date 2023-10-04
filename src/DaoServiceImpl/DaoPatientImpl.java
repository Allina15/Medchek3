package DaoServiceImpl;

import DaoService.PatientDao;
import Database.Dao;
import Model.Hospital;
import Model.Patient;
import exception.MyException;

import java.util.*;

public class DaoPatientImpl implements PatientDao {
    private List<Patient> patients = new ArrayList<>();
    private Dao dao;

    public DaoPatientImpl(Dao dao) {
        this.dao = dao;
    }

    @Override
    public Patient getPatientById(Long id) {
        List<Hospital> hospitals = Dao.getHospitals();
        for (Hospital hospital : hospitals) {
            List<Patient> patients = hospital.getPatients();
            for (Patient patient : patients) {
                if (patient.getId().equals(id)) {
                    return patient;
                }
            }
        }
        return null; // Пациент не найден
    }
    @Override
    public String addPatientToHospital(Long id, Patient patient) {
        boolean isTrue = true;
        for (Hospital d : Database.Dao.getHospitals()) {
            if (d.getId() == id) {
                isTrue = true;
                d.getPatients().add((Patient) patient);
                return "Patient successfully added patient: " + patient;
            } else {
                isTrue = false;
            }
        }
        try {
            if (!isTrue) {
                throw new MyException("Not found hospital");
            }
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }


    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> allPatients = new ArrayList<>();
        List<Hospital> hospitals = Dao.getHospitals();
        for (Hospital hospital : hospitals) {
            List<Patient> patients = hospital.getPatients();
            allPatients.addAll(patients);
        }

        if (ascOrDesc.equalsIgnoreCase("asc")) {
            allPatients.sort(Comparator.comparingInt(Patient::getAge));
        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            allPatients.sort(Comparator.comparingInt(Patient::getAge).reversed());
        }

        return allPatients;
    }

    @Override
    public Map<Integer, Patient> getPatientByAge() {
        Map<Integer, Patient> patientsByAge = new HashMap<>();
        List<Hospital> hospitals = Dao.getHospitals();
        for (Hospital hospital : hospitals) {
            List<Patient> patients = hospital.getPatients();
            for (Patient patient : patients) {
                patientsByAge.put(patient.getAge(), patient);
            }
        }
        return patientsByAge;
    }
    @Override
    public String updatePatientById(Long id, Patient patientsNewInfo) {
        List<Hospital> hospitals = Dao.getHospitals();
        for (Hospital hospital : hospitals) {
            if (hospital.getId().equals(id)) {
                List<Patient> patients = hospital.getPatients();
                for (int i = 0; i < patients.size(); i++) {
                    Patient existingPatient = patients.get(i);
                    if (existingPatient.getId().equals(patientsNewInfo.getId())) {
                        patients.set(i, patientsNewInfo);
                        return "Patient updated successfully.";
                    }
                }
                return "Patient with ID " + id + " not found in the hospital.";
            }
        }
        return "Hospital not found.";
    }

    @Override
    public void removePatientById(Long id) {
        List<Hospital> hospitals = Dao.getHospitals();
        for (Hospital hospital : hospitals) {
            if (hospital.getId().equals(id)) {
                hospitals.remove(hospital);
                break;
            }
        }
    }
}