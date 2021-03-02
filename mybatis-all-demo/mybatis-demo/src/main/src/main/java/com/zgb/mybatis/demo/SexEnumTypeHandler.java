package com.zgb.mybatis.demo;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SexEnumTypeHandler extends BaseTypeHandler<Sex> {

    /**
     * 入参处理
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Sex parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    /**
     * 返回结果处理
     */
    @Override
    public Sex getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        if (rs.wasNull()) {
            return null;
        } else {
            return Sex.getSex(code);
        }
    }

    /**
     * 返回结果处理
     */
    @Override
    public Sex getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        if (rs.wasNull()) {
            return null;
        } else {
            return Sex.getSex(code);
        }
    }

    /**
     * 存储过程返回结果（CallableStatement）处理
     */
    @Override
    public Sex getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        if (cs.wasNull()) {
            return null;
        } else {
            return Sex.getSex(code);
        }
    }

}