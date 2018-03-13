//Вставить новый элемент в массив строк (слов), раздвинув его для этого вправо.. А самый правый при этом пусть теряется
package home14.sheepSleep;

public class MoveRight
{
	public static void main(String[] args)
	{
		String[] words = { "board", "bag", "compare", "mouse", "keyboard", "nothing" };

		for (int i = 0; i < words.length; i++)
		{
			System.out.print(words[i] + " ");
		}
		System.out.println();

		String newElement = "New";
		int position = (int) (Math.random() * words.length + 1);

		for (int i = words.length - 1; i > position - 1; i--)
		{
			words[i] = words[i - 1];
		}
		words[position - 1] = newElement;
		for (int i = 0; i < words.length; i++)
		{
			System.out.print(words[i] + " ");
		}
		System.out.println();
	}
}
