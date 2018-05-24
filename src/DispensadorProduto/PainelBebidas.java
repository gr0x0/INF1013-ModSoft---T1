package DispensadorProduto;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.imageio.ImageIO;
import javax.swing.*;
import DispensadorMoedas.*;
import ObserverPattern.*;
import ControladorVenda.*;

class PainelBebidas extends JPanel implements ObservadoIF
{
	private Image imgFanta;
	private Image imgCoca;
	private Image imgAntartica;
	private Image imgSkol;
	int pixelsDistX = 10, pixelsDistY = 10, imgSizeX = 175, imgSizeY = 320;
	int coordX, coordY;
	int valBebida = 0;
	private ArrayList<ObservadorIF> observadorList = new ArrayList<ObservadorIF>();
	ControladorVenda controlador;
	
	public PainelBebidas()
	{		
		ControladorDispensadorProduto.getCtrlProduto();
		controlador = ControladorVenda.getCtrlVenda();
		
		//Tratamento de click das bebidas'
		MouseListener ClickEvent = new MouseListener() 
		{
			public void mouseClicked(MouseEvent e) {
				
				if(SwingUtilities.isLeftMouseButton(e))
				{
					coordX = e.getX();
					coordY = e.getY();
					
					//Tratamento de click de 'Fanta'
					if(coordY > pixelsDistY && coordY < (pixelsDistY + imgSizeY) &&
						coordX > pixelsDistX && coordX < (pixelsDistX+imgSizeX) &&
						controlador.isBebidaAllowed()==true)
					{
						valBebida = 1;
						controlador.selPr(1);
						atualiza();
					}
					
					//Tratamento de click de 'Coca'
					if(coordY > pixelsDistY && coordY < (pixelsDistY+imgSizeY) &&
							coordX > (2*pixelsDistX + imgSizeX) && coordX < (2*pixelsDistX + 2*imgSizeX) &&
							controlador.isBebidaAllowed()==true)
					{
						valBebida = 2;
						controlador.selPr(2);
						atualiza();
					}
					
					//Tratamento de click de 'Antartica'
					if(coordY > pixelsDistY && coordY < (pixelsDistY+imgSizeY) &&
							coordX > (3*pixelsDistX + 2*imgSizeX) && coordX < (3*pixelsDistX + 3*imgSizeX) &&
							controlador.isBebidaAllowed()==true)
					{
						valBebida = 3;
						controlador.selPr(3);
						atualiza();
					}
					
					//Tratamento de click de 'Skol'	
					if(coordY > pixelsDistY && coordY < (pixelsDistY+imgSizeY) &&
							coordX > (4*pixelsDistX + 3*imgSizeX) && coordX < (4*pixelsDistX + 4*imgSizeX) &&
							controlador.isBebidaAllowed()==true)
					{
						valBebida = 4;
						controlador.selPr(4);
						atualiza();
					}
					
					//Tratamento de click fora das moedas
					else
						valBebida = 0;					
				}
					
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		};
		addMouseListener(ClickEvent);									
	}
	
	public void paintComponent(Graphics g)
	{
		int finalDistX = pixelsDistX;
		
		super.paintComponent(g);
		Graphics2D graphics2D = (Graphics2D) g;

		try
		{
			imgFanta = ImageIO.read(new File("img\\fanta.gif"));
			graphics2D.drawImage(imgFanta, finalDistX, pixelsDistY, null);
			finalDistX += pixelsDistX + imgSizeX;
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		try
		{
			imgCoca = ImageIO.read(new File("img\\coca.gif"));
			graphics2D.drawImage(imgCoca, finalDistX, pixelsDistY, null);
			finalDistX += pixelsDistX + imgSizeX;
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		try
		{
			imgAntartica = ImageIO.read(new File("img\\antartica.gif"));
			graphics2D.drawImage(imgAntartica, finalDistX, pixelsDistY, null);
			finalDistX += pixelsDistX + imgSizeX;
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		try
		{
			imgSkol = ImageIO.read(new File("img\\skol.gif"));
			graphics2D.drawImage(imgSkol, finalDistX, pixelsDistY, null);
			finalDistX += pixelsDistX + imgSizeX;
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	
	public void add(ObservadorIF o)
	{
		observadorList.add(o);
	}
	
	private void atualiza()
	{
		ListIterator<ObservadorIF> helpList = observadorList.listIterator();
		while(helpList.hasNext())
		{
			helpList.next().notify(this);
		}
			
	}
	
	public int get(int i)
	{
		return valBebida;
	}
	
	public void remove(ObservadorIF o)
	{
		observadorList.clear();
	}
}
