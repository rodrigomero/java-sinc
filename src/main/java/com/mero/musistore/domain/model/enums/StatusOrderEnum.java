package com.mero.musistore.domain.model.enums;

public enum StatusOrderEnum {

    CONFIRMADO(1, "Confirmado"),
    PENDENTE(2, "Pagamento Pendente"),
    PAGO(3, "Pago"),
    ENTREGUE(4, "Entregue"),
    CANCELADO(5, "Cancelado");

    private final int code;
    private final String description;

    StatusOrderEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static StatusOrderEnum getByCode(int code) {
        for (StatusOrderEnum status : StatusOrderEnum.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return null;
    }
}
