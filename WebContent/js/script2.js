function validate2() {
	var username = document.form2.alogin.value;
	var email = document.form2.aemail.value;
	var password = document.form2.apass.value;
	var password2 = document.form2.apass2.value;
	if (username == "") {
		alert("Enter Username!");
		return false;
	}
	if (email == "") {
		alert("Enter Email!");
		return false;
	}
	if (password == "") {
		alert("Enter Password!");
		return false;
	}
	if (password2 == "") {
		alert("Enter Password!");
		return false;
	}
	if (password2 != password) {
		alert("Check Password!");
		return false;
	}

	return true;
}