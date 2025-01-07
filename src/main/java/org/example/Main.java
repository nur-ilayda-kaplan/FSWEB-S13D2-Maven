package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // isPalindrome metodunu test ediyoruz
        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(707));  // true
        System.out.println(isPalindrome(11212)); // false

        // isPerfectNumber metodunu test ediyoruz
        System.out.println(isPerfectNumber(6));   // true
        System.out.println(isPerfectNumber(28));  // true
        System.out.println(isPerfectNumber(5));   // false
        System.out.println(isPerfectNumber(-1));  // false

        // numberToWords metodunu test ediyoruz
        numberToWords(123);   // One Two Three
        numberToWords(1010);  // One Zero One Zero
        numberToWords(-12);   // Invalid Value
    }

    public static boolean isPalindrome(int number) {
        // Negatif sayıları pozitif yapmak için mutlak değer alıyoruz
        int originalNumber = Math.abs(number);
        int reversedNumber = 0;
        int temp = originalNumber;

        // Sayıyı ters çevirmek için
        while (temp > 0) {
            int lastDigit = temp % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            temp /= 10;
        }

        // Ters çevrilmiş sayı ile orijinal sayı eşit mi kontrol ediyoruz
        return originalNumber == reversedNumber;
    }

    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false; // Sayı 0'dan küçükse false döner
        }

        int sum = 0;

        // Sayının tüm pozitif bölenlerini bulup topluyoruz (kendisi hariç)
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        // Bölenlerin toplamı sayıya eşitse mükemmel sayı demektir
        return sum == number;
    }

    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
            return;
        }

        int reversed = reverse(number); // Sayıyı ters çeviriyoruz
        int originalDigitCount = getDigitCount(number);
        int reversedDigitCount = getDigitCount(reversed);

        // Ters çevrilmiş sayıdan rakamları alıp kelimelerle yazdırıyoruz
        while (reversed > 0) {
            int lastDigit = reversed % 10;
            printWord(lastDigit);
            reversed /= 10;
        }

        // Eksik sıfırları eklemek için (örneğin, 100'de "One Zero Zero")
        for (int i = 0; i < originalDigitCount - reversedDigitCount; i++) {
            printWord(0);
        }
    }

    public static int reverse(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            reversedNumber = (reversedNumber * 10) + lastDigit;
            number /= 10;
        }
        return reversedNumber;
    }

    public static int getDigitCount(int number) {
        if (number == 0) {
            return 1;
        }

        if (number < 0) {
            number = Math.abs(number);
        }

        int count = 0;
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static void printWord(int digit) {
        switch (digit) {
            case 0:
                System.out.print("Zero ");
                break;
            case 1:
                System.out.print("One ");
                break;
            case 2:
                System.out.print("Two ");
                break;
            case 3:
                System.out.print("Three ");
                break;
            case 4:
                System.out.print("Four ");
                break;
            case 5:
                System.out.print("Five ");
                break;
            case 6:
                System.out.print("Six ");
                break;
            case 7:
                System.out.print("Seven ");
                break;
            case 8:
                System.out.print("Eight ");
                break;
            case 9:
                System.out.print("Nine ");
                break;
        }
    }
}
