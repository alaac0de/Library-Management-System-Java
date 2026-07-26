public class BookList {
    BookNode head;

    // إضافة كتاب جديد
    public void addBook(int id, String title, String author) {
        BookNode newNode = new BookNode(id, title, author);
        if (head == null) {
            head = newNode;
            return;
        }
        BookNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    // تعديل كتاب
    public boolean updateBook(int id, String newTitle, String newAuthor, boolean newAvailable) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.title = newTitle;
                temp.author = newAuthor;
                temp.available = newAvailable;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // حذف كتاب
    public boolean deleteBook(int id) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                if (temp.prev != null) temp.prev.next = temp.next;
                else head = temp.next; // حذف الرأس
                if (temp.next != null) temp.next.prev = temp.prev;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // البحث بالعنوان أو المؤلف
    public BookNode search(String key) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(key) || temp.author.equalsIgnoreCase(key))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // عرض كل الكتب
    public void displayAll() {
        BookNode temp = head;
        while (temp != null) {
            System.out.println(temp.bookId + " - " + temp.title + " - " + temp.author +
                    " (" + (temp.available ? "Available" : "Borrowed") + ")");
            temp = temp.next;
        }
    }

    // عرض الكتب المتاحة فقط
    public void displayAvailable() {
        BookNode temp = head;
        while (temp != null) {
            if (temp.available)
                System.out.println(temp.bookId + " - " + temp.title + " - " + temp.author);
            temp = temp.next;
        }
    }

    // فرز الكتب حسب العنوان
    public void sortByTitle() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            BookNode temp = head;
            while (temp.next != null) {
                if (temp.title.compareToIgnoreCase(temp.next.title) > 0) {
                    swapData(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
    }

    // فرز الكتب حسب المؤلف
    public void sortByAuthor() {
        if (head == null) return;
        boolean swapped;
        do {
            swapped = false;
            BookNode temp = head;
            while (temp.next != null) {
                if (temp.author.compareToIgnoreCase(temp.next.author) > 0) {
                    swapData(temp, temp.next);
                    swapped = true;
                }
                temp = temp.next;
            }
        } while (swapped);
    }

    // دالة مساعدة لتبديل بيانات العقدتين
    private void swapData(BookNode a, BookNode b) {
        int id = a.bookId;
        String title = a.title;
        String author = a.author;
        boolean available = a.available;

        a.bookId = b.bookId;
        a.title = b.title;
        a.author = b.author;
        a.available = b.available;

        b.bookId = id;
        b.title = title;
        b.author = author;
        b.available = available;
    }

    // يعيد BookNode حسب id أو null اذا لم يوجد
    public BookNode getBookById(int id) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

}
