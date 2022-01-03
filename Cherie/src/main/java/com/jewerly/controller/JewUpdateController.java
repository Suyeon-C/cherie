package com.jewerly.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.common.controller.ImgFileController;
import com.dto.Jewelry;
import com.service.JewelryService;

// 판매자가 상품의 정보를 수정하도록 하는 컨트롤러 
@Controller
@RequestMapping("jewelry")
public class JewUpdateController {

	@Autowired
	JewelryService jser;
	
	@GetMapping(value="/update")
	public String get(@RequestParam(value="jewIdx", required = true) int jewIdx,
						HttpSession session) {
		
		Jewelry jew = jser.selectJew(jewIdx);
		session.setAttribute("jew", jew);
		return "jewelry/update";
	}
	
	@PostMapping(value="/update")
	public String post(@ModelAttribute("jew") Jewelry jew,
					   BindingResult errors,
					   HttpSession session,
					   HttpServletRequest request,
					   @RequestParam(value="priorImg", required = false) String priorImg) {
		
		System.out.println(this.getClass() + " doPost 메소드");
		System.out.println("빈 객체 정보");
		System.out.println(jew.toString());
		System.out.println("지울 이미지 : " + priorImg); // 지워야 할 이미지 정보

		if (errors.hasErrors()) {
			System.out.println("유효성 검사 실패.");
			System.out.println(errors);
			session.setAttribute("jew", jew);
			return "jewelry/update";

		} else {
			if (jew.getJewUploadFile().isEmpty() == false) {
				System.out.println("유효성 검사 통과");
				MultipartFile multi = jew.getJewUploadFile();
				String uploadPath = "/upload";
				String realPath = request.getRealPath(uploadPath);
				try {
					String del_img = realPath + "/" + priorImg;
					new File(del_img).delete();

					File target = ImgFileController.getUploadedFileInfo(multi, realPath);
					multi.transferTo(target);
					jew.setJewImg(target.getName());
					jser.updateJew(jew);
					return "jewelry/list";

				} catch (IllegalStateException e) {
					e.printStackTrace();
				
				} catch (Exception e) {
					e.printStackTrace();
				
				}
			} else {
				jew.setJewImg(priorImg);
				jser.updateJew(jew);
				return "jewelry/list";
			}

		}
		return "jewelry/update";
	}	
	

}
