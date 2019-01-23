

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class lamina extends JPanel{

	public lamina(String titulo, String [] opciones){
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),titulo));
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		grupo=new ButtonGroup();
		
		for(int i=0; i<opciones.length; i++){
			
			JRadioButton boton=new JRadioButton(opciones[i]);
			boton.setActionCommand(opciones[i]);
			add(boton);
			grupo.add(boton);
			
			
		}
	}
	
	public String dameseleccion(){
		ButtonModel miboton=grupo.getSelection();
		String s=miboton.getActionCommand();
		return s;
	}
	
	ButtonGroup grupo;
}
