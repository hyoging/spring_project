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
		if(image_file_name.isEmpty()) {		//파일이 없는 경우
			dto.setImageFileName("nan");
		}else {  //파일이 존재하는 경우
			dto.setImageFileName(bfs.saveFile(image_file_name));
		}
		int result = mapper.writeSave(dto);
		
		String msg="", url="";
		if(result == 1) {	//디비에 성공적으로 저장
			msg="새글이 추가되었습니다";
			url = "/root/board/boardAllList";
		}else {		//디비에 저장 안되었을때
			msg = "문제가 발생했습니다";
			url = "/root/board/writeForm";
			
		}
		return bfs.getMessage(msg,url);
	}

	@Override
	public BoardDTO contentView(int writeNo) {
		
		return mapper.getContent(writeNo);
	}
}
