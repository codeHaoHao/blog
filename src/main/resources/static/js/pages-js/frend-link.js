$(document).ready(function() {
	init();
})

function init(){
	createFrendLink();
	deleteFrendLink();
	editFrendLink();
}

function editFrendLink(){
	$(".editObject").each(function(){
		$(this).click(function(){
			var id = $(this).parents("tr").children(".object_id").text();
			var old_name = $(this).parents("tr").children(".frendLink_name").text();
			var old_url = $(this).parents("tr").children(".frendLink_url").text();
			$("input[name='edit_id']").val(id);
			$("input[name='edit_name']").val(old_name);
			$("input[name='edit_url']").val(old_url);
		})
	})
	
	// edit save button
	$("#editFrendLinkButton").on("click",function(){
		var url = "/admin/editFrendLink";
		var data = {
				id : $("input[name='edit_id']").val(),
				name : $("input[name='edit_name']").val(),
				url : $("input[name='edit_url']").val()
		}
		$.ajax({
			type : "POST",
			url : url,
			data : data,
			success : function(result){
				if(result.success){
					echoSuccess2(result.message);
				} else {
					echoError(result.message);
				}
			}
		})
	})
}

function deleteFrendLink(){
	$(".deleteObject").each(function(){
		$(this).click(function(){
			var url = "/admin/deleteFrendLink";
			var data = {
				id : $(this).parents("tr").children(".object_id").text()	
			};
			var this_ = $(this);
			$.alert({
		        title: '嗨',
		        content: '你确认要删除这条信息吗？',
				buttons: {
					confirm: {
						text: '确认',
						btnClass: 'btn-primary',
						action: function(){
							
							$.ajax({
								type : "POST",
								url : url,
								data : data,
								success : function(result) {
									if(result.success){
										this_.parents("tr").remove();
										echoSuccess(result.message);
									} else {
										echoError(result.message);
									}
								}
							})
						}
					},
					cancel: {
						text: '取消'
					}
				}
		    });
			
		})
	})
}

function createFrendLink(){
	$("#saveFrendLink").on("click",function(){
		var url = "/admin/createFrendLink";
		var data = {
			name : $("input[name='name']").val(),
			url : $("input[name='url']").val()
		};
		
		$.ajax({
			type:"POST",
			url:url,
			data:data,
			success:function(result){
				if(result.success){
					echoSuccess2(result.message)
				} else {
					echoError(result.message);
				}
			}
		})
	})
}

function echoSuccess(message) {
	$.confirm({
        title: '成功',
        content: message,
        type: 'green',
        buttons: {
            omg: {
                text: '谢谢',
                btnClass: 'btn-green',
            },
            close: {
                text: '关闭',
            }
        }
    });
}

function echoSuccess2(message) {
	$.confirm({
        title: '成功',
        content: message,
        type: 'green',
        buttons: {
            omg: {
                text: '谢谢',
                btnClass: 'btn-green',
                action : function(){
                	window.location.reload();
                }
            },
            close: {
                text: '关闭',
            }
        }
    });
}

function echoError(message) {
	$.confirm({
        title: '错误提示',
        content: message,
        type: 'red',
        typeAnimated: true,
        buttons: {
            tryAgain: {
                text: '知道了',
                btnClass: 'btn-red',
            },
            close: {
                text: '关闭'
            }
        }
    });
}

