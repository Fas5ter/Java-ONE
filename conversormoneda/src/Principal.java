import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Principal {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Moneda> historialDeConversiones =  new ArrayList<>();
        String menu = """
                #####################################################
                
                Bienvenid@ al Conversor de Moneda $ :D
                
                1) Dolar [USD] =>> Peso Argentino [ARS]
                2) Peso Argentino [ARS] =>> Dolar [USD]
                3) Dolar [USD] =>> Real brasileño [BRL]
                4) Real brasileño [BRL] =>> Dolar [USD]
                5) Dolar [USD] =>> Peso Colombiano [COP]
                6) Peso Colombiano [COP] =>> Dolar [USD]
                7) Dolar [USD] =>> Peso Mexicano [MXN]
                8) Peso Mexicano [MXN] =>> Dolar [USD]
                9) Salir
                Elija una opción válida:
                #####################################################
                """;

        Scanner entrada = new Scanner(System.in);
        Conversor conversor = new Conversor();

        while (true) {
            try {
                clearScreen();
                System.out.println(menu);
                int opcion = Integer.parseInt(entrada.nextLine());

                if (opcion == 9) {
                    System.out.println("Finalizando programa...");
                    break;
                }

                double cantidad;
                Moneda resultado;

                switch (opcion) {
                    case 1 -> {
                        System.out.println("Ingresa la cantidad de dólares: ");
                        cantidad = Double.parseDouble(entrada.nextLine());
                        resultado = conversor.dolarToPesoArg(cantidad);
                        System.out.println(resultado);
                    }
                    case 2 -> {
                        System.out.println("Ingresa la cantidad de pesos argentinos: ");
                        cantidad = Double.parseDouble(entrada.nextLine());
                        resultado = conversor.pesoArgToDolar(cantidad);
                        System.out.println(resultado);
                    }
                    case 3 -> {
                        System.out.println("Ingresa la cantidad de dólares: ");
                        cantidad = Double.parseDouble(entrada.nextLine());
                        resultado = conversor.dolarToRealBrasileno(cantidad);
                        System.out.println(resultado);
                    }
                    case 4 -> {
                        System.out.println("Ingresa la cantidad de reales brasileños: ");
                        cantidad = Double.parseDouble(entrada.nextLine());
                        resultado = conversor.realBrasilenoToDolar(cantidad);
                        System.out.println(resultado);
                    }
                    case 5 -> {
                        System.out.println("Ingresa la cantidad de dólares: ");
                        cantidad = Double.parseDouble(entrada.nextLine());
                        resultado = conversor.dolarToPesoColombiano(cantidad);
                        System.out.println(resultado);
                    }
                    case 6 -> {
                        System.out.println("Ingresa la cantidad de pesos colombianos: ");
                        cantidad = Double.parseDouble(entrada.nextLine());
                        resultado = conversor.pesoColombianoToDolar(cantidad);
                        System.out.println(resultado);
                    }
                    case 7 -> {
                        System.out.println("Ingresa la cantidad de dólares: ");
                        cantidad = Double.parseDouble(entrada.nextLine());
                        resultado = conversor.dolarToPesoMexicano(cantidad);
                        System.out.println(resultado);
                    }
                    case 8 -> {
                        System.out.println("Ingresa la cantidad de pesos mexicanos: ");
                        cantidad = Double.parseDouble(entrada.nextLine());
                        resultado = conversor.pesoMexicanoToDolar(cantidad);
                        System.out.println(resultado);
                    }
                    default -> {
                        System.out.println("Opción inválida");
                        TimeUnit.SECONDS.sleep(2);
                        clearScreen();
                        continue;
                    }
                }
                historialDeConversiones.add(resultado);
                // Pausa para ver el resultado antes de limpiar pantalla
                System.out.println("\nPresione Enter para continuar...");
                entrada.nextLine();

            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Operación interrumpida");
            }
        }

        entrada.close();
        try {
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(historialDeConversiones);
            System.out.println("Historial de conversiones generado correctamente.");
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
}