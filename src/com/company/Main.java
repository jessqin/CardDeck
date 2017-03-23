package com.company;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("How many of each suit?: ");
            int suit = sc.nextInt();

            if (suit < 0)
            {
                System.out.println("Please do not enter negative numbers.");
                System.exit(0);
            }

            Scanner scs = new Scanner(System.in);
            System.out.println("How many different suits?");
            int suitNum = sc.nextInt();

            if (suitNum < 0)
            {
                System.out.println("Please do not enter negative numbers.");
                System.exit(0);
            }

            System.out.println("Names of each suit (Example: spades, hearts, diamonds, clubs)");
            String suitNames = scs.nextLine();
            System.out.println("Enter Lowest Card and Highest Card(non face card): (\" Please separate each number by a space\")");
            String lowHigh = scs.nextLine();
            System.out.println("Standard Face? (yes or no)");
            String yn = scs.next();

            String ace = "Ace";
            String jack = "Jack";
            String queen = "Queen";
            String king = "King";


            if (yn.equalsIgnoreCase("no") || yn.equalsIgnoreCase("n"))
            {
                System.out.println("What will Replace Ace?");
                ace = scs.next();
                System.out.println("What will Replace Jack?");
                jack = scs.next();
                System.out.println("What wil replace Queen?");
                queen = scs.next();
                System.out.println("What will replace King?");
                king = scs.next();

            }
            System.out.println("Extra cards and amount?");
            String extras = scs.nextLine();

            ArrayList<String > cards = new ArrayList<>();

            String [] hl = lowHigh.split("\\s");
            // int spaceIndex = lowHigh.indexOf(' ');
            int low = Integer.parseInt(hl[0]);
            int high = Integer.parseInt(hl[1]);

            String [] names = suitNames.split(",\\s");

            String[] faceCards = {jack, queen, king, ace};

            String [] suits = new String[suitNum];

            for (int i = 0; i < suitNum; i ++)
            {
                for (int k = 0; k < suit; k++)
                {
                    for (int j = low; j <= high; j++)
                    {
                        cards.add(j + " of " + names[i]);
                    }
                    for (int a = 0; a < 4; a++)
                    {
                        cards.add(faceCards[a] + " of " + names[i]);
                    }
                }
            }


            String [] extraArray = extras.split("\\s");
            String [] extraCardName = new String[extraArray.length/2 + 1];
            int [] extraCardAmount = new int[extraArray.length/2 + 1];
            int counterAmount = 0;
            int counterName = 0;
            for (int b = 0; b < extraArray.length; b++)
            {
                if ((b+1)%2 == 0)
                {
                    extraCardAmount[counterAmount] = Integer.parseInt(extraArray[b]);
                    counterAmount++;
                }
                else
                {
                    extraCardName[counterName] = extraArray[b];
                    counterName++;
                }

            }
            for (int c = 0; c < counterAmount; c++)
            {
                for (int e = 0; e < extraCardAmount[c]; e++)
                {
                    cards.add(extraCardName[c]);
                }
            }
            for(int i = 0; i<cards.size(); i++)
            {
                if (i%5==0 && (i!=0))
                {
                    System.out.println(cards.get(i));
                }
                else
                {
                    System.out.println(cards.get(i) + ", ");
                }
            }

        }
        catch (InputMismatchException e)
        {
            System.out.println("Please Follow the Directions");
            System.exit(0);
        }


    }
}
