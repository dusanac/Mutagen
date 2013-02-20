package mutagen;

/**
 *
 * @author dusan.materic@telrad.net
 */
class nukleotid {
  private String sekvenca;
	private char[] array;

	
	public void setSeq(String s){
		sekvenca = s.toUpperCase();
	}
	
	public boolean isDNA (String a){
		setSeq(a);
		array = sekvenca.toCharArray();
		for (int i = 0; i<array.length; i++){
			if ( array[i] != 'A' && array[i] != 'G' && array[i] != 'T' && array[i] != 'C'){
				return false;
			}
		}
		return true;		
	}
}

