package mutagen;

/**
 *
 * @author dusan.materic@gmail.com
 */

public class mutiranjeBaza {

//private String Seqvence;
private char [] seqvence;

public void setSeq (String seq){
  //Seqvence = seq;
	seqvence = seq.toCharArray();
	}

public void setSeq (char [] seq){
	seqvence = seq;
	}

public boolean mutSeq (int poz, char baze){
	if (seqvence[poz]==baze){
		return false;
		}
	else {
		seqvence[poz]=baze;//prihvacena promjena
		return true;
		}
	}
	
public String getSeqString (){
	return String.valueOf(seqvence);
	}

public char[] getSeqChar (){
	return seqvence;
	}

}

