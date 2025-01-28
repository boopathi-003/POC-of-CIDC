package crud_oper;
import java.util.InputMismatchException;
import java.util.Scanner;
public class EmployeCrud {
    public static void main(String[] args) throws InputMismatchException {
        try {
            Scanner sc = new Scanner(System.in);
            EmployeeRecordManagement erm = new EmployeeRecordManagement();
            Record rec = new Record();
            rec.setName("boopathi");
            rec.setId(1);
            rec.setPh_no(876543342L);
            erm.AddRecord(rec);
            System.out.println("Welcome to Employee Management System" + "\n" + "Choose your option to interact with us: ");
            System.out.println("1. Add");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Display all Records");
            System.out.println("6. Exit");
            int option;
            do {
                System.out.print("Enter the option : ");
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter id : ");
                        int id = sc.nextInt();
                        System.out.print("Enter name : ");
                        String name = sc.next();
                        System.out.print("Enter Ph_No");
                        Long Ph_No = sc.nextLong();
                        rec = new Record(name, id, Ph_No);
                        erm.AddRecord(rec);
                        System.out.println(rec);
                        System.out.println("Record Added Successfully");
                        break;
                    case 2:
                        System.out.print("Enter Id : ");
                        int Search = sc.nextInt();
                        rec = erm.Read(Search);
                        System.out.println(rec);
                        break;
                    case 3:
                        System.out.print("Enter Id : ");
                        int update = sc.nextInt();
                        erm.UpdateRecord(update, sc);
                        break;
                    case 4:
                        System.out.print("Enter Id : ");
                        int deleteid = sc.nextInt();
                        erm.DeleteRecord(deleteid);
                        break;
                    case 5:
                        erm.display();
                        break;
                    case 6:
                        System.out.println("Thanks for Coming");
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
            while (option != 6);
        } catch (InputMismatchException e) {
            System.err.println(e);
        }

    }
}
