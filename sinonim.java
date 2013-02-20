package mutagen;

/**
 *
 * @author dusan.materic@telrad.net
 */
public class sinonim {

private String codon1;
private String codon2;
private String AK;

public void setSinonim(char [] a, char[] b){//nepotrebno
  codon1 = String.valueOf(a);
	codon2 = String.valueOf(b);
}

public void setSinonim (String a, String b){//nepotrebno
	codon1 = a;
	codon2 = b;
}

public String whichAK (String codon){
	switch (codon){
		case "GCA":
		case "GCG":
		case "GCC":
		case "GCT":	AK = "Ala";
					break;
		case "CGT": 
		case "CGC": 
		case "CGA": 
		case "CGG": 
		case "AGA": 
		case "AGG":	AK = "Arg";
					break;
					
		case "AAT":
		case "AAC":	AK = "Asn";
					break;
		case "GAT":
		case "GAC":	AK = "Asp";
					break;
		case "TGT":
		case "TGC": AK = "Cys";
					break;
		case "CAA":
		case "CAG": AK = "Gln";
					break;			
		case "GAA":
		case "GAG":	AK = "Glu";
					break;
		case "GGA":
		case "GGG":
		case "GGT":
		case "GGC":	AK = "Gly";
					break;
		case "CAT":
		case "CAC": AK = "His";
					break;
		case "ATT":
		case "ATC":
		case "ATA": AK = "Ile";
					break;
		case "TTA":
		case "TTG":
		case "CTA":
		case "CTG":
		case "CTC":
		case "CTT":	AK = "Leu";
					break;
		case "AAA":
		case "AAG":	AK = "Lys";
					break;
		case "ATG": AK = "Met";
					break;
		case "TTT":
		case "TTC":	AK = "Phe";
					break;
		case "CCC":
		case "CCG":
		case "CCA":
		case "CCT": AK = "Pro";
					break;
		case "TCA":
		case "TCG":
		case "TCT":
		case "TCC":
		case "AGT":
		case "AGC":	AK = "Ser";
					break;
		case "ACA":
		case "ACG":
		case "ACT":
		case "ACC":	AK = "Thr";
					break;
		case "TGG": AK = "Trp";
					break;
		case "TAT":
		case "TAC": AK = "Tyr";
					break;
		case "GTA":
		case "GTG":
		case "GTT":
		case "GTC":	AK = "Val";
					break;
		case "TAA":
		case "TAG":
		case "TGA": AK = "STOP";
					break;
		
					
		//treba nastaviti listu			
	}
							
	return AK;
}

public String whichAK (char[] codon){
	return whichAK (String.valueOf(codon));
}

public boolean isSinonim (String c1, String c2){
	if (!c2.equals(c1) && whichAK(c1) == whichAK(c2)){
		return true;
	}
	else {
		return false;
	}
}

public boolean isSinonim (char [] c1, char [] c2){
	return isSinonim(String.valueOf(c1), String.valueOf(c2));
}

public boolean isSTOP (String a){
	if (a.equals("TAA") || a.equals ("TAG") || a.equals("TGA") ){
		return true;
	} 
	else { 
		return false;
	}
}

public boolean isSTOP (char [] ar){
	return isSTOP (String.valueOf(ar));
}


} 
