package kr.co.kfm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.kfm.beans.AnalysisBean;

public interface AnalysisMapper {

	@Select("select pr.name, pr.img, pr.specifications, pr.classification, pr.brand "
			+ "from Product pr, Franchisee_inventory fi, Franchisee fr "
			+ "where fr.franchisee_id = fi.franchisee_id and fi.product_id = pr.product_id "
			+ "and fr.franchisee_id = #{franchisee_id}")
	List<AnalysisBean> getFranchiseeProduct(String franchisee_id);

	@Select("select pr.name, pr.img, pr.specifications, pr.classification, pr.brand "
			+ "from Product pr, Logistics_center_inventory li, Logistics_center lc "
			+ "where lc.logistics_center_id = li.logistics_center_id and li.product_id = pr.product_id "
			+ "and lc.logistics_center_id = #{logistics_center_id}")
	List<AnalysisBean> getLogisticsProduct(String logistics_center_id);
}
