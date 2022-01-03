
/* ===============================
	 별점 관련
 ===============================
 */
	var rateText = [ "별로예요", "그저그래요", "괜찮아요", "만족해요", "최고예요" ];
	var rateStar = [ "★", "☆" ];
	$(document).ready(function() {
		$('.rateItem').on('click', function(e) {
			let $this = $(this);
			rateThis($this);
		
		});
	
	});

	function rateThis($this) {
		let idx = $this.index();
		$this.closest('div').find('.rateText').text(rateText[idx]);
		$this.parent().find('.rateItem').each(function(index, elem) {
			$(this).text(rateStar[$(this).index() <= idx ? 0 : 1]);
		});	
	}
	
/* ===============================
 리뷰 사진 업로드 관련 
 ===============================
 */
function readURL(input) {
		if (input.files && input.files[0]) {

			var reader = new FileReader();

			reader.onload = function(e) {
				$('.image-upload-wrap').hide();

				$('.file-upload-image').attr('src', e.target.result);
				$('.file-upload-content').show();
				$('.btn-outline-dark').hide();

				$('.image-title').html(input.files[0].name);
			};

			reader.readAsDataURL(input.files[0]);

		} else {
			removeUpload();
		}
	}

	function removeUpload() {
		$('.file-upload-input').replaceWith($('.file-upload-input').clone());
		$('.file-upload-content').hide();
		$('.image-upload-wrap').show();
	}
	$('.image-upload-wrap').bind('dragover', function() {
		$('.image-upload-wrap').addClass('image-dropping');
	});
	$('.image-upload-wrap').bind('dragleave', function() {
		$('.image-upload-wrap').removeClass('image-dropping');
	});
