function validate() {
		var username = document.form.login.value;
		var password = document.form.pass.value;
		if (username == "") {
			alert("Enter Username!");
			return false;
		}
		if (password == "") {
			alert("Enter Password!");
			return false;
		}
		return true;
	}