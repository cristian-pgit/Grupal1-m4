package grupalEvaluacion;

public class Huevo {
	
	private int x;
	private int y;
	
	public Huevo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Huevo cayo en (x)" + x + ", (y) " + y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void mostrarHuevo() {
		System.out.println(toString());
	}
}
