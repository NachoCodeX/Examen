package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Window extends JFrame implements ActionListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel []panel;
	private JMenu menu;
	private JMenuBar mbar;
	private JMenuItem []it;
	
	
	public static JLabel []lb;
	
	private JToggleButton []tb;
	
	public static JList<String> list,list2;
	private JSpinner spiner;
	
	private ButtonGroup []group;
	private JRadioButton []rb;
	
	private JComboBox<String> combo;
	
	private JCheckBox ch;
	
	private JButton btn;
	
	public static String modelo="",modeloc=""; 
	
	private Double total=0.0;
	
	public Window() {
		setWindow();
		init();
		addComponents();
	}
	
	private void setWindow(){
		this.setTitle("Jesus Ignacio Castillo Barrios");
		this.setResizable(false);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	private void init(){
		panel=new JPanel[3];
		panel[0]=new JPanel(null);
		panel[0].setBounds(0, 0, 800, 600);
		
		//MENU
		it=new JMenuItem[2];
		it[0]=new JMenuItem("Venta");
		menu=new JMenu();
		menu.add(it[0]);
		
		mbar=new JMenuBar();
		mbar.add(menu);
		
		
		mbar.add(it[0]);
		mbar.add(it[1]);
		
		mbar.setBounds(0, 0, 800, 20);
		
		
		//Labels
		lb=new JLabel[3];
		lb[0]=new JLabel("");
		lb[0].setBorder(new TitledBorder("Precios"));
		lb[0].setBounds(150, 60, 100, 100);
		lb[0].setFont(new Font("Arial",Font.PLAIN,10));
		
		lb[1]=new JLabel("");
		lb[1].setBorder(new TitledBorder("Precios"));
		lb[1].setBounds(450, 60, 100, 100);
		lb[1].setFont(new Font("Arial",Font.PLAIN,10));
		
		lb[2]=new JLabel();
		lb[2].setBorder(new TitledBorder(""));
		lb[2].setBounds(150, 340, 300, 50);
		//Toggle
		tb=new JToggleButton[2];
		tb[0]=new JToggleButton("Salas");
		tb[0].setBounds(20, 20, 100, 20);
		tb[0].addActionListener(this);
		tb[0].setActionCommand("tb[0]");
		
		
		tb[1]=new JToggleButton("Comedor");
		tb[1].setBounds(300, 20, 100, 20);
		tb[1].setActionCommand("tb[1]");
		tb[1].addActionListener(this);
		
		
		//Lista
		String []da={"Modelo1","Modelo2","Modelo3","Modelo4"};
		list=new JList<String>();
		list.setListData(da);
		list.setBounds(20, 60, 100, 70);
		list.addListSelectionListener(new ListAction());
		list.setEnabled(false);
		String []da1={"Modelo1","Modelo2","Modelo3","Modelo4"};
		list2=new JList<String>();
		list2.setListData(da1);
		list2.setBounds(300, 60, 100, 70);
		list2.addListSelectionListener(new List2Action());
		list2.setEnabled(false);
		
		//Spinner
		spiner=new JSpinner();
		spiner.setBounds(550, 60, 150, 30);
		
		//Radios
		group=new ButtonGroup[2];
		group[0]=new ButtonGroup();
		group[1]=new ButtonGroup();
		rb=new JRadioButton[6];
		String []n={"Blanco","Beige","Azul","4 sillas","6 sillas","8 sillas"};
		for (int i = 0; i < rb.length; i++) {
			rb[i]=new JRadioButton(n[i]);
			
		}  
		
		group[0].add(rb[0]);
		rb[0].setBounds(20,150,100,20);
		
		group[0].add(rb[1]);
		rb[1].setBounds(20,170,100,20);
		
		group[0].add(rb[2]);
		rb[2].setBounds(20,190,100,20);
		
		group[1].add(rb[3]);
		rb[3].setBounds(290,150,100,20);
		
		group[1].add(rb[4]);
		rb[4].setBounds(290,170,100,20);
		
		group[1].add(rb[5]);
		rb[5].setBounds(290,190,100,20);
		
		
		//combo
		combo=new JComboBox<String>();
		combo.setBorder(new TitledBorder("Forma de pago"));
		combo.addItem("Contado");
		combo.addItem("12 Meses");
		combo.addItem("18 Meses");
		combo.setBounds(500, 160, 150, 50);
		
		//check
		ch=new JCheckBox("Entrega a domicilio");
		ch.setBounds(20, 250, 200, 25);
		
		//Button
		btn=new JButton("Calcular");
		btn.setBounds(20, 350, 100, 30);
		
		btn.addActionListener(this);
		btn.setActionCommand("btn");
	}
	
	private void addComponents(){
		this.add(panel[0]);
		panel[0].add(mbar);
		panel[0].add(tb[0]);
		panel[0].add(tb[1]);
		panel[0].add(list);
		panel[0].add(list2);
		panel[0].add(lb[0]);
		panel[0].add(lb[1]);
		panel[0].add(spiner);
		
		for (int i = 0; i <6; i++) {
			panel[0].add(rb[i]);
		}
		
		panel[0].add(combo);
		panel[0].add(ch);
		
		panel[0].add(btn);
		panel[0].add(lb[2]);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		total=0.0;
		
		if(e.getActionCommand().equals("tb[0]")){
			if(list.isEnabled()){
				list.setEnabled(false);
			}else{
				list.setEnabled(true);
				
				
				
			}
		}
		
		if(e.getActionCommand().equals("tb[1]")){
			if(list2.isEnabled()){
				list2.setEnabled(false);
			}else{
				list2.setEnabled(true);
			}
		}
		
		if(e.getActionCommand().equals("btn")){
			
			getModelo();
			
			
			lb[2].setText("$ "+total);
		}
		
		
	}
	
	
	private void getModelo(){
		if(tb[0].isSelected()){
			switch (modelo) {
				case "Modelo1":{
					if(rb[0].isSelected()){
						total+=10000;
					}else if(rb[1].isSelected()){
						total+=14000;
					}else if(rb[2].isSelected()){
						total+=16000;
					}
					
					break;
				}
				
				case "Modelo2":{
					if(rb[0].isSelected()){
						total+=20000;
					}else if(rb[1].isSelected()){
						total+=24000;
					}else if(rb[2].isSelected()){
						total+=26000;
					}
					
					break;
				}
				
				case "Modelo3":{
					if(rb[0].isSelected()){
						total+=25000;
					}else if(rb[1].isSelected()){
						total+=27000;
					}else if(rb[2].isSelected()){
						total+=29000;
					}
					
					break;
				}
				
				case "Modelo4":{
					if(rb[0].isSelected()){
						total+=40000;
					}else if(rb[1].isSelected()){
						total+=45000;
					}else if(rb[2].isSelected()){
						total+=50000;
					}
					
					break;
				}
			}
		
		}
		
		if(tb[1].isSelected()){

			switch (modeloc) {
			case "Modelo1":{
				if(rb[3].isSelected()){
					total+=10000;
				}else if(rb[4].isSelected()){
					total+=14000;
				}else if(rb[5].isSelected()){
					total+=16000;
				}
				
				break;
			}
			
			case "Modelo2":{
				if(rb[3].isSelected()){
					total+=20000;
				}else if(rb[4].isSelected()){
					total+=24000;
				}else if(rb[5].isSelected()){
					total+=26000;
				}
				
				break;
			}
			
			case "Modelo3":{
				if(rb[3].isSelected()){
					total+=25000;
				}else if(rb[4].isSelected()){
					total+=27000;
				}else if(rb[5].isSelected()){
					total+=29000;
				}
				
				break;
			}
			
			case "Modelo4":{
				if(rb[3].isSelected()){
					total+=40000;
				}else if(rb[4].isSelected()){
					total+=45000;
				}else if(rb[5].isSelected()){
					total+=50000;
				}
				
				break;
			}
		}
		}
		
	}
	
	


}
