public class Main {

    public static void main(String[] args) {
        ListOfNumbers list = new ListOfNumbers("numbers.txt");
        System.out.println("Der Dezimalwert aller Palindrome in der Liste aus Binärzahlen beträgt aufaddiert " + list.getTotalValueOfPalindromes() + ".");
    }

}
