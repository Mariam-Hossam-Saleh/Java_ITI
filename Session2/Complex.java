class Complex
{
	private int real;
	private int img;
	Complex()
	{
		real = 0 ;
		img = 0 ;
	}
	Complex(int r, int i)
	{
		real = r ;
		img = i;
	}
	public static Complex sum(Complex c1, Complex c2)
	{
		Complex res = new Complex();
		res.real = c1.real + c2.real;
		res.img = c1.img + c2.img;
		return res;
	}
	public static Complex sub(Complex c1, Complex c2)
	{
		Complex res = new Complex();
		res.real = c1.real - c2.real;
		res.img = c1.img - c2.img;
		return res;
	}
	public void print()
	{
		if((real > 0) && (img > 0))
		{
			System.out.println(real + "+" + img + "i");
		}
		else if((real > 0) && (img < 0))
		{
			System.out.println(real + "-" + img + "i");
		}
		else if((real < 0) && (img < 0))
		{
			System.out.println(real +""+ img + "i");
		}
	}
}

class mainComplex
{
	public static void main(String[] args)
	{
		Complex myComp1 = new Complex(1,2);
		Complex myComp2 = new Complex(3,4);
		Complex myComp3 = new Complex();
		myComp3 = Complex.sum(myComp1,myComp2);
		System.out.print("Sum = ");
		myComp3.print();
		myComp3 = Complex.sub(myComp1,myComp2);
		System.out.print("Sub = ");
		myComp3.print();
	}
}
