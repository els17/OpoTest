package com.example.opotest.Entidades;

public class Login {

    private int id_login;
    private int id_user;
    private String tema_test;
    private String num_test;
    private int fallos;
    private String fecha;
    private String hora;

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
