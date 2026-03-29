class Book {

    int id;
    String title;
    String author;
    boolean issued;

    Book(int id, String title, String author, boolean issued) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = issued;
    }

    public String toFileString() {
        return id + "," + title + "," + author + "," + issued;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Issued: " + issued);
        System.out.println("---------------------");
    }
}