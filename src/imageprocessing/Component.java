package imageprocessing;

import java.util.ArrayList;

public class Component 
{
	private int id;
	private ArrayList<Integer> pixels;
	
	Component(int id)
	{
		this.id = id;
		pixels = new ArrayList<Integer>();
	}

	public void addPixels(int index)
	{
		pixels.add(index);
	}
	
	public int getPixelsSize()
	{
		return pixels.size();
	}
	
	public int getLargestX(int width)
	{
		int largestX = pixels.get(0)%width;
		for (int i = 0; i < pixels.size(); i++)
		{
			int index = pixels.get(i);
			int x = index%width;
			if(x > largestX)
			{
				largestX = x;
			}
		}
		return largestX;
	}
	
	public int getLargestY(int width)
	{
		int largestY = pixels.get(0)/width;
		for (int i = 0; i < pixels.size(); i++)
		{
			int index = pixels.get(i);
			int y = index/width;
			if(y > largestY)
			{
				largestY = y;
			}
		}
		return largestY;
	}
	
	public int getSmallestX(int width)
	{
		int smallestX = pixels.get(0)%width;
		for (int i = 0; i < pixels.size(); i++)
		{
			int index = pixels.get(i);
			int x = index%width;
			if(x < smallestX)
			{
				smallestX = x;
			}
		}
		return smallestX;
	}
	
	public int getSmallestY(int width)
	{
		int smallestY = pixels.get(0)/width;
		for (int i = 0; i < pixels.size(); i++)
		{
			int index = pixels.get(i);
			int y = index/width;
			if(y < smallestY)
			{
				smallestY = y;
			}
		}
		return smallestY;
	}
	
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}
	
}
