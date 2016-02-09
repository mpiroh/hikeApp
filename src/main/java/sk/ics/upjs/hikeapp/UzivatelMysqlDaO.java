package sk.ics.upjs.hikeapp;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UzivatelMysqlDaO implements UzivatelDaO {

    private JdbcTemplate tmp;

    public UzivatelMysqlDaO(JdbcTemplate tmp) {
        this.tmp = tmp;
    }

    @Override
    public void vlozUzivatela(Uzivatel u) {
        tmp.update("insert into uzivatel values(?,?,?)", null, u.getMeno(), u.getHeslo());
    }

    @Override
    public Long getUserId(String meno) {
        Long idU = null;
        List<Uzivatel> uzivatel = tmp.query("select * from uzivatel where meno = ?", new Object[]{meno}, new UzivatelMapper());
        for (Uzivatel u : uzivatel) {
            if (u.getMeno().equals(meno)) {
                idU = u.getId();
            }
        }
        return idU;
    }

    @Override
    public List<Uzivatel> dajVsetkych() {
        return tmp.query("select * from uzivatel", new UzivatelMapper());
    }

    @Override
    public boolean overMeno(String meno) {
        List<Uzivatel> list = tmp.query("select * from uzivatel where meno=?", new Object[]{meno}, new UzivatelMapper());
        for (Uzivatel u : list) {
            if(u.getMeno().equals(meno)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean overUzivatela(String meno, String heslo) {
        List<Uzivatel> uzivatel = tmp.query("select * from uzivatel where meno=? and heslo=?",
                new Object[]{meno, heslo}, new UzivatelMapper());
        if (uzivatel.isEmpty()) {
            return false;
        } else {
            for (Uzivatel u : uzivatel) {
                if (u.getMeno().equals(meno) && u.getHeslo().equals(heslo)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public List<Uzivatel> dajVsetkychZoradenychPodlaPoctuTur() {
        String sql = "SELECT * FROM uzivatel u JOIN statistika s ON u.id = s.idU "
                + "ORDER BY s.pocetTur DESC";
        return tmp.query(sql, new UzivatelMapper());
    }
    
    @Override
    public List<Uzivatel> dajVsetkychZoradenychPodlaPoctuKm() {
        String sql = "SELECT * FROM uzivatel u JOIN statistika s ON u.id = s.idU "
                + "ORDER BY s.kmSpolu DESC";
        return tmp.query(sql, new UzivatelMapper());
    }
    
    @Override
    public List<Uzivatel> dajVsetkychZoradenychPodlaPriemernejObtiaznosti() {
        String sql = "SELECT * FROM uzivatel u JOIN statistika s ON u.id = s.idU "
                + "ORDER BY s.priemernaObtiaznost DESC";
        return tmp.query(sql, new UzivatelMapper());
    }

    public class UzivatelMapper implements RowMapper<Uzivatel> {

        @Override
        public Uzivatel mapRow(ResultSet rs, int i) throws SQLException {
            Uzivatel u = new Uzivatel();
            u.setId(rs.getLong("id"));
            u.setMeno(rs.getString("meno"));
            u.setHeslo(rs.getString("heslo"));
            return u;
        }

    }
}
