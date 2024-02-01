package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.CommentDTO;
import com.example.demo.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	CommentService service;
	
	@ResponseBody//데이터를 보낼 때 json 타입으로 보낼 수 있도록 해주는 어노테이션
	@GetMapping("/list")
	public List<CommentDTO> list(@RequestParam(name = "boarNo")int boarNo){
		List<CommentDTO> commentList = service.getListByBoardNo(boarNo);
		return commentList;
	}
	
}
