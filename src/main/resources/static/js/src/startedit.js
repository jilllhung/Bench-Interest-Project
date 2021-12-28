



document.addEventListener(
	//'click', () => document.getElementById('expnametext').style.color = "red"
	'click', () => switchToEdit("expnametext")
)

function switchToEdit(id) {
	document.getElementById(id).style.color = "red";
}

