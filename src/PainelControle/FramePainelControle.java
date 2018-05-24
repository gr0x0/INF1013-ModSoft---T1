package PainelControle;

import java.awt.*;
import javax.swing.*;
import javax.swing.JRootPane;
import DispensadorMoedas.*;

class FramePainelControle extends JFrame
{	
	ToolBarControle controle;
	
	public FramePainelControle()
	{			
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.setBounds(100, 150, 300, 445);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
		
		/* CRIANDO A PARTE ESQUERDA (PAINEL DE MOEDAS) */
		this.getContentPane().add(ControladorDispensadorMoedas.getCtrlMoedas().getPainelMoedas(), 
				BorderLayout.CENTER);
		
		/* CRIANDO A PARTE DIREITA (TOOLBAR DE CONTROLE) */
		controle = new ToolBarControle();
		this.getContentPane().add(controle,BorderLayout.EAST);
		
		this.validate();

	}
	
	protected void zerarDeposito()
	{
		controle.zerarDeposito();
	}
	
	protected void printTroco()
	{
		controle.printTroco();
	}

}
