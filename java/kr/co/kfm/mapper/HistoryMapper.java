package kr.co.kfm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import kr.co.kfm.beans.product_HistoryBean;

@Mapper
public interface HistoryMapper {

    @Select("SELECT * FROM product_History WHERE TO_CHAR(change_date, 'YYYY-MM-DD') = #{change_date} and LOGISTICS_CENTER_ID = #{logisticsCenterId}")
    List<product_HistoryBean> getHistoryByDateLC(@Param("change_date") String change_date, @Param("logisticsCenterId") String logisticsCenterId);
    
    @Select("SELECT * FROM product_History WHERE TO_CHAR(change_date, 'YYYY-MM-DD') = #{change_date} and FRANCHISEE_ID = #{franchiseeId}")
    List<product_HistoryBean> getHistoryByDateF(@Param("change_date") String change_date, @Param("franchiseeId") String franchiseeId);
}
