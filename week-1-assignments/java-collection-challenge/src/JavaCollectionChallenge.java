// Java Collection Challenge

import java.util.*;

//-----------------------------------------------------------------------------------------------------------------
//                                              ArrayList
//-----------------------------------------------------------------------------------------------------------------

class ArrayListX
{
    private ArrayList<String> books = new ArrayList<>();
    
    public void mainMenu()
    {
        Scanner sobj = new Scanner(System.in);
        
        int iChoice = 0;
        
        System.out.println("\n----- BOOK MANAGEMENT -----");

        do
        {
            
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. Search Book");
            System.out.println("5. Display Books");
            System.out.println("6. Back");

            try
            {
                System.out.print("Please select option : ");
                iChoice = sobj.nextInt();
                sobj.nextLine();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid choice. Please enter a number.");
                sobj.nextLine();
                continue;
            }

            if(iChoice < 1 || iChoice > 6)                                    // validation for menu
            {
                System.out.println("Please enter a choice between 1 and 6");
                continue;
            }

            switch(iChoice)
            {
                case 1:
                    System.out.println("Enter Name of Book: ");
                    String book = sobj.nextLine();
                    books.add(book);

                    System.out.println("Book Successfully Added\n");
                    break;

                case 2:
                    System.out.println("Enter Name of Book: ");
                    book = sobj.nextLine();

                    if(books.remove(book))
                    {
                        System.out.println("Book successfully removed\n");
                    }
                    else
                    {
                        System.out.println("Book not Found\n");
                    }
                    break;

                case 3:
                    System.out.println("Enter Name of old book: ");
                    String oldBook = sobj.nextLine();

                    int index = books.indexOf(oldBook);

                    if(index != -1)
                    {
                        System.out.println("Enter new Name: ");
                        String newBook = sobj.nextLine();

                        books.set(index, newBook);

                        System.out.println("Book successfully updated\n");
                    }
                    else
                    {
                        System.out.println("Book not found\n");
                    }
                    break;

                case 4:
                    System.out.println("Enter Name of Book: ");
                    book = sobj.nextLine();

                    if(books.contains(book))
                    {
                        System.out.println("Book found\n");
                    }
                    else
                    {
                        System.out.println("Book not found\n");
                    }

                    break;

                case 5:
                    System.out.println("Name of all Books are: ");

                    for(String b: books)
                    {
                        System.out.println(b);
                    }
                    break;      
                    
                case 6:
                    return;

                default:
                    System.out.println("Invalid choice\n");
                    break;

            }   // end of switch

        } while(iChoice != 0);
    
    }   // end of mainMenu method
}   // end of ArrayListX class

//-----------------------------------------------------------------------------------------------------------------
//                                              HashMap
//-----------------------------------------------------------------------------------------------------------------

class HashMapX
{
    private HashMap<Integer, Integer> studentMarks = new HashMap<>();

    public void mainMenu()
    {
        int iChoice = 0;
        Scanner sobj = new Scanner(System.in);

        do
        {
            System.out.println("\n----- STUDENT MARKS MANAGEMENT -----");
            System.out.println("1. Add Student");
            System.out.println("2. Get Marks");
            System.out.println("3. Update Marks");
            System.out.println("4. Check Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Back");

            try
            {
                System.out.print("Please select option : ");
                iChoice = sobj.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid choice. Please enter a number.");
                sobj.nextLine();
                continue;
            }

            if(iChoice < 1 || iChoice > 6)                                    // validation for menu
            {
                System.out.println("Please enter a choice between 1 and 6");
                continue;
            }

            switch(iChoice)
            {
                case 1:
                    System.out.println("Enter Student Id: ");
                    int id = sobj.nextInt();

                    if(studentMarks.containsKey(id))
                    {
                        System.out.println("Id already exits\n");
                    }
                    else
                    {
                        System.out.println("Enter Student Marks: ");
                        int marks = sobj.nextInt();

                        studentMarks.put(id, marks);

                        System.out.println("Student Added Successfully\n");
                    }
                    break;

                case 2:
                    System.out.println("Enter Student Id: ");
                    id = sobj.nextInt();

                    if(studentMarks.containsKey(id))
                    {
                        System.out.println("Marks :"+studentMarks.get(id));
                    }
                    else
                    {
                        System.out.println("Student not Found\n");
                    }
                    break;

                case 3:
                    System.out.println("Enter Student Id: ");
                    id = sobj.nextInt();

                    if(studentMarks.containsKey(id))
                    {
                        System.out.print("Enter updated marks: ");
                        int updatedmarks = sobj.nextInt();

                        studentMarks.put(id, updatedmarks);

                        System.out.println("Marks updated successfully\n");
                    }
                    break;

                case 4:
                    System.out.println("Enter Student Id: ");
                    id = sobj.nextInt();

                    if(studentMarks.containsKey(id))
                    {
                        System.out.println("Student Exists");
                    }
                    else
                    {
                        System.out.println("Student Not Found");
                    }
                    break;

                case 5:
                    System.out.println("\nStudents Record: ");

                    for(Map.Entry<Integer, Integer> entry: studentMarks.entrySet())
                    {
                        System.out.println("ID: "+entry.getKey()+"\tMarks: "+entry.getValue());
                    }

                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice\n");
                    break;
                
            }   // end of switch

        }while(iChoice != 0);

    }   // end of mainMenu method
    
}   // end of HashMapX class

//-----------------------------------------------------------------------------------------------------------------
//                                              Queue
//-----------------------------------------------------------------------------------------------------------------

class QueueX
{
    private Queue<String> customerQueue = new LinkedList<>();
    
    public void mainMenu()
    {   
        int iChoice = 0;
        Scanner sobj = new Scanner(System.in);

        do
        {
            System.out.println("\n----- CUSTOMER QUEUE -----");
            System.out.println("1. Add Customer");
            System.out.println("2. Serve Customer");
            System.out.println("3. Peek Customer");
            System.out.println("4. Display Queue");
            System.out.println("5. Back");

            try
            {
                System.out.print("Please select option : ");
                iChoice = sobj.nextInt();
                sobj.nextLine();

            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid choice. Please enter a number.");
                sobj.nextLine();
                continue;
            }

            if(iChoice < 1 || iChoice > 5)                                    // validation for menu
            {
                System.out.println("Please enter a choice between 1 and 5");
                continue;
            }

            switch(iChoice)
            {
                case 1:
                    System.out.println("Enter Name of Customer: ");
                    String name = sobj.nextLine();

                    customerQueue.add(name);
                    System.out.println("Customer Successfully added\n");

                    break;

                case 2:

                    if(customerQueue.isEmpty())
                    {
                        System.out.println("Queue is Empty\n");
                    }
                    else
                    {
                        System.out.println("Served customer is: "+customerQueue.poll());
                    }

                    break;

                case 3:

                    if(customerQueue.isEmpty())
                    {
                        System.out.println("Queue is Empty\n");
                    }
                    else
                    {
                        System.out.println("Next customer is: "+customerQueue.peek());
                    }

                    break;

                case 4:
                    System.out.println("\nQueue Contents:");

                    for(String customer : customerQueue)
                    {
                        System.out.println(customer);
                    }
                    break;

                case 5:
                    return;

            }

        } while(iChoice!= 0);

    }   // end of mainMenu method
    
    
}   // end of QueueX class

//-----------------------------------------------------------------------------------------------------------------
//                                              Main class
//-----------------------------------------------------------------------------------------------------------------

class JavaCollectionChallenge
{
    public static void main(String a[])
    {
        int iChoice = 0;
        Scanner sobj = new Scanner(System.in);
        ArrayListX aobj = new ArrayListX();
        HashMapX hobj = new HashMapX();
        QueueX qobj = new QueueX();

        System.out.println("------------------------------------------------------------------------");
        System.out.println("---------------Welcome to Java Collection Challenge---------------------");
        System.out.println("------------------------------------------------------------------------");

        while(true)
        {
            System.out.println("1. ArrayList Operations (Books)");
            System.out.println("2. HashMap Operations (Student Marks)");
            System.out.println("3. Queue Operations (Customer Tokens)");
            System.out.println("4. Exit");
            
            try
            {
                System.out.print("Please select option : ");
                iChoice = sobj.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Invalid choice. Please enter a number.");
                sobj.nextLine();
                continue;
            }

            if(iChoice < 1 || iChoice > 4)                                    // validation for menu
            {
                System.out.println("Please enter a choice between 1 and 4");
                continue;
            }
            
            switch(iChoice)
            {
                case 1:
                    aobj.mainMenu();
                    break;

                case 2:
                    hobj.mainMenu();
                    break;

                case 3:
                    qobj.mainMenu();
                    break;

                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice Entered");
                    break;
            }   // end of switch
        }   // end of while

    }   // end of main method
}   // end of javacollectionchallenge class
