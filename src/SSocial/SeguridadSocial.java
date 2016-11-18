package SSocial;

import java.util.List;
import java.util.ArrayList;

public class SeguridadSocial {
    private List<Persona> personasList;

    public SeguridadSocial() {
        personasList = new ArrayList<>();
    }

    // Debes comprobar que no se introduzcan dos personas con el mismo DNI/Número Seguridad Social
    public void altaPersona(Persona persona) {

        boolean repetida = false;
        for (Persona persona1 : personasList) {
            if (persona1.getDni().equals(persona.getDni())) repetida = true;

        }

        if (!repetida) {
            personasList.add(persona);
        } else {
            System.out.println("La persona introducida ya existe");
        }
    }

    public void bajaPersona(String dni) {
        personasList.removeIf(persona -> persona.getDni().equals(dni));
    }

    public Persona obtenerPersonaPorDNI(String dni) {

        for (Persona personaActual : personasList) {
            if (personaActual.getDni().equals(dni)) {
                return personaActual;
            }
        }
        return null;

    }

    public Persona obtenerPersonaPorNumSS(String numSS) {
        for (Persona personaActual : personasList) {
            if (personaActual.getNumSS().equals(numSS)) {
                return personaActual;
            }
        }
        return null;

    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max) {
        List<Persona> aux = new ArrayList<>();
        for (Persona personaActual : personasList) {
            if (personaActual.getSalario() <= max) {
                aux.add(personaActual);
            }
        }
        return aux;
    }

    public List<Persona> obtenerPersonasMayoresQue(int edad) {
        List<Persona> aux = new ArrayList<>();
        for (Persona personaActual : personasList) {
            if (personaActual.getEdad() > edad) {
                aux.add(personaActual);
            }
        }
        return aux;
    }

    public List<Persona> obtenerTodas() {

        List<Persona> aux = new ArrayList<>();
        for (Persona personaActual : personasList) {
            aux.add(personaActual);
        }
        return aux;
    }

    @Override
    public String toString() {
        return "SeguridadSocial{" +
                "personasList=" + personasList +
                '}';
    }
}
