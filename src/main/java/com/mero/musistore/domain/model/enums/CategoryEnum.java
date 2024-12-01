package com.mero.musistore.domain.model.enums;

public enum CategoryEnum {

    INSTRUMENTO(1, "Instrumento"),
    ACESSORIO(2, "Acessorio"),
    AMPLIFICADOR(3, "Amplificador");

    private final int code;
    private final String description;

    CategoryEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static CategoryEnum getByCode(int code) {
        for (CategoryEnum status : CategoryEnum.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return null;
    }
}
