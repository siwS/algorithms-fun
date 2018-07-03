package algos.simple_exercises;

/**
 * Simple Fizz Buzz algorithm
 * Write a program that outputs all numbers from 1..100
 * If number is multiplier of 3 print Fizz,
 * if it is multiplier of 5 print Buzz,
 * if it is multiplier of both print FizzBuzz
 */
class FizzBuzz {
    public static void main(String[] args) {
        for (int i=1; i<100; i++) {
            if (i%15==0)
                System.out.println("FizzBuzz");
            else if (i%3==0)
                System.out.println("Fizz");
            else if (i%5==0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }
}