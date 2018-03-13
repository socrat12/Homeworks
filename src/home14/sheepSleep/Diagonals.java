package home14.sheepSleep;
//По матрице A(N,N) построить матрицу B(N,N). Элемент B(I,J) равен максимальному
//из элементов матрицы А принадлежащем части, ограниченной справа диагоналями,
//проходящими через A(I,J).
public class Diagonals {
	
	private static int[][] a = new int[5][5];
	
	public static void main(String[] args) {
		init();
		print(a);
		
		int[][] b = new int[a.length][a.length];
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = maxInDiagonal(i,j,b);
			}
		}
		System.out.println();
		print(b);
	}
	
	private static int maxInDiagonal(int x, int y, int[][] b) {
		int max = -2147483648, n = y;
		for (int i = x; i >= 0; i--) {
			for (int j = 0; j <= n; j++) {
				max = Math.max(a[i][j],max);
			}
			n--;
		}
		for (int i = x; i < a.length; i++) {
			for (int j = 0; j <= y; j++) {
				max = Math.max(a[i][j],max);
			}
			y--;
		}
		return max;
	}
	
	private static void init() {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) (Math.random() * a.length * 40 - a.length * 20);
			}
		}
    }

    private static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.printf("\t%d", array[i][j]);
			}
			System.out.printf("\n\n");
		}
    }
}