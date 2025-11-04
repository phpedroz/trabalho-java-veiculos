import java.util.ArrayList;
import java.io.*;

public class MarcaBanco {

    private final ArrayList<Marca> lista = new ArrayList<>();

    public void inserir(Marca m){
        lista.add(m);
    }

    public void alterar(Marca m) throws Exception {
        Marca x = pesquisar(m.getId());
        if(x == null) throw new Exception("Marca não encontrada!");
        x.setNome(m.getNome());
        x.setObservacoes(m.getObservacoes());
    }

    public void excluir(int id) throws Exception {
        Marca x = pesquisar(id);
        if(x == null) throw new Exception("Marca não encontrada!");
        lista.remove(x);
    }

    public Marca pesquisar(int id){
        for(Marca m : lista){
            if(m.getId() == id) return m;
        }
        return null;
    }

    public ArrayList<Marca> imprimirTodos(){
        return lista;
    }

    public int quantidade(){
        return lista.size();
    }

    // SALVAR EM TXT
    public void salvarArquivo() throws Exception {
        try (FileWriter fw = new FileWriter("marcas.txt");
             PrintWriter pw = new PrintWriter(fw)) {

            for(Marca m : lista){
                pw.println(m.getId() + ";" + m.getNome() + ";" + m.getObservacoes());
            }
        }
    }

    // CARREGAR TXT
    public void carregarArquivo() throws Exception {
        File file = new File("marcas.txt");
        if(!file.exists()) return;

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String linha;
            while((linha = br.readLine()) != null){
                String[] partes = linha.split(";");

                Marca m = new Marca();
                m.setId(Integer.parseInt(partes[0]));
                m.setNome(partes[1]);
                m.setObservacoes(partes.length > 2 ? partes[2] : "");

                lista.add(m);
            }
        }
    }
}