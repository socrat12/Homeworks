package home24.edinorog;

import java.util.Arrays;

public class TaskResolver {
    private static Uni[] stall = new Uni[6];
    private static char[] stallC = "ROYGBV".toCharArray();

    public static String resolveOneCase(String caseInput) {
	// e.g. caseInput = 6 2 0 2 0 2 0
	// оранжевый - смесь жёлтого и красного
	// фиолетовый - смесь синего и красного
	// зелёный - смесь жёлтого и синего
	// рядом с оранжевым - только синий
	// рядом с зелёным - только карсный
	// рядом с фиолетовым только жёлтый
	
	String[] inputAsArray = caseInput.split(" ");

	// кол-во единорогов
	int N = Integer.parseInt(inputAsArray[0]);

	for (int i = 0; i < stall.length; i++) {
	    stall[i] = new Uni(Integer.parseInt(inputAsArray[i + 1]), stallC[i]);
	}

	//print(stall);

	String answer = resolveTask(N);
	// System.out.println(answer);
	return answer;
    }

    private static String resolveTask(int n) {
	char[] answer = new char[n];

	Arrays.sort(stall, stall[0]);
	System.out.print(0 + ": ");
	print(stall);
	
	answer[0] = stall[0].color;
	stall[0].amount--;
	int prevoius = colorFinder(answer[0]);
	System.out.println(answer);
	
	for (int i = 1; i < answer.length; i++) {
	    Arrays.sort(stall, stall[0]);
	    System.out.print((i+1) + ": ");
	    print(stall);
	    System.out.println(answer);
	    
	    if (stall[positionFinder((prevoius + 3) % 6)].amount > 0) {
		int color = positionFinder((prevoius + 3) % 6);
		prevoius = fill(answer, i, color);
		continue;
	    }
	    
	    if (possibility(answer, i, answer[0], positionFinder(colorFinder(answer[0]))) 
		    && stall[positionFinder(colorFinder(answer[0]))].amount > 0) {
		    prevoius = fill(answer, i, positionFinder(colorFinder(answer[0])));
		    continue;
	    }
	    
	    for (int j = 0; j < stall.length; j++) {
		char color = stall[j].color;
		int current = colorFinder(color);
		
		if (possibility(answer, i, color, current)) {
		    
		    prevoius = fill(answer, i, j);
		    if (stall[j].amount < 0) {
			return "IMPOSSIBLE";
		    }
		    break;
		}
	    }

	}
	
	if (answer[0] == answer[answer.length - 1]) {
	    if (colorFinder(answer[answer.length - 3]) % 2 != 0){
		return "IMPOSSIBLE";
	    }
	    char temp = answer[answer.length - 1];
	    answer[answer.length - 1] = answer[answer.length - 2];
	    answer[answer.length - 2] = temp;
	}
	
	if (answer[answer.length - 3] == answer[answer.length - 2]
		|| colorFinder(answer[answer.length - 1]) % 2 != 0) {
	    return "IMPOSSIBLE";
	}
	
	return new String(answer);
    }

    private static boolean possibility(char[] answer, int i, char color, int current) {
	return answer[i - 1] != color && answer[i - 1] != stallC[((current + 6) - 1) % 6]
		&& answer[i - 1] != stallC[(current + 1) % 6];
    }

    private static int fill(char[] answer, int i, int j) {
	int prevoius;
	answer[i] = stall[j].color;
	stall[j].amount--;
	prevoius = colorFinder(answer[i]);
	return prevoius;
    }

    private static int positionFinder(int color) {
	for (int j = 0; j < stall.length; j++) {
	    if(stall[j].color == stallC[color]) {
		return j;
	    }
	}
	return 0;
    }

    private static int colorFinder(char n) {
	int position = 0;
	for (int i = 0; i < stallC.length; i++) {
	    if(n == stallC[i]) {
		position = i;
	    }
	}
	return position;
    }

    private static void print(Uni[] stall) {
	for (int i = 0; i < stall.length; i++) {
	    System.out.print(stall[i]);
	    if (i != stall.length - 1) {
		System.out.print(" | ");
	    }
	}
	System.out.println();
    }
}