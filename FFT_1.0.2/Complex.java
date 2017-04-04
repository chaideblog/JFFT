//package FFT;

public class Complex{
	short real = 0;
	short image = 0;
	
	Complex(short real, short image) {
		this.real = real;
		this.image = image;
	}
	
	public double getReal() {
		return real;
	}
	
	public double getImage() {
		return image;
	}
	
	public double getAbs() {
		return Math.sqrt(this.real * this.real + this.image * this.image);
	}
	
	public void setReal(short real) {
		this.real = real;
	}
	
	public void setImage(short image) {
		this.image = image;
	}
	/*
	public Complex add(Complex otherNum) {
		return(new Complex(this.real + otherNum.getReal(), this.image + otherNum.getImage()));
	}
	
	public Complex sub(Complex otherNum) {
		return(new Complex(this.real - otherNum.getReal(), this.image - otherNum.getImage()));
	}
	
	public Complex mul(Complex otherNum) {
		return(new Complex(this.real * otherNum.getReal() - this.image * otherNum.getImage(), 
				this.image * otherNum.getReal() + this.real * otherNum.getImage()));
	}
	
	public Complex div(Complex otherNum) {
		double newReal = (this.real * otherNum.getReal() + this.image * otherNum.getImage()) 
				/ (otherNum.getReal() * otherNum.getReal() + otherNum.getImage() * otherNum.getImage());
		double newImage = (this.image * otherNum.getReal() - this.real * otherNum.getImage()) 
				/ (otherNum.getReal() * otherNum.getReal() + otherNum.getImage() * otherNum.getImage());
		return(new Complex(newReal, newImage));
	}
	
	public Complex exp() {
		Complex expReal = new Complex(Math.exp(this.real), 0);
		Complex expImage = new Complex(Math.cos(this.image), Math.sin(this.image));
		
		return(expImage.mul(expReal));
	}
	*/
	public void show() {
		if (this.image == 0)
			System.out.println(this.real);
		else if (this.real == 0)
			System.out.println("j" + this.image);
		else if (this.image > 0)
			System.out.println(this.real + "+j" + this.image);
		else if (this.image < 0)
			System.out.println(this.real + "-j" + Math.abs(this.image));
	}
}
