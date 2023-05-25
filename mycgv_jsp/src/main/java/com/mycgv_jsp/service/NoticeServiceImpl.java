package com.mycgv_jsp.service;

import java.util.ArrayList;

import com.mycgv_jsp.dao.NoticeDao;
import com.mycgv_jsp.vo.NoticeVo;

public class NoticeServiceImpl implements NoticeService{
	
	NoticeDao noticeDao = new NoticeDao();
	
	@Override
	public int getInsert(NoticeVo noticeVo) {
		return noticeDao.insert(noticeVo);
	}
	@Override
	public ArrayList<NoticeVo> getSelect(int startCount, int endCount){
		return noticeDao.select(startCount, endCount);
	}
	@Override
	public NoticeVo getSelect(String bid) {
		return noticeDao.select(bid);
	}
	@Override
	 public int getUpdate(NoticeVo noticeVo) {
		return noticeDao.update(noticeVo);
	}
	@Override
	 public int getDelete(String bid) {
		return noticeDao.delete(bid);
	}
	@Override
	 public int getTotalRowCount() {
		return noticeDao.totalRowCount();
	}
	@Override
	 public void getUpdateHits(String bid) {
		noticeDao.updateHits(bid);
	}
}
