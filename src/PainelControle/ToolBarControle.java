package PainelControle;

import java.awt.*;
import javax.swing.*;
import ObserverPattern.*;
import DispensadorMoedas.*;

class ToolBarControle extends JToolBar
{
	private PainelDepositadoCtrl painelDepositado;
	private ToolBarButtonsCtrl buttons;
	private PainelTrocoCtrl painelTroco;
	
	public ToolBarControle()
	{
		//Criando a toolbar principal
		this.setOrientation(JToolBar.VERTICAL);
		this.setFloatable(false);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		//Criando o painel de DEPOSITADO
		painelDepositado = new PainelDepositadoCtrl();
		this.add(painelDepositado, BorderLayout.NORTH);
		
		//Criando a toolbar de CONFIRMA e CANCELA
		buttons = new ToolBarButtonsCtrl();	
		this.add(buttons, BorderLayout.CENTER);
		
		//Criando o painel TROCO
		painelTroco = new PainelTrocoCtrl();
		this.add(painelTroco, BorderLayout.SOUTH);		
		
	}	
	
	protected void zerarDeposito()
	{
		painelDepositado.zerarDeposito();
	}
	
	protected void printTroco()
	{
		painelTroco.printTroco();
	}

}
