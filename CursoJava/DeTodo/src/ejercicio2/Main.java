package ejercicio2;

public class Main {
	public static void main(String[] args) {
		Articulo articulo=new Articulo("Camiseta",15,0.20,0.17);
		System.out.println(articulo.toString());
		System.out.println(articulo.precioFinal());;
		System.out.println(articulo.descuentoAplicado()+"€");
	}
}
