package com.bugtracking.bug;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bugtracking.shared.OperationStatusModel;

@RestController
public class BugRestImpl implements IBugRest {

	@Autowired
	IBugService bugServiceImpl;

	Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public List<BugDetailsWrapper> getAllBug() {
		return bugServiceImpl.getAllBug();
	}

	@Override
	public BugDetailsWrapper createbug(BugDetailsWrapper bugDetailsWrapper) {
		logger.info("In BugRestImpl createbug Parameter id {}", bugDetailsWrapper.getTitle());
		return bugServiceImpl.createbug(bugDetailsWrapper);
	}

	@Override
	public BugDetailsWrapper getbug(String id) {
		logger.info("In BugRestImpl getBug Parameter id {}", id);
		return bugServiceImpl.getbug(id);
	}

	@Override
	public BugDetailsWrapper updatebug(String id, BugDetailsWrapper bugDetailsWrapper) {
		logger.info("In BugRestImpl updateProject Parameter id {}", id);
		return bugServiceImpl.updatebug(id, bugDetailsWrapper);
	}

	@Override
	public OperationStatusModel deletebug(String id) {
		logger.info("In BugRestImpl deletebug Parameter id {}", id);
		return bugServiceImpl.deletebug(id);
	}

}
