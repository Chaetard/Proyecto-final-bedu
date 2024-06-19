package com.postwork4.bedu;
import com.postwork4.bedu.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import com.postwork4.bedu.model.Persona;
import org.springframework.boot.CommandLineRunner;
import java.util.Scanner;

@SpringBootApplication
public class PostWork5Application implements CommandLineRunner {

    private final ValidadorTelefono validadorTelefono;
    private final FormateadorTelefono formateadorTelefono;

    @Autowired
    public PostWork5Application(ValidadorTelefono validadorTelefono, FormateadorTelefono formateadorTelefono) {
        this.validadorTelefono = validadorTelefono;
        this.formateadorTelefono = formateadorTelefono;
    }

    public static void main(String[] args) {
        SpringApplication.run(PostWork5Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce el nombre: ");
        String nombre = teclado.nextLine();

        System.out.println("Introduce el telefono: ");
        String telefono = teclado.nextLine();

        if (validadorTelefono.isValido(telefono)) {
            telefono = validadorTelefono.limpiaNumero(telefono);
            telefono = formateadorTelefono.formatea(telefono);

            Persona persona = new Persona(nombre, telefono);

            System.out.println(persona);
        } else {
            System.out.println("introduce solo numeros validos");
        }
    }
}