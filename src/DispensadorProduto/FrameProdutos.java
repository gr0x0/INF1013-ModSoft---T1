package DispensadorProduto;

import java.awt.*;
import javax.swing.*;


class FrameProdutos extends JFrame
{	
	private ToolBarPrecos precos;
	private PainelBebidas bebidas; 
	private ToolBarQuantidades quantidades;
	
	public FrameProdutos()
	{					
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.setBounds(430, 150, 760, 445);
		this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		this.setLayout(new BorderLayout());
		this.setVisible(true);	
		
		/* CRIANDO A PARTE SUPERIOR (TOOLBAR DE PREÇOS) */
		precos = new ToolBarPrecos();
		this.add(precos,BorderLayout.NORTH);
		precos.setVisible(true);
		
		/* CRIANDO A PARTE MÉDIA (PAINEL DO MENU DE BEBIDAS) */
		bebidas = new PainelBebidas();
		this.add(bebidas,BorderLayout.CENTER);
		bebidas.setVisible(true);
		
		/* CRIANDO A PARTE INFERIOR (TOOLBAR DE QUANTIDADES DISPONÍVEIS) */
		quantidades = new ToolBarQuantidades();
		this.add(quantidades,BorderLayout.SOUTH);
		quantidades.setVisible(true);
        
		this.validate();
		
	}
	
	protected ToolBarPrecos getToolBarPrecos()
	{
		return precos;
	}
	
	protected PainelBebidas getPainelBebidas()
	{
		return bebidas;
	}
	
	protected ToolBarQuantidades getToolBarQuantidades()
	{
		return quantidades;
	}
}
