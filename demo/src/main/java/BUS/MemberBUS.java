package BUS;

import java.util.List;

import DAL.MemberDAL;
import DAL.IDAL.IMemberDAL;
import Entity.Member;

public class MemberBUS {
    private IMemberDAL memberDAL;

    public MemberBUS () {
        this.memberDAL = new MemberDAL();
    }

    public boolean addMember(Member member) { // test, done
        return ((MemberDAL) this.memberDAL).insertObject(member);
    }

    public boolean updateMember(Member member) { // test, done
        return ((MemberDAL) this.memberDAL).updateObject(member);
    }

    public boolean removeMember(Long maTV) { // test, done
        return ((MemberDAL) this.memberDAL).removeObject(maTV);
    }

    public Member getAMemberWithID(Long maTV) { // test, done
        return ((MemberDAL) this.memberDAL).getAnObjectByID(maTV);
    }

    public List<Member> getAllMembers() { // test, done
        return ((MemberDAL) this.memberDAL).getAllMembers();
    }

    // khoa, nganh, khoa'
    public boolean deleteMembersByConditions(String khoa, String nganh, String maTVSubstring) {
        return ((MemberDAL) this.memberDAL).deleteMembersByConditions(khoa, nganh, maTVSubstring);
    }

    public void addManyMembers (List<Member> members) {
        for (Member member:members) {
            addMember(member);
        }
    }

    public static void main(String[] args) {
        // IMemberDAL dal = null;
        MemberBUS bus = new MemberBUS();
        bus.deleteMembersByConditions("abc", "abc", "23");
        // System.out.println(member.getKhoa());
        // bus.removeMember(Long.valueOf("1120330231"));
        List<Member> members = bus.getAllMembers();
        for (Member mem:members){
            System.out.println(mem.getHoTen());
        }
        // Hibernate: 
    }

}
