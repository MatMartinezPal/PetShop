package models;

public class PedidoProducto {

    public static int contador_ids = 0;

    private int id;
    private int cantidad;
    private Pedido pedido;
    private Producto producto;
    private float subtotal;

    public PedidoProducto(int cantidad, Pedido pedido, Producto producto, float subtotal) {
        PedidoProducto.contador_ids += 1;
        this.id = PedidoProducto.contador_ids;
        this.setCantidad(cantidad);
        this.setPedido(pedido);
        this.setProducto(producto);
        this.setSubtotal(subtotal);
    }

    public PedidoProducto(int cantidad, Pedido pedido, Producto producto) {
        PedidoProducto.contador_ids += 1;
        this.id = PedidoProducto.contador_ids;
        this.setCantidad(cantidad);
        this.setPedido(pedido);
        this.setProducto(producto);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
        this.pedido.getLista_pedidos_producto().add(this);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        this.producto.getLista_pedidos_producto().add(this);
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public static void borrarProductoDeCarritoCompras(int id_producto, Pedido pedido_pendiente) {
        for (PedidoProducto item_carrito : pedido_pendiente.getLista_pedidos_producto()) {
            if (item_carrito.getProducto().getId() == id_producto) {
                pedido_pendiente.getLista_pedidos_producto().remove(item_carrito);
                return;
            }
        }

    }
    
    public static boolean validarExistenciaCarrito (int id_producto, Pedido pedido_pendiente){
        
        for (PedidoProducto itemCarritoActual: pedido_pendiente.getLista_pedidos_producto()){
            if (itemCarritoActual.getProducto().getId() == id_producto){
                return false;
            }
        }
        
        return true;
        
    }

}
