package pruebas;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pruebas extends JFrame {
	private JPanel contentPane;
	

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pruebas frame = new Pruebas ();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
		
	public Pruebas(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 619);
		contentPane = new JPanel();		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	}

	
		
		
		/*
		String f[][]=new String[4][5];
		System.out.println(f.length);		
		String Cat[]={"D","T","Y","U","W"};
			
		for (int i = 0; i < 4; i++) {
			for (int k = 0; k < 5; k++) {
				f[i][k]=Cat[(int)(Math.random()*5)];							
				System.out.print(f[i][k]);
			}
			System.out.println();
		}
		//System.out.println(f.toString());
		String y="";
		for (int i = 0; i < 5; i++) {
			y+="Seq["+(i+1)+"]: ";
			for (int j = 0; j <4; j++) {				
				y+=f[j][i];
			}			
		}
		System.out.println(y);*/
		
		
		
		
		
	

}
