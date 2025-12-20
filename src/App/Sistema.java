package App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sistema {
    private List<Aluno> alunos = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public void cadastrarAluno(String nome, String matricula, String curso) {
        Aluno aluno = new Aluno(nome, matricula, curso);
        alunos.add(aluno);
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados!");
        } else {
            for (Aluno i : alunos) {
                System.out.println(i);
            }
        }
    }

    public Aluno buscarAlunoNome(String nome) {
        for (Aluno i : alunos) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return null;
    }

    public Aluno buscarAlunoMatricula(String matricula) {
        for (Aluno i : alunos) {
            if (matricula.equals(i.getMatricula())) {
                return i;
            }
        }
        return null;
    }

    public Aluno removerAluno(String matricula) {
        Aluno encontrado = null;
        for (Aluno i : alunos) {
            if (i.getMatricula().equals(matricula)) {
                encontrado = i;
                break;
            }
        }
        if (encontrado != null) {
            System.out.println(encontrado);
            System.out.println("Tem certeza que deseja remover (S/N)");
            String opcao = input.nextLine();
            if (opcao.equalsIgnoreCase("S")) {
                alunos.remove(encontrado);
                System.out.println("Aluno removido com sucesso!");
                return encontrado;
            } else {
                System.out.println("Aluno não removido.");
            }
        } else {
            System.out.println("Aluno não encontrado");
            return null;
        }
        return null;
    }

    public void editarAluno(String matricula) {
        Aluno encontrado = null;
        int opcao;
        for (Aluno i : alunos) {
            if (i.getMatricula().equals(matricula)) {
                encontrado = i;
                break;
            }
        }
        if (encontrado != null) {
            System.out.println(encontrado);

                System.out.println("Digite o que deseja editar (ou 0 para sair): ");
                System.out.print("""
                        1. Nome
                        2. Matricula
                        3. Curso
                        """);
                opcao = input.nextInt();
                input.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o novo nome:");
                        encontrado.setNome(input.nextLine());
                        System.out.println("Nome do aluno editado com sucesso!\n");
                        break;
                    case 2:
                        System.out.println("Digite a nova matrícula:");
                        encontrado.setMatricula(input.nextLine());
                        System.out.println("Matricula do aluno editada com sucesso!\n");
                        break;
                    case 3:
                        System.out.println("Digite o novo curso: ");
                        encontrado.setCurso(input.nextLine());
                        System.out.println("Curso editado com sucesso!\n");
                        break;
                    case 0:
                    break;
                    default:
                        System.out.println("Opção inválida");
                }
        }
        else{
            System.out.println("Aluno não encontrado");
        }
    }
}
