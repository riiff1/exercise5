import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import wdsr.exercise5.dao.TradeDao;
import wdsr.exercise5.model.Trade;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Mateusz on 2017-05-08.
 */
@ContextConfiguration("/spring-context.xml")
@RunWith(value = SpringRunner.class)
public class TradeDaoTest {

    @Autowired
    TradeDao tradeDao;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void insertTradeTest() {
        // given
        Trade trade = new Trade(1, "$ASIA_TOP_50", 100.0, Calendar.getInstance().getTime());

        // when
        int i = tradeDao.insertTrade(trade);

        // then
        Assert.assertEquals(1, i);
    }

    @Test
    public void updateTradeTest() {
        // given
        Date date = java.sql.Date.valueOf(LocalDate.of(2017, 5, 1));
        Trade trade = new Trade(null, "PKP INTERCITY", 70.0, date);

        // when
        tradeDao.updateTrade(1, trade);

        // then
        Assert.assertEquals(JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "trade", "id=2 and asset='PKP INTERCITY' and amount=70.0 and date='2017-05-01'"), 1);
    }

    @Test
    public void extractTradeTest() {
        // given
        Date date = java.sql.Date.valueOf(LocalDate.of(2017, 1, 1));
        Trade expectedTrade = new Trade(0, "GFT", 90.0, date);

        // when
        Optional<Trade> trade = tradeDao.extractTrade(0);

        // then
        Assert.assertTrue(trade.isPresent());
        Assert.assertEquals(expectedTrade, trade.get());
    }

    @Test
    public void deleteTradeTest() {
        // given

        // when
        tradeDao.deleteTrade(0);

        // then
        Assert.assertEquals(2, JdbcTestUtils.countRowsInTable(jdbcTemplate, "trade"));
        Assert.assertEquals(0, JdbcTestUtils.countRowsInTableWhere(jdbcTemplate, "trade", "id=0"));

    }

}
