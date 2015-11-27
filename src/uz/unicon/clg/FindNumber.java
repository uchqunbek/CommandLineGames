package uz.unicon.clg;

import java.security.SecureRandom;
import java.util.Scanner;

/**
 * Created by Uchqun on 26.11.2015.
 */
public class FindNumber implements CommandLineGame {
    private int min = 0;
    private int max = 100;
    private int randomNumber;
    private int userNumber;
    private boolean loopCheck=true;

    public static final int userChanceMaxCount = 10;

    public boolean run() {
        /**
         * TODO: 1. O'yin boshlanganligi, qisqacha o'yin qoidalari, maksimal, minimal son haqida ma'lumot chiqaring (sout).
         * */
        System.out.print(getGameName());
        System.out.println(getRules());

        this.randomNumber = (int) (Math.random() * 100);

        System.out.println("Son kiriting: ");

        for (int i = 0; i < userChanceMaxCount; i++) {
            Scanner scanner = new Scanner(System.in);
            userNumber = scanner.nextInt();

            if (userNumber < randomNumber) {
                System.out.println("Siz kiritgan son o'ylangan sondan kichik");

            }
            if (userNumber > randomNumber) {
                System.out.println("Siz kiritgan son o'ylangan sondan katta");
            } if(isFound()) {
                System.out.println("Tabriklaymiz Siz G'olib bo'ldingiz :-)");

                loopCheck=false;
                break;
            }

        }if(loopCheck)
        System.out.println("Siz yutqazdingiz :-(");

        /**
         * TODO: 2. Sikl ichida foydalanuvchidan son kiritishini so'rang. Son generatsiya qilingan sondan katta yo kichikligini, yoki foydalanuvchi to'g'ri topganligini ko'rsating. Agarda son to'g'ri topilmagan bo'lsa, siklni userChanceMaxCount martagacha takrorlash mumkin. Shu sikl ichida foydalanuvchi sonni topolmasa, foydalanuvchi o'yinni yutqazgan deb toping va false qaytaring. Agarda son to'g'ri topilgan bo'lsa, foydalanuvchini tabriklang va true qaytaring.
         * */


        return true;
    }

    private boolean isFound() {
        if (userNumber == randomNumber) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public String getGameName() {
        return "Raqamni Top";
    }

    public String getRules() {
        /**
         * TODO: 3. Yuqoridagi shartlar asosida to'liq o'yin qoidalarini ishlab chiqing, va String ko'rinishida qaytaring (userChanceMaxCount yoddan chiqmasin).
         * */
        return " O'yini boshlandi\nO'yin qoidalari quyidagicha:\n" + min + "  dan " + max + "  oralig'ida istalgan butun sonni kiritasiz.\n " +
                "Sizga " + userChanceMaxCount + " marta imkon beriladi\n";
    }
}
