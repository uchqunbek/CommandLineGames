package uz.unicon.clg;

import java.security.SecureRandom;
import java.util.stream.IntStream;

/**
 * Created by Uchqun on 26.11.2015.
 */
public class FindCellNumbers implements CommandLineGame {
    private final static int min = 0;
    private final static int max = 9;
    private int[] cells;
    public static final int userChanceMaxCount = 5;

    @Override
    public boolean run() {

        /**
         * TODO: 1. O'yin boshlanganligi, qisqacha o'yin qoidalari, maksimal, minimal son haqida ma'lumot chiqaring (sout).
         * */

        cells = new int[4];
        SecureRandom r = new SecureRandom();
        IntStream intStream = r.ints(this.min, this.max);
        for (int i = 0; i < cells.length; i++) {
            cells[i] = intStream.findAny().getAsInt();
        }
        /**
         * TODO: 2. Sikl ichida foydalanuvchidan probel bilan ajratilgan 4 ta 0 da 9 gacha son kiritishni so'rang. Kiritilgan sonlarni 4 ta int ga ajrating va bu sonlar generatsiya qilingon sonlar bilan ketma-ketligi bo'yicha aynan bir xil ekanligini tekshiring. Ekranga o'rni to'g'ri kelgan sonlarni chiqaring, o'rni to'g'ri kelmagan, ammo aslida to'g'ri topilgan sonlar o'rnida *, umuman to'g'ri kelmagan sonlar o'rnida - chiqaring. Foydalanuvchi userChanceMaxCount marta urinishda sonlarni ketma-ketligi bilan topsa true, aks holda false qaytaring.
         * Misol uchun kompyuter 5 3 9 0 sonlarini generatsiya qildi
         * Kiritilgan sonlar        Ekranga chiqarish
         *   1 2 3 4                  - - * -
         *   5 6 7 8                  5 - - -
         *   5 9 0 3                  5 * * *
         *   5 0 3 9                  5 * * *
         *   5 3 9 0                  5 3 9 0
         * */
        return false;
    }

    @Override
    public String getGameName() {
        return "Raqam o'rnini top";
    }

    @Override
    public String getRules() {
        /**
         * TODO: 3. Yuqoridagi shartlar asosida to'liq o'yin qoidalarini ishlab chiqing, va String ko'rinishida qaytaring (userChanceMaxCount yoddan chiqmasin).
         * */
        return "Raqam o'rnini top o'yini qoidalari: \n...\n";
    }
}
