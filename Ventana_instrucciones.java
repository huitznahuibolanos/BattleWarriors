import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana_instrucciones extends JFrame implements ActionListener {
	
	
	private BufferedImage i1,i2,i3,i4;
	private ImageIcon iconInst;
	private JLabel labelInst, titulo;
	private JPanel panel;
	
	private JButton anterior, siguiente, regresa;
	
	private int inst, j1, j2, map;
	
	public Ventana_instrucciones(){
		
		super();
		
		setLayout(null);
		this.setBounds(200,100,600,400);
		inst=1;
		panel= new JPanel();
		
		
		/*Todavía no están terminadas completamente
		 * 
		 * i1=limgs.getImage("instruccion1");
		 * i2=limgs.getImage("instruccion2");
		 * i3=limgs.getImage("instruccion3");
		 * i4=limgs.getImage("instruccion4");
		 * i5=limgs.getImage("instruccion5");
		 * 
		 * iconInst= new ImageIcon(i1);
		 * labelInst = new JLabel(iconInst);
		 */
		
		//i1=Entity_mgr.imags.getImage("mex_front");
		//iconInst = new ImageIcon(i1);
		//labelInst = new JLabel(iconInst);
		//labelInst.setBounds(50, 50, 200, 200);
		
		titulo = new JLabel("INSTRUCCIONES");
		//titulo.setBounds(200, 20, 100, 50);
		
		titulo.setBounds(200, 20, 100, 50);
		
		
		anterior = new JButton("<-");
		siguiente = new JButton("->");
		regresa = new JButton("REGRESAR");
		
		anterior.setBounds(20, 300, 100, 50);
		siguiente.setBounds(400, 300, 100, 50);
		regresa.setBounds(200, 300, 100, 50);
		
		anterior.addActionListener(this);
		siguiente.addActionListener(this);
		regresa.addActionListener(this);
		
		//this.add(labelInst);
		this.add(titulo);
		this.add(anterior);
		this.add(regresa);
		this.add(siguiente);
		
		
	}

	public void setValores(int j1, int j2, int map){
		this.j1=j1;
		this.j2=j2;
		this.map=map;
	}
	
	public void regresa(){
		this.setVisible(false);
		Ventana_principal vprincipal= new Ventana_principal();
		vprincipal.setVisible(true);
		vprincipal.setValores(j1, j2, map);
		vprincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent k ) {
		if(k.getSource()==regresa){
			regresa();
		}
		
		
	}
	
	

}
