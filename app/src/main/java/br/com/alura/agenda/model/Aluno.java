package br.com.alura.agenda.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Aluno implements Parcelable {
    public static final Creator<Aluno> CREATOR = new Creator<Aluno>() {
        @Override
        public Aluno createFromParcel(Parcel in) {
            return new Aluno(in);
        }

        @Override
        public Aluno[] newArray(int size) {
            return new Aluno[size];
        }
    };
    private Long id;
    private String nome;
    private String telefone;
    private String email;

    public Aluno(Long id, String nome, String telefone, String email) {
        this(nome, telefone, email);
        this.id = id;
    }

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    protected Aluno(Parcel in) {
        id = in.readLong();
        nome = in.readString();
        telefone = in.readString();
        email = in.readString();
    }

    public Aluno() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long contadorID) {
        this.id = contadorID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(nome);
        dest.writeString(telefone);
        dest.writeString(email);
    }
}
