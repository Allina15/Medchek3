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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dao dao = new Dao();

        PatientDao patientDao = new DaoPatientImpl(dao);
        PatientService patientService = new PatientServImpl();


        DoctorDao doctorDao = new DaoDoctorImpl(dao);
        DoctorService doctorService = new DoctorServiceImpl(dao, doctorDao);

        DepartmentDao departmentDao = new DaoDepartmentImpl(dao);
        DepartmentService departmentService = new DepartmentServImpl(dao, departmentDao);

        while (true) {
            System.out.println("1. Add hospital");
            System.out.println("2. Get all hospital");
            System.out.println("3. Find hospital by id");
            System.out.println("4. Get all patient by hospital id");
            System.out.println("5. Add patient to hospital");
            System.out.println("6. Get patient by id");
            System.out.println("7. Get patient by age");
            System.out.println("8. Sort patient by age");
            System.out.println("9.  Add department to hospital");
            System.out.println("10. Get all department by hospital id");
            System.out.println("11. Add doctor to hospital");
            System.out.println("12. Assign doctor to another department");
            System.out.println("13. Get all doctor by department id");
            System.out.println("14. Find doctor by id");
            System.out.println("15. Get all doctor by hospital id");
            System.out.println("16. Find department by name");
            System.out.println("17. Get hospital by address");
            System.out.println("18. Delete the hospital");
            System.out.println("19. Update doctor");
            System.out.println("20. Delete the doctor");
            System.out.println("21. Delete the department by id");
            System.out.println("22. Update department by id");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("Put name for hospital: ");
                    String name = scanner.next();
                    scanner.nextLine();
                    System.out.print("Put address: ");
                    String address = scanner.next();
                    System.out.println(hospitalService.addHospital(new Hospital(name, address, new ArrayList<>())));
                }
                case 2 -> System.out.println(hospitalService.getAllHospital());
                case 3 -> {
                    System.out.print("Put id to find the hospital: ");
                    Long id = (long) scanner.nextInt();
                    System.out.println(hospitalService.findHospitalById(id));
                }
                case 4 -> {
                    System.out.print("Put id of hospital to find the patient: ");
                    Long id2 = (long) scanner.nextInt();
                    System.out.println(hospitalService.getAllPatientFromHospital(id2));
                }
//                case 5 -> {
//                    System.out.print("Put id of hospital to add the patient: ");
//                    Long id3 = (long) scanner.nextInt();
//                    System.out.print("Write any name: ");
//                    String name1 = scanner.next();
//                    System.out.print("Write fullName: ");
//                    String fullName = scanner.next();
//                    System.out.print("Put age of patient: ");
//                    int age = scanner.nextInt();
//                    System.out.print("Write any name for another patient: ");
//                    String name11 = scanner.next();
//                    System.out.print("Write fullName: ");
//                    String fullName1 = scanner.next();
//                    System.out.print("Put age of patient: ");
//                    int age2 = scanner.nextInt();
//                    System.out.println(patientService.addPatientsToHospital(id3, List.of(new Patient(name1, fullName, age, Gender.FEMALE), new Patient(name11, fullName1, age2, Gender.MALE))));
//                }
//                case 6 -> {
//                    System.out.print("Put id of patient: ");
//                    Long id4 = (long) scanner.nextInt();
//                    System.out.println(patientService.getPatientById(id4));
//                }
//                case 7 -> System.out.println(patientService.getPatientByAge());
//                case 8 -> {
//                    while (true) {
//                        System.out.print("Put 1 to ascending, or 2 to descending: ");
//                        String num1 = scanner.next();
//                        System.out.println(patientService.sortPatientsByAge(num1));
//                        if (num1.equals("2")) {
//                            break;
//                        }
//                    }
//                }
                case 9 -> {
                    System.out.print("Put id of hospital to add department for: ");
                    Long id5 = (long) scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Put name for 1 department : ");
                    String name4 = scanner.next();
                    System.out.println(departmentService.addDepartmentToHospital(id5, new Department(name4, new ArrayList<>())));
                }
                case 10 -> {
                    System.out.print("Put id of hospital to get all departments: ");
                    Long id54 = (long) scanner.nextInt();
                    System.out.println(departmentService.getAllDepartmentByHospital(id54));

                }
                case 11 -> {
                    System.out.print("Put id of department to add doctors for: ");
                    Long id6 = (long) scanner.nextInt();
                    System.out.print("Put any name to create doctor: ");
                    String name6 = scanner.next();
                    System.out.print("Put fullName: ");
                    String name7 = scanner.next();
                    System.out.print("Write age: ");
                    int age1 = scanner.nextInt();
                    System.out.println(doctorService.addDoctorToHospital(id6, new Doctor(name6, name7, Gender.FEMALE, age1)));
                }
                case 12 -> {
                    System.out.print("Enter department ID to transfer the doctor: ");
                    Long departmentId = scanner.nextLong();

                    System.out.print("Enter the number of doctors to assign: ");
                    int numDoctors = scanner.nextInt();
                    List<Long> doctorsId = new ArrayList<>();

                    for (int i = 0; i < numDoctors; i++) {
                        System.out.print("Enter doctor ID " + (i + 1) + ": ");
                        Long doctorId = scanner.nextLong();
                        doctorsId.add(doctorId);
                    }
                    String result = doctorService.assignDoctorToDepartment(departmentId, doctorsId);
                    System.out.println(result);
                }
                case 13 -> {
                    System.out.print("Get all doctors by department id: ");
                    Long id7 = (long) scanner.nextInt();
                    System.out.println(doctorService.getAllDoctorsByDepartmentId(id7));
                }
                case 14 -> {
                    System.out.print("Put id of doctor: ");
                    Long id8 = (long) scanner.nextInt();
                    System.out.println(doctorService.findDoctorById(id8));
                }
                case 15 -> {
                    System.out.print("Put id of hospital to get all doctors: ");
                    Long id9 = (long) scanner.nextInt();
                    System.out.println(doctorService.getAllDoctorsByHospitalId(id9));
                }
                case 16 -> {
                    System.out.print("Put name of department: ");
                    String n = scanner.next();
                    System.out.println(departmentService.findDepartmentByName(n));
                }
                case 17 -> {
                    System.out.print("Put address of hospital: ");
                    String hospital1 = scanner.next();
                    System.out.println(hospitalService.getAllHospitalByAddress(hospital1));
                }
                case 18 -> {
                    System.out.print("Put id to delete: ");
                    Long num = (long) scanner.nextInt();
                    System.out.println(hospitalService.deleteHospitalById(num));
                }
                case 19 -> {
                    System.out.print("Put id to delete: ");
                    Long numm = (long) scanner.nextInt();
                    System.out.print("Put any name to create doctor: ");
                    String namee = scanner.next();
                    System.out.print("Put fullName: ");
                    String namee2 = scanner.next();
                    System.out.print("Write age: ");
                    int agee2 = scanner.nextInt();
                    System.out.println(doctorService.updateDoctor(numm, new Doctor(namee, namee2, Gender.FEMALE, agee2)));
                }
                case 20 -> {
                    System.out.print("Put id to delete: ");
                    Long numm2 = (long) scanner.nextInt();
                    doctorService.deleteDoctorById(numm2);
                }
                case 21 -> {
                    System.out.print("Put id to delete: ");
                    Long numm3 = (long) scanner.nextInt();
                    departmentService.deleteDepartmentById(numm3);
                }
                case 22 -> {
                    System.out.print("Put id to delete: ");
                    Long numm4 = (long) scanner.nextInt();
                    System.out.println("Put department name");
                    String dep = scanner.next();
                    System.out.println(departmentService.updateDepartmentById(numm4, new Department(dep, new ArrayList<>())));
                }
            }
        }
    }
}