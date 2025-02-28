public class IPCutter
{
	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			System.out.println("Please Enter the IP!");
		}
		else
		{
			String s1 = args[0];
			int start = 0;
			int end = s1.length();
			int index = s1.indexOf(".",start);
			while(index != -1)
			{
				System.out.println(s1.substring(start,index));
				start = index+1;
				index = s1.indexOf(".",start);
			}
			System.out.println(s1.substring(start));
		}

	}
}
