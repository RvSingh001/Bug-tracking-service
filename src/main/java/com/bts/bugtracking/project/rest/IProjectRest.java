package com.bts.bugtracking.project.rest;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bts.bugtracking.bug.wrapper.BugDetailsWrapper;
import com.bts.bugtracking.project.wrapper.ProjectDetailsWrapper;
import com.bts.bugtracking.shared.OperationStatusModel;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@ResponseBody
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, path = "/api/projects")
@OpenAPIDefinition(tags = { @Tag(name = "Project Rest", description = "REST APIs related to Project") })
public interface IProjectRest {

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Add a Project")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Added the Project Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProjectDetailsWrapper.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid payload supplied", content = @Content) })
	public ProjectDetailsWrapper createProject(
			@Parameter(description = "Project Properties payload") @RequestBody ProjectDetailsWrapper projectDetailsWrapper);

	@GetMapping(path = "/{id}")
	@Operation(summary = "Get a Project by its id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found the Project", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ProjectDetailsWrapper.class)) }), })
	public ProjectDetailsWrapper getProject(
			@Parameter(description = "id of project to be searched") @PathVariable String id);

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Update a Project by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Updated the Project Sucessfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProjectDetailsWrapper.class)) }) })
	public ProjectDetailsWrapper updateProject(
			@Parameter(description = "id of project to be updated") @PathVariable String id,
			@Parameter(description = "Updated Project properties payload") @RequestBody ProjectDetailsWrapper projectDetailsWrapper);

	@GetMapping()
	@Operation(summary = "Get all Projects")
	public List<ProjectDetailsWrapper> getAllProject();

	@DeleteMapping(path = "/{id}")
	@Operation(summary = "Delete a Project by its id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Delete the Project", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ProjectDetailsWrapper.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Project not found", content = @Content) })
	public OperationStatusModel deleteProject(
			@Parameter(description = "id of project to be delete") @PathVariable String id);

	@GetMapping(path = "/{id}/bugs")
	@Operation(summary = "Get all bugs for provided project id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Delete the Project", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = List.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Bug not found", content = @Content) })
	public List<BugDetailsWrapper> getAllBugs(@Parameter(description = "id of project") @PathVariable String id);

}
