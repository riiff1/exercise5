package wdsr.exercise5.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import wdsr.exercise5.TradeMapper;
import wdsr.exercise5.model.Trade;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.Optional;

@Repository
public class TradeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * Zaimplementuj metode insertTrade aby wstawiała nowy rekord do tabeli "trade"
     * na podstawie przekazanego objektu klasy Trade.
     * @param trade
     * @return metoda powinna zwracać id nowego rekordu.
     */
    public int insertTrade(Trade trade) {
        // TODO
        String sql = "INSERT INTO trade (asset, amount, date) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{trade.getAsset(), trade.getAmount(), trade.getDate()}, new int[]{Types.VARCHAR, Types.DOUBLE, Types.DATE});
        String sql1 = "select * from trade order by id desc limit 1";
        Trade trade1 = jdbcTemplate.queryForObject(sql1, new TradeMapper());
        return trade1.getId();
    }

    /**
     * Zaimplementuj metode aby wyciągneła z bazy rekord o podanym id.
     * Użyj intrfejsu RowMapper.
     * @param id
     * @return metaoda powinna zwracać obiekt reprezentujący rekord o podanym id.
     */
    public Optional<Trade> extractTrade(int id) {
        // TODO
        String sql = "select * from trade where id = ?";
        Trade trade = jdbcTemplate.queryForObject(sql, new Object[] {id}, new TradeMapper());
        return Optional.ofNullable(trade);
    }

    /**
     * Zaimplementuj metode aby wyciągneła z bazy rekord o podanym id.
     * @param id, rch - callback który przetworzy wyciągnięty wiersz.
     * @return metaoda powinna zwracać obiekt reprezentujący rekord o podanym id.
     */
    public void extractTrade(int id, RowCallbackHandler rch) {
        // TODO
        String sql = "select * from trade where id = ?";
        jdbcTemplate.query(sql, new Object[]{id}, rch);


    }

    /**
     * Zaimplementuj metode aby zaktualizowała rekord o podanym id danymi z przekazanego parametru 'trade'
     * @param trade
     */
    public void updateTrade(int id, Trade trade) {
        // TODO
        String sql = "update trade set asset = ?, amount = ? , date = ? where id = ?";
        jdbcTemplate.update(sql, new Object[]{trade.getAsset(), trade.getAmount(), trade.getDate(), id}, new int[]{Types.VARCHAR, Types.DOUBLE, Types.DATE, Types.INTEGER});

    }

    /**
     * Zaimplementuj metode aby usuwała z bazy rekord o podanym id.
     * @param id
     */
    public void deleteTrade(int id) {
        // TODO
        String sql = "delete from trade where id = ?";
        jdbcTemplate.update(sql, new Object[]{id});
    }

}
