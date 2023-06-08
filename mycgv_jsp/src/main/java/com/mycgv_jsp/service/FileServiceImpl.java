package com.mycgv_jsp.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.mycgv_jsp.vo.BoardVo;

@Service("fileService")
public class FileServiceImpl {
	/**
	 * fileDelete ��� - ���� ����
	 */
	public void fileDelete(HttpServletRequest request, String oldFileName) throws Exception{
		//������ ������ġ
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
			
		//������ �����ϸ� ������ ����
		if(oldFileName != null && !oldFileName.equals("")) { //���ο� ���� ���� 
		File deleteFile = new File(root_path + attach_path+oldFileName);
		System.out.println(root_path + attach_path+oldFileName);
		if(deleteFile.exists()) {
			deleteFile.delete();
		}
	}
}
	
	/**
	 * fileDelete ��� - ���� ����
	 */
	public void fileDelete(BoardVo boardVo, HttpServletRequest request, String oldFileName) throws Exception{
		//������ ������ġ
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
			
		//������ �����ϸ� ������ ����
		if(!boardVo.getFile1().getOriginalFilename().equals("")) {
		File deleteFile = new File(root_path + attach_path+oldFileName);
		System.out.println(root_path + attach_path+oldFileName);
		if(deleteFile.exists()) {
			deleteFile.delete();
		}
	}
}
	
	/**
	 *  fileSave ���  - ������ �����ϸ� ������ �����ϴ� �޼ҵ�
	 */
	public void fileSave(BoardVo boardVo, HttpServletRequest request) throws Exception{
		//������ ������ġ
		String root_path = request.getSession().getServletContext().getRealPath("/");
		String attach_path = "\\resources\\upload\\";
			
		//������ �����ϸ� ������ ����
		if(boardVo.getBfile() != null && boardVo.getBfile().equals("")) {
		System.out.println("sava file--->" + boardVo.getBfile());
		File saveFile = new File(root_path + attach_path+boardVo.getBsfile());
		boardVo.getFile1().transferTo(saveFile);
	}
}
	
	
	
	
	/**
	 * fileCheck ��� - ������ �����ϸ� boardVo�� bfile, bsfile set!, ������ boardVo ����
	 */
	public BoardVo fileCheck(BoardVo boardVo) {
		if(boardVo.getFile1().getOriginalFilename() != null
				&& !boardVo.getFile1().getOriginalFilename().equals("")) { //������ �����ϸ�
			//BSFILE ���� �ߺ� ó��
			UUID uuid = UUID.randomUUID();
			String bfile =  boardVo.getFile1().getOriginalFilename();
			String bsfile = uuid + "_" + bfile; 
			
			System.out.println("bfile-->"+ bfile);
			System.out.println("bsfile-->"+ bsfile);
			
			boardVo.setBfile(bfile);
			boardVo.setBsfile(bsfile);
		}else {
			System.out.println("���� ����");
			//boardVo.setBfile("");
			//boardVo.setBsfile("");
		}
		return boardVo;
	}
	
	
}
