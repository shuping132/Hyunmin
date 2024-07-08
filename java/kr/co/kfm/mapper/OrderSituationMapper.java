package kr.co.kfm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.co.kfm.beans.OrderData;
import kr.co.kfm.beans.OrderSituationBean;

@Mapper
public interface OrderSituationMapper {

	// 占쏙옙占쏙옙 占쏙옙황 => 占쏙옙占쏙옙 占쏙옙占승울옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 확占쏙옙)
	@Select("select fr.company_name, fr.address, od.order_id, od.order_state, od.order_date, fp.total_price, fp.counting "
			+ "from Orders od "
			+ "left join ( "
			+ "    select fp.order_id, sum(pr.sell_price * fp.quantity) as total_price, count(fp.product_id) as counting "
			+ "    from Franchisee_order_product fp "
			+ "    join Product pr on pr.product_id = fp.product_id "
			+ "    group by fp.order_id "
			+ ") fp ON fp.order_id = od.order_id "
			+ "join ( "
			+ "    select fo.order_id, fr.company_name, fr.address "
			+ "    from Franchisee_order fo "
			+ "    join Franchisee fr on fr.franchisee_id = fo.franchisee_id "
			+ "    where fo.logistics_center_id = #{company_id} "
			+ ") fr ON fr.order_id = od.order_id "
			+ "where od.order_state = #{order_state} "
			+ "order by od.order_date desc")
	List<OrderSituationBean> getLogisticsOrderData(@Param("order_state") String order_state, @Param("company_id") String company_id);
	
	// 占쏙옙占쏙옙 占쏙옙황 => 占쏙옙占쏙옙 占쏙옙占승곤옙 占쏙옙占쏙옙 占쏙옙청, 占쌉곤옙 占쏙옙占� 혹占쏙옙 占싸븝옙 占쌉곤옙 占싹쏙옙 占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 확占쏙옙)
	@Select("select fr.company_name, fr.address, od.order_id, od.order_state, od.order_date, fp.total_price, fp.counting "
			+ "from Orders od "
			+ "left join ( "
			+ "    select fp.order_id, sum(pr.sell_price * fp.quantity) as total_price, count(fp.product_id) as counting "
			+ "    from Franchisee_order_product fp "
			+ "    join Product pr on pr.product_id = fp.product_id "
			+ "    group by fp.order_id "
			+ ") fp ON fp.order_id = od.order_id "
			+ "join ( "
			+ "    select fo.order_id, fr.company_name, fr.address "
			+ "    from Franchisee_order fo "
			+ "    join Franchisee fr on fr.franchisee_id = fo.franchisee_id "
			+ "    where fo.logistics_center_id = #{company_id} "
			+ ") fr ON fr.order_id = od.order_id "
			+ "where od.order_state in ('승인', '부분 입고') "
			+ "order by od.order_date desc")
	List<OrderSituationBean> getLogisticsOrderWaitData(@Param("company_id") String company_id);

	// 占쏙옙占쏙옙 占쏙옙황 => 占쏙옙占쏙옙 占쏙옙占승울옙 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 확占쏙옙)
	@Select("select lc.company_name, lc.address, od.order_id ,od.order_state, od.order_date, lp.total_price, lp.counting "
		+ "from Orders od "
		+ "left join( "
		+ "select lp.order_id, sum(sell_price * quantity) as total_price , count(lp.product_id) as counting "
		+ "from Logistics_center_order_product lp "
		+ "join Product pr on pr.product_id = lp.product_id "
		+ "group by order_id "
		+ ") lp ON lp.order_id = od.order_id "
		+ "join( "
		+ "select lo.order_id, lc.company_name, lc.address "
		+ "from Logistics_center_order lo  "
		+ "join Logistics_center lc on lc.logistics_center_id = lo.logistics_center_id "
		+ "where lo.supplier_id = #{company_id} "
		+ ") lc ON lc.order_id = od.order_id "
		+ "where od.order_state = #{order_state} "
		+ "order by od.order_date desc")
	List<OrderSituationBean> getSupplierOrderData(@Param("order_state") String order_state, @Param("company_id") String company_id);
		 
	// 占쏙옙占쏙옙 占쏙옙황 => 占쏙옙占쏙옙 占쏙옙占승곤옙 占쏙옙占쏙옙 占쏙옙청, 占쌉곤옙 占쏙옙占� 혹占쏙옙 占싸븝옙 占쌉곤옙 占싹쏙옙 占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 확占쏙옙)
	@Select("select lc.company_name, lc.address, od.order_id ,od.order_state, od.order_date, lp.total_price, lp.counting "
		+ "from Orders od "
		+ "left join( "
		+ "select lp.order_id, sum(sell_price * quantity) as total_price , count(lp.product_id) as counting "
		+ "from Logistics_center_order_product lp "
		+ "join Product pr on pr.product_id = lp.product_id "
		+ "group by order_id "
		+ ") lp ON lp.order_id = od.order_id "
		+ "join( "
		+ "select lo.order_id, lc.company_name, lc.address "
		+ "from Logistics_center_order lo "
		+ "join Logistics_center lc on lc.logistics_center_id = lo.logistics_center_id "
		+ "where lo.supplier_id = #{company_id} "
		+ ") lc ON lc.order_id = od.order_id "
		+ "where od.order_state in ('승인', '부분 입고') "
		+ "order by od.order_date desc")	
	List<OrderSituationBean> getSupplierOrderWaitData(@Param("company_id") String company_id);

	// 占쏙옙占쏙옙 占쏙옙황 -> 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 => 占쌔댐옙 占쏙옙占쏙옙 占쏙옙占쏙옙占싶몌옙 占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 확占쏙옙)
	@Select("select od.order_id, od.order_state, od.order_date, od.due_date, fr.company_name " + "from Orders od "
			+ "join( " + "select fo.order_id, fr.company_name " + "from Franchisee_order fo "
			+ "join Franchisee fr on fo.franchisee_id = fr.franchisee_id " + ") fr on fr.order_id = od.order_id "
			+ "where od.order_id = #{order_id}")
	OrderSituationBean getLogisticsOrderInfo(@Param("order_id") String order_id);

	// 占쏙옙占쏙옙 占쏙옙황 -> 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 => 占쏙옙占쏙옙占쏙옙 占쏙옙품占쏙옙 占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 확占쏙옙)
	@Select("select od.order_id, pr.name, pr.sell_price, pr.brand, pr.img, pr.specifications, pr.classification, pr.quantity "
			+ "from Orders od " + "join( "
			+ "select fp.order_id, fp.quantity, pr.name, pr.sell_price, pr.brand, pr.img, pr.specifications, pr.classification "
			+ "from Franchisee_order_product fp " + "join Product pr on fp.product_id = pr.product_id "
			+ ") pr on pr.order_id = od.order_id " + "where od.order_id = #{order_id}")
	List<OrderSituationBean> getLogisticsOrderProductInfo(@Param("order_id") String order_id);

	// 占쏙옙占쏙옙 占쏙옙황 -> 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 => 占쏙옙占쏙옙占쏙옙 占쏙옙품占쏙옙 占쌉곤옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙

	// 占쏙옙占쏙옙 占쏙옙황 -> 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 => 占쌔댐옙 占쏙옙占쏙옙 占쏙옙占쏙옙占싶몌옙 占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 확占쏙옙)
	@Select("select od.order_id, od.order_state, od.order_date, od.due_date, lc.company_name " + "from Orders od "
			+ "join( " + "select lo.order_id, lc.company_name " + "from Logistics_center_order lo "
			+ "join Logistics_center lc on lo.logistics_center_id = lc.logistics_center_id"
			+ ") lc on lc.order_id = od.order_id " + "where od.order_id = #{order_id}")
	OrderSituationBean getSupplierOrderInfo(@Param("order_id") String order_id);

	// 占쏙옙占쏙옙 占쏙옙황 -> 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 => 占쏙옙占쏙옙占쏙옙 占쏙옙품占쏙옙 占쏙옙占쏙옙占쏙옙(占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 확占쏙옙)
	@Select("select od.order_id, pr.name, pr.sell_price, pr.brand, pr.img, pr.specifications, pr.classification, pr.quantity "
			+ "from Orders od " + "join( "
			+ "select lp.order_id, lp.quantity, pr.name, pr.sell_price, pr.brand, pr.img, pr.specifications, pr.classification "
			+ "from Logistics_center_order_product lp "
			+ "join Product pr on lp.product_id = pr.product_id "
			+ ") pr on pr.order_id = od.order_id "
			+ "where od.order_id = #{order_id}")
		List<OrderSituationBean> getSupplierOrderProductInfo(@Param("order_id")String order_id);

		// 占쏙옙占쏙옙 占쏙옙황 -> 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 -> 占쌉곤옙 占쏙옙占쏙옙
		@Select("select IO_id, IO_date, count(product_id) as product_quantity, sum(quantity) as total_quantity, ui.name "
				+ "from IO io "
				+ "join User_info ui on ui.user_idx = io.user_idx "
				+ "where order_id = #{order_id} "
				+ "group by IO_id, IO_Date, ui.name "
				+ "order by IO_id")
		List<OrderSituationBean> getIOdata(@Param("order_id")String order_id);
		
		// 占쏙옙占쏙옙 占쏙옙황 -> 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 -> 占쌉곤옙 占쏙옙황(占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙)
		@Select("select fp.order_id, pr.name, pr.brand, pr.img, pr.specifications, pr.classification, io.product_quantity, fp.quantity as total_quantity "
				+ "from Franchisee_order_product fp "
				+ "join Product pr on fp.product_id = pr.product_id  "
				+ "join ( "
				+ "    select order_id, product_id, sum(quantity) as product_quantity "
				+ "    from IO "
				+ "    group by order_id, product_id "
				+ ") io on io.order_id = fp.order_id and io.product_id = fp.product_id "
				+ "where fp.order_id = #{order_id}")
		List<OrderSituationBean> getIOLogisticsCurrent(@Param("order_id") String order_id);
		

		// 占쏙옙占쏙옙 占쏙옙황 -> 占쏙옙占쏙옙 占쏙옙 占쏙옙占쏙옙占쏙옙 -> 占쌉곤옙 占쏙옙황(占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙)
		@Select("select lp.order_id, pr.name, pr.brand, pr.img, pr.specifications, pr.classification, io.product_quantity, lp.quantity as total_quantity "
				+ "from Logistics_center_order_product lp "
				+ "join Product pr on lp.product_id = pr.product_id  "
				+ "join ( "
				+ "    select order_id, product_id, sum(quantity) as product_quantity "
				+ "    from IO "
				+ "    group by order_id, product_id "
				+ ") io on io.order_id = lp.order_id and io.product_id = lp.product_id "
				+ "where lp.order_id = #{order_id}")
		List<OrderSituationBean> getIOSupplierCurrent(@Param("order_id") String order_id);		
		
		
		@Update("update Orders set order_state = #{order_state} where order_id = #{order_id}")
		void updateOrdersState(OrderData orderData);
		
		@Update("update Orders set order_state = #{order_state}, rejection = #{reject_memo} where order_id = #{order_id}")
		void updateRejectOrdersState(OrderData orderData);
		
		@Select("select od.order_id, od.order_state, od.order_date, fo.company_name,  "
				+ "fp.product_quantity "
				+ "from Orders od "
				+ "join User_info ui on ui.user_idx = od.user_idx "
				+ "join( "
				+ "    select fo.order_id, fr.company_name "
				+ "    from Franchisee_order fo "
				+ "    join Franchisee fr on fr.franchisee_id = fo.franchisee_id "
				+ "    where fr.franchisee_id = #{company_id} "
				+ ") fo on fo.order_id = od.order_id "
				+ "Left join ( "
				+ "    select fp.order_id, count(fp.product_id) as product_quantity, sum(quantity * sell_price) as total_price "
				+ "    from Franchisee_order_product fp "
				+ "    join Product pr on pr.product_id = fp.product_id "
				+ "    group by order_id "
				+ ") fp on fp.order_id = od.order_id "
				+ "order by od.order_date desc")
		List<OrderSituationBean> getRecentFranchiseeOrders(String company_id);
		
		// Ư�� ������ �ֽ� ���� ��Ȳ ������ �������� (��������)
		@Select("select od.order_id, od.order_state, od.order_date, lo.company_name,  "
				+ "lp.product_count "
				+ "from Orders od "
				+ "join User_info ui on ui.user_idx = od.user_idx "
				+ "join( "
				+ "    select lo.order_id, lc.company_name "
				+ "    from logistics_center_order lo "
				+ "    join logistics_center lc on lc.logistics_center_id = lo.logistics_center_id "
				+ "    where lc.logistics_center_id = 'LC00001' "
				+ ") lo on lo.order_id = od.order_id "
				+ "Left join ( "
				+ "    select lp.order_id, count(lp.product_id) as product_count, sum(quantity * sell_price) as total_price "
				+ "    from Logistics_center_order_product lp "
				+ "    join Product pr on pr.product_id = lp.product_id "
				+ "    group by order_id "
				+ ") lp on lp.order_id = od.order_id "
				+ "order by od.order_id desc")
		List<OrderSituationBean> getRecentLogisticsOrders(String company_id);
		
		
		
}
