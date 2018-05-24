package PainelControle;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import DispensadorMoedas.*;
import ObserverPattern.*;

class PainelDepositadoCtrl extends JPanel implements ObservadorIF
{
	JLabel labelDepositado;
	float valDepositado = 0;
	
	public PainelDepositadoCtrl()
	{
		//Registrando-se junto ao observado 'ControladorVendas'
		ControladorDispensadorMoedas.getCtrlMoedas().registra(this);
		
		//Definindo o painel
		this.setLayout(new BorderLayout());
		Border border = BorderFactory.createLineBorder(Color.BLACK, 3) ;
		JLabel labelText = new JLabel("-DEPOSITADO-",JLabel.CENTER);
		labelDepositado = new JLabel("R$0,00",JLabel.CENTER);
		labelDepositado.setBackground(Color.WHITE);
		labelDepositado.setBorder(border);
		this.add(labelText, BorderLayout.NORTH);
		this.add(labelDepositado, BorderLayout.CENTER);		
	}
	
	public void setTextValor(float val)
	{
		labelDepositado.setText(String.format("R$"+"%.2f", val));
	}
	
	public void notify(ObservadoIF o)
	{
		switch(o.get(1))
		{
		case(1):
			valDepositado += 1.0;
			break;
		case(2):
			valDepositado += 0.50;
			break;
		case(3):
			valDepositado += 0.25;
			break;
		case(4):
			valDepositado += 0.10;
			break;
		case(0):
			valDepositado += 0.0;
			break;
		default:
			valDepositado += 0.0;
			break;
		}
		
		this.setTextValor(valDepositado);
		this.repaint();
	}
	
	protected void zerarDeposito()
	{
		valDepositado = 0;
		this.setTextValor(valDepositado);
		this.repaint();
	}

}
