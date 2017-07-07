package kdata.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SugangManager {
	//신청, 취소 , 리스트
	public static int apply(String snum, String subjectCode) throws SQLException {
		Connection con = DBUtil.getConnection();
		String sql = "insert into takeclass values (?,?,null,default)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, snum);
		pstmt.setString(2, subjectCode);
		
		int result = pstmt.executeUpdate();
		
		DBUtil.close(con, pstmt);
		
		return result;
		
	}
	public static int cancel(String snum, String subjectCode) throws SQLException {
		Connection con = DBUtil.getConnection();
		String sql = "delete from takeclass where trim(snum)=? and trim(subjectcode)=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, snum);
		pstmt.setString(2, subjectCode);
		
		int result = pstmt.executeUpdate();
		DBUtil.close(con, pstmt);
		
		return result;
	}
	/**
	 * 
	 * 
	 */
	public static List<Sugang> sugangList(String snum) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Sugang> list=null;
		
		try {
			con = DBUtil.getConnection();
			
			String sql = "select s.snum, s.sname, su.subjectcode, "
					+ "su.subjectname, t.applydate, t.grade "
					+ "from stuinfo s inner join takeclass t on s.snum=t.snum "
					+ "inner join subject su on t.subjectcode=su.subjectcode "
					+ "where trim(s.snum) = ?";
			pstmt = con.prepareStatement(sql);
			System.out.println(sql);
			pstmt.setString(1, snum);
			rs = pstmt.executeQuery();
			if (rs==null) {
				return list;
			}
			list = new ArrayList<>();
			
			while(rs.next()) {
				Sugang s = new Sugang() ;
				s.setSnum(rs.getString("snum"));
				s.setSname(rs.getString("sname"));
				s.setSubjectcode(rs.getString("subjectcode"));
				s.setSubjectname(rs.getString("subjectname"));
				s.setGrade(rs.getString("grade"));
				s.setApplydate(rs.getString("applydate"));
				System.out.println(s);
				list.add(s);
			}
		} finally {
			DBUtil.close(con, pstmt,rs);
		}
		return list;
	}
	public static int inputGrade(String snum, String subjectCode, int grade) throws SQLException {
		Connection con = DBUtil.getConnection();
		String sql = "update takeclass set grade = ? where trim(snum) = ? and trim(subjectcode) =? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setInt(1, grade);
		pstmt.setString(2, snum);
		pstmt.setString(3, subjectCode);
		
		int result = pstmt.executeUpdate();
		DBUtil.close(con, pstmt);
		
		return result;
	
	}
}
