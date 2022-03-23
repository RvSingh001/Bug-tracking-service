//package com.bts.bugtracking.bug.service.impl;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.fail;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.bts.bugtracking.bug.model.Bug;
//import com.bts.bugtracking.bug.service.IBugService;
//import com.bts.bugtracking.bug.wrapper.BugDetailsWrapper;
//import com.bts.bugtracking.project.model.Project;
//import com.bts.bugtracking.user.model.User;
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//class BugServiceImplTest {
//
//	private static final String bugId = "NmodQfzlzbZCeJp";
//	private static final Long projectId = 8l;
//	private static final Long userId = 11l;
//	private static BugDetailsWrapper testBug;
//
//	@Autowired
//	private IBugService iBugService;
//
//	@Autowired
//	ModelMapper mapper;
//
//	@BeforeEach
//	public void setUp() {
//		testBug = createBug();
//	}
//
//	@AfterEach
//	public void tearDown() {
//		deleteBug();
//	}
//
//	@Test
//	void testGetbug() {
//		BugDetailsWrapper bug = this.iBugService.getbug(bugId);
//		assertThat(bug.getBugId()).isEqualTo(bugId);
//	}
//
//	@Test
//	@Disabled
//	void testCreatebug() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testUpdatebug() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testGetAllBug() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testDeletebug() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	@Disabled
//	void testGetAllBugByProject() {
//		fail("Not yet implemented");
//	}
//
//	private BugDetailsWrapper createBug() {
//		Bug bug = new Bug();
//		Project project = new Project(projectId);
//		User user = new User(userId);
//		bug.setBugId(bugId);
//		bug.setProject(project);
//		bug.setUser(user);
//
//		return this.iBugService.createbug(mapper.map(bug, BugDetailsWrapper.class));
//	}
//
//	private void deleteBug() {
//		this.iBugService.deletebug(bugId);
//	}
//
//}
