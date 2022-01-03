/* ===============================
[ajax] 이메일 중복검사
===============================
*/
$(document).ready(function(){
	$("#buyEmail").blur(function() {
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var buyEmail = $('#buyEmail').val();
		var isCheck = $('#isCheck').val();
		console.log(buyEmail);
		$.ajax({
			url : '/buyer/dupliEmail',
			type : 'get',
			data: {'buyEmail':buyEmail},
			contentType: "applictaion/json; charset=utf-8",
			success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			if (data == '1') {
						// 1 : 이메일이 중복되는 문구
					$("#check_buyEmail").text("사용중인 이메일입니다");
					$("#check_buyEmail").css("color", "red");
					$("#buyer-submit").attr("disabled", true);
			} else {
						
				if(buyEmail == ""){
						$("#check_buyEmail").text("이메일을 입력해주세요");
						$("#check_buyEmail").css('color', 'red');
						$("#buyer-submit").attr("disabled", true);
				} else if(regExp.test(buyEmail) == false) {
						$("#check_buyEmail").text("올바른 이메일 형태가 아닙니다");
						$("#check_buyEmail").css('color', 'red');
						$("#buyer-submit").attr("disabled", true);
				} else {
					$("#check_buyEmail").text("사용 가능한 이메일입니다");
	                $("#check_buyEmail").css('color', '#5080BF');
	                $("#buyer-submit").attr("disabled", false);
				}
			}
				}, error : function(error) {
						console.dir(error)
				}
			});
		});
	});	
/* ===============================
	휴대폰번호 정규표현식
===============================
*/
$(function(){
	$("#buyPhone").blur(function() {
		var regexp = /^[0-9]*$/;
		var buyPhone = $('#buyPhone').val();
		if( !regexp.test(buyPhone) ) {
			$("#check_buyPhone").text("숫자만 입력해주세요");
			$("#check_buyPhone").css('color', 'red');
			$("#buyer-submit").attr("disabled", true);
			$('#buyPhone').val('');
          	$('#buyPhone').focus();
	} else if(buyPhone == ""){
		$("#check_buyPhone").text("휴대전화번호를 입력해주세요");
		$("#check_buyPhone").css('color', 'red');
		$("#buyer-submit").attr("disabled", true);
	} else { 
           	$("#check_buyPhone").text("올바른 휴대폰번호 형태입니다");
			$("#check_buyPhone").css('color', '#5080BF');
			$("#buyer-submit").attr("disabled", false);
	}
});
});	
/* ===============================
	비밀번호 정규표현식
===============================
*/
$(function(){
$("#buyPW").blur(function() {
	var regexp = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	var buyPW = $('#buyPW').val();
	if( !regexp.test(buyPW) ) {
		$("#check_buyPW").text("숫자, 문자, 특수문자 포함 8~15자리 이내로 입력해주세요");
		$("#check_buyPW").css('color', 'red');
		$("#buyer-submit").attr("disabled", true);
		$('#check_buyPW').val('');
      	$('#check_buyPW').focus();
}else if(buyPW == ""){
	$("#check_buyPW").text("비밀번호를 입력해주세요");
	$("#check_buyPW").css('color', 'red');
	$("#buyer-submit").attr("disabled", true);
	
}else { 
       	$("#check_buyPW").text("올바른 비밀번호 형태입니다");
		$("#check_buyPW").css('color', '#5080BF');
		$("#buyer-submit").attr("disabled", false);
}
});
});	
/* ===============================
	비밀번호 확인 일치 검사
===============================
*/
	$(function(){
	$('#buyPW2').blur(function(){
		var buyPW = $('#buyPW').val();
		var buyPW2 = $('#buyPW2').val();
	   if($('#buyPW').val() != $('#buyPW2').val()){
	    	if($('#buyPW2').val()!=''){//비밀번호가 일치하지 않고 공백도 아닐 경우
	    		$("#check_buyPW2").text("비밀번호가 일치하지 않습니다");
				$("#check_buyPW2").css('color', 'red');
				$("#buyer-submit").attr("disabled", true);	
	    		$('#buyPW2').val('');
	          	$('#buyPW2').focus();
	          	//경고text를 화면에 출력하고 submit버튼을 비활성화시킴 
	    		}
	    } else if(buyPW == ""){ //비밀번호 값이 없는 경우
	    	$('#buyPW').focus();
	    	$("#check_buyPW").text("비밀번호를 입력해주세요");
	    	$("#check_buyPW").css('color', 'red');
	    	$("#buyer-submit").attr("disabled", true);
	    } else {//비밀번호가 일치하는 경우,
				$("#check_buyPW2").text("비밀번호가 일치합니다");
	 			$("#check_buyPW2").css('color', '#5080BF');
		    	$("#buyer-submit").attr("disabled", false);
		    	//경고text를 화면에서 숨기고 submit버튼을 활성화시킴	  
	    }
	})  	   
});
/* ===============================
	생년월일 정규표현식
===============================
*/
	$(function(){
		$("#buyBirth").blur(function() {
			var regExp = /([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))/;
			var buyBirth = $('#buyBirth').val();
		if(regExp.test(buyBirth) == false) { //값이 올바른 생년월일 형태가 아닌 경우
				$("#check_buyBirth").text("올바른 생년월일 형태가 아닙니다");
				$("#check_buyBirth").css('color', 'red');
				$("#buyer-submit").attr("disabled", true);
				$('#buyBirth').val('');
	          	$('#buyBirth').focus();
		} else { //값이 존재하고 올바른 생년월일 형태인 경우(YYMMDD)
	           	$("#check_buyBirth").text("올바른 생년월일 형태입니다");
				$("#check_buyBirth").css('color', '#5080BF');
				$("#buyer-submit").attr("disabled", false);
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
			$("#buyer-submit").attr("disabled", true);
			$('#buyName').val('');
          	$('#buyName').focus();
	} else { 
           	$("#check_buyName").text("올바른 이름 형태입니다");
			$("#check_buyName").css('color', '#5080BF');
			$("#buyer-submit").attr("disabled", false);
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
            document.getElementById('buyZipcode').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('buyAddress').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('buyDaddress').focus();
        }
    }).open();
}


  
