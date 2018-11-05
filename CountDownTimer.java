
/**
 *  @Author:         Corey M. Moura
 *  @Date:           January 18, 2018
 *  @Professor:      Dr. Trafftz
 *  @Project:        Project 1 of CS163.  Designed to manipulate a timer through the interaction with the GUI.
 *                   Timer counts down from given value
 *  
 *  @Notes:          Some methods are not used to operate the timer.  They are methods designed to refamilularize 
 *                   the student with object oriented programming.
 */

import java.util.Scanner;       //Scanner functions required in program
import java.lang.Math;          //Math functions used to manipulate the timer

public class CountDownTimer
{
    // instance variables 
    private int hours, minutes, seconds;   //Variable which keep track of this time     

    /*Default constructor that sets the CountDownTimer to zero.*/
    public CountDownTimer(){
        hours = 0;                  //Set hours to zero
        minutes = 0;                //Set minutes to zero
        seconds = 0;                //Set seconds to zero
    }

    /**************************************************************************************************************************************/
    /* A constructor that initializes the instance variables with the provided values.*/
    public CountDownTimer(int nhours, int nminutes, int nseconds){
        hours = nhours;             //Passed peramiter nhours is assigned to hours
        minutes = nminutes;         //Passed peramiter nminutes is assigned to minutes
        seconds = nseconds;         //Passed peramiter nseconds is assigned to seconds
    }

    /**************************************************************************************************************************************/
    /*A constructor that initializes the instance variables with the provided values. Initialize hours to 0.**/
    public CountDownTimer(int nminutes, int nseconds){
        hours = 0;                  //hours is assigned zero
        minutes = nminutes;         //Passed peramiter nminutes is assigned to minutes
        seconds = nseconds;         //Passed peramiter nseconds is assigned to seconds
    }

    /**************************************************************************************************************************************/
    /*A constructor that initializes the instance variables with the provided values. Initialize hours and minutes to 0.*/
    public CountDownTimer(int nseconds){ 
        hours = 0;              //Variable hours is assigned zero
        minutes = 0;            //Variable minutes is assigned zero
        seconds = nseconds;     ///Passed peramiter nseconds is assigned to seconds
    }

    /**************************************************************************************************************************************/
    /*A constructor that initializes the instance variables with the other CountDownTimer parameter.*/
    public CountDownTimer (CountDownTimer other) {
        hours = other.hours;        //Access another timer object to pass hours
        minutes = other.minutes;    //Access another timer object to pass minutes
        seconds = other.seconds;    //Access another timer object to pass seconds
    }  

    /**************************************************************************************************************************************/
    /* A constructor that accepts a String as a parameter with the following format: “1:21:30” where 1 indicates hours, 
    21 indicates minutes, and 30 indicates seconds. OR the format “15:20” where the 15 indicates minutes, and 20 indicates 
    seconds, OR the format “30” where 30 indicates seconds. If a value is not specified, i.e., "", then it is set to zero. 
    You can assume the input has no errors (i.e., a valid set of numbers) contained within.                               */
    public CountDownTimer(String nstartTime){
        if (nstartTime.length() == 0) {
            hours = 0;      //Set start hours to zero
            minutes = 0;    //Set start minutes to zero
            seconds = 0;    //Set start seconds to zero
            return;
        }
        String delims = ":";                        //Identify the character used to split the string
        String[] part = nstartTime.split(delims);   //split the string nstartTime and pass elements into the string part

        //If the string contains hours, minutes, and seconds
        if (part.length == 3) {
            hours = Integer.parseInt(part[0]);      //Assign hours the value of the 1 element in the string
            minutes = Integer.parseInt(part[1]);    //Assign minutes the value of the 2nd element in the string
            seconds = Integer.parseInt(part[2]);    //Assigne seconds the value of the 3rd element in the string
        }
        //if the string contains only minutes and seconds
        if (part.length == 2) {
            minutes = Integer.parseInt(part[0]);    //Assign minutes the value of the 1 element in the string
            seconds = Integer.parseInt(part[1]);    //Assigne seconds the value of the 2nd element in the string
        }
        //If the string contains only seconds
        if (part.length == 1) {
            seconds = Integer.parseInt(part[0]);    //Assigne seconds the value of the 1 element in the string
        }
        
    }
    /**************************************************************************************************************************************/
    
    public void timerSet(String nstartTime){
        if (nstartTime.length() == 0) {
            hours = 0;      //Set start hours to zero
            minutes = 0;    //Set start minutes to zero
            seconds = 0;    //Set start seconds to zero
            return;
        }
        String delims = ":";                        //Identify the character used to split the string
        String[] part = nstartTime.split(delims);   //split the string nstartTime and pass elements into the string part

        //If the string contains hours, minutes, and seconds
        if (part.length == 3) {
            hours = Integer.parseInt(part[0]);      //Assign hours the value of the 1 element in the string
            minutes = Integer.parseInt(part[1]);    //Assign minutes the value of the 2nd element in the string
            seconds = Integer.parseInt(part[2]);    //Assigne seconds the value of the 3rd element in the string
        }
        //if the string contains only minutes and seconds
        if (part.length == 2) {
            minutes = Integer.parseInt(part[0]);    //Assign minutes the value of the 1 element in the string
            seconds = Integer.parseInt(part[1]);    //Assigne seconds the value of the 2nd element in the string
        }
        //If the string contains only seconds
        if (part.length == 1) {
            seconds = Integer.parseInt(part[0]);    //Assigne seconds the value of the 1 element in the string
        }
    }
    
    
    

    /**************************************************************************************************************************************/
    /*A method that returns true if “this” CountDownTimer object is exactly the same (mins = other.mins && secs = other.secs && ...) 
    as the other object (Note: you must cast the other object as a CountDownTimer object).                                         */

    public boolean equals(Object o) {
        CountDownTimer other = (CountDownTimer)o;       //Assigns all atributes to other
        if(minutes == other.minutes && seconds == other.seconds && hours == other.hours){           //Compare instance variables
            return true;            //If all variables are equal, the method returns true
        }
        else
            return false;           //If just one variable is not equal it returns false
    }

    /**************************************************************************************************************************************/
    /*A static method that returns true if CountDownTimer object t1 is exactly the same as CountDownTimer object t2 
    (i.e. mins = other.mins && secs = other.secs && ...).                       */
    public static boolean equals(CountDownTimer t1, CountDownTimer t2){
        if(t1.minutes == t2.minutes && t1.seconds == t2.seconds && t1.hours == t2.hours){           //Compare instance variables
            return true;        //If all variables are equal, the method returns true    
        }
        else
            return false;       //If just one variable is not equal it returns false
    }

    /**************************************************************************************************************************************/
    /*A method that returns 1 if “this” CountDownTimer object is greater than the other CountDownTimer object; returns -1 if the  
     * “this” CountDownTimer object is less than the other CountDownTimer; returns 0 if the “this” CountDownTimer object is equal 
     * to the other CountDownTimer object. */
    public int compareTo(CountDownTimer other){
        int thisSeconds = (hours * 3600) + (minutes * 60) + seconds;                            //Converts "this" time into units of seconds
        int otherSeconds = (other.hours * 3600) + (other.minutes * 60) + other.seconds;         //Converts "other" time to units of seconds     

        return thisSeconds - otherSeconds;          //The math will produce either a negative, positive or zero result
    }

    /**************************************************************************************************************************************/
    /*A method that returns 1 if CountDownTimer object t1 is greater than CountDownTimer object t2; returns -1 if the CountDownTimer
    object t1 is less than CountDownTimer t2; returns 0 if the CountDownTimer object t1 is equal to CountDownTimer object t2.**/
    public static int compareTo(CountDownTimer t1, CountDownTimer t2) {
        int t1Seconds = (t1.hours * 3600) + (t1.minutes * 60) + t1.seconds;     //Converts "t1" time into units of seconds
        int t2Seconds = (t2.hours * 3600) + (t2.minutes * 60) + t2.seconds;     //Converts "t2" time into units of seconds

        return t1Seconds - t2Seconds;               //The math will produce either a negative, positive or zero result         
    }

    /**************************************************************************************************************************************/
    /*A method that subtracts the number of seconds from “this” CountDownTimer object. You may assume the parameter “seconds” is positive.*/
    public void sub(int nSeconds){
        int thisSeconds = (hours * 3600) + (minutes * 60) + seconds;            //Converts "this" time into units of seconds
        int result = thisSeconds - nSeconds;            //Produces the remaining amount of time
        hours = result / 3600;                          //Turns seconds back into hours to display
        int rest = result % 3600;                       //Gets the remainder of the hours into rest (number of minutes)
        minutes = rest / 60;                            //Turns the remainder of seconds into minutes   
        seconds = rest % 60;                            //What ever is left are the seconds
    }

    /**************************************************************************************************************************************/
    /*A method that subtracts CountDownTimer other from the “this” CountDownTimer object.*/
    public void sub (CountDownTimer other) {
        int thisSeconds = (hours * 3600) + (minutes * 60) + seconds;                        //Converts "this" time into units of seconds
        int otherSeconds = (other.hours * 3600) + (other.minutes * 60) + other.seconds;     //Converts "other" time into units of seconds
        int result = thisSeconds - otherSeconds;        //Produces the remaining amount of time
        hours = result / 3600;                          //Turns seconds back into hours to display
        int rest = result % 3600;                       //Gets the remainder of the hours into rest (number of minutes)
        minutes = rest / 60;                            //Turns the remainder of seconds into minutes 
        seconds = rest % 60;                            //What ever is left are the seconds
    }

    /**************************************************************************************************************************************/
    /*A method that decrements the “this” CountDownTimer by 1 second.*/
    public void dec() {
        sub(1);             //A math library function which will decrement automatically by one when the method is called
    }

    /**************************************************************************************************************************************/
    /*A method that adds the number of seconds to “this” CountDownTimer object. You may assume the parameter “seconds” is positive.*/
    public void add(int seconds){
        int thisSeconds = (hours * 3600) + (minutes * 60) + seconds;        //Converts "this" time into units of seconds
        int result = seconds + thisSeconds;             //Produces the remaining amount of time
        hours = result / 3600;                          //Turns seconds back into hours to display
        int rest = result % 3600;                       //Gets the remainder of the hours into rest (number of minutes)
        minutes = rest / 60;                            //Turns the remainder of seconds into minutes 
        seconds = rest % 60;                            //What ever is left are the seconds
    }

    /**************************************************************************************************************************************/
    /*A method that adds CountDownTimer other to the “this” CountDownTimer object. Convert the “other” CounterDownTimer object to seconds 
    and call the add (int seconds) method. You may assume the parameter “seconds” is positive.*/
    public void add (CountDownTimer other) {
        int otherSeconds = (other.hours * 3600) + (other.minutes * 60) + other.seconds;     //Converts "other" time into units of seconds
        add(otherSeconds);     //Adds otherseconds
    }

    /**************************************************************************************************************************************/
    /*A method that increments the “this” CountDownTimer by 1 second.*/
    public void inc() {
        add(1);         //A math library function which will increment automatically by one when the method is called
    }

    /**************************************************************************************************************************************/
    /*Below Getters are redundant, used for debugging. */
    public int getHours(){
        return hours;   //Simple getter method used for debugging
    }

    /**************************************************************************************************************************************/
    public int getMinutes(){
        return minutes;    //Simple getter method used for debugging
    }

    /**************************************************************************************************************************************/
    public int getSeconds(){
        return seconds;    //Simple getter method used for debugging
    }

    /**************************************************************************************************************************************/
    /*A method that returns a string that represents the state of a CountDownTimer with the following format: “1:06:01”. Display the hours 
    as is; minutes with 2 digits including a leading “0” if minutes < 10, and seconds with 2 digits again including a leading “0” if 
    seconds < 10. Other examples: “21:32:00”, “0:00:00”.*/
    public String toString() {
        String result = hours+":";
        if (minutes < 10) {
            result = result +"0"+minutes;
        }
        else {
            result = result + minutes;
        }
        result = result+":";
        if (seconds < 10) {
            result = result +"0"+seconds;
        }
        else {
            result = result + seconds;
        }
        return result;
    }

    
    /**************************************************************************************************************************************/
    /**************************************************************************************************************************************/

    /*A method that saves the “this” CountDownTimer to a file; use the parameter filename for the name of the file.*/
    public void save(String fileName) {
        CountDownTimer out = null;
        try {
            out = new CountDownTimer(new CountDownTimer(new CountDownTimer(fileName)));
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
        System.out.println(42);
        System.out.println(163);
        System.out.close();
    }

    /**************************************************************************************************************************************/
    /*A method that loads the “this” CountDownTimer object from a file; use the parameter filename for the name of the file.*/
    // public void load(String fileName) {
        // int someInt;
        // try{
            // // open the data file
            // /Scanner fileReader = new Scanner(new file(fileName));
            // Scanner lineReader;
            // // read one int
            // someInt = fileReader.nextInt();
            // System.out.println (someInt);
            // someInt = fileReader.nextInt();
            // System.out.println (someInt);
        // }
        // // problem reading the file
        // catch(Exception error){
            // throw new IllegalArgumentException();
        // } 
    // }

    /*A method that turns ‘off’ and ‘on’ any add method in CountDownTimer. In other words, when the flag is true then it prevents any add 
    method from changing (mutate) the state of the “this” object as it relates to hours, minutes, and seconds. If flag is false, then 
    mutation is allowed*/
    public static void Suspend(Boolean flag){
        

    }
    
    /**************************************************************************************************************************************/
    public static void main(String[] args) {
        CountDownTimer s = new CountDownTimer("2:59:8"); 
        System.out.println("Time: " + s);

        s = new CountDownTimer("20:8"); 
        System.out.println("Time: " + s);

        s = new CountDownTimer("8"); 
        System.out.println("Time: " + s);

        CountDownTimer s1 = new CountDownTimer(25, 2, 20); 
        System.out.println("Time: " + s1);

        s1 = new CountDownTimer(2, 20); 
        System.out.println("Time: " + s1);

        s1.sub(1000); 
        System.out.println("Time: " + s1);

        s1.add(1000); 
        System.out.println("Time: " + s1);

        
    }
}
