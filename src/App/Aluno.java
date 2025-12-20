package App;

public class Aluno {
    private String nome;
    private String matricula;
    private String curso;

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }
    public String getMatricula(){
        return matricula;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return  "Nome: " + nome +
                " | Matricula: " + matricula +
                " | Curso: " + curso;

    }
}
