package com.postwork4.bedu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.postwork4.bedu.model.Persona;
import org.springframework.boot.CommandLineRunner;
import java.util.Scanner;

@SpringBootApplication
public class PostWork4Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PostWork4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Nombre: ");
        String nombre = teclado.nextLine();

        System.out.println("Telefono:");
        String telefono = teclado.nextLine();

        Persona persona = new Persona(nombre, telefono);

        System.out.println(persona);
    }
}