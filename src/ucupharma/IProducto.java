package ucupharma;

public interface IProducto<E> {

    /**
     * Retorna el dato contenido en el nodo.
     *
     * @return Dato contenido en el nodo.
     */
    public E getDato();

    /**
     * Asigna un dato al nodo.
     *
     * @param dato a asignar.
     */
    public void setDato(E dato);

    /**
     * Asigna el siguiente nodo al nodo actual.
     *
     * @param nodo Nodo a asignar como siguiente.
     */
    public void setSiguiente(IProducto<E> nodo);

    /**
     * Retorna el siguiente nodo al nodo actual.
     *
     * @return Siguiente nodo del actual
     */
    public IProducto<E> getSiguiente();

    /**
     * Imprime los datos del nodo
     */
    public void imprimir();

    /**
     * Imprime la etiqueta del nodo
     */
    public void imprimirEtiqueta();

    /**
     *
     * @param unNodo
     * @return si son iguales, por la clave
     */
    public boolean equals(IProducto<E> unNodo);

    /**
     * Retorna la etiqueta del nodo
     *
     * @return etiqueta del nodo
     */
    public Comparable getEtiqueta();
//	/**
//	 *
//	 * @param unNodo
//	 * @return devueve -1 si this tiene una clave menor, 0 si son iguales, 1 si es mayor
//	 */
//	public int compareTo(INodo<E> unNodo);

    /**
     *
     * @param etiqueta
     * @return devueve -1 si this tiene una etiqueta menor, 0 si son iguales, 1
     * si es mayor
     */
    public int compareTo(Comparable etiqueta);
}
