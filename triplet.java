package mutagen;

/**
 *
 * @author dux
 */
public class triplet {
  private char [] seq;
	private char [] tripl = new char[3];
	private int start;
	

	
	public String whichTriplet (String s, int n){
		seq = s.toCharArray();
		if ( (seq.length % 3) == 0){//iskljucuje nepotpune sekvence
			
			if (n % 3 == 0){
				start = n;
				
				tripl[0] = seq[start];
				tripl[1] = seq[start+1];
				tripl[2] = seq[start+2];
				return String.valueOf(tripl);
			}
			else if (n % 3 == 1){
				start = n-1;
				tripl[0] = seq[start];
				tripl[1] = seq[start+1];
				tripl[2] = seq[start+2];
				return String.valueOf(tripl);
			}
			else {
				start = n-2;
				tripl[0] = seq[start];
				tripl[1] = seq[start+1];
				tripl[2] = seq[start+2];
				return String.valueOf(tripl);
			}
			
		}
		else {
			return ("Greska");
		}
	}
	
	public String whichTriplet (char [] s, int n){
		return whichTriplet (String.valueOf(s),n);
	}

} 
