package DAL.IDAL;

import java.util.List;

import Entity.Member;

public interface IMemberDAL {
    public List<Member> getAllMembers();
    public boolean deleteMembersByConditions(String khoa, String nganh, String maTVSubstring);
}
