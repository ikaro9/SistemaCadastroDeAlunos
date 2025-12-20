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
                  sistema.listarAlunos();
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
        System.out.println("Digite a matrícula do aluno: ");
       String matricula = input.nextLine();
        System.out.println("Digite o curso do aluno: ");
        String curso = input.nextLine();
        sistema.cadastrarAluno(nome,matricula,curso);
        System.out.println("Aluno cadastrado com sucesso!");
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
        sistema.removerAluno(matricula);

    }
    public void editarAluno(){
        System.out.println("Digite a matrícula do aluno:");
        String matricula = input.nextLine();
        sistema.editarAluno(matricula);
    }

}
