package wdsr.exercise5.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import wdsr.exercise5.model.Trade;

import java.sql.PreparedStatement;
import java.sql.Statement;
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
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((con -> {
            PreparedStatement ps = con.prepareStatement("insert into trade(asset, amount, date) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, trade.getAsset());
            ps.setDouble(2, trade.getAmount());
            ps.setDate(3, new java.sql.Date(trade.getDate().getTime()));
            return ps;
        }
        ), keyHolder);

        return keyHolder.getKey().intValue();
    }

    /**
     * Zaimplementuj metode aby wyciągneła z bazy rekord o podanym id.
     * @param id
     * @return metaoda powinna zwracać obiekt reprezentujący rekord o podanym id.
     */
    public Optional<Trade> extractTrade(int id) {
        // TODO
        return null;
    }

    /**
     * Zaimplementuj metode aby zaktualizowała rekord o podanym id danymi z przekazanego parametru 'trade'
     * @param trade
     */
    public void updateTrade(int id, Trade trade) {
        // TODO
    }

    /**
     * Zaimplementuj metode aby usuwała z bazy rekord o podanym id.
     * @param id
     */
    public void deleteTrade(int id) {
        // TODO
    }

}
