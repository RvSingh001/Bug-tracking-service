package com.bugtracking.bug;

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

import com.bugtracking.shared.OperationStatusModel;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@ResponseBody
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, path = "/api/bugs")
@OpenAPIDefinition(tags = { @Tag(name = "bug Rest", description = "REST APIs related to bug ") })
public interface IBugRest {

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Add a bug")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Added the bug Successfully", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = BugDetailsWrapper.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid payload supplied", content = @Content) })
	public BugDetailsWrapper createbug(
			@Parameter(description = "Bug Properties payload") @RequestBody BugDetailsWrapper projectDetailsWrapper);

	@GetMapping(path = "/{id}")
	@Operation(summary = "Get a bug by its id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found the bug", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = BugDetailsWrapper.class)) }), })
	public BugDetailsWrapper getbug(@Parameter(description = "id of bug to be searched") @PathVariable String id);

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Update a bug by its id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Updated the bug Sucessfully", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = BugDetailsWrapper.class)) }) })
	public BugDetailsWrapper updatebug(@Parameter(description = "id of bug to be updated") @PathVariable String id,
			@Parameter(description = "Updated bug properties payload") @RequestBody BugDetailsWrapper projectDetailsWrapper);

	@GetMapping()
	@Operation(summary = "Get all bugs")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Get all Bug", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = List.class)) }), })
	public List<BugDetailsWrapper> getAllBug();

	@DeleteMapping(path = "/{id}")
	@Operation(summary = "Delete a bug by its id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Delete the Bug", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = BugDetailsWrapper.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "bug not found", content = @Content) })
	public OperationStatusModel deletebug(@Parameter(description = "id of bug to be delete") @PathVariable String id);

}
