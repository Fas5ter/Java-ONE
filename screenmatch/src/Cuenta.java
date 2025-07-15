public class Cuenta {
    /* Podemos declarar el atributo saldo como protected para evitar esta situación
     y permitir el acceso directo a él desde las clases que heredan de la clase Cuenta: */
    protected double saldo;
    public void retirar(double valor){
        saldo -= valor;
        System.out.println("El nuevo saldo es: " + saldo);
    }

    /*Para guardar un nuevo usuario, se realizan varias validaciones, como por
     ejemplo: Ver si el nombre:
     solo contiene letras,
     la IDENTIDAD solo números y
     ver si el usuario tiene al menos 18 años.
     Aquí está el método que hace esta validación:*/

//    public boolean usuarioValido(Usuario usuario){
//        if(!usuario.getNombre().matches("[a-zA-Záàâãéèêíïóôõöúçñ\\s]+")){
//            return false;
//        }
//        if(!usuario.getIdentidad().matches("[^0-9]+")){
//            return false;
//        }
//        return Period.between(usuario.getFechaNacimiento(), LocalDate.now()).getYears() >= 18;
//    }
}


// Polimorfismo de interfaces
/*
interface Figura {
    double calcularArea();
}

class Circulo implements Figura {
    double radio;

// Constructor
    Circulo(double radio) {
        this.radio = radio;
    }

    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

class Rectangulo implements Figura {
    double longitud, ancho;

// Constructor
    Rectangulo(double longitud, double ancho) {
        this.longitud = longitud;
        this.ancho = ancho;
    }

    public double calcularArea() {
        return longitud * ancho;
    }
}

public class Main {
    public static void main(String[] args) {
        Figura figura1 = new Circulo(5.0);
        Figura figura2 = new Rectangulo(4.0, 3.0);

        System.out.println("Área del círculo: " + figura1.calcularArea()); // Salida: Área del círculo: 78.54
        System.out.println("Área del rectángulo: " + figura2.calcularArea()); // Salida: Área del rectángulo: 12.0
    }
}
 */
