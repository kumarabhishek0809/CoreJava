package core.threads.library.management;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Student implements Runnable {
    private int id;
    private List<Book> booksWithStudent;

    public Student(int id, List<Book> booksWithStudent) {
        this.id = id;
        this.booksWithStudent = booksWithStudent;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true){
            int bookId = random.nextInt(Constants.NUMBER_OF_BOOKS);
            try{
                Optional<Book> bookOptional = booksWithStudent.stream().filter(book -> book.getId() == bookId).findAny();
                if(bookOptional.isPresent()){
                    Book book = bookOptional.get();
                    book.read(this);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
