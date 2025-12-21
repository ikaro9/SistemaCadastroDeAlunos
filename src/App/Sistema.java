package App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sistema {
    private List<Aluno> alunos = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public int quantAlunos(){
        return alunos.size();
    }

    public void cadastrarAluno(String nome, String matricula, String curso) {
        Aluno aluno = new Aluno(nome, matricula, curso);
        alunos.add(aluno);
    }

    public void listarAlunos() {
            for (Aluno i : alunos) {
                System.out.println(i);
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
     Aluno aluno = buscarAlunoMatricula(matricula);
     if(aluno != null){
         alunos.remove(aluno);
         return aluno;
     }
        return null;
    }

    public Aluno editarNome(String matricula, String novoNome){
        Aluno aluno = buscarAlunoMatricula(matricula);
        if(aluno != null){
            aluno.setNome(novoNome);
            return aluno;
        }
        return null;
    }
    public Aluno editarMatricula(String matricula, String novaMatricula){
        Aluno aluno = buscarAlunoMatricula(matricula);
        if(aluno != null){
            aluno.setMatricula(novaMatricula);
            return aluno;
        }
        return null;
    }
    public Aluno editarCurso(String matricula, String novoCurso){
        Aluno aluno = buscarAlunoMatricula(matricula);
        if(aluno != null){
            aluno.setCurso(novoCurso);
            return aluno;
        }
        return null;
    }
    public boolean validarMatricula (String matricula){
        return matricula.length() == 10;
    }
}
