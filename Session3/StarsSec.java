public class StarsSec
{
        public static void main(String[] args)
        {
                String star = "*";
                String space = " ";
                for(int i = 1 ; i <=  Integer.parseInt(args[0]) ; i++)
                {
                        for(int j = 0 ; j <=  Integer.parseInt(args[0])*2 + 1; j++)
                        {
				if(j < i)
				{
					System.out.print(star);
				}
				else if(j > Integer.parseInt(args[0])*2+1-i)
				{
					System.out.print(star + " ");
				}
				else
				{
					System.out.print(space);
				}
                        }
			System.out.println();
		}
        }
}
