package PainelControle;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import DispensadorMoedas.*;
import DispensadorProduto.*;
import ObserverPattern.*;
import ControladorVenda.*;

class PainelTrocoCtrl extends JPanel implements ObservadorIF
{	
	JLabel labelTroco;
	double valTroco = 0;
	ControladorVenda controlador;
	
	public PainelTrocoCtrl()
	{		
		//Registrando-se junto ao observado 'PainelBebidas'
		ControladorDispensadorProduto.getCtrlProduto().registra(this);
		
		controlador = ControladorVenda.getCtrlVenda();
		
		//Definindo o Painel
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLACK, 3) ;
		JLabel labelText = new JLabel("-TROCO-",JLabel.CENTER);
		labelTroco = new JLabel("R$0,00",JLabel.CENTER);
		labelTroco.setBackground(Color.WHITE);
		labelTroco.setBorder(border);
		this.add(labelText, BorderLayout.NORTH);
		this.add(labelTroco, BorderLayout.CENTER);		
	}
	
	public void setTextValor(double valTroco2)
	{
		labelTroco.setText(String.format("R$"+"%.2f", valTroco2));
	}
	
	public void notify(ObservadoIF o)
	{
		this.setTextValor(controlador.getValorTroco());
		this.repaint();
	}
	
	protected void printTroco()
	{
		this.setTextValor(controlador.getValorTroco());
		this.repaint();
	}
}
