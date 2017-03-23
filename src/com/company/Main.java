package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("How many of each suit?: ");
        int suit = sc.nextInt();
        Scanner scs = new Scanner(System.in);
        System.out.println("How many different suits?: ");
        int suitNum = sc.nextInt();
        System.out.println("Names of each suit: ");
        String suitNames = scs.nextLine();
        System.out.println("Enter Lowest Card and Highest Card(non face card):");
        String lowHigh = scs.nextLine();
        System.out.println("Standard Face?");
        String yn = scs.next();

        String ace = "Ace";
        String jack = "Jack";
        String queen = "Queen";
        String king = "King";


        if (yn.equalsIgnoreCase("no"))
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
        String extras = scs.next();
        ArrayList<String > cards = new ArrayList<>();
        int spaceIndex = lowHigh.indexOf(' ');
        int low = Integer.parseInt(lowHigh.substring(0,spaceIndex));
        int high = Integer.parseInt(lowHigh.substring(spaceIndex + 1));

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

        System.out.println(cards);
    }
}
