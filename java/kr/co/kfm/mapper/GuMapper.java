package kr.co.kfm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.co.kfm.beans.GuBean;
import kr.co.kfm.beans.Logistics_centerBean;

@Mapper
public interface GuMapper {

	//가맹점 로그인
	@Select("select * from Logistics_center where "
			+ "logistics_center_id in("
			+ "select logistics_center_id "
			+ "from Account where franchisee_id = #{company_id})")
	List<GuBean> getAccountInfo(String company_id);
	
	//물류센터 로그인
	@Select("select * from franchisee where "
			+ "franchisee_id in("
			+ "select franchisee_id "
			+ "from Account where Logistics_center_id = #{company_id})")
	List<GuBean> getAccount2Info(String company_id);
	
	@Select("select * from Supplier where "
			+ "supplier_id in("
			+ "select supplier_id "
			+ "from Account where Logistics_center_id = #{company_id})")
	List<GuBean> getAccount4Info(String company_id);
	
	//공급업체 로그인
	@Select("select * from Logistics_center where "
			+ "Logistics_center_id in("
			+ "select Logistics_center_id "
			+ "from Account where supplier_id = #{company_id})")
	List<GuBean> getAccount3Info(String company_id);
	
}
