public class ProcessedNumber {
    private boolean isPalindrome = true;
    private int decimalValue = 0;
    private String binaryValue;

    public ProcessedNumber(String raw) {
        binaryValue = raw;
        rawDataToBinary();
        isPalindrome();
        if(isPalindrome) {
            calculateDecimalValue();
        }
    }

    private void rawDataToBinary() {

        binaryValue = binaryValue.replace("\"", "");
        binaryValue = binaryValue.replace(",", "");
    }

    private void isPalindrome() {
        int i = binaryValue.length() - 1;
        int end = binaryValue.length() / 2;
        while(end > 0) {
            if(binaryValue.charAt(i) == binaryValue.charAt(binaryValue.length() - 1 - i)) {
                end--;
                i--;
            } else {
                isPalindrome = false;
                break;
            }
        }
    }

    private void calculateDecimalValue() {
        int i = 0;
        while(i < binaryValue.length()) {
            if(binaryValue.charAt(binaryValue.length() - 1 - i) == '1') {
                decimalValue = (int) (decimalValue + Math.pow(2, i));
            }
            i++;
        }
    }

    public boolean getIsPalindrome() {
        return isPalindrome;
    }

    public int getDecimalValue() {
        return decimalValue;
    }

}
