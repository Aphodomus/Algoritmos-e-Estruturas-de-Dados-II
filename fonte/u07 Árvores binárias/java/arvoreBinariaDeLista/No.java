
class No {
	public Celula primeiro, ultimo;
	public No esq, dir;
	public char letra;
	
	public No(char letra) {
		this.letra = letra;
		this.esq = this.dir = null;
		primeiro = ultimo = new Celula();
	}
}
