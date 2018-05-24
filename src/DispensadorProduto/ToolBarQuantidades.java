package DispensadorProduto;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;


class ToolBarQuantidades extends JToolBar
{
	private ToolBarLabelsQtds quantidade;
	private JLabel labelText;
	
	public ToolBarQuantidades()
	{
		//Criando a toolbar principal
		this.setOrientation(JToolBar.VERTICAL);
		this.setFloatable(false);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		//Criando o label de texto
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2) ;
		labelText = new JLabel("-QUANTIDADES DISPONÍVEIS-",JLabel.CENTER);
		this.add(labelText, BorderLayout.NORTH);
		
		//Criando os labels de QUANTIDADES
		quantidade = new ToolBarLabelsQtds();
		this.add(quantidade, BorderLayout.SOUTH);	
	}
	
	protected ToolBarLabelsQtds getToolBarLabelsQtds()
	{
		return quantidade;
	}

}
