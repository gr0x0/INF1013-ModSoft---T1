package DispensadorProduto;

import ObserverPattern.ObservadoIF;
import ObserverPattern.ObservadorIF;

public class ControladorDispensadorProduto
{
	private static ControladorDispensadorProduto ctrlProduto = null;
	private static FrameProdutos pProdutos = null;
	
	private ControladorDispensadorProduto()
	{}
	
	public static ControladorDispensadorProduto getCtrlProduto()
	{
		if(ctrlProduto == null)
		{
			ctrlProduto = new ControladorDispensadorProduto();
			pProdutos = new FrameProdutos();
		}
		return ctrlProduto;
	}
	
	public ObservadoIF registra(ObservadorIF o)
	{
		pProdutos.getPainelBebidas().add(o);
		return pProdutos.getPainelBebidas();
	}
	
	public static void atualizarQtds(int i)
	{
		pProdutos.getToolBarQuantidades().getToolBarLabelsQtds().decrementarQtd(i);
	}
	
	public static boolean isVazio(int i)
	{
		return pProdutos.getToolBarQuantidades().getToolBarLabelsQtds().isZeroQtd(i);
	}

}

