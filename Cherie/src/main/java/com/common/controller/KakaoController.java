package com.common.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.BuyerDAOImpl;
import com.dto.Buyer;
import com.service.KakaoService;

//회원 카카오 로그인에 대한 컨트롤러
//일치하는 정보의 회원이 없다면 자동으로 회원가입 한 후 메인화면으로 이동 
@Controller
public class KakaoController {
	
	@Autowired
	private KakaoService kakaoService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	BuyerDAOImpl bdaoImpl;

	@RequestMapping("/kakaoLogin")
    public String home(@RequestParam(value = "code", required = false) String code, HttpSession session) throws Exception{
		// 만약 로그인에 성공했다면 코드에 값이 들어있을 것입니다.
		// 로그인이 완료되어 있다는 코드입니다.
		// 사용자 정보를 가져오기위해선 access_Token 코드가 필요하고, 
		// 이 access_Token 코드를 받기위해선 아래 code가 필요합니다.
		// 로그인 -> 로그인완료코드 발급 -> 사용자 정보에 접근할 수 있는 코드 발급 -> 사용자 정보요청 
        System.out.println("#########" + code);
        
        /******************************************************
         *  카카오 리턴 값들
         *****************************************************/
        String access_Token = kakaoService.getAccessToken(code);
        HashMap<String, Object> memInfo = kakaoService.getMemInfo(access_Token);
        
        System.out.println("###userInfo#### : " + memInfo.get("email"));
        System.out.println("###nickname#### : " + memInfo.get("nickname"));
        	
        String buyEmail = String.valueOf(memInfo.get("email"));
        String buyName = String.valueOf(memInfo.get("nickname"));
        
        Buyer bdto = new Buyer(buyEmail, buyName);
        
        if(bdaoImpl.kakaoLogin(buyEmail) == null) { 
            request.getSession().setAttribute("k_email", memInfo.get("email"));
            request.getSession().setAttribute("k_name", memInfo.get("nickname"));
        	bdaoImpl.kakaoSign(bdto);
        }
       
       request.getSession().setAttribute("loginfo", bdaoImpl.kakaoLogin(buyEmail));
     
    	
    return "redirect:/";
}


	
}
