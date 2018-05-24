package DispensadorMoedas;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import ObserverPattern.*;
import java.util.*;
import ControladorVenda.*;

class PainelMoedas extends JPanel implements ObservadoIF
{		
	private ControladorVenda controlador;
	private Image img100;
	private Image img050;
	private Image img025;
	private Image img010;
	private int pixelsDistX = 25, pixelsDistY = 30, imgSizeX = 65, imgSizeY = 65;
	private int coordX, coordY;
	private int valMoeda = 0;
	private ArrayList<ObservadorIF> observadorList = new ArrayList<ObservadorIF>();
	
	public PainelMoedas()
	{
		controlador = ControladorVenda.getCtrlVenda();
		
		//Tratamento de click das moedas'
		MouseListener ClickEvent = new MouseListener() 
		{
			public void mouseClicked(MouseEvent e) {
				
				if(SwingUtilities.isLeftMouseButton(e))
				{
					coordX = e.getX();
					coordY = e.getY();
					
					//Tratamento de click de moeda $1,00'
					if(coordY > pixelsDistY && coordY < (pixelsDistY + imgSizeY) &&
						coordX > pixelsDistX && coordX < (pixelsDistX+imgSizeX) &&
						controlador.isMoedaAllowed()==true)
					{
						valMoeda = 1;
						controlador.insVal(1.00);
						atualiza();
					}
					
					//Tratamento de click de moeda '$0,50'
					if(coordY > (2*pixelsDistY + imgSizeY) && coordY < (2*pixelsDistY + 2*imgSizeY) &&
							coordX > pixelsDistX && coordX < (pixelsDistX+imgSizeX) &&
							controlador.isMoedaAllowed()==true)
					{
						valMoeda = 2;
						controlador.insVal(0.50);
						atualiza();
					}
					
					//Tratamento de click de moeda '$0,25'
					if(coordY > (3*pixelsDistY + 2*imgSizeY) && coordY < (3*pixelsDistY + 3*imgSizeY) &&
							coordX > pixelsDistX && coordX < (pixelsDistX+imgSizeX) &&
							controlador.isMoedaAllowed()==true)
					{
						valMoeda = 3;
						controlador.insVal(0.25);
						atualiza();
					}
					
					//Tratamento de click de moeda '$0,10;'
					if(coordY > (4*pixelsDistY + 3*imgSizeY) && coordY < (4*pixelsDistY + 4*imgSizeY) &&
							coordX > pixelsDistX && coordX < (pixelsDistX+imgSizeX) &&
							controlador.isMoedaAllowed()==true)
					{
						valMoeda = 4;
						controlador.insVal(0.10);
						atualiza();
					}
					
					//Tratamento de click fora das moedas
					else
						valMoeda = 0;					
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
		int finalDistY = pixelsDistY;
		
		super.paintComponent(g);
		Graphics2D graphics2D = (Graphics2D) g;

		try
		{
			img100 = ImageIO.read(new File("img\\$1,00.gif"));
			graphics2D.drawImage(img100, pixelsDistX, finalDistY, null);
			finalDistY += pixelsDistY + imgSizeY;
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		try
		{
			img050 = ImageIO.read(new File("img\\$0,50.gif"));
			graphics2D.drawImage(img050, pixelsDistX, finalDistY, null);
			finalDistY += pixelsDistY + imgSizeY;
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		try
		{
			img025 = ImageIO.read(new File("img\\$0,25.gif"));
			graphics2D.drawImage(img025, pixelsDistX, finalDistY, null);
			finalDistY += pixelsDistY + imgSizeY;
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		try
		{
			img010 = ImageIO.read(new File("img\\$0,10.gif"));
			graphics2D.drawImage(img010, pixelsDistX, finalDistY, null);
			finalDistY += pixelsDistY + imgSizeY;
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
		if(i==1) return valMoeda;
		return 0;
	}
	
	public void remove(ObservadorIF o)
	{
		observadorList.clear();
	}
}

