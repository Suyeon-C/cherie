function pay() {
		// 결제 테이블에 넣을 파라미터
		var orderNum = $('#orderNum').val(); // 주문 클래스
		var orderBuyEmail = $('#orderBuyEmail').val(); // 회원 이메일
		var orderTime = $('#orderTime').val(); // 결제 일자
		var orderZipcode = $('#orderZipcode').val(); // 우편 번호
		var orderQua = $('#orderQua').val(); // 구매 수량
		var ordersAddress = $('#orderAddress').val(); // 우편 번호
		var orderDaddress = $('#orderDaddress').val(); // 주소
		var orderPhone = $('#orderPhone').val(); // 상세 주소
		var orderRequest = $('#orderRequest').val();
		var orderTotalPay = $('#orderTotalPay').val();

		var buyName = $('#buyName').val();

		IMP.init('imp89424660'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
		IMP.request_pay({
			pg : 'inicis', // version 1.1.0부터 지원.
			pay_method : 'card',
			merchant_uid : 'merchant_' + new Date().getTime(),
			name : '주문명: ' + orderNum + " | 결제 테스트",
			amount : orderTotalPay, // 결제 금액
			buyer_email : orderBuyEmail,// 결제자 이메일
			buyer_name : buyName, // 결제자 이름
			buyer_tel : orderPhone
		// 결제자 휴대폰 번호
		}, function(rsp) {
			if (rsp.success) {
				$('#orderNum').val(orderNum);// 주문 클래스
				$('#orderBuyEmail').val(orderBuyEmail); // 회원 이메일
				$('#orderTime').val(orderTime); // 결제 일자
				$('#orderZipcode').val(orderZipcode); // 우편 번호
				$('#orderQua').val(orderQua); // 구매 수량
				$('#orderAddress').val(ordersAddress); // 우편 번호
				$('#orderDaddress').val(orderDaddress); // 주소
				$('#orderPhone').val(orderPhone); // 상세 주소
				$('#orderRequest').val(orderRequest); // 요청사항
				$('#orderTotalPay').val(orderTotalPay); // 결제 총 가격
				var payform = document.payForm;
				payform.submit();

				var msg = '결제가 완료되었습니다.';
				msg += '\n고유ID : ' + rsp.imp_uid;
				msg += '\n상점 거래ID : ' + rsp.merchant_uid;
				msg += '\결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;

				alert(msg);

			} else {
				var msg = "결제에 실패하였습니다.";
				msg += "에러내용 :" + rsp.error_msg;
				alert(msg)
			}

		});
	}
	
/* ===============================
	휴대폰번호 정규표현식
===============================
*/
$(function(){
	$("#orderPhone").blur(function() {
		var regexp = /^[0-9]*$/;
		var orderPhone = $('#orderPhone').val();
		if( !regexp.test(orderPhone) ) {
			$("#check_orderPhone").text("숫자만 입력해주세요");
			$("#check_orderPhone").css('color', 'red');
			$("#paybutton").attr("disabled", true);
			$('#orderPhone').val('');
          	$('#orderPhone').focus();
	} else if(orderPhone == ""){
		$("#check_orderPhone").text("휴대전화번호를 입력해주세요");
		$("#check_orderPhone").css('color', 'red');
		$("#paybutton").attr("disabled", true);
	} else { 
           	$("#check_orderPhone").text("올바른 휴대폰번호 형태입니다");
			$("#check_orderPhone").css('color', '#5080BF');
			$("#paybutton").attr("disabled", false);
	}
});
});	

/* ===============================
	이름 정규표현식(한글, 영어만)
===============================
*/
$(function(){
	$("#buyName").blur(function() {
		var regExp = /^[ㄱ-ㅎ|가-힣|a-z|A-Z]+$/;
		var buyName = $('#buyName').val();
	if(regExp.test(buyName) == false) {
			$("#check_buyName").text("한글 또는 영어로 입력해주세요");
			$("#check_buyName").css('color', 'red');
			$("#paybutton").attr("disabled", true);
			$('#buyName').val('');
          	$('#buyName').focus();
	} else { 
           	$("#check_buyName").text("올바른 이름 형태입니다");
			$("#check_buyName").css('color', '#5080BF');
			$("#paybutton").attr("disabled", false);
	}
});
});	

/* =======================
 *    우편번호 찾기 Daum 
 *========================
 */

	function zip() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

	            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var fullAddr = ''; // 최종 주소 변수
	            var extraAddr = ''; // 조합형 주소 변수

	            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                fullAddr = data.roadAddress;

	            } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                fullAddr = data.jibunAddress;
	            }

	            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
	            if(data.userSelectedType === 'R'){
	                //법정동명이 있을 경우 추가한다.
	                if(data.bname !== ''){
	                    extraAddr += data.bname;
	                }
	                // 건물명이 있을 경우 추가한다.
	                if(data.buildingName !== ''){
	                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
	                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
	            }

	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('orderZipcode').value = data.zonecode; //5자리 새우편번호 사용
	            document.getElementById('orderAddress').value = fullAddr;

	            // 커서를 상세주소 필드로 이동한다.
	            document.getElementById('orderDaddress').focus();
	        }
	    }).open();
	}