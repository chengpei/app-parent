package com.whpe.webservices;

import org.springframework.stereotype.Service;

@Service("whpeservice")
public class WhpeService {

	//验证操作员的卡
	public boolean isLogin(String nn) {
		return false;
	}

	//验证非操作员卡
	public String exeCommands(String cmd) {

		return "success";
	}

	public String exeFunction(String cmd) {
		return "successss";
	}

	public byte[] downTransferInfor(String args) {
		return null;
	}

	public boolean upTransferInfor(byte[] infor, String args) {
		return false;
	}

}
