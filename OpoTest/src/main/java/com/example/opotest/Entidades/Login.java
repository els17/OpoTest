package com.example.opotest.Entidades;

public class Login {

    private int id_login;
    private int id_user;
    private int tema_test;
    private int num_test;
    private int fallos;

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getTema_test() {
        return tema_test;
    }

    public void setTema_test(int tema_test) {
        this.tema_test = tema_test;
    }

    public int getNum_test() {
        return num_test;
    }

    public void setNum_test(int num_test) {
        this.num_test = num_test;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }
}
