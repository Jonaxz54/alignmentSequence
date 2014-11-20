package kmp;
import java.lang.StringBuffer;

public class Sequence{
	
	private String sequence;	
	private int limit;
	
		
	public Sequence(int j){
		this.limit=j;		
	}
	
	public Sequence(){
		this.limit=500;		
	}
	
	public void generate_sequence(){		
		String str="ATCG";int tmp;		
		StringBuffer sequ= new StringBuffer();
		for(int j=0;j<limit;j++){
			tmp=(int)(Math.random()*4);			
			sequ.append(str.charAt(tmp));
		}		
		this.sequence=sequ.toString();
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getSequence() {
		return this.sequence;
	}
	
	public void printSequence() {
		System.out.println(sequence.toString());
	}
	
	

}
