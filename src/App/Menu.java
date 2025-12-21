package App;

import java.util.Scanner;

public class Menu {
    private Sistema sistema;
    private Scanner input;

    public Menu(){
        sistema = new Sistema();
        input = new Scanner(System.in);
    }

    public void exibirMenu(){
    int opcao;
        do {
            System.out.println("------- Menu --------");
            System.out.println("""
                    1. Cadastrar aluno
                    2. Listar alunos
                    3. Buscar por nome
                    4. Buscar por matrícula
                    5. Remover aluno
                    6. Editar aluno
                    0. Sair do sistema""");

            System.out.println("Digite a opção desejada: ");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao){
                case 1:
                  cadastrarAlunos();
                  break;
                case 2:
                  listarAlunos();
                  break;
                case 3:
                    buscarAlunoNome();
                    break;
                case 4:
                    buscarAlunoMatricula();
                    break;
                case 5:
                    removerAluno();
                    break;
                case 6:
                    editarAluno();
                    break;
                case 0:
                    System.out.println("Saindo do sistema ...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        }while(opcao != 0);
    }

    public void cadastrarAlunos(){
        System.out.println("Digite o nome do aluno: ");
        String nome = input.nextLine();
        String matricula;
        do {
            System.out.println("Digite a matrícula do aluno: ");
            matricula = input.nextLine();
            if (!sistema.validarMatricula(matricula)) {
                System.out.println("Matrícula inválida! A matricula deve ter 10 digitos.");
            }
        }while(!sistema.validarMatricula(matricula));
        System.out.println("Digite o curso do aluno: ");
        String curso = input.nextLine();
        sistema.cadastrarAluno(nome,matricula,curso);
        System.out.println("Aluno cadastrado com sucesso!");
    }
    public void listarAlunos(){
        if(sistema.quantAlunos()==0){
            System.out.println("Não há alunos cadastrados!");
        }
        else{
            sistema.listarAlunos();
        }
    }
    public void buscarAlunoNome(){
        System.out.println("Digite o nome do aluno");
        String nome = input.nextLine();
        Aluno aluno = sistema.buscarAlunoNome(nome);
        if(aluno == null){
            System.out.println("Aluno não encontrado!");
        }
        else{
            System.out.println("Aluno encontrado!");
            System.out.println(aluno);
        }
    }
    public void buscarAlunoMatricula(){
        System.out.println("Digite a matrícula do aluno");
        String matricula = input.nextLine();
        Aluno aluno = sistema.buscarAlunoMatricula(matricula);
        if(aluno == null){
            System.out.println("Aluno não encontrado!");
        }
        else{
            System.out.println("Aluno encontrado!");
            System.out.println(aluno);
        }
    }
    public void removerAluno(){
        System.out.println("Digite a matrícula do aluno");
        String matricula = input.nextLine();
        Aluno aluno = sistema.buscarAlunoMatricula(matricula);
        if(aluno == null){
            System.out.println("Aluno não encontrado");
            return;
        }
        System.out.println(aluno);
        System.out.println("Tem certeza que deseja remover (S/N)");
        String opcao = input.nextLine();
        if(opcao.equalsIgnoreCase("s")){
        sistema.removerAluno(matricula);
            System.out.println("Aluno removido com sucesso!");
        }
        else{
            System.out.println("Aluno não removido");
        }
    }
    public void editarAluno() {
        System.out.println("Digite a matrícula do aluno:");
        String matricula = input.nextLine();
        Aluno aluno = sistema.buscarAlunoMatricula(matricula);
        if(aluno==null){
            System.out.println("Aluno não encontrado!");
            return;
        }
        System.out.println(aluno);
            System.out.println("Digite o que deseja alterar");
            System.out.println("""
                    1. Nome
                    2. Matrícula
                    3. Curso""");
            int opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o novo nome: ");
                    String novoNome = input.nextLine();
                    sistema.editarNome(matricula, novoNome);
                    System.out.println("Nome alterado.");
                    break;
                case 2:
                    String novaMatricula;
                   do {
                       System.out.println("Digite a nova matricula: ");
                      novaMatricula = input.nextLine();
                       if (!sistema.validarMatricula(novaMatricula)) {
                           System.out.println("Matrícula inválida! A matricula deve ter 10 digitos.");
                       }
                       ;
                   }while(!sistema.validarMatricula(novaMatricula));
                    sistema.editarMatricula(matricula, novaMatricula);
                    System.out.println("Matrícula alterada.");

                    break;
                case 3:
                    System.out.println("Digite o novo curso: ");
                    String novoCurso = input.nextLine();
                    sistema.editarCurso(matricula, novoCurso);
                    System.out.println("Curso alterado alterado.");

                    break;

                default:
                    System.out.println("Opção inválida");
            }
    }

}
