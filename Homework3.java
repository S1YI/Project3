import java.util.Random;

public class Homework3 {

    public static int power(int x, int n){
        int y;
        if (n == 0){
            //if the power is 0 return 1
            return 1;
        }
        else if(n == 1){
            //if power is 1 return base number
            return x;
        }
        else if(n % 2 == 0){
            //even power
            y = power(x,n/2);
            return y * y;
        }
        else{
            //odd number
            y = power(x,n/2);
            return (y * y)* x;
        }
    }

    public static int multiply(int n1, int n2){
        if (n2 == 0 || n1 == 0) {
            //returns 0 if one of the numbers is 0
            return 0;
        }
        else if(n2 == 1 || n1 == 1) {
            //multiplies the numbers by its self if 1
            return n1 * n2;
        }
        else {
            //multiples recursively
            return n2 + multiply(n1-1, n2);
        }
    }

    public static long fibonacci(int n){
        if(n == 0){
            //returns 0 if 0 is inputted
            return 0;
        }
        else if(n == 1){
            //returns 1 if 1 is inputted
            return 1;
        }
        else{
            //fibonacci recursively
            return (fibonacci(n - 1) + fibonacci(n - 2));
        }
    }


    //creates class
    static class Node{
        int data;
        Node next;

        //creates the node
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //defines the head and tail to null
    public Node head = null;
    public Node tail = null;

    //allows user to add nodes to the linked list
    public void addNode(int data){
        Node aNode = new Node(data);

        //creates the new list if not already made
        if(head == null) {
            tail = aNode;
            head = aNode;
        }
        //adds a node to the linked list
        else {
            tail.next = aNode;
            tail = aNode;
        }
    }

    public int lengthOfLinkedList(Node node){
        //detects if there is no linked list
        if(node == null){
            return 0;
        }
        //recursively counts the amount of nodes in the linked list
        else{
            return 1 + lengthOfLinkedList(node.next);
        }
    }

    private static void mergeSort(int[] array) {
        //defines the array length
        int arrayLength = array.length;

        //if array is less or equal to 1 then returns the length
        if (arrayLength == 0 || arrayLength == 1) {
            return;
        }

        //splits the array in half
        int halfArray = arrayLength / 2;
        //defines how big the left half array should be
        int[] lHalf = new int[halfArray];
        //defines how big the right half array should be
        int[] rHalf = new int[arrayLength - halfArray];

        for (int i = 0; i < halfArray; i++) {
            //puts left half of the array in the left array
            lHalf[i] = array[i];
        }
        for (int i = halfArray; i < arrayLength; i++) {
            //puts right half of the array in the right array
            rHalf[i - halfArray] = array[i];
        }

        //sorts both left and right half recursively
        mergeSort(rHalf);
        mergeSort(lHalf);

        //Calls the merge function to put the array together
        mergeHalfs(array, lHalf, rHalf);
    }

    private static void mergeHalfs (int[] array, int[] lHalf, int[] rHalf) {
        //defines the size of the arrays
        int lLength = lHalf.length;
        int rLength = rHalf.length;

        //variables
        int n = 0, x = 0, i = 0;

        //loops until we run out of items in both arrays
        while (n < lLength && x < rLength) {
            //compares left and right numbers to combine into the array
            if (lHalf[n] <= rHalf[x]) {
                array[i] = lHalf[n];
                n++;
            }
            else {
                //if the other number in the other half is bigger then we add it to the array
                array[i] = rHalf[x];
                x++;
            }
            i++;
        }

        //puts the leftover number from the left side into the array
        while (n < lLength) {
            array[i] = lHalf[n];
            n++;
            i++;
        }

        //puts the leftover number from the right side into the array
        while (x < rLength) {
            array[i] = rHalf[x];
            x++;
            i++;
        }

    }

    private static void printArray(int[] numbers) {
        //prints out each number in the array
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    public static int gcd(int num1, int num2){
        //if numbers are the same it returns number
        if (num1 == num2){
            return num1;
        }
        //if num1 is bigger than num2 it recursively finds gcd
        else if(num1 > num2){
            return gcd(num1 - num2, num2);
        }
        else{
            //if num2 is bigger than num1 it recursively finds gcd
            return gcd(num1, num2 - num1);
        }
    }


    public static void main(String[] args) {
        //Calls the power algorithm
        System.out.println("The product of the power is: " + power( 2,  7));

        //Calls the multiplication
        System.out.println("The product is: " + multiply(5,5));

        //Prints out the first ten numbers
        for(int x = 0; x <= 9;x++){
            System.out.println("Fibonacci Sequence " + (x) +": " + fibonacci(x));
        }

        //Calls the Fibonacci sequence
        System.out.println("The number in the Fibonacci Sequence is: " + fibonacci(6));

        //Calls Euclid’s algorithm
        System.out.println("The GCD is: " + gcd(31,2));

        //Creates simple linked list
        Homework3 simpleLinkedList = new Homework3();

        //Adds 10 nodes to list
        for(int x = 0; x < 10; x++) {
            simpleLinkedList.addNode(x);
        }

        //Prints number of links in the list
        System.out.println("There are " + simpleLinkedList.lengthOfLinkedList(simpleLinkedList.head) + " links in the list");

        //Creates Array and puts random numbers into it
        Random rand = new Random();
        int[] randomArray = new int[100];

        for(int x = 0; x < randomArray.length; x++){
            randomArray[x] = rand.nextInt(100);
        }

        //Prints unsorted array
        System.out.println("----Before Merge Sort----");
        printArray(randomArray);
        //Sorts random num array
        mergeSort(randomArray);
        //Prints sorted array
        System.out.println("----After Merge Sort----");
        printArray(randomArray);
    }
}