package sk.ics.upjs.hikeapp;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum DaOFactory {

    INSTANCE;
    
    private MysqlDataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private UzivatelDaO uzivatelDao;
    private TuraDaO turaDao;
    private FotkaDaO fotkaDao;
    private StatistikaDao statistikaDao;

    public TuraDaO getTuraDaO() {
        if (this.turaDao == null) {
            this.turaDao = new MysqlTuraDaO(getJdbcTemplate());
        }
        return this.turaDao;
    }

    public UzivatelDaO getUserDaO() {
        if (this.uzivatelDao == null) {
            this.uzivatelDao = new UzivatelMysqlDaO(getJdbcTemplate());
        }
        return this.uzivatelDao;
    }

    public FotkaDaO getFotkaDaO() {
        if (this.fotkaDao == null) {
            this.fotkaDao = new MysqlFotkaDaO(getJdbcTemplate());
        }
        return this.fotkaDao;
    }
    
    public StatistikaDao getStatistikaDao() {
        if (this.statistikaDao == null) {
            this.statistikaDao = new MysqlStatistikaDao(getJdbcTemplate());
        }
        return this.statistikaDao;
    }
    
    public JdbcTemplate getJdbcTemplate() {
        if (this.jdbcTemplate == null) {
            this.jdbcTemplate = new JdbcTemplate(getDataSource());
        }
        return this.jdbcTemplate;
    }
    
    public MysqlDataSource getDataSource() {
        if (this.dataSource == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost/Hike");
            dataSource.setUser("paz1c");
            dataSource.setPassword("paz1c");
            this.dataSource = dataSource;
        }
        return this.dataSource;
    }
}
