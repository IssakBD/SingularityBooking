package kz.arab.SingularityHackathon.demo.RowMapper;

import kz.arab.SingularityHackathon.demo.dto.BookingDto;
import kz.arab.SingularityHackathon.demo.dto.IdDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IdMapper implements RowMapper<IdDto> {
    @Override
    public IdDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        IdDto idDto = new IdDto();
        idDto.setId(rs.getLong("time_slot_id"));

        return idDto;
    }
}
