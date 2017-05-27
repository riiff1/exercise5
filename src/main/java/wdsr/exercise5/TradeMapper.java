package wdsr.exercise5;

import org.springframework.jdbc.core.RowMapper;
import wdsr.exercise5.model.Trade;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Rafal on 5/22/2017.
 */
public class TradeMapper implements RowMapper<Trade> {
    @Override
    public Trade mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trade trade = new Trade(null,null,null,null);
        trade.setId(rs.getInt("id"));
        trade.setAsset(rs.getString("asset"));
        trade.setAmount(rs.getDouble("amount"));
        trade.setDate(rs.getDate("date"));
        return trade;
    }
}
