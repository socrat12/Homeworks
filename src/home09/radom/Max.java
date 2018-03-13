package home09.radom;

public class Max
{
	private final static int MASSLENGTH = 100000000;

	public static void main(String[] args)
	{
		int[] mass = new int[MASSLENGTH];

		for (int i = 0; i < MASSLENGTH; i++)
		{
			mass[i] = i;
		}

		int big = mass[0];

		long time = System.currentTimeMillis();

		for (int i = 0; i < mass.length; i++)
		{
			if (big < mass[i])
			{
				big = mass[i];
			}
		}
		System.out.println("Time - " + (System.currentTimeMillis() - time) / 1000f);

		System.out.println("Biggest: " + big);
		
		time = System.currentTimeMillis();

		big = mass[0];
		for (int i = 0; i < mass.length; i++)
		{
			big = Math.max(big, mass[i]);
		}
		System.out.println("Time - " + (System.currentTimeMillis() - time) / 1000f);

		System.out.println("Biggest: " + big);
				
	}
}