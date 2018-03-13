package home06.dragon;
//9. Вычислить максимально возможное значение силы трёх драконов
public class dragon
{

	public static void main(String[] args)
	{
		int sum = 50000, num = 0;

		if (sum < 3)
		{
			System.out.println("Max for three dragons: " + sum);
			System.exit(0);
		}
		long time = System.currentTimeMillis();

		int comp, max = 1;

		for (int dr1 = sum-2; dr1 > 0; dr1--)
		{
			for (int dr2 = sum - 1 - dr1; dr2 > 0; dr2--)
			{
				int dr3 = sum - dr1 - dr2;
				comp = dr1 * dr2 * dr3;
				num++;
				if (comp > max)
				{
					max = comp;
				}
			}
		}
		System.out.println(num);
		System.out.println("Max for three dragons: " + max);
		System.out.println("Time - " + (System.currentTimeMillis() - time) / 1000f);
	}
}