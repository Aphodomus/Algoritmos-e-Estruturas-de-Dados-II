public class Cliente {
    //Atributos
    private int codigo;
    private String nome;

    //Metodos especiais
    public Cliente() {
        this.codigo = 0;
        this.nome = "";
    }

    public Cliente(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Metodos
    public Cliente clone() {
        Cliente resp = new Cliente();

        resp.codigo = this.codigo;
        resp.nome = this.nome;

        return resp;
    }
}
