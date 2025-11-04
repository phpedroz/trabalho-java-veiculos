public class Marca {

    private int id;
    private String nome;
    private String observacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if(id <= 0){
            throw new Exception("Código não pode ser negativo ou zero!");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(nome == null || nome.trim().length() < 3){
            throw new Exception("Nome não pode ser nulo, vazio ou menor que 3 caracteres!");
        }
        this.nome = nome;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Obs: " + observacoes;
    }
}
