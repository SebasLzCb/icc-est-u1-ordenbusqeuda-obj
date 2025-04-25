package Controllers;
import Models.Persona;

// 
public class PersonaController {
    // Método de ordenamiento seleccion desecendente
    public void sortByDireccionCodigo(Persona[] personas) {
        for (int i = 0; i < personas.length - 1; i++) {
            int indexMenor = i;
            for (int j = i + 1; j < personas.length; j++) {
                if (personas[j].getCodigoDireccion() < personas[indexMenor].getCodigoDireccion()) {
                    indexMenor = j;
                }
            }
            if (i != indexMenor) {
                Persona aux = personas[i];
                personas[i] = personas[indexMenor];
                personas[indexMenor] = aux;
            }
        }
    }
    

    public Persona findPersonByCodigoDireccion(Persona[] personas, int codigo) {
        int bajo = 0;
        int alto = personas.length - 1;

        while (bajo <= alto) {
            int center = (bajo + alto) / 2;
            if (personas[center].equalsByCodigoDireccion(codigo)) {
                return personas[center];
            } 
            /// ACABAR USANDO EL METODO CUSTOM de compareCodigoDireccion
            else if (personas[center].getCodigoDireccion() < codigo) {
                bajo = center + 1;
            } else {
                alto = center - 1;
            }
        }
        // Si no se encuentra la persona, se puede devolver null o lanzar una excepción
        return null;
    }
}
