package kr.co.kfm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.co.kfm.beans.IOBean;

@Mapper
public interface IOMapper {
	
	@Select("select "
			+ "    pr.img, "
			+ "    pr.name, "
			+ "    pr.classification, "
			+ "    pr.brand, "
			+ "    pr.specifications, "
			+ "    coalesce(inp.inputQuantity, 0) as inputQuantity, "
			+ "    coalesce(outp.outputQuantity, 0) as outputQuantity, "
			+ "    coalesce(io.IOQuantity, 0) as IOQuantity, li.current_stock "
			+ "from Product pr "
			+ "left join ( "
			+ "    select io.product_id, sum(io.quantity) as inputQuantity "
			+ "    from IO io "
			+ "    where io_date between '2024-05-24' and '2024-06-24' and division = '입고' "
			+ "    group by io.product_id "
			+ ") inp on inp.product_id = pr.product_id "
			+ "left join ( "
			+ "    select io.product_id, sum(io.quantity) as outputQuantity "
			+ "    from IO io "
			+ "    where io_date between '2024-05-24' and '2024-06-24' and division = '출고' "
			+ "    group by io.product_id "
			+ ") outp on outp.product_id = pr.product_id "
			+ "left join ("
			+ "    select io.product_id, sum(io.quantity) as IOQuantity "
			+ "    from IO io"
			+ "    where io_date between '2024-05-24' and '2024-06-24' and division = '조정' "
			+ "    group by io.product_id "
			+ ") io on io.product_id = pr.product_id "
			+ "join("
			+ "    select product_id, current_stock "
			+ "    from logistics_center_inventory li "
			+ "    where li.logistics_center_id = #{logistics_center_id} "
			+ ") li on li.product_id = pr.product_id ")
	List<IOBean> LCincoming_and_outgoing(String logistics_center_id);
	
	@Select("select pr.img, "
			+ "pr.name, "
			+ "pr.classification, "
			+ "pr.brand, "
			+ "pr.specifications, "
			+ "coalesce(inp.inputQuantity, 0) as inputQuantity, "
			+ "coalesce(outp.outputQuantity, 0) as outputQuantity, "
			+ "coalesce(io.IOQuantity, 0) as IOQuantity, fi.current_stock "
			+ "from Product pr "
			+ "join ( "
			+ "    select io.product_id, sum(io.quantity) as inputQuantity "
			+ "    from IO io "
			+ "    where io_date between '2024-05-26' and '2024-06-26' and division = '입고' "
			+ "    group by io.product_id "
			+ ") inp on inp.product_id = pr.product_id "
			+ "left join ( "
			+ "    select io.product_id, sum(io.quantity) as outputQuantity "
			+ "    from IO io "
			+ "    where io_date between '2024-05-26' and '2024-06-26' and division = '출고' "
			+ "    group by io.product_id "
			+ ") outp on outp.product_id = pr.product_id "
			+ "left join ( "
			+ "    select io.product_id, sum(io.quantity) as IOQuantity "
			+ "    from IO io "
			+ "    where io_date between '2024-05-26' and '2024-06-26' and division = '조정' "
			+ "    group by io.product_id "
			+ ") io on io.product_id = pr.product_id "
			+ "left join( "
			+ "    select product_id, current_stock "
			+ "    from franchisee_inventory fi "
			+ "    where fi.franchisee_id = #{franchisee_id} "
			+ ")fi on fi.product_id = pr.product_id")
	List<IOBean> Fincoming_and_outgoing(String franchisee_id);
	
}
