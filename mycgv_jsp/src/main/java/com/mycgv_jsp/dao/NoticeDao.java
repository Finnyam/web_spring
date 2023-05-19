package com.mycgv_jsp.dao;

import java.util.ArrayList;

import com.mycgv_jsp.vo.NoticeVo;

public class NoticeDao extends DBConn {
	/**
	 * updateHits - 공지사항 조회수 업데이트 
	 */
	public void updateHits(String nid) {
		String sql = "update mycgv_notice set nhits = nhits+1 where nid=?";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, nid);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * delete - 공지사항 삭제
	 */
	public int delete(String nid) {
		int result = 0;
		String sql = "DELETE FROM MYCGV_NOTICE WHERE NID=? ";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, nid);			
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	/**
	 * update - 공지사항 수정처리
	 */
	public int update(NoticeVo noticeVo) {
		int result = 0;
		String sql ="UPDATE MYCGV_NOTICE SET NTITLE=?,NCONTENT=? WHERE NID=? ";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, noticeVo.getNtitle());
			pstmt.setString(2, noticeVo.getNcontent());
			pstmt.setString(3, noticeVo.getNid());
			
			result = pstmt.executeUpdate();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	/**
	 *  select(String nid) - 공지사항 상세보기
	 */
	public NoticeVo select(String nid){
		NoticeVo noticeVo = new NoticeVo();
		String sql ="SELECT NID,NTITLE,NCONTENT,NHITS,NDATE FROM MYCGV_NOTICE "
				+ " WHERE NID=? ";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, nid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				noticeVo.setNid(rs.getString(1));
				noticeVo.setNtitle(rs.getString(2));
				noticeVo.setNcontent(rs.getString(3));
				noticeVo.setNhits(rs.getInt(4));
				noticeVo.setNdate(rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return noticeVo;
	}
	
	/**
	 * select - 공지사항 전체 리스트
	 */
	public ArrayList<NoticeVo> select(){
		ArrayList<NoticeVo> list = new ArrayList<NoticeVo>();
		String sql ="SELECT ROWNUM RNO,NID,NTITLE,NHITS,TO_CHAR(NDATE,'YYYY-MM-DD') NDATE "
				+ " FROM (SELECT NID,NTITLE,NHITS,NDATE FROM MYCGV_NOTICE "
				+ " ORDER BY NDATE DESC) ";
		getPreparedStatement(sql);
		
		try {
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVo noticeVo = new NoticeVo();
				noticeVo.setRno(rs.getInt(1));
				noticeVo.setNid(rs.getString(2));
				noticeVo.setNtitle(rs.getString(3));
				noticeVo.setNhits(rs.getInt(4));
				noticeVo.setNdate(rs.getString(5));
				
				list.add(noticeVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * insert - 공지사항 등록
	 */
	public int insert(NoticeVo noticeVo) {
		int result = 0;
		String sql = "insert into mycgv_notice(nid,ntitle,ncontent,nhits,ndate) "
		 + " values('n_'||ltrim(to_char(sequ_mycgv_notice.nextval,'0000')),?,?,0,sysdate)";
		getPreparedStatement(sql);
		
		try {
			pstmt.setString(1, noticeVo.getNtitle());
			pstmt.setString(2, noticeVo.getNcontent());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
