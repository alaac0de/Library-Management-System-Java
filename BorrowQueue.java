// طابور بسيط للطلبات باستخدام قائمة مرتبطة أحادية
public class BorrowQueue {
    BorrowRequestNode front; // أمام الطابور (أول طلب)
    BorrowRequestNode rear;  // آخر الطابور (آخر طلب)

    public BorrowQueue() {
        front = rear = null;
    }

    // إضافة طلب إلى الطابور (enqueue)
    public void enqueue(int memberId, int bookId, String date) {
        BorrowRequestNode node = new BorrowRequestNode(memberId, bookId, date);
        if (isEmpty()) { // الطابور فارغ
            front = rear = node;
            return;
        }
        rear.next = node;
        rear = node;
    }

    // إزالة أول طلب من الطابور (dequeue) وإرجاعه
    public BorrowRequestNode dequeue() {
        if (isEmpty()) return null; // الطابور فارغ
        BorrowRequestNode node = front;
        front = front.next;
        if (isEmpty()) rear = null; // أصبح الطابور فارغاً
        node.next = null;
        return node;
    }

    // عرض جميع الطلبات الحالية (من الأمام إلى الخلف)
    public void displayQueue() {
        BorrowRequestNode temp = front;
        while (temp != null) {
            System.out.println("Member: " + temp.memberId + " | Book: " + temp.bookId + " | Date: " + temp.date);
            temp = temp.next;
        }
    }

    // تحقق إذا الطابور فارغ
    public boolean isEmpty() {
        return front == null;
    }
}
