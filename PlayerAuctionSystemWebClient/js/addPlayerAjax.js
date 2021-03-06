var flag = true;

function validateTeamName() {
	var teamName = document.getElementById('teamName').value;
	var regex = /^[A-Z][a-z]*(\s[A-Z][a-z]*)*$/;
	if (regex.test(teamName)) {
		// alert("Valid Team Name");
		document.getElementById('errorTeamName').innerHTML = "";
		flag = true;
	} else {
		// alert("Invalid Team Name");
		// document.getElementById('errorTeamName').style.visibility =
		// "visible";
		document.getElementById('errorTeamName').innerHTML = "<font color=red>Invalid Team Name</font>";
		flag = false;
	}

}

function validatePlayerName() {
	document.getElementById('errorPlayerName').innerHTML = "";
	var playerName = document.getElementById('playerName').value;
	var regex = /^[A-Z][a-z]*(\s[A-Z][a-z]*)*$/;
	if (regex.test(playerName)) {

		// alert("Valid Player Name");
		document.getElementById('errorPlayerName').innerHTML = "";
		flag = true;
		// document.getElementById('lblPlayerName').style.visibility = "hidden";
	} else {
		console.error("Invalid Player Name");
		document.getElementById('errorPlayerName').innerHTML = "<font color=red>Invalid Player Name</font>";
		// document.getElementById('lblPlayerName').style.visibility =
		// "visible";
		flag = false;
	}

}

function validateCategory() {
	var category = document.getElementById('category').value;
	// var regex = /["batsman"|"bowler"|"allrounder"]/i;
	if (category == 'select') {
		// alert("Invalid category");
		document.getElementById('errorCategory').innerHTML = "<font color=red>Invalid Category</font>";
		flag = true;
	} else {
		document.getElementById('errorCategory').innerHTML = "";
		// alert("Valid category");
		flag = false;
	}

}

function validateHighestScore() {
	var highestScore = document.getElementById('highestScore').value;
	if (highestScore <= 0 || highestScore == ""){
		document.getElementById('errorHighestScore').innerHTML = "<font color=red>Invalid Highest Score</font>";
		flag = false;
	}
	else if (document.getElementById('category').value == "batsman") {
		if (highestScore <= 50){
			document.getElementById('errorHighestScore').innerHTML = "<font color=red>Invalid Highest Score</font>";
			flag = false;
		}
		else{
			document.getElementById('errorHighestScore').innerHTML = "";
			flag = true;
		}
	} else{
		document.getElementById('errorHighestScore').innerHTML = "";
		flag = true;
	}

}

function validateBestFigure() {
	var bestFigure = document.getElementById('bestFigure').value;
	var regx = /^\d{1,2}\/\d{1,3}$/;
	if (!regx.test(bestFigure)) {
		document.getElementById('errorBestFigure').innerHTML = "<font color=red>Invalid Best Figure</font>";
		flag = false;
	} else{
		document.getElementById('errorBestFigure').innerHTML = "";
		flag = true;
	}

}

function loadData() {

	var url = "http://localhost:8080/PlayerAuctionSystemWeb_v1/getCategories";
	var url1 = "http://localhost:8080/PlayerAuctionSystemWeb_v1/getTeamName";
	var method = "GET";
	// practice $.ajax yourself
	$.get(url, function(data) {
		// $(".result").html(data);
		// alert("Data was received.");
		// alert(data);
		// console.log(data);
		var dataText = "";
		dataText += "<option value='select'>Select</option>";
		for ( var key in data) {
			// console
			// .log(data[key].categoryKey + " : "
			// + data[key].categoryValue);
			// console.log();
			dataText += "<option value='" + data[key].categoryKey + "'>"
					+ data[key].categoryValue + "</option>"
		}

		// console.log(dataText);
		$('#category').html(dataText);

	});

	/*
	 * $.get(url1, function(data, textStatus, jqXHR) { //
	 * $(".result").html(data); // alert("Data was received."); // alert(data); //
	 * console.log(data); console.log(textStatus); console.log(jqXHR.status); if
	 * (jqXHR.status == 500) { alert("Some error"); console.err(data.error[0]);
	 * $('#errorTeamName').html( "<font color=red>" + data.error[0] + "</font>"); }
	 * 
	 * var dataText = ""; dataText += "<option value='select'>Select</option>";
	 * for ( var key in data.data) { // console // .log(data[key].categoryKey + " : " // +
	 * data[key].categoryValue); // console.log(); dataText += "<option
	 * value='" + data.data[key].teamNameKey + "'>" +
	 * data.data[key].teamNameValue + "</option>" }
	 * 
	 * console.log(dataText); $('#teamName').html(dataText);
	 * 
	 * });
	 * 
	 */

	$.get(
			url1,
			function(data, status) {
				var dataText = "";
				dataText += "<option value='select'>Select</option>";
				for ( var key in data.data) {
					// console
					// .log(data[key].categoryKey + " : "
					// + data[key].categoryValue);
					// console.log();
					dataText += "<option value='" + data.data[key].teamNameKey
							+ "'>" + data.data[key].teamNameValue + "</option>"
				}

				console.log(dataText);
				$('#teamName').html(dataText);
			}).fail(
			function(data) {
				// alert("Some error");
				console.error(data.responseJSON);
				$('#errorTeamName').html(
						"<font color=red>" + data.responseJSON.error[0]
								+ "</font>");
			});

}

//const submitButton = document.querySelector(".submitBtn");

const submitButton = document.querySelector("input[value='Submit']");
/*
https://www.codegrepper.com/code-examples/javascript/javascript+onclick+event+listener

element.addEventListener("click", function(){ 
   element.innerText = "something"; 
}); 

*/

submitButton.addEventListener("click", () => {
	var categoryVal = $("select[name='category']").val();
	//console.log(category);
	var categoryOptionSelected = $("select[name='category'] option:selected");
	//console.log(categoryOptionSelected);
	var teamName = $("select[name=teamName]");
	//console.log(teamName);
	//console.log(teamName.val());
	//const teamNameElement = document.querySelector("input[name='teamName']");
	const teamNameElement = document.querySelector("input#teamName");
	//console.log('teamNameElement');
	//console.log(teamNameElement);
	//console.log("teamNameElement value -"+teamNameElement);
	var key = 'some dynamic data generated on server';
	var player_url = "http://localhost:8080/PlayerAuctionSystemWeb_v1/addPlayerAjax";
	var data = { playerName: $("input#playerName").val(), category : categoryOptionSelected.val(), highestScore : $("input.highestScore").val(), bestFigure : $("input#bestFigure").val(), teamName : teamName.val()}
	if(flag){
		console.log(data);	
		$.ajax({
			url: player_url,
			type: 'POST',
			data: data,
			headers: { 'AUTH': key, 'Accept':'application/json' },
					//async: false,
				success: function( response, status,xhr){
					console.log(response);
					console.log(status);
					//json = JSON.parse(data);
					//console.log(json);
					var data = response.data;
					var text = '<font color=green>'+ data+ '</font>';
					$("span[id='message']").html(text);
				},
				error: function( jqXhr, textStatus, errorThrown ){
					console.log( errorThrown );
					console.log( jqXhr.responseJSON.error[0] );
					var text = '<font color=red>'+ jqXhr.responseJSON.error[0] + '</font>';
					$("span[id='message']").html(text);
					}
			});
		
	}
	
});