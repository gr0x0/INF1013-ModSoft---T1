package ControladorVenda;

import DispensadorMoedas.*;
import DispensadorProduto.*;
import PainelControle.*;

public class ControladorVenda
{
	private static ControladorVenda ctrlVenda = null;
	private double valAcc = 0.0;
	private double valTroco = 0.0;
	private static ControladorDispensadorProduto ctrlProduto = null;
	private static ControladorPainelControle ctrlPainelDeControle = null;
	private boolean flagMoedaAllowed = true;
	private boolean flagBebidaAllowed = false;
	
	private ControladorVenda()
	{}	
	
	public static ControladorVenda getCtrlVenda()
	{
		if(ctrlVenda == null)
		{
			ctrlVenda = new ControladorVenda();
			ctrlProduto = ControladorDispensadorProduto.getCtrlProduto();
			ctrlPainelDeControle = ControladorPainelControle.getCtrlPainelDeControle();
		}
		return ctrlVenda;
	}
	
	public void insVal(double v)
	{
		valAcc += v;
	}
	
	public void selPr(int prod)
	{
		valTroco = valAcc;
		valAcc = 0.0;
		
		switch(prod)
		{
		case(1):
			if(valTroco >= 2.50 && ControladorDispensadorProduto.isVazio(1) == false)
			{
				valTroco -= 2.50;
				ControladorDispensadorProduto.atualizarQtds(1);
				finalizaCompra();
			}
			else finalizaCompra();
			break;
		case(2):
			if(valTroco >= 3.00 && ControladorDispensadorProduto.isVazio(2) == false)
			{
				valTroco -= 3.00;
				ControladorDispensadorProduto.atualizarQtds(2);
				finalizaCompra();
			}
			else finalizaCompra();
			break;
		case(3):
			if(valTroco >= 4.50 && ControladorDispensadorProduto.isVazio(3) == false)
			{
				valTroco -= 4.50;
				ControladorDispensadorProduto.atualizarQtds(3);
				finalizaCompra();
			}
			else finalizaCompra();
			break;
		case(4):
			if(valTroco >= 4.00 && ControladorDispensadorProduto.isVazio(4) == false)
			{
				valTroco -= 4.00;
				ControladorDispensadorProduto.atualizarQtds(4);
				finalizaCompra();
			}
			else finalizaCompra();
			break;
		case(0):
			break;
		default:
			break;
		}
	}
	
	public boolean isMoedaAllowed()
	{
		return flagMoedaAllowed;
	}
	
	public boolean isBebidaAllowed()
	{
		return flagBebidaAllowed;
	}
	
	public double getValorTroco()
	{
		return valTroco;
	}
	
	public void confirmaButtonPressed()
	{
		if(this.isMoedaAllowed()==true && this.isBebidaAllowed()==false)
		{
			flagMoedaAllowed = false;
			flagBebidaAllowed = true;
		}
		else if(this.isMoedaAllowed()==false && this.isBebidaAllowed()==true)
		{
			flagBebidaAllowed = false;
		}
		else if(this.isMoedaAllowed()==false && this.isBebidaAllowed()==false)
		{
			finalizaCompra();
		}		
	}
	
	public void cancelaButtonPressed()
	{
			valTroco = valAcc;
			finalizaCompra();
			valTroco = 0.0;
			valAcc = 0.0;
	}
	
	private void finalizaCompra()
	{
		if(valTroco == 0.0)
			valTroco = valAcc;
		ctrlPainelDeControle.printTroco();
		flagMoedaAllowed = true;
		flagBebidaAllowed = false;
		ctrlPainelDeControle.zerarDeposito();
	}

}
