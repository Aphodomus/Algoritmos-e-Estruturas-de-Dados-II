public class unidade_00i_pagina83 {

    public static void main (String[] args){
        Cliente c1 = new Cliente(1, "aa");
        Cliente vet[] = new Cliente [5];
        System.out.println("ADDRS C1: " + c1 + " | Codigo: " + c1.getCodigo() + " | Nome: " + c1.getNome());
        for (int i = 0; i < vet.length; i++){
            vet[i] = c1.clone();
            System.out.println("ADDRS vet[" + i + "]: " + vet[i] + " | Codigo: " + vet[i].getCodigo() + " | Nome: " + vet[i].getNome());
        }
    }   
}
