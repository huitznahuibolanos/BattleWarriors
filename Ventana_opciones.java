import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana_opciones extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelPers, titulo, labelPers2, labelmapa;
	
	private JButton multi, sigmapa, sigpers2, antmapa, antpers2;
	private JButton anterior, siguiente, guardarC;
	private int j1, j2, map;
	private BufferedImage sprite1, sprite2, mapa;
	
	public Ventana_opciones(){
		
		
		setBounds(200, 100, 600, 400);
		setLayout(null);
		
		j1=1;		
		
		//sprite1 = Entity_mgr.imags.getImage("formal_front");
		//labelPers= new JLabel(new ImageIcon(sprite1));
		
		
		titulo = new JLabel("OPCIONES");
		
		//labelPers.setBounds(250, 250, 100, 100);
		
		titulo.setBounds(200, 20, 100, 50);
		
		anterior = new JButton("<-");
		siguiente = new JButton("->");
		guardarC = new JButton("GUARDAR CAMBIOS");
		
		anterior.setBounds(100, 100, 100, 50);
		siguiente.setBounds(400, 100, 100, 50);
		guardarC.setBounds(300, 400, 100, 50);
		
		anterior.addActionListener(this);
		siguiente.addActionListener(this);
		guardarC.addActionListener(this);
		add(anterior);
		add(siguiente);
		add(guardarC);
		
		{//Multijugador
			multi = new JButton("Multijugador");
			sigpers2 = new JButton(">");
			antpers2 = new JButton("<");
			//labelPers2 = new JLabel(new ImageIcon(Entity_mgr.imags.getImage("mex_front")));
		}
		{//Mapa
			sigmapa = new JButton(">");
			antmapa = new JButton("<");
			/*la imagen del mapa no está implementadas
			 * labelmapa = new JLabel(new ImageIcon(Entity_mgr.imags.getImage("mapa")));
			 */
		}
		
		
	}
	
	public void setValores(int j1, int j2, int map){
		this.j1=j1;
		this.j2=j2;
		this.map=map;
	}
	

	public void imgAnterior(){
		if(j1!=1){
			if(j1==3){
				//sprite1 = Entity_mgr.imags.getImage("ciclop_front");
				//labelPers.setIcon(new ImageIcon(sprite1));
			}else{
				//sprite1 = Entity_mgr.imags.getImage("formal_front");
				//labelPers.setIcon(new ImageIcon(sprite1));
			}
			j1--;
		}
	}
	
	
	public void imgSiguiente(){
		if(j1!=3){
			if(j1==1){
				//sprite1 = Entity_mgr.imags.getImage("ciclop_front");
				//labelPers.setIcon(new ImageIcon(sprite1));
			}else{
				//sprite1 = Entity_mgr.imags.getImage("mex_front");
				//labelPers.setIcon(new ImageIcon(sprite1));
			}
			j1++;
		}
	}
	
	public void guardaCambios(){
		this.setVisible(false);
		Ventana_principal vprincipal= new Ventana_principal();
		vprincipal.setVisible(true);
		vprincipal.setValores(j1, j2, map);
		vprincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==anterior){
			imgAnterior();
		}
		if(e.getSource()==siguiente){
			imgSiguiente();
		}
		if(e.getSource()==guardarC){
			guardaCambios();
		}
	}
	

}
