import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

// Herencia multiple
//public class CuentaAhorro extends Cuenta, Pago
// Jerarquia de clases
// public class CuentaCorriente extends CuentaAhorro

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula();
        System.out.println(miPelicula);
        miPelicula.setNombre("Encanto");
        miPelicula.setFechaDeLanzamiento (2021);
        miPelicula.setDuracionEnMinutos(120);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(7.8);
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        System.out.println(miPelicula.getSumaDeLasEvaluaciones());
        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        Pelicula otraPelicula = new Pelicula();
        System.out.println(otraPelicula);
        otraPelicula.setNombre("Matrix");
        otraPelicula.setFechaDeLanzamiento (1998);
        otraPelicula.setDuracionEnMinutos(180);
//        miPelicula.muestraFichaTecnica();

        System.out.println("***************************************");
        Serie casaDragon = new Serie();
        casaDragon.setNombre("La casa del Dragón");
        casaDragon.setFechaDeLanzamiento(2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        //System.out.println(casaDragon.getDuracionEnMinutos());

        CalculadoraDeTiempo calculadoraDeTiempo = new CalculadoraDeTiempo();
        calculadoraDeTiempo.incluye(miPelicula);
        calculadoraDeTiempo.incluye(casaDragon);
        calculadoraDeTiempo.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver tus titulos favoritos estas vacaciones: "+ calculadoraDeTiempo.getTiempoTotal() + " min");

        FiltroRecomendacion filtroRecomendacion = new FiltroRecomendacion();
        filtroRecomendacion.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa Targaryen");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(80);

        filtroRecomendacion.filtra(episodio);
    }
}
