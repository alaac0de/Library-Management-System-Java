// مكدس سجلات الارجاع (LIFO)
public class ReturnStack {
    ReturnRecord top; // قمة المكدس
    int size; // عدد السجلات داخل المكدس

    public ReturnStack() {
        top = null;
        size = 0;
    }

    // دفع سجل جديد إلى القمة (push)
    public void push(int returnId, int memberId, int bookId, String date) {
        ReturnRecord node = new ReturnRecord(returnId, memberId, bookId, date);
        node.next = top;
        top = node;
        size++;
    }

    // إزالة وإرجاع السجل الأعلى (pop)
    public ReturnRecord pop() {
        if (top == null) return null;
        ReturnRecord node = top;
        top = top.next;
        node.next = null;
        size--;
        return node;
    }

    // عرض آخر 5 سجلات من القمة (أو أقل إذا المكدس أقل من 5)
    public void displayLast5() {
        ReturnRecord temp = top;
        int count = 0;
        while (temp != null && count < 5) {
            System.out.println("ReturnID: " + temp.returnId + " | Member: " + temp.memberId + " | Book: " + temp.bookId + " | Date: " + temp.date);
            temp = temp.next;
            count++;
        }
    }

    // عرض كامل المكدس (اختياري)
    public void displayAll() {
        ReturnRecord temp = top;
        while (temp != null) {
            System.out.println("ReturnID: " + temp.returnId + " | Member: " + temp.memberId + " | Book: " + temp.bookId + " | Date: " + temp.date);
            temp = temp.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}
