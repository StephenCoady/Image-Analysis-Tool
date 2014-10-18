package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import imageprocessing.ConnectedComponentImage;
import imageprocessing.WeightedQuickUnionUF;

import org.junit.Test;

import edu.princeton.cs.introcs.Picture;

public class ConnectedComponentTest 
{

	/*
	 * This method tests the binary method. it firsts tests that the total number of
	 * black and white pixels is not the total number of pixels, ie that there are 
	 * other colours in the image apart from black and white. it then runs the binary method
	 * on the same image and checks again if every pixel is either black or white. it then 
	 * checks again if the total black and white pixels equals the total pixels
	 * 
	 */
	@Test
	public void testBinaryComponent()
	{

		Picture pic = new Picture("src/images/shapes.bmp");
		int totalPixels = pic.width()*pic.height();
		int blackWhiteCounter = 0;

		for (int x = 0; x < pic.width(); x++)
		{
			for (int y = 0; y < pic.height(); y++)
			{
				if(pic.get(x, y).equals(Color.BLACK) || 
						pic.get(x, y).equals(Color.WHITE))
				{
					blackWhiteCounter++;
				}
			}
		}

		assertTrue(totalPixels != blackWhiteCounter);

		ConnectedComponentImage component2 = 
				new ConnectedComponentImage("src/images/shapes.bmp");
		Picture pic2 = new Picture(component2.binaryComponentImage());
		blackWhiteCounter = 0;
		for (int x = 0; x < pic2.width(); x++)
		{
			for (int y = 0; y < pic2.height(); y++)
			{
				assertTrue(pic2.get(x, y).equals(Color.BLACK) 
						|| pic2.get(x, y).equals(Color.WHITE));
				if(pic2.get(x, y).equals(Color.BLACK) || 
						pic2.get(x, y).equals(Color.WHITE))
				{
					blackWhiteCounter++;
				}
			}
		}
		assertTrue(totalPixels == blackWhiteCounter);
	}

	/*
	 * simple method to test that the weighted quick union class is working correctly.
	 */

	@Test
	public void testWeightedUnion()
	{
		WeightedQuickUnionUF wqu = new WeightedQuickUnionUF(10);
		wqu.union(1, 2);
		wqu.union(2, 3);
		assertTrue(wqu.connected(1, 3));
		assertFalse(wqu.connected(1, 8));
	}


	/*
	 * tests the counting components method. it tests an image which contains 
	 * no objects and only has black background. then one very large object 
	 * and finally 3 distinct objects. it then counts an image with a large number of 
	 * components and ensures it is not counting 0 objects.
	 * 
	 */
	@Test
	public void testCountComponents() 
	{
		ConnectedComponentImage noComponent = 
				new ConnectedComponentImage("src/images/testNoComponents.png");
		assertTrue(noComponent.countComponents()==0);

		ConnectedComponentImage oneComponent = 
				new ConnectedComponentImage("src/images/testOneComponent.png");
		assertTrue(oneComponent.countComponents()==1);

		ConnectedComponentImage threeComponents = 
				new ConnectedComponentImage("src/images/shapes.bmp");
		assertTrue(threeComponents.countComponents()==3);

		ConnectedComponentImage component = 
				new ConnectedComponentImage("src/images/stars.jpg");
		assertFalse(component.countComponents()==0);
	}

	// TODO

	/*
	 * tests the greyscale method. checks whether or not pixels from the un-greyscaled 
	 * version equals their counterparts from the greyscaled version. if they do not, then 
	 * a change has occured. 
	 */

	@Test
	public void testGreyScale()
	{
		int count = 0;
		Picture pic2 = new Picture("src/images/shapes.bmp");
		ConnectedComponentImage component = 
				new ConnectedComponentImage("src/images/shapes.bmp");
		Picture pic = new Picture(component.greyScale());
		for (int x = 0; x < pic2.width(); x++)
		{
			for (int y = 0; y < pic2.height(); y++)
			{
				if(!pic2.get(x,y).equals(pic.get(x,y)))
				{
					count++;
				}
			}
		}
		assertTrue(count>0);
		

	}

	@Test
	public void testRandomColours()
	{	
		Random random = new Random();
		Picture pic = new Picture("src/images/shapes.bmp");

		ConnectedComponentImage component = 
				new ConnectedComponentImage("src/images/shapes.bmp");
		Picture pic2 = new Picture(component.colourComponentImage());

		ArrayList<Color> colours = new ArrayList<Color>();
		ArrayList<Color> randColours = new ArrayList<Color>();

		for (int i = 0; i < 100; i++)
		{
			int x = random.nextInt(pic.width());
			int y = random.nextInt(pic.height());

			assertTrue(!pic.get(x, y).equals(pic2.get(x, y)));
		}

		for (int x = 0; x < pic.width(); x++)
		{
			for (int y = 0; y < pic.height(); y++)
			{
				colours.add(pic.get(x, y));
			}
		}

		for (int x = 0; x < pic2.width(); x++)
		{
			for (int y = 0; y < pic2.height(); y++)
			{
				randColours.add(pic2.get(x, y));
			}
		}

		if(pic.width()*pic.height() > 1000)
		{
			for (int i = 0; i < 1000; i++)
			{
				int index = random.nextInt(pic.width());
				assertTrue(!colours.get(index).equals(randColours.get(index)));
			}
		}

	}

	@Test
	public void testIdentifiedComponentImage()
	{
		ConnectedComponentImage component = 
				new ConnectedComponentImage("src/images/shapes.bmp");
		Picture binary = new Picture(component.binaryComponentImage());
		Picture identified = new Picture(component.identifiedComponentImage());

		for (int x = 0; x < binary.width(); x++)
		{
			for (int y = 0; y < binary.height(); y++)
			{
				assertTrue(!binary.get(x, y).equals(Color.RED));
			}
		}

		int count = 0;
		for (int x = 0; x < identified.width(); x++)
		{
			for (int y = 0; y < identified.height(); y++)
			{
				if(identified.get(x, y).equals(Color.RED))
				{
					count++;
				}
			}
		}
		assertTrue(count > 0);

	}

}
