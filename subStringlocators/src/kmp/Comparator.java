package kmp;

public class Comparator {
		
	private String text;
	private String pattern;	
	private int[][] DFA;	
	
	public Comparator(){		
	}
	
	public Comparator(String seq,String pattern){	
		this.text = seq;
		this.pattern=pattern;
		buildDFA();
	}
	
	public String getIndex(){
						
		String 	str=searchPattern(this.text);		
		return str;
	}
	
		
	public void buildDFA (){	
		int M = pattern.length();
		int R = 256;
		
		int[][] dfa = new int[R][M];
		dfa[pattern.charAt(0)][0] = 1;
		
		for (int X = 0, j = 1; j < M; j++)
		{
			for (int c = 0; c < R; c++)
				dfa[c][j] = dfa[c][X];
				dfa[pattern.charAt(j)][j] = j+1;
				X = dfa[pattern.charAt(j)][X];
		}
		this.DFA=dfa;	
	}
		
	private String searchPattern(String txt)
	{ 
		String str="";int g=0;		
		int i, state, N = txt.length(), M = pattern.length();		
		for (i = 0, state = 0; i < N && state < M; i++)
		{
			state = this.DFA[txt.charAt(i)][state];
			if (state == M)
			{
				g=Math.abs(i - M);
				str+=String.valueOf(g)+", ";				
				state=0;
			}							
		}
		return str;
	}
	
	public String getSequence() {
		return text;
	}
	
	public void setSequence(String x){	
		this.text=x;		
	}
	

	public String getPattern() {
		return pattern;
	}
	
	public void setPattern(String x){
		this.pattern=x;		
	}

	
	

}
