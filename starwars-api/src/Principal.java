import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        List<Pelicula> titulos = new ArrayList<>();

        String menu = """
                #### Buscador de títulos de Star Wars con la API de Star Wars (SWAPI) ####
                * Para salir digite 0.
                Ingrese el número de la película:""";
        while (true) {
            System.out.println(menu);
            var busqueda = lectura.nextLine();
            if (busqueda.equalsIgnoreCase("0")) {
                break;
            }
            try {
                ConsultaPelicula consulta = new ConsultaPelicula();
                Pelicula pelicula = consulta.buscaPelicula((Integer.parseInt(busqueda)));
//                System.out.println(pelicula);
                titulos.add(pelicula);

            } catch (NumberFormatException e) {
                System.err.println("Error al buscar la película: " + e.getMessage());
            } catch (RuntimeException e) {
                System.err.println(e.getMessage());
                System.err.println("Finalizando la aplicacion");
            }
        }
        System.out.println(titulos);
        try {
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            generador.guardarJson(titulos);
        } catch (IOException e){
            System.err.println(e.getMessage());
        }


    }
}
