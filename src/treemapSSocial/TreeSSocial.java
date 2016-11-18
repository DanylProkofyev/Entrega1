package treemapSSocial;

import SSocial.Persona;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

public class TreeSSocial {
    private TreeMap<String, Persona> treeMapDni = new TreeMap<>();
    private TreeMap<String, Persona> treeMapSs = new TreeMap<>();

    public void altaPersona(Persona persona) {

        if (!treeMapDni.containsKey(persona.getDni()) && !treeMapSs.containsKey(persona.getNumSS())) {
            treeMapDni.put(persona.getDni(), persona);
            treeMapSs.put(persona.getNumSS(), persona);
        }
    }

    public void bajaPersona(String dni) {

        Persona persona = treeMapDni.get(dni);
        if (persona != null) {
            treeMapDni.remove(persona.getDni());
            treeMapSs.remove(persona.getNumSS());
        }
    }

    public Persona obtenerPersonaPorNumSS(String numSS) {
        return treeMapSs.get(numSS);
    }

    public Persona obtenerPersonaPorDNI(String dni) {
        return treeMapDni.get(dni);
    }

    public Collection<Persona> obtenerTodas() {
        return treeMapDni.values();
    }

    public Collection<Persona> obtenerPersonasRangoSalarial(double min, double max) {
        List<Persona> aux = new ArrayList<>();
        for (Persona p : treeMapDni.values()) {
            if (p.getSalario() >= min && p.getSalario() <= max) {
                aux.add(p);
            }
        }
        return aux;
    }

    public Collection<Persona> obtenerPersonasMayoresQue(int edad) {
        List<Persona> aux = new ArrayList<>();
        for (Persona p : treeMapDni.values()) {
            if (p.getEdad() > edad) {
                aux.add(p);
            }
        }
        return aux;
    }
}
