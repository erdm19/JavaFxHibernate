package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.hibernate.Session;
import sample.db.Kullanicilar;

import java.util.List;

public class Controller {


    final Session session;
    public Controller() {
        session = HibernateUtil.getSession();
    }

    @FXML
    void BtnClick(ActionEvent event) {
        try {
            List<Kullanicilar> kullaniciListesi = session.createQuery("from Kullanicilar ", Kullanicilar.class).list();
            kullaniciListesi.forEach(s -> System.out.println(s.getAdSoyad() + "-" + s.getYetkilerByYetkiId().getYetkiAdi()));
        } finally {

        }
    }

}
