import java.util.Random;
import java.util.Scanner;

public class Practica {
    public static void main(String[] args) {
        // equals() Method
        String contrasena = "12345";
        if (contrasena.equals("12345")) {
            System.out.println("Acceso autorizado");
        } else {
            System.out.println("Contraseña incorrecta");
        }

        // format() method
        String nombre = "Cristian";
        int edad = 20;
        double valor = 55.9999;
        System.out.println(String.format("Mi nombre es %s, tengo %d años y hoy gasté %.2f dolares", nombre, edad, valor));

        // formatted with Text Blocks
        int aulas = 4;
        String msg = """
                Hola, %s!
                Bienvenido al curso de Java,
                Tendremos %d aulas para mostrarte lo que es necesario para que puedas tus primeros pasos en este lenguaje
                """.formatted(nombre, aulas);
        System.out.println(msg);

        // Casting: Convert one datatype in other datatype
        // Implicit Casting: The Compiler automatically converts in other datatype if it's compatible with the target data type
        int x = 10;
        double y = x; // Implicit Casting

        // Explicit Casting

        double x2 = 10.5;
        int y2 = (int) x2; // Explicit Casting

        // Desafio: Conversion de temperaturas
        double valorCelsius = 18.0;
        double valorFahrenheit = (valorCelsius * 1.8) + 32;
        String mensaje = String.format("La temperatura de %f Celsius es equivalente a %f Fahrenheit", valorCelsius, valorFahrenheit);
        System.out.println(mensaje);

        int temperaturaEnFahrenheitEntero = (int) valorFahrenheit;
        System.out.println("La temperatura en Fahrenheit entera es: " + temperaturaEnFahrenheitEntero);

        // Desafio: juego de adivinación
        Scanner teclado = new Scanner(System.in);
        double numero = 0;
        int numero_aleatorio = new Random().nextInt(10);
        for (int i = 0; i < 3; i++) {
            System.out.println("Ingresa un numero entre 1 y 100");
            numero = teclado.nextDouble();
            if (numero == numero_aleatorio){
                System.out.println("Acertaste!");
            } else {
                System.out.println("Numero equivocado!");
                if (numero_aleatorio > numero){
                    System.out.println("El numero es mayor");
                } else {
                    System.out.println("El numero es menor");
                }
            }
        }

    }
}
