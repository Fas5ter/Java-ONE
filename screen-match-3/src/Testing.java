import java.util.ArrayList;

public class Testing {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Andrea");
        nombres.add("Bruno");
        nombres.add("Darío");
        nombres.add("Emilia");

        for (String nombre : nombres) {
            System.out.println(nombre);
        }

//        nombres.forEach(nombre -> System.out.println(nombre));
        // Method reference
        nombres.forEach(System.out::println);

        /*Una cuestión importante relacionada con las referencias a objetos en Java
         es la cuestión de la igualdad e identidad de los objetos. Cuando comparas dos
          referencias de objetos usando el operador de igualdad ==, estás comparando las
           referencias en sí, no los objetos a los que apuntan.
           Por ejemplo: La salida será "Diferentes"*/
//        Pelicula pelicula1 = new Pelicula("Avatar", 2009);
//        Pelicula pelicula2 = new Pelicula("Avatar", 2009);
//
//        if (pelicula1 == pelicula2) {
//            System.out.println("Iguales");
//        } else {
//            System.out.println("Diferentes");
//        }
    }
}
