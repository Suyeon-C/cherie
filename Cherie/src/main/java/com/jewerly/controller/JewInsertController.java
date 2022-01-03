package com.jewerly.controller;

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
import org.springframework.web.multipart.MultipartFile;

import com.common.controller.ImgFileController;
import com.dto.Jewelry;
import com.service.JewelryService;

// 판매자가 판매할 상품 등록 
@Controller
@RequestMapping("jewelry")
public class JewInsertController {

	
	@Autowired
	JewelryService jser;
	
	@GetMapping(value="/insert")
	public String get() {
	
		return "jewelry/insert";
		
	}
	
	@PostMapping(value="/insert")
	public String post(@RequestParam(value="jewSellEmail", required = true) String jewSellEmail,
					    Jewelry jew,
					    HttpSession session,
					    HttpServletRequest request) {
		
		MultipartFile multi = jew.getJewUploadFile();
		File destination = null;
		
		String uploadPath = "/upload"; // 파일이 저장되는 폴더
		String realPath = request.getRealPath(uploadPath);
		System.out.println("실제 경로 출력 : " + realPath);
		
		try {

			if (multi != null) {
				destination = ImgFileController.getUploadedFileInfo(multi, realPath);
				multi.transferTo(destination); // 파일 업로드
				// 원래 이미지에 날짜를 붙인 새 이미지 이름을 넣기
				jew.setJewImg(destination.getName());
			
			}
			System.out.println(this.getClass() + "상품 추가 하기");
			jew.setJewSellEmail(jewSellEmail);
			System.out.println(jew.toString());

			jser.insertJew(jew);
			System.out.println("상품 등록 성공");
			return "jewelry/list";
		

		} catch (IllegalStateException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return "jewelry/insert";
	}
}