package sample.db;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Kullanicilar {
    private int id;
    private String adSoyad;
    private Integer yas;
    private Yetkiler yetkilerByYetkiId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ad_soyad", nullable = true, length = 25)
    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    @Basic
    @Column(name = "yas", nullable = true)
    public Integer getYas() {
        return yas;
    }

    public void setYas(Integer yas) {
        this.yas = yas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kullanicilar that = (Kullanicilar) o;
        return id == that.id &&
                Objects.equals(adSoyad, that.adSoyad) &&
                Objects.equals(yas, that.yas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adSoyad, yas);
    }

    @ManyToOne
    @JoinColumn(name = "yetki_id", referencedColumnName = "id", nullable = false)
    public Yetkiler getYetkilerByYetkiId() {
        return yetkilerByYetkiId;
    }

    public void setYetkilerByYetkiId(Yetkiler yetkilerByYetkiId) {
        this.yetkilerByYetkiId = yetkilerByYetkiId;
    }
}
