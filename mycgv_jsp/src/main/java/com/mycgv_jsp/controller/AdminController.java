package com.mycgv_jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycgv_jsp.dao.NoticeDao;
import com.mycgv_jsp.vo.NoticeVo;

@Controller
public class AdminController {
	/**
	 * admin_notice_write_proc.do - �������� ��� ó��
	 * @return
	 */
	@RequestMapping(value="/admin_notice_write_proc.do", method=RequestMethod.POST)
	public String admin_notice_write_proc(NoticeVo noticeVo) {	
		String viewName = "";
		NoticeDao noticeDao = new NoticeDao();
		int result = noticeDao.insert(noticeVo);
		if(result == 1) {
			viewName = "redirect:/admin_notice_list.do";
		}		
		
		return viewName;
	}
	/**
	 * admin_notice_write.do - �������� ����ϱ�
	 * @return
	 */
	@RequestMapping(value="/admin_notice_write.do", method=RequestMethod.GET)
	public String admin_notice_write() {		
		return "/admin/notice/admin_notice_write";
	}
	
	/**
	 * admin_notice_list.do - �������� ����Ʈ 
	 * @return
	 */
	@RequestMapping(value="/admin_notice_list.do", method=RequestMethod.GET)
	public String admin_notice_list() {
		
		
		return "/admin/notice/admin_notice_list";
	}
	
	
	/**
	 * admin_index.do - ������ ���� ������
	 * @return
	 */
	@RequestMapping(value="/admin_index.do", method=RequestMethod.GET)
	public String admin_index() {
		return "/admin/admin_index";
	}
}
