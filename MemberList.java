public class MemberList {
    MemberNode head;

    // إضافة عضو جديد
    public void addMember(int id, String name) {
        MemberNode newNode = new MemberNode(id, name);

        if (head == null) {
            head = newNode;
            return;
        }

        MemberNode temp = head;
        while (temp.next != null) temp = temp.next;

        temp.next = newNode;
    }

    // حذف عضو
    public boolean deleteMember(int id) {
        MemberNode temp = head;
        MemberNode prev = null;

        while (temp != null) {
            if (temp.memberId == id) {

                if (prev == null) head = temp.next;
                else prev.next = temp.next;

                return true;
            }
            prev = temp;
            temp = temp.next;
        }

        return false;
    }

    // تعديل عضو
    public boolean updateMember(int id, String newName) {
        MemberNode temp = head;

        while (temp != null) {
            if (temp.memberId == id) {
                temp.name = newName;
                return true;
            }
            temp = temp.next;
        }

        return false;
    }



    // عرض كل الأعضاء
    public void displayMembers() {
        MemberNode temp = head;

        while (temp != null) {
            System.out.println(
                    "ID: " + temp.memberId +
                            ", Name: " + temp.name +
                            ", Borrowed: " + temp.borrowedCount
            );
            temp = temp.next;
        }
    }

    // يعيد MemberNode حسب id أو null اذا لم يوجد
    public MemberNode searchMember(int id) {
        MemberNode temp = head;
        while (temp != null) {
            if (temp.memberId == id) return temp;
            temp = temp.next;
        }
        return null;
    }
    
}
