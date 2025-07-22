import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Moneda(String base_code,
                     String target_code,
                     double conversion_rate,
                     double conversion_result,
                     LocalDateTime fechaConversion) {

    public Moneda(String base_code, String target_code, double conversion_rate, double conversion_result) {
        this(base_code, target_code, conversion_rate, conversion_result, LocalDateTime.now());
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format(
                "De %s a %s | Tasa: %.4f | Resultado: %.2f | Fecha: %s",
                base_code,
                target_code,
                conversion_rate,
                conversion_result,
                fechaConversion.format(formatter)
        );
    }
}