package DAL.IDAL;

import java.util.List;

import Entity.Member;

public interface IMemberDAL {
    public List<Member> getAllMembers();
    public boolean deleteMembersByConditions(String khoa, String nganh, String maTVSubstring);
    public String addMultipleMembers(List<Member> members) throws Exception;
    public boolean updateMemberMaTV(Long oldMaTV, Long newMaTV);
    public List<Member> searchMembersByName(String name);
}
