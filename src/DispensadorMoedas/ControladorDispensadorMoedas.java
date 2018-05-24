package DispensadorMoedas;

import ObserverPattern.*;

public class ControladorDispensadorMoedas
{	
	private static ControladorDispensadorMoedas ctrlMoedas = null;
	private static PainelMoedas pMoedas = null;
	
	private ControladorDispensadorMoedas()
	{}
	
	public static ControladorDispensadorMoedas getCtrlMoedas()
	{
		if(ctrlMoedas == null)
		{
			ctrlMoedas = new ControladorDispensadorMoedas();
			pMoedas = new PainelMoedas();
		}
		return ctrlMoedas;
	}
	
	public static PainelMoedas getPainelMoedas()
	{
		return pMoedas;
	}
	
	public void libMd(double v)
	{}
	
	public ObservadoIF registra(ObservadorIF o)
	{
		pMoedas.add(o);
		return pMoedas;
	}

}
