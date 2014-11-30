package proj2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.Timer;

public class GameOfLifeControl {
	int delay = 100;
	public Timer timer = new Timer(delay, new startListener());

	private GameOfLifeModel myModel;
	private GameOfLifeView myView;
	
	//Constructor
	public GameOfLifeControl(GameOfLifeModel model, GameOfLifeView view){
		myModel = model;
		myView = view;
		
		view.addNextListener(new nextListener());
		view.addStartListener(new startListener());
		view.addStopListener(new stopListener());
		view.addShapesListener(new shapesListener());
	}
	
	class nextListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			myModel.startGame();	
			myView.setAge(myModel.age + " ");

		}
	}
	
	class startListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			timer.start();
			if(myModel.myList.isEmpty() == true){
				timer.stop();
			}
			else{
				myModel.startGame();
				myView.setAge(myModel.age + " ");
			}
		}
	}
	
	class stopListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			timer.stop();
		}
	}
	
	
	class shapesListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			JComboBox<String> myShapes = (JComboBox)e.getSource();
	        String shapeName = (String)myShapes.getSelectedItem();
	        myModel.setShape(shapeName);
		}
	}
	
	
}
