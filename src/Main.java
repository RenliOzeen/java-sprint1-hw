import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        System.out.println("Введите число от 1 до 4 для выполнения действия");
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {

                while (true) {
                    System.out.println("Введите номер нужного месяца от 0 до 11");
                    int month = scanner.nextInt();

                    System.out.println("Введите номер нужного дня от 0 до 29");
                    int day = scanner.nextInt();

                    System.out.println("Введите количество шагов за указанный день");
                    int steps = scanner.nextInt();

                    if(month<0 || month>11 || day<0 || day>29 || steps<0){
                        System.out.println("Ошибка ввода, попробуйте снова");
                    }
                    else{
                        stepTracker.saveSteps(month,day,steps);
                        break;
                    }

                }

            } else if (userInput == 2) {
                while(true){
                    System.out.println("Введите номер месяца от 0 до 11, за который " +
                            "хотите увидеть статистику");
                    int month = scanner.nextInt();
                    if(month<0 || month>11){
                        System.out.println("Ошибка ввода, попробуйте снова");
                    }
                    else{
                        stepTracker.viewStats(month);
                        break;
                    }
                }

            } else if (userInput == 3) {
                while(true){
                    System.out.println("Введите новое целевое значение шагов");
                    stepTracker.goalSteps=scanner.nextInt();
                    if(stepTracker.goalSteps<0){
                        System.out.println("Ошибка ввода, попробуйте снова");
                    }
                    else{
                        System.out.println("Целевое значение шагов изменено! " +
                                "Новое целевое значение - " + stepTracker.goalSteps + " шагов");
                        break;
                    }

                }

            } else {
                System.out.println("Такого пункта нет в меню, попробуйте снова!");
            }

            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("1 - Ввод числа шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов");
        System.out.println("0 - Выход из приложения");

    }

}




