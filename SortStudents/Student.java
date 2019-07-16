package preparation.SortStudents;

public class Student implements Comparable

{

    public String firstName="";
    public String lastName="";
    public int score=0;

    public Student(String firstName, String lastName, int score)

    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }


    @Override
    public int compareTo(Object t)
    {
        Student s =(Student) t;

        if(lastName.equals(s.lastName))
        {
            return firstName.compareToIgnoreCase(s.firstName);
        }
        return lastName.compareToIgnoreCase(s.lastName);

    }


    public String getfirstName()
    {
        return firstName;
    }


    public String getlastName()
    {
        return lastName;
    }

    public int getScore()
    {
        return score;
    }

}