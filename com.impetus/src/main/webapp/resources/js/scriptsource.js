function activate(bookid) {
	var id = 'add' + bookid;
	var x = document.getElementById(id);

	x.className = "btn btn-defaultOrder disabled";
	x.disabled = true;
}

function ajaxRecommend(userid) {
	
	var userId = "userId=" + userid
	$.ajax({

		url : "recommend.htm",
		type : "POST",
		cache : false,
		data : userId,
		success : function(result) {

			$("#recommendations").html(result);

		},
		error : function() {
			alert("failed");
		}
	});

}

function ajaxViewShelf(userid) {
	
	var userId = "userId=" + userid;
	$.ajax({

		url : "viewShelf.htm",
		type : "GET",
		cache : false,
		data : userId,
		success : function(result) {
			
			document.getElementById("stage").innerHTML = result;
			$('#shelf').dataTable();
			 $('#shelf').removeClass('display').addClass(
					'table table-hover table-bordered');
	
			
		},
		error : function(xhr, status, error) {
			alert(xhr.responseText);
			console.log(xhr.status+"\t"+xhr.statusText);
			// alert("error"+error+status+xhr);
		}
	});

}

function ajaxBooksHeld(userid) {
	
	var userId = "userId=" + userid
	$.ajax({

		url : "booksheld.htm",
		type : "GET",
		cache : false,
		data : userId,
		success : function(result) {

			$("#showbooks").html(result);

		},
		error : function() {

		}
	});

}

function ajaxBooksRequested(userid) {
	
	var userId = "userId=" + userid
	$.ajax({

		url : "bookrequested.htm",
		type : "GET",
		cache : false,
		data : userId,
		success : function(result) {

			$("#booksrequested").html(result);

		},
		error : function() {

		}
	});

}

function ajaxViewPlan(userid) {
	
	var userId = "userId=" + userid
	$.ajax({

		url : "viewPlan.htm",
		type : "GET",
		cache : false,
		data : userId,
		success : function(result) {
			$("#plan").html(result);
		},
		error : function() {

		}
	});

}

function ajaxHistory(userid) {
	
	var userId = "userId=" + userid
	$.ajax({

		url : "bookHistory.htm",
		type : "GET",
		cache : false,
		data : userId,
		success : function(result) {
			document.getElementById("history").innerHTML = result;
			$('#historytable').dataTable();
			 $('#historytable').removeClass('display').addClass(
					'table table-hover table-bordered');
		},
		error : function() {
			alert("failure");
		}
	});

}

function ajaxViewProfile(userid) {
	
	var userId = "userId=" + userid
	$.ajax({

		url : "viewProfile.htm",
		type : "GET",
		cache : false,
		data : userId,
		success : function(result) {
			
			$("#profile").html(result);
			 
		},
		error : function() {

		}
	});

}

function ajaxNewPlan(userid) {
	
	var userId = "userId=" + userid
	$.ajax({

		url : "view.htm",
		type : "GET",
		cache : false,
		data : userId,
		success : function(result) {
			$("#newplan").html(result);
		},
		error : function() {

		}
	});

}

function ajaxOrderBook(bookid, address, userid) {

	
	// clickButton();
	var bookId = "bookId=" + bookid;
	var userId = "userId=" + userid;
	var address = "address=" + address;
	
	document.getElementById("message").style.display = 'block';
	$.ajax({
		url : "order.htm",
		type : "GET",
		cache : false,
		async:true,
		data : bookId + "&" + userId + "&" + address,

		success : function(response) {
		
			
			var str = response;
			var id = 'order' + bookid;
			var id1 = 'order1' + bookid;
			var x = document.getElementById(id);
			var y = document.getElementById(id1);
			x.className = "btn btn-defaultOrder disabled";
			$("#message").html(response);
			x.disabled = true;
			if (response == "ordered") {
				x.innerHTML = response;
				y.innerHTML = response;
				y.data('disabled', true);
				x.data('disabled', true);
				$("#message").html(response);
			} else
				$("#message").html(response);

		},

		error : function(response) {
			alert("Failure");
			alert("Cannot fulfill the request");
			var id = 'exception';
			var x = document.getElementById(id);
			x.innerHTML = response;
		}
	});
}

function ajaxShelf(bookid, userid) {
	document.getElementById("message").style.display = 'block';
	
	var bookId = "bookId=" + bookid;
	var userId = "userId=" + userid
	$.ajax({
		url : "addtoshelf.htm",
		type : "GET",
		cache : false,
		data : bookId + "&" + userId,

		success : function(response) {
			
			var id = 'add' + bookid;
			var id1 = 'message';
			var x = document.getElementById(id);
			var y = document.getElementById(id1);
			/* x.className ="btn btn-defaultShelf disabled"; */
			x.disabled = true;

			/*
			 * x.innerHTML=response; y.innerHTML=response;
			 */

		},

		error : function() {
			alert("Failure");
		}
	});
}


var ajaxRemove=function(bookid,userid){
	
	
	var bookId = "bookId="+bookid;
	var userId="userId="+userid;
		   $.ajax({
			    url : "remove.htm",
			    type: "GET",
			    cache:false,
			    data : bookId+"&"+userId,
	
	 success: function(response)
			    {
			    	
			    	var str=response;
			    	var i='remove'+bookid;
			    	var id='order'+bookid;
			    	var x=document.getElementById(id);
			    	var y=document.getElementById(i);
			    	x.className ="btn btn-defaultRemove disabled";
			    	
			    	x.disabled=true;
			    	y.className ="btn btn-defaultRemove disabled";
			    	y.disabled=true;
			    	if(str=="Removed")
		    		{
			    	 x.innerHTML=response;
			    	
			    		}
			    	else
			    		$("#message").html(response); 


 		       
			    },
			
		   error: function(response)
		    {
		 		alert("Failure");
		 		alert("Cannot fulfill the request");
		 		
		    }});
};  

/*
 * <!------------------------------------------------------Admin-------------------------------------------------------------------------------->
 */

function ajaxViewAll() {
		
	$.ajax({
		url : "viewalluser.htm",
		type : "GET",
		cache : false,
		async : false,
		success : function(result) {
			$("#stage1").html(result);
			$('#viewtable').dataTable();
			 $('#viewtable').removeClass('display').addClass(
					'table table-hover table-bordered');
		}
	});

}

function ajaxEdit(bookid) {

	var bookid = "bookid=" + bookid;
	$.ajax({
		url : "updatebook.htm",
		type : "GET",
		cache : false,
		async : false,
		data : bookid,
		success : function(result) {
			$("#stage").html(result);

		}
	});

}

function ajaxDeliveryRequests() {

	
	$.ajax({
		url : "deliveryRequest.htm",
		type : "GET",
		cache : false,
		async : false,
		success : function(result) {
			$("#deliveryRequest").html(result);

		}
	});

}

function ajaxReturnRequests() {

	
	$.ajax({
		url : "returnRequest.htm",
		type : "GET",
		cache : false,
		async : false,
		success : function(result) {
			$("#returnRequest").html(result);

		}
	});

}

function ajaxDelete(bookid) {

	var bookId = "bookId=" + bookid;
	var buttonid = "del" + bookid;
	$.ajax({

		url : "delete.htm",
		type : "GET",
		cache : false,
		data : bookId,
		success : function(res) {
			
			var id = '#' + "del" + bookid;
			$("#" + buttonid).attr("disabled", "disabled");
			$("#" + bookid).attr("disabled", "disabled");
			$(id).html(res);
		},
		error : function() {

		}
	});

}

function ajaxReports() {

	
	$.ajax({
		url : "admin_Reports.htm",
		type : "GET",
		async : false,
		success : function(result) {
			
			$("#reports").html(result);

		},
		fail : function() {
			alert("fail");
		}
	});

}

/*
 * <!------------------------------------------------------Admin
 * end-------------------------------------------------------------------------------->
 */
