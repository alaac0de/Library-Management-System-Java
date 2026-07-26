public class MemberNode {
 int memberId;
 String name;
int borrowedCount;

 MemberNode next;

 public MemberNode(int id, String name) {
 this.memberId = id;
this.name = name;
 this.borrowedCount = 0; // يبدأ بـ 0
 }
}
