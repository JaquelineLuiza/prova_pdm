package br.edu.iftm.pdm.patrimonizador.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Objects;

public class Patrimonio implements Parcelable {
    private long id;
    private String categoria;
    private String marca;
    private String estado;
    private float valor;
    private String descricao;
    private ArrayList<String> imagens;
    private String timeStamp;

    public Patrimonio(long id, String categoria, String marca,
                      String estado, float valor, String descricao,
                      ArrayList<String> imagens, String timeStamp) {
        this.id = id;
        this.categoria = categoria;
        this.marca = marca;
        this.estado = estado;
        this.valor = valor;
        this.descricao = descricao;
        this.imagens = imagens;
        this.timeStamp = timeStamp;
    }

    public Patrimonio(String categoria, String marca, String estado,
                      float valor, String descricao, ArrayList<String> imagens) {
        this.categoria = categoria;
        this.marca = marca;
        this.estado = estado;
        this.valor = valor;
        this.descricao = descricao;
        this.imagens = imagens;
    }

    public long getId() {
        return id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public ArrayList<String> getImagens() {
        return imagens;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return categoria + ": " + marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patrimonio that = (Patrimonio) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Parcelable implementation

    protected Patrimonio(Parcel in) {
        id = in.readLong();
        categoria = in.readString();
        marca = in.readString();
        estado = in.readString();
        valor = in.readFloat();
        descricao = in.readString();
        imagens = in.createStringArrayList();
        timeStamp = in.readString();
    }

    public static final Creator<Patrimonio> CREATOR = new Creator<Patrimonio>() {
        @Override
        public Patrimonio createFromParcel(Parcel in) {
            return new Patrimonio(in);
        }

        @Override
        public Patrimonio[] newArray(int size) {
            return new Patrimonio[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(categoria);
        dest.writeString(marca);
        dest.writeString(estado);
        dest.writeFloat(valor);
        dest.writeString(descricao);
        dest.writeStringList(imagens);
        dest.writeString(timeStamp);
    }
}
