abstract class GeoShape
{
    protected double dim1;
    protected double dim2;
    abstract public double CalcArea(); 
}

class Rect extends GeoShape
{
    Rect(double d1, double d2)
    {
        dim1 = d1;
        dim2 = d2;
    }
    public double CalcArea()
    {
        return dim1 * dim2;
    } 
}

class Triangle extends GeoShape
{
    Triangle(double d1, double d2)
    {
        dim1 = d1;
        dim2 = d2;
    }
    public double CalcArea()
    {
        return 0.5 * dim1 * dim2;
    } 
}

class Circle extends GeoShape
{
    Circle(double d1, double d2)
    {
        dim1 = d1;
        dim2 = d2;
    }
    public double CalcArea()
    {
        return 3.14 * dim1 * dim1;
    } 
}

class mainGeoShape
{
    public static void main(String[] args)
    {
        GeoShape rect = new Rect(1,2);
        GeoShape circle = new Circle(3,4);
        GeoShape triangle = new Triangle(5,6);
        double res = SumArea(rect,circle,triangle);
        System.out.println(res);

    }
    static double SumArea(GeoShape s1,GeoShape s2,GeoShape s3)
    {
        return (s1.CalcArea()+s2.CalcArea()+s3.CalcArea());
    }
}

