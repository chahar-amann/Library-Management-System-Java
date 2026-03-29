import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        library.loadFromFile();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nLibrary Menu");
            System.out.println("1 Add Book");
            System.out.println("2 Display Books");
            System.out.println("3 Search Book");
            System.out.println("4 Issue Book");
            System.out.println("5 Return Book");
            System.out.println("6 Sort Books");
            System.out.println("7 Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(id, title, author, false));
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:

                    System.out.print("Enter ID: ");
                    int search = sc.nextInt();

                    library.searchBook(search);
                    break;

                case 4:

                    System.out.print("Enter ID: ");
                    int issue = sc.nextInt();

                    library.issueBook(issue);
                    break;

                case 5:

                    System.out.print("Enter ID: ");
                    int ret = sc.nextInt();

                    library.returnBook(ret);
                    break;

                case 6:
                    library.sortBooks();
                    break;

                case 7:
                    System.out.println("Program ended.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}