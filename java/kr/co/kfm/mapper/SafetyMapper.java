package kr.co.kfm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.kfm.beans.SafetyBean;

@Mapper
public interface SafetyMapper {
	// ===============================================================================
	// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� �뜝�룞�삕�뜝占� select
	// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� 0�뜝�떛怨ㅼ삕 �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 1�뜝�룞�삕 �뜝�떛�궪�삕�뜝�룞�삕 �뜝�룞�삕�뭹 �뜝�룞�삕�뜝�룞�삕
	
	@Select("SELECT p.PRODUCT_ID, p.IMG, p.NAME, lci.CURRENT_STOCK, lci.SAFE_STOCK FROM PRODUCT p JOIN LOGISTICS_CENTER_INVENTORY lci ON p.PRODUCT_ID = lci.PRODUCT_ID where lci.LOGISTICS_CENTER_ID= #{logistics_center_id} and lci.CURRENT_STOCK > 0 and lci.SAFE_STOCK = 0")
	List<SafetyBean> getZeroSafeStockCenterProducts(String logistics_center_id);

	// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� 0�뜝�떛怨ㅼ삕 �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 1�뜝�룞�삕 �뜝�떛�궪�삕�뜝�룞�삕 �뜝�룞�삕�뭹 �뜝�룞�삕�뜝�룞�삕
	@Select("select p.PRODUCT_ID, p.IMG, p.NAME, fi.CURRENT_STOCK, fi.SAFE_STOCK  FROM PRODUCT p JOIN FRANCHISEE_INVENTORY fi ON p.product_id = fi.product_id where fi.FRANCHISEE_ID= #{franchisee_id} and fi.CURRENT_STOCK > 0 and fi.SAFE_STOCK = 0")
	List<SafetyBean> getZeroSafeStockFranchiseeProducts(String franchisee_id);

	// ===============================================================================
	// �뜝�룞�삕繹앭뜝占� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� select
	// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� 1�뜝�룞�삕 �뜝�떛�궪�삕�뜝�룞�삕 �뜝�룞�삕�뭹 �뜝�룞�삕�뜝�룞�삕
	@Select("select pr.product_id, pr.name, li.current_stock, li.safe_stock "
			+ "from Product pr "
			+ "join Logistics_center_inventory li on li.product_id = pr.product_id "
			+ "where safe_stock > 0 and li.logistics_center_id = #{logistics_center_id}")
	List<SafetyBean> getmainSafeStockCenterProducts(String logistics_center_id);

	// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� 1�뜝�룞�삕 �뜝�떛�궪�삕�뜝�룞�삕 �뜝�룞�삕�뭹 �뜝�룞�삕�뜝�룞�삕
	@Select("SELECT p.PRODUCT_ID, p.NAME, fi.CURRENT_STOCK, fi.SAFE_STOCK " +
	        "FROM PRODUCT p " +
	        "JOIN FRANCHISEE_INVENTORY fi ON p.PRODUCT_ID = fi.PRODUCT_ID " +
	        "WHERE fi.FRANCHISEE_ID = #{franchisee_id} " +
	        "AND fi.SAFE_STOCK > 0")
	List<SafetyBean> getmainSafeStockFranchiseeProducts(String franchisee_id);

	// ===============================================================================
	//�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�듃
	@Update("update logistics_center_inventory set safe_stock = #{safe_stock} where product_id = #{product_id} and logistics_center_id = #{logistics_center_id}")
	void getLCsafeQuantity(@Param("safe_stock") int safeStock, @Param("product_id") String productId, @Param("logistics_center_id") String logisticsCenterId);

	@Update("UPDATE FRANCHISEE_INVENTORY SET safe_stock = #{safe_stock} WHERE product_id = #{product_id} and franchisee_id = #{franchisee_id}")
	void getFsafeQuantity(@Param("safe_stock") int safeStock, @Param("product_id") String productId, @Param("franchisee_id") String franchiseeId);


	// ===============================================================================
	//�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝占� �뜝�룞�삕�뜝�룞�삕
	@Update("update logistics_center_inventory set safe_stock = 0 where product_id = #{product_id} and logistics_center_id = #{companyId}")
    void updateCenterSafeStockToZero(@RequestParam("product_id") String product_id,@RequestParam("companyId") String companyId);
    @Update("UPDATE FRANCHISEE_INVENTORY SET safe_stock = 0 WHERE product_id = #{product_id} and FRANCHISEE_ID = #{companyId}")
    void updateFranchiseeSafeStockToZero(@RequestParam("product_id") String product_id,@RequestParam("companyId") String companyId);
    
    //�뜝�떙紐뚯삕�뜝�룞�삕�뜝�룞�삕
    @Select("SELECT p.product_id, p.name, lci.current_stock, lci.safe_stock FROM Product p join LOGISTICS_CENTER_INVENTORY lci")
    List<SafetyBean> getLCAllProducts();
    @Select("SELECT p.product_id, p.name, fi.current_stock, fi.safe_stock FROM Product p join FRANCHISEE_INVENTORY fi")
    List<SafetyBean> getFAllProducts();
    
 // 諛쒖＜
    @Insert("INSERT INTO ORDERS (order_id, order_state, order_date, due_date, payment_date, memo, user_idx) " +
            "VALUES ('20240626581332', '발주 요청', SYSDATE, SYSDATE + 10, SYSDATE + 15, '알림재고발주', 'UI00001')")
    void RequestOrder();

    // 臾쇰쪟�꽱�꽣 諛쒖＜臾쇳뭹媛쒖닔
    @Insert("INSERT INTO FRANCHISEE_ORDER_PRODUCT (order_id, product_id, quantity) " +
            "VALUES ('20240626581332', 'P00035', 160)")
    void LCOrderquantity();

    // 媛�留뱀젏 諛쒖＜臾쇳뭹媛쒖닔
    @Insert("INSERT INTO FRANCHISEE_ORDER (order_id, FRANCHISEE_ID, LOGISTICS_CENTER_ID) " +
            "VALUES ('20240626581332', 'F00001', 'LC00001')")
    void FOrderquantity();
    
}
