public record Moneda(String base_code,
                     String target_code,
                     double conversion_rate,
                     double conversion_result) {
    @Override
    public String toString() {
        return "Moneda actual= " + base_code +
                ", Moneda a convertir= " + target_code +
                ", Conversión actual => 1 " + "[" + base_code + "]" + "= " + conversion_rate + "[" + target_code + "]" +
                ", Resultado = " + conversion_result + "[" + target_code + "]";
    }
}
