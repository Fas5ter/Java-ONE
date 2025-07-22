package com.alura.screenmatch.principal;

import com.alura.screenmatch.exceptions.ErrorEnConversionDeDuracionException;
import com.alura.screenmatch.modelos.Titulo;
import com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);

        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        while (true) {
            System.out.println("Escriba el nombre de la pelicula: ");
            var busqueda = lectura.nextLine();
//        var busqueda = URLEncoder.encode(lectura.nextLine());
//        var busqueda = lectura.nextLine().replaceAll(" ", "+");
            // Interfaz<> n = new clase<>();
            if (busqueda.equalsIgnoreCase("salir")) {
                break;
            }


            String direccion = "http://www.omdbapi.com/?t=" + URLEncoder.encode(busqueda) + "&apikey=e13e1ea8";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
//                  .uri(URI.create("http://www.omdbapi.com/?t=matrix&y=1993&plot=full&r=json&apikey=e13e1ea8"))
//                  .uri(URI.create("https://swapi.py4e.com/api/films/"+numeroDePelicula+"/");)
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

        /* try catch finally blocks
        try {
            metodoQuePuedeLanzarExcepcion();
            System.out.println("Se ejecutó");
        } catch (Exception e) {
            System.out.println("Dio un error!");
        } finally {
            System.out.println("Finalizó!");
        }*/

        /* Jerarquia de excepciones
        try{
            //Ejemplo de un código a ser ejecutado
        }catch(RuntimeException e){
            //Van a entrar las excepciones que sean del tipo RuntimeException o hijas de ella,
            // pero no las del tipo Exception (que es la madre de RuntimeException)
        }catch (Exception e){
            //Van a entrar todas las excepciones del tipo Exception o hijas de ella
            //incluida las excepciones del tipo RuntimeException
        }*/

            try {
                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(miTituloOmdb);

                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido: " + miTitulo);

                FileWriter escritura = new FileWriter("peliculas.txt");
                escritura.write(miTitulo.toString());
                escritura.close();

                /*
                 * La clase File tiene varios métodos útiles para interactuar con archivos y directorios,
                 *  como exists(), canRead(), canWrite(), isDirectory(), isFile(), mkdir() y delete().
                 * */
//                File file = new File("C:\\miArchivo.txt");

                /*
                 * Las clases FileReader y FileWriter se utilizan para leer y escribir datos en archivos de texto;
                 * la clase FileReader lee caracteres de un archivo de texto, mientras que la clase FileWriter escribe los caracteres.
                 * */

                /*FileReader reader = new FileReader(file);
                int data = reader.read();
                while (data != -1) {
                    System.out.println((char) data);
                    data = reader.read();
                }

                File file2 = new File("C:\\salida.txt");
                FileWriter writer = new FileWriter(file2);
                writer.write("Hola mundo!");
                writer.close();*/

                /*
                 * BufferedReader y BufferedWriter: se utilizan para leer y escribir archivos de texto de manera eficiente,
                 * leyendo y escribiendo una línea a la vez. Utilizan un búfer para almacenar datos, lo que hace que la lectura
                 * y la escritura sean más rápidas que cuando se hacen de un carácter a la vez;
                 *
                 * FileInputStream y FileOutputStream: se utilizan para leer y escribir datos binarios en un archivo.
                 * Se utilizan para leer y escribir datos en archivos que no son de texto, como imágenes y archivos de audio;
                 *
                 * ObjectInputStream y ObjectOutputStream: se utilizan para leer y escribir objetos en archivos.
                 * Esto le permite almacenar objetos Java en archivos para su uso posterior o para transferirlos entre diferentes aplicaciones.
                 * */

                // Multi-catch
//        } catch (NullPointerException | IllegalArgumentException e) {
//            System.out.println("tratando error...");
                titulos.add(miTitulo);
            } catch (NumberFormatException e) {
                System.out.println("Ocurrió un error.");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección.");
                System.out.println(e.getMessage());
            } catch (ErrorEnConversionDeDuracionException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(titulos);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();

        System.out.println("Finalizó la ejecución del programa");
    }
}
