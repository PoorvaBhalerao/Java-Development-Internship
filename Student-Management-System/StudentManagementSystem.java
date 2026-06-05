// Student Management System

import java.lang.*;                     // for Exception     
import java.util.ArrayList;
import java.util.Scanner;           

class Student
{
    public int id;
    public String name;
    public int age;
    public Grade grade;
    public String email;

    // parameterised constructor to initialise students details
    public Student(int id, String name, int age, Grade grade, String email)
    {
        // Validation for name .. ..name should not be NULL
        if(name == null || name.trim().length() == 0)
        {
            System.out.println("Invalid Name");
            return;
        }

        // validation for age.. Age should be in range of 18 to 30
        if(age < 18 || age > 30)
        {
            System.out.println("Invalid Age");
            return;
        }

        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.email = email;
    }

    // Getters to retrive information later
    public int getid()
    {
        return id;
    }

    public String name()
    {
        return name;
    }
    
    public int getage()
    {
        return age;
    }
    
    public Grade getgrade()
    {
        return grade;
    }
    
    public String getemail()
    {
        return email;
    }

    //Setters to update information

    public void setid(int id)
    {
        this.id = id;
    }

    public void setname(String name)
    {
        this.name = name;
    }
    
    public void setage(int age)
    {
        this.age = age;
    }
    
    public void setgrade(Grade grade)
    {
        this.grade = grade;
    }
    
    public void setemail(String email)
    {
        this.email = email;
    }


    // Override toString to display data easily
    @Override
    public String toString()
    {
        return "Student[ ID: "+id+" , Name: "+name+" , Age: "+age+ ", Grade: "+grade+" , Email: "+email+ "]";
    }
}


class StudentManager
{
    // CRUD methods
    public void AddStudent(ArrayList<Student> list)
    {
        Scanner sobj= new Scanner(System.in);

        try
        {
            System.out.println("Enter id: ");

            while(!sobj.hasNextInt())
            {
                System.out.println("Please enter a valid id number:");
                sobj.next();
            }

            int id = sobj.nextInt();
            sobj.nextLine();

            for(Student s : list)
            {
                if(s.getid() == id)
                {
                    System.out.println("Student ID already exists");
                    return;
                }
            }

            System.out.println("Enter Name: ");
            String name = sobj.nextLine(); 
            
            System.out.println("Enter Age: ");
            int age = sobj.nextInt();
            sobj.nextLine();                                        // consumes error

            System.out.println("Enter Grade(A/B/C/D/E/F): ");

            Grade grade ;
            
            try
            {
                grade = Grade.valueOf( sobj.nextLine().toUpperCase());
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(
                    "Invalid Grade! Please enter A, B, C, D or F.");
                return;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Grade! Please enter A, B, C, D or F.");
                return;
            }

            System.out.println("Enter Email: ");
            String email = sobj.nextLine();

            if(name.trim().isEmpty())
            {
                System.out.println("Invalid Input");
                System.out.println("Record not Added");
                return;
            }

            if(age < 18 || age > 30)
            {
                System.out.println("Invlaid Age entered");
                System.out.println("Record not Added");
                return;
            }
            
            Student s = new Student(id, name, age, grade, email);

            list.add(s);

            System.out.println("Student Successfully Added");

        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Invalid Input Entered");
        }        
    }

    public void ViewAllStudents(ArrayList<Student> list)
    {
        for(Student s: list)
        {
            System.out.println(s);
        }
    }

    public void SearchById(ArrayList<Student> list, int id)
    {
        for(Student s: list)
        {
            if(s.getid() == id)
            {
                System.out.println(s);
                return;
            }
        }

        System.out.println("Student Not Found");

    }

    public void Update(ArrayList<Student> list, int id)
    {
        Scanner sobj = new Scanner(System.in);

        try
        {
            for(Student s: list)
            {
                if(s.getid() == id)
                {
                    System.out.println("Enter New Name: ");
                    String name = sobj.nextLine(); 

                    System.out.println("Enter New Age: ");
                    int age = sobj.nextInt();
                    sobj.nextLine();

                    System.out.println("Enter New Grade (A/B/C/D/E/F): ");
                    Grade grade ;
                    try
                    {
                        grade = Grade.valueOf(sobj.nextLine().toUpperCase());
                    }
                    catch(IllegalArgumentException e)
                    {
                        System.out.println(
                            "Invalid Grade! Please enter A, B, C, D or F.");
                        return;
                    }
                    catch(Exception e)
                    {
                        System.out.println(
                            "Invalid Grade! Please enter A, B, C, D or F.");
                        return;
                    }
                
                    System.out.println("Enter New Email: ");
                    String email = sobj.nextLine();

                    if(name.trim().isEmpty())
                    {
                        System.out.println("Invalid Input");
                        System.out.println("Record not updated");
                        return;
                    }

                    if(age < 18 || age > 30)
                    {
                        System.out.println("Invlaid Age entered");
                        System.out.println("Record not updated");
                        return;
                    }

                    s.setname(name);
                    s.setage(age);
                    s.setgrade(grade);
                    s.setemail(email);

                    System.out.println("Student Details Updated Successfully");
                    System.out.println(s);
                    return;
                }
            }

            System.out.println("Student not Found");
        }
        catch(java.util.InputMismatchException e)
        {
            System.out.println("Age must be a valid number");
        }
        catch(IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Invalid Input Entered");
        }
        
    }


    public void Delete(ArrayList<Student> list, int id)
    {
        for(int i = 0; i< list.size(); i++)
        {
            if(list.get(i).getid() == id)
            {
                list.remove(i);
                System.out.println("Student Deleted Successfully");
                return;
            }
        }

        System.out.println("Student not Found");
    }
}
    

class StudentManagementSystem
{
    public static void main(String Arg[])
    {
        int iChoice = 0;

        Scanner sobj = new Scanner(System.in);

        ArrayList<Student> student = new ArrayList<>();

        StudentManager manager = new StudentManager();

        while (true) 
        { 
            System.out.println("-------------------------------------------------------------");
            System.out.println("--------------Student Management System----------------------");
            System.out.println("-------------------------------------------------------------");
            System.out.println();
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student details");
            System.out.println("5. Delete Student details");
            System.out.println("6. Exit");

            System.out.println("Enter your choice(from 1 to 6): ");
            iChoice = sobj.nextInt();

            switch(iChoice)
            {
                case 1:
                    manager.AddStudent(student);
                    break;

                case 2:
                    manager.ViewAllStudents(student);
                    break;

                case 3:
                    System.out.println("Enter Id: ");
                    int id = sobj.nextInt();
                    manager.SearchById(student, id);
                    break;

                case 4:
                    System.out.println("Enter Id: ");
                    id = sobj.nextInt();
                    manager.Update(student, id);
                    break;
                    
                case 5:
                    System.out.println("Enter Id: ");
                    id = sobj.nextInt();
                    manager.Delete(student, id);
                    break;

                case 6:
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("------------Thank you for using our Application--------------");
                    System.out.println("-------------------------------------------------------------");
                    System.exit(0);
                    break;
                
                default:
                    System.out.println("Invalid Choice");
                    break;
            
            }
        }       

    }
}
