package home05.simple;
//Task 4: Население города ежегодно увеличивается на 1/n
//наличного состава жителей, где n-натуральное число. 
//Через сколько лет население города  утроится.
class town {

    public static void main(String[] args) {
		int n = 50, z = 0, nas = 1000; 

		for (double sum = nas; sum <= 3*nas; z++) {   
			sum += (1.0 / n) * sum;
		}                                            
		System.out.println(z);
    }

}
