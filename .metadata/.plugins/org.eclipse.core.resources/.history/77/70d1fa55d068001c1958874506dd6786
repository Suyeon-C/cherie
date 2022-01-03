package com.service;

import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.SellerDAO;
import com.dto.Buyer;
import com.dto.Seller;

@Service("sserImpl")
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	@Qualifier("sdao")
	SellerDAO sdao;

	@Override
	public Seller selectSeller(String sellEmail) {
		return sdao.selectSeller(sellEmail);
	}

	@Override
	public Seller selectSelEmailPW(String sellEmail, String sellPassword) {
		return sdao.selectSelEmailPW(sellEmail, sellPassword);
	}

	
	@Override
	public int selectSellCount(String keyword) {
		return sdao.selectSellCount(keyword);
	}

	@Override
	public List<Seller> selectListSeller(int offset, int limit, String keyword) {
		return sdao.selectListSeller(offset, limit, keyword);
	}

	@Override
	public void insertSell(Seller sell) {
		sdao.insertSell(sell);
		
	}

	@Override
	public void updateSell(Seller sell) {
		sdao.updateSell(sell);
		
	}

	@Override
	public void deleteSell(Seller sell) {
		sdao.deleteSell(sell);
	}

	@Override
	public Seller selectSelEmail(String sellName, String sellPhone) {
		return sdao.selectSelEmail(sellName, sellPhone);
	}

	@Override
	public Seller selectSelPW(String sellEmail, String sellName, String sellPhone) {
		return sdao.selectSelPW(sellEmail, sellName, sellPhone);
	}

	@Override
	public int countSeller(String sellEmail) {
		return sdao.countSeller(sellEmail);
	}

	@Override
	public void findPw(HttpServletResponse response, Seller sell) throws Exception {
		
		response.setContentType("text/html;charset=utf-8");
		Seller dto = sdao.selectSeller(sell.getSellEmail());
		PrintWriter out = response.getWriter();
		// 가입된 아이디가 없으면 
		if(dto == null) {
			out.println("등록된 정보가 없습니다.");
			out.close();
		}else {
			String pw = "";
			String uuid = UUID.randomUUID().toString().replace("-", "");
			pw = uuid.toString().substring(0, 6);
			sell.setSellPassword(pw);
			sdao.updatePw(sell);
			send(sell,"findpw");
			out.print("이메일로 임시 비밀번호를 발송하였습니다.");
			out.close();
			
		}
	}
		

	@Override
	public void send(Seller sell, String div) {
		//Mail server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com";
		
		//SMTP 서버명
		//아이디 
		String hostSMTPid = "s.yeonoel0830@gmail.com";
		//비밀번호 
		String hostSMTPpwd = "!seochoijune4879";
		
		//보내는 사람
		String fromEmail = "santanoel1225@naver.com";
		String fromName = "Chérie";
		String subject = "";
		String msg = "";
		
		if(div.equals("findpw")) {
			subject="Chérie 임시 비밀번호 입니다.";
			msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			msg += "<h3 style='color: blue;'>";
			msg += sell.getSellName() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
			msg += "<p>임시 비밀번호 : ";
			msg += sell.getSellPassword() + "</p></div>";
		
		}
		String mail = sell.getSellEmail();
		//email 전송 
		try {
			HtmlEmail email = new HtmlEmail();
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true);
			email.setHostName(hostSMTP);
			email.setSmtpPort(465); //SMTP 포트번호 
			
			email.setAuthentication(hostSMTPid, hostSMTPpwd);
			email.setTLS(true);
			email.addTo(mail,charSet);
			email.setFrom(fromEmail,fromName,charSet);
			email.setSubject(subject);
			email.setHtmlMsg(msg);
			email.send();
			
		} catch (Exception e) {
			System.out.println("비밀번호 찾기 메일 발송 실패 " + e);
			e.printStackTrace();
		}

	}

}


