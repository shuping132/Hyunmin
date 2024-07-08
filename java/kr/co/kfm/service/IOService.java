package kr.co.kfm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kfm.beans.IOBean;
import kr.co.kfm.beans.UserBean;
import kr.co.kfm.dao.IODao;

@Service
public class IOService {
	
	@Autowired
	private IODao iODao;
	
	@Resource(name = "loginUserBean")
	private UserBean loginUserBean;
	
	public List<IOBean> incoming_and_outgoing() {
		
		if (loginUserBean.getCompanyid().startsWith("LC")) {
			return iODao.LCincoming_and_outgoing(loginUserBean.getCompanyid());
		} else if (loginUserBean.getCompanyid().startsWith("F")) {
			return iODao.Fincoming_and_outgoing(loginUserBean.getCompanyid());
		}
		return null;

	}
}
