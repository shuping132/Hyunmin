package kr.co.kfm.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kfm.beans.IOBean;
import kr.co.kfm.mapper.IOMapper;

@Repository
public class IODao {
	
	@Autowired
	private IOMapper iOMapper;
	
	public List<IOBean> LCincoming_and_outgoing(String logistics_center_id) {
		return iOMapper.LCincoming_and_outgoing(logistics_center_id);
	}
	
	public List<IOBean> Fincoming_and_outgoing(String franchisee_id) {
		return iOMapper.Fincoming_and_outgoing(franchisee_id);
	}
}
