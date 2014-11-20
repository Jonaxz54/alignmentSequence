package kmp;

public class Test {				
	public static void main(String[] args) {	
		int nse=1,npa=4;		
		
		Sequence secuencias[] =new Sequence[nse];
		Sequence patrones[]=new Sequence[npa];		
		
		for(int h=0;h<nse;h++){
			secuencias[h]=new Sequence();			
			secuencias[h].generate_sequence();
		}
		
		for(int h=0;h<npa;h++){
			patrones[h]=new Sequence(5);			
			patrones[h].generate_sequence();	
		}

		String index[][]=new String[nse][npa];
		
		for(int u=0;u<nse;u++){
			Comparator comp= new Comparator();
			comp.setSequence(secuencias[u].getSequence());
			for(int y=0;y<npa;y++){			
				comp.setPattern(patrones[y].getSequence());
				comp.buildDFA();				
				index[u][y]=comp.getIndex();
				System.out.println(comp.getIndex());
			}
		}		
	}
	
	
}
