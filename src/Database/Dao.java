package Database;

import Model.Hospital;
import Model.Patient;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    private static List<Hospital> hospitals;
    private List<Patient>patients;

    public static List<Hospital> getHospitals() {
        return hospitals;
    }

    public Dao() {
        this.hospitals = new ArrayList<>();
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
