package imageprocessing;


import java.awt.Color;

import edu.princeton.cs.introcs.Picture;
import edu.princeton.cs.introcs.StdOut;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*************************************************************************
 * Compilation: javac ConnectedComponentImage.java
 * 
 * A class to use an image and perform several operations on it. All heavy lifting is 
 * performed in this class. The user can turn an image to greyscale, binarise, randomise 
 * the colour of any object and identify components by drawing red boxes around each one.
 * 
 * @author Stephen Coady 
 *************************************************************************/
@SuppressWarnings("unused")
public class ConnectedComponentImage implements ComponentImage
{
	private String fileLocation;
	private int threshhold = 128;
	private int width;
	private int height;



	/**
	 * Initialise fields
	 * 
	 * @param fileLocation
	 */
	public ConnectedComponentImage(String fileLocation) 
	{
		this.fileLocation = fileLocation;
	}                     


	/**
	 * 
	 * a method to perform a weighted quick union on a picture. checks each pixel in the 
	 * image and performs a union if they are not already in a union, and if they have the
	 * same colour value.
	 * 
	 * @param pic the chosen picture to work with.
	 * 
	 * @return the weighted quick union using a certain picture, pic.
	 */
	private WeightedQuickUnionUF checkUnion(Picture pic)
	{
		width = pic.width();
		height = pic.height();

		WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(width*height);
		for (int y = 0; y < height; y++) 
		{
			for (int x = 0; x < width; x++) 
			{
				//checks the pixel to the top
				if( y+1 < height
						&& pic.get(x, y).equals(pic.get(x, y+1)) )
				{
					wqu.union(index(x, y), index(x,y+1));
				}

				//checks the pixel to the right
				if( x+1 < width
						&& pic.get(x, y).equals(pic.get(x+1, y)) ) 
				{
					wqu.union(index(x, y), index(x+1,y));
				}
			} 
		}
		return wqu;
	}

	/**
	 * a method to count the number of objects in a picture. uses a binary image.
	 * 
	 * @return the number of components (between 1 and N) identified in the image. 
	 * discounts the background object
	 */

	public int countComponents() 
	{
		WeightedQuickUnionUF wqu = checkUnion(binaryComponentImage());
		return wqu.count()-1; // -1 allows for the background root
	}

	/**
	 * a method to return the unique index of each pixel in an image
	 * 
	 * @param x - the x value on the grid 
	 * @param y - the y value on the grid
	 * 
	 * @return the unique index of each pixel
	 */

	public int index(int x, int y)
	{
		return (y*(width)) + x;
	}

	/**
	 * a method to draw a red box around each identified object in an image. 
	 * 
	 * @return a picture object with all components surrounded by a red box, including the 
	 * background "object"
	 */


	public Picture identifiedComponentImage() 
	{
		Picture binaryPic = new Picture(binaryComponentImage());
		WeightedQuickUnionUF wqf = checkUnion(binaryPic);

		Picture pic = new Picture(this.fileLocation);
		ArrayList<Component> components = new ArrayList<Component>();
		ArrayList<Integer> componentRoots = new ArrayList<Integer>();

		width = pic.width();
		height = pic.height();

		for (int y = 0; y < height; y++) 
		{
			for (int x = 0; x < width; x++) 
			{
				componentRoots.add(wqf.find(index(x,y)));
			}
		}
		Set<Integer> noDupes = new HashSet<Integer>(componentRoots);
		componentRoots.clear();
		componentRoots.addAll(noDupes);

		for (int i = 0; i < componentRoots.size(); i++)
		{
			Component component = new Component (componentRoots.get(i));
			components.add(component);
		}

		for (int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				for (int i = 0;i < components.size(); i++)
				{
					if (wqf.find(index(x,y)) == components.get(i).getId())
					{
						components.get(i).addPixels(index(x,y));
						break;
					}
				}
			}
		}

		for (int i = 0; i < components.size(); i++)
		{
			int largestX = components.get(i).getLargestX(width);
			int largestY = components.get(i).getLargestY(width);
			int smallestX = components.get(i).getSmallestX(width);
			int smallestY = components.get(i).getSmallestY(width);

			for (int x = smallestX; x <= largestX; x++)
			{
				int y = smallestY;
				pic.set(x, y, Color.RED);
			}
			for (int x = smallestX; x <= largestX; x++)
			{
				int y = largestY;
				pic.set(x, y, Color.RED);
			}
			for (int y = smallestY; y <= largestY; y++)
			{
				int x = smallestX;
				pic.set(x, y, Color.RED);
			}
			for (int y = smallestY; y <= largestY; y++)
			{
				int x = largestX;
				pic.set(x, y, Color.RED);
			}
		}
		return pic;
	}

	/*
	 * sole purpose of this method is to allow the gui to change the threshold 
	 * value using a slider 
	 */
	public void setThreshhold(int threshhold) 
	{
		this.threshhold = threshhold;
	}
	
	public int getThreshhold() 
	{
		return threshhold;
	}

	/**
	 * Returns a picture with each object updated to a random colour.
	 * 
	 * @return a picture object with all components coloured randomly.
	 */


	public Picture colourComponentImage() 
	{

		Picture pic = binaryComponentImage();
		WeightedQuickUnionUF wqu = checkUnion(pic);
		
		ArrayList<Integer> roots = new ArrayList <Integer>();
		int width = pic.width();
		int height = pic.height();
		ArrayList<Color> colours = new ArrayList <Color>();


		for (int y = 0; y < height; y++) 
		{
			for (int x = 0; x < width; x++) 
			{
				roots.add(wqu.find(index(x, y)));
			}
		}

		Set<Integer> noDupes = new HashSet<Integer>(roots);
		roots.clear();
		roots.addAll(noDupes);

		for (int i = 0; i < noDupes.size(); i++)
		{
			Random r = new Random();
			Color randomColor = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
			colours.add(randomColor);
		}

		for (int y = 0; y < height; y++) 
		{
			for (int x = 0; x < width; x++) 
			{
				for(int z = 0; z < roots.size(); z++)
				{
					if(wqu.find(index(x, y)) == (roots.get(z)))
					{
						pic.set(x, y, colours.get(z));
						break;
					}
				}
			}
		}
		return pic;

	}

	/**
	 * Returns a binarised version of the original image
	 * 
	 * @return a picture object with all pixels set to either black or white
	 */

	public Picture binaryComponentImage() 
	{
		Picture pic = new Picture(greyScale()); 

		
		int width = pic.width();
		int height = pic.height();
		// convert to binary
		for (int x = 0; x < width; x++) 
		{
			for (int y = 0; y < height; y++) 
			{
				Color c = pic.get(x, y);

				if (Luminance.lum(c) >= threshhold)
				{
					pic.set(x, y, Color.BLACK); 
				} 
				else 
				{
					pic.set(x, y, Color.WHITE); 
				}
			}
		}

		return pic;
	}


	/**
	 * a method to greyscale a picture, which is taken from the fileLocation field
	 * 
	 * @return a picture object with all pixels greyscaled
	 */

	public Picture greyScale()
	{
		Picture pic = new Picture(fileLocation); 
		int width = pic.width();
		int height = pic.height();
		
		for (int x = 0; x < width; x++) 
		{
			for (int y = 0; y < height; y++) 
			{
				Color color = pic.get(x, y);
				Color gray = Luminance.toGray(color); 
				pic.set(x, y, gray);
			} 
		}
		return pic;
	}

}
