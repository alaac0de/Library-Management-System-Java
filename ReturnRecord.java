// عنصر في المكدس يمثل سجل إرجاع واحد
public class ReturnRecord {
    int returnId; // رقم اذن الارجاع (يمكن أن نولده بالتسلسل)
    int memberId;
    int bookId;
    String date;
    ReturnRecord next; // مؤشر للمكدس (رأس المكدس)

    public ReturnRecord(int returnId, int memberId, int bookId, String date) {
        this.returnId = returnId;
        this.memberId = memberId;
        this.bookId = bookId;
        this.date = date;
        this.next = null;
    }
}
