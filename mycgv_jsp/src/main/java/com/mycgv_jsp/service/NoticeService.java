package com.mycgv_jsp.service;

import java.util.ArrayList;

import com.mycgv_jsp.vo.NoticeVo;


public interface NoticeService {
	public int getInsert(NoticeVo noticeVo);
	ArrayList<NoticeVo> getSelect(int startCount, int endCount);
	NoticeVo getSelect(String nid);
	int getUpdate(NoticeVo noticeVo);
	int getDelete(String nid);
	int getTotalRowCount();
	void getUpdateHits(String nid);
}
