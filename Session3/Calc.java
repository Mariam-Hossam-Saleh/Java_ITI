public class Calc
{
	public static void main(String[] args)
	{
		if(args.length != 3)
		{
			System.out.println("Wrong Number of args!");
		}
		else
		{	
			int parameter1 = Integer.parseInt(args[0]);
			int parameter2 = Integer.parseInt(args[2]);
			switch(args[1])
			{
				case "+" :
					System.out.println(parameter1 + parameter2);
				break;
				case "-" :
					System.out.println(parameter1 - parameter2);
                        	break;
				case "x" :
					System.out.println(parameter1 * parameter2);
                        	break;
				case "/" :
					if(parameter2 == 0)
					{
						System.out.println("Invalid Division by Zero!");
					}
					else
					System.out.println(parameter1 / parameter2);
                        	break;
				default :
					System.out.println("Wrong Operation !");
			}
		}
	}
}

