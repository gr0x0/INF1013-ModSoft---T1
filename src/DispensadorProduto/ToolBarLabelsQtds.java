package DispensadorProduto;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

class ToolBarLabelsQtds extends JToolBar 
{
	private int qtdFanta = 15;
	private int qtdCoca = 10;
	private int qtdAntartica = 17;
	private int qtdSkol = 5;
	
	private JLabel labelQtdFanta;
	private JLabel labelQtdCoca;
	private JLabel labelQtdAntartica;
	private JLabel labelQtdSkol;
	
	public ToolBarLabelsQtds()
	{
		this.setOrientation(JToolBar.HORIZONTAL);
		this.setFloatable(false);
		this.setVisible(true);	
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1) ;
		
		//Inicializando label 'FANTA'
		this.add(Box.createHorizontalStrut(80));
		labelQtdFanta = new JLabel("   15   ",JLabel.CENTER);
		labelQtdFanta.setBackground(Color.WHITE);
		labelQtdFanta.setBorder(border);	
		this.add(labelQtdFanta);
		
		//Inicializando label 'COCA'
		this.add(Box.createHorizontalStrut(150));
		labelQtdCoca = new JLabel("   10   ",JLabel.CENTER);
		labelQtdCoca.setBackground(Color.WHITE);
		labelQtdCoca.setBorder(border);	
		this.add(labelQtdCoca);
		
		//Inicializando label 'ANTARTICA'
		this.add(Box.createHorizontalStrut(150));
		labelQtdAntartica = new JLabel("   17   ",JLabel.CENTER);
		labelQtdAntartica.setBackground(Color.WHITE);
		labelQtdAntartica.setBorder(border);	
		this.add(labelQtdAntartica);
		
		//Inicializando label 'SKOL'
		this.add(Box.createHorizontalStrut(150));
		labelQtdSkol = new JLabel("    5    ",JLabel.CENTER);
		labelQtdSkol.setBackground(Color.WHITE);
		labelQtdSkol.setBorder(border);	
		this.add(labelQtdSkol);
	}
	
	protected void decrementarQtd(int i)
	{
		switch(i)
		{
		case(1):
			qtdFanta--;
			labelQtdFanta.setText(String.format("   "+"%d"+"   ", qtdFanta));
			break;
		case(2):
			qtdCoca--;
			labelQtdCoca.setText(String.format("   "+"%d"+"   ", qtdCoca));
			break;
		case(3):
			qtdAntartica--;
			labelQtdAntartica.setText(String.format("   "+"%d"+"   ", qtdAntartica));
			break;
		case(4):
			qtdSkol--;
			labelQtdSkol.setText(String.format("    "+"%d"+"    ", qtdSkol));
			break;
		case(0):
			break;
		default:
			break;
		}		

		this.repaint();
	}
	
	protected boolean isZeroQtd(int i)
	{
		switch(i)
		{
		case(1):
			if(qtdFanta > 0) return false;
			break;
		case(2):
			if(qtdCoca > 0) return false;
			break;
		case(3):
			if(qtdAntartica > 0) return false;
			break;
		case(4):
			if(qtdSkol > 0) return false;
			break;
		case(0):
			break;
		default:
			break;
		}
		
		return true;
	}
}