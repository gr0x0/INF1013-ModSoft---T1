package DispensadorProduto;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

class ToolBarLabelsPrecos extends JToolBar 
{
	public ToolBarLabelsPrecos()
	{
		this.setOrientation(JToolBar.HORIZONTAL);
		this.setFloatable(false);
		this.setVisible(true);	
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1) ;
		
		//Inicializando label 'R$2,50'
		this.add(Box.createHorizontalStrut(70));
		JLabel labelQtdFanta = new JLabel(" R$2,50 ",JLabel.CENTER);
		labelQtdFanta.setBackground(Color.WHITE);
		labelQtdFanta.setBorder(border);	
		this.add(labelQtdFanta);
		
		//Inicializando label 'R$3,00'
		this.add(Box.createHorizontalStrut(140));
		JLabel labelQtdCoca = new JLabel(" R$3,00 ",JLabel.CENTER);
		labelQtdCoca.setBackground(Color.WHITE);
		labelQtdCoca.setBorder(border);	
		this.add(labelQtdCoca);
		
		//Inicializando label 'R$4,50'
		this.add(Box.createHorizontalStrut(140));
		JLabel labelQtdAntartica = new JLabel(" R$4,50 ",JLabel.CENTER);
		labelQtdAntartica.setBackground(Color.WHITE);
		labelQtdAntartica.setBorder(border);	
		this.add(labelQtdAntartica);
		
		//Inicializando label 'R$4,00'
		this.add(Box.createHorizontalStrut(140));
		JLabel labelQtdSkol = new JLabel(" R$4,00 ",JLabel.CENTER);
		labelQtdSkol.setBackground(Color.WHITE);
		labelQtdSkol.setBorder(border);	
		this.add(labelQtdSkol);
	}

}
