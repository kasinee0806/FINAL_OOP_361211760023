import java.util.List;
import java.util.Scanner;

public class PatientManagement {
    public static void main(String[] args) {
        //create interface instant
        PatientDAO dao = PatientDAOImpl.getInstance();

        //Get all Patient
        displayAllPatient(dao);
        //add new Patient
        addNewPatient(dao);
        //find Patient by ID
        findPatientByID(dao);
        //update Patient by ID
        updatePatientByID(dao);
        //delete Patient by ID
        deletePatientByID(dao);


    }

    private static void deletePatientByID(PatientDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Dalete patient with ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        dao.deletePatient(id);

    }


    private static void updatePatientByID(PatientDAO dao) {
        Patient PT = findPatientByID2(dao);
        Scanner sc = new Scanner(System.in);
        System.out.print("Updated new P_age for patient ID "+PT.getP_id()+":");
        int ns = Integer.parseInt(sc.nextLine().trim());
        //update salary
        PT.setP_age(ns);
        dao.updatePatient(PT);
        System.out.print("Updated employee with ID: "+PT.getP_id());

    }


    private static Patient findPatientByID2(PatientDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Update an patient ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Patient emp = dao.findPatient(id);
        System.out.print(emp.toString());
        return emp;
    }
    private static void findPatientByID(PatientDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Update new p_age for patient ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Patient PT = dao.findPatient(id);
        System.out.print(PT.toString());
    }


    private static void addNewPatient(PatientDAO dao) {
        Scanner sc = new Scanner(System.in);
        //input data
        System.out.print("Enter Patient p_id:");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Patient p_name:");
        String p_name = sc.nextLine().trim();
        System.out.print("Enter Patient p_gender:");
        String p_gender = sc.nextLine().trim();
        System.out.print("Enter Patient p_age:");
        int p_age = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter Patient p_address:");
        String p_address = sc.nextLine().trim();
        System.out.print("Enter Patient p_blood_result:");
        String p_blood_result = sc.nextLine().trim();
        //insert data to database
        Patient newEmp = new Patient(id, p_name, p_gender, p_age, p_address, p_blood_result);
        dao.addPatient(newEmp);

    }
        private static void displayAllPatient (PatientDAO dao){
            List<Patient> myPT = dao.getAllPatient();
            for (Patient PT : myPT) {
                System.out.println(PT.toString());
            }


        }
    }