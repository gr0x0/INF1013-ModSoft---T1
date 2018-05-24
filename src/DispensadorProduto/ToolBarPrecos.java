package DispensadorProduto;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

class ToolBarPrecos extends JToolBar
{
	public ToolBarPrecos()
	{
		//Criando a toolbar principal
		this.setOrientation(JToolBar.VERTICAL);
		this.setFloatable(false);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		//Criando o label de texto
		Border border = BorderFactory.createLineBorder(Color.BLACK, 2) ;
		JLabel labelText = new JLabel("-PREÇOS DAS BEBIDAS-",JLabel.CENTER);
		this.add(labelText, BorderLayout.NORTH);
		
		//Criando os labels de QUANTIDADES
		ToolBarLabelsPrecos precos = new ToolBarLabelsPrecos();
		this.add(precos, BorderLayout.SOUTH);	
	}

}
