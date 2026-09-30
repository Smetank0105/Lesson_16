package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import jdk.swing.interop.SwingInterOpUtils;

import java.beans.Visibility;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void main() {
        //1
        Book book = new Book("Some Book", "John Doe", 1991, 15.99);

        Gson gson = new Gson();
        String json = gson.toJson(book);

        System.out.println("JSON:");
        System.out.println(json);

        Gson pretty_gson = new GsonBuilder().setPrettyPrinting().create();
        String pretty_json = pretty_gson.toJson(book);

        System.out.println("pretty JSON:");
        System.out.println(pretty_json);

        //2
        String json2 = "[{\"name\": \"Аня\", \"age\": 19, \"grade\": 4.5}, {\"name\": \"Борис\", \"age\": 21, \"grade\": 3.8}, {\"name\": \"Вера\", \"age\": 20, \"grade\": 4.9}]";

        Gson gson2 = new Gson();

        Type typeToken = new TypeToken<List<Student>>() {}.getType();
        List<Student> students = gson2.fromJson(json2, typeToken);

        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getGrade() > 4.0)
                .collect(Collectors.toList());

        System.out.println("Students with grade above 4.0: ");
        filteredStudents.forEach(student-> System.out.println(student.getName()));

        double averageGrade = students.stream()
                .mapToDouble(Student::getGrade)
                .average()
                .orElse(0.0);

        System.out.println("Group average: "+averageGrade);

        //3
        User user = new User();
        user.setLogin("login");
        user.setPassword("password");
        user.setAddress(new Address());
        user.getAddress().setCity("city");
        user.getAddress().setStreet("street");
        user.setHobbies(List.of("hobby1", "hobby2"));

        Gson gson3 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json3 = gson3.toJson(user);
        System.out.println("Serialize: "+json3);

        User user2 = gson3.fromJson(json3, User.class);
        System.out.println("User log: "+user2.getLogin()+", User pass: "+user2.getPassword() + ", User hobby: "+user2.getHobbies());
    }
}
