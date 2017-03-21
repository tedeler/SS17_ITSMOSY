function initialize(){
	// define event listener
	function onSliderChanged(){
		// get the R, G, B values from the slider
		var slider = document.getElementById("slider-red");
		var red = slider.value;
		
		slider = document.getElementById("slider-green");
		var green = slider.value;

		slider = document.getElementById("slider-blue");
		var blue = slider.value;
		
		// set the background color of the body tag 
		var body = document.getElementById("body");
		body.style["background-color"] 
				= "rgb(" + red + "," + green + "," + blue + ")";
	}
	
	// set event listener
	var redSlider = document.getElementById("slider-red");
	redSlider.addEventListener("input", onSliderChanged);
	var greenSlider = document.getElementById("slider-green");
	greenSlider.addEventListener("input", onSliderChanged);
	var blueSlider = document.getElementById("slider-blue");
	blueSlider.addEventListener("input", onSliderChanged);
	// initialize the color
	onSliderChanged();

}