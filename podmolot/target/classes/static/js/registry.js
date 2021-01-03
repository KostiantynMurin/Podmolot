function addClasses (domElement, classes) 
{
 	for (var i = classes.length - 1; i >= 0; i--) 
 	{
		emailInputField.classList.add(classes[i]);
	}
}

function removeClasses (domElement, classes) 
{
	for (var i = classes.length - 1; i >= 0; i--) 
 	{
		emailInputField.classList.remove(classes[i]);
	}
}

function sendData (url, jsonData) {
	var httpRequest;
	if (window.XMLHttpRequest) { // Mozilla, Safari, ...
    	httpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE
    	httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	httpRequest.open("POST", url, true); 
	httpRequest.setRequestHeader("Content-Type", "application/json");
	httpRequest.onreadystatechange = function() {
   		if (this.readyState == 4 && this.status == 200) {
     		console.log(this.responseText);
   		}
	};
	httpRequest.send(JSON.stringify(jsonData));
}

var emailInputField = document.getElementById('email');
var dangerClasses = ['border', 'border-danger'];
var sucsessClasses = ['border', 'border-success'];
emailInputField.mouseleave(function(event) {
	var data = {field:'mail', value:this.value};
	sendData('/user/registry/validate', data);
});
