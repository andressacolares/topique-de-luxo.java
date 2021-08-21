package main;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Topic {
    private int capacidadeTotal;
    private int qtdPrioridades;
    private int qtdAssentosNormais;
    private final List <Passageiro> AssentosPrioriotarios;
    private final List <Passageiro> AssentosNormais;
    private int cont1 = 0;
    private int cont = 0;

    
    public Topic(int capacidade, int qtdPrioritatios) {
            if(capacidade < qtdPrioritatios)
                throw new IllegalArgumentException();
            this.capacidadeTotal = capacidade;
            this.qtdPrioridades = qtdPrioritatios;
        AssentosPrioriotarios = new ArrayList<>(Collections.nCopies(qtdPrioridades, null));
        AssentosNormais = new ArrayList<> (Collections.nCopies(qtdAssentosNormais, null));
    }
    public List <Passageiro> getAssentosNormais() {
        return AssentosNormais;
    }

    public List <Passageiro> getAssentosPrioriotarios() {
        return AssentosPrioriotarios;
    }

    public int getQtdAssentosNormais() {
        return qtdAssentosNormais;
    }

    public int getQtdPrioridades() {
        return qtdPrioridades;
    }

    public int getCapacidadeTotal() {
        return capacidadeTotal;
    }

    public int NumVagas(){
        return capacidadeTotal - (cont1 - cont);
    }
public boolean subir(Passageiro passageiros) {
    if(capacidadeTotal> cont1 + cont) {
        if(Passageiro.eQtdPrioridades()) {
            if(cont1 < cont) {
                AssentosPrioriotarios.set(cont1++, passageiros);
            } else if (cont1 < qtdPrioridades){
                AssentosNormais.set(cont++,passageiros);
        } else {
            if (cont < qtdAssentosNormais) {
                AssentosNormais.set(cont++, passageiros);
            } else {
                AssentosPrioriotarios.set(cont1++, passageiros);
            }
        }
        return true;
    }
    else
        return false;
}
    return false;
}
public boolean descer(String nome) {
    for(int i = 0; i < cont1; i++) {
        if(Objects.equals(AssentosPrioriotarios.get(i).getNome(), nome)) {
            AssentosPrioriotarios.remove(i);
            AssentosPrioriotarios.add(null);
            cont1--;
            return true;
        }
    }
    for(int i = 0; i < cont; i++) {
        if(Objects.equals(AssentosNormais.get(i).getNome(), nome)) {
            AssentosNormais.remove(i);
            AssentosNormais.add(null);
            cont--;
            return true;
        }
    }
    return false;
}
@Override
public String toString() {
    StringBuilder s = new StringBuilder("[");
    for (Passageiro AssentosPrioriotarios: AssentosPrioriotarios) {
        s.append("@");
        if(AssentosPrioriotarios != null)
            s.append(( (Passageiro) AssentosPrioriotarios).getNome());
        s.append(" ");
    }
    for (Passageiro AssentosNormais: AssentosNormais) {
        s.append("=");
        if(AssentosNormais != null)
            s.append(AssentosNormais.getNome());
        s.append(" ");
    }
    s.append("]");
    return s.toString();
}
}