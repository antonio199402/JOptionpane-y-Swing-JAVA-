

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class marco extends JFrame{
	public marco(){
		setTitle("SWING Y JOPTIONPANE");
		setBounds(200,150,500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel laminarejilla=new JPanel();
		GridLayout rejilla=new GridLayout(2,3);
		
		laminarejilla.setLayout(rejilla);
	//--------------------------------------------------------------------------------------------------------------
		
		String [] tipo={"mensaje", "confirmar","opcion", "entrada"};
		lamina_tipo=new lamina("Tipo",tipo);
		laminarejilla.add(lamina_tipo);
		
	//----------------------------------------------------------------------------------------------------------------------	
		
		String [] mensajes={"ERROR_MESAGGE","WARNING MESAGGE", "INFORMATION_MESSAGGE","QUESTION_MESAGGE", "PLAIN_MESSAGGE"};
		lamina_tipo_mensajes=new lamina("Tipo Mensaje",mensajes);
		laminarejilla.add(lamina_tipo_mensajes);
		
	//--------------------------------------------------------------------------------------------------------------
		
		String [] mensajes1={"Cadena", "Icono","Componente", "Otros", "Object"};
		lamina_mensajes=new lamina("Mensaje",mensajes1);
		laminarejilla.add(lamina_mensajes);
		
		
	//-----------------------------------------------------------------------------------------------------------
		
		String [] opcion={"DEFAULT_OPTION", "YES_NO_OPTION","YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"};
		lamina_tipo_opcion=new lamina("Tipo Opcion",opcion);
		laminarejilla.add(lamina_tipo_opcion);
		add(laminarejilla);
		
	//---------------------------------------------------------------------------------------------------------------
		String [] opciones={"String[]", "Icon[]","Object[]"};
		opcion1=new lamina("Tipo Mensaje",opciones);
		laminarejilla.add(opcion1);
	
	//-----------------------------------------------------------------------------------------------------

		String [] mensajes_entrada={"Campo texto", "Combo"};
		entrada=new lamina("Tipo Mensaje",mensajes_entrada);
		laminarejilla.add(entrada);
		
	//--------------------------------------------------------------------------------------------------------------	
		add(laminarejilla,BorderLayout.CENTER);
		
	//---------------------------------------------------------------------------------------------------------
		
		JPanel laminaboton=new JPanel();
			
		JButton botonmostrar=new JButton("MOSTRAR");
		
		gestion accion_mostrar=new gestion();
		botonmostrar.addActionListener(accion_mostrar);
		
		laminaboton.add(botonmostrar);
		
		add(laminaboton,BorderLayout.SOUTH);
	} 
	//----------------------------------------------------------------------------------------------------------
	
	private class gestion implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if(lamina_tipo.dameseleccion().equals("mensaje")){
				JOptionPane.showMessageDialog(marco.this,dame_mensaje(), "titulo", mensaje());
				
			}else if(lamina_tipo.dameseleccion().equals("confirmar")){
			    JOptionPane.showConfirmDialog(marco.this, dame_mensaje(), "titulo",mensaje());
			    
		}else if(lamina_tipo.dameseleccion().equals("entrada")){
			
			if(entrada.dameseleccion().equals("Campo texto")){
				JOptionPane.showInputDialog(marco.this,dame_mensaje(),"titulo",mensaje());
				
			}else if(entrada.dameseleccion().equals("Combo")){
				JOptionPane.showInputDialog(marco.this,dame_mensaje(),"titulo" , 0, null, new String[]{"amarillo","azul"}, "amarillo");
			}
			
		}else if(lamina_tipo.dameseleccion().equals("opcion")){
			JOptionPane.showOptionDialog(marco.this, dame_mensaje(), "titulo",1, mensaje(), null,dame_opcion(opcion1), null);
			
		}
		
	}
	}
	
	//--------------------------------------------------------------------------------------------------------------
	
			public Object dame_mensaje(){
				String s=lamina_mensajes.dameseleccion();
				
				if(s.equals("Cadena")){
					return cadena;
				}else if(s.equals("Icono")){
					return icono;
				}else if(s.equals("Componente")){
					return fecha;
				}else if(s.equals("Otros")){
					return mensaje;
				}else if(s.equals("Object")){
					return new Object[]{cadena,icono,fecha,mensaje};
				}else
					return null;
					
				
			}
			
		//------------------------------------------------------------------------------------------------------
			
			public int mensaje(){
				String s=lamina_tipo_mensajes.dameseleccion();
				
				if(s.equals("ERROR_MESAGGE")){
				   return 0;
				}else if(s.equals("INFORMATION_MESSAGGE")){
					return 1;
				}else if(s.endsWith("WARNING MESAGGE")){
					return 2;
				}else if(s.equals("QUESTION_MESAGGE")){
					return 3;
				}else if(s.equals("PLAIN_MESSAGGE")){
					return -1;
				}else{
					return 4;
				}
			}
		//-------------------------------------------------------------------------------------------------------------
			
			public int cantidad_botones(){
				String s=lamina_tipo_opcion.dameseleccion();
				
				if(s.equals("DEFAULT_OPTION")){
					return -1;
				}else if (s.equals("YES_NO_OPTION")){
					return 0;
				}else if (s.equals("YES_NO_CANCEL_OPTION")){
					return 1;
				}else if(s.equals("OK_CANCEL_OPTION")){
					return 2;
				}else{
					return 3;
				}
			}
			
		//----------------------------------------------------------------------------------------------------
			
			public Object[] dame_opcion(lamina lam){
				String s= lam.dameseleccion();
				
				if(s.equals("String[]")){
					return new String[]{"amarillo","azul","rojo"};
				
				}else if(s.equals("Object[]")){
					return new Object[]{cadena,icono,fecha,mensaje};
				}
					return null;
				
			}
			
			//--------------------------------------------------------------------------------------------------
			
			
			
private lamina lamina_tipo, lamina_tipo_mensajes,lamina_mensajes,lamina_tipo_opcion,opcion1,entrada;
private String cadena="mensaje";
private Icon icono=new ImageIcon("src/Proyecto_swing/cure.jpg");
private Date fecha=new Date();
private Component mensaje=new lamina_ejemplo();

private class lamina_ejemplo extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		Rectangle2D rectangulo=new Rectangle2D.Double(0,0,getWidth(),getHeight());
		
		g2.setPaint(Color.yellow);
		g2.fill(rectangulo);
	}
}
}


