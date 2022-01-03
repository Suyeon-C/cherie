/* ===============================  
	 버튼 클릭 시 수량, 가격 변동 
 ==================================*/

$(document).ready(function() {
		// 가격 콤마 찍기
		var jewPrice = $('#jewPrice').val();
			jewPrice = addcomma(jewPrice);
		// 가짜 결제 가격 콤마 찍기
		var inputTotalprice = $('#inputTotalprice').val();
			inputTotalprice = addcomma(inputTotalprice);
		// 진짜 결제 가격 콤마 찍기
		var totalprice = $('#totalprice').val();
			totalprice = addcomma(totalprice);

		function addcomma(str) {
				str = String(str);
				return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g,'$1,');
						
		}

		// 최종 가격 문장
		var result_jewPrice = jewPrice;
		var result_inputTotalprice = inputTotalprice;
		var result_totalprice = totalprice;
		$('#jewPrice').val(result_jewPrice);
		$('#inputTotalprice').val(result_inputTotalprice);
		$('#totalprice').val(result_totalprice);

// + 버튼을 누르면 수량 증가 , 결제 금액 증가
$('#plusbtn').click(function() {
		// 사업자가 설정한 재고량 
		var _jewStock = $('#jewStock').val();
		var jewStock = parseInt(_jewStock);
		// 사용자가 선택하는 수량
		var _qty = $('#inputQuantity').val();
		var qty = parseInt(_qty);
		// 사업자가 설정한 개 당 가격 
		var jewPrice = $('#jewPrice').val();
			jewPrice = removecomma(jewPrice); // 페이징 로딩 될때 설정했던 콤마 제거

function removecomma(pStr) {
			var strCheck = /\,/g;
			pStr = pStr.replace(strCheck,'');
			return pStr;
										
			}

			var qty_result; // 사용자가 선택한 총 수량
			var totalprice; // 사용자가 선택한 총 가격
			var inputTotalprice; // 사용자가 선택한 총 가격

			if (qty < jewStock) {// 사용자가 선택하는 수량이 사업자가 설정한 재고수량 미만이면 + 1 처리 
					// 수 증가
					qty_result = qty + 1;
					// 파라미터로 넘어갈 총 금액
					totalprice = jewPrice * qty_result; // 실제 DB로 넘어갈 결제 총 금액
					totalprice = addcomma(totalprice);
					// 사용자에게 보여줄 가짜 총 금액
				    inputTotalprice = jewPrice * qty_result; // 가짜 총 금액(사용자에게 보여줄 용도)
					inputTotalprice = addcomma(inputTotalprice);
				
			} else {//사용자가 선택하는 수량이 사업자가 설정한 재고 초과이면 + 0 처리 
					qty_result = qty;

					// 파라미터로 넘어갈 총 금액
					totalprice = jewPrice * qty_result; // 실제 DB로 넘어갈 결제 총 금액
					totalprice = addcomma(totalprice);
					// 사용자에게 보여줄 가짜 총 금액
					inputTotalprice = jewPrice * qty_result; // 가짜 총 금액(사용자에게 보여줄 용도)
					inputTotalprice = addcomma(inputTotalprice);

								
					}

				$('#inputQuantity').val(qty_result);
				$('#qty').val(qty_result);
				$('#totalprice').val(totalprice);
				$('#inputTotalprice').val(inputTotalprice);
								
		});

// - 버튼을 누르면 수량 감소 , 결제 금액 감소
$('#minusbtn').click(function() {
		var _inputQuantity = $('#inputQuantity').val();
		var qty = parseInt(_inputQuantity);
		var qty_result;
		// 사업자가 설정한 개당 가격 
		var jewPrice = $('#jewPrice').val();

		jewPrice = removecomma(jewPrice); // 페이징 로딩 될때 설정했던 콤마 제거

	function removecomma(pStr) {
			var strCheck = /\,/g;
			pStr = pStr.replace(strCheck, '');
			return pStr;
		}

		var totalprice; // 사용자가 선택한 총 가격
		var inputTotalprice; // 사용자가 선택한 총 가격

		if (qty >= 2) { // 최소값은 1로 남겨놔야함

			qty_result = qty - 1;

			totalprice = qty_result * jewPrice;
			totalprice = addcomma(totalprice);
			inputTotalprice = qty_result * jewPrice;
			inputTotalprice = addcomma(inputTotalprice);
							
		} else {
			
			qty_result = 1
			totalprice = qty_result * jewPrice;
			totalprice = addcomma(totalprice);
			inputTotalprice = qty_result * jewPrice;
			inputTotalprice = addcomma(inputTotalprice);
		}
							
		$('#inputQuantity').val(qty_result);
		$('#qty').val(qty_result);
		$('#totalprice').val(totalprice);
		$('#inputTotalprice').val(inputTotalprice);
				
				});
					
});