package kr.co.kfm.service;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kfm.beans.UserBean;
import kr.co.kfm.beans.product_HistoryBean;
import kr.co.kfm.dao.HistoryDao;

@Service
public class HistoryService {

    @Autowired
    private HistoryDao historyDao;

    @Resource(name = "loginUserBean")
	private UserBean loginUserBean;
    
	public List<product_HistoryBean> getHistoryByDate(String change_date) {
		if (loginUserBean.getCompanyid().startsWith("LC")) {
			System.out.println("lc�Է�");
			System.out.println(change_date);
			System.out.println(loginUserBean.getCompanyid());
			return historyDao.getHistoryByDateLC(change_date, loginUserBean.getCompanyid());
		} else if (loginUserBean.getCompanyid().startsWith("F")) {
			return historyDao.getHistoryByDateF(change_date, loginUserBean.getCompanyid());
		}
		return null;
	}
	
}
