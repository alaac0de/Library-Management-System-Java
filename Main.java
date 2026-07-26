import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LibrarySystem library = new LibrarySystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display All Books");
            System.out.println("6. Display All Members");
            System.out.println("7. Display Borrow Requests");
            System.out.println("8. Display Last 5 Returns");
            System.out.println("9. Delete Book");
            System.out.println("10. Edit Book");
            System.out.println("11. Delete Member");
            System.out.println("12. Edit Member");
            System.out.println("13. Search Book by Title/Author");
            System.out.println("14. Sort Books by Title");
            System.out.println("15. Sort Books by Author");
            System.out.println("16. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1: // Add Book
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: ");
                    String t = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String a = sc.nextLine();
                    library.books.addBook(bid, t, a);
                    System.out.println("Book Added.");
                    break;

                case 2: // Add Member
                    System.out.print("Enter Member ID: ");
                    int mid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    String n = sc.nextLine();
                    library.members.addMember(mid, n);
                    System.out.println("Member Added.");
                    break;

                case 3: // Borrow
                    System.out.print("Member ID: ");
                    int bm = sc.nextInt();
                    System.out.print("Book ID: ");
                    int bb = sc.nextInt(); sc.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    String d = sc.nextLine();
                    library.borrowBookRequest(bm, bb, d);
                    break;

                case 4: // Return
                    System.out.print("Member ID: ");
                    int rm = sc.nextInt();
                    System.out.print("Book ID: ");
                    int rb = sc.nextInt(); sc.nextLine();
                    System.out.print("Date (YYYY-MM-DD): ");
                    String rd = sc.nextLine();
                    library.returnBook(rm, rb, rd);
                    break;

                case 5: // Display books
                    library.displayAllBooks();
                    break;

                case 6: // Display members
                    library.displayAllMembers();
                    break;

                case 7: // Display queue
                    library.displayBorrowRequests();
                    break;

                case 8: // Display last 5 returns
                    library.displayLast5Returns();
                    break;

                case 9: // Delete Book
                    System.out.print("Enter Book ID to delete: ");
                    int db = sc.nextInt();
                    System.out.println(library.books.deleteBook(db)
                            ? "Book Deleted." : "Book Not Found.");
                    break;
                    case 10: // Edit Book
                    System.out.print("Enter Book ID to edit: ");
                    int ub = sc.nextInt(); sc.nextLine();
                    System.out.print("New Title: ");
                    String nt = sc.nextLine();
                    System.out.print("New Author: ");
                    String na = sc.nextLine();
                    System.out.print("Is Available? (true/false): ");
                    boolean av = sc.nextBoolean();
                    System.out.println(library.books.updateBook(ub, nt, na, av)
                            ? "Book Updated." : "Book Not Found.");
                    break;

                case 11: // Delete member
                    System.out.print("Enter Member ID to delete: ");
                    int dm = sc.nextInt();
                    System.out.println(library.members.deleteMember(dm)
                            ? "Member Deleted." : "Member Not Found.");
                    break;

                case 12: // Edit member
                    System.out.print("Enter Member ID to edit: ");
                    int um = sc.nextInt(); sc.nextLine();
                    System.out.print("New Name: ");
                    String nn = sc.nextLine();
                    System.out.println(library.members.updateMember(um, nn)
                            ? "Member Updated." : "Member Not Found.");
                    break;

                case 13: // Search book
                    System.out.print("Enter Title or Author: ");
                    String key = sc.nextLine();
                    BookNode result = library.books.search(key);
                    if (result != null) {
                        System.out.println("FOUND: " + result.bookId + " - " + result.title + " - " + result.author);
                    } else {
                        System.out.println("Book Not Found.");
                    }
                    break;

                case 14:
                    library.books.sortByTitle();
                    System.out.println("Books sorted by Title.");
                    break;

                case 15:
                    library.books.sortByAuthor();
                    System.out.println("Books sorted by Author.");
                    break;

                case 16:
                    System.out.println("Exiting system...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
