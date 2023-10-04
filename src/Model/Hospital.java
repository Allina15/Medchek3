package Model;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private Long id;
    private Long instanceId;
    private  String hospitalName;

    private  String address;
    private  List<Department> departments;
    private  List<Doctor> doctors;
    private  List<Patient> patients;

    public Hospital(String hospitalName, String address, List<Department> departments) {
        this.instanceId=id++;
        this.hospitalName = hospitalName;
        this.address = address;
        this.departments = departments;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInstanceId() {
        return instanceId;
    }
    public String getAddress() {
        return address;
    }
    public List<Department> getDepartments() {
        return departments;
    }
    public List<Doctor> getDoctors() {
        return doctors;
    }
    public List<Patient> getPatients() {
        return patients;
    }




    @Override
    public String toString() {
        return "Hospital{" +
                "instanceId=" + instanceId +
                ", hospitalName='" + hospitalName + '\'' +
                ", address='" + address + '\'' +
                ", departments=" + departments +
                ", doctors=" + doctors +
                ", patients=" + patients +
                '}';
    }
}
