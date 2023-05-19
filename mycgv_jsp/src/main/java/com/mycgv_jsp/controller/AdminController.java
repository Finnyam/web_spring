package com.mycgv_jsp.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mycgv_jsp.dao.NoticeDao;
import com.mycgv_jsp.vo.NoticeVo;

@Controller
public class AdminController {
	/**
	 * admin_notice_delete_proc.do - 공지사항 삭제 처리
	 */
	@RequestMapping(value="/admin_notice_delete_proc.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_delete_proc(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeDao noticeDao = new NoticeDao();
		int result = noticeDao.delete(nid);
		
		if(result == 1) {
			model.setViewName("redirect:/admin_notice_list.do");
		}
		return model;
	}
	/**
	 * admin_notice_delete.do - 공지사항 삭제 폼
	 */
	@RequestMapping(value="/admin_notice_delete.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_delete(String nid) {
		ModelAndView model = new ModelAndView();
		model.addObject("nid", nid);
		model.setViewName("/admin/notice/admin_notice_delete");
		
		return model;
	}
	
	/**
	 * admin_notice_update_proc.do - 공지사항 수정 처리
	 */
	@RequestMapping(value="/admin_notice_update_proc.do", method=RequestMethod.POST)
	public ModelAndView admin_notice_update_proc(NoticeVo noticeVo) {
		ModelAndView model = new ModelAndView();
		NoticeDao noticeDao = new NoticeDao();
		int result = noticeDao.update(noticeVo);
		
		if(result == 1) {
			model.setViewName("redirect:/admin_notice_list.do");
		}
		return model;
	}
	/**
	 * admin_notice_update.do - 공지사항 수정 폼
	 */
	@RequestMapping(value="/admin_notice_update.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_update(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeDao noticeDao = new NoticeDao();
		NoticeVo noticeVo = noticeDao.select(nid);
		
		model.addObject("noticeVo", noticeVo);
		model.setViewName("/admin/notice/admin_notice_update");
		return model;
	}
	/**
	 * admin_notice_content.do - 공지사항 상세보기
	 */
	@RequestMapping(value="/admin_notice_content.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_content(String nid) {
		ModelAndView model = new ModelAndView();
		NoticeDao noticeDao = new NoticeDao();
		NoticeVo noticeVo = noticeDao.select(nid);
		
		model.addObject("noticeVo", noticeVo);
		model.setViewName("/admin/notice/admin_notice_content");
		return model;
	}
	/**
	 * admin_notice_write_proc.do - 공지사항 등록 처리
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
	 * admin_notice_write.do - 공지사항 등록하기
	 */
	@RequestMapping(value="/admin_notice_write.do", method=RequestMethod.GET)
	public String admin_notice_write() {		
		return "/admin/notice/admin_notice_write";
	}
	
	/**
	 * admin_notice_list.do - 공지사항 리스트 
	 */
	@RequestMapping(value="/admin_notice_list.do", method=RequestMethod.GET)
	public ModelAndView admin_notice_list() {
		ModelAndView model = new ModelAndView();
		NoticeDao noticeDao = new NoticeDao();
		ArrayList<NoticeVo> list = noticeDao.select();
			
		model.addObject("list", list);
		model.setViewName("/admin/notice/admin_notice_list");
				
		return model;
	}
	
	
	/**
	 * admin_index.do - 관리자 메인 페이지
	 */
	@RequestMapping(value="/admin_index.do", method=RequestMethod.GET)
	public String admin_index() {
		return "/admin/admin_index";
	}
}
