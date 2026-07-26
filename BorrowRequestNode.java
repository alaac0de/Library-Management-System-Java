// عقدة تمثل طلب استعارة واحد
public class BorrowRequestNode {
    int memberId;
    int bookId;
    String date; // يمكن أن تكون "2025-12-03" أو أي نص
    BorrowRequestNode next;

    public BorrowRequestNode(int memberId, int bookId, String date) {
        this.memberId = memberId;
        this.bookId = bookId;
        this.date = date;
        this.next = null;
    }
}
 
