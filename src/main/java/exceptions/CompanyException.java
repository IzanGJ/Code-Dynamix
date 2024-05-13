package exceptions;

import java.util.List;
import java.util.Arrays;

public class CompanyException extends Exception {

    public static final int EMPRESA_REPEAT = 0;
    public static final int PRODUCT_REPEAT = 1;
    public static final int NAME_EMPTY = 2;
    public static final int CIF_EMPTY = 3;
    public static final int WRONG_CIF = 4;
    public static final int EMPRESA_NOT_FOUND = 5;
    public static final int PRODUCT_NAME_EMPTY = 6;
    public static final int DESCRIPTION_EMPTY = 7;
    public static final int WEIGHT_ERROR = 8;
    public static final int PRICE_NOT_NUM = 9;
    public static final int WHEELS_NOT_NUM = 10;
    public static final int KEYBOARD_TYPE_ERROR = 11;
    public static final int KEYBOARD_LENGTH_ERROR = 12;
    public static final int MOUSE_BUTTONS_ERROR = 13;

    private final List<String> missatges = Arrays.asList(
        "*L'empresa ja estava registrada",
        "*El producte ja estava registrat",
        "*El nom de l'empresa no pot estar buit",
        "*El cif de l'empresa no pot estar biut",
        "*El cif introduït no és vàlid",
        "*No s'ha trobat cap empresa amb aquest CIF",
        "*El nom del producte no pot estar buit",
        "*La descripció del producte no pot estar buida",
        "*El pes del producte no és un enter",
        "*El preu del producte no és un número",
        "*Les rodes del producte no és un número",
        "*El tipus de teclat no és correcte",
        "*La longitud del teclat no és correcte",
        "*El número de botons del ratolí no és un número");
    
    private final int code;

    public CompanyException(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return missatges.get(code);
    }

}
