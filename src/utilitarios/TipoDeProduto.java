package utilitarios;

public enum TipoDeProduto {
    ACOUGUE(1),
    HORTIFRUTI(2),
    LIMPEZA(3),
    HIGIENE(4),
    ELETRODOMESTICO(5),
    PERECIVEL(6),
    NAO_PERECIVEL(7),
    ADULTO(8),
    PARA_PET(9);

    private final int value;

    TipoDeProduto(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
    public static TipoDeProduto getPorValor(int valor) {
        for (TipoDeProduto tipo : TipoDeProduto.values()) {
            if (tipo.value == valor) {
                return tipo;
            }
        }

        return null;
    }
}
