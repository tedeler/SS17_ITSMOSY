function initialize(){
	const canvas = document.getElementById("graphics");
	const ctx = canvas.getContext("2d");
	
	ctx.fillStyle = '#FFFF00';
	ctx.fillRect(50, 100, 380, 400);
	ctx.fillStyle = 'rgba(0, 0, 128, 0.8)';
	ctx.fillRect(25, 50, 70, 190);
	
	class Square{
		constructor(x, y, width){
			this.x = x;
			this.y = y; 
			this.width = width;
		}
		draw(context){
			context.fillRect(this.x, this.y, 
							this.width, this.width);
		}
	}
	let square = new Square(10, 10, 30);
	square.x = 200;
	square.draw(ctx);
	
	class ColoredSquare extends Square{
		constructor(x, y, width, color){
			super(x, y, width);
			this.fillStyle = color;
		}
		draw(context){
			context.fillStyle = this.fillStyle;
			super.draw(context);
		}
	}
	let background = ctx.getImageData(20, 40, 70, 70);
	let magentaSquare 
				= new ColoredSquare(20, 40, 70, "magenta");
	magentaSquare.draw(ctx);
	
	// mousemove Eventlistener
/*
	const container = document.getElementById("container");
	function onMouseDown(e){
		const offsetX = e.pageX - magentaSquare.x;
		const offsetY = e.pageY - magentaSquare.y;
		function onMouseMove(e){
			const x = e.pageX;
			const y = e.pageY;
			magentaSquare.x = x - offsetX;
			magentaSquare.y = y - offsetY;
			magentaSquare.draw(ctx);
		}
		container.addEventListener("mousemove", onMouseMove);
		function onMouseUp(e){
			container.removeEventListener("mousemove", onMouseMove);
			container.removeEventListener("mouseup", this);
		}
		container.addEventListener("mouseup", onMouseUp);
	}
	container.addEventListener("mousedown", onMouseDown);
*/	
	const container = document.getElementById("container");
	container.addEventListener("mousedown", (e) => {
		const offsetX = e.pageX - magentaSquare.x;
		const offsetY = e.pageY - magentaSquare.y;
		function onMouseMove(e){
			const x = e.pageX;
			const y = e.pageY;
			ctx.putImageData(background, magentaSquare.x, magentaSquare.y);
			magentaSquare.x = x - offsetX;
			magentaSquare.y = y - offsetY;
			background = ctx.getImageData(magentaSquare.x, magentaSquare.y, magentaSquare.width, magentaSquare.width);
			magentaSquare.draw(ctx);

		}
		container.addEventListener("mousemove", onMouseMove);
		container.addEventListener("mouseup", (e) => {
			container.removeEventListener("mousemove", onMouseMove);
			container.removeEventListener("mouseup", this);
		});
	});
}







