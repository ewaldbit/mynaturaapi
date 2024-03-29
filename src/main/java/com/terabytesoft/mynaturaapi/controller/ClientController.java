package com.terabytesoft.mynaturaapi.controller;

import com.terabytesoft.mynaturaapi.dto.request.ClientDTO;
import com.terabytesoft.mynaturaapi.dto.MessageResponseDTO;
import com.terabytesoft.mynaturaapi.exception.ClientNotFoundException;
import com.terabytesoft.mynaturaapi.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {

    private ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createClient(@RequestBody @Valid ClientDTO clientDTO){
        return clientService.createClient(clientDTO);
    }

    @GetMapping
    public List<ClientDTO> listAll() {
        return clientService.listAll();
    }

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id) throws ClientNotFoundException {
        return clientService.findById(id);
    };

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws ClientNotFoundException {
        clientService.deleteById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody ClientDTO clientDTO) throws ClientNotFoundException {
        return clientService.updateById(id, clientDTO);
    }

}
