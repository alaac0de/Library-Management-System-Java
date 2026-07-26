public class BookNode {
    int bookId;
    String title;
    String author;
    boolean available = true; // true = available, false = borrowed
    int borrowedBy;  // ID العضو الذي استعاره – 0 يعني لا أحد
    BookNode prev;
    BookNode next;

    public BookNode(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.borrowedBy = 0; //**************
    }
}

