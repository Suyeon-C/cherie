package com.review.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.common.controller.ImgFileController;
import com.dto.Jewelry;
import com.dto.Review;
import com.service.JewelryService;
import com.service.ReviewService;

// 리뷰 작성 컨트롤러 
// 구매한 회원만 한번만 작성가능. 수정은 여러번 ok
@Controller
@RequestMapping("review")
public class RWInsertController {
	
	@Autowired
	ReviewService rser;
	
	@Autowired
	JewelryService jser;

	@GetMapping(value = "/insert")
	public String get(@RequestParam(value = "rwJewNum", required = true) int rwJewNum,
					  @RequestParam(value = "rwerEmail", required = true) String rwerEmail,
					  HttpSession session) {
		
		Jewelry jew = this.jser.selectJew(rwJewNum);
	
		Review rw = new Review();
		rw.setRwJewName(jew.getJewName());
		rw.setRwJewImg(jew.getJewImg());
		rw.setRwJewNum(jew.getJewIdx());
		
		session.setAttribute("rw", rw);
		
		return "review/insert";

	}
	
	@PostMapping(value="/insert")
	@ResponseBody
	public String post(@RequestParam(value = "rwJewNum", required = true) int rwJewNum,
			  		   @RequestParam(value = "rwerEmail", required = true) String rwerEmail,
			  		   Review review, 
			  		   HttpServletRequest request,
			  		   HttpSession session) {
		
		MultipartFile multi = review.getRwUploadFile();
		File destination = null;
		
		String uploadPath = "/upload"; // 파일이 저장되는 폴더
		String realPath = request.getRealPath(uploadPath);
		System.out.println("실제 경로 출력 : " + realPath);
		
		try {

			if (multi != null) { 
				destination = ImgFileController.getUploadedFileInfo(multi, realPath);
				multi.transferTo(destination); // 파일 업로드
				// 원래 이미지에 날짜를 붙인 새 이미지 이름을 넣기
				review.setRwImg(realPath);
				review.setRwImg(destination.getName());
			
			}
			System.out.println(this.getClass() + "리뷰 추가 하기");
			review.setRwerEmail(rwerEmail);
			review.setRwJewNum(rwJewNum);
			System.out.println(review.toString());

			rser.insertRev(review); //리뷰 등록
		
			return "order/list";
		

		} catch (IllegalStateException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return "order/list";
	}
}

