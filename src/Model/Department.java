package Model;

import java.util.List;

public class Department {
    public Long id;
    private int instanceId;
    private String departmentName;
    private List<Doctor> doctors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(int instanceId) {
        this.instanceId = instanceId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }


    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
