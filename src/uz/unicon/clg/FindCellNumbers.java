package uz.unicon.clg;

import java.util.Scanner;

public class FindCellNumbers implements CommandLineGame {
    private final static int min = 0;
    private final static int max = 9;
    private int[] cells;
    public static final int userChanceMaxCount = 5;
    String[] Qoidalar = new String[5];

    int[] attempt = new int[4];

    String[] attempString;
    String result[] = new String[4];
    protected boolean res = false;

    @Override
    public boolean run() {

        System.out.println("Siz " + getGameName() + " o'yiniga hush kelibsiz!");
        System.out.println("Quyida sizni o'yin qoidalari bilan tanishtiraman.");
        getRules();
        System.out.println("Qoidalar bilan tanishib bo'lgan bo'lsangiz demak o'yin bowlandi!");
        /**
         * TODO: 1. O'yin boshlanganligi, qisqacha o'yin qoidalari, maksimal, minimal son haqida ma'lumot chiqaring (sout).
         * */
        generate();

        for (int k = 0; k < 5; k++) {
            System.out.println((k + 1) + " - imkoniyat");
            userInput();                                               //checking
            //birinchi qoida bo'yicha tekshirish
            checking();
        }
        if (result.equals(attempString)) {
            System.out.println("Siz yutdingiz generatsiya qilingan 4 lik");
            res = true;
        } else
            System.out.println("Siz yutkazdingiz generatsiya qilingan 4 lik");
        for (int i = 0; i < cells.length; i++)
            System.out.print(cells[i] + " ");


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
        return res;
    }

    @Override
    public String getGameName() {
        return "Raqam o'rnini top";
    }

    @Override
    public String getRules() {
        Qoidalar[0] = "Demak, sizda 5 ta imkon mavjud. ";
        Qoidalar[1] = "Siz shu 5 urunish orqali maksimal aniqlik bilan kompyuter Generatsiya qilgan 4 ta sonni va ularning joylashish tartibini topishingiz kerak.";
        Qoidalar[2] = "Agar siz sonni ham u joylashgan o'rnini ham topsangiz o'wa son, sonni topgsangizu lekin uning o'rnini topa olmasangiz *, ulardan ikkisini ham topa olmasangiz - belgisi chiqadi. ";
        Qoidalar[3] = "Minimal son : 0, maksimal son esa  9 ga teng";
        Qoidalar[4] = "Sonlarni probel bilan ajratib kiriting. Masalan: 5 3 9 0";
        for (int i = 0; i < 5; i++)
            System.out.println(Qoidalar[i]);

        /**
         * TODO: 3. Yuqoridagi shartlar asosida to'liq o'yin qoidalarini ishlab chiqing, va String ko'rinishida qaytaring (userChanceMaxCount yoddan chiqmasin).
         * */
        return Qoidalar.toString();
    }

    protected void generate() {
        cells = new int[4];                             //generator
        for (int i = 0; i < cells.length; i++) {
            cells[i] = (int) (Math.random() * 9);
        }
    }

    public void userInput() {
        Scanner input = new Scanner(System.in);           //vvod dannix i razdelenie

        String imkon = input.nextLine();
        attempString = imkon.split(" ");
        for (int i = 0; i < 4; i++) {
            try {
                Byte b1 = new Byte(attempString[i]);
                attempt[i] = b1;
            } catch (NumberFormatException e) {
                System.err.println("Siz sonlarni noto'g'ri formatda kiritdingiz, sizning joriy imkoniyatingiz kuydi!");
            }
            if ((attempt[i] < 0) || attempt[i] > 9)
                System.err.println("Siz qoidani buzdingiz,0 dan kichik yoki 9 dan katta sonni kiritish mumkin emas, sizning joriy imkoniyatingiz kuydi!!");
        }
    }

    public void checking() {
        for (int i = 0; i < 4; i++) {
            result[i] = "- ";
        }
        for (int i = 0; i < 4; i++) {
            if (attempt[i] == cells[i]) result[i] = attempString[i];

            else {
                for (int j = 0; j < 4; j++)
                    if ((attempt[i] == cells[j]) & (i != j)) result[i] = "*";
            }
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

}

