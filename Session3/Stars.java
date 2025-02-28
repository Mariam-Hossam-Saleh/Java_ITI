public class Stars
{
	public static void main(String[] args)
	{
		String star1 = "*";
	        String space = "";
		String star2 = "*";
		for(int i = 0 ; i < 2*Integer.parseInt(args[0]); i++)
		{
			space += " ";
		}	
		for(int j = 0 ; j <  Integer.parseInt(args[0]) ; j++)
		{
			System.out.println(star1 + space.substring(0,2*(Integer.parseInt(args[0])-j)) + star2);
			star1 += "*";
			star2 += " *";
		}
	}
}
