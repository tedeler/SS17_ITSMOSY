function initialize(){
//	alert("Hello World");
/* mehrzeiliger
	Kommentar
*/
	
	// Beispiel Text der Überschrift verändern
	let ueberschrift 
		= document.getElementById("gruene_ueberschrift");
	ueberschrift.innerHTML = "neue Ueberschrift";
	ueberschrift.style["color"] = "rgb(255, 0, 0)";
	let fontSize = 72;
	ueberschrift.style["font-size"] = fontSize + "px";
	
	// Eventhandler für den Slider
	function onSliderChanged(){
		let sliderRed = document.getElementById("sliderRed");
		let value = sliderRed.value;
		
		let labelRed = document.getElementById("labelRed");
		labelRed.innerHTML = value;
	}
	
	let sliderRed = document.getElementById("sliderRed");
	sliderRed.addEventListener("input", onSliderChanged);
	
	
}