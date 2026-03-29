import java.util.*;
import java.io.*;

class Library {

    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
        saveToFile();
        System.out.println("Book added.");
    }

    void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books) {
            b.display();
        }
    }

    void searchBook(int id) {

        for (Book b : books) {

            if (b.id == id) {
                b.display();
                return;
            }
        }

        System.out.println("Book not found.");
    }

    void issueBook(int id) {

        for (Book b : books) {

            if (b.id == id) {

                if (!b.issued) {
                    b.issued = true;
                    saveToFile();
                    System.out.println("Book issued.");
                } else {
                    System.out.println("Already issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    void returnBook(int id) {

        for (Book b : books) {

            if (b.id == id) {

                if (b.issued) {
                    b.issued = false;
                    saveToFile();
                    System.out.println("Book returned.");
                } else {
                    System.out.println("Book was not issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    void sortBooks() {

        books.sort((a, b) -> a.title.compareToIgnoreCase(b.title));

        System.out.println("Books sorted by title.");
    }

    void saveToFile() {

        try {

            FileWriter fw = new FileWriter("books.txt");

            for (Book b : books) {
                fw.write(b.toFileString() + "\n");
            }

            fw.close();

        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

    void loadFromFile() {

        try {

            File file = new File("books.txt");

            if (!file.exists())
                return;

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String line = sc.nextLine();

                String[] data = line.split(",");

                books.add(
                        new Book(
                                Integer.parseInt(data[0]),
                                data[1],
                                data[2],
                                Boolean.parseBoolean(data[3])));
            }

            sc.close();

        } catch (Exception e) {
            System.out.println("Error loading file.");
        }
    }
}