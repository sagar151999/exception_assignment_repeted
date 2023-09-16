/*
 * Write a Java program that reads a list of integers from the user and throws an
exception if any numbers are duplicates.
Input the Integers 1 2 3 3 4 5
Error: Duplicate number found: 3
Input 1 2 3 4 5 6
No duplicate numbers!
 */

package assignment_no_11;

import java.util.Scanner;

public class duplicate_no {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter a list of integers separated by spaces:");

        String input = sc.nextLine();
        String[] inputArray = input.split(" ");

        try {
            if (hasDuplicates(inputArray))
            {
                throw new DuplicateNumberException("Error: Duplicate number(s) found!");
            }
            else
            {
                System.out.println("No duplicate numbers!");
            }
        } 
        catch (DuplicateNumberException e) 
        {
            System.err.println(e.getMessage());
        }
    }

    public static boolean hasDuplicates(String[] numbers)
    {
        for (int i = 0; i < numbers.length; i++)
        {
            for (int j = i + 1; j < numbers.length; j++)
            {
                if (numbers[i].equals(numbers[j])) 
                {
                    System.err.println("Error: Duplicate number found: " + numbers[i]);
                    return true;
                }
            }
        }
        return false;
    }

    static class DuplicateNumberException extends Exception {
        public DuplicateNumberException(String message) {
            super(message);
        }
    }
}
