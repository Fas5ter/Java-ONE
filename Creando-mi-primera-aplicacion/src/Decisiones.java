public class Decisiones {
    public static void main(String[] args) {
        int fechaDeLanzamiento = 1999;
        boolean incluidoEnElPlan = true;
        double notaDeLaPelicula = 8.2;
        String tipoPlan = "plus";

        // Codigo que prueba los operadores relacionales
        if (fechaDeLanzamiento >= 2022){
            System.out.println("Peliculas más populares");
        } else{
            System.out.println("Pelicula Retro que aún vale la pena ver");
        }

        if (incluidoEnElPlan || tipoPlan == "plus"){
            System.out.println("Disfrute de su pelicula");
        } else {
            System.out.println("Pelicula no disponible para su plan actual");
        }

        int dia = 3;
        switch (dia){
            case 1:
                System.out.println("El dia 1 es lunes");
                break;
            case 2:
                System.out.println("El dia 2 es martes");
                break;
            case 3:
                System.out.println("El dia 1 es miercoles");
                break;
            case 4:
                System.out.println("El dia 1 es jueves");
                break;
            case 5:
                System.out.println("El dia 1 es viernes");
                break;
            case 6:
                System.out.println("El dia 1 es sabado");
                break;
            case 7:
                System.out.println("El dia 1 es domingo");
                break;
            default:
                System.out.println("Dia no valido");
        }
    }
}
