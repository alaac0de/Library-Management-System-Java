// كلاس مركزي يربط BookList, MemberList, BorrowQueue, ReturnStack
public class LibrarySystem {
    BookList books;
    MemberList members;
    BorrowQueue borrowQueue;
    ReturnStack returnStack;
    int nextReturnId; // لتوليد أرقام اذن الإرجاع

    public LibrarySystem() {
        books = new BookList();//ينشئ قائمة كتب فارغة 
        members = new MemberList();//ينشئ قائمة اعضاء فارغة 
        borrowQueue = new BorrowQueue();//ينشئ طابور استعارة فارغ 
        returnStack = new ReturnStack();//ينشئ مكدس ارجاع فارغ 
        nextReturnId = 1;
    }

    // محاولة إضافة طلب استعارة: يتحقق من توفر الكتاب وحد أقصى العضو
    public boolean borrowBookRequest(int memberId, int bookId, String date) {
        // البحث عن العضو والكتاب
        MemberNode member = members.searchMember(memberId); //  هذه الدالة في MemberList
        BookNode book = books.getBookById(bookId);          // هذه الدالة في BookList

        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        if (!book.available) {
            System.out.println("Book is not available.");
            return false;
        }

        if (member.borrowedCount >= 5) {
            System.out.println("Member reached borrow limit (5).");
            return false;
        }

        // كل الشروط صحيحة: نضيف الطلب إلى الطابور ونغير حالة الكتاب ونزيد عداد العضو
        borrowQueue.enqueue(memberId, bookId, date);
        book.available = false;
        member.borrowedCount++;
        book.borrowedBy = memberId; //**********************************************************************
        System.out.println("Borrow request added and book marked as borrowed.");
        return true;
    }

    // معالجة إرجاع: نضيف سجل في المكدس ونغيّر حالة الكتاب وننقص عداد العضو
    public boolean returnBook(int memberId, int bookId, String date) {
        MemberNode member = members.searchMember(memberId);
        BookNode book = books.getBookById(bookId);

        if (member == null) {
            System.out.println("Member not found.");
            return false;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return false;
        }

        // إذا كان الكتاب مسبقاً متاح، ربما خطأ، لكن سنقبل الإرجاع كأمان
        if (book.available) {
            System.out.println("Warning: Book already marked as available.");
        }
        if (book.borrowedBy != memberId) { //******************************************************
    System.out.println("Error: This book was borrowed by another member!");
    return false;
}
        

        // أضف سجل الإرجاع إلى المكدس
        returnStack.push(nextReturnId++, memberId, bookId, date);

        // عدّل حالة الكتاب والعضو
        book.available = true;
        book.borrowedBy = 0;
        if (member.borrowedCount > 0) member.borrowedCount--;

        System.out.println("Return recorded and book marked as available.");
        return true;
    }

    // عرض طلبات الطابور
    public void displayBorrowRequests() {
        borrowQueue.displayQueue();
    }

    // عرض آخر 5 سجلات الارجاع
    public void displayLast5Returns() {
        returnStack.displayLast5();
    }

    // دوال مساعدة لعرض الكتب والأعضاء (تعتمد على دوال في BookList/MemberList)
    public void displayAllBooks() {
        books.displayAll();
    }

    public void displayAllMembers() {
        members.displayMembers();
    }
}
