//import libraries

import java.io.*;

import java.util.Scanner;




/*COP3503 - CSII
 *Lab 01 - Prim's Algorithm
 *Submitted by:
 *   Felipe Caseiro
 *   Aglay Saenz
 */


public class Lab01 {
	
	public static void main (String[] args) {
        
        try { //try block
        
        	
        	//exists
            if (args.length > 0) {

            	//new variables for reading in file and input
            	
                File InputFile = new File(args[0]);

                Scanner readScanner = new Scanner(InputFile);

                int VertexNumber = Integer.parseInt(readScanner.next());
                int EdgesNumber = Integer.parseInt(readScanner.next());
                
                double Grid[][] = new double[VertexNumber][VertexNumber];

                //new variables for reading
                
                for (int i = 0; i < EdgesNumber; i++) {
                
                    int FirstVertex = Integer.parseInt(readScanner.next());


                    int SecondVertex = Integer.parseInt(readScanner.next());


                    double weight = Double.parseDouble(readScanner.next());


                    Grid[FirstVertex][SecondVertex] = weight;
                    Grid[SecondVertex][FirstVertex] = weight;
                    
                }

                MST.Graph(Grid, VertexNumber); //print

                readScanner.close(); //close scanner

            }

        } 
        
        catch (FileNotFoundException e) { //catch block
        
            System.out.println("File was not found. You're an idiot");
            e.printStackTrace();
            
        }

    }
	
}


class MST { //MST class

    public static int MinimumMST (double point[], boolean Grid[], int VertexNumber) {
    	
    	//initialize values
    
        double LowestNumber = Integer.MAX_VALUE;
        
        int Index = 0;

        for (int i = 0; i < VertexNumber; i++) {
        
            if (Grid[i] == false && point[i] < LowestNumber) {

                Index = i;
                LowestNumber = point[i];

            }
            
        }
        
        return Index;

  } //end of MinimumMST
    

    public static void Graph (double Grid[][], int VertexNumber) {
    
        int PrimMST[] = new int[VertexNumber]; //array for MST
        
        PrimMST[0] = -1; //starting point


        double Point[] = new double[VertexNumber]; //array for point
        Point[0] = 0; //starting point

        boolean[] NewGrid = new boolean[VertexNumber]; //array for new grid


        //pseudocode from assignment:
        for (int i = 0; i < VertexNumber; i++) {
        
            Point[i] = Integer.MAX_VALUE;
            NewGrid[i] = false;
            
        }

        for (int j = 0; j < VertexNumber - 1; j++) {
        
            int temp = MinimumMST(Point, NewGrid, VertexNumber);

            NewGrid[temp] = true;

            for (int k = 0; k < VertexNumber; k++) {

                if (Grid[temp][k] != 0 && NewGrid[k] == false && Grid[temp][k] < Point[k]) {

                    Point[k] = Grid[temp][k];
                    
                    PrimMST[k] = temp;

                } //if
            } //k
        } //j

        
        double Counter = 0; //reset
        
        //hold the weights
        for (int l = 1; l < VertexNumber; l++) {
        

            System.out.println(PrimMST[l]+ "-" +l+ " "+Grid[PrimMST[l]][l]); //print

            Counter +=  Grid[PrimMST[l]][l]; //Counter = previous Counter + Grid values

        }
        
        System.out.printf("%.5f\n", Counter); //print Counter

    }
    
}
