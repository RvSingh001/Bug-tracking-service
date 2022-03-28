package com.bugtracking.user;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bugtracking.user.shared.OperationStatusModel;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:4201", "" })
@ResponseBody
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, path = "/api/users")
@OpenAPIDefinition(tags = { @Tag(name = "User Rest", description = "REST APIs related to Project ") })
public interface IUserRest {

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Add a User")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Added the User Successfully", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserDetailsWrapper.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid payload supplied", content = @Content) })
	public UserResponseWrapper createUser(
			@Parameter(description = "User Properties payload") @RequestBody UserDetailsWrapper userDetailsWrapper);

	@GetMapping(path = "/{id}")
	@Operation(summary = "Get a User by its id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found the User", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserDetailsWrapper.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
	public UserResponseWrapper getUser(@Parameter(description = "id of user to be searched") @PathVariable String id);

	@PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "Update a User by its id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Updated the User Sucessfully", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserDetailsWrapper.class)) }) })
	public UserResponseWrapper updateUser(@Parameter(description = "id of user to be updated") @PathVariable String id,
			@Parameter(description = "Updated User properties payload") @RequestBody UserDetailsWrapper userDetailsWrapper);

	@GetMapping(path = "/role/{userRole}")
	@Operation(summary = "Get all Users")
	public List<UserResponseWrapper> getAllUser(@PathVariable String userRole);

	@DeleteMapping(path = "/{id}")
	@Operation(summary = "Delete a user by its id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Delete the User", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = UserDetailsWrapper.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "User not found", content = @Content) })
	public OperationStatusModel deleteUser(@Parameter(description = "id of user to be delete") @PathVariable String id);

	@GetMapping("/dev")
	public List<UserResponseWrapper> getAllDeveloper();

	@PutMapping("/{id}/active")
	public OperationStatusModel activateUser(@PathVariable String id);

}
