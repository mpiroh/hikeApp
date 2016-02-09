package sk.ics.upjs.hikeapp;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class MysqlStatistikaDao implements StatistikaDao {
    private JdbcTemplate jdbcTemplate;
    
    public MysqlStatistikaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public void pridaj(Statistika s) {
        String sql = "INSERT INTO statistika (idS, idU, pocetTur, kmSpolu, priemernaObtiaznost, pocetFotiek, " +
                     "spoluTurJar, spoluTurLeto, spoluTurJesen, spoluTurZima, pocetHodnoteni, hodSpolu, " +
                     "priemernaRychlost) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, null, s.getIdU(), s.getPocetTur(), s.getKmSpolu(),
                s.getPriemernaObtiaznost(), s.getPocetFotiek(), s.getSpoluTurJar(),
                s.getSpoluTurLeto(), s.getSpoluTurJesen(), s.getSpoluTurZima(),
                s.getPocetHodnoteni(), s.getHodSpolu(), s.getPriemernaRychlost());
    }
    
    @Override
    public void uprav(Statistika s) {
        String sql = "UPDATE statistika SET pocetTur = ?, kmSpolu = ?, priemernaObtiaznost = ?, "
                + "pocetFotiek = ?, spoluTurJar = ?, spoluTurLeto = ?, spoluTurJesen = ?, "
                + "spoluTurZima = ?, pocetHodnoteni = ?, hodSpolu = ?, priemernaRychlost = ? "
                + "WHERE idS = ?";
        jdbcTemplate.update(sql, s.getPocetTur(), s.getKmSpolu(), s.getPriemernaObtiaznost(), 
                s.getPocetFotiek(), s.getSpoluTurJar(), s.getSpoluTurLeto(), s.getSpoluTurJesen(),
                s.getSpoluTurZima(), s.getPocetHodnoteni(), s.getHodSpolu(), s.getPriemernaRychlost(),
                s.getIdS());
    }
    
    @Override
    public Statistika dajPodlaUzivatela(Long idU) {
        String sql = "SELECT * FROM statistika WHERE idU = ?";
        BeanPropertyRowMapper<Statistika> mapper = BeanPropertyRowMapper.newInstance(Statistika.class);
        List<Statistika> statistiky = jdbcTemplate.query(sql, mapper, idU);
        
        return statistiky.get(0);
    }
    
    @Override
    public void vynulujStatistiku(Statistika s) {
        String sql = "UPDATE statistika SET pocetTur = 0, kmSpolu = 0, priemernaObtiaznost = 0, "
                + "pocetFotiek = 0, spoluTurJar = 0, spoluTurLeto = 0, spoluTurJesen = 0, "
                + "spoluTurZima = 0, pocetHodnoteni = 0, hodSpolu = 0, priemernaRychlost = 0, "
                + "vynulovanie = DEFAULT WHERE idS = ?";
        jdbcTemplate.update(sql, s.getIdS());
    }
    
    @Override
    public boolean statistikaSaZaznamenava(Long idU) {
        String sql = "SELECT * FROM statistika WHERE idU = ?";
        BeanPropertyRowMapper<Statistika> mapper = BeanPropertyRowMapper.newInstance(Statistika.class);
        List<Statistika> statistiky = jdbcTemplate.query(sql, mapper, idU);
        
        if (statistiky.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}