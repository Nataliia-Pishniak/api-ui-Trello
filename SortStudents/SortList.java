package preparation.SortStudents;



import java.util.Scanner;
import java.util.Arrays;


public class SortList {
public static void main(String[] args)

{

    System.out.println("Welcome to the Student Scores Application."+"\n");
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of students to enter: ");

    int numberofStudent = sc.nextInt();

    Student[] s = new Student[numberofStudent];

    int y=0;
    for( int i=1; i<=numberofStudent; i++)
    {
        System.out.println("");
        String StudentFirstName = Validator.firstName(sc , "Student " + i + " First name: ");
        String studentLastName = Validator.firstName(sc , "Student " + i + " Last  name: ");
        int studentScore= Validator.vScore(sc,"Student " + i + " score : ");

        //stores student information in an array
        s[y] = new Student(StudentFirstName , studentLastName , studentScore);

        y=y+1;
    }


    System.out.println("");

    Arrays.sort(s,0,numberofStudent);
    for(Student i: s)

        System.out.println(i.getlastName()+", "+i.getfirstName()+": "+i.getScore());


}


}