package kmp;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class GUISequences extends JFrame {

	private JPanel contentPane;
	private JPanel panelImagen;
	private JLabel lblTitSeq1;
	private JLabel lblTitSeq2;
	private JLabel lblTitSeq3;
	private JLabel lblSeq1;
	private JLabel lblSeq2;
	private JLabel lblSeq3;
	
	private JTextField txtPat1;
	private JTextField txtPat2;
	private JTextField txtPat3;
	private JTextField txtPat4;
	private JTextField txtPat5;
	private JTextField txtFrePat1;
	private JTextField txtFrePat2;
	private JTextField txtFrePat3;
	private JTextField txtFrePat4;
	private JTextField txtFrePat5;
	
	private Sequence secuencias[];
	
	private Sequence secuencia1;
	private Sequence secuencia2;
	private Sequence secuencia3;
	
	private Sequence patron1;
	private Sequence patron2;
	private Sequence patron3;
	private Sequence patron4;
	private Sequence patron5;
	
	private Sequence patrones[];				
	private int nse=3,npa=5,mode=0;
	private JButton btnClean;
	
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUISequences frame = new GUISequences();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUISequences() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelImagen = new JPanel();
		panelImagen.setBounds(33, 27, 816, 172);
		contentPane.add(panelImagen);
		panelImagen.setLayout(null);
		
		lblTitSeq1 = new JLabel("Sequence 1");
		lblTitSeq1.setBounds(12, 12, 150, 15);
		panelImagen.add(lblTitSeq1);
		
		lblTitSeq2 = new JLabel("Sequence 2");
		lblTitSeq2.setBounds(12, 65, 150, 15);
		panelImagen.add(lblTitSeq2);
		
		lblTitSeq3 = new JLabel("Sequence 3");
		lblTitSeq3.setBounds(12, 113, 150, 15);
		panelImagen.add(lblTitSeq3);
		
		lblSeq1 = new JLabel("A");
		lblSeq1.setBounds(12, 38, 784, 15);		
		panelImagen.add(lblSeq1);
		
		lblSeq2 = new JLabel("A");
		lblSeq2.setBounds(12, 86, 784, 15);
		panelImagen.add(lblSeq2);
		
		lblSeq3 = new JLabel("A");
		lblSeq3.setBounds(12, 140, 784, 15);
		panelImagen.add(lblSeq3);
		
		JButton btnLoadSq1 = new JButton("load");
		btnLoadSq1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sequ1[]=loadFile(lblTitSeq1);
				if (sequ1!=null) {
					setField(sequ1,1);
					setSequence(sequ1,1);	
					mode=1;
				}
				
			}
		});
		btnLoadSq1.setBounds(734, 8, 62, 23);
		panelImagen.add(btnLoadSq1);
		
		JButton btnLoadSq2 = new JButton("load");
		btnLoadSq2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sequ2[]=loadFile(lblTitSeq2);			
				setField(sequ2,2);
				setSequence(sequ2,2);
				mode=1;
			}
		});
		btnLoadSq2.setBounds(734, 61, 62, 23);
		panelImagen.add(btnLoadSq2);
		
		JButton btnLoadSq3 = new JButton("load");
		btnLoadSq3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sequ3[]=loadFile(lblTitSeq3);			
				setField(sequ3,3);
				setSequence(sequ3,3);
				mode=1;
			}
		});
		btnLoadSq3.setBounds(734, 109, 62, 23);
		panelImagen.add(btnLoadSq3);
		
		JPanel panelCalculator = new JPanel();
		panelCalculator.setBounds(33, 245, 816, 334);
		contentPane.add(panelCalculator);
		panelCalculator.setLayout(null);
		
		JLabel lblTitPat1 = new JLabel("Pattern 1");
		lblTitPat1.setForeground(Color.RED);
		lblTitPat1.setBounds(12, 17, 70, 15);
		panelCalculator.add(lblTitPat1);
		
		JLabel lblTitPat2 = new JLabel("Pattern 2");
		lblTitPat2.setForeground(Color.BLUE);
		lblTitPat2.setBounds(12, 82, 70, 15);
		panelCalculator.add(lblTitPat2);
		
		JLabel lblTitPat3 = new JLabel("Pattern 3");
		lblTitPat3.setForeground(Color.GREEN);
		lblTitPat3.setBounds(12, 152, 70, 15);
		panelCalculator.add(lblTitPat3);
		
		JLabel lblTitPat4 = new JLabel("Pattern 4");
		lblTitPat4.setForeground(Color.ORANGE);
		lblTitPat4.setBounds(12, 210, 70, 15);
		panelCalculator.add(lblTitPat4);
		
		JLabel lblTitPat5 = new JLabel("Pattern 5");
		lblTitPat5.setForeground(Color.MAGENTA);
		lblTitPat5.setBounds(12, 268, 70, 15);
		panelCalculator.add(lblTitPat5);
		
		txtPat1 = new JTextField();
		txtPat1.setBounds(12, 49, 748, 19);
		panelCalculator.add(txtPat1);
		txtPat1.setColumns(10);
		
		txtPat2 = new JTextField();
		txtPat2.setColumns(10);
		txtPat2.setBounds(12, 107, 748, 19);
		panelCalculator.add(txtPat2);
		
		txtPat3 = new JTextField();
		txtPat3.setColumns(10);
		txtPat3.setBounds(12, 171, 748, 19);
		panelCalculator.add(txtPat3);
		
		txtPat4 = new JTextField();
		txtPat4.setColumns(10);
		txtPat4.setBounds(12, 237, 748, 19);
		panelCalculator.add(txtPat4);
		
		txtPat5 = new JTextField();
		txtPat5.setColumns(10);
		txtPat5.setBounds(12, 300, 748, 19);
		panelCalculator.add(txtPat5);
		
		txtFrePat1 = new JTextField();
		txtFrePat1.setBounds(96, 15, 664, 19);
		txtFrePat1.setEditable(false);
		panelCalculator.add(txtFrePat1);
		txtFrePat1.setColumns(10);		
		
		txtFrePat2 = new JTextField();
		txtFrePat2.setColumns(10);
		txtFrePat2.setBounds(100, 80, 660, 19);
		txtFrePat2.setEditable(false);
		panelCalculator.add(txtFrePat2);
		
		txtFrePat3 = new JTextField();
		txtFrePat3.setColumns(10);
		txtFrePat3.setBounds(100, 148, 660, 19);
		txtFrePat3.setEditable(false);
		panelCalculator.add(txtFrePat3);
		
		txtFrePat4 = new JTextField();
		txtFrePat4.setColumns(10);
		txtFrePat4.setBounds(100, 208, 660, 19);
		txtFrePat4.setEditable(false);
		panelCalculator.add(txtFrePat4);
		
		txtFrePat5 = new JTextField();
		txtFrePat5.setColumns(10);
		txtFrePat5.setBounds(100, 266, 660, 19);
		txtFrePat5.setEditable(false);
		panelCalculator.add(txtFrePat5);
		
		JSpinner SpinnerP1 = new JSpinner();
		SpinnerP1.setModel(new SpinnerNumberModel(4, 2, 25, 1));
		SpinnerP1.setBounds(770, 49, 39, 20);
		SpinnerP1.setVisible(false);
		panelCalculator.add(SpinnerP1);
		
		JSpinner SpinnerP2 = new JSpinner();
		SpinnerP2.setModel(new SpinnerNumberModel(4, 2, 25, 1));
		SpinnerP2.setBounds(770, 108, 39, 20);
		SpinnerP2.setVisible(false);
		panelCalculator.add(SpinnerP2);
		
		JSpinner SpinnerP3 = new JSpinner();
		SpinnerP3.setModel(new SpinnerNumberModel(4, 2, 25, 1));
		SpinnerP3.setBounds(770, 172, 39, 20);
		SpinnerP3.setVisible(false);
		panelCalculator.add(SpinnerP3);
		
		JSpinner SpinnerP4 = new JSpinner();
		SpinnerP4.setModel(new SpinnerNumberModel(4, 2, 25, 1));
		SpinnerP4.setBounds(770, 238, 39, 20);
		SpinnerP4.setVisible(false);
		panelCalculator.add(SpinnerP4);
		
		JSpinner SpinnerP5 = new JSpinner();
		SpinnerP5.setModel(new SpinnerNumberModel(4, 2, 25, 1));
		SpinnerP5.setBounds(770, 301, 39, 20);
		SpinnerP5.setVisible(false);
		panelCalculator.add(SpinnerP5);
		
		JLabel lblTitle = new JLabel("LOCALIZADOR DE MOTIF");
		lblTitle.setBounds(369, 0, 213, 29);
		contentPane.add(lblTitle);
		
		JButton btnGenSeq = new JButton("Make a Test");
		btnGenSeq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				generateSample();
				setFields();
			}
		});
		
		btnGenSeq.setBounds(33, 210, 122, 25);
		contentPane.add(btnGenSeq);
		
		JButton btnFinPat = new JButton("Find Patterns");
		btnFinPat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
								
				if (mode==0) {//modo prueba
					executeFindPatterns();					
				}else if(mode==1){					
					if(checkFieldsLoaded()){
						secuencias[0]=secuencia1;
						secuencias[1]=secuencia2;
						secuencias[2]=secuencia3;
						patrones[0]=patron1;
						patrones[1]=patron2;
						patrones[2]=patron3;
						patrones[3]=patron4;
						patrones[4]=patron5;
						executeFindPatterns();				
						
					}else{						
						JOptionPane.showMessageDialog(null, "Secuencias no cargadas");						
					}
				}
				
			}			
		});
		
		btnFinPat.setBounds(673, 211, 155, 25);
		contentPane.add(btnFinPat);		
		
		btnClean = new JButton("Clean");
		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblTitSeq1.setText("Sequence 1");
				lblTitSeq2.setText("Sequence 2");
				lblTitSeq3.setText("Sequence 3");
			  	lblSeq1.setText("A");
			  	lblSeq2.setText("A");
			  	lblSeq3.setText("A");
				txtPat1.setText("");
				txtPat2.setText("");
				txtPat3.setText("");
				txtPat4.setText("");
				txtPat5.setText("");
				txtFrePat1.setText("");
				txtFrePat2.setText("");
				txtFrePat3.setText("");
				txtFrePat4.setText("");
				txtFrePat5.setText("");

				/*secuencias=null;
				secuencia1=null;
				secuencia2=null;
				secuencia3=null;
				patrones[]=null;
				*/				
			}
		});
		btnClean.setBounds(201, 211, 82, 25);		 
		contentPane.add(btnClean);
	}
	
	
	
	void executeFindPatterns(){
		
		String index[][]=new String[nse][npa];					
		int y=0;			
		for(int u=0;u<nse;u++){
			Comparator comp= new Comparator();
			comp.setSequence(secuencias[u].getSequence());					
			for(y=0;y<npa;y++){			
				comp.setPattern(patrones[y].getSequence());
				comp.buildDFA();
				index[u][y]=comp.getIndex();			
			}								
		}
		
		JTextField txtFreTotal[]={txtFrePat1,txtFrePat2,txtFrePat3,txtFrePat4,txtFrePat5};
		
		String seqPatron="";
		for (int i = 0; i < npa; i++) {
			seqPatron="";
			for (int j = 0; j <nse; j++) {
				seqPatron+="Seq["+((j+1))+"]: ";
				seqPatron+=index[j][i];
			}
			txtFreTotal[i].setText(seqPatron);
		}
		
		
	}
	
	String[]  loadFile(JLabel lb){
		 JFileChooser fc = new JFileChooser();
		 int respuesta = fc.showOpenDialog(this);
		 
		 	File archivo = null;
		 	FileReader fr = null;
		 	BufferedReader br = null;
		 	String sequ[]=new String[2];
		 	
	        if (respuesta == JFileChooser.APPROVE_OPTION)
	        {
	            
	            try {	             	            
	            	archivo = fc.getSelectedFile();
	            	//lb.setText(archivo.getName());	               
	            	fr = new FileReader (archivo);
	            	br = new BufferedReader(fr);
	                sequ[0]=br.readLine();	                
	                String linea,sequa="";	               
	                while((linea=br.readLine())!=null) sequa+=linea;
	                sequ[1]=sequa;
	            }
	            catch(Exception e){
	               e.printStackTrace();
	            }finally{	             
	               try{                   
	                  if( fr!= null  ){  
	                     fr.close();    
	                  }                 
	               }catch (Exception e2){
	                  e2.printStackTrace();
	               }
	            }
	            
	        }else{
	        	sequ=null;
	        }
	        	        
	        return sequ;
	}
	
	
	boolean checkFieldsLoaded(){
		boolean flag=false;
		
			if (secuencia1==null | secuencia2==null |secuencia3==null ) {				
				flag=false;
			}else flag=true;
		
		return flag;		
	}
	
	
	
	void setField(String st[], int a){		
		switch(a){		
		case 1:	
			lblTitSeq1.setText(st[0]);
			lblSeq1.setText(st[1]);			
			break;
		case 2:
			lblTitSeq2.setText(st[0]);
			lblSeq2.setText(st[1]);			
			break;
		case 3:
			lblTitSeq3.setText(st[0]);
			lblSeq3.setText(st[1]);			
			break;		
		}		
	}
	
	void setSequence(String st[], int a){
		int len=st[1].length();
		switch(a){		
		case 1:	
				secuencia1=new Sequence(len);			
				secuencia1.generate_sequence();			
				break;
		case 2:
				secuencia2=new Sequence(len);			
				secuencia2.generate_sequence();
				break;
		case 3:
				secuencia3=new Sequence(len);			
				secuencia3.generate_sequence();
				break;
		}		
		
	}
	
	
	
	
	void generateSample(){
		secuencias=new Sequence[nse];
		patrones=new Sequence[npa];		
		
		for(int h=0;h<nse;h++){
			secuencias[h]=new Sequence();			
			secuencias[h].generate_sequence();
		}
		
		for(int h=0;h<npa;h++){
			patrones[h]=new Sequence(4);			
			patrones[h].generate_sequence();	
		}	}
	
	void setFields(){		
		
		lblSeq1.setText(secuencias[0].getSequence());				
		lblSeq2.setText(secuencias[1].getSequence());
		lblSeq3.setText(secuencias[2].getSequence());
		
		txtPat1.setText(patrones[0].getSequence());
		txtPat2.setText(patrones[1].getSequence());
		txtPat3.setText(patrones[2].getSequence());
		txtPat4.setText(patrones[3].getSequence());
		txtPat5.setText(patrones[4].getSequence());
	}
	
	
	
	
	
}
