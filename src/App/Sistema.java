package App;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Sistema {
   private List<Aluno> alunos = new ArrayList<>();
   Scanner input = new Scanner(System.in);

   public void cadastrarAluno(String nome,String matricula,String curso){
       Aluno aluno = new Aluno(nome,matricula,curso);
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

   public Aluno buscarAlunoNome(String nome){
       for(Aluno i : alunos){
           if(i.getNome().equalsIgnoreCase(nome)){
               return i;
           }
       }
       return null;
   }

   public Aluno buscarAlunoMatricula(String matricula){
       for(Aluno i : alunos){
           if(matricula.equals(i.getMatricula())){
               return i;
           }
       }
       return null;
   }

   public Aluno removerAluno(String nome, String matricula){
       Aluno encontrado = null;
       for(Aluno i : alunos){
           if(i.getNome().equalsIgnoreCase(nome) && i.getMatricula().equals(matricula)){
               encontrado = i;
               break;
           }
       }
       if(encontrado!=null){
           System.out.println(encontrado);
           System.out.println("Tem certeza que deseja remover (S/N)");
           String opcao = input.nextLine();
           if(opcao.equalsIgnoreCase("S")){
               alunos.remove(encontrado);
               System.out.println("Aluno removido com sucesso!");
               return encontrado;
           }
           else{
               System.out.println("Aluno não removido.");
           }
       }
       else{
           System.out.println("Aluno não encontrado");
           return null;
       }
       return null;
   }
}
