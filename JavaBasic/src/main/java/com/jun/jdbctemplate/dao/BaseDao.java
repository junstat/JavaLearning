package com.jun.jdbctemplate.dao;

import com.google.common.collect.Lists;
import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

public abstract class BaseDao {
    // @Autowired
    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate template;

    @PostConstruct
    private void createTemplate() {
        template = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    public <T> T queryForObject(String sql, Class<T> resultClass) {
        return queryForObject(sql, new MapSqlParameterSource(), resultClass);
    }

    public <T> T queryForObject(String sql, SqlParameterSource args, Class<T> resultClass) {
        return template.queryForObject(sql, args, resultClass);
    }

    public <T> List<T> query(String sql, Class<T> resultClass) {
        return query(sql, new MapSqlParameterSource(), resultClass);
    }

    public <T> List<T> query(String sql, SqlParameterSource args, Class<T> resultClass) {
        return template.query(sql, args, new BeanPropertyRowMapper<>(resultClass));
    }

    public void update(String sql, SqlParameterSource args) {
        template.update(sql, args);
    }

    public <T> void batchUpdate(String sql, List<T> beans) {
        Lists.partition(beans, 500).forEach(parts -> {
            SqlParameterSource[] args = parts.stream()
                    .map(BeanPropertySqlParameterSource::new)
                    .toArray(SqlParameterSource[]::new);
            template.batchUpdate(sql, args);
        });
    }
}
