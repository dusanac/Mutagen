package mutagen;

/**
 *
 * @author dusan.materic@gmail.com
 */
import java.util.Random;

public class randmut{

  private int base, pozition;
	char Base;
	Random rnum = new Random();
	
	
	public int getbase (){//returns int 0 1 2 3
		return base;
	}
	public char getBase (){//returns char A G T or C
		return Base;
	}
	public int getPozition(){// 0 - 300 (No of nucleotides)
		return pozition;
	}
	
	private void makeBase(){
		// A=0 G=1 T=2 C=3
		switch (base){
			case 0: 
				Base = 'A';
				break;
			case 1:
				Base = 'G';
				break;	
			case 2:
				Base = 'T';
				break;
			case 3:
				Base = 'C';
				break;
		}
	}
	public void nextmut (int range){// najprimjenjivija
		base = rnum.nextInt(4);
		makeBase();
		pozition = rnum.nextInt(range);
	}
	public randmut (){};
	public randmut (int range){
		nextmut (range);
	}
}

