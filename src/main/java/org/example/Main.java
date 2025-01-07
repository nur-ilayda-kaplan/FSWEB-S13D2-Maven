package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // isPalindrome metodunu test ediyoruz
        System.out.println(isPalindrome(-1221)); // true
        System.out.println(isPalindrome(707));  // true
        System.out.println(isPalindrome(11212)); // false
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
}