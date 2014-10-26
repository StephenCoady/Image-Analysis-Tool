package windows;

import imageprocessing.Component;
import imageprocessing.ConnectedComponentImage;

import java.awt.FileDialog;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JTable;

import java.awt.List;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.SystemColor;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import edu.princeton.cs.introcs.Picture;
import edu.princeton.cs.introcs.StdOut;

import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLayeredPane;
import javax.swing.UIManager;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import org.imgscalr.Scalr;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("unused")
public class Window {

	private JFrame frame;
	private JTextPane textPane;
	private JTextArea textArea;
	private JTextField txtBi;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JTextPane txtpnPleaseChooseAn;
	private JList<Object> list_1;
	private Picture pic;
	private JPanel panel_1;
	private JLayeredPane layeredPane;
	private JTextPane txtpnBinariseTheImage;
	private JButton btnBinarise;
	private JButton btnBinarise_1;
	private String filePath;
	private JPanel panel_2;
	private JLayeredPane layeredPane_1;
	private JTextPane txtpnCountComponents;
	private JButton btnCount;
	private JTextPane textPane_1;
	private JLayeredPane layeredPane_2;
	private JPanel panel_3;
	private JLayeredPane layeredPane_3;
	private JTextPane txtpnGreyScale;
	private JButton btnGreyScale;
	private JPanel panel_4;
	private JLayeredPane layeredPane_4;
	private JTextPane txtpnRandomiseColours;
	private JButton btnRandomise;
	private JPanel panel_5;
	private JLayeredPane layeredPane_5;
	private JTextPane txtpnRandomiseEachObjects;
	private JButton btnRandomise_1;
	private JPanel panel_6;
	private JFileChooser fileChooser;
	private JFileChooser fileChooser_1;
	private JFileChooser fileChooser_2;
	private JFileChooser chooser;
	private JButton btnPopOut;
	private JButton btnPopOutImage;
	private JButton btnPopOutImage_1;
	private JButton btnPopOutImage_2;
	private JSlider slider_1;
	private JTextPane txtpnChangeTheBinarisation;
	private JTextPane txtpnWouldYouLike;
	private JButton btnChooseAgain;
	private JLayeredPane layeredPane_6;
	private JPanel panel_7;
	private JTextPane txtpnThisProgramCan;
	private JLayeredPane layeredPane_7;
	private JLayeredPane layeredPane_8;
	private JTextPane txtpnCaptureWebcamImage;
	private JButton btnCapture;
	private JPanel panel_8;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public Window() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame. adds each panel and contents
	 * @throws IOException 
	 */
	private void initialize() throws IOException 
	{
		frame = new JFrame();
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 711, 639);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		frame.getContentPane().add(tabbedPane);


		JFileChooser chooser = new JFileChooser("src/images");
		chooser.setDialogTitle("Please choose a file to work with");
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPG & GIF Images", "jpg", "gif", "png", "bmp");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(tabbedPane);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			this.filePath = chooser.getSelectedFile().getAbsolutePath();
		}

		panel = new JPanel();
		tabbedPane.addTab("Main Menu", null, panel, null);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("139px:grow"),
				ColumnSpec.decode("196px"),},
				new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("16px"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(173dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));

		txtpnPleaseChooseAn = new JTextPane();
		txtpnPleaseChooseAn.setBackground(SystemColor.window);
		txtpnPleaseChooseAn.setEditable(false);
		txtpnPleaseChooseAn.setText("  You have decided to work with: ");
		panel.add(txtpnPleaseChooseAn, "1, 2, 2, 1, left, top");

		panel_1 = new JPanel();
		panel.add(panel_1, "1, 6, 2, 1, center, fill");

		BufferedImage myPicture = ImageIO.read(new File(chooser.getSelectedFile().getAbsolutePath()));
		BufferedImage mySmallImage = Scalr.resize(myPicture, 420);
		this.filePath = chooser.getSelectedFile().getAbsolutePath();
		JLabel picLabel = new JLabel(new ImageIcon(mySmallImage));
		panel_1.add(picLabel);

		txtpnWouldYouLike = new JTextPane();
		txtpnWouldYouLike.setBackground(SystemColor.window);
		txtpnWouldYouLike.setText("Would you like to choose a different image?");
		panel.add(txtpnWouldYouLike, "1, 14, center, center");

		btnChooseAgain = new JButton("Choose again");
		btnChooseAgain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				JFileChooser chooser = new JFileChooser(new File("src/images"));
				chooser.setDialogTitle("Please choose a file to work with");
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"JPG & GIF Images", "jpg", "gif", "png", "bmp");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(tabbedPane);
				if (returnVal == JFileChooser.APPROVE_OPTION) 
				{
					BufferedImage myPicture=null;
					try {
						myPicture = ImageIO.read(new File(chooser.getSelectedFile().getAbsolutePath()));
					} catch (IOException e1) 
					{
						e1.printStackTrace();
					}
					BufferedImage mySmallImage = Scalr.resize(myPicture, 420);
					filePath = chooser.getSelectedFile().getAbsolutePath();
					JLabel picLabel = new JLabel(new ImageIcon(mySmallImage));
					panel_1.removeAll();
					panel_4.removeAll();
					panel_2.removeAll();
					panel_5.removeAll();					
					panel_6.removeAll();
					panel_1.add(picLabel);
					panel_1.revalidate();
					panel_1.repaint();
				}
			}
		});
		panel.add(btnChooseAgain, "2, 14, center, default");


		/*
		 * From here is grey scale tab
		 */

		layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Grey Scale", null, layeredPane_2, null);


		panel_3 = new JPanel();
		panel_3.setBounds(0, 6, 590, 456);
		layeredPane_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		layeredPane_3 = new JLayeredPane();
		panel_3.add(layeredPane_3);
		GridBagLayout gbl_layeredPane_3 = new GridBagLayout();
		gbl_layeredPane_3.columnWidths = new int[]{76, 42, 206, 34, 20, -25, 0};
		gbl_layeredPane_3.rowHeights = new int[]{48, 0, 0, 167, 0, 0, 0, 0};
		gbl_layeredPane_3.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_layeredPane_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		layeredPane_3.setLayout(gbl_layeredPane_3);


		txtpnGreyScale = new JTextPane();
		txtpnGreyScale.setText("Grey Scale?");
		txtpnGreyScale.setEditable(false);
		txtpnGreyScale.setBackground(SystemColor.window);
		GridBagConstraints gbc_txtpnGreyScale = new GridBagConstraints();
		gbc_txtpnGreyScale.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnGreyScale.gridx = 2;
		gbc_txtpnGreyScale.gridy = 0;
		layeredPane_3.add(txtpnGreyScale, gbc_txtpnGreyScale);

		btnGreyScale = new JButton("Grey Scale");
		btnGreyScale.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ConnectedComponentImage component = new ConnectedComponentImage(filePath);
				Picture greyScale = component.greyScale();
				pic = greyScale;
				pic.save("greyImage.jpg");
				try {
					runGreyScale();
					panel_4.revalidate();
					panel_4.repaint();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});
		GridBagConstraints gbc_btnGreyScale = new GridBagConstraints();
		gbc_btnGreyScale.insets = new Insets(0, 0, 5, 5);
		gbc_btnGreyScale.gridx = 2;
		gbc_btnGreyScale.gridy = 1;
		layeredPane_3.add(btnGreyScale, gbc_btnGreyScale);

		panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.window);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 3;
		layeredPane_3.add(panel_4, gbc_panel_4);
		
				btnPopOut = new JButton("Pop Out Image");
				btnPopOut.setBounds(236, 474, 136, 29);
				layeredPane_2.add(btnPopOut);
				btnPopOut.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						Picture pic = new Picture("greyImage.jpg");
						pic.show();
					}
				});

		/*
		 * Binary panes
		 * 
		 */

		layeredPane = new JLayeredPane();
		tabbedPane.addTab("Binary", null, layeredPane, null);
		GridBagLayout gbl_layeredPane = new GridBagLayout();
		gbl_layeredPane.columnWidths = new int[]{17, 110, 317, 34, 76, -25, 0};
		gbl_layeredPane.rowHeights = new int[]{55, 0, 0, 0, 287, 0, 0, 0};
		gbl_layeredPane.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_layeredPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		layeredPane.setLayout(gbl_layeredPane);

		txtpnBinariseTheImage = new JTextPane();
		txtpnBinariseTheImage.setEditable(false);
		txtpnBinariseTheImage.setBackground(UIManager.getColor("Button.background"));
		txtpnBinariseTheImage.setText("                            Binarise the image?");
		GridBagConstraints gbc_txtpnBinariseTheImage = new GridBagConstraints();
		gbc_txtpnBinariseTheImage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtpnBinariseTheImage.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnBinariseTheImage.gridx = 2;
		gbc_txtpnBinariseTheImage.gridy = 0;
		layeredPane.add(txtpnBinariseTheImage, gbc_txtpnBinariseTheImage);

		btnBinarise_1 = new JButton("Binarise");
		btnBinarise_1.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ConnectedComponentImage component = new ConnectedComponentImage(filePath);
				Picture binary = component.binaryComponentImage();
				pic = binary;
				pic.save("binaryImage.jpg");
				try {
					runBinary();
					panel_2.revalidate();
					panel_2.repaint();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnBinarise_1 = new GridBagConstraints();
		gbc_btnBinarise_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnBinarise_1.gridx = 2;
		gbc_btnBinarise_1.gridy = 1;
		layeredPane.add(btnBinarise_1, gbc_btnBinarise_1);

		slider_1 = new JSlider(0, 255);
		slider_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) 
			{
				if (!slider_1.getValueIsAdjusting()) 
				{
					ConnectedComponentImage component = new ConnectedComponentImage(filePath);
					Picture binary;
					component.setThreshhold(slider_1.getValue());
					binary = component.binaryComponentImage();
					pic = binary;
					pic.save("binaryImage.jpg");
					try {
						runBinary();
						panel_2.revalidate();
						panel_2.repaint();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		txtpnChangeTheBinarisation = new JTextPane();
		txtpnChangeTheBinarisation.setBackground(SystemColor.window);
		txtpnChangeTheBinarisation.setText("Change the binarisation threshold: ");
		GridBagConstraints gbc_txtpnChangeTheBinarisation = new GridBagConstraints();
		gbc_txtpnChangeTheBinarisation.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnChangeTheBinarisation.gridx = 1;
		gbc_txtpnChangeTheBinarisation.gridy = 3;
		layeredPane.add(txtpnChangeTheBinarisation, gbc_txtpnChangeTheBinarisation);
		GridBagConstraints gbc_slider_1 = new GridBagConstraints();
		gbc_slider_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider_1.insets = new Insets(0, 0, 5, 5);
		gbc_slider_1.gridx = 2;
		gbc_slider_1.gridy = 3;
		layeredPane.add(slider_1, gbc_slider_1);

		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 4;
		layeredPane.add(panel_2, gbc_panel_2);
						
								btnPopOutImage = new JButton("Pop Out Image");
								btnPopOutImage.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) 
									{
										Picture pic = new Picture("binaryImage.jpg");
										pic.show();
									}
								});
								GridBagConstraints gbc_btnPopOutImage = new GridBagConstraints();
								gbc_btnPopOutImage.insets = new Insets(0, 0, 5, 5);
								gbc_btnPopOutImage.gridx = 2;
								gbc_btnPopOutImage.gridy = 5;
								layeredPane.add(btnPopOutImage, gbc_btnPopOutImage);

		/*
		 * Counts components
		 */
		layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Count", null, layeredPane_1, null);
		layeredPane_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(80dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(99dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(40dlu;default)"),},
				new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(23dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("top:3dlu"),
				RowSpec.decode("max(24dlu;default)"),
				RowSpec.decode("max(59dlu;default)"),}));

		txtpnCountComponents = new JTextPane();
		txtpnCountComponents.setText("Count Components?");
		txtpnCountComponents.setEditable(false);
		txtpnCountComponents.setBackground(SystemColor.window);
		layeredPane_1.add(txtpnCountComponents, "4, 2, center, center");
		textPane_1 = new JTextPane();
		textPane_1.setEditable(false);
		layeredPane_1.add(textPane_1, "4, 6, fill, fill");
		btnCount = new JButton("Count");
		btnCount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ConnectedComponentImage component = new ConnectedComponentImage(filePath);
				String text = Integer.toString(component.countComponents());
				textPane_1.setText("Number of components: " +  text);
			}
		});
		layeredPane_1.add(btnCount, "4, 5, center, default");

		/*
		 * Randomise Colours
		 */

		layeredPane_4 = new JLayeredPane();
		layeredPane_4.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Randomise", null, layeredPane_4, null);
		GridBagLayout gbl_layeredPane_4 = new GridBagLayout();
		gbl_layeredPane_4.columnWidths = new int[]{117, 182, 0, 0};
		gbl_layeredPane_4.rowHeights = new int[]{37, 63, 310, 0, 0};
		gbl_layeredPane_4.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_layeredPane_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		layeredPane_4.setLayout(gbl_layeredPane_4);

		txtpnRandomiseColours = new JTextPane();
		txtpnRandomiseColours.setBackground(SystemColor.window);
		txtpnRandomiseColours.setText("Randomise Colours");
		GridBagConstraints gbc_txtpnRandomiseColours = new GridBagConstraints();
		gbc_txtpnRandomiseColours.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnRandomiseColours.fill = GridBagConstraints.VERTICAL;
		gbc_txtpnRandomiseColours.gridx = 1;
		gbc_txtpnRandomiseColours.gridy = 0;
		layeredPane_4.add(txtpnRandomiseColours, gbc_txtpnRandomiseColours);

		btnRandomise = new JButton("Randomise");
		btnRandomise.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(new File ("binaryImage.jpg")!=null)
				{
					ConnectedComponentImage component = new ConnectedComponentImage("binaryImage.jpg");
					Picture colour = component.colourComponentImage();
					pic = colour;
					pic.save("colourImage.jpg");
					try {
						runRandom();
						panel_5.revalidate();
						panel_5.repaint();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else
				{
					ConnectedComponentImage component = new ConnectedComponentImage(filePath);
					Picture colour = component.colourComponentImage();
					pic = colour;
					pic.save("colourImage.jpg");
					try {
						runRandom();
						panel_5.revalidate();
						panel_5.repaint();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		GridBagConstraints gbc_btnRandomise = new GridBagConstraints();
		gbc_btnRandomise.insets = new Insets(0, 0, 5, 5);
		gbc_btnRandomise.gridx = 1;
		gbc_btnRandomise.gridy = 1;
		layeredPane_4.add(btnRandomise, gbc_btnRandomise);

		panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.window);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 1;
		gbc_panel_5.gridy = 2;
		layeredPane_4.add(panel_5, gbc_panel_5);
		
				btnPopOutImage_1 = new JButton("Pop Out Image");
				btnPopOutImage_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Picture pic = new Picture("colourImage.jpg");
						pic.show();
					}
				});
				GridBagConstraints gbc_btnPopOutImage_1 = new GridBagConstraints();
				gbc_btnPopOutImage_1.insets = new Insets(0, 0, 0, 5);
				gbc_btnPopOutImage_1.gridx = 1;
				gbc_btnPopOutImage_1.gridy = 3;
				layeredPane_4.add(btnPopOutImage_1, gbc_btnPopOutImage_1);

		/*
		 * deals with boxing components
		 */

		layeredPane_5 = new JLayeredPane();
		tabbedPane.addTab("Components", null, layeredPane_5, null);
		layeredPane_5.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(72dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(110dlu;default):grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(42dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(155dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));

		txtpnRandomiseEachObjects = new JTextPane();
		txtpnRandomiseEachObjects.setBackground(SystemColor.window);
		txtpnRandomiseEachObjects.setText("Highlight each component with a red box");
		layeredPane_5.add(txtpnRandomiseEachObjects, "4, 2, center, fill");

		btnRandomise_1 = new JButton("Highlight");
		btnRandomise_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ConnectedComponentImage component = new ConnectedComponentImage(filePath);
				Picture boxed = component.identifiedComponentImage();
				pic = boxed;
				pic.save("boxedImage.jpg");
				try {
					runBoxed();
					panel_6.revalidate();
					panel_6.repaint();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		layeredPane_5.add(btnRandomise_1, "4, 4, center, default");

		panel_6 = new JPanel();
		layeredPane_5.add(panel_6, "4, 6, fill, fill");
		
				btnPopOutImage_2 = new JButton("Pop Out Image");
				btnPopOutImage_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnPopOutImage_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						Picture pic = new Picture("boxedImage.jpg");
						pic.show();
					}
				});
				layeredPane_5.add(btnPopOutImage_2, "4, 8, center, default");
				
				layeredPane_7 = new JLayeredPane();
				tabbedPane.addTab("Web Cam", null, layeredPane_7, null);
				
				layeredPane_8 = new JLayeredPane();
				layeredPane_8.setBackground(Color.LIGHT_GRAY);
				layeredPane_8.setBounds(6, 6, 690, 571);
				layeredPane_7.add(layeredPane_8);
				GridBagLayout gbl_layeredPane_8 = new GridBagLayout();
				gbl_layeredPane_8.columnWidths = new int[]{117, 182, 0, 0};
				gbl_layeredPane_8.rowHeights = new int[]{37, 63, 310, 0, 0};
				gbl_layeredPane_8.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
				gbl_layeredPane_8.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				layeredPane_8.setLayout(gbl_layeredPane_8);
				
				txtpnCaptureWebcamImage = new JTextPane();
				txtpnCaptureWebcamImage.setText("Capture Webcam Image");
				txtpnCaptureWebcamImage.setBackground(SystemColor.window);
				GridBagConstraints gbc_txtpnCaptureWebcamImage = new GridBagConstraints();
				gbc_txtpnCaptureWebcamImage.fill = GridBagConstraints.VERTICAL;
				gbc_txtpnCaptureWebcamImage.insets = new Insets(0, 0, 5, 5);
				gbc_txtpnCaptureWebcamImage.gridx = 1;
				gbc_txtpnCaptureWebcamImage.gridy = 0;
				layeredPane_8.add(txtpnCaptureWebcamImage, gbc_txtpnCaptureWebcamImage);
				
				btnCapture = new JButton("Capture");
				btnCapture.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						ConnectedComponentImage component = new ConnectedComponentImage(filePath);
						BufferedImage captured = component.webCam();
						File outputfile = new File("saved.png");
					    try {
							ImageIO.write(captured, "png", outputfile);
						} catch (IOException e2) {
							e2.printStackTrace();
						}
						try {
							runCapture();
							panel_8.revalidate();
							panel_8.repaint();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				});
				GridBagConstraints gbc_btnCapture = new GridBagConstraints();
				gbc_btnCapture.insets = new Insets(0, 0, 5, 5);
				gbc_btnCapture.gridx = 1;
				gbc_btnCapture.gridy = 1;
				layeredPane_8.add(btnCapture, gbc_btnCapture);
				
				panel_8 = new JPanel();
				panel_8.setBackground(SystemColor.window);
				GridBagConstraints gbc_panel_8 = new GridBagConstraints();
				gbc_panel_8.fill = GridBagConstraints.BOTH;
				gbc_panel_8.insets = new Insets(0, 0, 5, 5);
				gbc_panel_8.gridx = 1;
				gbc_panel_8.gridy = 2;
				layeredPane_8.add(panel_8, gbc_panel_8);
				
				button_1 = new JButton("Pop Out Image");
				button_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) 
					{
						Picture pic = new Picture("saved.png");
						pic.show();
					}
				});
				GridBagConstraints gbc_button_1 = new GridBagConstraints();
				gbc_button_1.insets = new Insets(0, 0, 0, 5);
				gbc_button_1.gridx = 1;
				gbc_button_1.gridy = 3;
				layeredPane_8.add(button_1, gbc_button_1);
				
				layeredPane_6 = new JLayeredPane();
				tabbedPane.addTab("About", null, layeredPane_6, null);
				layeredPane_6.setLayout(new GridLayout(1, 0, 0, 0));
				
				panel_7 = new JPanel();
				layeredPane_6.add(panel_7);
				panel_7.setLayout(new GridLayout(1, 0, 0, 0));
				
				txtpnThisProgramCan = new JTextPane();
				txtpnThisProgramCan.setEditable(false);
				txtpnThisProgramCan.setBackground(SystemColor.window);
				txtpnThisProgramCan.setText("NOTE: This file is also contained in the \"About\" tab of the Graphical Interface. \n\nThis program can be used to perform several image analysis processes on any image of your choosing. NOTE: it is still buggy. Images larger than ~4MB may not render correctly. You will also need to use the binary tab to binarise the image before being able to use the random colours process. This is due to the face that the randomise function uses a binarised image to colour each component, and adjusting the slider is then reflected in the random colours image.\n\nExtra work (outside of spec sheet):\n- GUI added\n- Grey Scale method implemented\n- Binary Slider added, allows the user to choose how deep binarisation should go\n- File chooser added, allows the user to choose their own image\n- Added a pdf containing run times for each process and a graph showing its order of growth in time. This pdf is entitled \"trends.pdf\"\nand can be found bundled in the main project folder. \n- added JUnit tests to test each method in the main connected component\n- after each process has been carried out, the user has the option to \"pop-out\" the image. this will allow them to save the updated version, if they so wish.\n- the user may also change their choice of image on the main menu tab, without needing to restart the program.\n- added a runnable jar file, which can be run without needing to import the project into eclipse. \nNOTE: to use this jar java must be installed on the users computer.\n\n\n\n\n\n\n\nStephen Coady\n20064122\nscoady2@gmail.com");
				panel_7.add(txtpnThisProgramCan);
	}

	/**
	 * sets the pictue to be used, which is taken from the file chooser
	 * 
	 * @throws IOException
	 */
	
	private void chooseFile() throws IOException
	{
		this.pic = new Picture(fileChooser.getSelectedFile().getAbsolutePath());

	}
	
	/**
	 * runs the binary method and adds the binarised image to the panel using buffered image
	 * @throws IOException
	 */
	private void runBinary() throws IOException
	{
		BufferedImage binaryImage = ImageIO.read(new File("binaryImage.jpg"));
		BufferedImage binarySmallImage = Scalr.resize(binaryImage, 450);
		JLabel binaryLabel = new JLabel(new ImageIcon(binarySmallImage));
		if(panel_2.getComponents()==null)
		{
			panel_2.add(binaryLabel);
		}
		else
		{
			panel_2.removeAll();
			panel_2.add(binaryLabel);
		}
	}

	/**
	 * runs the greyscale method and adds the image to the panel using buffered image
	 * @throws IOException
	 */
	private void runGreyScale() throws IOException
	{
		BufferedImage greyImage = ImageIO.read(new File("greyImage.jpg"));
		BufferedImage greySmallImage = Scalr.resize(greyImage, 420);
		JLabel greyLabel = new JLabel(new ImageIcon(greySmallImage));
		if(panel_4.getComponents()==null)
		{
			panel_4.add(greyLabel);
		}
		else
		{
			panel_4.removeAll();
			panel_4.add(greyLabel);
		}
	}

	/**
	 * runs the random colour method and adds the image to the panel using buffered image
	 * @throws IOException
	 */
	
	private void runRandom() throws IOException
	{
		BufferedImage colourImage = ImageIO.read(new File("colourImage.jpg"));
		BufferedImage colourSmallImage = Scalr.resize(colourImage, 420);
		JLabel colourLabel = new JLabel(new ImageIcon(colourSmallImage));
		if(panel_5.getComponents()==null)
		{
			panel_5.add(colourLabel);
		}
		else
		{
			panel_5.removeAll();
			panel_5.add(colourLabel);
		}
	}

	/**
	 * runs the identify component images method and adds the image to the panel using buffered image
	 * @throws IOException
	 */
	private void runBoxed() throws IOException
	{
		BufferedImage boxedImage = ImageIO.read(new File("boxedImage.jpg"));
		BufferedImage boxedSmallImage = Scalr.resize(boxedImage, 420);
		JLabel boxedLabel = new JLabel(new ImageIcon(boxedSmallImage));
		if(panel_6.getComponents()==null)
		{
			panel_6.add(boxedLabel);
		}
		else
		{
			panel_6.removeAll();
			panel_6.add(boxedLabel);
		}
	}
	
	private void runCapture() throws IOException
	{
		BufferedImage capturedImage = ImageIO.read(new File("saved.png"));
		BufferedImage capturedSmallImage = Scalr.resize(capturedImage, 420);
		JLabel capturedLabel = new JLabel(new ImageIcon(capturedSmallImage));
		if(panel_8.getComponents()==null)
		{
			panel_8.add(capturedLabel);
		}
		else
		{
			panel_8.removeAll();
			panel_8.add(capturedLabel);
		}
	}
}
