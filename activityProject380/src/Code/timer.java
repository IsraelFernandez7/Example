
package Code;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;
public class timer {

	private String timeString;
	public int time = 0; 
	public Timer timer;
	
	

		public void start1(final JLabel label) {
			timer = new Timer();
	        timer.scheduleAtFixedRate(new TimerTask() {
	            @Override
	            public void run() {
	                action(label);
	            }
	        }, 0, 1000);
	    }

	    public void stop1() {														//function to stop the timer
	    	//stop timer
	        timer.cancel();
	    }

	    public void reset1(JLabel label) {
	    	//stop timer
	    	timer.cancel();
	        time = 0;
	        //clear time	        
	        label.setText("00 : 00 : 00");//label for the time 
	        start1(label);
	    }

	    public void action(JLabel label) {														//function to start the timer
	        //increment by 1
	    	time = time + 1;
	    	//calling timer conversion
	        int[] timing = timeConversion(time);
	        //setting up the string for the timer
	        timeString = makeTimeString(timing[0], timing[1], timing[2]);											//label for the time
	        label.setText(timeString);
	    }

	    public int[] timeConversion(int seconds) {									//function to convet seconds to minutes then minutes to hours
	        //three elements
	    	int[] result = new int[3];
	    	//seconds
	        result[0] = seconds / 3600;
	        //minutes
	        result[1] = (seconds % 3600) / 60;
	        //hours
	        result[2] = (seconds % 3600) % 60;
	        return result;
	    }


	    public String makeTimeString(int hours, int minutes, int seconds) {
	        // Creating the timeString
	        //hours
	    	timeString = "";
	        timeString += String.format("%02d", hours);
	        timeString += " : ";
	        //minutes
	        timeString += String.format("%02d", minutes);
	        timeString += " : ";
	        //seconds
	        timeString += String.format("%02d", seconds);
	        return timeString;
	    }
	 
	    public String getTimeString() {
	    	return timeString;
	}
}
