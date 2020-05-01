import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class Inventory extends Throwable implements ActionListener {
	// basic structures
	JFrame frame;
	JTabbedPane pane = new JTabbedPane();
	//Open/Close tab components
	JButton openBtn = new JButton("Open Manager");
	JButton closeBtn = new JButton("Close Manager");
	// Search tab components
	JLabel searchLabel = new JLabel("Search Merchandise:");
	JTextField searchUPC = new JTextField(20);
	JButton searchBtn = new JButton("Search");
	JTextArea searchRslt = new JTextArea(10, 10);
	// new item tab components
	JLabel newMerchLabel = new JLabel("New UPC:");
	JTextField newMerchField = new JTextField(20);
	JButton newMerchBtn = new JButton("Add New Item");
	// add/remove/delete tab components
	JLabel addLabel = new JLabel("Add Merchandise:");
	JTextField addUPC = new JTextField("UPC", 7);
	JTextField addLot = new JTextField("LOT", 7);
	JTextField addQty = new JTextField("Qty", 3);
	JButton addBtn = new JButton("Add");//
	JLabel removeLabel = new JLabel("Remove Merchandise:");
	JTextField removeUPC = new JTextField("UPC", 7);
	JTextField removeLot = new JTextField("LOT", 7);
	JTextField removeQty = new JTextField("Qty", 3);
	JButton removeBtn = new JButton("Remove");
	JLabel deleteLabel = new JLabel("Delete Merchandise:");
	JTextField deleteUPC = new JTextField(20);
	JButton deleteBtn = new JButton("Delete");
	// new LOT tab components
	JLabel newLotName = new JLabel("Name");
	JLabel newLotUPC = new JLabel("UPC");
	JLabel newLotPrice = new JLabel("Price");
	JLabel newLotQty = new JLabel("Quantity");
	JLabel newLotLOT = new JLabel("LOT");
	JTextField lotNameField = new JTextField(20);
	JTextField lotUPCField = new JTextField(20);
	JTextField lotPriceField = new JTextField(5);
	JTextField lotQtyField = new JTextField(5);
	JTextField lotLOTField = new JTextField(10);
	JButton newLOTBtn = new JButton("Add LOT");
	// sale tab components
	JLabel saleUPC = new JLabel("UPC");
	JLabel saleQty = new JLabel("Quantity");
	JTextField saleUPCField = new JTextField(20);
	JTextField saleQtyField = new JTextField(20);
	JButton saleBtn = new JButton("Sell Items(s)");

	// HASH MAP DATA
	HashMap<Integer, LinkedList<Merch>> inventoryList = new HashMap<Integer, LinkedList<Merch>>();
	private final JButton btnClear = new JButton("Clear");
	private final JButton btnClear_1 = new JButton("Clear");
	private final JButton btnClear_2 = new JButton("Clear");
	private final JButton btnClear_3 = new JButton("Clear");
	private final JButton btnClear_4 = new JButton("Clear");
	private final JButton btnClear_5 = new JButton("Clear");
	private final JButton btnClear_6 = new JButton("Clear");
	private final JButton btnClearAllFields = new JButton("Clear All Fields");

	/***************************************************************************************************************/

	// creates GUI
	public void createAndShowGUI() {
		frame = new JFrame("Inventory Manager");
		frame.setSize(500, 300);

		pane.setSize(500, 300);
		// open/close tab and sub panels
		JPanel openClosePanel = new JPanel(new BorderLayout());
		JPanel opnClsTop = new JPanel();
		JPanel opnClsMid = new JPanel();
		JPanel opnClsBot = new JPanel();
		// search tab and sub panels
		JPanel searchPanel = new JPanel(new BorderLayout());
		JPanel searchTop = new JPanel();
		JPanel searchMid = new JPanel();
		JPanel searchBot = new JPanel(new BorderLayout(3, 3));
		// update quantity tab and sub panels
		JPanel updatePanel = new JPanel(new BorderLayout());
		JPanel updateTop = new JPanel();
		JPanel updateMid = new JPanel();
		JPanel updateBot = new JPanel();
		// new LOT tab and sub panels
		JPanel newLotPanel = new JPanel(new BorderLayout());
		JPanel lotTop = new JPanel();
		JPanel lotMid = new JPanel();
		JPanel lotBot = new JPanel();
		// sale tab and sub panels
		JPanel salePanel = new JPanel(new BorderLayout());
		JPanel saleTop = new JPanel();
		JPanel saleMid = new JPanel();
		JPanel saleBot = new JPanel();
		// new merch tab and sub panels
		JPanel newMerchPanel = new JPanel(new BorderLayout());
		JPanel merchTop = new JPanel();
		JPanel merchMid = new JPanel();
		// JPanel merchBot = new JPanel();

		//OPEN/CLOSE TAB
		//top sub panel
		opnClsTop.add(openBtn);
		//mid sub panel
		opnClsMid.add(closeBtn);
		//add sub panels to main panel
		openClosePanel.add(opnClsTop, BorderLayout.PAGE_START);
		openClosePanel.add(opnClsMid, BorderLayout.CENTER);
		
		// SEARCH TAB
		// top sub panel
		searchTop.add(searchLabel);
		// middle sub panel
		searchMid.add(searchUPC);
		searchBtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		searchMid.add(searchBtn);
		// bottom sub panel
		searchBot.add(searchRslt);
		// add sub panels to main panel
		searchPanel.add(searchTop, BorderLayout.PAGE_START);
		searchPanel.add(searchMid, BorderLayout.CENTER);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchUPC.setText(null);
				searchRslt.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 10));
		
		searchMid.add(btnClear);
		searchPanel.add(searchBot, BorderLayout.PAGE_END);

		// UPDATE TAB
		// top sub panel
		updateTop.add(addLabel);
		updateTop.add(addUPC);
		updateTop.add(addLot);
		updateTop.add(addQty);
		updateTop.add(addBtn);
		// middle sub panel
		updateMid.add(removeLabel);
		updateMid.add(removeUPC);
		updateMid.add(removeLot);
		updateMid.add(removeQty);
		updateMid.add(removeBtn);
		// bottom sub panel
		updateBot.add(deleteLabel);
		updateBot.add(deleteUPC);
		updateBot.add(deleteBtn);
		// add sub panels to main panel
		updatePanel.add(updateTop, BorderLayout.PAGE_START);
		btnClear_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUPC.setText(null);
				addLot.setText(null);
				addQty.setText(null);
			}
		});
		
		updateTop.add(btnClear_4);
		updatePanel.add(updateMid, BorderLayout.CENTER);
		btnClear_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeUPC.setText(null);
				removeLot.setText(null);
				removeQty.setText(null);
			}
		});
		
		updateMid.add(btnClear_5);
		updatePanel.add(updateBot, BorderLayout.PAGE_END);
		btnClear_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteUPC.setText(null);
			}
		});
		
		updateBot.add(btnClear_6);

		// NEW LOT TAB
		// top sub Panel
		lotTop.add(newLotName);
		lotTop.add(lotNameField);
		lotTop.add(newLotUPC);
		lotTop.add(lotUPCField);
		// mid sub panel
		lotMid.add(newLotLOT);
		lotMid.add(lotLOTField);
		lotMid.add(newLotPrice);
		lotMid.add(lotPriceField);
		lotMid.add(newLotQty);
		lotMid.add(lotQtyField);
		// bottom sub panel
		lotBot.add(newLOTBtn);
		// add sub panels to main panel
		newLotPanel.add(lotTop, BorderLayout.PAGE_START);
		newLotPanel.add(lotMid, BorderLayout.CENTER);
		newLotPanel.add(lotBot, BorderLayout.PAGE_END);
		btnClearAllFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lotNameField.setText(null);
				lotUPCField.setText(null);
				lotLOTField.setText(null);
				lotPriceField.setText(null);
				lotQtyField.setText(null);
			}
		});
		
		lotBot.add(btnClearAllFields);

		// SALE TAB
		// top sub panel
		saleTop.add(saleUPC);
		saleTop.add(saleUPCField);
		// mid sub panel
		saleMid.add(saleQty);
		saleMid.add(saleQtyField);
		// sale bot panel
		saleBot.add(saleBtn);
		// add sub panels to main panel
		salePanel.add(saleTop, BorderLayout.PAGE_START);
		btnClear_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleUPCField.setText(null);
			}
		});
		
		saleTop.add(btnClear_2);
		salePanel.add(saleMid, BorderLayout.CENTER);
		btnClear_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saleQtyField.setText(null);
			}
		});
		
		saleMid.add(btnClear_3);
		salePanel.add(saleBot, BorderLayout.PAGE_END);

		// NEW MERCH TAB
		// top sub panel
		merchTop.add(newMerchLabel);
		merchTop.add(newMerchField);
		merchMid.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		// mid sub panel
		merchMid.add(newMerchBtn);
		// add sub panels to main panel
		newMerchPanel.add(merchTop, BorderLayout.PAGE_START);
		newMerchPanel.add(merchMid, BorderLayout.CENTER);
		btnClear_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newMerchField.setText(null);
			}
		});
		
		merchMid.add(btnClear_1);

		// add tabs to tabbed pane
		pane.add("Open/Close", openClosePanel);
		pane.add("Search", searchPanel);
		pane.add("Add New Item", newMerchPanel);
		pane.add("Add new LOT", newLotPanel);
		pane.add("Update Quantity", updatePanel);
		pane.add("Sell Items", salePanel);

		// add tabbed pane to frame
		frame.getContentPane().add(pane, BorderLayout.PAGE_START);

		// create ActionListeners for buttons
		openBtn.addActionListener(this);
		closeBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		addBtn.addActionListener(this);
		removeBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		newLOTBtn.addActionListener(this);
		newMerchBtn.addActionListener(this);
		saleBtn.addActionListener(this);

		// set frame parameters
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/*************************************************************************************************************/

	// creates new inventory item
	public void createNewItem(int UPC) {
		LinkedList<Merch> newQueue = new LinkedList<Merch>();
		inventoryList.put(UPC, newQueue);
	}

	/*************************************************************************************************************/

	// add a new lot to inventory
	public void addLOT(String name, int UPC, int LOT, double price, int onHand) {
		Merch newMerch = new Merch(name, UPC, LOT, price, onHand);
		inventoryList.get(UPC).addLast(newMerch);
	}

	/**************************************************************************************************************/

	// increase on hand quantity of a specific lot
	public void addMerch(int UPC, int LOT, int qty) {
		for (int i = 0; i < inventoryList.get(UPC).size(); i++) {
			if (inventoryList.get(UPC).get(i).getLOT() == LOT)
				inventoryList.get(UPC).get(i).addQty(qty);
		}
	}

	/*************************************************************************************************************/

	// decrease on hand quantity of a specific lot
	public void removeMerch(int UPC, int LOT, int qty) {
		for (int i = 0; i < inventoryList.get(UPC).size(); i++) {
			if (inventoryList.get(UPC).get(i).getLOT() == LOT) {
				if (inventoryList.get(UPC).get(i).getOnHand() >= qty)
					inventoryList.get(UPC).get(i).removeQty(qty);
				else
					inventoryList.get(UPC).remove(i);
				return;
			}
		}
	}

	/*************************************************************************************************************/

	// removes an item from inventory
	public void deleteMerch(int UPC) {
		inventoryList.remove(UPC);
	}

	/**************************************************************************************************************/

	// sells an item
	public void sellItem(int UPC, int qty) throws IOException {
		File file = new File("C:\\Users\\keith\\Documents\\EMU\\COSC 311\\Project\\salesReport.txt");
		FileWriter fw = new FileWriter(file, true);
		fw.write(inventoryList.get(UPC).getFirst().name +" "+ UPC +" "+ qty + "\n");
		// is sale qty is greater than the on Hand qty of first lot
		while (qty > inventoryList.get(UPC).getFirst().getOnHand()) {
			qty = qty - inventoryList.get(UPC).getFirst().getOnHand();
			inventoryList.get(UPC).removeFirst();
		}
		// if sale qty == on Hand of first lot
		if (inventoryList.get(UPC).getFirst().getOnHand() == qty)
			inventoryList.get(UPC).removeFirst();
		// if sale qty is less than on hand qty of first lot
		else
			inventoryList.get(UPC).getFirst().removeQty(qty);
		fw.close();
	}

	/*************************************************************************************************************/

	// searches for an item and prints its data
	public String search(int UPC) {
		String tempName = inventoryList.get(UPC).peek().getName();
		int tempUPC = inventoryList.get(UPC).peek().getUPC();
		double tempPrice = inventoryList.get(UPC).peek().getPrice();
		int tempQty = 0;
		String lotString = "";
		for (int i = 0; i < inventoryList.get(UPC).size(); i++) {
			tempQty += inventoryList.get(UPC).get(i).getOnHand();
			lotString += inventoryList.get(UPC).get(i).getLOT() + " ";
		}
		String str = "Item: " + tempName + "\n" + "UPC: " + tempUPC + "\n" + "Price: " + tempPrice + "\n" + "Quantity "
				+ tempQty + "\n" + "Available LOTs: " + lotString;
		return str;
	}

	/************************************************************************************************************/

	// button action function
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == searchBtn) {
				searchRslt.setText("");
				searchRslt.setText(search(Integer.parseInt(searchUPC.getText())));
			} else if (e.getSource() == addBtn) {
				addMerch(Integer.parseInt(addUPC.getText()), Integer.parseInt(addLot.getText()),
						Integer.parseInt(addQty.getText()));
				JOptionPane.showMessageDialog(frame, "Quantity Updated");
			} else if (e.getSource() == removeBtn) {
				removeMerch(Integer.parseInt(removeUPC.getText()), Integer.parseInt(removeLot.getText()),
						Integer.parseInt(removeQty.getText()));
				JOptionPane.showMessageDialog(frame, "Quantity Updated");
			} else if (e.getSource() == deleteBtn) {
				deleteMerch(Integer.parseInt(deleteUPC.getText()));
				JOptionPane.showMessageDialog(frame, "Item Removed from Inventory");
			} else if (e.getSource() == newLOTBtn) {
				addLOT(lotNameField.getText(), Integer.parseInt(lotUPCField.getText()),
						Integer.parseInt(lotLOTField.getText()), Double.parseDouble(lotPriceField.getText()),
						Integer.parseInt(lotQtyField.getText()));
				JOptionPane.showMessageDialog(frame,
						lotNameField.getText() + ", LOT " + lotLOTField.getText() + " Added");
			} else if (e.getSource() == saleBtn) {
				sellItem(Integer.parseInt(saleUPCField.getText()), Integer.parseInt(saleQtyField.getText()));
				JOptionPane.showMessageDialog(frame, saleQtyField.getText() + " Units Sold");
			} else if (e.getSource() == newMerchBtn) {
				createNewItem(Integer.parseInt(newMerchField.getText()));
				JOptionPane.showMessageDialog(frame, newMerchField.getText() + " Successfully Added");
			}else if(e.getSource() == openBtn) {
				upload();
				JOptionPane.showMessageDialog(frame, "Inventory List Successfully Uploaded");
			}else if(e.getSource()==closeBtn) {
				export(inventoryList);
				JOptionPane.showMessageDialog(frame, "Inventory List Successfully Exported");
			}
		} catch (Exception e1) {
			//System.out.println("User trying an action that is not allowed.");
			JOptionPane.showMessageDialog(frame, "Error, value entered not allowed");
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
/************************************************************************************************************/

	public void upload() throws Exception{
		String name = "";
		int upc = 0;
		int lot = 0;
		double price = 0;
		int onHand = 0;
		File file = new File("Inventory.txt");
		Scanner sc = new Scanner(file);
		String str;
		str = sc.nextLine();
		int numItems = Integer.parseInt(str);
		for(int i = 1; i <= numItems; i++){
			str = sc.nextLine();
			createNewItem(Integer.parseInt(str));
		}
		while(sc.hasNextLine()){
			str = sc.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(str);
			while(tokenizer.hasMoreTokens()){
				name = tokenizer.nextToken();
				upc = Integer.parseInt(tokenizer.nextToken());
				lot = Integer.parseInt(tokenizer.nextToken());
				price = Double.parseDouble(tokenizer.nextToken());
				onHand  = Integer.parseInt(tokenizer.nextToken());
			}
			addLOT(name, upc, lot, price, onHand);
		}
		sc.close();
	}
	
/***********************************************************************************************************/
	
	public void export(HashMap<Integer, LinkedList<Merch>> map) throws IOException {
		File file = new File("C:\\Users\\leahd\\Documents\\Inventory.txt");
		FileWriter fw = new FileWriter(file, false);
		int numItems = map.size();
		fw.write(numItems+"\n");
		int[] upcList = new int[numItems];
		int i = 0;
		for(int key : map.keySet()) {
			upcList[i] = key;
			fw.write(upcList[i]+"\n");
			i++;
		}
		for(int j = 0; j < numItems; j++) {
			LinkedList<Merch> temp = map.get(upcList[j]);
			for(int k = 0; k < temp.size(); k++) {
				String str = temp.get(k).name +" "+ temp.get(k).UPC +" "+ temp.get(k).LOT +" "+ 
						temp.get(k).price +" "+ temp.get(k).onHand;
				fw.write(str+"\n");
			}
		}
		fw.close();
	}
	
	/***********************************************************************************************************/
	
	// main
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Inventory().createAndShowGUI();
			}
		});
	}
}
