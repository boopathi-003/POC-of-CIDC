package crud_oper;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Stream;

public class EmployeeRecordManagement {
    LinkedList<Record> list;

    public EmployeeRecordManagement() {
        list = new LinkedList<>();
    }

    public void AddRecord(Record record) {
        if (!isExist(record.getId())) {
            list.add(record);
        } else {
            System.out.println("Record is already Exist");
        }
    }

    public void UpdateRecord(int id, Scanner input) {
        if (!isExist(id)) {
            Record rec = Read(id);
            System.out.print("id : ");
            int idNumber = input.nextInt();
            System.out.print("contact Number :  ");
            long contactNumber = input.nextLong();
            input.nextLine();
            System.out.print("updated  name : ");
            String name = input.nextLine();
            rec.setId(idNumber);
            rec.setName(name);
            rec.setPh_no(contactNumber);
            System.out.println("Record Updated Successfully");
        } else {
            System.out.println("Record Not Found in the Student list");
        }
    }

    public void DeleteRecord(int Id) {
        Record deleteRecord = null;
        for (Record l : list) {
            if (l.getId() == Id) {
                deleteRecord = l;
            }
        }
        if (deleteRecord == null) {
            System.out.println("No record found");
        } else {
            list.remove(deleteRecord);
            System.out.println("Deleted Successfully");
        }
    }

    public Record Read(int Id) {

        return list.stream().filter(l -> l.getId() == Id).findFirst().orElse(null);

    }

    public boolean isExist(int Id) {
        Stream<Record> n = list.stream().filter(findList -> findList.getId() == Id);
        if (n.equals(Id)) {
            return true;
        } else {
            return false;
        }
    }

    public void display() {
         if(list.isEmpty()){
             System.out.println("No file Found");
         }
         else {
             System.out.println("Employee Records : " + "\n" + list);
         }
    }
}
