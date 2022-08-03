import java.util.*;

class StudentData{
    String name;
    String rollno;
    int oop;
    int ada;
    int se;
    int de;
    int total=0;
    double pr;

    StudentData(String name,String rollno,int oop,int ada,int se,int de){
        this.name = name;
        this.rollno = rollno;
        this.oop = oop;
        this.ada = ada;
        this.se = se;
        this.de = de;
    }
}

public class Student{
    public static void main(String args[])
    {
        ArrayList<StudentData> s = new ArrayList<StudentData>();
        s.add(new StudentData("std1", "17ce001", 38, 33, 61, 47));
        s.add(new StudentData("std2", "17ce002", 50, 34, 69, 69));
        s.add(new StudentData("std3", "17ce003", 61, 46, 43, 69));
        s.add(new StudentData("std4", "17ce004", 60, 61, 49, 61));
        s.add(new StudentData("std5", "17ce005", 58, 44, 58, 36));
        s.add(new StudentData("std6", "17ce006", 53, 69, 45, 54));
        s.add(new StudentData("std7", "17ce007", 50, 39, 68, 62));
        s.add(new StudentData("std8", "17ce008", 67, 44, 54, 49));
        s.add(new StudentData("std9", "17ce009", 52, 67, 52, 67));
        s.add(new StudentData("std10", "17ce0010", 66, 34, 58, 63));
        s.add(new StudentData("std11", "17ce0011", 70, 45, 69, 41));

        int max=0;
        for(StudentData d : s)
        {
            d.total = (d.ada+d.se+d.oop+d.de);
            
            if(max<d.total)
            {
                max=d.total;
            }
            // System.out.println(d.total);
        }

        for(StudentData d:s)
        {
            d.pr = (double)d.total*100/max;
        }

        System.out.println("NAME  |   ROLLNO  |   OOP  |   ADA  |   SE  |   DE   |   TOTAL  |   PR");
        System.out.println("-----------------------------------------------------------------------------");
        
        for(StudentData d : s)
        {
            System.out.println(d.name+"  |  "+d.rollno+"  |   "+d.oop+"   |   "+d.ada+"   |   "+d.se+"  |   "+d.de+"   |    "+d.total+"   |   "+String.format("%.2f", d.pr)+ " PR");
        }
    }
}