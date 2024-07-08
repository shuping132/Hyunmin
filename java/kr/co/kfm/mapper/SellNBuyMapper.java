package kr.co.kfm.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.kfm.beans.OrderData;
import kr.co.kfm.beans.OrderDetail;
import kr.co.kfm.beans.OrderSituationBean;
import kr.co.kfm.beans.SellNBuyBuyBean;
import kr.co.kfm.beans.SellNBuyContentbean;
import kr.co.kfm.beans.SellNBuyIOBean;

@Mapper
public interface SellNBuyMapper {
    
    // �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕 - �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�떢怨ㅼ삕 �뜝�룞�삕�뜝�룞�삕
    @Select("SELECT o.order_state, " +
            "TO_CHAR(o.order_date, 'YYYY-MM-DD') AS order_date, " +
            "lo.order_id, " +
            "MAX(lo.supplier_id) AS supplier_id, " +
            "MAX(lp.product_id) AS product_id, " +
            "MAX(lp.quantity) AS quantity, " +
            "o.memo, " +
            "o.user_idx " +
            "FROM Orders o " +
            "JOIN Logistics_center_order lo ON o.order_id = lo.order_id " +
            "JOIN Logistics_center_order_product lp ON lo.order_id = lp.order_id " +
            "GROUP BY o.order_state, TO_CHAR(o.order_date, 'YYYY-MM-DD'), lo.order_id, o.memo, o.user_idx")
    List<SellNBuyContentbean> getBuyList();

    // �뜝�룞�삕�뜝�뙇�눦�삕 �뜝�뙗�눦�삕 �뜝�룞�삕 �뜝�룞�삕�뜝�뙃�릺�뙋�삕 �뜝�떢�벝�삕
    @Insert("INSERT INTO Orders (order_id, user_idx, order_date, due_date, memo, order_state) VALUES (#{order_id, jdbcType=VARCHAR}, #{user_idx, jdbcType=VARCHAR}, sysdate, #{due_date, jdbcType=DATE}, #{memo, jdbcType=VARCHAR}, #{order_state, jdbcType=VARCHAR})")
    void insertOrder(OrderData orderData);

    @Insert("INSERT INTO Franchisee_order (order_id, franchisee_id, logistics_center_id) VALUES (#{order_id, jdbcType=VARCHAR}, #{company_id, jdbcType=VARCHAR}, #{recipient_id, jdbcType=VARCHAR})")
    void insertLogisticsOrder(OrderData orderData);
    
    @Insert("INSERT INTO Logistics_center_order (order_id, logistics_center_id, supplier_id) VALUES (#{order_id, jdbcType=VARCHAR}, #{company_id, jdbcType=VARCHAR}, #{recipient_id, jdbcType=VARCHAR})")
    void insertSupplierOrder(OrderData orderData);

    @Insert("INSERT INTO Franchisee_order_product (product_id, order_id, quantity) VALUES (#{product_id, jdbcType=VARCHAR}, #{order_id, jdbcType=VARCHAR}, #{quantity, jdbcType=INTEGER})")
    void insertLogisticsOrderProduct(OrderDetail orderDetail);
    
    @Insert("INSERT INTO Logistics_center_order_product (product_id, order_id, quantity) VALUES (#{product_id, jdbcType=VARCHAR}, #{order_id, jdbcType=VARCHAR}, #{quantity, jdbcType=INTEGER})")
    void insertSupplierOrderProduct(OrderDetail orderDetail);

    // �뜝�룞�삕�뜝�뙇�눦�삕 �뜝�뙗�눦�삕 �뜝�룞�삕 �뜝�룞�삕夷됲깙�뜝占� �뜝�떦�뙋�삕 �뜝�떢�벝�삕
    // �뜝�떊琉꾩삕泥� �뜝�룞�삕�뜝占�
    @Select("select company_name, sp.supplier_id as company_id from Supplier sp join account ac on ac.Logistics_center_id = #{company_id} and ac.supplier_id = sp.supplier_id")
    List<SellNBuyBuyBean> getSupplierList(String company_id);
    
    @Select("select company_name, lc.logistics_center_id as company_id from Logistics_center lc join account ac on ac.Franchisee_id = #{company_id} and ac.logistics_center_id = lc.logistics_center_id")
    List<SellNBuyBuyBean> getLogisticsList(String company_id);

    // �뜝�룞�삕�뜘�돓璵��댙�삕�뜝占� �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뭹�뜝�룞�삕 �뜝�룞�삕�뜝占� �뜝�룞�삕�뜝�룞�삕 �떚�뜝�뙐�벝�삕 �뜝�룞�삕�뜝占�
    @Select("select pr.product_id, pr.name, pr.initial_quantity, pr.sell_price "
    		+ "from Product pr "
    		+ "where pr.product_id = #{product_id}")
    List<SellNBuyBuyBean> searchProduct(String product_id);

    // �뜝�룞�삕�뜘�돓�뜝占� �뜝�뙣�뙋�삕�뜝�룞�삕 name�뜝�룞�삕 �뜝�룞�삕�뜝占�
    @Select("select pr.product_id, pr.name "
    		+ "from Product pr "
    		+ "join Franchisee_inventory fi on fi.product_id = pr.product_id "
    		+ "where fi.franchisee_id = #{company_id}")
    List<SellNBuyBuyBean> getProductname(String company_id);

    @Select("SELECT o.order_id, o.memo, o.order_state, TO_CHAR(o.order_date, 'YYYY-MM-DD') AS order_date, fo.logistics_center_id as recipient_id " +
    		"FROM orders o " + 
    		"JOIN Franchisee_order fo ON o.order_id = fo.order_id " +
    		"WHERE o.order_id = #{order_id}")
    OrderData getFranchiseeOrderData(@Param("order_id") String order_id);

    // �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕 (�뜝�뙇諭꾩삕)
    @Select("SELECT o.order_id, o.memo, o.order_state, TO_CHAR(o.order_date, 'YYYY-MM-DD') AS order_date, lo.supplier_id as recipient_id " +
            "FROM orders o " + 
            "JOIN Logistics_center_order lo ON o.order_id = lo.order_id " +
            "WHERE o.order_id = #{order_id}")
    OrderData getLogisticsOrderData(@Param("order_id") String order_id);
    
    
    // �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕
    @Select("SELECT o.order_id, o.memo, o.order_state, TO_CHAR(o.order_date, 'YYYY-MM-DD') AS order_date, fo.logistics_center_id as recipient_id, " +
            "fp.product_id, p.name, fp.quantity, p.buy_price " +
            "FROM Orders o " +
            "JOIN Franchisee_order fo ON o.order_id = fo.order_id " +
            "JOIN Franchisee_order_product fp ON fo.order_id = fp.order_id " +
            "JOIN Product p ON fp.product_id = p.product_id " +
            "WHERE o.order_id = #{order_id}")
    List<OrderDetail> getFranchiseeOrderDetails(@Param("order_id") String order_id);
    
    @Select("SELECT o.order_id, o.memo, o.order_state, TO_CHAR(o.order_date, 'YYYY-MM-DD') AS order_date, lo.supplier_id as recipient_id, " +
            "lp.product_id, p.name, lp.quantity, p.buy_price " +
            "FROM Orders o " +
            "JOIN Logistics_center_order lo ON o.order_id = lo.order_id " +
            "JOIN Logistics_center_order_product lp ON lo.order_id = lp.order_id " +
            "JOIN Product p ON lp.product_id = p.product_id " +
            "WHERE o.order_id = #{order_id}")
    List<OrderDetail> getLogisticsOrderDetails(@Param("order_id") String order_id);
    

    //�뜝�룞�삕�뜝�뙇�긽�꽭�냲�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�뙃怨ㅼ삕泥섇뜝�룞�삕�뜝�떦源띿삕
    @Insert("INSERT INTO IO (IO_id, order_id, product_id, io_date, quantity, division, user_idx, memo) VALUES (#{io_id, jdbcType=VARCHAR}, #{order_id, jdbcType=VARCHAR}, #{product_id, jdbcType=VARCHAR}, sysdate, #{quantity, jdbcType=INTEGER}, #{division, jdbcType=VARCHAR}, #{user_idx, jdbcType=VARCHAR}, #{memo, jdbcType=VARCHAR})")
    void insertIO(SellNBuyIOBean io);
    
    @Update("UPDATE Franchisee_inventory SET current_stock = current_stock + #{quantity} WHERE franchisee_id = #{company_id} AND product_id = #{product_id}")
    void updateFranchiseeInventory(@Param("company_id") String company_id, @Param("product_id") String product_id, @Param("quantity") int quantity);
    
    @Update("UPDATE Logistics_center_inventory SET current_stock = current_stock + #{quantity} WHERE logistics_center_id = #{company_id} AND product_id = #{product_id}")
    void updateLogisticsCenterInventory(@Param("company_id") String company_id, @Param("product_id") String product_id, @Param("quantity") int quantity);

    @Select("SELECT product_id, quantity FROM Franchisee_order_product WHERE order_id = #{orderId}")
    List<OrderDetail> getDetails(@Param("orderId") String orderId);
    
    
    // �뜝�떎紐뚯삕 �뜝�룞�삕�뜝�룞�삕 - �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룜媛� �뜝�룞�삕�뜝�룞�삕
    @Select("SELECT o.order_state, " +
            "TO_CHAR(o.order_date, 'YYYY-MM-DD') AS order_date, " +
            "fo.order_id, " +
            "MAX(fo.logistics_center_id) AS logistics_center_id, " +
            "MAX(fp.product_id) AS product_id, " +
            "MAX(fp.quantity) AS quantity, " +
            "MAX(o.memo) AS memo, " +
            "MAX(o.user_idx) AS user_idx " +
            "FROM Orders o " +
            "JOIN Franchisee_order fo ON o.order_id = fo.order_id " +
            "JOIN Franchisee_order_product fp ON fo.order_id = fp.order_id " +
            "GROUP BY o.order_state, TO_CHAR(o.order_date, 'YYYY-MM-DD'), fo.order_id")
    List<SellNBuyContentbean> getSellList();
    
 // �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占� - �뜝�뙇諭꾩삕 �뜝�룞�삕泥�(�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 - �뜝�룞�삕�뜝�뙇紐뚯삕�뜝占�)
    @Select("select od.order_id, od.order_state, od.order_date, fo.company_name, "
    		+ "fp.product_count, fp.total_price, od.memo, ui.name, io.completeio "
    		+ "from Orders od "
    		+ "join User_info ui on ui.user_idx = od.user_idx "
    		+ "join( "
    		+ "    select fo.order_id, fr.company_name "
    		+ "    from Franchisee_order fo "
    		+ "    join Franchisee fr on fr.franchisee_id = fo.franchisee_id "
    		+ "    where fo.franchisee_id = #{company_id} "
    		+ ") fo on fo.order_id = od.order_id "
    		+ "left join ( "
    		+ "    select fp.order_id, count(fp.product_id) as product_count, sum(quantity * sell_price) as total_price "
    		+ "    from Franchisee_order_product fp "
    		+ "    join Product pr on pr.product_id = fp.product_id "
    		+ "    group by order_id "
    		+ ") fp on fp.order_id = od.order_id "
    		+ "left join ( "
    		+ "    select fp.order_id, count(fp.order_id) as completeio "
    		+ "    from Franchisee_order_product fp "
    		+ "    join( "
    		+ "        select io.order_id, io.product_id, sum(io.quantity) as total_quantity "
    		+ "        from IO io "
    		+ "        where Exists (select 1 from Franchisee_order_product fp where fp.order_id = io.order_id) "
    		+ "        group by io.order_id, io.product_id "
    		+ "    ) io on io.order_id = fp.order_id and io.product_id = fp.product_id "
    		+ "    where io.total_quantity = fp.quantity "
    		+ "    group by fp.order_id "
    		+ ") io on io.order_id = od.order_id "
    		+ "order by od.order_date desc")
    List<SellNBuyBuyBean> getFranchiseeOrderInfo(String company_id);
    
    // �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占� - �뜝�뙇諭꾩삕 �뜝�룞�삕泥� (�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 - �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�)
    @Select("select od.order_id, od.order_state, od.order_date, lo.company_name,  "
    		+ "lp.product_count, lp.total_price, od.memo, ui.name, io.completeio "
    		+ "from Orders od "
    		+ "join User_info ui on ui.user_idx = od.user_idx "
    		+ "join( "
    		+ "    select lo.order_id, lc.company_name "
    		+ "    from Logistics_center_order lo "
    		+ "    join Logistics_center lc on lc.logistics_center_id = lo.logistics_center_id "
    		+ "    where lo.logistics_center_id = #{company_id} "
    		+ ") lo on lo.order_id = od.order_id "
    		+ "left join ( "
    		+ "    select lp.order_id, count(lp.product_id) as product_count, sum(quantity * sell_price) as total_price "
    		+ "    from Logistics_center_order_product lp "
    		+ "    join Product pr on pr.product_id = lp.product_id "
    		+ "    group by order_id "
    		+ ") lp on lp.order_id = od.order_id "
    		+ "left join ( "
    		+ "    select lp.order_id, count(lp.order_id) as completeio "
    		+ "    from Logistics_center_order_product lp "
    		+ "    join( "
    		+ "        select io.order_id, io.product_id, sum(io.quantity) as total_quantity "
    		+ "        from IO io "
    		+ "        where Exists (select 1 from Logistics_center_order_product lp where lp.order_id = io.order_id) "
    		+ "        group by io.order_id, io.product_id "
    		+ "    ) io on io.order_id = lp.order_id and io.product_id = lp.product_id "
    		+ "    where io.total_quantity = lp.quantity "
    		+ "    group by lp.order_id "
    		+ ") io on io.order_id = od.order_id "
    		+ "order by od.order_date desc")
    List<SellNBuyBuyBean> getLogisticsOrderInfo(String company_id);
    
 // �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占� - �뜝�뙇諭꾩삕 �뜝�룞�삕泥�(�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 - �뜝�룞�삕�뜝�뙇紐뚯삕�뜝占�)
    @Select("select od.order_id, od.order_state, od.order_date, fo.company_name, "
    		+ "fp.product_count, fp.total_price, od.memo, ui.name, io.completeio "
    		+ "from Orders od "
    		+ "join User_info ui on ui.user_idx = od.user_idx "
    		+ "join( "
    		+ "    select fo.order_id, fr.company_name "
    		+ "    from Franchisee_order fo "
    		+ "    join Franchisee fr on fr.franchisee_id = fo.franchisee_id "
    		+ "    where fo.franchisee_id = #{company_id} "
    		+ ") fo on fo.order_id = od.order_id "
    		+ "left join ( "
    		+ "    select fp.order_id, count(fp.product_id) as product_count, sum(quantity * sell_price) as total_price "
    		+ "    from Franchisee_order_product fp "
    		+ "    join Product pr on pr.product_id = fp.product_id "
    		+ "    group by order_id "
    		+ ") fp on fp.order_id = od.order_id "
    		+ "left join ( "
    		+ "    select fp.order_id, count(fp.order_id) as completeio "
    		+ "    from Franchisee_order_product fp "
    		+ "    join( "
    		+ "        select io.order_id, io.product_id, sum(io.quantity) as total_quantity "
    		+ "        from IO io "
    		+ "        where Exists (select 1 from Franchisee_order_product fp where fp.order_id = io.order_id) "
    		+ "        group by io.order_id, io.product_id "
    		+ "    ) io on io.order_id = fp.order_id and io.product_id = fp.product_id "
    		+ "    where io.total_quantity = fp.quantity "
    		+ "    group by fp.order_id "
    		+ ") io on io.order_id = od.order_id "
    		+ "where od.order_state = #{order_state} "
    		+ "order by od.order_date desc")
 	List<SellNBuyBuyBean> getFranchiseeOrderStateInfo(@Param("company_id") String company_id,
 			@Param("order_state") String order_state);
    
    // �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占� - �뜝�뙇諭꾩삕 �뜝�룞�삕泥� (�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 - �뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝占�)
    @Select("select od.order_id, od.order_state, od.order_date, lo.company_name,  "
    		+ "lp.product_count, lp.total_price, od.memo, ui.name, io.completeio "
    		+ "from Orders od "
    		+ "join User_info ui on ui.user_idx = od.user_idx "
    		+ "join( "
    		+ "    select lo.order_id, lc.company_name "
    		+ "    from Logistics_center_order lo "
    		+ "    join Logistics_center lc on lc.logistics_center_id = lo.logistics_center_id "
    		+ "    where lo.logistics_center_id = #{company_id} "
    		+ ") lo on lo.order_id = od.order_id "
    		+ "left join ( "
    		+ "    select lp.order_id, count(lp.product_id) as product_count, sum(quantity * sell_price) as total_price "
    		+ "    from Logistics_center_order_product lp "
    		+ "    join Product pr on pr.product_id = lp.product_id "
    		+ "    group by order_id "
    		+ ") lp on lp.order_id = od.order_id "
    		+ "left join ( "
    		+ "    select lp.order_id, count(lp.order_id) as completeio "
    		+ "    from Logistics_center_order_product lp "
    		+ "    join( "
    		+ "        select io.order_id, io.product_id, sum(io.quantity) as total_quantity "
    		+ "        from IO io "
    		+ "        where Exists (select 1 from Logistics_center_order_product lp where lp.order_id = io.order_id) "
    		+ "        group by io.order_id, io.product_id "
    		+ "    ) io on io.order_id = lp.order_id and io.product_id = lp.product_id "
    		+ "    where io.total_quantity = lp.quantity "
    		+ "    group by lp.order_id "
    		+ ") io on io.order_id = od.order_id "
    		+ "where od.order_state = #{order_state} "
    		+ "order by od.order_date desc")
 	List<SellNBuyBuyBean> getLogisticsOrderStateInfo(@Param("company_id") String company_id,
 			@Param("order_state") String order_state);
    
 // 諛쒖＜ �쁽�솴 -> 諛쒖＜ �긽�꽭 �뜲�씠�꽣 => �빐�떦 諛쒖＜ �뜲�씠�꽣留� 媛��졇�샂(媛�留뱀젏 諛쒖＜ �긽�꽭 �솗�씤)
 	@Select("select od.order_id, od.order_state, od.order_date, od.due_date, fr.company_name "
 		+ "from Orders od "
 		+ "join( "
 		+ "select fo.order_id, fr.company_name "
 		+ "from Franchisee_order fo "
 		+ "join Franchisee fr on fo.franchisee_id = fr.franchisee_id "
 		+ ") fr on fr.order_id = od.order_id "
 		+ "where od.order_id = #{order_id}")
 	SellNBuyBuyBean getLogisticsOrdersInfo(@Param("order_id") String order_id);
 	
 	// 諛쒖＜ �쁽�솴 -> 諛쒖＜ �긽�꽭 �뜲�씠�꽣 => 諛쒖＜�븳 �젣�뭹留� 媛��졇�샂(媛�留뱀젏 諛쒖＜ �긽�꽭 �솗�씤)
 	@Select("select od.order_id, pr.name, pr.sell_price, pr.brand, pr.img, pr.specifications, pr.classification, pr.quantity "
 		+ "from Orders od "
 		+ "join( "
 		+ "select fp.order_id, fp.quantity, pr.name, pr.sell_price, pr.brand, pr.img, pr.specifications, pr.classification "
 		+ "from Franchisee_order_product fp "
 		+ "join Product pr on fp.product_id = pr.product_id "
 		+ ") pr on pr.order_id = od.order_id "
 		+ "where od.order_id = #{order_id}")
 	List<SellNBuyBuyBean> getLogisticsOrdersProductInfo(@Param("order_id")String order_id);
 	
 	// 諛쒖＜ �쁽�솴 -> 諛쒖＜ �긽�꽭 �뜲�씠�꽣 => 諛쒖＜�븳 �젣�뭹�쓽 �엯怨� �궡�뿭留� 媛��졇�샂
 	
 	
 	// 諛쒖＜ �쁽�솴 -> 諛쒖＜ �긽�꽭 �뜲�씠�꽣 => �빐�떦 諛쒖＜ �뜲�씠�꽣留� 媛��졇�샂(臾쇰쪟�꽱�꽣 諛쒖＜ �긽�꽭 �솗�씤)
 		@Select("select od.order_id, od.order_state, od.order_date, od.due_date, lc.company_name "
 			+ "from Orders od "
 			+ "join( "
 			+ "select lo.order_id, lc.company_name "
 			+ "from Logistics_center_order lo "
 			+ "join Logistics_center lc on lo.logistics_center_id = lc.logistics_center_id"
 			+ ") lc on lc.order_id = od.order_id "
 			+ "where od.order_id = #{order_id}")
 		SellNBuyBuyBean getSupplierOrdersInfo(@Param("order_id") String order_id);
 		
 		// 諛쒖＜ �쁽�솴 -> 諛쒖＜ �긽�꽭 �뜲�씠�꽣 => 諛쒖＜�븳 �젣�뭹留� 媛��졇�샂(臾쇰쪟�꽱�꽣 諛쒖＜ �긽�꽭 �솗�씤)
 		@Select("select od.order_id, pr.name, pr.sell_price, pr.brand, pr.img, pr.specifications, pr.classification, pr.quantity "
 			+ "from Orders od "
 			+ "join( "
 			+ "select lp.order_id, lp.quantity, pr.name, pr.sell_price, pr.brand, pr.img, pr.specifications, pr.classification "
 			+ "from Logistics_center_order_product lp "
 			+ "join Product pr on lp.product_id = pr.product_id "
 			+ ") pr on pr.order_id = od.order_id "
 			+ "where od.order_id = #{order_id}")
 		List<SellNBuyBuyBean> getSupplierOrdersProductInfo(@Param("order_id")String order_id);
 		
 		// 諛쒖＜ �쁽�솴 -> 諛쒖＜ �긽�꽭 �뜲�씠�꽣 -> �엯怨� �쁽�솴(臾쇰쪟�꽱�꽣 �엯�옣)
 		@Select("select fp.order_id, pr.name, pr.brand, pr.img, pr.specifications, pr.classification, io.product_quantity, fp.quantity as total_quantity "
 				+ "from Franchisee_order_product fp "
 				+ "join Product pr on fp.product_id = pr.product_id  "
 				+ "join ( "
 				+ "    select order_id, product_id, sum(quantity) as product_quantity "
 				+ "    from IO "
 				+ "    group by order_id, product_id "
 				+ ") io on io.order_id = fp.order_id and io.product_id = fp.product_id "
 				+ "where fp.order_id = #{order_id}")
 		List<SellNBuyBuyBean> getIOLogisticsCurrent(@Param("order_id") String order_id);
 		

 		// 諛쒖＜ �쁽�솴 -> 諛쒖＜ �긽�꽭 �뜲�씠�꽣 -> �엯怨� �쁽�솴(臾쇰쪟�꽱�꽣 �엯�옣)
 		@Select("select lp.order_id, pr.name, pr.brand, pr.img, pr.specifications, pr.classification, io.product_quantity, lp.quantity as total_quantity "
 				+ "from Logistics_center_order_product lp "
 				+ "join Product pr on lp.product_id = pr.product_id  "
 				+ "join ( "
 				+ "    select order_id, product_id, sum(quantity) as product_quantity "
 				+ "    from IO "
 				+ "    group by order_id, product_id "
 				+ ") io on io.order_id = lp.order_id and io.product_id = lp.product_id "
 				+ "where lp.order_id = #{order_id}")
 		List<SellNBuyBuyBean> getIOSupplierCurrent(@Param("order_id") String order_id);
 		
 		// 諛쒖＜ �쁽�솴 -> 諛쒖＜ �긽�꽭 �뜲�씠�꽣 -> �엯怨� �궡�뿭
 		@Select("select io.io_id, io_date, io.memo, pt.product_quantity, pt.total_quantity, ui.name "
 				+ "from IO io "
 				+ "join User_info ui on ui.user_idx = io.user_idx "
 				+ "join( "
 				+ "    select io_id, count(product_id) as product_quantity, sum(quantity) as total_quantity "
 				+ "    from IO io "
 				+ "    group by io_id "
 				+ ") pt on io.io_id = pt.io_id "
 				+ "where io.order_id = #{order_id}")
 		List<SellNBuyBuyBean> getIOdata(@Param("order_id")String order_id);
 		
 		@Update("update orders set order_state = '입고 완료' where order_id = #{order_id}")
 		void updateBulk(@Param("order_id") String order_id);
 		
}
