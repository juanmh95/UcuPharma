package ucupharma;

public class Almacen<E> implements IAlmacen<E> {

    private IProducto<E> primero;

    public Almacen() {
        primero = null;
    }

    public Almacen(IProducto<E> unProducto) {
        this.primero = unProducto;
    }

    public void insertar(IProducto<E> unProducto) {
        if (esVacia()) {
            primero = unProducto;
        } else {
            IProducto<E> aux = primero;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(unProducto);
        }
    }

    public IProducto<E> buscar(Comparable clave) {
        if (esVacia()) {
            return null;
        } else {
            IProducto<E> aux = primero;
            while (aux != null) {
                if (aux.getEtiqueta().equals(clave)) {
                    return aux;
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    public boolean eliminar(Comparable clave) {
        if (esVacia()) {
            return false;
        }
        if (primero.getSiguiente() == null) {
            if (primero.getEtiqueta().equals(clave)) {
                primero = null;
                return true;
            }
        }
        IProducto<E> aux = primero;
        if (aux.getEtiqueta().compareTo(clave) == 0) {
            //Eliminamos el primer elemento
            IProducto<E> temp1 = aux;
            IProducto<E> temp = aux.getSiguiente();
            primero = temp;
            return true;
        }
        while (aux.getSiguiente() != null) {
            if (aux.getSiguiente().getEtiqueta().equals(clave)) {
                IProducto<E> temp = aux.getSiguiente();
                aux.setSiguiente(temp.getSiguiente());
                return true;

            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public String imprimir() {
        String aux = "";
        if (!esVacia()) {
            IProducto<E> temp = primero;
            while (temp != null) {
                temp.imprimirEtiqueta();
                temp = temp.getSiguiente();
            }
        }
        return aux;
    }

    public String imprimir(String separador) {
        String aux = "";
        if (esVacia()) {
            return "";
        } else {
            IProducto<E> temp = primero;
            aux = "" + temp.getEtiqueta();
            while (temp.getSiguiente() != null) {
                aux = aux + separador + temp.getSiguiente().getEtiqueta();
                temp = temp.getSiguiente();
            }

        }
        return aux;

    }

    public int cantElementos() {
        int contador = 0;
        if (esVacia()) {
            System.out.println("Cantidad de elementos 0.");
            return 0;
        } else {
            IProducto aux = primero;
            while (aux != null) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    public boolean esVacia() {
        return primero == null;
    }

    public IProducto<E> getPrimero() {
        return primero;
    }
    
    public void setPrimero(IProducto<E> nodo)   {
        IProducto<E> aux = this.getPrimero();
        this.primero = nodo;
        nodo.setSiguiente(aux);
    }
    
    
    
    public IProducto<E> eliminarPrimero(){
        if (!esVacia()){
            IProducto<E> elem = this.primero;
            this.eliminar(elem.getEtiqueta());
            return elem;
        } 
        else {
            return null;
        }
    }
    
    public Almacen<E> OrdenarporInsercion(){
        Almacen<E> l2 = new Almacen<>();
        IProducto<E> elem = eliminarPrimero();
        while (!this.esVacia()){
            l2.insertarOrdenado(elem);
            elem = eliminarPrimero();
        }
        return l2;
    }
    
    public void insertarOrdenado(IProducto<E> elem){
        IProducto<E> aux = getPrimero();
        if (aux == null){
            insertar(elem);
        } else {
            if (elem.compareTo(aux.getEtiqueta()) == -1){
                setPrimero(elem);
            } else {
                IProducto<E> aux2 = getPrimero();
                while (aux2.getSiguiente() != null) {
                    if (aux2.getSiguiente().compareTo(elem.getEtiqueta()) >= 0) {
                        elem.setSiguiente(aux2.getSiguiente());
                        aux2.setSiguiente(elem);
                        return;
                    } else {
                        aux2 = aux2.getSiguiente();
                    }
                }
                aux2.setSiguiente(elem);
            }    
        }
        
    }
    
}
