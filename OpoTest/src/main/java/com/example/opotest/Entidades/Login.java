package com.example.opotest.Entidades;

public class Login {

    private int id_login;
    private String tema_test;
    private String num_test;
    private int fallos;

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public String getTema_test() {
        return tema_test;
    }

    public void setTema_test(String tema_test) {
        this.tema_test = tema_test;
    }

    public String getNum_test() {
        return num_test;
    }

    public void setNum_test(String num_test) {
        this.num_test = num_test;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }
}
