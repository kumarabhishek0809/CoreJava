package core.threads.library.management;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LibraryManagement {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Constants.NUMBER_OF_STUDENTS);
        List<Book> books = new ArrayList<>(Constants.NUMBER_OF_BOOKS);
        ExecutorService executor = Executors.newFixedThreadPool(Constants.NUMBER_OF_STUDENTS);
        try {
            for(int i = 0 ; i< Constants.NUMBER_OF_BOOKS;i++){
                books.add(new Book(i));
            }
            for(int i = 0 ; i< Constants.NUMBER_OF_STUDENTS;i++){
                Student student = new Student(i, books);
                students.add(student);
                executor.execute(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
            executor.shutdown();
        } finally {
            executor.shutdown();
        }
    }
}
