package uz.unicon.clg;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by Uchqun on 26.11.2015.
 */
public class FindNumber implements CommandLineGame{
    private int min = 0;
    private int max = 100;
    private int randomNumber;
    public static final int userChanceMaxCount = 5;

    public boolean run() {
        /**
         * TODO: 1. O'yin boshlanganligi, qisqacha o'yin qoidalari, maksimal, minimal son haqida ma'lumot chiqaring (sout).
         * */
        SecureRandom r = new SecureRandom();
        this.randomNumber = r.ints(this.min, this.max).findFirst().getAsInt();
        /**
         * TODO: 2. Sikl ichida foydalanuvchidan son kiritishini so'rang. Son generatsiya qilingan sondan katta yo kichikligini, yoki foydalanuvchi to'g'ri topganligini ko'rsating. Agarda son to'g'ri topilmagan bo'lsa, siklni userChanceMaxCount martagacha takrorlash mumkin. Shu sikl ichida foydalanuvchi sonni topolmasa, foydalanuvchi o'yinni yutqazgan deb toping va false qaytaring. Agarda son to'g'ri topilgan bo'lsa, foydalanuvchini tabriklang va true qaytaring.
         * */
        return true;
    }

    @Override
    public String getGameName() {
        return "Raqamni Top";
    }

    public String getRules() {
        /**
         * TODO: 3. Yuqoridagi shartlar asosida to'liq o'yin qoidalarini ishlab chiqing, va String ko'rinishida qaytaring (userChanceMaxCount yoddan chiqmasin).
         * */
        return "Raqamni Top o'yini qoidalari: \n...\n";
    }
}
