

/* ===============================
수량 부분 + , - 버튼
===============================
*/

function plusqty(count){
var cartIdx = $('#cartIdx' + count).val(); // 장바구니 번호

var orderNum = $('#orderNum' + count).val(); // 상품 번호

var orderQua = parseInt($('#orderQua' + count).val()); // 회원이 장바구니에 담을 때 선택한 수량

var newQty = orderQua + count; // 회원이 변경한 수량

var jewPrice = parseInt($('#jewPrice' + count).val()); // 단가

var newPrice = newQty * jewPrice; // 회원이 변경한 수량에 맞는 상품 하나의 금액

var sum_price = parseInt($('#sum_price').text()); // 장바구니 상품 총 금액

var new_sum_price = sum_price + jewPrice; // + 버튼을 눌렀을 때 상품 총 금액

// 배송비 기준 30,000원 미만 2500원 30,000원 이상 0원
var delivery_price;

if(new_sum_price >= 30000){ 
	delivery_price = 0;
}else{
	delivery_price = 3000;
}

var total_amount = new_sum_price + delivery_price;  // 총 상품 금액 + 배송비

// + 수량 ajax 
$.ajax({
	url: '/cart/update',
	type: 'get',
	dataType: "text",
	contentType: "application/json; charset=UTF-8",
	data: { 'cartIdx' : cartIdx , 'orderNum': orderNum ,'newQty' : newQty}, // 1. {code : code } code=code 형식 , 2. String 으로 받을 수 있음..  
	success: function(data) { 
		if(data == 'over'){ // 재고의 max 값을 초과했을 때 
			alert('상품의 재고가 모자랍니다.')
		}else if(data == 'success'){
			$('#orderQua' + count).val(newQty);
			$('#orderPayment' + count).text(newPrice);
			$('#sum_price').text(new_sum_price);
			$('#delivery_price').text(delivery_price);
			$('#total_amount').text(total_amount);
			$('#orderTotalPay').val(total_amount);
		}else if(data == 'fail'){
			
			alert('상품 수량 수정이 불가능 합니다!');
		
		}else if(data == 'login'){
			location.href = getContextPath() + "/buyer/login";
		}
	}, error:function(request,status,error){
	    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	   }


});

}

function minusqty(count){
	
	var cartIdx = $('#cartIdx' + count).val(); // 장바구니 번호

	var orderNum = $('#orderNum' + count).val(); // 상품 번호

	var orderQua = parseInt($('#orderQua' + count).val()); // 회원이 장바구니에 담을 때 선택한 수량

	var newQty = orderQua - count; // 회원이 변경한 수량

	var jewPrice = parseInt($('#jewPrice' + count).val()); // 단가

	var newPrice = newQty * jewPrice; // 회원이 변경한 수량에 맞는 상품 하나의 금액

	var sum_price = parseInt($('#sum_price').text()); // 장바구니 상품 총 금액

	var new_sum_price = sum_price - jewPrice; // + 버튼을 눌렀을 때 상품 총 금액

	// 배송비 기준 30,000원 미만 2500원 30,000원 이상 0원
	var delivery_price;

	if(new_sum_price >= 30000){ 
		delivery_price = 0;
	}else{
		delivery_price = 3000;
	}

	var total_amount = new_sum_price + delivery_price; // 총 상품 금액 + 배송비

	// + 수량 ajax 
	$.ajax({
		url: '/cart/update',
		type: 'get',
		dataType: "text",
		contentType: "application/json; charset=UTF-8",
		data: { 'cartIdx' : cartIdx , 'orderNum': orderNum ,'newQty' : newQty}, // 1. {code : code } code=code 형식 , 2. String 으로 받을 수 있음..  
		success: function(data) {  
			if(data == 'over'){ // 재고의 max 값을 초과했을 때 
				
				alert('상품의 재고가 모자랍니다.')
			
			}else if(data == 'zero'){
				
				alert('수량은 1개 이상이어야 합니다!');

			}else if(data == 'success'){
				$('#orderQua' + count).val(newQty);
				$('#orderPayment' + count).text(newPrice);
				$('#sum_price').text(new_sum_price);
				$('#delivery_price').text(delivery_price);
				$('#total_amount').text(total_amount);
				$('#orderTotalPay').val(total_amount);
				
			}else if(data == 'fail'){
				
				alert('상품 수량 수정이 불가능 합니다!');
			
			}
		}, error:function(request,status,error){
		    alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		   }


	});
}
