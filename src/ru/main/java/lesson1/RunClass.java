package ru.main.java.lesson1;

public class RunClass {

    public static void main(String[] args) {
        Person[] person = new Person[4];
        person[0] = new Person(" Максим ", 100 );
        person[1] = new Person(" Анзор ", 200 );
        person[2] = new Person(" Алёна ", 250 );
        person[3] = new Person(" Лена ", 300 );
        Group group = new Group(" Друзья ", person);

        Restoran restoran = new Restoran(150, 500, 700);
        String result = restoran.doIt(group);
        System.out.println(result);

    }
}
