$(document).ready(function() {
	init();
})

function init(){
	deleteArticle();
	editArticle();
}

function editArticle(){
	$(".editObject").each(function(){
		$(this).click(function(){
			var id = $(this).parents("tr").children(".object_id").text()
			var url = "/admin/editArticlePage.html?id=" + id;
			$.alert({
		        title: '嗨',
		        content: '你确认要修改这篇文章吗？',
				buttons: {
					confirm: {
						text: '确认',
						btnClass: 'btn-primary',
						action: function(){
							window.location.href = url;
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

function deleteArticle(){
	$(".deleteObject").each(function(){
		$(this).click(function(){
			var url = "/admin/deleteArticle";
			var data = {
				article_id : $(this).parents("tr").children(".object_id").text()	
			};
			var this_ = $(this);
			$.alert({
		        title: '嗨',
		        content: '你确认要删除这篇文章吗？',
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

