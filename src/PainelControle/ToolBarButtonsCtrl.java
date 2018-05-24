package PainelControle;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ControladorVenda.*;

class ToolBarButtonsCtrl extends JToolBar
{	
	ControladorVenda controlador;
	
	public ToolBarButtonsCtrl()
	{
		controlador = ControladorVenda.getCtrlVenda();
		this.setOrientation(JToolBar.HORIZONTAL);
		this.setFloatable(false);
		this.setVisible(true);	
		
		//Inicializando botão 'CONFIRMA'
		JButton buttonConfirma;
		buttonConfirma = new JButton("CONFIRMA");
		buttonConfirma.setMargin(new Insets(9, 12, 9, 12));
		buttonConfirma.setHorizontalTextPosition(JButton.CENTER);
		buttonConfirma.setVerticalTextPosition(JButton.BOTTOM);
		this.add(buttonConfirma, BorderLayout.CENTER);
		
		buttonConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.confirmaButtonPressed();
			}
		});   
		
		//Inicializando botão 'CANCELA'
		JButton buttonCancela;
		buttonCancela = new JButton("CANCELA");
		buttonCancela.setMargin(new Insets(9, 12, 9, 12));
		buttonCancela.setHorizontalTextPosition(JButton.CENTER);
		buttonCancela.setVerticalTextPosition(JButton.BOTTOM);
		this.add(buttonCancela, BorderLayout.CENTER);
		
		buttonCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cancelaButtonPressed();
			}
		});   
	}

}
