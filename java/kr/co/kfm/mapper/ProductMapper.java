package kr.co.kfm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.kfm.beans.ProductBean;

@Mapper
public interface ProductMapper {

	@Insert("insert into Product (name, img, buy_price, sell_price, initial_quantity, specifications, classification, brand) "
			+ "values (#{name}, #{img}, #{buy_price}, #{sell_price}, #{initial_quantity}, #{specifications}, #{classification}, #{brand})")
	void addProInfo(ProductBean writeProBean);

	/*
	 * @Insert("insert into Franchisee_inventory (franchisee_id, current_stock, safe_stock) "
	 * + "values (#{franchisee_id}, #{current_stock}, #{safe_stock})") void
	 * addProInfo2(ProductBean writeProBean);
	 */

	@Select("select * from Product p1, Franchisee_inventory fi1 "
			+ "where p1.product_id = fi1.product_id and fi1.franchisee_id = #{company_id}")
	List<ProductBean> getProductInfo(String company_id);

	@Select("select * from Product p1, Logistics_center_inventory lc1 "
			+ "where p1.product_id = lc1.product_id and lc1.logistics_center_id = #{company_id}")
	List<ProductBean> getProductInfo2(String company_id);

	/*
	 * @Select("select * from product p1, Logistics_center_inventory lc1 where p1.product_id = lc1.product_id and lc1.logistics_center_id = #{company_id}"
	 * ) List<ProductBean> getProductInfo2(String company_id);
	 */

	@Update("update Product "
			+ " set name = #{name}, img = #{img}, buy_price = #{buy_price}, sell_price = #{sell_price}, specifications = #{specifications}, classification = #{classification}, brand = #{brand} "
			+ " where product_id = #{product_id}")
	void modifyProInfo(ProductBean modifyProInfo);

	/*
	 * @Update("update Franchisee_inventory set current_stock = #{current_stock}, safe_stock = #{safe_stock} where product_id = #{product_id}"
	 * ) void modifyProInfo2(ProductBean modifyProInfo);
	 */

	@Update("update Logistics_center_inventory set current_stock = #{current_stock}, safe_stock = #{safe_stock} where product_id = #{product_id}")
	void modifyProInfo3(ProductBean modifyProInfo);

	@Delete("delete Product where Product_id = #{Product_id}")
	void deleteProInfo(String product_id);

}
