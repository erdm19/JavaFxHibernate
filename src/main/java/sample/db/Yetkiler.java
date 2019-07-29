package sample.db;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Yetkiler {
    private int id;
    private String yetkiAdi;
    private Collection<Kullanicilar> kullanicilarsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "yetki_adi", nullable = true, length = 15)
    public String getYetkiAdi() {
        return yetkiAdi;
    }

    public void setYetkiAdi(String yetkiAdi) {
        this.yetkiAdi = yetkiAdi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Yetkiler yetkiler = (Yetkiler) o;
        return id == yetkiler.id &&
                Objects.equals(yetkiAdi, yetkiler.yetkiAdi);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, yetkiAdi);
    }

    @OneToMany(mappedBy = "yetkilerByYetkiId")
    public Collection<Kullanicilar> getKullanicilarsById() {
        return kullanicilarsById;
    }

    public void setKullanicilarsById(Collection<Kullanicilar> kullanicilarsById) {
        this.kullanicilarsById = kullanicilarsById;
    }
}
