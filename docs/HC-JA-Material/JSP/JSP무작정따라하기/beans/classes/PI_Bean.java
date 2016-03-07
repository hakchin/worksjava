package firstBean;

public class PI_Bean{
	private int a=10;
	private double PI=3.14;
	private double area;
	
	public void setA(int a){	 this.a=a;	}
	public void setPI(double PI){	this.PI=PI;	}
	public void setArea(double area){	this.area=area;	}
	public int getA(){	return a; }
	public double getPI(){	return PI;	}
	public double getArea(){	return area;	}

	public double area(){
		area=PI*a*a;

		return area;
	}


}