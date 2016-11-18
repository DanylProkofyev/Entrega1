package HashSSocial;

import SSocial.Persona;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SeguridadSocialHashmap {
    private Map<String, Persona> PersonaMapDni = new HashMap<>();
    private Map<String, Persona> PersonaMapSs = new HashMap<>();

    public void altaPersona(Persona persona) {
        if (!PersonaMapDni.containsKey(persona.getDni()) && !PersonaMapSs.containsKey(persona.getNumSS())) {
            PersonaMapDni.put(persona.getDni(), persona);
            PersonaMapSs.put(persona.getNumSS(), persona);
        }
    }

    public void bajaPersona(Persona persona) {
        if (PersonaMapDni.containsKey(persona.getDni())) {
            PersonaMapDni.remove(persona);
            PersonaMapSs.remove(persona.getNumSS());
        }
    }

    public Persona obtenerPersonaPorNumSS(String numSS) {

        return PersonaMapSs.get(numSS);
    }

    public Persona obtenerPersonaPorDni(String dni) {

        return PersonaMapDni.get(dni);
    }

    public List<Persona> obtenerPersonasRangoSalarial(double min, double max) {
        return PersonaMapDni.values().parallelStream().filter(persona -> persona.getSalario() >= min).collect(Collectors.toList());

    }

    public List<Persona> obtenerTodas() {
        List<Persona> aux = new ArrayList<>();
        for (Persona p : PersonaMapDni.values()) {
            aux.add(p);
        }
        return aux;
    }

    public List<Persona> obtenerPersonasMayoresQue(int edad) {
        List<Persona> aux = new ArrayList<>();
        for (Persona p : PersonaMapDni.values()) {
            if (p.getEdad() > edad) {
                aux.add(p);
            }
        }
        return aux;
    }

    public List<Persona> obtenerPersonaPorDNI(String Dni) {
        List<Persona> aux = new ArrayList<>();
        for (Persona p : PersonaMapDni.values()) {
            if (p.getDni().equalsIgnoreCase(Dni)) {
                aux.add(p);
            }
        }
        return aux;
    }
}