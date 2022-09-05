

public class StepTracker {
    MonthData[] monthToData;
    int goalSteps=10000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();

        }
    }
    void saveSteps(int month,int day, int steps){
        monthToData[month].dayInMonth[day]=steps;
        System.out.println("шаги сохранены");
    }

    void viewStats(int month){
        Converter converter=new Converter();
        int sumStepsPerMonth=0;
        int maxStepsPerMonth=0;
        int scoreDays=0;
        int maxScoreDays=0;
        for(int i=0; i<30; i++) {
            System.out.println(i + 1 + "день: " + monthToData[month].dayInMonth[i] + "шагов");

            sumStepsPerMonth += monthToData[month].dayInMonth[i];

            if (monthToData[month].dayInMonth[i] > maxStepsPerMonth) {
                maxStepsPerMonth = monthToData[month].dayInMonth[i];
            }


            if (monthToData[month].dayInMonth[i] >= goalSteps) {
                scoreDays++;
                if (scoreDays > maxScoreDays) {
                    maxScoreDays = scoreDays;
                }
            } else {
                scoreDays = 0;
            }
        }

        System.out.println("Общее количество шагов за месяц - " + sumStepsPerMonth);

        System.out.println("Максимальное пройденное число шагов в месяце - " + maxStepsPerMonth);

        System.out.println("Среднее количество шагов за месяц - " + (sumStepsPerMonth/30));

        System.out.println("За этот месяц было пройдено - " + converter.convertToKilometers(sumStepsPerMonth) + " километров");

        System.out.println("За этот месяц было сожжено - " + converter.convertToKiloCal(sumStepsPerMonth) + " килокалорий");

        System.out.println("Лучшая серия дней подряд - " + maxScoreDays);


   }

   private static class MonthData {
        int [] dayInMonth= new int[30];
    }
}
