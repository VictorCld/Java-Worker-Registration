package exercicios.ExercAula99;
import exercicios.ExercAula99.Trabalhador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Locale;

public class RegistroDeTrabalhadores {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Trabalhador> list = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();
        System.out.println();

        for (int i = 1; i <= n; i++) {
            Trabalhador t = new Trabalhador(0, "", 0.0);

            System.out.println("Emplyoee #" + i);
            System.out.print("Id: ");
            t.setId(sc.nextInt());
            while (hasId(list, t.getId())) {
                System.out.print("Id already taken. Try again: ");
                t.setId(sc.nextInt());
            }
            System.out.print("Name: ");
            sc.nextLine();
            t.setName(sc.nextLine());
            System.out.print("Salary: ");
            t.setSalary(sc.nextDouble());
            System.out.println();

            list.add(t);
        }

        System.out.println();
        System.out.print("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        System.out.print("Enter the percentage: ");
        double percentage = sc.nextDouble();
        System.out.println();
        Trabalhador t = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (t == null) {
            System.out.println("This id does not exist!");
        } else {
            t.setSalary(t.getSalary() + (t.getSalary() * percentage / 100));
        }

        System.out.println();
        System.out.println("List of employees:");
        for (Trabalhador x : list) {
            System.out.println(x);
        }

        sc.close();
    }

    public static boolean hasId(List<Trabalhador> list, int id) {
        Trabalhador trab = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return trab != null;
    }

}
