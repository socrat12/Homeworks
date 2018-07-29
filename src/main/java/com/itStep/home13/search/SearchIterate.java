package com.itStep.home13.search;

public class SearchIterate
{
	public static void main(String[] args)
	{
		int findMe = 1;
		int[] intArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };
		int start = 0, end = intArray.length - 1;
		while (start <= end)
		{
			int middle = (start + end) / 2;
			if (findMe == intArray[middle])
			{
				System.out.println("Position is: " + middle);
				System.exit(0);
			}
			if (findMe < intArray[middle])
			{
				// уходим левее
				end = middle - 1;
			}
			else if (findMe > intArray[middle])
			{
				// уходим правее
				start = middle + 1;
			}
		}
		System.out.println("Not found");
	}
}
