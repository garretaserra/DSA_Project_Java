import java.util.*;

public class Mundo {

    public Map<String, Usuario> usuarios = new HashMap<>();
    Mapa[] mapas;

    public Mundo(int mapas){
        this.mapas = new Mapa[mapas];
    }

    //usuario
    public boolean crearUsuario(Usuario u){
        if(usuarios.containsKey(u.getNombre()))
            return false;
        else{
            usuarios.put(u.getNombre(), u);
            return true;
        }
    }
    public boolean eliminarUsuario(String nombre){
        if(usuarios.remove(nombre) == null){
            return false;
        }
        return true;
    }
    public Usuario consultarUsuario(String nombre){
        return usuarios.get(nombre);
    }

    //objeto
    public void añadirObjetoAUsuario(Usuario u, Objeto o){
        usuarios.get(u.getNombre()).inventario.add(o);
    }
    public LinkedList consultarObjetosDeUsuario(Usuario u){
        return u.inventario;
    }
    public Objeto consultarObjetoDeUsuario(Usuario u, String nombreObjeto){
        for(Objeto o : u.inventario)
            if(o.nombre.equals(nombreObjeto))
                return o;
        return null;
    }
    public boolean eliminarObjetoDeUsuario(Usuario u, String nombreObjeto){
        for(Objeto o : u.inventario)
            if(o.nombre.equals(nombreObjeto)){
                u.inventario.remove(o);
                return true;
            }
        return false;
    }
    public void transferirObjetoEntreUsuarios(Usuario origen, Usuario destino, Objeto o){
        if(origen.inventario.remove(o))
            destino.inventario.add(o);
    }
}
