// All done by Zain 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 

//some of the code is just a copy of the same code over so I wrote comments the first time they apper as to make the comment proccess less uneeded repitition  

public class Main {
 
   
    
   // holds 1 and zero value to tell if something needs to be pulled 
   public static int zO[];
   //holds extra values that are needed for decryption when num is wrapped around
   public static int val[];


   public static void main (String [] args)
   {
   String code,code2;
  
 
 // frame name and size
 JFrame frame = new JFrame("Enc and Dec by ZZ:");
   frame.setSize(500,250);
   frame.setLayout(null);
   

   // Encrypt and Decrypt buttons
   JTextField txtIn = new JTextField("",300);
   JButton btnEncrypt = new JButton("Click to Encrypt");
   JButton btnDecrypt = new JButton("Click to Decrypt");
   JTextField txtOut = new JTextField("",100);
   

   //sets size of input boxes and buttons 
   txtIn.setBounds(20,20,200,25);
   btnEncrypt.setBounds(50,120,150,25);
   btnDecrypt.setBounds(50,170,150,25);
   txtOut.setBounds(20,50,200,50);
 
   // adds the frames 
   frame.add(txtIn);
   frame.add(btnEncrypt);
   frame.add(btnDecrypt);
   frame.add(txtOut);
   

   // takes input are directs to encryption then displays 
   btnEncrypt.addActionListener(
     new ActionListener(){
     public void actionPerformed (ActionEvent e){
       String code = txtIn.getText();
       //Call your encryption method
       txtOut.setText(isAMath(code) );
     }
 
   } );
   // takes input are directs to decryption then displays 
   btnDecrypt.addActionListener(
     new ActionListener(){
     public void actionPerformed (ActionEvent e){
       String code2 = txtIn.getText();
       //Call your decryption method
       txtOut.setText(isAMath2(code2));
     }
 
   } );
   
   // makes everything visable
   frame.setVisible(true);
 }

  // Encryption method  
  public static String isAMath(String code){
  
     // variables 
     int bobRoss = 0, rossBob = 0;
     String conv = "";
     int ascii[];
     int lenWord;
     int countN = 0;
     int half = 0;
     int quarter = 0;
     int countB = 0;
     int tester = 0;
     int countL = 0;
     int key1 = 3, key2 = -2, key3 = 5, key4 = -1, key5 = 3, key6 = -2, key7 = 7;

    // gets word length 
      lenWord = code.length();
  
    //gets half and quater of word length 
     half = lenWord/2;
     quarter = lenWord/4;
     
  
     // sets the amount of space arrays have 
     ascii = new int[lenWord];
     zO = new int[lenWord];
     val = new int[lenWord];
 
     for (int i=0; i < lenWord; i++)
       {    // int converts to ascii value
           ascii[i] = (int)code.charAt(i);
       }
        
 
     for (int b=0; b < lenWord ; b++)
    {
        countL = countL + 1;
        bobRoss = ascii[b];
        // variables for finding 

        ////////////////////////////////////////////////////////////////
              
        // acts as computers checker
        tester = bobRoss;
        int testOut = 0;
        int rem = 0;
        int remS = 0;
        int remB = 0;
        int remBB = 0;
           
        // tells the if else statements how far in the word the loop is 
        countB = countB + 1;
 

/////////////////////////////////////////////////////////////////////////////////

   
    // runs if value of word being looked at is in the first quarter of the phrase 
        if (countB <= quarter)
        { 
    
            // adds key 1 to overall tally which effects the output 
            countN = countN + key1;
                
            //gives the program a version of the total ascii value created to take a look at 
            testOut = tester + countN;
            
            // checks if the shifted ascii value/tester's value drops into a dead zone 
            if (tester + countN > 126 && tester + countN < 161 || tester + countN <= 31 )
            {
            
            // gives signal that this shifted ascii value interacted with the dead zone
            zO[b] = 1;
    

                // runs if shifted ascii value shifts to below 32 
                if (testOut <= 31)
                {
                    // gives remainder pos
                    
                    //stores its raw value for later calcuation in decryption 
                    val[b] = testOut;
                
                    // grabs value that went into the dead zone
                    remS= testOut - 31;
                
                    //wraps around and adds value from dead zone to very top of ascii code to subtract from it. then sends it to display 
                    rossBob = 256 + remS;
                
                }

                //runs if shifted ascii value shifts above 126 but is still below 160 
                else if (testOut > 126 && testOut < 161)
                {

                    // gives signal this shifted ascii value interacted with the dead zone 
                    zO[b] = 1;
                
                
                    //stores its raw value for later calcuation in decryption 
                    val[b] = testOut;
            
                    // grabs value that went into the dead zone
                    remB = testOut - 126;
                    
                    //wraps around to 160 and adds value from dead zone.Then sends it to display 
                    rossBob = remB + 160;

                    
                    
                }
                
                        // runs if shifted ascii value shifts to above 255
                else if (testOut > 255)
                {
                    // gives signal this shifted ascii value interacted with the dead zone 
                    zO[b] = 1;
                    
                    //stores its raw value for later calcuation in decryption 
                    val[b] = testOut;
            
                    // grabs value that went into the dead zone
                    remBB = testOut - 255;
                    
                    //wraps around to 31 and adds value from dead zone.Then sends it to display
                    rossBob = remBB + 31;

                }
            }
        // runs if the shifted ascii value does not fall into a dead zone
            else {
                // gives signal that this letter value is ok and does not need a further look at 
                zO[b] = 0;
                // no extra valu needs to be taken from it 
                val[b] = 0;
                //adds acsii value by count value to send to diplay 
                rossBob = bobRoss + countN;
            }
        }
    
        // runs if value of word being looked at is in the first half/ second quarter of the phrase
        else if (countB < half)
        {
            // adds key 2 to overall tally which effects the output 
            countN = countN + key2;

                // repeat from eariler 
            testOut = tester + countN;


            // copy of past proccess for if the shifted ascii goes into dead zone commnets would just be the same as above 
            if (tester + countN > 126 && tester + countN < 161 || tester + countN <= 31 )
            {
        
    
    
                // says something happend
                zO[b] = 1;
    
        
    
                if (testOut <= 31)
                {
                
                    
            
                    val[b] = testOut;
                
                
                
                    remS= testOut - 31;
                
                    rossBob = 256 + remS;

                        
                
                }
                else if (testOut > 126 && testOut < 161)
                {
                    zO[b] = 1;
                    val[b] = testOut;
                    remB = testOut - 126;
                    rossBob = remB + 160;
                }
            
                else if (testOut > 255)
                {
                    zO[b] = 1;
                    val[b] = testOut;
                    remBB = testOut - 255;
                    rossBob = remBB + 31;
                }
                }
            else {
                zO[b] = 0;
                val[b] = 0;
                rossBob = bobRoss + countN;  
            }
        }
        
    ///////////////////////////////////////////////////////////////////////////////
            // runs if value of word being looked is at the half of the phrase
        else if (countB == half)
        {
            // adds key 3 to overall tally which effects the output 
            countN = countN + key3;
            // same code as before 
            if (tester + countN > 126 && tester + countN < 161 || tester + countN <= 31 )
            {
                testOut = tester + countN;
                 zO[b] = 1;
    
        
                // if 0-31
                if (testOut <= 31)
                {
                    rem = testOut;
                    val[b] = rem;
                    remS= testOut - 31;
                    rossBob = 256 + remS;
                }
                else if (testOut > 126 && testOut < 161)
                {
                    zO[b] = 1;
                    val[b] = testOut;
                    remB = testOut - 126;
                    rossBob = remB + 160;
                }
            
                else if (testOut > 255)
                {
                    zO[b] = 1;
                    val[b] = testOut;
                    remBB = testOut - 255;
                    rossBob = remBB + 31;
                }
            }
            else {
                zO[b] = 0;
                val[b] = 0;
                rossBob = bobRoss + countN;
            }    
        }
////////////////////////////////////////////////////////////////////////////////////

        // runs if value of word being looked at is in the third quarter of the phrase 
        else if (countB < half + quarter)
        {
            // adds key 4 to overall tally which effects the output 
            countN = countN + key4;
            // same code as befoew
            if (tester + countN > 126 && tester + countN < 161 || tester + countN <= 31 )
            {
                testOut = tester + countN;
                zO[b] = 1;
                if (testOut <= 31)
                {     
                    rem = testOut;
                    val[b] = rem;
                    remS= testOut - 31;
                    rossBob = 256 + remS;
                }
                else if (testOut > 126 && testOut < 161)
                {
                    zO[b] = 1;
                    val[b] = testOut;
                    remB = testOut - 126;
                    rossBob = remB + 160;
                }
                else if (testOut > 255)
                {
                    zO[b] = 1;
                    val[b] = testOut;
                    remBB = testOut - 255;
                    rossBob = remBB + 31;
                }
            }
            else {
                zO[b] = 0;
        
                val[b] = 0;
            
                rossBob = bobRoss + countN;
            }
            
        }
    
            ////////////////////////////////////////////////////////////////////////////
            // runs if value of word being looked at is at the third quarter of the phrase 
        else if (countB == half + quarter)
        {
            // adds key 5 to overall tally which effects the output 
            countN = countN + key5;
            //same as before 
            if (tester + countN > 126 && tester + countN < 161 || tester + countN <= 31 )
            {
                testOut = tester + countN;
                zO[b] = 1;
                if (testOut <= 31)
                {
                    rem = testOut;
                    val[b] = rem;
                    remS= testOut - 31;  
                    rossBob = 256 + remS;
                }
                else if (testOut > 126 && testOut < 161)
                {
                    zO[b] = 1;
                    val[b] = testOut;
                    remB = testOut - 126;
                    rossBob = remB + 160;
                }
                else if (testOut > 255)
                {
                    zO[b] = 1;       
                    val[b] = testOut;
                    remBB = testOut - 255;  
                    rossBob = remBB + 31;
                }
            }
            else {
                zO[b] = 0;
    
                val[b] = 0;
        
                rossBob = bobRoss + countN;
            }
        }
        // runs if value of word being looked at is in the fourth quarter of the phrase 
        else if (countB < lenWord)
        {
            // adds key 6 to overall tally which effects the output 
            countN = countN + key6;
    
        // same as before
            if (tester + countN > 126 && tester + countN < 161 || tester + countN <= 31 )
            {
                testOut = tester + countN;
                zO[b] = 1;
                if (testOut <= 31)
                { 
                    rem = testOut;
                    val[b] = rem;
                    remS= testOut - 31;
                    rossBob = 256 + remS;
                }
                else if (testOut > 126 && testOut < 161)
                {
                    zO[b] = 1;
                    val[b] = testOut;
                    remB = testOut - 126;
                    rossBob = remB + 160;
                }
                else if (testOut > 255)
                {
                    zO[b] = 1;
                    val[b] = testOut;
                    remBB = testOut - 255;
                    rossBob = remBB + 31;
                }
            }
            else {
            zO[b] = 0;
            val[b] = 0;
            rossBob = bobRoss + countN;   
            }
                
        }
    
            ////////////////////////////////////////////////////////////////////
    // runs if value of word being looked at is at the end of the phrase 
        else if (countB == lenWord)
        {
            // adds key 7 to overall tally which effects the output 
             countN = countN + key7;
    
    
            if (tester + countN > 126 && tester + countN < 161 || tester + countN <= 31 )
            {
                testOut = tester + countN;
                zO[b] = 1;
                // if 0-31
                if (testOut <= 31)
                {              
                    rem = testOut;            
                    val[b] = rem;       
                    remS= testOut - 31;
                    rossBob = 256 + remS;
                
                }
                else if (testOut > 126 && testOut < 161)
                {
                    zO[b] = 1;
                    val[b] = testOut;
                    remB = testOut - 126;
                    rossBob = remB + 160;
                }
                else if (testOut > 255)
                {
                    zO[b] = 1;
                    val[b] = testOut;
                    remBB = testOut - 255;
                    rossBob = remBB + 31;
                }
            }
            else {
                zO[b] = 0;
                val[b] = 0;
                rossBob = bobRoss + countN;
            }
         
        }
        
 
/////////////////////////////////////////////////////////////////////////////////
          
        //takes acsii value post shifting and wrapping and turns it from int back into char and stores it
        char takeBack=(char)rossBob;
        // takes char value and converts to string while adding it to word to be displayed
        conv += String.valueOf(takeBack);
    }
       // sends word to be displayed after loop is done converting every peice of phrase
    return conv;
}
      
 
 
 
      ///////////////////////////////////////////////////////////////// Decryption
      
    // method for decryption 
    public static String isAMath2(String code){
  
        //variables 

        int val1 = 0, val2 = 0;
        String conv2 = "";
     
        int ascii2[];
        int lenWord2;
        int countN =0;
        int countB =0;
        int half = 0;
        int quarter = 0;
        int key1D = -3, key2D = 2, key3D = -5, key4D = 1, key5D = -3, key6D = 2, key7D = -7;
        //grabs length of code 
        lenWord2 = code.length();

        //determines how long half code is 
        half = lenWord2/2;

        //determines how long a quarter of code is
        quarter = lenWord2/4;


        // tells array how much space it will have that being the value of lenWord2
        ascii2 = new int[lenWord2];

        //  loop makes sure every part of phrase has been converted to ascii code
        for (int i=0; i < lenWord2; i++)
        {   //  =throws appropriate ascii value in same space normal letter would be
            ascii2[i] = (int)code.charAt(i);
        }
        
        // runs loop length of word to make sure every part of phrase has been decrypted 
        for (int b=0; b < lenWord2 ; b++)
        {
            // takes out appropriate ascii value for letter at b value in loop and converts it to int to do math with
            val1 = ascii2[b];

            // move extracts val[b] value to do math with. Wiped to 0 every loop to prevent overlapping 
            int move = 0; 
    
            //tells if else statment how far in the code the loop is 
            countB = countB + 1;
     
        // much of this code repeats so I will comment the first time something show up and unique stuff

////////////////////////////////////////////

            // runs if value of word being looked at is in the first quarter of the phrase 
            if (countB <= quarter)
            {
                
                // if else statement runs to check if this value had to wrap or not

                // runs if this value never needed to wrap 
                if (zO[b] == 0)
                {
                    // add key to total value to unshift accordingly 
                    countN = countN + key1D;
                    // takes val1/ given ascii value and reverse shifts it accordingly with count to turn to normal 
                    val2 = val1 + countN;
                }
            
                //runs if value had to wrap
                else if(zO[b] == 1)
                {
                    //grabs this asciis raw unwrapped value from val 
                    move = val[b];
                    // add key 1 to total value to unshift accordingly 
                    countN = countN + key1D;
                    // adds raw value to countN to ethier add or sub back to normal value
                    val2 = countN + move;
                }
            ///////////////////////////////////////////////////////////////
            }
                // runs if value of word being looked at is in the second quarter of the phrase 
            else if (countB < half)
            {
                // same as before 
                if (zO[b] == 0)
                {
                    // add key 2 to total value to unshift accordingly 
                    countN = countN + key2D;
                    val2 = val1 + countN;
                }

                else if(zO[b] == 1)
                {
                    move = val[b];
                    // add key 2 to total value to unshift accordingly 
                    countN = countN + key2D;
                    val2 = countN + move;    
                }
            }
                // runs if value of word being looked at is at hald of the phrase 
            else if (countB == half)
            {
                // same as before 
                if (zO[b] == 0)
                {
                    // add key 3 to total value to unshift accordingly 
                    countN = countN + key3D;
                    val2 = val1 + countN;
                }
                else if(zO[b] == 1)
                {
                    move = val[b];
                    // add key 3 to total value to unshift accordingly 
                    countN = countN + key3D;
                    val2 = countN + move;
                }
            }
                
            // runs if value of word being looked at is in the third quarter of the phrase 
            else if (countB < half + quarter)
            {
                // same as before 
                if (zO[b] == 0)
                {
                    // add key 4 to total value to unshift accordingly 
                    countN = countN + key4D;
                    val2 = val1 + countN;
                }
                else if(zO[b] == 1)
                {
                    move = val[b];
                    // add key 4 to total value to unshift accordingly 
                    countN = countN + key4D;
                    val2 = countN + move;
                }
            }
                // runs if value of word being looked at is at the third quarter of the phrase 
            else if (countB == half + quarter)
            {
                
                // same as before 
                if (zO[b] == 0)
                {
                    // add key 5 to total value to unshift accordingly 
                    countN = countN + key5D;
                    val2 = val1 + countN;
                }
                else if(zO[b] == 1)
                {
                    move = val[b];
                    // add key 5 to total value to unshift accordingly 
                    countN = countN + key5D;
                    val2 = countN + move;  
                }    
            }
                // runs if value of word being looked at is in the fourth quarter of the phrase 
            else if (countB < lenWord2)
            {
                    // same as before 
                if (zO[b] == 0)
                {
                    // add key 6 to total value to unshift accordingly 
                    countN = countN + key6D;
                    val2 = val1 + countN;
                }
                else if(zO[b] == 1)
                {
                    move = val[b];
                    // add key 6 to total value to unshift accordingly 
                    countN = countN + key6D;
                    val2 = countN + move;
                } 
            }
                // runs if value of word being looked at is at the end of the phrase 
            else if (countB == lenWord2)
            {
                // same as before 
                if (zO[b] == 0)
                {
                    // add key 7 to total value to unshift accordingly 
                    countN = countN + key7D;
                    val2 = val1 + countN;
                }
                else if(zO[b] == 1)
                {
                    move = val[b];
                    countN = countN + key7D;
                    val2 = countN + move;
                }
            }
           //////////////////
            // takes ascii value created in int and converts to char and stores it
            char takeBack2=(char)val2;
            // takes stored char value and converts it to string and adds and stores it to a string
           conv2 += String.valueOf(takeBack2);
        }
       //returns full decrypted string one conversion is done to all peices of phrase
       return conv2;
   }   
}
