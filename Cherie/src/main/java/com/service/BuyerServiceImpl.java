package com.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dao.BuyerDAO;
import com.dto.Buyer;

@Service("bserImpl")
public class BuyerServiceImpl implements BuyerService {
	
	
	@Autowired
	@Qualifier("bdao")
	BuyerDAO bdao;


	@Override
	public Buyer selectBuyer(String buyEmail, String buyPW) {
		return bdao.selectBuyer(buyEmail, buyPW);
	}

	@Override
	public Buyer selectBuyerByEmail(String buyEmail) {
		return bdao.selectBuyerByEmail(buyEmail);
	}
	

	@Override
	public int selectBuyCount(String keyword) {
		return bdao.selectBuyCount( keyword);
	}
	

	@Override
	public List<Buyer> selectListBuyer(int offset, int limit, String keyword) {
		return bdao.selectListBuyer(offset, limit, keyword);
	}

	@Override
	public void insertBuyer(Buyer dto) {
		bdao.insertBuyer(dto);
	}

	@Override
	public void updateBuyer(Buyer dto) {
		bdao.updateBuyer(dto);
		
	}

	@Override
	public void deleteBuyer(Buyer dto) {
		bdao.deleteBuyer(dto);
		
	}

	@Override
	public Buyer selectEmail(String buyName, String buyPhone) {
		return bdao.selectEmail(buyName, buyPhone);
	}

	@Override
	public Buyer selectPW(String buyEmail, String buyName, String buyPhone) {
		return bdao.selectPW(buyEmail, buyName, buyPhone);
	}
	
	@Override
	public int countBuyer(String buyEmail) {
		return bdao.countBuyer(buyEmail);
	}

	@Override
	public Buyer kakaoLogin(String buyEmail) {
		return bdao.kakaoLogin(buyEmail);
	}

	@Override
	public void kakaoSign(Buyer dto) {
		bdao.kakaoSign(dto);
		
	}

	@Override
	public void findPw(HttpServletResponse response, Buyer buy) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		Buyer dto = bdao.selectBuyerByEmail(buy.getBuyEmail());
		PrintWriter out = response.getWriter();
		// ????????? ???????????? ????????? 
		if(dto == null) {
			out.println("????????? ????????? ????????????.");
			out.close();
		}else {
			String pw = "";
			String uuid = UUID.randomUUID().toString().replace("-", "");
			pw = uuid.toString().substring(0, 6);
			buy.setBuyPW(pw);
			bdao.updatePw(buy);
			send(buy,"findpw");
			out.print("???????????? ?????? ??????????????? ?????????????????????.");
			out.close();
			
		}
	}
		

	@Override
	public void send(Buyer buy, String div) {
			//Mail server ??????
				String charSet = "utf-8";
				String hostSMTP = "smtp.gmail.com";
				
				//SMTP ?????????
				//????????? 
				String hostSMTPid = "s.yeonoel0830@gmail.com";
				//???????????? 
				String hostSMTPpwd = "!seochoijune4879";
				
				//????????? ??????
				String fromEmail = "santanoel1225@naver.com";
				String fromName = "Ch??rie";
				String subject = "";
				String msg = "";
				
				if(div.equals("findpw")) {
					subject="Ch??rie ?????? ???????????? ?????????.";
					msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
					msg += "<h3 style='color: blue;'>";
					msg += buy.getBuyName() + "?????? ?????? ???????????? ?????????. ??????????????? ???????????? ???????????????.</h3>";
					msg += "<p>?????? ???????????? : ";
					msg += buy.getBuyPW() + "</p></div>";
				
				}
				String mail = buy.getBuyEmail();
				//email ?????? 
				try {
					HtmlEmail email = new HtmlEmail();
				System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
					email.setDebug(true);
					email.setCharset(charSet);
					email.setSSL(true);
					email.setHostName(hostSMTP);
					email.setSmtpPort(465); //SMTP ???????????? 
					
					email.setAuthentication(hostSMTPid, hostSMTPpwd);
					email.setTLS(true);
					email.addTo(mail,charSet);
					email.setFrom(fromEmail,fromName,charSet);
					email.setSubject(subject);
					email.setHtmlMsg(msg);
					email.send();
					
				} catch (Exception e) {
					System.out.println("???????????? ?????? ?????? ?????? ?????? " + e);
					e.printStackTrace();
				}

			}
		
	}
	


