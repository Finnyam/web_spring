package com.mycgv_jsp.dao;

import com.mycgv_jsp.vo.NoticeVo;

public class NoticeDao extends DBConn {
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
