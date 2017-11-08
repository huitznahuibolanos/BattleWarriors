import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana_principal extends JFrame implements ActionListener{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton salir, jugar, opciones, instrucciones;
	private JPanel botones;
	private JLabel titulo;
	
	
	private int  j1, j2, map;;
	
	public Ventana_principal(){
		
		super();
		setBounds(200, 100, 600, 400);
		setLayout(null);

		j1=1;
		j2=2;
		map=1;
		
		botones = new JPanel();
		botones.setBounds(200, 150, 150, 300);
		
		
		/*
		 * No cambia :(
		 */
		salir = new JButton ("Salir");
		
		jugar = new JButton ("Jugar");
		
		opciones = new JButton ("Opciones");
		
		instrucciones = new JButton("Instrucciones");
		
		
		salir.addActionListener(this);
		jugar.addActionListener(this);
		opciones.addActionListener(this);
		instrucciones.addActionListener(this);
		
		botones.add(jugar);
		botones.add(instrucciones);
		botones.add(opciones);
		botones.add(salir);
		
		titulo = new JLabel("Battle Warriors");
		titulo.setBounds(200, 20, 100, 50);
		
		add(titulo);
		add(botones);
				
	}
	
	
	public int getJ1() {
		return j1;
	}
	public void setJ1(int j1) {
		this.j1 = j1;
	}
	public void setValores(int j1, int j2, int map){
		this.j1=j1;
		this.j2=j2;
		this.map=map;
	}


	public void abrirJuego(){
		this.setVisible(false);
		Ventana_juego juego = new Ventana_juego();
		juego.setVisible(true);
		//juego.getCanvas().getContext().getEntities().setJ1(j1);
		juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void abrirOpciones(){
		this.setVisible(false);
		Ventana_opciones opciones= new Ventana_opciones();
		opciones.setVisible(true);
		opciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public void abrirInstrucciones(){
		this.setVisible(false);
		Ventana_instrucciones inst= new Ventana_instrucciones();
		inst.setVisible(true);
		inst.setValores(j1, j2, map);
		inst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==salir){
			System.exit(0);
		}
		
		if(e.getSource()==jugar){
			abrirJuego();
		}
		
		if(e.getSource()==instrucciones){
			abrirInstrucciones();
		}
		
		if(e.getSource()==opciones){
			abrirOpciones();
		}
		
		
		
	}
	
	
	
	
	
}
