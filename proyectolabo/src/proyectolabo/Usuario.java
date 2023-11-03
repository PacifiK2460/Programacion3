package proyectolabo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 176453
 */
public class Usuario {
            private int id;
        private String user_name;
        private double saldo;

        public Usuario(int id, String user_name, double saldo) {
            this.id = id;
            this.user_name = user_name;
            this.saldo = saldo;
        }

        // Métodos get y set para los atributos
        public int getId() {
            return id;
        }

        public String getUser_name() {
            return user_name;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }
}
