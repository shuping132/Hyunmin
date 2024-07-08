package kr.co.kfm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.co.kfm.beans.AnalysisBean;
import kr.co.kfm.beans.IOsumBean;

/*
 * @Mapper public class IOsumMapper {
 * 
 * @Select("select pr.name, pr.img, pr.specifications, pr.classification, pr.brand ,o.IO_quantity"
 * + "from Product pr, Franchisee_inventory fi, Franchisee fr,IO o " +
 * "where fr.franchisee_id = fi.franchisee_id and fi.product_id = pr.product_id "
 * + "and fr.franchisee_id = #{franchisee_id}") List<IOsumBean> getIOsum(String
 * franchisee_id); }
 */
