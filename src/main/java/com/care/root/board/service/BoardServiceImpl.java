package com.care.root.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.care.root.board.dto.BoardDTO;
import com.care.root.mybatis.board.BoardMapper;

@Service
public class BoardServiceImpl  implements BoardService {
	@Autowired BoardMapper mapper;
	@Autowired BoardFileService bfs;
	
	@Override
	public List<BoardDTO> boardAllList() {
		return mapper.boardAllList();
	}

	@Override
	public String writeSave(BoardDTO dto, MultipartFile image_file_name) {
		if(image_file_name.isEmpty()) {		//������ ���� ���
			dto.setImageFileName("nan");
		}else {  //������ �����ϴ� ���
			dto.setImageFileName(bfs.saveFile(image_file_name));
		}
		int result = mapper.writeSave(dto);
		
		String msg="", url="";
		if(result == 1) {	//��� ���������� ����
			msg="������ �߰��Ǿ����ϴ�";
			url = "/root/board/boardAllList";
		}else {		//��� ���� �ȵǾ�����
			msg = "������ �߻��߽��ϴ�";
			url = "/root/board/writeForm";
			
		}
		return bfs.getMessage(msg,url);
	}

	@Override
	public BoardDTO contentView(int writeNo) {
		
		return mapper.getContent(writeNo);
	}
}
