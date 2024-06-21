import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

class Placement_Cell {

    private int count_cell_1 = 0;
    private Student[] stu_array = new Student[100];
    private int count_cell_2 = 0;
    private Company[] cpny_array = new Company[100];
    public int getCount_cell_1() {
        return count_cell_1;
    }
    public void setCount_cell_1(int count_cell_1) {
        this.count_cell_1 = count_cell_1;
    }
    public void setCount_cell_2(int count_cell_2) {
        this.count_cell_2 = count_cell_2;
    }
    public int getCount_cell_2() {
        return count_cell_2;
    }
    public Company[] getCpny_array() {
        return cpny_array;
    }
    public Student[] getStu_array() {
        return stu_array;
    }
    public void Open_student_registration(String str1, String str2) {
        System.out.println("opening:");

        System.out.println(str1);
        System.out.println("closing:");

        System.out.println(str2);

    }

    public void Open_Company_registration(String str1, String str2) {
        System.out.println("opening:");

        System.out.println(str1);
        System.out.println("closing:");

        System.out.println(str2);

    }

    public int getNumber_of_companies_reg() {
        return this.count_cell_2;
    }

    public int getNumber_of_students_reg() {

        return this.count_cell_1;

    }

    public void get_offered_unoffered_blocked() {
        int num_unoffer = 0;
        int block = 0;

        for (int i = 0; i < count_cell_1; i++) {
            if (stu_array[i].getStatus() == -2) {
                block++;

            }

            else if (stu_array[i].getStatus() == -1) {
                // System.out.println(stu);
                System.out.println(stu_array[i].getName() + "is offered by" + stu_array[i].getAccepted_Company().getName());
                System.out.println(stu_array[i].getCGPA());
                System.out.println(stu_array[i].getBranch());
                System.out.println(stu_array[i].getRoll_no());
                System.out.println();
            } else {
                num_unoffer++;
            }

        }
        System.out.println("Unoffered students are:" + num_unoffer);
        System.out.println("Blocked students are:" + block);

    }

    public void get_student_details(String stu_nam, int roll) {
        int num = 0;
        for (int i = 0; i < count_cell_1; i++) {
            if (stu_array[i].getRoll_no() == roll) {
                num = i;
                break;
            }

        }
        Set<String> hs = new HashSet<String>();
        for (int i = 0; i < count_cell_2; i++) {
            hs.add(cpny_array[i].getName());

        }
        System.out.println("Registered Companies by " + stu_array[num].getName() + ":");

        for (int i = 0; i < (stu_array[num]).getCount2(); i++) {
            System.out.println((stu_array[num]).getReg_cmp()[i].getName());
            // for (int j = 0; j < (stu_array[num]).count3; j++) {
            // if((stu_array[num]).reg_cmp[i].Name == (stu_array[num]).offered_cmp[j].Name){
            // System.out.println("offered by above company");
            // }

            // }
        }

        if (stu_array[num].getAccepted_Company() != null) {
            System.out.println("offered to " + stu_array[num].getName() + " by " + stu_array[num].getAccepted_Company().getName());
        }

        // System.out.println("Not registered companies");
        System.out.println("Not Registered Companies by " + stu_array[num].getName() + ":");

        for (int i = 0; i < (stu_array[num]).getCount2(); i++) {
            for (int j = 0; j < count_cell_2; j++) {
                if (cpny_array[j].getName() == (stu_array[num]).getReg_cmp()[i].getName()) {
                    // System.out.println((stu_array[num]).reg_cmp[i].Name);
                    hs.remove(cpny_array[j].getName());

                }

            }

        }
        for (String string : hs) {
            System.out.println(string);

        }

    }

    public void get_Company_details(String c) {
        int num = 0;

        for (int i = 0; i < count_cell_2; i++) {
            if (cpny_array[i].getName() == c) {
                num = i;
                break;

            }

        }

        System.out.println("Company " + cpny_array[num].getName() + " selected: ");

        for (int i = 0; i < cpny_array[num].getCount2(); i++) {
            System.out.println(cpny_array[num].getSelected()[i].getName());
            // System.out.println(cpny_array[num].selected[i].Branch);
            // System.out.println(cpny_array[num].selected[i].CGPA);
            System.out.println(cpny_array[num].getSelected()[i].getRoll_no());

        }

    }

    public void get_average_package() {
        int sum = 0;
        for (int i = 0; i < count_cell_1; i++) {
            if (stu_array[i].getStatus() == -1) {
                sum += stu_array[i].getAccepted_Company().getPackage();
            }
        }

        // return sum/count_cell_1;
        System.out.println("Average Package is: " + sum / count_cell_1);
    }

    public void get_company_process_list(String c) {
        int num = 0;

        // System.out.println("Company Process List: ");


        for (int i = 0; i < count_cell_2; i++) {
            if (cpny_array[i].getName() == c) {
                num = i;
                break;

            }

        }

        cpny_array[num].get_selected_students();

        System.out.println("List of students selected by " + cpny_array[num].getName() + ":");

        for (int i = 0; i < cpny_array[num].getCount2(); i++) {
            System.out.println(cpny_array[num].getSelected()[i].getName());
            System.out.println();

        }

    }

}

class Company {
    private String Name;
    private String Role;
    private float Package;
    private float CGPA;
    private String Date_and_time;
    private int count1 = 0;
    private int count2 = 0;

    Company(String name, String role, float packag, float cgpa, String date_and_time) {
        this.Name = name;
        this.Role = role;
        this.Package = packag;
        this.CGPA = cgpa;
        this.Date_and_time = date_and_time;

    }

    // int count_applied =0;
    public void setCount1(int count1) {
        this.count1 = count1;
    }
    public void setCount2(int count2) {
        this.count2 = count2;
    }

    private Student[] applied = new Student[100];
    // int count_selected =0;

    private Student[] selected = new Student[100];

    public Student[] getSelected() {
        return selected;
    }

    public float getCGPA() {
        return CGPA;
    }

    
    public void setCGPA(float cGPA) {
        CGPA = cGPA;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getRole() {
        return Role;
    }

    public void setPackage(float package1) {
        Package = package1;
    }

    public float getPackage() {
        return Package;
    }
    public Student[] getApplied() {
        return applied;
    }
    public int getCount1() {
        return count1;
    }
    public int getCount2() {
        return count2;
    }
    public String getName() {
        return Name;
    }
    
    
    public void add_company(Placement_Cell p) {
        p.getCpny_array()[p.getCount_cell_2()] = this;
        // p.count_cell_2++;
        p.setCount_cell_2(p.getCount_cell_2()+1);
        System.out.println(this.Name +"successfully registered for placement cell");

    }

    public void get_selected_students() {

        Random ran = new Random();
        int t = ran.nextInt(count1);
        this.selected[this.count2] = applied[t];

        applied[t].getOffered_cmp()[applied[t].getCount3()] = this;
        count2++;
        // applied[t].count3++;
        applied[t].setCount3(applied[t].getCount3()+1);

        for (int i = 0; i < count1; i++) {
            if (t == i) {
                continue;
            }

            if (ran.nextBoolean()) {

                this.selected[this.count2] = applied[i];
                applied[i].getOffered_cmp()[applied[i].getCount3()] = this;
                count2++;
                // applied[i].count3++;
                applied[i].setCount3(applied[i].getCount3()+1);


            }

        }

    }

}

class Student {
    private String Name;
    private int Roll_no;
    private float CGPA;
    private String Branch;
    private int status = 0;
    private Company accepted_Company;

    private int count1 = 0;
    private Company[] cmp = new Company[100];
    private int count2 = 0;
    private Company[] reg_cmp = new Company[100];

    private int count3 = 0;
    private Company[] offered_cmp = new Company[100];

    Student(String name, int roll_no, float cgpa, String branch) {
        this.Name = name;
        this.Roll_no = roll_no;
        this.CGPA = cgpa;
        this.Branch = branch;

    }
    public Company getAccepted_Company() {
        return accepted_Company;
    }
    public String getBranch() {
        return Branch;
    }
    public float getCGPA() {
        return CGPA;
    }
    public Company[] getCmp() {
        return cmp;
    }
    public int getCount1() {
        return count1;
    }
    public int getCount2() {
        return count2;
    }
    public int getCount3() {
        return count3;
    }
    public String getName() {
        return Name;
    }
    public Company[] getOffered_cmp() {
        return offered_cmp;
    }
    public Company[] getReg_cmp() {
        return reg_cmp;
    }
    public int getRoll_no() {
        return Roll_no;
    }
    public int getStatus() {
        return status;
    }

    public void setAccepted_Company(Company accepted_Company) {
        this.accepted_Company = accepted_Company;
    }
    public void setBranch(String branch) {
        Branch = branch;
    }
    public void setCmp(Company[] cmp) {
        this.cmp = cmp;
    }
    public void setCount1(int count1) {
        this.count1 = count1;
    }
    public void setCount2(int count2) {
        this.count2 = count2;
    }
    public void setCount3(int count3) {
        this.count3 = count3;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setRoll_no(int roll_no) {
        Roll_no = roll_no;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public void add_student(Placement_Cell p) {
        p.getStu_array()[p.getCount_cell_1()] = this;
        p.setCount_cell_1(p.getCount_cell_1()+1);

        System.out.println(this.Name +" succesfully registered for placement drive");
        System.out.println(this.Roll_no);
        System.out.println(this.CGPA);
        System.out.println(this.Branch);

    }

    public void Register_for_Company(String cmpny) {
        if (this.count1 == 0) {
            System.out.println("No Company registered yet");
            return;
        }
        // int k =0;
        for (int i = 0; i < this.count1; i++) {
            if ((this.cmp[i].getName()).equals(cmpny)) {
                this.reg_cmp[count2] = cmp[i];
                System.out.println(this.Name + " registered for " + this.cmp[i].getName());
                System.out.println();

                this.cmp[i].getApplied()[this.cmp[i].getCount1()] = this;
                this.count2++;
                // this.cmp[i].count1++;
                this.cmp[i].setCount1(this.cmp[i].getCount1()+1);

            }

        }

        System.out.println();
        

    }

    public void Get_all_available(Company[] arr, int len) {
        this.count1 = 0;
        if (status == -2) {
            System.out.println("Blocked by placement cell");
            return;
        }

        System.out.println("Available companies for" + this.Name);

        for (int g = 0; g < len; g++) {

            if (this.status == 0 && this.CGPA >= (arr[g]).getCGPA()) {

                // System.out.println();
                this.cmp[this.count1] = arr[g];
                System.out.println(this.cmp[count1].getName());
                System.out.println(this.cmp[count1].getPackage());
                System.out.println(this.cmp[count1].getCGPA());
                System.out.println(this.cmp[count1].getRole());

                this.count1++;

            }
            // int i;
            if (this.status == -1 && this.CGPA >= (arr[g]).getCGPA()
                    && (arr[g]).getPackage() >= 3 * (accepted_Company).getPackage()) {
                this.cmp[this.count1] = arr[g];
                System.out.println(this.cmp[count1].getName());
                System.out.println(this.cmp[count1].getPackage());
                System.out.println(this.cmp[count1].getCGPA());
                System.out.println(this.cmp[count1].getRole());
                this.count1++;
            }

        }

    }

    public void setCGPA(Placement_Cell p, float cGPA) {

        for (int i = 0; i < p.getCount_cell_1(); i++) {
            if (this.Roll_no == p.getStu_array()[i].getRoll_no()) {
                (p.getStu_array()[i]).CGPA = cGPA;
            }

        }
    }

    public void get_current_status() {
        if (status == -1) {
            System.out.println(this.Name + " placed in:");
            Company max_Company = offered_cmp[0];
            for (int i = 0; i < count3; i++) {
                if (max_Company.getPackage() < offered_cmp[i].getPackage()) {
                    max_Company = offered_cmp[i];
                }

            }
            // System.out.println(i+1 +":");
            System.out.println(max_Company.getName());
            System.out.println(max_Company.getCGPA());
            System.out.println(max_Company.getRole());
            System.out.println(max_Company.getPackage());
            System.out.println();
            return;

        }
        if (status == -2) {
            System.out.println(this.Name + " is Blocked");
            return;
        }

        if(count3>0){
            Company max_Company = offered_cmp[0];
            for (int i = 0; i < count3; i++) {
                if (max_Company.getPackage() < offered_cmp[i].getPackage()) {
                    max_Company = offered_cmp[i];
                }

            }
            // System.out.println(i+1 +":");
            System.out.println(this.Name + "is Offered");

            System.out.println(max_Company.getName());
            System.out.println(max_Company.getCGPA());
            System.out.println(max_Company.getRole());
            System.out.println(max_Company.getPackage());
            System.out.println();
            
            return;
        }
        if (status == 0) {
            System.out.println(this.Name + " is Unoffered");
            return;

        }

    }

    public void Accept_Reject_Offer() {
        if (count3 == 0) {
            System.out.println("No offers available for " + this.Name);
            return;
        }
        System.out.println("Write 0 if dont want any Company offer, if want write 1 (for " + this.Name + ")");
        Company max_Company = offered_cmp[0];
        for (int i = 0; i < count3; i++) {
            if (max_Company.getPackage() < offered_cmp[i].getPackage()) {
                max_Company = offered_cmp[i];
            }

        }
        // System.out.println(i+1 +":");
        System.out.println(max_Company.getName());
        System.out.println(max_Company.getCGPA());
        System.out.println(max_Company.getRole());
        System.out.println(max_Company.getPackage());
        System.out.println();
        // System.out.println("");
        Scanner scn = new Scanner(System.in);

        int number = scn.nextInt();

        // System.out.println();
        if (number == 0) {
            this.status = -2;
            return;
        }

        this.accepted_Company = max_Company;
        this.status = -1;

    }

}

public class Tanuj_2021497_Assignment_1 {
    public static void main(String[] args) {

        // Company [] allCompanies = new Company[100];
        ArrayList<Company> allCompanies = new ArrayList<Company>();
        ArrayList<Student> allStudents = new ArrayList<Student>();

        System.out.println("Welcome to FutureBuilder:");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1) Enter the Application");
            System.out.println("2) Exit the Application");

            int scn_int = sc.nextInt();
            String scn_String;

            if (scn_int == 1) {
                Placement_Cell pCell = new Placement_Cell();
                while (true) {
                System.out.println("1) Enter as Student Mode");
                System.out.println("2) Enter as Company Mode");
                System.out.println("3) Enter as Placement Cell Mode");
                System.out.println("4) Return to Main Application");
                scn_int = sc.nextInt();
                    if (scn_int == 1) {
                    while(true){

                        System.out.println("1) Enter as a Student(Give Student Name, and Roll No.)");
                        System.out.println("2) Add students");
                        System.out.println("3) Back");
                        scn_int = sc.nextInt();
                        
                        if(scn_int ==1){
                            String name = sc.next();
                            int roll_no = sc.nextInt();

                            // for (Student student : allStudents) {
                            //     Student st;


                            //     if(student.Roll_no==roll_no){
                            //         st = student;
                            //         break;
                            //     }
                                
                            // }

                            int num1=0;

                            for (int i = 0; i < allStudents.size(); i++) {
                                if(allStudents.get(i).getRoll_no() ==roll_no){
                                    num1 =i;
                                    break;

                                }
                                
                            }

                            // Student stud = st;
                            Student s = allStudents.get(num1);

                            while(true){

                            System.out.println("Welcome " + s.getName());
                            // System.out.println("Welcome");
                            System.out.println("1) Register For Placement Drive");
                            System.out.println("2) Register For Company");
                            System.out.println("3) Get All available companies");
                            System.out.println("4) Get Current Status");
                            System.out.println("5) Update CGPA");
                            System.out.println("6) Accept/Reject offer");
                            System.out.println("7) Back");
                            scn_int = sc.nextInt();
                            // Student s1 = s;

                            if(scn_int == 1){
                                s.add_student(pCell);
                                
                                
                            }
                            else if(scn_int ==2){
                                String cmpny = sc.next();
                                s.Register_for_Company(cmpny);

                            }

                            else if(scn_int==3){

                                s.Get_all_available(pCell.getCpny_array(), pCell.getCount_cell_2());
                            }
                            else if(scn_int==4){
                                s.get_current_status();
                            }
                            else if(scn_int ==5){
                                float cGPA  = sc.nextFloat();

                                
                                s.setCGPA(pCell, cGPA);
                            }

                            else if(scn_int ==6){
                                s.Accept_Reject_Offer();
                            }

                            else{
                                break;
                            }
                        }



                            // if()

                            
                            
                            
                            
                            
                            
                            






                        }
                        else if(scn_int==2){
                            System.out.println("Number of students to add: ");
                            int sc_int = sc.nextInt();
                            System.out.println("Please add students Name, Roll No, CGPA, Branch(in order):");
                            for (int i = 0; i < sc_int; i++) {

                                String name = sc.next();
                                int roll_no = sc.nextInt();
                                float cgpa = sc.nextFloat();
                                String branch = sc.next();
                                // String name = sc.next();

                                Student st1 = new Student(name, roll_no, cgpa, branch);
                                // Student st = new Student(name, roll_no, cgpa, branch);





                                

                                allStudents.add(st1);



                                
                            }
                        }
                        else{
                            break;
                        }

                    }

                    } 
                    else if (scn_int == 3) {
                        while(true){
                        System.out.println("Welcome to IIITD Placement Cell");
                        System.out.println("1)Open Student Registrations");
                        System.out.println("2)Open Company Registrations");
                        System.out.println("3)Get Number of Student Registrations");
                        System.out.println("4)Get Number of Company Registrations");
                        System.out.println("5)Get Number of Offered/Unoffered/Blocked Students");
                        System.out.println("6)Get Student Details");
                        System.out.println("7)Get Company Details");
                        System.out.println("8)Get Average Package");
                        System.out.println("9)Get Company Process Result");
                        System.out.println("10)Back");
                        scn_int = sc.nextInt();
                        if (scn_int == 1) {
                            System.out.println("opening:");
                            scn_String = sc.next();
                            System.out.println("closing:");

                            String scn_String2 = sc.next();
                            


                            pCell.Open_student_registration(scn_String, scn_String2);
                            continue;

                        } else if (scn_int == 2) {
                            System.out.println("opening:");
                            scn_String = sc.next();
                            System.out.println("closing:");
                            String scn_String2 = sc.next();


                            pCell.Open_Company_registration(scn_String, scn_String2);
                            continue;

                        }

                        else if (scn_int == 3) {
                            System.out.println(pCell.getNumber_of_companies_reg());
                            continue;

                        }

                        else if (scn_int == 4) {
                            System.out.println(pCell.getNumber_of_students_reg());
                            continue;
                        }

                        else if (scn_int == 5) {
                            // System.out.println(pCell.ge);
                            pCell.get_offered_unoffered_blocked();
                            continue;

                        }

                        else if (scn_int == 6) {
                            System.out.println("Enter Student Name:");
                            scn_String = sc.next();
                            String stu_nam = scn_String;
                            System.out.println("Enter Roll Number");
                            scn_int = sc.nextInt();

                            int roll = scn_int;
                            pCell.get_student_details(stu_nam, roll);
                            continue;

                        }

                        else if (scn_int == 7) {
                            System.out.println("Enter company Name:");
                            scn_String = sc.next();

                            pCell.get_Company_details(scn_String);
                            continue;

                        }

                        else if (scn_int == 8) {
                            pCell.get_average_package();
                            continue;

                        }

                        else if (scn_int == 9) {
                            System.out.println("Enter company Name:");
                            scn_String = sc.next();

                            pCell.get_company_process_list(scn_String);
                            continue;

                        }

                        else {
                            break;

                        }
                    }

                    }

                    else if(scn_int==2){
                        while(true){
                        System.out.println("Choose the Company Query to perform:");
                        System.out.println("1) Add Company and Details");
                        System.out.println("2)Choose Company");
                        System.out.println("3)Get available Companies");
                        System.out.println("4)Back");
                        scn_int = sc.nextInt();
                        
                        if(scn_int == 4){
                            break;
                        }
                        else if(scn_int ==1){
                            System.out.println("Enter company Name, Role, CTC, CGPA");
                            String name = sc.next();
                            String role = sc.next();
                            float packag = sc.nextFloat();
                            float cgpa = sc.nextFloat();
                            String date_and_time = sc.next();
                            // String name = sc.next();

                            Company cm = new Company(name, role, packag, cgpa, date_and_time);
                            allCompanies.add(cm);

                            continue;



                        }

                        else if(scn_int ==2){
                            int k =0;
                            for (Company cm : allCompanies) {
                                System.out.println((k+1) +")" );
                                System.out.println(cm.getName());
                                // System.out.println(cm.Role);
                                // System.out.println(cm.Package);
                                // System.out.println(cm.CGPA);
                                // System.out.println();

                                
                            }

                            scn_int = sc.nextInt();
                            scn_int--;
                            while(true){
                            System.out.println("Welcome"+allCompanies.get(scn_int).getName());
                            System.out.println("1) Update Role");
                            System.out.println("2) Update Package");
                            System.out.println("3) Update CGPA criteria");
                            System.out.println("4) Register to Institue Drive");
                            System.out.println("5) Back");

                            int scn_in = sc.nextInt();
                            if(scn_in==1){
                                String role = sc.next();
                                allCompanies.get(scn_int).setRole(role);

                            }
                            else if(scn_in==2){
                                float package1 = sc.nextFloat();
                                allCompanies.get(scn_int).setPackage(package1);


                            }
                            else if(scn_in ==3){
                                float cGPA = sc.nextFloat();
                                allCompanies.get(scn_int).setCGPA(cGPA);

                            }

                            else if(scn_in==4){
                                allCompanies.get(scn_int).add_company(pCell);
                            }
                            else{
                                break;
                            }

                        }
                        }
                        else if(scn_int==3){
                            int k =0;
                            for (Company cm : allCompanies) {
                                System.out.println((k+1) +")" );
                                System.out.println(cm.getName());
                                System.out.println(cm.getRole());
                                System.out.println(cm.getPackage());
                                System.out.println(cm.getCGPA());
                                System.out.println();

                                
                            }
                            continue;

                        }

                        else{
                            break;
                        }
                    }
                    }

                    else{
                        break;
                    }



                }
            } 
            else {
                return;

            }

        }

    }
}



