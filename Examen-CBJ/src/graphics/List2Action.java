package graphics;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class List2Action implements ListSelectionListener{

	@Override
	public void valueChanged(ListSelectionEvent e) {
		switch (Window.list2.getSelectedValue().toString()) {
		case "Modelo1":{
			Window.lb[1].setText("<html><p>$10000(4)</p><br><p>$14000(6)</p><br><p>$16000(8)</p></html>");
			Window.modeloc="Modelo1";
			break;
		}
		
		case "Modelo2":{
			Window.lb[1].setText("<html><p>$20000(4)</p><br><p>$24000(6)</p><br><p>$26000(8)</p></html>");
			Window.modeloc="Modelo2";
			break;
		}
		case "Modelo3":{
			Window.lb[1].setText("<html><p>$25000(4)</p><br><p>$27000(6)</p><br><p>$29000(8)</p></html>");
			Window.modeloc="Modelo3";
			break;
		}
		case "Modelo4":{
			Window.lb[1].setText("<html><p>$40000(4)</p><br><p>$45000(6)</p><br><p>$50000(8)</p></html>");
			Window.modeloc="Modelo4";
			break;
		}
	}
		
	}

}
