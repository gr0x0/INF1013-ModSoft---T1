package PainelControle;

public class ControladorPainelControle 
{
	private static ControladorPainelControle ctrlPainelControle = null;
	private static FramePainelControle pPainelControle = null;
	
	private ControladorPainelControle()
	{}
	
	public static ControladorPainelControle getCtrlPainelDeControle()
	{
		if(ctrlPainelControle == null)
		{
			ctrlPainelControle = new ControladorPainelControle();
			pPainelControle = new FramePainelControle();
		}
		return ctrlPainelControle;
	}
	
	public static FramePainelControle getFramePainelControle()
	{
		return pPainelControle;
	}
	
	public void zerarDeposito()
	{
		pPainelControle.zerarDeposito();
	}
	
	public void printTroco()
	{
		pPainelControle.printTroco();
	}

}
