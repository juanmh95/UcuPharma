package ucupharma;

public class Producto<T> implements IProducto<T> {

    private final Comparable id;
    private T dato;
    private IProducto<T> siguiente = null;

    public Producto(T dato, Comparable id) {
        this.dato = dato;
        this.id = id;
    }

    public T getDato() {
        return this.dato;
    }

    public void setDato(T dato) {
        this.dato = dato;

    }

    public Comparable getEtiqueta() {
        return this.id;
    }

    public void setSiguiente(IProducto<T> nodo) {
        this.siguiente = nodo;

    }

    public IProducto<T> getSiguiente() {
        return this.siguiente;
    }

    public void imprimir() {
        System.out.println(dato.toString());
    }

//    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.id);
    }

    public IProducto<T> clonar() {
        return new Producto<T>(this.dato, this.id);
    }

//    @Override
    public boolean equals(IProducto<T> unNodo) {
        return this.dato.equals(unNodo.getDato());
    }

//    @Override
    public int compareTo(Comparable id) {
        return this.id.compareTo(id);
    }
}
