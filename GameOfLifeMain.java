package proj2;

import javax.swing.SwingUtilities;

public class GameOfLifeMain {
	public static void main(String[] args){	

		SwingUtilities.invokeLater(new Runnable(){
			GameOfLifeModel model = new GameOfLifeModel();
			GameOfLifeView view = new GameOfLifeView(model);
			GameOfLifeControl controller = new GameOfLifeControl(model, view);
			public void run() {
				createAndShowGUI( view );
				}
			});
		}//end main

		
		private static void createAndShowGUI( GameOfLifeView view) {
			view.setVisible(true);			
			view.pack();
			}
		}//end class
		    