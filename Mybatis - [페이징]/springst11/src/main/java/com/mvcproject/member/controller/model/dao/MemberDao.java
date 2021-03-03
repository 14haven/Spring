package com.mvcproject.member.controller.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvcproject.member.controller.model.vo.Member;

@Repository // DAO 위에 붙여줌  
public class MemberDao {

	@Autowired // 가지고 있는 자원이면 넣어줘 -> DI(이게 바로 DI 라는 것)
	private SqlSessionTemplate sqlSession;
	
	public MemberDao() {}

	public List<Member> selectMemberAll() throws Exception {
		List<Member> memberList = sqlSession.selectList("Member.selectMemberAll"); // namespace.실행 하고 싶은 쿼리의 아이디
		return memberList;
	}
	
	public Member selectMember(String userid) throws Exception{
		Member member = sqlSession.selectOne("Member.selectMember",userid); // 뒤에 적어주면 자동으로 userid가 들어감
		return member;
	}

	public int deleteMember(Member member) throws Exception{
		
		int cnt = sqlSession.delete("Member.deleteMember", member);
		return cnt;
	}
	
	public int insertMember(Member member) throws Exception{
		
		int cnt = sqlSession.insert("Member.insertMember", member);
		return cnt;
	}
	
	public int updateMember(Member member) throws Exception{
		
		int cnt = sqlSession.update("Member.updateMember", member);
		return cnt;
	}
	
}