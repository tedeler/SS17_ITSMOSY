function initialize(){
	// define event listener
	function onSliderChanged(){
		// get the R, G, B values from the slider
		let slider = document.getElementById("slider-red");
		let red = slider.value;
		
		slider = document.getElementById("slider-green");
		let green = slider.value;

		slider = document.getElementById("slider-blue");
		let blue = slider.value;
		
		// set the background color of the body tag 
		let body = document.getElementById("body");
		body.style["background-color"] 
// oder:				= `rgb(${red}, ${green}, ${blue})`;
		= "rgb(" + red + "," + green + "," + blue + ")";
	}
	
	// set event listener
	let redSlider = document.getElementById("slider-red");
	redSlider.addEventListener("input", onSliderChanged);
	let greenSlider = document.getElementById("slider-green");
	greenSlider.addEventListener("input", onSliderChanged);
	let blueSlider = document.getElementById("slider-blue");
	blueSlider.addEventListener("input", onSliderChanged);
	// initialize the color
	onSliderChanged();

}