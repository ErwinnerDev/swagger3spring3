package com.swaggerthree.config.swagger3.application.resources;


import com.swaggerthree.config.swagger3.model.ExampleResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Api("Estos son endpont de ejemplos")
@RequestMapping("/api/usuario")
public interface Exampleresource {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK",          content = @Content(schema = @Schema(implementation = ExampleResponse.class))),
            @ApiResponse(responseCode = "500", description = "Bad request", content = @Content(schema = @Schema(implementation = ExampleResponse.class)))
    })
    @ResponseStatus(HttpStatus.NOT_FOUND) //404

    @GetMapping(value = "/{name}")
    @Operation(summary = "Saludar a un usuario", description = "Esto es una nota") //@ApiOperation(value = "Saludar a un usuario", notes = "Esto es una nota")
    @ExceptionHandler(NullPointerException.class)
    ResponseEntity<ExampleResponse> saludar(
            //@ApiParam(name = "name", value = "Puede ir cualquier valor", example = "Example: Erwin, chene, Evelin, Ojilver" )
            @PathVariable(name = "name") String name);
}
