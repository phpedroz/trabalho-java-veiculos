import java.util.Scanner;

public class Menu {

    private static final MarcaBanco banco = new MarcaBanco();
    private static final Scanner sc = new Scanner(System.in);

    public static void mostrar() throws Exception {

        banco.carregarArquivo(); // <--- carrega marcas do txt 

        int op = -1;

        while(op != 0){
            System.out.println("\n--- MENU MARCAS ---");
            System.out.println("1 - Inserir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Pesquisar");
            System.out.println("5 - Imprimir todos");
            System.out.println("6 - Quantidade");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            op = Integer.parseInt(sc.nextLine());

            switch (op){
                case 1 -> inserir();
                case 2 -> alterar();
                case 3 -> excluir();
                case 4 -> pesquisar();
                case 5 -> imprimirTodos();
                case 6 -> System.out.println("Total: " + banco.quantidade());
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    private static void inserir() throws Exception {
        Marca m = new Marca();
        System.out.print("ID: ");
        m.setId(Integer.parseInt(sc.nextLine()));
        System.out.print("Nome: ");
        m.setNome(sc.nextLine());
        System.out.print("Observações: ");
        m.setObservacoes(sc.nextLine());

        banco.inserir(m);
        banco.salvarArquivo();

        System.out.println("✅ Marca inserida com sucesso!");
    }

    private static void alterar() throws Exception {
        Marca m = new Marca();
        System.out.print("ID da marca que deseja alterar: ");
        m.setId(Integer.parseInt(sc.nextLine()));
        System.out.print("Novo nome: ");
        m.setNome(sc.nextLine());
        System.out.print("Novas observações: ");
        m.setObservacoes(sc.nextLine());

        banco.alterar(m);
        banco.salvarArquivo();

        System.out.println("✅ Marca alterada com sucesso!");
    }

    private static void excluir() throws Exception {
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());

        banco.excluir(id);
        banco.salvarArquivo();

        System.out.println("✅ Marca excluída com sucesso!");
    }

    private static void pesquisar() {
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Marca m = banco.pesquisar(id);
        System.out.println( (m == null) ? "Não encontrado!" : m );
    }

    private static void imprimirTodos() {
        for(Marca m : banco.imprimirTodos()){
            System.out.println(m);
        }
    }
}
