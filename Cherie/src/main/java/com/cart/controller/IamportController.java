package com.cart.controller;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.dto.Cart;
import com.dto.Jewelry;
import com.dto.Order;
import com.service.CartService;
import com.service.JewelryService;
import com.service.OrderService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.AccessToken;
import com.siot.IamportRestClient.response.IamportResponse;


//imaport 결제 연동, 결제 후 상품의 재고 차감, 장바구니에서 상품 삭제 실행 
@Controller
public class IamportController {

	IamportClient client;

	@Autowired
	OrderService oser;

	@Autowired
	JewelryService jser;

	@Autowired
	CartService cser;

	// API key와 API Secret Key 를 활용해 IamportClient 생성
	IamportClient getTestClient() {
		System.out.println("getTestClient 메소드 통과");
		String test_api_key = "5038522291245744";
		String test_api_secret = "5234f708eee898e6ed85117fd3e16d7b2085c135365b7edccd5df0a3b25a8570cdb42a1ce5b25ea7";
		return new IamportClient(test_api_key, test_api_secret);
	}

	// 토큰 값 가져오기
	void getToken() {
		System.out.println("토큰 값 가져오기");
		try {
			IamportResponse<AccessToken> auth_response = client.getAuth();
			assertNotNull(auth_response.getResponse());
			assertNotNull(auth_response.getResponse().getToken());
			System.out.println("get token str: " + auth_response.getResponse().getToken());
		} catch (IamportResponseException e) {

			System.out.println(e.getMessage());

			switch (e.getHttpStatusCode()) {
			case 401:
				System.out.println("http status code 401");
				break;

			case 500:
				System.out.println("http status code 500");
				break;

			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

	
	@PostMapping(value = "/cart/payment")
	public String post(String orderZipcode, String orderAddress, String orderDaddress, String orderBuyEmail,
			String orderRequest, String orderPhone, String orderTotalPay, HttpSession session) {

		List<Cart> mycart = (List<Cart>) session.getAttribute("cartlists");
		System.out.println("===> 확인 mycart : " + mycart);

		int cnt;
		for (Cart cart : mycart) {
			cnt = -1;

			Order bean = new Order();

			bean.setOrderZipcode(orderZipcode);
			bean.setOrderAddress(orderAddress);
			bean.setOrderDaddress(orderDaddress);
			bean.setOrderBuyEmail(orderBuyEmail);
			bean.setOrderRequest(orderRequest);
			bean.setOrderPhone(orderPhone);
			bean.setOrderNum(cart.getCartJewNum());
			bean.setOrderQua(cart.getCartBuyQua());
			bean.setOrderPayment(cart.getCartPrice());

			Jewelry jew = jser.selectJew(cart.getCartJewNum());
			System.out.println(" 확인 jew ===> " + jew);

			if (jew.getJewStock() - bean.getOrderQua() >= 0) {

				cnt = this.oser.insertOrder(bean);

				if (cnt > 0) {
					System.out.println("===> 상품 결제 성공");

					this.jser.updateStock(bean.getOrderNum(), bean.getOrderQua());
					System.out.println("===> 재고 차감 성공");

					// 결재된 상품 장바구니에서 삭제 
					cnt = -1;
					cnt = this.cser.cartDeleteByEmail(orderBuyEmail);

					if (cnt > 0) { // 장바구니 삭제 성공 --> 결제 성공 !
						System.out.println("===> 장바구니 삭제 성공");
						return "common/main";
					}

				} else { // 결제 실패
					System.out.println("===> 상품 결제 실패");
					return "common/main";
				}

			} else { // 상품의 재고 없음 ---> 결제 실패
				System.out.println("재고 없음, 상품 결제 실패");
				return "cart/list";
			}

		} // for문 종료
		return "common/main";
	}
}
