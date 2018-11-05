
/**
 *  @Author:         Corey M. Moura
 *  @Date:           January 18, 2018
 *  @Professor:      Dr. Trafftz
 *  @Project:        Project 1 of CS163.  The GUI of the CountDownTimer Class
 *  @Notes:          This is a copy paste / modification of the GUI from Assignment 5 CS16
 *  start and stop timers, one button to stop all timers, display all timers
 */

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class CountDownTImerGUI extends JPanel{
    private int x, xx , y , yy , z , zz ;

    private CountDownTimer t1;      //A timer object t1 of data type CountDownTimer
    private CountDownTimer t2;      //A timer object t2 of data type CountDownTimer
    private CountDownTimer t3;      //A timer object t3 of data type CountDownTimer

    /** buttons */
    private JButton timer1;         //A variable for timer 1 start stop
    private JButton t1Reset;        //A variable for timer 1 time reset

    private JButton timer2;         //A variable for timer 2 start stop
    private JButton t2Reset;        //A variable for timer 2 time reset

    private JButton timer3;         //A variable for timer 3 start stop
    private JButton t3Reset;        //A variable for timer 3 time reset

    /** labels */
    private JLabel labeltimer1;     //A variable for showing the time as it counts down  
    private JLabel labeltimer2;     //A variable for showing the time as it counts down 
    private JLabel labeltimer3;     //A variable for showing the time as it counts down

    /** text fields */
    private JTextField timeE1;      //Used to create a text box to eneter the countdown time manually for t1
    private JTextField timeE2;      //Used to create a text box to eneter the countdown time manually for t2
    private JTextField timeE3;      //Used to create a text box to eneter the countdown time manually for t3

    /** GUI Window */
    private JFrame theGUI;      //Will be used to  create an object of JFrame

    private javax.swing.Timer timer;        //Will be used to create an object timer for interupts
    final int DELAY = 1000;                 //DELAY represents the number of milliseconds the swing timer will wait between interupts

    /**************************************************************************************************************************************/
    /*Constructor - instantiates and displays all of the GUI commponents*/
    public CountDownTImerGUI(){ 
        /**Timer Objects*/
        t1 = new CountDownTimer("0:00");    //Initially set timer 1 to display 0:00
        t2 = new CountDownTimer("0:00");    //Initially set timer 2 to display 0:00
        t3 = new CountDownTimer("0:00");    //Initially set timer 3 to display 0:00

        /**JFrame Initialization*/
        theGUI = new JFrame("Count Down Timer");        //theGUI object will access JFrame methods
        theGUI.setVisible(true);                        //If false or, not present, the window will not appear
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Default exit procedures vs a menu exit button
        theGUI.setLayout(new GridBagLayout());                  //Sets the structure of the GUI to follow gridBagLayout format
        GridBagConstraints layoutConst;                 //Variable layoutConst is of data type GridBagConstraints
        layoutConst = constraints(10,10,10,10);         //assigns the size of the GridBagConstraints

        //--------------------Text Fields-------------------------
        /**Text Boxes Where Times Are Entered*/
        timeE1 = new JTextField(5);                 //New text box
        layoutConst = constraintsText(0,3,1,1);     //Location of textbox
        theGUI.add(timeE1, layoutConst);            //Adds text box to the layout

        timeE2 = new JTextField(5);                 //New text box
        layoutConst = constraintsText(1,3,1,1);     //Location of textbox
        theGUI.add(timeE2, layoutConst);            //Adds text box to the layout

        timeE3 = new JTextField(5);                 //New text box
        layoutConst = constraintsText(2,3,1,1);     //Location of textbox
        theGUI.add(timeE3, layoutConst);            //Adds text box to the layout

        /**Future Refrence for Scroll Pane Addition*/
        //JScrollPane scrollPane = new JScrollPane(results);
        //theGUI.add(scrollPane, layoutConst);

        //--------------------Action Buttons-------------------------
        timer1 = new JButton("Timer 1");        //Creates start/stop button for timer 1
        layoutConst = constraints(0,0,1,1);     //Location of button
        theGUI.add(timer1, layoutConst);        //Adds button to the JFrame

        t1Reset = new JButton("Reset");             //Creates reset button for timer 1
        layoutConst = constraintsResets(0,4,1,1);   //Location of button
        theGUI.add(t1Reset, layoutConst);           //Adds button to the JFrame

        timer2 = new JButton("Timer 2");        //Creates start/stop button for timer 2
        layoutConst = constraints(1,0,1,1);     //Location of button
        theGUI.add(timer2, layoutConst);        //Adds button to the JFrame

        t2Reset = new JButton("Reset");             //Creates start/stop button for timer 2
        layoutConst = constraintsResets(1,4,1,1);   //Location of button
        theGUI.add(t2Reset, layoutConst);           //Adds button to the JFrame

        timer3 = new JButton("Timer 3");        //Creates start/stop button for timer 3
        layoutConst = constraints(2,0,1,1);     //Location of button
        theGUI.add(timer3, layoutConst);        //Adds button to the JFrame

        t3Reset = new JButton("Reset");             //Creates start/stop button for timer 3
        layoutConst = constraintsResets(2,4,1,1);   //Location of button
        theGUI.add(t3Reset, layoutConst);           //Adds button to the JFrame

        //----------------------Labels-----------------------
        labeltimer1 = new JLabel(t1.toString());        //Creates a Label Assigned the toString methods output for timer 1
        layoutConst = constraintsLabels(0,1,2,1);       //Location of Label
        theGUI.add(labeltimer1, layoutConst);           //Adds label to the JFrame

        labeltimer2 = new JLabel(t2.toString());        //Creates a Label Assigned the toString methods output for timer 2
        layoutConst = constraintsLabels(1,1,1,1);       //Location of Label
        theGUI.add(labeltimer2, layoutConst);           //Adds label to the JFrame

        labeltimer3 = new JLabel(t3.toString());        //Creates a Label Assigned the toString methods output for timer 3
        layoutConst = constraintsLabels(2,1,1,1);       //Location of Label
        theGUI.add(labeltimer3, layoutConst);           //Adds label to the JFrame

        //----------------------Action Listeners-----------------------

        ButtonListener listener = new ButtonListener();             //instantiate an ActionListener object
        timer1.addActionListener(listener);             //Add an action listener
        t1Reset.addActionListener(listener);            //Add an action listener

        timer2.addActionListener(listener);             //Add an action listener
        t2Reset.addActionListener(listener);            //Add an action listener

        timer3.addActionListener(listener);             //Add an action listener
        t3Reset.addActionListener(listener);            //Add an action listener

        /**Timer Initialization*/
        timer = new javax.swing.Timer(DELAY, new TimerListener());      //Passes DELAY, and TimerListener 
        timer.start();      //Starts the Java Swing internal timer with the above peramiters
    }
    /**************************************************************************************************************************************/

    /*Assigns the Timer Buttons which called the function a location in the JFrame via grid points*/
    private GridBagConstraints constraints(int x, int y, int h, int w){
        GridBagConstraints rtn=new GridBagConstraints();
        rtn.gridx=x;
        rtn.gridy=y;
        rtn.gridheight=h;
        rtn.gridwidth=w;
        rtn.insets=new Insets(5,5,5,5);
        rtn.anchor=GridBagConstraints.LINE_START;
        return rtn;
    }
    /**************************************************************************************************************************************/

    /*Assigns the Labels which called the function a location in the JFrame via grid points*/
    private GridBagConstraints constraintsLabels(int x, int y, int h, int w){
        GridBagConstraints rtn=new GridBagConstraints();
        rtn.gridx=x;
        rtn.gridy=y;
        rtn.gridheight=h;
        rtn.gridwidth=w;
        rtn.insets=new Insets(5,28,5,5);
        rtn.anchor=GridBagConstraints.LINE_START;
        return rtn;
    }
    /**************************************************************************************************************************************/

    /*Assigns the Text fields which called the function a location in the JFrame via grid points*/
    private GridBagConstraints constraintsText(int x, int y, int h, int w){
        GridBagConstraints rtn=new GridBagConstraints();
        rtn.gridx=x;
        rtn.gridy=y;
        rtn.gridheight=h;
        rtn.gridwidth=w;
        rtn.insets=new Insets(5,19,5,5);
        rtn.anchor=GridBagConstraints.LINE_START;
        return rtn;
    }
    /**************************************************************************************************************************************/
    
    /*Assigns the Reset Buttons which called the function a location in the JFrame via grid points*/  
    private GridBagConstraints constraintsResets(int x, int y, int h, int w){
        GridBagConstraints rtn=new GridBagConstraints();
        rtn.gridx=x;
        rtn.gridy=y;
        rtn.gridheight=h;
        rtn.gridwidth=w;
        rtn.insets=new Insets(5,13,5,5);
        rtn.anchor=GridBagConstraints.LINE_START;
        return rtn;
    }
    /**************************************************************************************************************************************/

    /*Main function is necisarry to run the GUI*/
    public static void main(String arg[]){
        CountDownTImerGUI g = new CountDownTImerGUI();
    }

    /**************************************************************************************************************************************/
    /*Respond to menu selections and button clicks
    @param e the button or menu item that was selected*/
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            /*Check to see if the button was pressed.*/
            if(e.getSource() == timer1){            
                /*Uses variable x to track the states of the timer between set/start/stop.  Global variable xx is tracked in the inturupt
                 * handler "private class TimerListener implements ActionListener" below and will preform duties as determined by state.
                 */
                switch (x){                    
                    case 0:
                    t1.timerSet(timeE1.getText());//Reads the text from the text field specified as timeE1 and sets timer via peramiter
                    xx = 0;
                    break;

                    case 1:
                    xx = 1;
                    break;

                    case 2:
                    x = 0;
                    xx = 0;
                    break;   
                }
                x++;
            }
            /*Check to see if the button was pressed.*/
            if(e.getSource() == t1Reset){            
                t1.timerSet(timeE1.getText());//Reads the text from the text field specified as timeE1 and sets timer via peramiter
                xx = 1;  
            } 
            /*Check to see if the button was pressed.*/
            if(e.getSource() == timer2){            
                /*Uses variable y to track the states of the timer between set/start/stop.  Global variable yy is tracked in the inturupt
                 * handler "private class TimerListener implements ActionListener" below and will preform duties as determined by state.
                 */
                switch (y){                    
                    case 0:
                    t2.timerSet(timeE2.getText());//Reads the text from the text field specified as timeE1 and sets timer via peramiter
                    yy = 0;
                    break;

                    case 1:
                    yy = 1;
                    break;

                    case 2:
                    y = 0;
                    yy = 0;
                    break;   
                }
                y++;
            }
            /*Check to see if the button was pressed.*/
            if(e.getSource() == t2Reset){            
                t2.timerSet(timeE2.getText());//Reads the text from the text field specified as timeE1 and sets timer via peramiter
                yy = 1;  
            } 
            /*Check to see if the button was pressed.*/
            if(e.getSource() == timer3){            
                /*Uses variable z to track the states of the timer between set/start/stop.  Global variable zz is tracked in the inturupt
                 * handler "private class TimerListener implements ActionListener" below and will preform duties as determined by state.
                 */
                switch (z){                    
                    case 0:
                    t3.timerSet(timeE3.getText());//Reads the text from the text field specified as timeE1 and sets timer via peramiter
                    zz = 0;
                    break;

                    case 1:
                    zz = 1;
                    break;

                    case 2:
                    z = 0;
                    zz = 0;
                    break;   
                }
                z++;
            }
            /*Check to see if the button was pressed.*/
            if(e.getSource() == t3Reset){            
                t3.timerSet(timeE3.getText());//Reads the text from the text field specified as timeE1 and sets timer via peramiter
                zz = 1;  
            } 

        }
    }
    private class TimerListener implements ActionListener {
        /**Updates the time
         * @param event a timer interrupt*/
        public void actionPerformed(ActionEvent event) { 
            if(xx == 0){
                labeltimer1.setText(t1.toString()); //Displays the output of the "toString" method.  
            }
            if(xx == 1){
                t1.dec();
                labeltimer1.setText(t1.toString()); //Displays the output of the "toString" method. 
            }

            if(yy == 0){
                labeltimer2.setText(t2.toString()); //Displays the output of the "toString" method. 
            }
            if(yy == 1){
                t2.dec();
                labeltimer2.setText(t2.toString()); //Displays the output of the "toString" method. 
            }

            if(zz == 0){
                labeltimer2.setText(t2.toString()); //Displays the output of the "toString" method. 
            }
            if(zz == 1){
                t3.dec();
                labeltimer3.setText(t3.toString()); //Displays the output of the "toString" method. 
            }

        }
    }
}

