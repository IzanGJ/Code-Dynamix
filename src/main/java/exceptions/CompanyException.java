package exceptions;

import java.util.List;
import java.util.Arrays;

public class CompanyException extends Exception {

    public static final int EMPRESA_REPEAT = 0;
    public static final int NEGATIVE_NUM = 1;
    public static final int NAME_EMPTY = 2;
    public static final int CIF_EMPTY = 3;
    public static final int WRONG_CIF = 4;
    public static final int EMPRESA_NOT_FOUND = 5;

    private final List<String> missatges = Arrays.asList(
        "*Ya hi ha una empresa amb aquest CIF",
        "< ERROR 002: Número fora de rang>",
        "*El nom de l'empresa no pot estar buit",
        "*El cif de l'empresa no pot estar buit",
        "*El cif introduït no es vàlid",
        "No s'ha trobat cap empresa amb aquest CIF");
    
    private final int code;

    public CompanyException(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return missatges.get(code);
    }

}
