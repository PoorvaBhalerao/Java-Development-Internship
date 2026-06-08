//  Library Management System

import java.lang.*;             
import java.util.*;             

class Book
{
    private int bookId;
    private String title;
    private String author;
    private boolean availability;

    // parameterised constructor
    public Book(int bookId, String title, String author, boolean availability)
    {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.availability = availability;
    }

    //getters
    public int getId()
    {
        return this.bookId;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public boolean isAvailable()
    {
        return this.availability;
    }

    // setter for availabilty
    public void setAvailability(boolean availability)
    {
        this.availability = availability;
    }

    // overriding toString method
    @Override
    public String toString()
    {
        return "Book ID: " + bookId +
               ", Title: " + title +
               ", Author: " + author +
               ", Available: " + availability+"\n";
    }

}   // end of Book class


class Library
{
    private HashMap<Integer, Book> books;

    public Library()
    {
        books = new HashMap<>();
    }

    public void AddNewBook(Scanner sobj)
    {
        System.out.print("Enter Book ID : ");
        int id = sobj.nextInt();
        
        if(books.containsKey(id))                                   // Validation of Id
        {
            System.out.println("Book id already exits\n");
            return;
        }

        if(id <= 0)                                                 // validation for Id
        {
            System.out.println("Invalid Book ID\n");
            return;
        }
        sobj.nextLine();

        System.out.print("Enter Book Title : ");
        String title = sobj.nextLine();

        if(title.trim().isEmpty())                                  // validation for title
        {
            System.out.println("Title cannot be empty");
            return;
        }

        System.out.print("Enter Author Name : ");
        String author = sobj.nextLine();

        if(author.trim().isEmpty())                                 // valdation for author
        {
            System.out.println("Author cannot be empty\n");
            return;
        }

        Book b = new Book(id, title, author, true);

        books.put(id, b);

        System.out.println("Book Added Successfully\n");
    }

    public void ViewAllBooks()
    {
        for(Book b : books.values())
        {
            System.out.println(b);
        }
    }

    public void SearchById(int bookId)
    {
        Book book = books.get(bookId);

        if(book != null)
        {
            System.out.println(book);
        }
        else
        {
            System.out.println("Book not found\n");
        }
    }

    public void SearchByTitle(String title)
    {
        boolean found = false;
        for(Book b: books.values())
        {
            if(b.getTitle().equalsIgnoreCase(title))
            {
                System.out.println(b);
                found = true;
                break;
            }
        }

        if(!found)
        {
            System.out.println("Book not Found\n");

        }
    }

    public void IssueBook(int bookId)
    {
        Book b = books.get(bookId);

        if(b != null && b.isAvailable())
        {
            b.setAvailability(false);
            System.out.println("Book Issued Successfully\n");
        }
        else
        {
            System.out.println("Book Not Available\n");
        }
    }

    public void ReturnBook(int bookId)
    {
        Book b = books.get(bookId);

        if(b == null)
        {
            System.out.println("Book not found");
        }
        else if(b.isAvailable())                                // validation for if book is not issued then there is no returnng of that book should happen
        {
            System.out.println("Book is not issued");
        }
        else
        {
            b.setAvailability(true);
            System.out.println("Book Returned Successfully");
        }
    }

    public void RemoveBook(int bookId)
    {
       Book b = books.get(bookId);

        if(b != null && b.isAvailable())
        {
            books.remove(bookId);
            System.out.println("Book Removed Successfully\n");
        }
        else
        {
            System.out.println("Book not Found\n");
        }
       
    }

    public void Exit()
    {
        System.out.println("----------------Thank you for using our Application----------------");
        System.exit(0);
    }

}   // end of class Library


class LibraryManagement
{
    public static void main(String Arg[])
    {
        int iChoice = 0;
        Scanner sobj = new Scanner(System.in);
        Library lobj = new Library();

        System.out.println("------------------------------------------------------------------------");
        System.out.println("---------------Welcome to Library Management System---------------------");
        System.out.println("------------------------------------------------------------------------");

        while(true)
        {
            System.out.println("1. Add a new Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by Id");
            System.out.println("4. Search Book by Title");
            System.out.println("5. Issue a Book");
            System.out.println("6. Return a Book");
            System.out.println("7. Remove a Book");
            System.out.println("8. Exit the Application");

            System.out.println("Please select option: ");
            
            if(!sobj.hasNextInt())                                            // validation for menu
            {
                System.out.println("Please enter a valid numeric choice");
                sobj.next();
                continue;
            }

            iChoice = sobj.nextInt();

            if(iChoice < 1 || iChoice > 8)                                    // validation for menu
            {
                System.out.println("Please enter a choice between 1 and 8");
                continue;
            }
            
            switch(iChoice)
            {
                case 1:
                    lobj.AddNewBook(sobj);
                    break;

                case 2:
                    lobj.ViewAllBooks();
                    break;

                case 3:
                    System.out.println("Enter bookId: ");
                    int id = sobj.nextInt();
                    lobj.SearchById(id);
                    break;

                case 4:
                    sobj.nextLine();
                    System.out.println("Enter book title: ");
                    String title = sobj.nextLine();
                    lobj.SearchByTitle(title);
                    break;

                case 5:
                    System.out.println("Enter bookId: ");
                    id = sobj.nextInt();
                    lobj.IssueBook(id);
                    break;

                case 6:
                    System.out.println("Enter bookId: ");
                    id = sobj.nextInt();
                    lobj.ReturnBook(id);
                    break;

                case 7:
                    System.out.println("Enter bookId: ");
                    id = sobj.nextInt();
                    lobj.RemoveBook(id);
                    break;

                case 8:
                    lobj.Exit();

                    break;

                default:
                    System.out.println("Invalid choice Entered");
                    break;

            }   // end of switch
        }   // end of while
    }   // end of main method
}   // end of LibraryManagementMain class