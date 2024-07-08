package kr.co.kfm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kfm.beans.product_HistoryBean;
import kr.co.kfm.mapper.HistoryMapper;

@Repository
public class HistoryDao {

	@Autowired
	private HistoryMapper historyMapper;

	public List<product_HistoryBean> getHistoryByDateLC(String change_date, String logisticsCenterId) {
		return historyMapper.getHistoryByDateLC(change_date, logisticsCenterId);
	}
	public List<product_HistoryBean> getHistoryByDateF(String change_date, String franchiseeId) {
		return historyMapper.getHistoryByDateF(change_date, franchiseeId);
	}
}
