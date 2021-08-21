package main;

public class Passageiro {
    private String nome;
    private int idade;

    public Passageiro(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
    }

    public boolean ePrioritario() {
        if(this.idade >= 65){
            return true;
        }
        else{
            return false;

        }
    }

    String getNome() {
        return this.nome;

    }

    public static boolean eQtdPrioridades() {
        return false;
    }
   
}
