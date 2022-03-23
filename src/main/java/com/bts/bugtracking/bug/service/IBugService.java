package com.bts.bugtracking.bug.service;

import java.util.List;

import com.bts.bugtracking.bug.model.Bug;
import com.bts.bugtracking.bug.wrapper.BugDetailsWrapper;
import com.bts.bugtracking.project.model.Project;
import com.bts.bugtracking.shared.OperationStatusModel;

public interface IBugService {
	public BugDetailsWrapper getbug(String id);

	public BugDetailsWrapper createbug(BugDetailsWrapper projectDetailsWrapper);

	public BugDetailsWrapper updatebug(String id, BugDetailsWrapper projectDetailsWrapper);

	public List<BugDetailsWrapper> getAllBug();

	public OperationStatusModel deletebug(String id);

	public List<BugDetailsWrapper> getAllBugByProject(Project existingProject);

}
