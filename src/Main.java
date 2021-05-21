import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);
    private static Jsoup_parser parser = new Jsoup_parser();

    public static void main(String[] args) {
        int answer = 0;

        while (true) {
            System.out.println("--- Parse News ---");
            System.out.println("1) Показать новости");
            System.out.println("2) Список поддерживаемых тегов");
            System.out.println("3) Выйти из программы");
            try {
                answer = input.nextInt();
            } catch (InputMismatchException ex) {
                input.nextLine(); // очищаем буфер, чтобы не ушел в бесконечный цикл
            }
            if(answer == 1)
                show_news();
            else if(answer == 2)
                parser.print_city();
            else if(answer == 3)
                break;
            else
                System.out.println("Неверный пункт меню!");
        }
    }

    public static void show_news() {
        String answer = null;

        System.out.println("Введите интересующий вас город (список тегов /tags):");
        answer = input.next();
        parser.parse_city(answer);
    }
}