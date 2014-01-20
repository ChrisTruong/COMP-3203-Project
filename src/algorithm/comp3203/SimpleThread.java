package algorithm.comp3203;

import java.io.IOException;




public class SimpleThread extends Thread {
	
	private GUI gui;
	private Sensor sens;
	private TimeLoop time;
	private int alg;
	
    public SimpleThread(GUI g, Sensor s, TimeLoop t, int a) {
    	gui = g;
    	sens = s;
    	time = t;
    	alg = a;
    }
    
    public void run() {
		while (true) {
			time.checkConnections();
			
			if((sens.getCurrAngle() + sens.getBeamWidth()) > 360){
				sens.setCurrAngle((int) (sens.getCurrAngle() + sens.getBeamWidth()));
				sens.setCurrAngle((int) (sens.getCurrAngle() - 360));
			}else
				sens.setCurrAngle((int) (sens.getCurrAngle() + sens.getBeamWidth()));
			
			sens.incNumRot();
			
			if (alg == 2){	
			 	if (sens.checkRotFinish()){
			 		gui.repaint();
					break;
				}
			}
			if (alg == 3){
			 	if (sens.checkRotFinish2()){
			 		gui.repaint();
					break;
				}
			}
			
			if(gui.sigStopped){
		 		break;
		 	}
			gui.repaint();
			try {
				sleep(100*sens.getRotSpeed());
			}
			catch (InterruptedException e) {}
		}
    }
}