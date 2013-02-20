package mutagen;

/**
 *
 * @author dusan.materic@gmail.com
 */

public class vrednovanje {
   
public final char [] seq1;// MORAO CONSTANT RADI PROVJERE GRESAKA
private char [] seqMut;// sa prihvacenim promjenama
private char [] seq2;
private char [] seqSin;	
private int changeNo;
private int pozitivPromjena;
private int rem;
private int sinonims;
private int ukupnoPromjena;//postavlja se pivi put radi progressBar
private int STOP;
private int pozition;//pozicija zadnje promjene na koju treba akcentovati testiranje
private String temp1;
private String temp2;//upotrebiti za triplete i sinonime
triplet t = new triplet();
sinonim sin = new sinonim();
//////////////////////////////////////////////////////////////////////////////////////


/*public vrednovanje(){
	changeNo = 0;
	pozitivPromjena = 0;
	sinonims = 0;
	ukupnoPromjena = 0;
	STOP = 0;
}*/
public vrednovanje(String a,String b){
	changeNo = 0;
	pozitivPromjena = 0;
	sinonims = 0;
	ukupnoPromjena = 0;
	STOP = 0;
	seq1 = a.toCharArray();
	seqMut = b.toCharArray();//privremeno radi slijeda dogadjaja MUTACIJA
	seqSin = a.toCharArray();;//prvi put seqSin = seq1; VELIKA GRESKA 
}
/*
public void setSeq (char [] seq1, char [] seq2){// pozvati prvi put
	if (seq1.length != seq2.length){
		System.out.println("Sequence length missmach !");//poslati drugi prozor obavjestenje ???????
		System.exit (-2);//radije stopirati proces
	}
		//this.seq1 = seq1;
		this.seq2 = seq2;
		this.seqMut = seq2;
		this.seqSin = seq1;//greska ... mjenja prilikom sinonima
}
public void setSeq (String S1, String S2){
	setSeq (S1.toCharArray(), S2.toCharArray());
}*/

public void ukupnoPromjena(char [] seqv1, char [] seqv2){//poziva se samo prvi put radi progresBarr
	for (int i=0; i<seqv1.length; i++){
		if (seqv1[i] != seqv2[i]){
			ukupnoPromjena++;
		}
	}
}
public void ukupnoPromjena (){
	ukupnoPromjena (seq1, seq2);
}
public int ostaloPromjena(){
	rem = 0;
	for (int i=0; i<seq1.length; i++){
		if (seq1[i] != seqMut[i]){
			rem++;
		}
	}
	return rem;
}

public void vrednuj (char [] a, int br){//NAJ vazniji metod
	vrednujPozitivne(a,br);
	sinonimAndStop();	
}
public void vrednuj (String st, int no){
	vrednuj (st.toCharArray(), no);
}


///////////////////////////////////////////////////////////////////////////////////////////////
// G E T    M E T O D E
public int getBrPokusaja(){
	return changeNo;
}
public int getBrPozitivPromjena(){
	return pozitivPromjena;
}
public int getBrSinonims(){
	return sinonims;
}
public int getBrSTOP(){
	return STOP;
}
public int getPotrebnihPromjena(){
	return ukupnoPromjena;
}
public String getSeqMut(){
	return (String.valueOf (seqMut));
}
public String getSeqSinonim(){
	return String.valueOf(seqSin);
}


///////////////////////////////////////////////////////////////////////////////////////////////////
//  P R I V A T N I    M E T O D I
public void setSeq2 (char [] seq2){// samo seq2 posto je seq1 konstantna kroz izvrsenje programa
		this.seq2 = seq2;
		//this.seqSin = seq2;
}
private void setPozition (int n){
	pozition = n;
}

private void vrednujPozitivne (char [] s, int n){
	setSeq2 (s);
	setPozition (n);
	changeNo ++;
	
	if (seq1[n] == seq2[n]){//ovo testirati logicki 
		pozitivPromjena++;
		seqMut[n] = seq2[n];
		//System.out.println(String.valueOf(seqMut));// dodati "\r"+
		//seqSin [n] = seq2[n];//update sinonima da li je potrebno NIJE
	}
	/*else if (seq1[n] != seq2[n] && seq1[n] == seqMut[n]){
		pozitivPromjena--;
		//System.out.println("smanjivanje");
	}*/
	
}


private void sinonimAndStop (){
	
	
	temp1 = t.whichTriplet (seq1 , pozition);//triplet potomka
	temp2 = t.whichTriplet (seq2 , pozition);//triplet predaka - mutiran
	if (sin.isSinonim(temp1,temp2)){
		sinonims++;
		//System.out.println ("sinonimi predak/poromak: " + temp1 +"/"+ temp2);
		this.seqSin[pozition] = seq2[pozition];
		//System.out.println ("seqSin" + String.valueOf(seqSin) + "value of seqSin[pozition] "+seqSin[pozition]);
	}
	if (sin.isSTOP(temp2)){
		STOP++;
	}
	
}



}

