package app;

import java.util.ArrayList;
import java.util.Iterator;

public class No {
    private String nomeNo;
    private String label;
    protected ArrayList<No> filhas = new ArrayList<>();
    protected int associacoes;
    //Atributos especificos de cada no
    private int labelFsizenode;
    private String labellocNode;
    private String imagens;

    public No(String nome) { this.nomeNo = nome; }

    public void setNomeNo(String no) {
        this.nomeNo = no;
    }

    public void setlabel(String label) {
        this.label = label;
    }

    public void setImagens(int c){
        Imagens imagens = Imagens.escolherImagem(c);

        switch (imagens) {
            case RACK:
                this.imagens = "img/rack-server.png";
            case CAMERA:
                this.imagens = "img/ip-camera.png";
            case SERVER:
                this.imagens = "img/network-server-generic.png";
            case SWITCH:
                this.imagens = "img/switch.png";
            case DESKTOP:
                this.imagens = "img/desktop.png";
            case FIREWALL:
                this.imagens = "img/firewall.png";
            case INTERNET:
                this.imagens = "img/cloud.png";
            case ROTEADORazul:
                this.imagens = "img/blue-router.png";
            case ROTEADORverde:
                this.imagens = "img/green-router.png";
            default:
                this.imagens = null;
        }
    }

    public String getImagens() { return  this.imagens; }

    public String getLabel() {
        return this.label;
    }

    public int getLabelFsizenode() {
        return labelFsizenode;
    }

    public void setLabelFsizenode(int labelFsizenode) {
        if(labelFsizenode < 14) {
            this.labelFsizenode = labelFsizenode;
        } else this.labelFsizenode = 10;
    }

    public String getLabellocNode() {
        return labellocNode;
    }

    public void setLabellocNode(String c) {
        this.labellocNode = Locations.escolherLocalizacao(c);
    }

    public String getNomeNo() {
        return nomeNo;
    }

    public boolean adicionarFilha(No filha) {
        if(filha == null) {
            return false;
        } else {
            filha.associar();
            this.associar();
            this.filhas.add(filha);
            return true;
        }
    }

    public void associar() {
        this.associacoes++;
    }

    public void desassociar() {
        this.associacoes--;
    }

    public boolean removeFilha(String noID) {
        Iterator<No> filha = filhas.iterator();
        while (filha.hasNext()) {
            No no = filha.next();
            if(no.getNomeNo().equals(noID)) {
                this.desassociar();
                filha.remove();
                return true;
            }
        }
        return false;
    }

    public boolean atualizaFilha(String noID, String novoID) {
        Iterator<No> filha = filhas.iterator();
        while (filha.hasNext()) {
            No no = filha.next();
            if(no.getNomeNo().equals(noID)) {
                no.setNomeNo(novoID);
                return true;
            }
        }
        return false;
    }

    public boolean existemFilhas() {
        return this.filhas.size() > 0;
    }

    public boolean existeFilha(String noID) {
        for (No n : filhas) {
            if (n.getNomeNo().equals(noID)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarAssociacoes() {
        return this.associacoes > 0;
    }

    public ArrayList<No> getFilhas() {
        return filhas;
    }
}
