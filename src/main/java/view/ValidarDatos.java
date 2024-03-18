package view;

public class ValidarDatos {
    public static boolean esCifValido(String cif) {
        if (cif == null || cif.length() != 9) {
            return false;
        }

        if (Character.isLetter(cif.charAt(0)) == false) {
            return false;
        }

        for (int i = 1; i < 7; i++) {
            if (Character.isDigit(cif.charAt(i)) == false) {
                return false;
            }
        }

        char ultimoCaracter = cif.charAt(8);
        if (Character.isLetterOrDigit(ultimoCaracter) == false) {
            return false;
        }

        return true;
    }
}
